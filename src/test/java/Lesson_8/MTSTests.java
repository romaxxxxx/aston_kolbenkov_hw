package Lesson_8;

import Lesson_8.Data.PayFieldsInfo;
import Lesson_8.Pages.CookieAgreePage;
import Lesson_8.Pages.HomePage;
import Lesson_8.Pages.PayFormPage;
import Lesson_8.Pages.ServiceInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
    public static void checkServiceInfoLink() {
        ServiceInfoPage serviceInfoPage = new CookieAgreePage(driver)
                .acceptCookiesOnHomePage()
                .moveToServiceInfoPage();

        Assert.assertNotNull(serviceInfoPage, "Страница с информацие о сервисе не открывается");
    }

    @Test
    public static void checkContinueButton() throws InterruptedException {
        PayFormPage PayForm = new CookieAgreePage(driver)
                .acceptCookiesOnHomePage()
                .typeServicesAndCommunicationsPayData("297777777", "asdf@mail.ru", "50")
                .moveToPayFormPage();

        Assert.assertNotNull(PayForm, "Форма для ввода данных по оплате не открывается");
    }

    @Test
    public static void checkPlaceholdersInPayField() {
        HomePage homePage = new HomePage(driver);

        new CookieAgreePage(driver)
                .acceptCookiesOnHomePage();

        List<PayFieldsInfo> connectionPlaceholders = homePage.getPlaceholdersInput("Услуги связи");

        for (PayFieldsInfo placeholderInputConnection : connectionPlaceholders) {
            softAssert.assertEquals(placeholderInputConnection.webElementPlaceholderValue,
                    placeholderInputConnection.actualPlaceholderValue,
                    "\nНеверный плейсхолдер в поле:" + placeholderInputConnection.fieldName);
        }

        List<PayFieldsInfo> placeholdersInputInternet = homePage.getPlaceholdersInput("Домашний интернет");

        for (PayFieldsInfo placeholderInputInternet : placeholdersInputInternet) {
            softAssert.assertEquals(placeholderInputInternet.webElementPlaceholderValue,
                    placeholderInputInternet.actualPlaceholderValue,
                    "\nНеверный плейсхолдер в поле:" + placeholderInputInternet.fieldName);
        }

        List<PayFieldsInfo> placeholdersInputInstalment = homePage.getPlaceholdersInput("Рассрочка");

        for (PayFieldsInfo placeholderInputInstalment : placeholdersInputInstalment) {
            softAssert.assertEquals(placeholderInputInstalment.webElementPlaceholderValue,
                    placeholderInputInstalment.actualPlaceholderValue,
                    "\nНеверный плейсхолдер в поле:" + placeholderInputInstalment.fieldName);
        }

        List<PayFieldsInfo> placeholdersInputArrears = homePage.getPlaceholdersInput("Задолженность");

        for (PayFieldsInfo placeholderInputArrears : placeholdersInputArrears) {
            softAssert.assertEquals(placeholderInputArrears.webElementPlaceholderValue,
                    placeholderInputArrears.actualPlaceholderValue,
                    "\nНеверный плейсхолдер в поле:" + placeholderInputArrears.fieldName);
        }
        softAssert.assertAll();
    }

    @Test
    public static void checkPayDataForm() throws InterruptedException {
        HomePage homePage = new CookieAgreePage(driver)
                .acceptCookiesOnHomePage()
                .typeServicesAndCommunicationsPayData("297777777", "asdf@mail.ru", "50");

        PayFormPage payFormPage = homePage
                .moveToPayFormPage();

        payFormPage.getHomePageObject(homePage);

        softAssert.assertEquals(payFormPage.getTypeService(), homePage.serviceType, "Неверный тип сервиса");
        softAssert.assertEquals(payFormPage.getPhoneNumber(), homePage.connectionPhoneNumberInput, "Неверный номер телефона");
        softAssert.assertTrue(payFormPage.getButtonCost().contains(homePage.connectionSumInput), "Неверная цена на кнопке оплаты");
        softAssert.assertTrue(payFormPage.getPayFormCost().contains(homePage.connectionSumInput), "Неверная цена на форме оплаты");
        softAssert.assertAll();
    }

    @Test
    public static void checkPayFormPlaceholders() throws InterruptedException {
        PayFormPage payFormPage = new CookieAgreePage(driver)
                .acceptCookiesOnHomePage()
                .typeServicesAndCommunicationsPayData("297777777", "asdf@mail.ru", "50")
                .moveToPayFormPage();

        softAssert.assertEquals(payFormPage.getCVCPlaceholdersName(), "CVC", "\nНеверный плейсхолдер в поле CVC");
        softAssert.assertEquals(payFormPage.getCardNumberPlaceholdersName(), "Номер карты", "\nНеверный плейсхолдер в поле Номер карты");
        softAssert.assertEquals(payFormPage.getValidityPeriodPlaceholdersName(), "Срок действия", "\nНеверный плейсхолдер в поле Срок дейсвтия");
        softAssert.assertEquals(payFormPage.getHoldersnamePlaceholdersName(), "Имя держателя (как на карте)", "\nНеверный плейсхолдер в поле Держатель карты");
        softAssert.assertAll();
    }

    @Test
    static void checkPartnersLabelOnPayForm() throws InterruptedException {
        PayFormPage payFormPage = new CookieAgreePage(driver)
                .acceptCookiesOnHomePage()
                .typeServicesAndCommunicationsPayData("297777777", "asdf@mail.ru", "50")
                .moveToPayFormPage();

        softAssert.assertEquals(payFormPage.getMIRLableLink(), "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg",
                "\nНеверный лейбл у MIR");
        softAssert.assertEquals(payFormPage.getMaestroLableLink(), "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg",
                "\nНеверный лейбл у Maestro");
        softAssert.assertEquals(payFormPage.getBelcartLableLink(), "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg",
                "\nНеверный лейбл у Belcart");
        softAssert.assertEquals(payFormPage.getVISALableLink(), "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg",
                "\nНеверный лейбл у VISA");
        softAssert.assertEquals(payFormPage.getMastercardLableLink(), "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg",
                "\nНеверный лейбл у Mastercard");
        softAssert.assertAll();
    }

}

