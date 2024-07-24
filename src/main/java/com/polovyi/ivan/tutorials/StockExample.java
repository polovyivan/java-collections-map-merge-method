package com.polovyi.ivan.tutorials;

import java.util.HashMap;
import java.util.Map;

public class StockExample {

    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("mouse", 5);
        stock.put("headset", 2);
        stock.put("charger", 12);

        Map<String, Integer> newDelivery = new HashMap<>();
        newDelivery.put("mouse", 2);
        newDelivery.put("headset", 3);
        newDelivery.put("pc", 1);

        newDelivery.forEach((item, qty) -> stock.merge(item, qty,
                (oldValue, newValue) -> oldValue + newValue));

        System.out.println("stock = " + stock);
    }
}
