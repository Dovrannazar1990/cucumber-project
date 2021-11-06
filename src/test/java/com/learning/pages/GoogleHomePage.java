package com.learning.pages;

import com.learning.utility.ConfigReader;
import com.learning.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    public GoogleHomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    /*
     * Navigate to google homepage
     */
    public void goTo() {
        // Driver.getDriver().get("https://www.google.com/");
        Driver.getDriver().get(ConfigReader.read("google.utl"));
    }

    /**
     * Search on google homepage
     *
     * @param keyword keyword you want to search on google
     */

    public void searchKeyword(String keyword) {

        this.searchBox.sendKeys(keyword);
        this.searchBtn.submit();
    }

    /**
     * Check if you are at google homepage by checking the title
     *
     * @return true if title is Google, false if not
     */

    public boolean isAt() {

        return Driver.getDriver().getTitle().equals("Google");
    }
}