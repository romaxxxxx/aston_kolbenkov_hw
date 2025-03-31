package Lesson_8.Pages;

import com.google.common.base.Splitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;


import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

public class PayFormPage extends BasePage {
    HomePage homePage;
    private static final By payDataFormBy = By.className("app-wrapper__content");
    private static final By payDataFrameBy = By.className("bepaid-iframe");
    private static final By payFormCost = By.className("pay-description__cost");
    private static final By payFormDescriptionText = By.className("pay-description__text");
    private static final By payFormButtonPayment = By.className("pay-description__cost");
    private static final By cardNumberPlaceholderBy = By.xpath("//input[@id='cc-number']/..//label");
    private static final By validityPeriodPlaceholderBy = By.xpath("//input[@formcontrolname='expirationDate']/..//label");
    private static final By cvcPlaceholderBy = By.xpath("//input[@name='verification_value']/../..//label");
    private static final By holdersnamePlaceholderBy = By.xpath("//input[@autocomplete='cc-name']/../..//label");
    private static final By visaLableBy = By.xpath("//div[contains(@class,'brands__container')]/img[1]");
    private static final By mastercardLableBy = By.xpath("//div[contains(@class,'brands__container')]/img[2]");
    private static final By belcartLableBy = By.xpath("//div[contains(@class,'brands__container')]/img[3]");
    private static final By mirLableBy = By.xpath("//div[contains(@class,'cards-brands_random')]/img[2]");
    private static final By maestroLableBy = By.xpath("//div[contains(@class,'cards-brands_random')]/img[1]");

    public PayFormPage(WebDriver driver) throws InterruptedException {
        super(driver);
        waitFrame(payDataFrameBy, payDataFormBy);
    }

    public String getTypeService() {
        String webElementText = getWebElementText(payFormDescriptionText);
        return payDescriptionSplitterToMap(webElementText).get("Оплата");
    }

    public String getPhoneNumber() {
        String webElementText = getWebElementText(payFormDescriptionText);
        return payDescriptionSplitterToMap(webElementText).get("Номер");
    }

    public String getPayFormCost() {
        return getWebElementText(payFormCost);
    }

    public String getButtonCost() {
        return getWebElementText(payFormButtonPayment);
    }

    public Map<String, String> payDescriptionSplitterToMap(String value) {
        Map<String, String> map = null;
        if (homePage.getServiceType() == "Услуги связи") {
            String split[] = value.split(":");
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String st : split) {
                if (st.contains("Оплата")) {
                    sb.append("Оплата:");
                    continue;
                }
                if (st.contains(homePage.getServiceType())) {
                    sb.append(homePage.getServiceType());
                }
                if (st.contains("Номер")) {
                    sb.append("\nНомер:");
                    continue;
                }
                if (st.contains(homePage.getConnectionPhoneNumberInput())) {
                    sb.append(homePage.getConnectionPhoneNumberInput());
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
        return getWebElementAttributeValue(visaLableBy, "src");
    }

    public String getMastercardLableLink() {
        return getWebElementAttributeValue(mastercardLableBy, "src");
    }

    public String getBelcartLableLink() {
        return getWebElementAttributeValue(belcartLableBy, "src");
    }

    public String getMIRLableLink() {
        return getWebElementAttributeValue(mirLableBy, "src");
    }

    public String getMaestroLableLink() {
        return getWebElementAttributeValue(maestroLableBy, "src");
    }

    public void getHomePageObject(HomePage homePage) {
        this.homePage = homePage;
    }
}
