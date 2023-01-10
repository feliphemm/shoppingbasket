# CV-JAVA-INTERVIEW

> [!INFO]
> After finishing the problems, create a public repository in Github, push your code and send us the Github Public URL
> If for some reason this is not possible, send us a zip folder with your project

### Pre Requisites
 - IDE supporting Java
 - Java 11
 - Maven

## Instructions
### Building and running tests
From the command line you can build the project with:
```
mvn clean install
```

And run the tests with:
```
mvn test
```

### Project Description
 * This test is based on a simple retail checkout pipeline
 * A Basket of BasketItems is passed to a CheckoutPipeline
 * The Basket is placed in a CheckoutContext, then passed through a series of CheckoutSteps
 * These steps process and update the basket and the context in order to produce a final bill

## Problem 1

 * We have the start of the implementation for a Shopping Basket Service
 * You can see a Basket definition which contains individual BasketItems, each having a product code, name and quantity
 * Implement the consolidateItems method from the Basket, so that there is no more than one BasketItem with the same productCode within it, and the quantity of that item is set to the sum of the quantities for all items with that same productCode in the original basket

## Problem 2
### The Checkout process involves a number of CheckoutSteps
 * You’ll see there’s one for consolidating the Basket (calling the method you’ve just implemented in Problem 1)
 * And one for pricing the Basket
 * We want an additional CheckoutStep that calls a PromotionnService to retrieve all Promotions for a Basket and adds them to the CheckoutContext for itemising on a receipt and calculate the final customer price
    * eq. 2 for the price of 1
 * The calculation of the final price based on the promotions is expected to be implemented as well


### Expected outcome:
* Test for the new implementation of the CheckoutStep interface that mocks the interaction with the PromotionService
* Successful implementation of a CheckoutStep that uses a PromotionsService, adds the promotions retrieved from the service into the CheckoutContext and calculates the final price
