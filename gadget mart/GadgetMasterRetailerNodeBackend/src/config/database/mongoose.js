const logger = require('../logger/logger')
const mongoose = require('mongoose')
mongoose.Promise = require('bluebird')

const dbURL ="mongodb+srv://chameera:Test@123456@gadgetmart.fsjg9.mongodb.net/gadgetmartdb?retryWrites=true&w=majority";

// refere this link for more details - https://mongoosejs.com/docs/connections.html
module.exports = async () => {
    try {
        await mongoose.connect(dbURL, {
            useUnifiedTopology: true,
            useNewUrlParser: true,
            useCreateIndex: true,
            useFindAndModify: false,
            ssl: true,
            sslValidate: true,
        })
        logger.info('Database Connected');
    } catch (error) {
        logger.error('Database Connectivity Error', error);
        throw new Error(error);
    }
}
