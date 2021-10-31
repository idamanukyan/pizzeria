package com.company.model;

import com.company.enums.PizzaType;
import com.company.util.GenerateRandom;

import java.util.List;
import java.util.Objects;

public class Pizza {

    private int id;
    private PizzaType type;
    private String name;
    private List<Ingredient> ingredients;
    private double price;

    private GenerateRandom generateRandom;

    public Pizza() {
    }

    public Pizza(int id, PizzaType type, String name, List<Ingredient> ingredients, double price) {
        this.id = generateRandom.generateRandom();
        this.type = type;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id && Double.compare(pizza.price, price) == 0 && type == pizza.type && Objects.equals(name, pizza.name) && Objects.equals(ingredients, pizza.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, ingredients, price);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + price +
                '}';
    }
}
