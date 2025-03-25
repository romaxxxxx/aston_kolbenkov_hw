package Lesson_8.Pages;

import com.google.common.base.Splitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;


import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

public class PayFormPage extends BasePage {
    HomePage homePage;
    static By loaderBy = By.className("loader");

    static By payDataForm = By.className("app-wrapper__content");
    static By payDataFrameBy = By.className("bepaid-iframe");
    static By payFormCost = By.className("pay-description__cost");
    static By payFormDescriptionText = By.className("pay-description__text");
    static By payFormButtonPayment = By.className("pay-description__cost");

    static By cardNumberPlaceholderBy = By.xpath("//input[@id='cc-number']/..//label");
    static By validityPeriodPlaceholderBy = By.xpath("//input[@formcontrolname='expirationDate']/..//label");
    static By cvcPlaceholderBy = By.xpath("//input[@name='verification_value']/../..//label");

    static By holdersnamePlaceholderBy = By.xpath("//input[@autocomplete='cc-name']/../..//label");


    static By visaLableBy = By.xpath("//div[contains(@class,'brands__container')]/img[1]");


    static By mastercardLableBy = By.xpath("//div[contains(@class,'brands__container')]/img[2]");
    static By belcartLableBy = By.xpath("//div[contains(@class,'brands__container')]/img[3]");
    static By mirLableBy = By.xpath("//div[contains(@class,'cards-brands_random')]/img[2]");
    static By maestroLableBy = By.xpath("//div[contains(@class,'cards-brands_random')]/img[1]");


    public PayFormPage(WebDriver driver) {
        super(driver);
        waitExistElement(loaderBy);
        waitInVisibility(loaderBy);
        wait.until(frameToBeAvailableAndSwitchToIt(driver.findElement(payDataFrameBy)));
        waitVisibility(payDataForm);
    }

    public String getTypeService() {
        String webElementText = getWebElementText(payFormDescriptionText);
        return payDescriptionSpliterToMap(webElementText).get("Оплата");
    }

    public String getPhoneNumber() {
        String webElementText = getWebElementText(payFormDescriptionText);
        return payDescriptionSpliterToMap(webElementText).get("Номер");
    }

    public String getPayFormCost() {
        return getWebElementText(payFormCost);

    }

    public String getButtonCost() {
        return getWebElementText(payFormButtonPayment);
    }

    public Map<String, String> payDescriptionSpliterToMap(String value) {
        Map<String, String> map = null;
        if (homePage.serviceType == "Услуги связи") {
            String split[] = value.split(":");
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String st : split) {
                if (st.contains("Оплата")) {
                    sb.append("Оплата:");
                    continue;
                }
                if (st.contains(homePage.serviceType)) {
                    sb.append(homePage.serviceType);
                }
                if (st.contains("Номер")) {
                    sb.append("\nНомер:");
                    continue;
                }
                if (st.contains(homePage.connectionPhoneNumberInput)) {
                    sb.append(homePage.connectionPhoneNumberInput);
                }
            }
            map = Splitter.on("\n")
                    .withKeyValueSeparator(":")
                    .split(sb.toString());
        }
        return map;
    }

    public String getCardNumberPlaceholdersName() {
        return getWebElementText(cardNumberPlaceholderBy);
    }

    public String getValidityPeriodPlaceholdersName() {
        return getWebElementText(validityPeriodPlaceholderBy);
    }

    public String getCVCPlaceholdersName() {
        return getWebElementText(cvcPlaceholderBy);
    }

    public String getHoldersnamePlaceholdersName() {
        return getWebElementText(holdersnamePlaceholderBy);
    }

    public String getVISALableLink() {
        return getWebElementAttrubuteValue(visaLableBy, "src");
    }

    public String getMastercardLableLink() {
        return getWebElementAttrubuteValue(mastercardLableBy, "src");
    }

    public String getBelcartLableLink() {
        return getWebElementAttrubuteValue(belcartLableBy, "src");
    }

    public String getMIRLableLink() {
        return getWebElementAttrubuteValue(mirLableBy, "src");
    }

    public String getMaestroLableLink() {
        return getWebElementAttrubuteValue(maestroLableBy, "src");
    }

    public void getHomePageObject(HomePage homePage) {
        this.homePage = homePage;
    }


}
