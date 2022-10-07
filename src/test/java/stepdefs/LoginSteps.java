package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import general.*;
import org.testng.reporters.jq.Main;

public class LoginSteps {


    @Given("^User is arrive to Login Page$")
    public void user_is_arrive_to_Login_Page() {
       MainCall.loginPage.arriveToLogin();
    }
    @When("^I want to Close Driver$")
    public void i_want_to_Close_Driver() throws Exception {
        Thread.sleep(30000);
        MainCall.webDriverFactory.finishDriver();
    }

    @Given("^I am Testing Case : \"([^\"]*)\"$")
    public void iAmTestingCase(String id) throws Throwable {
        MainCall.caseID = id;
    }

    @And("^I have enter username as \"([^\"]*)\"$")
    public void iHaveEnterUsernameAs(String userName) throws Throwable {
        //Database Example
        MainCall.loginPage.dataBaseQuery();
       MainCall.loginPage.enterUserName(userName);
    }

    @And("^I have enter password as \"([^\"]*)\"$")
    public void iHaveEnterPasswordAs(String password) throws Throwable {
        MainCall.loginPage.enterPassword(password);
    }

    @When("^I press the login button$")
    public void iPressTheLoginButton() {
        MainCall.loginPage.clickLogin();
    }

    @Then("^I verify the login$")
    public void iVerifyTheLogin() {
        MainCall.loginPage.verifyLogin("Logout");
    }

    @Then("^I want to see the error message$")
    public void iWantToSeeTheErrorMessage() {
        MainCall.loginPage.verifyError("The username or password you entered is incorrect");
    }
}
