import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecSetup {
    public static ResponseSpecBuilder builder;

    @BeforeClass
    public static ResponseSpecification setupResponseSpec() {
        builder = new ResponseSpecBuilder();
        return builder.expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .expectHeader("Connection", "keep-alive")
                .expectBody("headers.host", equalTo("postman-echo.com"))
                .expectBody("headers.connection", equalTo("close"))
                .expectBody("headers.x-forwarded-proto", equalTo("https"))
                .expectBody("headers.x-forwarded-port", equalTo("443"))
                .build();
    }
}
