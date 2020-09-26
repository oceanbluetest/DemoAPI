package tests01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
This form of writing api Requests are needed to implement with Cucumber BDD
 */
public class af_RequestsWithReqSpec {
    String baseUri = "https://gorest.co.in/public-api";

    @Test
    void test01(){
        RequestSpecification requestSpecification = given().baseUri(baseUri);
        Response response = requestSpecification.when().get("/users");
        ValidatableResponse valResponse = response.then();
        valResponse.assertThat().body("data[0].id", equalTo(4));
    }

    @Test
    void testttt(){
        baseURI = "https://tla-school-api.herokuapp.com/api/school/departments";
        basePath = "/gettoken";
        authentication = basic("user", "user123");

        given()
                .get()
                .then()
                .statusCode(200)
                .log()
                .body();
    }
}
