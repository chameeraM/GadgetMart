const express = require("express");
const router = express.Router();
const orderController = require("../controllers/order.controller");

router.post("/add", orderController.add);
router.get("/get/:id", orderController.get);

module.exports = router;
