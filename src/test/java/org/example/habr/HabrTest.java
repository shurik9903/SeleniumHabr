package org.example.habr;

import org.example.TestProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HabrTest {

    public static HabrPage habrPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        habrPage = new HabrPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(TestProperties.getProperty("habrpage"));

    }

    @Test
    public void habrTest(){

        habrPage.clickFind();
        habrPage.testActive();
        habrPage.textInput("Selenium WebDriver");
        habrPage.ClickFindInputField();
        habrPage.FindToText();
        habrPage.getDateTime();
        habrPage.clickPublication();


    }

    @AfterClass
    public static void down(){

        driver.quit();
    }

}
