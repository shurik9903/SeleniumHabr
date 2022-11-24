package org.example.mail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailPage {

    public WebDriver driver;
    public MailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement waitElement(By by, String error_msg, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(error_msg);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clickEnter() {
        WebElement element = waitElement(By.xpath("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big svelte-1y37831']"), "Не найдено кнопки входа", 10);
        element.click();
    }

    public void inputLoginField(String text){

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
            driver.get(element.getAttribute("src"));
        }catch (Exception ignored){}

        WebElement element = waitElement(By.xpath("//input[@name='username']"), "Не найдено поля логина", 10);
        element.clear();
        element.sendKeys(text);
    }

    public void clickPassword(){
        WebElement element = waitElement(By.xpath("//button[@data-test-id='next-button']"), "Не найдено кнопки ввода пароля", 10);
        element.click();
    }

    public void inputPasswordField(String text){
        WebElement element = waitElement(By.xpath("//input[@name='password']"), "Не найдено поля пароля", 10);
        element.clear();
        element.sendKeys(text);
    }

    public void clickLogin(){
        WebElement element = waitElement(By.xpath("//button[@data-test-id='submit-button']"), "Не найдено кнопки входа", 10);
        element.click();
    }

    public void clickProfile(){
        WebElement element = waitElement(By.xpath("//div[@class='ph-project ph-project__account svelte-1hiqrvn ph-project-any']"), "Не найдено кнопки профиля", 10);
        element.click();
    }

    public void profileName(){
        WebElement element = waitElement(By.xpath("//div[@class='ph-name svelte-6ia8p0']"), "Не найдено имени профиля", 10);
        Assert.assertEquals(element.getText(), "Тестовый Тестич");
    }

    public void exitProfile(){
        WebElement element = waitElement(By.xpath("//div[@class='ph-item ph-item__hover-active svelte-6ia8p0']"), "Не найдено кнопки выхода", 10);
        element.click();
    }

    public void checkExit(){
        try {
            WebElement element = waitElement(By.xpath("//a[@class='resplash-btn resplash-btn_outlined-blue resplash-btn_mailbox-big svelte-1y37831']"), "Не найдено элемента сравнения", 10);
            Assert.assertTrue(element.isDisplayed());
        } catch (Exception ignore){
            WebElement element = waitElement(By.xpath("//div[@class='login-panel-footer-right']"), "Не найдено элемента сравнения", 10);
            Assert.assertTrue(element.isDisplayed());
        }




    }

}
