package com.jose.cordoba.formacion.unitTesting.session2.service;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    private final List<String> items = new ArrayList<>();
    @Override
    public void addItem(String item) {
        if (item == null || item.isEmpty()) {
            throw new IllegalArgumentException("Item cannot be null or empty");
        }
        items.add(item);
    }

    @Override
    public void removeItem(String item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException("Item not found in cart");
        }
        items.remove(item);
    }

    @Override
    public int getTotalItems() {
        return items.size();
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);
    }
}
