package com.learning.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * We wanted to have a class with that only return Singleton object
 * no matter how many times you asked for object
 * So we are creating this class with technic we learned from Singleton pattern
 */

public class Driver {

    private static WebDriver obj;

    private Driver() {
    }

    /**
     * Return obj with only one WebDriver instance
     *
     * @return same WebDriver if exists, new one if null
     */

    public static WebDriver getDriver() {
        // Read the browser type you want to launch from properties file
        String browserName = ConfigReader.read("browser");

        if (obj == null) {

            // According to browser type set up driver correctly
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                // other browsers omitted
                default:
                    obj = null;
                    System.out.println("Unknown browser type!" + browserName);
            }
            return obj;

        } else {
            return obj;
        }
    }

    /**
     * Quitting the browser and setting the value of
     * WebDriver instance to null because you cannot reuse already quited driver
     */

    public static void closeBrowser() {

        // Check if we have WebDriver instance or not
        // Basically checking if obj is null or not
        // If not null
        // quit the browser
        // Make it null, because once quit it can not be used

        if (obj != null) {
            obj.quit();
            // So when ask for it again, it gives us not quited fresh driver
            obj = null;
        }
    }
}