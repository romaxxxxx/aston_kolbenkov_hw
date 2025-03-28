import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecSetup {
    private static RequestSpecBuilder builder;

    public static RequestSpecification setupRequestSpec() {
        builder = new RequestSpecBuilder();
        return builder
                .setBaseUri("https://postman-echo.com")
                .build();
    }

    public static RequestSpecification urlencodedSetupRequestSpec() {
        builder = new RequestSpecBuilder();
        return builder
                .setBaseUri("https://postman-echo.com")
                .setContentType("application/x-www-form-urlencoded; charset=utf-8")
                .build();
    }
}
