import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.nio.charset.Charset;

public class RequestSpecTest {
    public static RequestSpecBuilder builder;
    @BeforeClass
    public static RequestSpecification setupRequestSpecBuilder() {
        builder = new RequestSpecBuilder();
        return builder
                .setBaseUri("https://postman-echo.com")
                .build();
    }

    public static RequestSpecification urlencodedSetupRequestSpecBuilder() {
        builder = new RequestSpecBuilder();
        return builder
                .setBaseUri("https://postman-echo.com")
                .setContentType("application/x-www-form-urlencoded; charset=utf-8")
                .build();
    }
}
