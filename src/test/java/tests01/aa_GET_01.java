package tests01;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class aa_GET_01 {
    String usersURL = "https://gorest.co.in/public-api/users";
    String taskURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test(description = "printing out body of the response")
    void test01(){
        Response response = RestAssured.get(usersURL);
        response.getBody().prettyPrint();
    }

    @Test(description = "CLASS TASK") //<<=========================
    void test011(){
        Response response = RestAssured.get(taskURL);
        response.getBody().prettyPrint();
    }

    @Test(description = "asserting that id is equal to expected")
    void test02(){
        given()
                .get(usersURL)
                .then()
                .body("data[0].id", equalTo(1));
    }

    @Test(description = "CLASS TASK") //<<=========================
    void test021(){
        given()
                .get(taskURL)
                .then()
                .body("data[0].name", equalTo("Selenium course"));
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
                .body("data.gender", hasItems("Female", "Male"))
        .log().body();
    }

    @Test(description = "CLASS TASK") //<<=========================
    void test051(){
        given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .body("data.name", hasItems("Java", "Apache POI"))
                .log().body();
    }

    @Test(description = "asserting if data.name properties has given names as a parameter")
    void test06(){
        given()
                .get(usersURL)
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .log().headers();
    }

    @Test(description = "CLASS TASK") //<<=========================
    void test061(){
        given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .header("Server", equalTo("Cowboy"))
                .cookie("connect.sid")
                .log().headers();
    }

    @Test(description = "CLASS TASK") //<<=========================
    void test062(){
        given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .cookies("Domain", equalTo("tla-school-api.herokuapp.com"))
                .log().cookies();
    }

    //PATH Parameters example

    @Test
    void test070(){
        given()
                .pathParam("resource", "users")
                .when()
                .get("https://gorest.co.in/public-api/{resource}")
                .then()
                .statusCode(200);
    }

    //PATH parameter using DataProvider

    String baseURL = "https://gorest.co.in/public-api";

    @DataProvider(name = "resourceData")
    public Object[] getResources(){
        return new String[] {"users", "posts", "comments", "todos", "categories", "products", "product-categories"};
    }

    @Test(dataProvider = "resourceData")
    void test071(String resource){
        given()
                .pathParam("resourceName", resource)
                .when()
                .get(baseURL + "/{resourceName}")
                .then()
                .statusCode(200)
                .log().headers();
    }

    //QUERY PARAM examples

    @Test(description = "inserting page=2 as a query parameter")
    void test080(){
        given()
                .queryParam("page", 2)
                .when()
                .get(usersURL)
                .then()
                .body("meta.pagination.page", equalTo(2))
        .log().body();
    }

    @Test(description = "CLASS TASK -> find course based on query param") // <<========================
    void test082(){
        given()
                .queryParam("name", "Java course")
                .get(taskURL)
                .then()
                .body("[0].name", equalTo("Java course"))
                .log().body();
    }

    @Test(description = "chaining query params")
    void test083(){
        given()
                .queryParam("name", new String[]{"Java course", "Java", "Selenium course"})
                .get(taskURL)
                .then()
                .body("data.name", hasItems("Java course", "Java", "Selenium course"))
                .log().body();
    }

    //todo
    @Test(description = "API Key example as a query param")
    void test090(){
//        given()
//                .get("https://tla-school-api.herokuapp.com/api/school/resources/students")
    }

    //todo
    @Test(description = "API Key example as a header param")
    void test091(){
//        given()
//                .get("https://tla-school-api.herokuapp.com/api/school/resources/students")
    }

    //todo
    @Test(description = "Bearer token example, get token using api and then using in request")
    void test10(){
//        given()
//                .get("https://tla-school-api.herokuapp.com/api/school/resources/students")
    }

}
