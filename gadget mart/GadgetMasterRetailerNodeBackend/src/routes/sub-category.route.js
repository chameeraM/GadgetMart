const express = require("express");
const router = express.Router();
const subCategoryRouter = require("../controllers/sub-category.controller");

router.post("/add", subCategoryRouter.add);
router.put("/update/:id", subCategoryRouter.update);
router.get("/get/:id", subCategoryRouter.get);
router.get("/get_all", subCategoryRouter.getAll);
router.delete("/remove/:id", subCategoryRouter.remove);
router.get("/category/:id", subCategoryRouter.findByCategory);

module.exports = router;
