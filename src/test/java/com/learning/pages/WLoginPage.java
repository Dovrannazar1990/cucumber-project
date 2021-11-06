package com.learning.pages;

import com.learning.utility.ConfigReader;
import com.learning.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage {

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userNameField;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordField;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@id='ctl00_MainContent_status']")
    public WebElement errorMsg;

    // Now we need to instruct selenium to start looking for element
    // when this constructor is called
    // This is no arg constructor of this class
    public WLoginPage() {
        // PageFactory is a selenium class that supports Page Object Model
        // And it has method called initElements
        // Once it's called, it will locate all the element
        // Specified using @FindBy annotation with locator
        // InitElements accept 2 arguments,
        // WebDriver instance and Page class instance (this) means current instance of this class.

        PageFactory.initElements(Driver.getDriver(), this);
    }

    /*
     * Create a method to goTo
     * Accept no param just navigate to login page
     * Use config.properties for url
     */

    public void goTo() {
        Driver.getDriver().navigate().to(ConfigReader.read("weborder_url"));
    }

    /**
     * Login with parameters
     * @param username username
     * @param password password
     */

    public void login(String username, String password) {

        // You can access directly using userNameField or
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();
    }

    /**
     * Check error message is present if wrong credentials provided
     * loginErrorMsgPresent simple return the result of isDisplayed method call
     */

    public boolean loginErrorMsgPresent() {

        return this.errorMsg.isDisplayed();
    }
}