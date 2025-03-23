package Lesson_8;

import Lesson_8.Pages.BasePage;
import Lesson_8.Pages.CookieAgreePage;
import Lesson_8.Pages.HomePage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MTSTests extends BaseTest {
//    HomePage homePage = new HomePage(driver);
//    BasePage basePage = new BasePage(driver);
    //static CookieAgreePage cookieAgreePage = new CookieAgreePage(driver);


    @Test()
    public static void checkPaySectionName() {
        new CookieAgreePage(driver)
                .cookiesAgree();


//        if(cookieAgreePage.waitVisibility();)
//
//
//        if (driver.findElement(cookieAgreeForm).isDisplayed()) {
//            wait.until(elementToBeClickable(driver.findElement(cookieAgreeButton))).click();
//        }
//        WebElement paySectionForm = driver.findElement(paySection);
//        action.moveToElement(paySectionForm).perform();
//        String paySectionNameText = paySectionForm.findElement(paySectionName).getText();
//        Assert.assertEquals(paySectionNameText, "Онлайн пополнение\nбез комиссии");
    }
}
