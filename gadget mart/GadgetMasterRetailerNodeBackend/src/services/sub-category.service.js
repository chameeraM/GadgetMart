const SubCategory = require('../models/sub-category.modal')
const {GeneralError} = require('../utils/errors')
const logger = require('../config/logger/logger')

const findById = async (id) => {
    try {
        const subCategory = await SubCategory.findById(id)
        return subCategory
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const add = async (subCategory) => {
    try {

        const newSubCategory = new SubCategory({...subCategory})
        subCategory = await newSubCategory.save()
        return subCategory

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const update = async (subCategory, id) => {
    try {
        const existingSubCategory = await SubCategory.findById(id)

        existingSubCategory.name = subCategory.name
        existingSubCategory.category = subCategory.category

        subCategory = await existingSubCategory.save()
        return subCategory

    } catch (error) {
        logger.error(error)
        throw new Error(error)
    }
}

const remove = async (id) => {
    try {
        const subCategory = await SubCategory.findByIdAndDelete(id)
        return subCategory
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const getAll = async () => {
    try {
        const subCategories = await SubCategory.find()
        return subCategories
    } catch (error) {
        logger.error(error)
        throw new GeneralError('Something Went Wrong..')
    }
}

const findByCategory = async (id) => {
    try {
        const subCategory = await SubCategory.find({category: id})
        return subCategory
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
    findByCategory,
}
