package com.jose.cordoba.formacion.unitTesting.session2.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartImplTest {

    private static ShoppingCart sharedCart;

    @BeforeAll
    static void setUpForAll() {
        sharedCart = new ShoppingCartImpl();
        System.out.println("Inicializado el carro");
    }

    @BeforeEach
    void setUp() {
        sharedCart.addItem("platanos");
        sharedCart.addItem("manzanas");
        sharedCart.addItem("peras");
        System.out.println("Objetos en el carro: " + sharedCart.getItems());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Vaciando el Carro");
        sharedCart = new ShoppingCartImpl();
        System.out.println("Numero de objetos en el carro: " + sharedCart.getTotalItems());
    }

    @Test
    void addItem() {
        String newItem = "Patata";
        String newItem2 = "Tomate";
        String newItem3 = "Zanahoria";
        int currentItemCount = sharedCart.getTotalItems();

        sharedCart.addItem(newItem);
        sharedCart.addItem(newItem2);
        sharedCart.addItem(newItem3);

        assertAll(
                () -> assertTrue(sharedCart.getItems().contains(newItem)),
                () -> assertTrue(sharedCart.getItems().contains(newItem2)),
                () -> assertTrue(sharedCart.getItems().contains(newItem3)),
                () -> assertEquals(currentItemCount + 3, sharedCart.getTotalItems())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"platanos", "manzanas", "peras"})
    void removeItem(String item) {
        System.out.println("Eliminando: " + item);
        int currentItemCount = sharedCart.getTotalItems();

        sharedCart.removeItem(item);

        assertAll(
                () -> assertFalse(sharedCart.getItems().contains(item)),
                () -> assertEquals(currentItemCount - 1, sharedCart.getTotalItems())
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Patata,3",
            "Tomate,2",
            "Zanahoria,5"
    })
    void addItemWithQuantity(String item, int quantity) {
        System.out.println("Adding " + quantity + " of: " + item);
        int currentItemCount = sharedCart.getTotalItems();

        for (int i = 0; i < quantity; i++) {
            sharedCart.addItem(item);
        }

        assertAll(
                () -> assertTrue(sharedCart.getItems().contains(item), "Item should be in the cart"),
                () -> assertEquals(currentItemCount + quantity, sharedCart.getTotalItems(), "Total item count should match")
        );
    }

    @Test
    void getTotalItems() {
        int initialCount = sharedCart.getTotalItems();
        sharedCart.addItem("Apple");
        sharedCart.addItem("Banana");

        int totalItems = sharedCart.getTotalItems();

        assertEquals(initialCount + 2, totalItems, "The total item count should match the expected value.");
    }

    @Test
    void getItems() {
        sharedCart.addItem("Mango");
        sharedCart.addItem("Grapes");

        List<String> items = sharedCart.getItems();

        assertAll(
                () -> assertTrue(items.contains("Mango"), "The list of items should contain 'Mango'."),
                () -> assertTrue(items.contains("Grapes"), "The list of items should contain 'Grapes'."),
                () -> assertEquals(5, items.size(), "The total number of items in the cart should match the expected value.")
        );
    }

    @Test
    void addItemThrowsExceptionForNull() {
        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> sharedCart.addItem(null),
                "Expected addItem(null) to throw IllegalArgumentException"
        );
    }

    @Test
    void addItemThrowsExceptionForEmptyString() {
        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> sharedCart.addItem(""),
                "Expected addItem(\"\") to throw IllegalArgumentException"
        );
    }

    @Test
    void removeItemThrowsExceptionForNonexistentItem() {
        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> sharedCart.removeItem("Nonexistent Item"),
                "Expected removeItem(nonexistent) to throw IllegalArgumentException"
        );
    }

}
