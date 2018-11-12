package com.codurance;

import static spark.Spark.get;
import static spark.Spark.post;

class Routes {
    private final String pageWithButton ="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Hello from button</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <form action=\"/\">\n" +
            "        <input type=\"submit\"/>\n" +
            "    </form>\n" +
            "</body>\n" +
            "</html>";

    void create() {
        get("/hello", (req, res) -> "Hello World");
        get("/bye", (req, res) -> "Goodbye World");
        get("/", (req,res) -> pageWithButton);
    }
}
