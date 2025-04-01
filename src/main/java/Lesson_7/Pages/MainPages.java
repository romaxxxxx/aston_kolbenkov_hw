package Lesson_7.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPages {
    private static WebDriver driver;

    private static final By cookieAgreeForm = By.className("cookie__wrapper");
    private static final By cookieAgreeButtonBy = By.id("cookie-agree");
    private static final By paySection = By.id("pay-section");
    private static final By paySectionName = By.xpath("//div[contains(@class, 'pay__wrapper')]/h2");
    private static final By paySelect = By.id("pay");
    private static final By moreServiceInformationlinkBy = By.xpath("//a[text() = 'Подробнее о сервисе']");
    private static final By telephoneNumberInputBy = By.id("connection-phone");
    private static final By totalSumInputBy = By.id("connection-sum");
    private static final By emailInputBy = By.id("connection-email");
    private static final By continueButtonBy = By.xpath("//button[text()='Продолжить']");
    private static final By payPartnersLabelsBy = By.xpath("//div[@class = 'pay__partners']/ul/li/img");
    private static final By loaderBy = By.className("loader");
    private static final By payDataFrameBy = By.className("bepaid-iframe");
    private static final By payDataForm = By.className("app-wrapper__content");
    private static final List<String> payPartersLabelsActual = new ArrayList<>(List.of(
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"));

    public MainPages(WebDriver driver) {
        MainPages.driver = driver;
    }

    public static By getCookieAgreeButtonBy() {
        return cookieAgreeButtonBy;
    }

    public static By getPaySection() {
        return paySection;
    }

    public static By getPaySectionName() {
        return paySectionName;
    }

    public static By getPaySelect() {
        return paySelect;
    }

    public static By getMoreServiceInformationlinkBy() {
        return moreServiceInformationlinkBy;
    }

    public static By getTelephoneNumberInputBy() {
        return telephoneNumberInputBy;
    }

    public static By getTotalSumInputBy() {
        return totalSumInputBy;
    }

    public static By getEmailInputBy() {
        return emailInputBy;
    }

    public static By getContinueButtonBy() {
        return continueButtonBy;
    }

    public static By getPayPartnersLabelsBy() {
        return payPartnersLabelsBy;
    }

    public static By getLoaderBy() {
        return loaderBy;
    }

    public static By getPayDataFrameBy() {
        return payDataFrameBy;
    }

    public static By getPayDataForm() {
        return payDataForm;
    }

    public static List<String> getPayPartersLabelsActual() {
        return payPartersLabelsActual;
    }
    public static void selectListValue(By by, String value) {
        WebElement selectField = driver.findElement(by);
        List<WebElement> selectedCurrentValue = selectField.findElements(By.xpath("./../..//span[@class = 'select__now' and text() = '" + value + "']"));
        if (selectedCurrentValue.size() == 0) {
            selectField.findElement(By.xpath("./../..")).click();
            WebElement selectElement = selectField.findElement(By.xpath("./../..//ul/li/p[text()='" + value + "']"));
            selectElement.click();
        }
    }
}
