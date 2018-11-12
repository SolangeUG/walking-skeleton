package com.codurance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class AT_ShoppingBasket {

    @BeforeClass
    public static void setUp() {
        new ShoppingBasket().startOn(8080);
        Spark.awaitInitialization();
    }

    @Test
    public void mini_service_returns_200_with_hello_world_as_content() {
        when()
            .get("/hello").
        then()
            .statusCode(200)
            .contentType("text/html")
            .assertThat().body(equalTo("Hello World"));
    }

    @Test
    public void mini_service_returns_200_with_goodbye_world_as_content() {
        when()
            .get("/bye").
        then()
            .statusCode(200)
            .contentType("text/html")
            .assertThat().body(equalTo("Goodbye World"));
    }

    @Test
    public void return_homepage_with_a_button() {
        String expectedFormWithButton=
                "<!DOCTYPE html>\n" +
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

        when()
                .get("/").
        then()
                .statusCode(200)
                .contentType("text/html")
                .assertThat().body(equalTo(expectedFormWithButton));
    }

    @AfterClass
    public static void tearDown() {
        Spark.stop();
    }
}