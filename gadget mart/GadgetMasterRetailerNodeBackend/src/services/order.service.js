const Order = require('../models/order.modal')
const OrderDetails = require('../models/order-details.model')
const {GeneralError} = require('../utils/errors')
const logger = require('../config/logger/logger')
const ItemService = require('../services/item.service')
var ObjectId = require('mongodb').ObjectID;
var dateFormat = require("dateformat");

const findById = async (id) => {
    try {
        const order = await Order.findById(id)
        const orderDetails = await OrderDetails.find({order: ObjectId(id)})
        return {order, orderDetails}
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const add = async (order) => {
    const orderDTO = getOrderDTO(order)
    try {

        let errorOccurred = false
        var now = new Date().toLocaleString();
    
        let newOrder = new Order({
            customer: orderDTO.customer,
            contact: orderDTO.contact,
            fullAmount: orderDTO.fullAmount,
            orderAddress: orderDTO.orderAddress,
            date: now
        })
        order = await newOrder.save()

        const details = orderDTO.orderDetails
        const detailsIds = []

        for (let i = 0; i < details.length; i++) {
            const detail = details[i]
            const qty = detail.qty
            let itemData = await ItemService.findById(detail.item)
            if (itemData != null && itemData.qty >= qty) {
                const price = itemData.price * qty

                const remainingQty = itemData.qty - qty

                itemData.qty = remainingQty

                await itemData.save()

                let newOrderDetails = new OrderDetails({
                    item: detail.item,
                    qty: qty,
                    price: price,
                    order: order.id
                })
                newOrderDetails = await newOrderDetails.save()
                detailsIds.push(newOrderDetails.id)
            } else {
                errorOccurred = true
                break
            }
        }

        if (errorOccurred) {
            if (detailsIds.length > 0) {
                for (let i = 0; i < detailsIds.length; i++) {
                    await OrderDetails.findByIdAndDelete(detailsIds[i])
                }
            }
            await Order.findByIdAndDelete(order.id)
            return null
        }

        return {order, detailsIds}

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

function getOrderDTO(order) {
    return {
        customer: order.customer,
        contact: order.contact,
        fullAmount: order.fullAmount,
        orderAddress: order.orderAddress,
        orderDetails: order.orderDetailsModels,
    }
}

module.exports = {
    add,
    findById,
}
