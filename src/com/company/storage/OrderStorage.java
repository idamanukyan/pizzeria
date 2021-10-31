package com.company.storage;

import com.company.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {

    private static List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public Order findById(int id) {
        for (Order order :
                orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }


}
