package Lesson_8.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CookieAgreePage extends BasePage {
    private static final By cookieAgreeButton = By.id("cookie-agree");

    public CookieAgreePage(WebDriver driver) {
        super(driver);
    }

    public HomePage acceptCookiesOnHomePage(){
        if(webElementBy(cookieAgreeButton).isDisplayed()){
            webElementBy(cookieAgreeButton).click();
        }
        return new HomePage(driver);
    }

}
