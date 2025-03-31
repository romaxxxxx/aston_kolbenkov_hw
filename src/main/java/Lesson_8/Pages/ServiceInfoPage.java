package Lesson_8.Pages;

import org.openqa.selenium.WebDriver;

public class ServiceInfoPage extends BasePage{
    private static final String titlePage = "Порядок оплаты и безопасность интернет платежей";
    public ServiceInfoPage(WebDriver driver) {
        super(driver);
        waitTitlePage(titlePage);
    }
}
