package Lesson_8.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    static By paySection = By.id("pay-section");
    static By paySectionName = By.xpath("//div[contains(@class, 'pay__wrapper')]/h2");
    static By payPartnersLabelsBy = By.xpath("//div[@class = 'pay__partners']/ul/li/img");
    static By moreServiceInformationlinkBy = By.xpath("//a[text() = 'Подробнее о сервисе']");



    public HomePage(WebDriver driver) {
        super(driver);
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

    public ServiceInfoPage movToServiceInfoPage(){
        moveToElement(paySection);
        webElementBy(moreServiceInformationlinkBy).click();
        return new ServiceInfoPage(driver);
    }

}
