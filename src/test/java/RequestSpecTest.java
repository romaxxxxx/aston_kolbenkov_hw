import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class RequestSpecTest {
    public static RequestSpecBuilder builder;
    public static RequestSpecification requestSpec;
    @BeforeClass
    public static void setupRequestSpecBuilder()
    {
        builder = new RequestSpecBuilder();
        builder.setBaseUri("https://postman-echo.com");
        requestSpec = builder.build();
    }
}
