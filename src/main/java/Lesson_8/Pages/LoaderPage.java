package Lesson_8.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoaderPage extends BasePage{
    static By loaderBy = By.className("loader");

    public LoaderPage(WebDriver driver) {
        super(driver);
    }

    public PayFormPage waitPayFormLoader(){
        waitExistElement(loaderBy);
        waitInVisibility(loaderBy);
        return new PayFormPage(driver);
    }
}
