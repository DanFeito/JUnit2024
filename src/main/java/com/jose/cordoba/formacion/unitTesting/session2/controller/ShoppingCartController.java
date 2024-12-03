package com.jose.cordoba.formacion.unitTesting.session2.controller;

import com.jose.cordoba.formacion.unitTesting.session2.service.ShoppingCart;
import com.jose.cordoba.formacion.unitTesting.session2.service.ShoppingCartImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {
    private final ShoppingCart shoppingCart = new ShoppingCartImpl();

    // Endpoint: Add an item to the cart
    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestParam String item) {
        try {
            shoppingCart.addItem(item);
            return ResponseEntity.ok("Item added successfully: " + item);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint: Remove an item from the cart
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeItem(@RequestParam String item) {
        try {
            shoppingCart.removeItem(item);
            return ResponseEntity.ok("Item removed successfully: " + item);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint: Get all items in the cart
    @GetMapping("/items")
    public ResponseEntity<List<String>> getItems() {
        return ResponseEntity.ok(shoppingCart.getItems());
    }

    // Endpoint: Get the total number of items in the cart
    @GetMapping("/count")
    public ResponseEntity<Integer> getItemCount() {
        return ResponseEntity.ok(shoppingCart.getTotalItems());
    }

    // Endpoint: Clear all items from the cart
    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart() {
        shoppingCart.getItems().clear();
        return ResponseEntity.ok("Cart cleared successfully.");
    }
}
