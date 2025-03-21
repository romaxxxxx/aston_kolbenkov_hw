package Lesson_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MTStests {
    static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximised");
        driver = new ChromeDriver(options);
    }

    @Test()
    public static void checkPaySectionName() {
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        if (driver.findElement(By.className("cookie__wrapper")).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(By.id("cookie-agree"))));
            driver.findElement(By.id("cookie-agree")).click();
        }
        Actions action = new Actions(driver);
        WebElement paySection = driver.findElement(By.id("pay-section"));
        action.moveToElement(paySection).perform();
        String paySectionName = paySection.findElement(By.xpath("//div[contains(@class, 'pay__wrapper')]/h2")).getText();
        Assert.assertEquals(paySectionName, "Онлайн пополнение\nбез комиссии");
    }

    @Test()
    public static void checkPayPartnersLabel() {
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        if (driver.findElement(By.className("cookie__wrapper")).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(By.id("cookie-agree"))));
            driver.findElement(By.id("cookie-agree")).click();
        }
        Actions action = new Actions(driver);
        WebElement paySection = driver.findElement(By.id("pay-section"));
        action.moveToElement(paySection).perform();
        List<WebElement> payPartnersLabels = driver.findElements(By.xpath("//div[@class = 'pay__partners']/ul/li/img"));
        List<String> payPartersLabelsActual = new ArrayList<>(List.of(
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"));
        SoftAssert softAssert = new SoftAssert();
        int i = 0;
        for (WebElement payPartnerLabel : payPartnersLabels) {
            softAssert.assertEquals(payPartnerLabel.getAttribute("src"), payPartersLabelsActual.get(i),
                    "\nНеверное изображение лейбла:" + payPartersLabelsActual.get(i));
            i++;
        }
        softAssert.assertAll();
    }

    @Test
    public static void checkLink() {
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        if (driver.findElement(By.className("cookie__wrapper")).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(By.id("cookie-agree"))));
            driver.findElement(By.id("cookie-agree")).click();
        }
        WebElement paySection = driver.findElement(By.id("pay-section"));
        Actions action = new Actions(driver);
        action.moveToElement(paySection).perform();
        WebElement moreServiceInformationlink = paySection.findElement(By.xpath("//a[text() = 'Подробнее о сервисе']"));
        moreServiceInformationlink.click();
        Assert.assertNotNull(wait.until(titleContains("Порядок оплаты и безопасность интернет платежей")));
    }

    @Test
    public static void checkContunueButton(){
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        if (driver.findElement(By.className("cookie__wrapper")).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(By.id("cookie-agree"))));
            driver.findElement(By.id("cookie-agree")).click();
        }
        WebElement paySection = driver.findElement(By.id("pay-section"));
        Actions action = new Actions(driver);
        action.moveToElement(paySection).perform();
        WebElement paySelector = driver.findElement(By.id("pay"));
        paySelector.findElement(By.xpath("./../..")).click();
        WebElement payItemСommunicationServices = paySelector.findElement(By.xpath(
                "./../..//ul/li/p[text()='Услуги связи']"));
        payItemСommunicationServices.click();
        WebElement telephoneNumberInput = driver.findElement(By.id("connection-phone"));
        telephoneNumberInput.sendKeys("297777777");
        WebElement totalSumInput = driver.findElement(By.id("connection-sum"));
        totalSumInput.sendKeys("50");
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.sendKeys("asdf@mail.ru");
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueButton.click();
        By loader = By.className("loader");
        wait.until(visibilityOfElementLocated(loader));
        wait.until(invisibilityOf(driver.findElement(loader)));
        wait.until(frameToBeAvailableAndSwitchToIt(driver.findElement(By.className("bepaid-iframe"))));
        By formWithPayData = By.className("app-wrapper__content");
        Assert.assertNotNull(wait.until(visibilityOf(driver.findElement(formWithPayData))));
    }

    @AfterMethod
    public static void afterMethod() {
        driver.close();
    }
}
