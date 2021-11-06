package com.learning.pages;

import com.learning.utility.ConfigReader;
import com.learning.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibLoginPage {

    @FindBy(id = "inputEmail")
    private WebElement usernameBox;

    @FindBy(id = "inputPassword")
    private WebElement passwordBox;

    @FindBy(xpath = "//button[.='Sign in']")
    private WebElement loginButton;

    public LibLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo() {
//        Driver.getDriver().navigate().to("https://library2.cybertekschool.com/login.html");
        Driver.getDriver().get(ConfigReader.read("library2.ui.url"));
    }

    public void login(String username, String password) {

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}