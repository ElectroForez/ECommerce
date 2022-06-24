package com.yadren.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public static List<Integer> items = new ArrayList<>();

    public static List<Integer> getItems() {
        return items;
    }

    public static void setItems(List<Integer> items) {
        Order.items = items;
    }
}
