package Lesson_8.Pages;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    static WebDriverWait wait;
    static Actions action;

    public BasePage(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        this.driver = driver;
        this.driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        action = new Actions(driver);
}

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementBy)));
    }

    public void waitInVisibility(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOf((driver.findElement(elementBy))));
    }

    public void waitExistElement(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitTitlePage(String titleName) {
        wait.until(ExpectedConditions.titleContains(titleName));
    }

    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public WebElement waitToBeClickableElement(By elementBy){
        return wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public WebElement webElementBy (By by){
        return driver.findElement(by);
    }

    public void moveToElement(By by){
        action.moveToElement(webElementBy(by)).perform();
    }

    public void selectElement(By by, String value){
        WebElement selectField = webElementBy(by);
        WebElement selectedCurrentValue = selectField.findElement(By.xpath("./../..//span[@class = 'select__now' and text() = '" + value + "']"));
        if (!selectedCurrentValue.isDisplayed()) {
            selectField.findElement(By.xpath("./../..")).click();
            WebElement selectElement = selectField.findElement(By.xpath("./../..//ul/li/p[text()='" + value + "']"));
            selectElement.click();
        }
    }

    public void fillfield(By by, String value){
        webElementBy(by).sendKeys(value);
    }



    }