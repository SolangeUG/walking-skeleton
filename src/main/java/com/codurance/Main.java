package com.codurance;

public class Main {

    public static void main(String[] args) {
        new ShoppingBasket().startOn(getPortFromEnvironment());
    }

    private static int getPortFromEnvironment() {
        String port = System.getenv("PORT");
        if (port != null)
            return Integer.parseInt(port);
        return 4567;
    }
}