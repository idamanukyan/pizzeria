package com.company.model;

import com.company.util.GenerateRandom;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Order {

    private int id;
    private int customerNumber;
    private List<Pizza> pizzas;
    private LocalTime orderTime;
    private int quantity;
    private double price;

    private GenerateRandom generateRandom;

    public Order() {
    }

    public Order(int id, int customerNumber, List<Pizza> pizzas, LocalTime orderTime, int quantity, double price) {
        this.id = generateRandom.generateRandom();
        this.customerNumber = customerNumber;
        this.pizzas = pizzas;
        this.orderTime = orderTime;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        Order order = (Order) o;
        return id == order.id && customerNumber == order.customerNumber && quantity == order.quantity && price == order.price && Objects.equals(pizzas, order.pizzas) && Objects.equals(orderTime, order.orderTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerNumber, pizzas, orderTime, quantity, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerNumber=" + customerNumber +
                ", pizzas=" + pizzas +
                ", orderTime=" + orderTime +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
