const mongoose = require("mongoose");

const itemSchema = new mongoose.Schema(
    {
        name: {
            type: String,
            required: true,
            trim: true,
        },
        price: {
            type: Number,
            required: true,
        },
        discount: {
            type: Number,
            required: false,
        },
        warranty: {
            type: Number,
            required: false,
        },
        qty: {
            type: Number,
            required: true,
        },
        imageUrl: {
            type: String,
            required: true,
            trim: true,
        },
        itemtype: {
            type: String,
            required: true,
            trim: true,
        },
        longdes: {
            type: String,
            required: true,
            trim: true,
        },
        shortdes: {
            type: String,
            required: true,
            trim: true,
        },
        brand: {
            type: mongoose.Schema.Types.ObjectId,
            ref: "Brand",
        },
        subCategory: {
            type: mongoose.Schema.Types.ObjectId,
            ref: "SubCategory",
        },
    },
    {
        timestamps: true,
    }
);

itemSchema.methods.toJSON = function () {
    const task = this;
    const taskObject = task.toObject();
    taskObject.id = taskObject._id;

    delete taskObject._id;

    return taskObject;
};

const Item = mongoose.model("Item", itemSchema);

module.exports = Item;
