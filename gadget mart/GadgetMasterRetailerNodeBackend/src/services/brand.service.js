const Brand = require('../models/brand.modal')
const {GeneralError} = require('../utils/errors')
const logger = require('../config/logger/logger')

const findById = async (id) => {
    try {
        const brand = await Brand.findById(id)
        return brand
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const add = async (brand) => {
    try {

        const newBrand = new Brand({...brand})
        brand = await newBrand.save()
        return brand

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const update = async (brand, id) => {
    try {
        const existingBrand = await Brand.findById(id)

        existingBrand.name = brand.name

        brand = await existingBrand.save()
        return brand

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const remove = async (id) => {
    try {
        const brand = await Brand.findByIdAndDelete(id)
        return brand
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const getAll = async () => {
    try {
        const brands = await Brand.find()
        return brands
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
    update
}
