package Lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public SoftAssert softAssert;
    //protected static WebDriverWait wait;
    protected static Actions action;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        //wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        action = new Actions(driver);
        softAssert = new SoftAssert();
        driver.get("https://www.mts.by");
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
