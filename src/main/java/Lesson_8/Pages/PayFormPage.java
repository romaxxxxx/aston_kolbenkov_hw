package Lesson_8.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

public class PayFormPage extends BasePage {
    static By loaderBy = By.className("loader");

    static By payDataForm = By.className("app-wrapper__content");
    static By payDataFrameBy = By.className("bepaid-iframe");


    public PayFormPage(WebDriver driver) {
        super(driver);
        waitExistElement(loaderBy);
        waitInVisibility(loaderBy);
        wait.until(frameToBeAvailableAndSwitchToIt(driver.findElement(payDataFrameBy)));
        waitVisibility(payDataForm);
    }

    public PayFormPage waitLoadServiceInfoPage() {
        waitVisibility(payDataForm);
        return this;
    }
}
