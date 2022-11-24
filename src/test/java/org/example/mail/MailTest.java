package org.example.mail;

import org.example.TestProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MailTest {

    public static MailPage mailPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mailPage = new MailPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestProperties.getProperty("mailpage"));

    }

    @Test
    public void mailTest(){

        mailPage.clickEnter();
        mailPage.inputLoginField(TestProperties.getProperty("login"));
        mailPage.clickPassword();
        mailPage.inputPasswordField(TestProperties.getProperty("password"));
        mailPage.clickLogin();
        mailPage.clickProfile();
        mailPage.profileName();
        mailPage.exitProfile();
        mailPage.checkExit();
    }

    @AfterClass
    public static void down(){

        driver.quit();
    }
}
