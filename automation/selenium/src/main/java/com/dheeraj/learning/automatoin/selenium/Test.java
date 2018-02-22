package com.dheeraj.learning.automatoin.selenium;

/*
* Created by bhavani
* */

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.Select;

public class Test{


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        WebDriver driver ;
        System.setProperty("webdriver.chrome.driver","C:\\dev\\tools\\chromedriver_win32_2.18\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver();

        String baseUrl = "https://www.facebook.com/";
        /*String expectedTitle = "Google";
        String actualTitle = "";*/

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        System.out.println(driver.getTitle());
        // get the actual value of the title
        /*actualTitle = driver.getTitle();
        System.out.println("Title : "+actualTitle);
            *//*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         *//*
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");*/
      //  }

        Select a = new Select(driver.findElement(By.id("day")));
        a.selectByVisibleText("20");
        //close Fire fox
        driver.close();

        // exit the program explicitly
        System.exit(0);
    }

}