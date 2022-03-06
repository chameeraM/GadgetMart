const express = require("express");
const router = express.Router();
const categoryController = require("../controllers/category.controller");

router.post("/add", categoryController.add);
router.put("/update/:id", categoryController.update);
router.get("/get/:id", categoryController.get);
router.get("/get_all", categoryController.getAll);
router.delete("/remove/:id", categoryController.remove);

module.exports = router;
