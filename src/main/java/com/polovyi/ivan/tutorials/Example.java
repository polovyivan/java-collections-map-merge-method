package com.polovyi.ivan.tutorials;

import java.util.Map;
import java.util.TreeMap;

public class Example {

    public static void main(String[] args) {
        Map<String, Integer> rewardPoints = new TreeMap<>();
        rewardPoints.put("Customer1", 100);
        rewardPoints.put("Customer2", 200);
        rewardPoints.put("Customer3", null); // customer left reward program
        System.out.println("initial reward points = " + rewardPoints);
        // {Customer1=100, Customer2=200, Customer3=null}

        // Customer1 got bonus because he got the largest number of points
        Integer rewardPointsWithBonus = rewardPoints.merge("Customer2", 2, (oldValue, newValue) -> oldValue * newValue);
        System.out.println("rewardPointsWithBonus = " + rewardPointsWithBonus);
        // rewardPointsWithBonus = 400
        System.out.println("reward points after bonus= " + rewardPoints);
        // {Customer1=100, Customer2=400, Customer3=null}

        // Add a new customer to a reward program
        Integer newCustomerValue = rewardPoints.merge("Customer4", 0, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("newCustomerValue = " + newCustomerValue);
        // newCustomerValue = 100
        System.out.println("reward points after adding new customer = " + rewardPoints);
        // {Customer1=100, Customer2=400, Customer3=null, Customer4=0}

        // Remove customer from reward program, although he earned some points in the last month
        Integer inactiveCustomer = rewardPoints.merge("Customer3", 100, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("inactiveCustomer = " + inactiveCustomer);
        // inactiveCustomer = 100
        System.out.println("reward points after removing customer = " + rewardPoints);
        // {Customer1=100, Customer2=400, Customer3=100, Customer4=0}

        Map<String, Integer> cashBackPoints = new TreeMap<>();
        cashBackPoints.put("Customer1", 150);
        cashBackPoints.put("Customer2", 75);
        cashBackPoints.put("Customer4", 300);

        cashBackPoints.forEach((item, qty) -> rewardPoints.merge(item, qty,
                (oldValue, newValue) -> oldValue + newValue));
        System.out.println("Total reward points after merging cashback points = " + rewardPoints);
        // {Customer1=250, Customer2=475, Customer3=100, Customer4=300}
    }
}
