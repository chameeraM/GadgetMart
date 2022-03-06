const logger = require("../config/logger/logger");
const orderService = require('../services/order.service')
const {BadRequest} = require('../utils/errors')
const Constants = require('../constants/constants')
const httpStatus = require('http-status')

const add = async (req, res, next) => {
    try {

        const body = req.body
        const data = await orderService.add(body)

        if (data != null) {
            let response = {
                message: Constants.customMessage.SUCCESSFUL,
                data,
            }
            res.status(httpStatus.OK).send(response)
        } else {
            throw new BadRequest('Something Went Wrong')
        }
    } catch (error) {
        logger.error(error)
        next(error)
    }
}

const get = async (req, res, next) => {
    try {
        let id = req.param('id');
        let data = await orderService.findById(id)

        if (data != null) {
            let response = {
                message: Constants.customMessage.SUCCESSFUL,
                data,
            }
            res.status(httpStatus.OK).send(response)
        } else {
            throw new BadRequest('Cannot Find Brand.')
        }

    } catch (error) {
        logger.error(error)
        next(error)
    }
}


module.exports = {
    add,
    get
}
