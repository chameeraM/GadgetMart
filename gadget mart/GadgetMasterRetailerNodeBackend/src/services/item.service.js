const Item = require('../models/item.modal')
const {GeneralError} = require('../utils/errors')
const logger = require('../config/logger/logger')

const findById = async (id) => {
    try {
        const item = await Item.findById(id)
        return item
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const add = async (item) => {
    try {

        const newItem = new Item({...item})
        item = await newItem.save()
        return item

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const update = async (item, id) => {
    try {
        const existingItem = await Item.findById(id)

        existingItem.name = item.name
        existingItem.price = item.price
        existingItem.discount = item.discount
        existingItem.warranty = item.warranty
        existingItem.qty = item.qty
        existingItem.imageUrl = item.imageUrl
        existingItem.itemtype = item.itemtype
        existingItem.longdes = item.longdes
        existingItem.shortdes = item.shortdes
        existingItem.brand = item.brand
        existingItem.subCategory = item.subCategory

        item = await existingItem.save()
        return item

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const remove = async (id) => {
    try {
        const item = await Item.findByIdAndDelete(id)
        return item
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const getAll = async () => {
    try {
        const items = await Item.find()
        return items
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const findByBrand = async (id) => {
    try {
        const items = await Item.find({brand: id})
        return items
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const findBySubCategory = async (id) => {
    try {
        const items = await Item.find({subCategory: id})
        return items
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

module.exports = {
    add,
    findById,
    getAll,
    remove,
    update,
    findByBrand,
    findBySubCategory
}
