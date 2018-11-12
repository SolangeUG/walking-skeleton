package com.codurance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.get;

class Routes {
    private final String pageWithButton ="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Hello from button</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <form action=\"/product\" method=\"get\">\n" +
            "        <input type=\"submit\"/>\n" +
            "    </form>\n" +
            "</body>\n" +
            "</html>";

    void create() {
        get("/hello", (req, res) -> "Hello World");
        get("/bye", (req, res) -> "Goodbye World");
        get("/", (req,res) -> pageWithButton);
        get("/product", (req, res) -> {
            res.type("application/json");
            return parseFile();
        });
    }

    private String parseFile() {

        final String pathToJsonFile = "persistence/hello.json";
        Path filePath =  Paths.get(pathToJsonFile);

        try {
            return Files.readAllLines(filePath).stream().reduce("", (s, s2) -> s += s2);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
