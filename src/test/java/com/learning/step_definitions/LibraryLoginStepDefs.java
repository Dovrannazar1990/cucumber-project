package com.learning.step_definitions;

import com.learning.pages.LibLoginPage;
import com.learning.utility.BrowserUtil;
import com.learning.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LibraryLoginStepDefs {

    LibLoginPage loginPage = new LibLoginPage();

    @Given("user is at library login page")
    public void userIsAtLibraryLoginPage() {
        loginPage.goTo();
    }

    @When("user use email {string} and passcode {string}")
    public void userUseEmailAndPasscode(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("user should be at dashboard page")
    public void userShouldBeAtDashboardPage() {

        BrowserUtil.waitFor(1);
        // Check the title is now Library after logging in
        assertEquals("Library", Driver.getDriver().getTitle());
    }
}
