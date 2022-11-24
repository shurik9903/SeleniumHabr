package org.example.habr;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HabrPage {

    public WebDriver driver;
    public HabrPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement waitElement(By by, String error_msg, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(error_msg);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clickFind() {
        WebElement element = waitElement(By.xpath("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search']"), "Не найдено кнопки поиска", 10);
        element.click();
    }

    public void testActive(){
        WebElement element = waitElement(By.xpath("//*[@class='tm-input-text-decorated__input']"), "Не найдено поле поиска", 10);
        Assert.assertEquals(element, driver.switchTo().activeElement());
    }

    public void textInput(String text){
        WebElement element = waitElement(By.xpath("//*[@class='tm-input-text-decorated__input']"), "Не найдено поле поиска", 10);
        element.sendKeys(text);
    }

    public void ClickFindInputField(){
        WebElement element = waitElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']"), "Не найдено кнопка поиска поля поиска", 10);
        element.click();
    }

    public void FindToText(){
        WebElement element = waitElement(By.linkText("Что такое Selenium?"), "Не найдено искомой статьи", 10);
        element.click();
    }

    public void getDateTime(){
        WebElement element = waitElement(By.xpath("//*[@class='tm-article-snippet tm-article-presenter__snippet tm-article-snippet']//*[@class='tm-article-snippet__datetime-published']//time"), "Не найдено даты статьи", 10);
        Assert.assertEquals("28 сентября 2012 в 16:14", element.getText());
    }

    public void clickPublication(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.manage().window().setSize(new Dimension(1280, 1025));

        WebElement element = waitElement(By.xpath("//a[@class='footer-menu__item-link router-link-active' and @href='/ru/']"), "Не найдено кнопки публикации", 10);
        element.click();
    }

}



