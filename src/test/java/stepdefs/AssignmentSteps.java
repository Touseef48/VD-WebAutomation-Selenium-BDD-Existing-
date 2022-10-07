package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import objects.Assignment;

public class AssignmentSteps {
    /*
        -------------------------------------------------
        Add Dove Brand (Newest) item to cart using Xpath
        -------------------------------------------------
    */
    @Given("Click the Dove Brand from list")
    public void selectDoveBrand(){
        Assignment.arriveToLogin();
        Assignment.clickDoveBrand();
    }

    @Then("Select the newest item")
    public void selectnewitem(){
        Assignment.setSelectnewitem();
    }

    @And("Add it to Cart")
    public void addToCart(){
        Assignment.clickAddToCart();
    }

    @Then("Verify item in cart")
    public void assertItem(){
        Assignment.AssertValue();
    }

    /*
    --------------------------------------------------------------------
    Add Men Category Item to cart (name end with letter M) Using x-Path
    --------------------------------------------------------------------
    */

    @Given("Go to the men section")
    public void clickMenNavbar(){
        Assignment.arriveToLogin();
        Assignment.selectMenNav();
    }

    @Then("Select product whose product name ends with M")
    public void selectProductEndWithM(){
        Assignment.addItemEndsWithMToCart();
    }

    @And("Add men item to Cart")
    public void addItemToCart(){
        Assignment.cart();
    }

    @Then("item into the cart should start with the name M.")
    public void verifyItem(){
        Assignment.verify();
    }

    /*
        ------------------------------------------------------------------------
            Add Accessories T-shirts and Shoes item to cart using CSS-Selectors
        ------------------------------------------------------------------------
    */

    @Given("Go to the APPAREL & ACCESSORIES section")
    public void go_to_the_APPAREL_ACCESSORIES_section() {
        Assignment.arriveToLogin();
        Assignment.selectAccessoriesSection();
    }

    @Then("go to Tshirts")
    public void go_to_Tshirts() {
        Assignment.selectTshirts();
    }

    @And("sort the element by low to high rate")
    public void sort_the_element_by_low_to_high_rate() {
        Assignment.sortShirts();
    }

    @Then("Select the lowest value medium sized products")
    public void select_the_lowest_value_medium_sized_products() {
        Assignment.selectLowValueMediumShirt();
    }

    @And("Add Shirt to your cart")
    public void addShirtToCart() {
        Assignment.addShirtToCart();
    }

    @Then("Go back to the APPAREL & ACCESSORIES section")
    public void go_back_to_the_APPAREL_ACCESSORIES_section() {
        Assignment.selectAccessoriesSection();
    }

    @And("go to the shoes section")
    public void go_to_the_shoes_section() {
        Assignment.selectShoesOption();
    }

    @Then("add the highest value product to the cart, and quantity should be 2")
    public void addHighestValueShoesToCart() {
        Assignment.addHighRatedShoesToCart();
    }

    @And("Verify the selected item in the cart")
    public void verifyAccessoriesCart() {
        Assignment.assertAccessoriesInCart();
    }

}
