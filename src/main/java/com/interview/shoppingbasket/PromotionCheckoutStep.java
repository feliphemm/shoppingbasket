package com.interview.shoppingbasket;

import java.util.List;

public class PromotionCheckoutStep {
    private PromotionsService promotionsService;

    public PromotionCheckoutStep (PromotionsService promotionsService){this.promotionsService = promotionsService; }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        List<Promotion> promotions = promotionsService.getPromotions(basket);


        checkoutContext.setRetailPriceTotal(retailTotal);
    }
}
