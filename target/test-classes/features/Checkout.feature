Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on GreenCart Landing page
When user searched from sheet <SheetName> with rowNumber <RowNumber> and extracted actual name of product
And Added items "3" of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
|SheetName|RowNumber|
|Sheet1|0|
|Sheet1|1|

