package com.jose.cordoba.formacion.unitTesting.session2.service;

import java.util.List;

public interface ShoppingCart {

    void addItem(String item);
    void removeItem(String item);
    int getTotalItems();
    List<String> getItems();

}
