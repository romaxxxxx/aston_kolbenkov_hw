package Lesson_8.Pages;

import Lesson_8.Data.PayFieldsInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    private static final By paySection = By.id("pay-section");
    private static final By paySectionName = By.xpath("//div[contains(@class, 'pay__wrapper')]/h2");
    private static final By payPartnersLabelsBy = By.xpath("//div[@class = 'pay__partners']/ul/li/img");
    private static final By moreServiceInformationlinkBy = By.xpath("//a[text() = 'Подробнее о сервисе']");
    private static final By paySelect = By.id("pay");
    private static final By connectionPhoneNumberInputBy = By.id("connection-phone");
    private static final By connectionSumInputBy = By.id("connection-sum");
    private static final By connectionEmailInputBy = By.id("connection-email");
    private static final By internetPhoneNumberInputBy = By.id("internet-phone");
    private static final By internetSumInputBy = By.id("internet-sum");
    private static final By internetEmailInputBy = By.id("internet-email");
    private static final By instalmentScoreInputBy = By.id("score-instalment");
    private static final By instalmentSumInputBy = By.id("instalment-sum");
    private static final By instalmentEmailInputBy = By.id("instalment-email");
    private static final By scoreArrearsInputBy = By.id("score-arrears");
    private static final By arrearsSumInputBy = By.id("arrears-sum");
    private static final By arrearsEmailInputBy = By.id("arrears-email");
    private static final By continueButtonBy = By.xpath("//button[text()='Продолжить']");
    private String serviceType;
    private String connectionPhoneNumberInput;
    private String connectionSumInput;
    private String connectionEmailInput;
    List<PayFieldsInfo> payFieldsInfo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getConnectionPhoneNumberInput() {
        return connectionPhoneNumberInput;
    }

    public String getConnectionSumInput() {
        return connectionSumInput;
    }

    public String getPaySectionName() {
        moveToElementBy(paySection);
        return webElementBy(paySection).findElement(paySectionName).getText();
    }

    public List<String> getPayPartnerLableLinks() {
        List<String> lableLinks = new ArrayList<>();
        moveToElementBy(paySection);
        List<WebElement> payPartnersLabels = driver.findElements(payPartnersLabelsBy);
        for (WebElement payPartnerLabel : payPartnersLabels) {
            lableLinks.add(payPartnerLabel.getAttribute("src"));
        }
        return lableLinks;
    }

    public ServiceInfoPage moveToServiceInfoPage() {
        moveToElementBy(paySection);
        webElementBy(moreServiceInformationlinkBy).click();
        return new ServiceInfoPage(driver);
    }

    public HomePage selectServiceType(String serviceType) throws InterruptedException {
        this.serviceType = serviceType;
        selectListElement(paySelect, serviceType);
        return this;
    }

    public HomePage typeTelephoneNumber(String value) {
        this.connectionPhoneNumberInput = value;
        fillField(connectionPhoneNumberInputBy, value);
        return this;
    }

    public HomePage typeTotalSum(String value) {
        this.connectionSumInput = value;
        fillField(connectionSumInputBy, value);
        return this;
    }

    public HomePage typeEmail(String value) {
        this.connectionEmailInput = value;
        fillField(connectionEmailInputBy, value);
        return this;
    }

    public PayFormPage moveToPayFormPage() throws InterruptedException {
        clickBy(continueButtonBy);
        return new PayFormPage(driver);
    }

    public HomePage typeServicesAndCommunicationsPayData(String telephoneNumber, String email, String totalSum) throws InterruptedException {

        selectServiceType("Услуги связи");
        typeTelephoneNumber(telephoneNumber);
        typeEmail(email);
        typeTotalSum(totalSum);
        return this;
    }

    public List<PayFieldsInfo> getPlaceholdersInput(String serviceType) throws InterruptedException {
        payFieldsInfo = new ArrayList<>();
        if (serviceType == "Услуги связи") {
            selectServiceType("Услуги связи");
            payFieldsInfo.add(new PayFieldsInfo("Телефон: Услуги связи", "Номер телефона",
                    getPlaceholder(connectionPhoneNumberInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Сумма: Услуги связи", "Сумма",
                    getPlaceholder(connectionSumInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Email: Услуги связи", "E-mail для отправки чека",
                    getPlaceholder(connectionEmailInputBy)));
        }

        if (serviceType == "Домашний интернет") {
            selectServiceType("Домашний интернет");
            payFieldsInfo.add(new PayFieldsInfo("Номер абонента: Домашний интернет", "Номер абонента",
                    getPlaceholder(internetPhoneNumberInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Сумма: Домашний интернет", "Сумма",
                    getPlaceholder(internetSumInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Email: Домашний интернет", "E-mail для отправки чека",
                    getPlaceholder(internetEmailInputBy)));
        }

        if (serviceType.equals("Рассрочка")) {
            selectServiceType("Рассрочка");
            payFieldsInfo.add(new PayFieldsInfo("Номер счета: Рассрочка", "Номер счета на 44",
                    getPlaceholder(instalmentScoreInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Сумма: Рассрочка", "Сумма",
                    getPlaceholder(instalmentSumInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Email: Рассрочка", "E-mail для отправки чека",
                    getPlaceholder(instalmentEmailInputBy)));
        }

        if (serviceType.equals("Задолженность")) {
            selectServiceType("Задолженность");
            payFieldsInfo.add(new PayFieldsInfo("Номер счета: Задолженность", "Номер счета на 2073",
                    getPlaceholder(scoreArrearsInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Сумма: Задолженность", "Сумма",
                    getPlaceholder(arrearsSumInputBy)));
            payFieldsInfo.add(new PayFieldsInfo("Email: Задолженность", "E-mail для отправки чека",
                    getPlaceholder(arrearsEmailInputBy)));

        }
        return payFieldsInfo;
    }
}
