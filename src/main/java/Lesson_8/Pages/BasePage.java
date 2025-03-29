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

import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

public class BasePage {
    protected WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

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

    public void waitTitlePage(String titleName) {
        wait.until(ExpectedConditions.titleContains(titleName));
    }

    public void click(By by) {
        moveToElementBy(by);
        waitVisibility(by);
        driver.findElement(by).click();
    }

    public WebElement webElementBy(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> webElementsBy(By by) {
        return driver.findElements(by);
    }

    public void moveToElementBy(By by) {
        action.moveToElement(webElementBy(by)).perform();
    }

    public void moveToElement(WebElement webElement) {
        action.moveToElement(webElement).perform();
    }

    public void fillField(By by, String value) {
        moveToElementBy(by);
        webElementBy(by).sendKeys(value);
    }

    public String getWebElementAttributeValue(By by, String attributeName) {
        return webElementBy(by).getAttribute(attributeName);
    }

    public String getPlaceholder(By by){
        return webElementBy(by).getAttribute("placeholder");
    }

    public void selectListElement(By selectFieldBy, String value) {
        moveToElementBy(selectFieldBy);
        WebElement selectField = webElementBy(selectFieldBy);
        try {
            selectField.findElement(By.xpath("./../..//span[@class = 'select__now' and text() = '" + value + "']"));
        } catch(NoSuchElementException e) {
            selectField.findElement(By.xpath("./../..")).click();
            WebElement selectElement = selectField.findElement(By.xpath("./../..//ul/li/p[text()='" + value + "']"));
            moveToElement(selectElement);
            selectElement.click();
        }
    }

    public String getWebElementText(By by) {
        return webElementBy(by).getText();
    }

    public void waitFrame(By frameBy, By webFormBy) throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            try {
                wait.until(frameToBeAvailableAndSwitchToIt(webElementBy(frameBy)));
            } catch (NoSuchElementException e) {
                System.out.println("Попытка" + i);
            }
            Thread.sleep(5000);
            List<WebElement> frame = webElementsBy(webFormBy);
            if (frame.size() > 0)
                break;
        }
    }
}