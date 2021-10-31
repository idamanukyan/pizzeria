package com.company.storage;

import com.company.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaStorage {

    private static List<Pizza> pizzas = new ArrayList<>();

    public void save(Pizza pizza) {
        pizzas.add(pizza);
    }


}
