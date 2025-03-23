package Lesson_8.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CookieAgreePage extends BasePage {
    //BasePage basePage = new BasePage(driver);
    static By cookieAgreeForm = By.className("cookie__wrapper");
    static By cookieAgreeButton = By.id("cookie-agree");

    public CookieAgreePage(WebDriver driver) {
        super(driver);
    }

    public CookieAgreePage cookiesAgree(){
        waitToBeClickableElement(cookieAgreeButton).click();
        return this;
    }

}
