package com.polovyi.ivan.tutorials;

import java.util.HashMap;
import java.util.Map;

public class MergeMethod {

    public static void main(String[] args) {
      //  addNewValue();
      //  removeValue();
        calculateValueValue();
    }

    private static void addNewValue() {
        System.out.println("AddNewValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String returnedValue = map.merge(3, "C",
                (value, newValue) -> "Some value");
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = C
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B, 3=C}
    }

    private static void removeValue() {
        System.out.println("RemoveValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String returnedValue = map.merge(2, "New Value",
                (value, newValue) -> null);
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = null
        System.out.println("map after = " + map);
        // map after = {1=A}
    }

    private static void calculateValueValue() {
        System.out.println("CalculateValue:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("map before = " + map);
        // map before = {1=A, 2=B}
        String returnedValue = map.merge(2, "New Value",
                (value, newValue) -> value + "+" + newValue);
        System.out.println("returnedValue = " + returnedValue);
        // returnedValue = B+New Value
        System.out.println("map after = " + map);
        // map after = {1=A, 2=B+New Value}
    }


}
