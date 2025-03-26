package Lesson_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    static WebDriverWait wait;
    static Actions action;
    static SoftAssert softAssert;
    static By cookieAgreeForm = By.className("cookie__wrapper");
    static By cookieAgreeButton = By.id("cookie-agree");
    static By paySection = By.id("pay-section");
    static By paySectionName = By.xpath("//div[contains(@class, 'pay__wrapper')]/h2");
    static By paySelect = By.id("pay");
    static By moreServiceInformationlinkBy = By.xpath("//a[text() = 'Подробнее о сервисе']");
    static By telephoneNumberInputBy = By.id("connection-phone");
    static By totalSumInputBy = By.id("connection-sum");
    static By emailInputBy = By.id("connection-email");
    static By continueButtonBy = By.xpath("//button[text()='Продолжить']");
    static By payPartnersLabelsBy = By.xpath("//div[@class = 'pay__partners']/ul/li/img");
    static By loaderBy = By.className("loader");
    static By payDataFrameBy = By.className("bepaid-iframe");
    static By payDataForm = By.className("app-wrapper__content");
    static List<String> payPartersLabelsActual = new ArrayList<>(List.of(
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"));

    @BeforeMethod
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(20000));
        action = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @Test()
    public static void checkPaySectionName() {
        driver.get("https://www.mts.by/");
        if (driver.findElement(cookieAgreeForm).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(cookieAgreeButton))).click();
        }
        WebElement paySectionForm = driver.findElement(paySection);
        action.moveToElement(paySectionForm).perform();
        String paySectionNameText = paySectionForm.findElement(paySectionName).getText();
        Assert.assertEquals(paySectionNameText, "Онлайн пополнение\nбез комиссии");
    }

    @Test()
    public static void checkPayPartnersLabel() {
        driver.get("https://www.mts.by/");
        if (driver.findElement(cookieAgreeForm).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(cookieAgreeButton))).click();
        }
        WebElement paySectionForm = driver.findElement(paySection);
        action.moveToElement(paySectionForm).perform();
        List<WebElement> payPartnersLabels = driver.findElements(payPartnersLabelsBy);
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
        if (driver.findElement(cookieAgreeForm).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(cookieAgreeButton))).click();
        }
        WebElement paySectionForm = driver.findElement(paySection);
        action.moveToElement(paySectionForm).perform();
        WebElement moreServiceInformationlink = paySectionForm.findElement(moreServiceInformationlinkBy);
        moreServiceInformationlink.click();
        Assert.assertNotNull(wait.until(titleContains("Порядок оплаты и безопасность интернет платежей")));
    }

    @Test
    public static void checkContinueButton() throws InterruptedException {
        driver.get("https://www.mts.by/");
        if (driver.findElement(cookieAgreeForm).isDisplayed()) {
            wait.until(elementToBeClickable(driver.findElement(cookieAgreeButton))).click();
        }
        WebElement paySectionForm = driver.findElement(paySection);
        action.moveToElement(paySectionForm).perform();
        selectListElement(paySelect, "Услуги связи");
        WebElement telephoneNumberInput = driver.findElement(telephoneNumberInputBy);
        telephoneNumberInput.sendKeys("297777777");
        WebElement totalSumInput = driver.findElement(totalSumInputBy);
        totalSumInput.sendKeys("50");
        WebElement emailInput = driver.findElement(emailInputBy);
        emailInput.sendKeys("asdf@mail.ru");
        WebElement continueButton = driver.findElement(continueButtonBy);
        continueButton.click();
        waitFrome(payDataFrameBy);
        Assert.assertNotNull(wait.until(visibilityOf(driver.findElement(payDataForm))));
    }

    @AfterMethod
    public static void tearDown() {
        driver.close();
    }

    static void waitFrome(By by) throws InterruptedException {
        for(int i = 0;i<6;i++) {
            try {
                wait.until(frameToBeAvailableAndSwitchToIt(driver.findElement(payDataFrameBy)));
            }catch (NoSuchElementException e){
                System.out.println("Попытка"+i);
            }
            Thread.sleep(5000);
            List<WebElement> frame = driver.findElements(payDataForm);
            if(frame.size()>0)
                break;
        }
    }

    static void selectListElement(By by, String value) {
        WebElement selectField = driver.findElement(by);
        WebElement selectedCurrentValue = selectField.findElement(By.xpath("./../..//span[@class = 'select__now' and text() = '" + value + "']"));
        if (!selectedCurrentValue.isDisplayed()) {
            selectField.findElement(By.xpath("./../..")).click();
            WebElement selectElement = selectField.findElement(By.xpath("./../..//ul/li/p[text()='" + value + "']"));
            selectElement.click();
        }
    }



}
