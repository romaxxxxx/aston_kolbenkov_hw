package Lesson_7;

import Lesson_7.Pages.MainPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static Lesson_7.Pages.MainPages.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MTStests {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static  Actions action;
    private static  SoftAssert softAssert;
    private static MainPages mainPage;

    @BeforeMethod
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        action = new Actions(driver);
        softAssert = new SoftAssert();
        driver.get("https://www.mts.by/");
        mainPage = new MainPages(driver);
    }

    @Test()
    public static void checkPaySectionName() {
        WebElement cookieAgreeButton = driver.findElement(getCookieAgreeButtonBy());
        if (cookieAgreeButton.isDisplayed()) {
            cookieAgreeButton.click();
        }
        WebElement paySectionForm = driver.findElement(getPaySection());
        action.moveToElement(paySectionForm).perform();
        String paySectionNameText = paySectionForm.findElement(getPaySectionName()).getText();
        Assert.assertEquals(paySectionNameText, "Онлайн пополнение\nбез комиссии");
    }

    @Test()
    public static void checkPayPartnersLabel() {
        WebElement cookieAgreeButton = driver.findElement(getCookieAgreeButtonBy());
        if (cookieAgreeButton.isDisplayed()) {
            cookieAgreeButton.click();
        }
        WebElement paySectionForm = driver.findElement(getPaySection());
        action.moveToElement(paySectionForm).perform();
        List<WebElement> payPartnersLabels = driver.findElements(getPayPartnersLabelsBy());
        int i = 0;
        for (WebElement payPartnerLabel : payPartnersLabels) {
            softAssert.assertEquals(payPartnerLabel.getAttribute("src"), getPayPartersLabelsActual().get(i),
                    "\nНеверное изображение лейбла:" + getPayPartersLabelsActual().get(i));
            i++;
        }
        softAssert.assertAll();
    }

    @Test
    public static void checkServiceInformationLink() {
        WebElement cookieAgreeButton = driver.findElement(getCookieAgreeButtonBy());
        if (cookieAgreeButton.isDisplayed()) {
            cookieAgreeButton.click();
        }
        WebElement paySectionForm = driver.findElement(getPaySection());
        action.moveToElement(paySectionForm).perform();
        WebElement moreServiceInformationlink = paySectionForm.findElement(getMoreServiceInformationlinkBy());
        moreServiceInformationlink.click();
        Assert.assertNotNull(wait.until(titleContains("Порядок оплаты и безопасность интернет платежей")),
                "Страница с информацие о сервисе не открывается");
    }

    @Test
    public static void checkContinueButton() {
        WebElement cookieAgreeButton = driver.findElement(getCookieAgreeButtonBy());
        if (cookieAgreeButton.isDisplayed()) {
            cookieAgreeButton.click();
        }
        WebElement paySectionForm = driver.findElement(getPaySection());
        action.moveToElement(paySectionForm).perform();
        selectListValue(getPaySelect(), "Услуги связи");
        WebElement telephoneNumberInput = driver.findElement(getTelephoneNumberInputBy());
        telephoneNumberInput.sendKeys("297777777");
        WebElement totalSumInput = driver.findElement(getTotalSumInputBy());
        totalSumInput.sendKeys("50");
        WebElement emailInput = driver.findElement(getEmailInputBy());
        emailInput.sendKeys("asdf@mail.ru");
        WebElement continueButton = driver.findElement(getContinueButtonBy());
        continueButton.click();
        wait.until(visibilityOfElementLocated(getLoaderBy()));
        wait.until(invisibilityOf(driver.findElement(getLoaderBy())));
        wait.until(frameToBeAvailableAndSwitchToIt(driver.findElement(getPayDataFrameBy())));
        Assert.assertNotNull(wait.until(visibilityOf(driver.findElement(getPayDataForm()))),
                "Форма для ввода данных по оплате не открывается");
    }

    @AfterMethod
    public static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
