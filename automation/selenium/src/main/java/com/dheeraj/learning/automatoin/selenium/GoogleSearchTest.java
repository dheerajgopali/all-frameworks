package com.dheeraj.learning.automatoin.selenium;

/**
 * Created by gopad on 25-03-2017.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {

    public static void main(String...args) {
        System.setProperty("webdriver.gecko.driver","C:\\dev\\tools\\geckodriver-v0.15.0-win64\\geckodriver.exe");

        WebDriver driver  = new FirefoxDriver();
        driver.navigate().to("http://facebook.com");
        String appTitle = driver.getTitle();
        System.out.println("Application title is :: "+appTitle);
        driver.quit();
    }

}