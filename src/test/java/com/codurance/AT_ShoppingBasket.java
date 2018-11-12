package com.codurance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;

import static io.restassured.RestAssured.when;
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

    @AfterClass
    public static void tearDown() {
        Spark.stop();
    }
}