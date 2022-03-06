const Category = require('../models/category.modal')
const {GeneralError} = require('../utils/errors')
const logger = require('../config/logger/logger')

const findById = async (id) => {
    try {
        const category = await Category.findById(id)
        return category
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const add = async (category) => {
    try {

        const newCategory = new Category({...category})
        category = await newCategory.save()
        return category

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const update = async (category, id) => {
    try {
        const existingCategory = await Category.findById(id)

        existingCategory.name = category.name

        category = await existingCategory.save()
        return category

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const remove = async (id) => {
    try {
        const category = await Category.findByIdAndDelete(id)
        return category
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const getAll = async () => {
    try {
        const categories = await Category.find()
        return categories
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
