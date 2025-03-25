package Lesson_8;

import Lesson_8.Pages.CookieAgreePage;
import Lesson_8.Pages.HomePage;
import Lesson_8.Pages.PayFormPage;
import Lesson_8.Pages.ServiceInfoPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MTSTests extends BaseTest {
    static List<String> payPartersLabelsActual = new ArrayList<>(List.of(
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"));


    static Map<String, String> placeholderc = Map.of();

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
                .movToServiceInfoPage();

        Assert.assertNotNull(serviceInfoPage, "Страница с информацие о сервисе не открывается");
    }

    @Test
    public static void checkContinueButton() {
        PayFormPage PayForm = new CookieAgreePage(driver)
                .acceptCookiesOnHomePage()
                .typeServicesAndCommunicationsPayData("297777777", "asdf@mail.ru", "50")
                .moveToPayFormPage();

        Assert.assertNotNull(PayForm, "Форма для ввода данных по оплате не открывается");
    }

    @Test
    public static void checkPlaceholdersInPayField() {
        HomePage hp = new HomePage(driver);

        new CookieAgreePage(driver)
                .acceptCookiesOnHomePage();

        Map<By, String> connectionPlaceholders = hp.getPlaceholdersInput("Услуги связи");

        connectionPlaceholders.forEach((key, value) -> softAssert.assertEquals(value,
                hp.getActualplaceholder(key),
                "\nНеверный плейсхолдер в поле:" + hp.getFieldNameByLocator(key)));

        for (Map.Entry<By, String> placeholderInputConnection : connectionPlaceholders.entrySet()) {
            softAssert.assertEquals(placeholderInputConnection.getValue(),hp.getActualplaceholder(placeholderInputConnection.getKey()),
                    "\nНеверный плейсхолдер в поле:" + hp.getFieldNameByLocator(placeholderInputConnection.getKey()));
        }

        Map<By, String> placeholdersInputInternet = hp.getPlaceholdersInput("Домашний интернет");

        for (Map.Entry<By, String> placeholderInputInternet : placeholdersInputInternet.entrySet()) {
            softAssert.assertEquals(placeholderInputInternet.getValue(),hp.getActualplaceholder(placeholderInputInternet.getKey()),
                    "\nНеверный плейсхолдер в поле:" + hp.getFieldNameByLocator(placeholderInputInternet.getKey()));
        }

        Map<By, String> placeholdersInputInstalment = hp.getPlaceholdersInput("Рассрочка");

        for (Map.Entry<By, String> placeholderInputInstalment : placeholdersInputInstalment.entrySet()) {
            softAssert.assertEquals(placeholderInputInstalment.getValue(),hp.getActualplaceholder(placeholderInputInstalment.getKey()),
                    "\nНеверный плейсхолдер в поле:" + hp.getFieldNameByLocator(placeholderInputInstalment.getKey()));
        }

        Map<By, String> placeholdersInputArrears = hp.getPlaceholdersInput("Задолженность");

        for (Map.Entry<By, String> placeholderInputArrears : placeholdersInputArrears.entrySet()) {
            softAssert.assertEquals(placeholderInputArrears.getValue(),hp.getActualplaceholder(placeholderInputArrears.getKey()),
                    "\nНеверный плейсхолдер в поле:" + hp.getFieldNameByLocator(placeholderInputArrears.getKey()));
        }
        softAssert.assertAll();
    }
}

