package Lesson_8.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    static WebDriverWait wait;
    static Actions action;
    HomePage homePage;

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

    public void click(By by) {
        moveToElement(by);
        waitVisibility(by);
        driver.findElement(by).click();
    }

    public WebElement waitToBeClickableElement(By elementBy) {
        return wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public WebElement webElementBy(By by) {
        return driver.findElement(by);
    }

    public void moveToElement(By by) {
        action.moveToElement(webElementBy(by)).perform();
    }


    public void fillfield(By by, String value) {
        moveToElement(by);
        webElementBy(by).sendKeys(value);
    }

    public String getWebElementAttrubuteValue(By by, String attributeName) {
        return webElementBy(by).getAttribute(attributeName);
    }

    public void selectListElement(By by, String value) {
        moveToElement(by);
        WebElement selectField = webElementBy(by);
        List<WebElement> selectedCurrentValue = selectField.findElements(By.xpath("./../..//span[@class = 'select__now' and text() = '" + value + "']"));
        if (selectedCurrentValue.size() == 0) {
            selectField.findElement(By.xpath("./../..")).click();
            WebElement selectElement = selectField.findElement(By.xpath("./../..//ul/li/p[text()='" + value + "']"));
            selectElement.click();
        }
    }

    public boolean isDisplayedWebElement(WebElement webElement) {
        boolean bool = true;
        try {
            WebElement webElement1 = webElement;
        } catch (NoSuchElementException e) {
            e.getMessage();
            bool = false;
        }
        return bool;
    }

    public String getWebElementText(By by){
        return webElementBy(by).getText();
    }


}