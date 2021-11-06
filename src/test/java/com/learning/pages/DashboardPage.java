package com.learning.pages;

import com.learning.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    // Add 3 elements that hold numbers
    // Add @FindBy annotation

    @FindBy(id = "user_count")
    private WebElement userCountElm;

    @FindBy(id = "book_count")
    private WebElement bookCountElm;

    @FindBy(id = "borrowed_books")
    private WebElement borrowedCountElm;

    // Add constructor
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Add 3 method for getting the numbers
    public String getUserCountText() {
        return userCountElm.getText();
    }

    public String getBookCountText() {
        return bookCountElm.getText();
    }

    public String getBorrowedBookText() {
        return borrowedCountElm.getText();
    }
}