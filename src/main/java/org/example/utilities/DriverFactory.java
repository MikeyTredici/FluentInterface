package org.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {
        // Prevents instantiation
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", ConfigReader.getChromeDriver());
            driver = new ChromeDriver();
        }

        return driver;
    }
}
