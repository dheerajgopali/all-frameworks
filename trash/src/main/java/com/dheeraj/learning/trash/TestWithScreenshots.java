package com.dheeraj.learning.trash;

/**
 * Created by gopad on 06-04-2017.
 */
import static org.junit.Assert.*;
        import java.io.File;
        import java.io.IOException;
        import javax.imageio.ImageIO;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import ru.yandex.qatools.ashot.AShot;
        import ru.yandex.qatools.ashot.Screenshot;
        import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class TestWithScreenshots {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","C:\\dev\\tools\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFirstResult() throws InterruptedException, IOException
    {

        driver.get("http://www.vpl.ca");

//take the screenshot of the entire home page and save it to a png file
        Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File("c:\\Screenshots\\home.png"));

        WebElement searchField = driver.findElement(By.xpath("//input[@id='globalQuery']"));
        searchField.click();
        searchField.sendKeys("java");

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
        searchButton.click();

        Thread.sleep(3000);

//take the screenshot of the entire results page and save it to a png file
        screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File("c:\\Screenshots\\results.png"));

//take the screenshot of a div element that includes all results page details>br/> screenshot = new AShot().takeScreenshot(driver, driver.findElement(By.xpath("(//div[@id='ct_search'])[1]")));
        ImageIO.write(screenshot.getImage(), "PNG", new File("c:\\Screenshots\\div_element.png"));

        WebElement searchResultLink = driver.findElement(By.xpath("(//a[@testid='bib_link'])[2]"));
        searchResultLink.click();

        Thread.sleep(3000);

//take the screenshot of the entire details page and save it to a png file
        screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File("c:\\Screenshots\\details.png"));

        WebElement bookTitleElement = driver.findElement(By.xpath("//h1[@id='item_bib_title']"));
        String bookTitleValue = bookTitleElement.getText();

        assertEquals(bookTitleElement.isDisplayed(), true);
        assertTrue(bookTitleValue.length() > 0);

    }

}