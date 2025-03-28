import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

import java.util.regex.Matcher;

import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecTest {
    public static ResponseSpecBuilder builder;
    public static ResponseSpecification responseSpec;
    @BeforeClass
    public static ResponseSpecification setupResponseSpecBuilder()
    {
        builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType(ContentType.JSON);
        builder.expectResponseTime(Matchers.lessThan(5000L));
        builder.expectHeader("Connection","keep-alive");
        builder.expectBody("headers.host",equalTo("postman-echo.com"));
        builder.expectBody("headers.connection",equalTo("close"));
        builder.expectBody("headers.x-forwarded-proto",equalTo("https"));
        builder.expectBody("headers.x-forwarded-port",equalTo("443"));
        responseSpec = builder.build();
        return responseSpec;
    }
}
