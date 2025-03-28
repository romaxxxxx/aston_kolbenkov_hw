import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
//import static org.apache.commons.codec.digest.UnixCrypt.body;
import static org.hamcrest.Matchers.*;

public class EchoAPITests extends BaseTest {
    @Test
    public void getTest() {
        given()
                .spec(setupRequestSpec)
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .log().all()
                .get("/get")
                .then()
                .log().all()
                .spec(setupResponseSpec)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test
    public void postRawTest() {
        given()
                .spec(setupRequestSpec)
                .body("{\"test\": \"value\" \n}")
                .when()
                .log().all()
                .post("/post")
                .then()
                .log().all()
                .spec(setupResponseSpec)
                .body("data", equalTo("{\"test\": \"value\" \n}"));
    }

    @Test
    public void postFormDataTest() {
        given()
                .spec(urlencodedSetupSpec)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .log().all()
                .post("/post")
                .then()
                .log().all()
                .spec(setupResponseSpec)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putTest() {
        given()
                .spec(setupRequestSpec)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .log().all()
                .put("/put")
                .then()
                .log().all()
                .spec(setupResponseSpec)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void patchTest() {
        given()
                .spec(setupRequestSpec)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .log().all()
                .patch("/patch")
                .then()
                .log().all()
                .spec(setupResponseSpec)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void deleteTest() {
        given()
                .spec(setupRequestSpec)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .log().all()
                .delete("/delete")
                .then()
                .log().all()
                .spec(setupResponseSpec)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}