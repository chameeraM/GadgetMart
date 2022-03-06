const mongoose = require("mongoose");

const brandSchema = new mongoose.Schema(
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

brandSchema.methods.toJSON = function () {
    const task = this;
    const taskObject = task.toObject();
    taskObject.id = taskObject._id;

    delete taskObject._id;

    return taskObject;
};

const Brand = mongoose.model("Brand", brandSchema);

module.exports = Brand;
