package com.company;

import com.company.enums.PizzaType;
import com.company.model.Ingredient;
import com.company.model.Order;
import com.company.model.Pizza;
import com.company.storage.OrderStorage;
import com.company.storage.PizzaStorage;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final OrderStorage orderStorage = null;
    public static final PizzaStorage pizzaStorage = null;
    public static double price = 1;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Order order = new Order();
        List<Pizza> pizzas = new ArrayList<>();
        Pizza pizza = new Pizza();
        Ingredient ingredient = new Ingredient();
        List<Ingredient> ingredientList = new ArrayList<>();

        System.out.println("Hello dear customer, please tell me your number.");
        int customerNumber = scanner.nextInt();
        order.setCustomerNumber(customerNumber);

        System.out.println("How many pizzas do you want to order?");
        int pizzaNumber = scanner.nextInt();

        for (int i = 0; i < pizzaNumber; i++) {

            System.out.println("Which pizza type do you prefer?" +
                    "only regular base or closed");
            String pizzaType = scanner.nextLine();
            if (pizzaType.equalsIgnoreCase(String.valueOf(PizzaType.CLOSED))) {
                price = price + 0.5;
            }
            pizza.setType(PizzaType.valueOf(pizzaType));

            System.out.println("Please give a name to your pizza.");
            String pizzaName = scanner.nextLine();

            if (pizzaName.equalsIgnoreCase("Margarita")) {
                ingredient.setName("TOMATO_PASTE");
                ingredient.setPrice(1);
                ingredientList.add(ingredient);
                ingredient.setName("CHEESE");
                ingredient.setPrice(1);
                ingredientList.add(ingredient);
                ingredient.setName("SALAMI");
                ingredient.setPrice(1.5);
                ingredientList.add(ingredient);
                ingredient.setName("OLIVES");
                ingredient.setPrice(0.5);
                ingredientList.add(ingredient);
                pizza.setName("Margarita");
                pizza.setIngredients(ingredientList);
                pizza.setPrice(price + 1 + 1 + 1.5 + 0.5);
            } else if (pizzaName.length() >= 4 && pizzaName.length() <= 20) {
                pizza.setName(pizzaName);
            } else {
                System.out.println("Please tell me your name.");
                String customerName = scanner.nextLine();
                pizza.setName("customer_" + customerName + pizza.getId());
            }

            if (!pizza.getName().equals("Margarita")) {
                System.out.println("How many ingredients do you want to add?");
                int ingNum = scanner.nextInt();

                if (ingNum <= 7) {
                    System.out.println("Tell the ingredients");
                    for (int j = 0; j <= ingNum; j++) {
                        double ingredientPrice = 1;
                        String ingredientName = scanner.nextLine();
                        if (!ingredientList.contains(ingredientName)) {
                            switch (ingredientName) {
                                case "TOMATO_PASTE", "CHEESE" -> price = price + ingredientPrice;
                                case "SALAMI" -> {
                                    ingredientPrice = 1.5;
                                    price = price + ingredientPrice;
                                }
                                case "BACON" -> {
                                    ingredientPrice = 1.2;
                                    price = price + ingredientPrice;
                                }
                                case "GARLIC" -> {
                                    ingredientPrice = 0.3;
                                    price = price + ingredientPrice;
                                }
                                case "CORN" -> {
                                    ingredientPrice = 0.7;
                                    price = price + ingredientPrice;
                                }
                                case "PEPPERONI" -> {
                                    ingredientPrice = 0.6;
                                    price = price + ingredientPrice;
                                }
                                case "OLIVES" -> {
                                    ingredientPrice = 0.5;
                                    price = price + ingredientPrice;
                                }
                                default -> {
                                    return;
                                }
                            }
                            ingredient.setName(ingredientName);
                            ingredient.setPrice(ingredientPrice);
                            ingredientList.add(ingredient);
                        } else {
                            System.out.println("Duplicate ingredients are not allowed.");
                        }
                    }
                    pizza.setIngredients(ingredientList);
                    pizza.setPrice(price);
                    pizzaStorage.save(pizza);
                } else {
                    System.out.println("Pizza can have 7 ingredients.");
                }
            }
        }

        order.setQuantity(pizzaNumber);
        order.setPizzas(pizzas);
        order.setOrderTime(LocalTime.now());
        order.setPrice(price);
        orderStorage.save(order);

    }

    public void printCheck(int id) {
        Order order = orderStorage.findById(id);
        System.out.println("***************" + "\n"
                + "Order: " + order.getId() + "\n"
                + "Client: " + order.getCustomerNumber()
        );
        for (int i = 0; i < order.getPizzas().size(); i++) {
            System.out.println("Name: " + order.getPizzas().get(i).getName() + "\n"
                    + "--------------------------------" + "\n"
                    + "Pizza Base" + order.getPizzas().get(i).getType() + "\n"
            );
            for (int j = 0; j < order.getPizzas().get(i).getIngredients().size(); j++) {
                System.out.println(order.getPizzas().get(i).getIngredients().get(i).getName() + ": "
                        + order.getPizzas().get(i).getIngredients().get(i).getPrice());
            }
        }
        System.out.println("--------------------------------" + "\n"
                + "Amount: " + order.getPrice() + "\n"
                + "Quantity" + order.getQuantity()

        );
    }


}
