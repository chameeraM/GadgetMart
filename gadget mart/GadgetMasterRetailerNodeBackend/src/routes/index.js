const express = require('express');
const router = express.Router();
const categoryRouter = require('./category.route')
const brandRouter = require('./brand.route')
const subCategoryRouter = require('./sub-category.route')
const itemRouter = require('./item.route')
const orderRouter = require('./order.route')

/* GET APP Details. */
router.get('/', function (req, res, next) {
    let response = {
        app_name: 'GadgetMart Node Backend',
        developers: [{
            name: 'Chameera Madusanka',
        }],
    }
    res.status(200).send(response);
});

router.get('/status', (req, res) => {
    res.send({status: 'OK'})
}) // api status
router.get('/health', (req, res) => {
    res.send({status: 'OK'})
}) // api status

router.use('/category', categoryRouter); // task routes.
router.use('/brand', brandRouter); // brand routes.
router.use('/subCategory', subCategoryRouter); // sub category routes.
router.use('/item', itemRouter); // item routes.
router.use('/order', orderRouter); // order routes.

module.exports = router;
