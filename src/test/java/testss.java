import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
//import static org.apache.commons.codec.digest.UnixCrypt.body;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.*;

public class testss {
    @Test
    public void getTest() {
        given()
                .spec(RequestSpecTest.urlencodedSetupRequestSpecBuilder())
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .log().all()
                .get("/get")
                .then()
                .log().all()
                .spec(ResponseSpecTest.setupResponseSpecBuilder())
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test
    public void postRawTest() {
        given()
                .spec(RequestSpecTest.setupRequestSpecBuilder())
                .body("{\"test\": \"value\" \n}")
                .when()
                .log().all()
                .post("/post")
                .then()
                .log().all()
                .spec(ResponseSpecTest.setupResponseSpecBuilder())
                .body("data", equalTo("{\"test\": \"value\" \n}"));
    }

    @Test
    public void postFormDataTest() {
        given()
                .spec(RequestSpecTest.urlencodedSetupRequestSpecBuilder())
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .log().all()
                .post("/post")
                .then()
                .log().all()
                .spec(ResponseSpecTest.setupResponseSpecBuilder())
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putTest() {
        given()
                .spec(RequestSpecTest.setupRequestSpecBuilder())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .log().all()
                .put("/put")
                .then()
                .log().all()
                .spec(ResponseSpecTest.setupResponseSpecBuilder())
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void patchTest() {
        given()
                .spec(RequestSpecTest.setupRequestSpecBuilder())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .log().all()
                .patch("/patch")
                .then()
                .log().all()
                .spec(ResponseSpecTest.setupResponseSpecBuilder())
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void deleteTest() {
        given()
                .spec(RequestSpecTest.setupRequestSpecBuilder())
                .body("This is expected to be sent back as part of response body.")
                .when()
                .log().all()
                .delete("/delete")
                .then()
                .log().all()
                .spec(ResponseSpecTest.setupResponseSpecBuilder())
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}