package com.dheeraj.learning.trash;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gopad on 06-04-2017.
 */
public class WebpageScreenshot {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver browser = new ChromeDriver();
        WebDriver driver = browser;
        driver.get("https://news.google.co.in/");
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Long clientHeight = (Long) jse.executeScript("return document.documentElement.clientHeight");
        Long scrollHeight = (Long) jse.executeScript("return document.documentElement.scrollHeight");
        int screens = 0, xAxis = 0, yAxis = clientHeight.intValue();
        String screenNames = "C:\\Screenshots\\abc";
        for (screens = 0; ; screens++) {
            if (scrollHeight.intValue() - xAxis < clientHeight) {
                File crop = new File(screenNames + screens+".jpg");
                FileUtils.copyFile(browser.getScreenshotAs(OutputType.FILE), crop);

                BufferedImage image = ImageIO.read(new FileInputStream(crop));
                int y_Axixs = scrollHeight.intValue() - xAxis;
                BufferedImage croppedImage = image.getSubimage(0, image.getHeight()-y_Axixs, image.getWidth(), y_Axixs);
                ImageIO.write(croppedImage, "jpg", crop);
                break;
            }

            FileUtils.copyFile(browser.getScreenshotAs(OutputType.FILE), new File(screenNames + screens+".jpg"));
            jse.executeScript("window.scrollBy("+ xAxis +", "+yAxis+")");

            jse.executeScript("var elems = window.document.getElementsByTagName('*');"
                    + "     for(i = 0; i < elems.length; i++) { "
                    + "         var elemStyle = window.getComputedStyle(elems[i], null);"
                    + "         if(elemStyle.getPropertyValue('position') == 'fixed' && elems[i].innerHTML.length != 0 ){"
                    + "             elems[i].parentNode.removeChild(elems[i]); "
                    + "}}");    // Sticky Content Removes
            xAxis += yAxis;
        }
        driver.quit();
    }
}
