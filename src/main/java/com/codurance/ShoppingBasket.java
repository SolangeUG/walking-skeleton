package com.codurance;

import spark.Spark;

class ShoppingBasket {

    void startOn(int port) {
        Spark.port(port);
        new Routes().create();
    }
}
