const mongoose = require("mongoose");

const subCategorySchema = new mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            trim: true,
        },
        category: {
            type: mongoose.Schema.Types.ObjectId,
            ref: "Category",
        },
    },
    {
        timestamps: true,
    }
);

subCategorySchema.methods.toJSON = function () {
    const task = this;
    const taskObject = task.toObject();
    taskObject.id = taskObject._id;

    delete taskObject._id;

    return taskObject;
};

const SubCategory = mongoose.model("SubCategory", subCategorySchema);

module.exports = SubCategory;
