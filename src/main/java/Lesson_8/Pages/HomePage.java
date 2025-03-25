package Lesson_8.Pages;

import com.google.common.base.Splitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {
    static By paySection = By.id("pay-section");
    static By paySectionName = By.xpath("//div[contains(@class, 'pay__wrapper')]/h2");
    static By payPartnersLabelsBy = By.xpath("//div[@class = 'pay__partners']/ul/li/img");
    static By moreServiceInformationlinkBy = By.xpath("//a[text() = 'Подробнее о сервисе']");
    static By paySelect = By.id("pay");
    static By connectionPhoneNumberInputBy = By.id("connection-phone");
    static By connectionSumInputBy = By.id("connection-sum");
    static By connectionEmailInputBy = By.id("connection-email");
    static By internetPhoneNumberInputBy = By.id("internet-phone");
    static By internetSumInputBy = By.id("internet-sum");
    static By internetEmailInputBy = By.id("internet-email");
    static By instalmentScoreInputBy = By.id("score-instalment");
    static By instalmentSumInputBy = By.id("instalment-sum");
    static By instalmentEmailInputBy = By.id("instalment-email");
    static By scoreArrearsInputBy = By.id("score-arrears");
    static By arrearsSumInputBy = By.id("arrears-sum");
    static By arrearsEmailInputBy = By.id("arrears-email");
    static By continueButtonBy = By.xpath("//button[text()='Продолжить']");


    public String serviceType;
    public String connectionPhoneNumberInput;
    public  String connectionSumInput;
    public String connectionEmailInput;

    static public Map<By, String> fieldNameByLocator;
    static Map<By, String> actualPlaceholdersField;

    public HomePage(WebDriver driver) {
        super(driver);
        actualPlaceholdersFieldInit();
    }

    public String getPaySectionName() {
        moveToElement(paySection);
        return webElementBy(paySection).findElement(paySectionName).getText();
    }

    public List<String> getPayPartnerLableLinks() {
        List<String> lableLinks = new ArrayList<>();
        moveToElement(paySection);
        List<WebElement> payPartnersLabels = driver.findElements(payPartnersLabelsBy);
        for (WebElement payPartnerLabel : payPartnersLabels) {
            lableLinks.add(payPartnerLabel.getAttribute("src"));
        }
        return lableLinks;
    }

    public ServiceInfoPage moveToServiceInfoPage() {
        moveToElement(paySection);
        webElementBy(moreServiceInformationlinkBy).click();
        return new ServiceInfoPage(driver);
    }

    public HomePage selectServiceType(String serviceType) {
        this.serviceType = serviceType;
        selectListElement(paySelect, serviceType);
        return this;
    }

    public HomePage typeTelephoneNumber(String value) {
        this.connectionPhoneNumberInput = value;
        fillfield(connectionPhoneNumberInputBy, value);
        return this;
    }

    public HomePage typeTotalSum(String value) {
        this.connectionSumInput = value;
        fillfield(connectionSumInputBy, value);
        return this;
    }

    public HomePage typeEmail(String value) {
        this.connectionEmailInput = value;
        fillfield(connectionEmailInputBy, value);
        return this;
    }

    public PayFormPage moveToPayFormPage() {
        click(continueButtonBy);
        return new PayFormPage(driver);
    }

    public HomePage typeServicesAndCommunicationsPayData(String telephoneNumber, String email, String totalSum) {

        selectServiceType("Услуги связи");
        typeTelephoneNumber(telephoneNumber);
        typeEmail(email);
        typeTotalSum(totalSum);
        return this;
    }

    public Map<By, String> getPlaceholdersInput(String serviceType) {
        Map<By, String> placeholders = null;

        if (serviceType == "Услуги связи") {
            selectServiceType("Услуги связи");
            placeholders = Map.of(
                    connectionPhoneNumberInputBy, getWebElementAttrubuteValue(connectionPhoneNumberInputBy, "placeholder"),
                    connectionSumInputBy, getWebElementAttrubuteValue(connectionSumInputBy, "placeholder"),
                    connectionEmailInputBy, getWebElementAttrubuteValue(connectionEmailInputBy, "placeholder")
            );
        }
        if (serviceType == "Домашний интернет") {
            selectServiceType("Домашний интернет");
            placeholders = Map.of(
                    internetPhoneNumberInputBy, getWebElementAttrubuteValue(internetPhoneNumberInputBy, "placeholder"),
                    internetSumInputBy, getWebElementAttrubuteValue(internetSumInputBy, "placeholder"),
                    internetEmailInputBy, getWebElementAttrubuteValue(internetEmailInputBy, "placeholder")
            );
        }

        if (serviceType == "Рассрочка") {
            selectServiceType("Рассрочка");
            placeholders = Map.of(
                    instalmentScoreInputBy, getWebElementAttrubuteValue(instalmentScoreInputBy, "placeholder"),
                    instalmentSumInputBy, getWebElementAttrubuteValue(instalmentSumInputBy, "placeholder"),
                    instalmentEmailInputBy, getWebElementAttrubuteValue(instalmentEmailInputBy, "placeholder")
            );
        }
        if (serviceType == "Задолженность") {
            selectServiceType("Задолженность");
            placeholders = Map.of(
                    scoreArrearsInputBy, getWebElementAttrubuteValue(scoreArrearsInputBy, "placeholder"),
                    arrearsSumInputBy, getWebElementAttrubuteValue(arrearsSumInputBy, "placeholder"),
                    arrearsEmailInputBy, getWebElementAttrubuteValue(arrearsEmailInputBy, "placeholder")
            );
        }
        return placeholders;
    }

    public String getActualplaceholder(By by) {
        return actualPlaceholdersField.get(by);
    }

    public String getFieldNameByLocator(By by) {
        fieldNameByLocator = new HashMap<>();
        fieldNameByLocator.put(connectionPhoneNumberInputBy, "Телефон: Услуги связи");
        fieldNameByLocator.put(connectionSumInputBy, "Сумма: Услуги связи");
        fieldNameByLocator.put(connectionEmailInputBy, "Email: Услуги связи");
        fieldNameByLocator.put(internetPhoneNumberInputBy, "Номер абонента: Домашний интернет");
        fieldNameByLocator.put(internetSumInputBy, "Сумма: Домашний интернет");
        fieldNameByLocator.put(internetEmailInputBy, "Email: Домашний интернет");
        fieldNameByLocator.put(instalmentScoreInputBy, "Номер счета: Рассрочка");
        fieldNameByLocator.put(instalmentSumInputBy, "Сумма: Рассрочка");
        fieldNameByLocator.put(instalmentEmailInputBy, "Email: Рассрочка");
        fieldNameByLocator.put(scoreArrearsInputBy, "Номер счета: Задолженность");
        fieldNameByLocator.put(arrearsSumInputBy, "Сумма: Задолженность");
        fieldNameByLocator.put(arrearsEmailInputBy, "Email: Задолженность");
        return fieldNameByLocator.get(by);
    }

    public void actualPlaceholdersFieldInit() {
        actualPlaceholdersField = new HashMap<>();
        actualPlaceholdersField.put(connectionPhoneNumberInputBy, "Номер телефона");
        actualPlaceholdersField.put(connectionSumInputBy, "Сумма");
        actualPlaceholdersField.put(connectionEmailInputBy, "E-mail для отправки чека");
        actualPlaceholdersField.put(internetPhoneNumberInputBy, "Номер абонента");
        actualPlaceholdersField.put(internetSumInputBy, "Сумма");
        actualPlaceholdersField.put(internetEmailInputBy, "E-mail для отправки чека");
        actualPlaceholdersField.put(instalmentScoreInputBy, "Номер счета на 44");
        actualPlaceholdersField.put(instalmentSumInputBy, "Сумма");
        actualPlaceholdersField.put(instalmentEmailInputBy, "E-mail для отправки чека");
        actualPlaceholdersField.put(scoreArrearsInputBy, "Номер счета на 2073");
        actualPlaceholdersField.put(arrearsSumInputBy, "Сумма");
        actualPlaceholdersField.put(arrearsEmailInputBy, "E-mail для отправки чека");
    }




}
