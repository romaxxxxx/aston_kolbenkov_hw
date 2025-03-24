package Lesson_8;

import Lesson_8.Pages.CookieAgreePage;
import Lesson_8.Pages.HomePage;
import Lesson_8.Pages.ServiceInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class MTSTests extends BaseTest {
    static List<String> payPartersLabelsActual = new ArrayList<>(List.of(
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"));

    @Test()
    public static void checkPaySectionName() {
        new CookieAgreePage(driver)
                .acceptCookiesOnHomePage();

        Assert.assertEquals(new HomePage(driver).getPaySectionName(), "Онлайн пополнение\nбез комиссии");
    }

    @Test()
    public static void checkPayPartnersLabel() {
        new CookieAgreePage(driver)
                .acceptCookiesOnHomePage();

        int i = 0;
        for (String payPartnerLabel : new HomePage(driver).getPayPartnerLableLinks()) {
            softAssert.assertEquals(payPartnerLabel, payPartersLabelsActual.get(i),
                    "\nНеверное изображение лейбла:" + payPartersLabelsActual.get(i));
            i++;
        }
        softAssert.assertAll();
    }

    @Test()
    public static void checkLink() {
        ServiceInfoPage serviceInfoPage = new CookieAgreePage(driver)
                .acceptCookiesOnHomePage()
                .movToServiceInfoPage()
                .waitLoadServiceInfoPage();

        Assert.assertNotNull(serviceInfoPage);
    }


}

