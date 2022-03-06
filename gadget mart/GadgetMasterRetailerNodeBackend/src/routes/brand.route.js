const express = require("express");
const router = express.Router();
const brandController = require("../controllers/brand.controller");

router.post("/add", brandController.add);
router.put("/update/:id", brandController.update);
router.get("/get/:id", brandController.get);
router.get("/get_all", brandController.getAll);
router.delete("/remove/:id", brandController.remove);

module.exports = router;
