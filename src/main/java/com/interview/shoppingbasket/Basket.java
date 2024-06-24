package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        // Exercise - implement this function

        for(int i = 0; i <= getItems().size(); i++) {
            for (int j = i + 1; j < getItems().size(); j++) {
                if (getItems().get(i).getProductCode().equals(getItems().get(j).getProductCode())) {
                    getItems().get(i).setQuantity(getItems().get(i).getQuantity() + getItems().get(j).getQuantity());
                    getItems().remove(j);
                    j = j - 1;
                }
            }
        }
    }
}
