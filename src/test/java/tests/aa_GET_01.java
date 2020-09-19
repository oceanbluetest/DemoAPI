package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class aa_GET_01 {
    String usersURL = "https://gorest.co.in/public-api/users";

    @Test(description = "printing out body of the response")
    void test01(){
        Response response = RestAssured.get(usersURL);
        response.getBody().prettyPrint();
    }

    @Test(description = "asserting that id is equal to expected")
    void test02(){
        given()
                .get(usersURL)
                .then()
                .body("data[0].id", equalTo(15));
    }

    @Test(description = "asserting status code is 200")
    void test03(){
        given()
                .get(usersURL)
                .then()
                .statusCode(200);
    }

    @Test(description = "adding console log after assertion")
    void test04(){
        given()
                .get(usersURL)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(description = "asserting if data.name properties has given names as a parameter")
    void test05(){
        given()
                .get(usersURL)
                .then()
                .statusCode(200)
                .body("data.name", hasItems("Chandraayan Dhawan", "Ekaksh Sethi"))
        .log().body();
    }
}
