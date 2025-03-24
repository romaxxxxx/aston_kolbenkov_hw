package Lesson_8.Pages;

import org.openqa.selenium.WebDriver;

public class ServiceInfoPage extends BasePage{
    String titlePage = "Порядок оплаты и безопасность интернет платежей";
    public ServiceInfoPage(WebDriver driver) {
        super(driver);
        waitTitlePage(titlePage);
    }

//    public ServiceInfoPage waitLoadServiceInfoPage(){
//        waitTitlePage(titlePage);
//        return this;
//    }

}
