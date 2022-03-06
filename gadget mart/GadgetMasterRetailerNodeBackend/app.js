const express = require("express");
const path = require("path");
const cookieParser = require("cookie-parser");
const logger = require("morgan");
const dbConnection = require("./src/config/database/mongoose");
const errorHandle = require("./src/middleware/errorHandler");

const indexRouter = require("./src/routes/index");

const app = express();
// db connectivity
dbConnection();

app.use(logger("dev"));
app.use(express.json());

// request payload middleware
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());

app.use(express.static(path.join(__dirname, "public")));

app.use("/api", indexRouter);

// error handling middleware
app.use(errorHandle);

module.exports = app;
