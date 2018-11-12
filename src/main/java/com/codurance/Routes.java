package com.codurance;

import static spark.Spark.get;

class Routes {

    void create() {
        get("/hello", (req, res) -> "Hello World");
        get("/bye", (req, res) -> "Goodbye World");
    }
}
