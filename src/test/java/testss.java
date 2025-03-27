import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testss {

    @Test
    public void APItests() {
        System.out.println("555");
        given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
    }
}

                //.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");




                //.baseUri("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                //.param("foo1","bar1")
                //.param("foo2","bar2")
//                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
//                .then()
//                .time(lessThan(5000L));
//                .body("foo1", equalTo("bar1"));





//                .when()
//                .log().all()
//                .spec(RequestSpecTest.requestSpec)
//                                .param("foo1","bar1")
//                .param("foo2","bar2")
//                .get("/get")
//                .then()
//                .spec(ResponseSpecTest.responseSpec)
//                .body("foo1", equalTo("bar1"));
//    }
//}
