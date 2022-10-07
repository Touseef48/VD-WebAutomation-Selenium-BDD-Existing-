Feature: feature to test Swaglab login functionality

  @scenario1
  Scenario: Add Dove Item To Cart
    Given Click the Dove Brand from list
    Then Select the newest item
    And Add it to Cart
    Then Verify item in cart

  @scenario2
  Scenario: Add Accessories Items To Cart
    Given Go to the APPAREL & ACCESSORIES section
    Then go to Tshirts
    And sort the element by low to high rate
    Then Select the lowest value medium sized products
    And Add Shirt to your cart
    Then Go back to the APPAREL & ACCESSORIES section
    And go to the shoes section
    Then add the highest value product to the cart, and quantity should be 2
    And Verify the selected item in the cart

  @scenario4
  Scenario: Add Product whose name ends with M
    Given Go to the men section
    Then Select product whose product name ends with M
    And Add men item to Cart
    Then item into the cart should start with the name M.