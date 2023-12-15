Feature: Search and validate Product Name in Offers page
@OffersPage
Scenario Outline: Search Experience for offers page and validation of Product Name

Given User is on GreenCart Landing page
When user searched from sheet <SheetName> with rowNumber <RowNumber> and extracted actual name of product
Then user searched for <Name> shortname from row <RowNumber> in offers page
And  validate product name in offers page matches with Landing Page

Examples:
|SheetName|RowNumber|
|Sheet1|0|
|Sheet1|1|




