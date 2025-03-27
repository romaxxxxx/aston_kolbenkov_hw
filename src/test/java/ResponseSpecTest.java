import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

import java.util.regex.Matcher;

public class ResponseSpecTest {
    public static ResponseSpecBuilder builder;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setupResponseSpecBuilder()
    {
        builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType(ContentType.JSON);
        builder.expectResponseTime(Matchers.lessThan(5000L));
        responseSpec = builder.build();
    }
}
