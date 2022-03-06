const mongoose = require("mongoose");

const categorySchema = new mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            trim: true,
        },
    },
    {
        timestamps: true,
    }
);

categorySchema.methods.toJSON = function () {
    const task = this;
    const taskObject = task.toObject();
    taskObject.id = taskObject._id;

    delete taskObject._id;

    return taskObject;
};

const Category = mongoose.model("Category", categorySchema);

module.exports = Category;
