const express = require("express");
const router = express.Router();
const itemController = require("../controllers/item.controller");

router.post("/add", itemController.add);
router.put("/update/:id", itemController.update);
router.get("/get/:id", itemController.get);
router.get("/get_all", itemController.getAll);
router.delete("/remove/:id", itemController.remove);
router.get("/brand/:id", itemController.findByBrand);
router.get("/subCategory/:id", itemController.findBySubCategory);

module.exports = router;
