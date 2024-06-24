package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    void emptyBasket() {
        Basket basket = new Basket();
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(), 0);
    }

    @Test
    void createBasketFullConstructor() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(), 1);
        assertEquals(basketSize.get(0).getProductCode(), "productCode");
        assertEquals(basketSize.get(0).getProductName(), "myProduct");
        assertEquals(basketSize.get(0).getQuantity(), 10);
    }

    @Test
    void createBasketWithMultipleProducts() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        basket.add("productCode2", "myProduct2", 10);
        basket.add("productCode3", "myProduct3", 10);

        List<BasketItem> basketSize = basket.getItems();

        assertEquals(basketSize.size(),3);
        assertEquals(basketSize.get(0).getProductCode(), "productCode");
        assertEquals(basketSize.get(0).getProductName(), "myProduct");
        assertEquals(basketSize.get(0).getQuantity(), 10);
        assertEquals(basketSize.get(1).getProductCode(), "productCode2");
        assertEquals(basketSize.get(1).getProductName(), "myProduct2");
        assertEquals(basketSize.get(1).getQuantity(), 10);
        assertEquals(basketSize.get(2).getProductCode(), "productCode3");
        assertEquals(basketSize.get(2).getProductName(), "myProduct3");
        assertEquals(basketSize.get(2).getQuantity(), 10);
    }

    @Test
    void consolidateBasketTest() {
        // Exercise - implement the unit test for consolidate items

        Basket basket = new Basket();
        basket.add("productCode1", "myProduct", 10);
        basket.add("productCode2", "myProduct1", 10);
        basket.add("productCode3", "myProduct2", 10);
        basket.add("productCode2", "myProduct3", 10);
        basket.add("productCode3", "myProduct4", 10);
        basket.add("productCode1", "myProduct5", 10);

        List<BasketItem> basketSize = basket.getItems();

        basket.consolidateItems();

        assertEquals(basketSize.size(),3);
        assertEquals(basket.getItems().get(0).getProductCode(), "productCode1");
        assertEquals(basket.getItems().get(1).getProductCode(), "productCode2");
        assertEquals(basket.getItems().get(2).getProductCode(), "productCode3");
        assertEquals(basket.getItems().get(0).getQuantity(), 20);
        assertEquals(basket.getItems().get(1).getQuantity(), 20);
        assertEquals(basket.getItems().get(2).getQuantity(), 20);

    }
}
