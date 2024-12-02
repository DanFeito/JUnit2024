package com.jose.cordoba.formacion.unitTesting.session1.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsServiceImplTest {

    private final OperationsService operationsService = new OperationsServiceImpl();

    @Test
    void alwaysTrue() {
        //When
        boolean result = operationsService.alwaysTrue();
        //Then
        assertTrue(result);
    }

    @Test
    void alwaysFalse() {
        //When
        boolean result = operationsService.alwaysFalse();
        //Then
        assertFalse(result);
    }

    @Test
    void sumPositives() {
        // Given
        int a = 10;
        int b = 5;
        int expected = 15;
        // When
        int result = operationsService.sum(a, b);
        // Then
        assertEquals(expected, result);
    }

    @Test
    void sumNegatives() {
        // Given
        int a = -10;
        int b = 5;
        int expected = -5;
        // When
        int result = operationsService.sum(a, b);
        // Then
        assertEquals(expected, result);
    }

    @Test
    void sumZero() {
        // Given
        int a = 0;
        int b = 5;
        int expected = 5;
        // When
        int result = operationsService.sum(a, b);
        // Then
        assertEquals(expected, result);
    }

    @Test
    void divPositiveNumbers() {
        int num = 10;
        int den = 2;
        int expected = 5;
        int result = operationsService.div(num, den);
        assertEquals(expected, result);
    }

    @Test
    void divNegativeByPositive() {
        int num = -10;
        int den = 2;
        int expected = -5;
        int result = operationsService.div(num, den);
        assertEquals(expected, result);
    }

    @Test
    void divPositiveByNegative() {
        int num = 10;
        int den = -2;
        int expected = -5;
        int result = operationsService.div(num, den);
        assertEquals(expected, result);
    }

    @Test
    void divNegativeNumbers() {
        int num = -10;
        int den = -2;
        int expected = 5;
        int result = operationsService.div(num, den);
        assertEquals(expected, result);
    }

    @Test
    void divByOne() {
        int num = 10;
        int den = 1;
        int expected = 10;
        int result = operationsService.div(num, den);
        assertEquals(expected, result);
    }

    @Test
    void divBySelf() {
        int num = 10;
        int den = 10;
        int expected = 1;
        int result = operationsService.div(num, den);
        assertEquals(expected, result);
    }

    @Test
    void divByZero() {
        int num = 10;
        int den = 0;
        assertThrows(ArithmeticException.class, () -> operationsService.div(num, den), "Expected division by zero to throw an ArithmeticException");
    }
}