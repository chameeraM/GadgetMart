const mongoose = require("mongoose");

const orderSchema = new mongoose.Schema(
    {
        customer: {
            type: String,
            required: true,
        },
        contact: {
            type: String,
            required: true,
        },
        date: {
            type: String,
            required: true,
        },
        fullAmount: {
            type: Number,
            required: true,
        },
        orderAddress: {
            type: String,
            required: true,
        },
    },
    {
        timestamps: true,
    }
);

orderSchema.methods.toJSON = function () {
    const task = this;
    const taskObject = task.toObject();
    taskObject.id = taskObject._id;

    delete taskObject._id;

    return taskObject;
};

const Order = mongoose.model("Order", orderSchema);

module.exports = Order;
