package tests01;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
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

    //Class task
    @Test(description = "print out body")
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

    //Class task
    @Test(description = "validate name")
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

    @Test(description = "asserting if data.name properties has given multiple names")
    void test05(){
        given()
                .get(usersURL)
                .then()
                .statusCode(200)
                .body("data.gender", hasItems("Female", "Male"))
        .log().body();
    }

    //Class task
    @Test(description = "Validate multiple fields")
    void test051(){
        given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .body("data.name", hasItems("Java", "Apache POI"))
                .log().body();
    }

    //NOTE: WORKING WITH HEADERS

    @Test(description = "asserting header's content-type")
    void test06(){
        given()
                .get(usersURL)
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .log().headers();
    }

    //Class task
    @Test(description = "Check response server is Cowboy")
    void test061(){
        given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .header("Server", "Cowboy")
                .log().headers();
    }

    @Test(description = "extracting a header")
    void test0610(){
        Headers headers = given()
                .get(taskURL)
                .getHeaders();

        System.out.println(headers.get("Connection"));
        System.out.println(headers.get("Date"));
    }

    //NOTE: WORKING WITH COOKIES

    @Test(description = "Check if cookie contains property connect.sid")
    void test062(){
        given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .cookie("connect.sid")
                .log().headers();
    }

    @Test(description = "Getting Cookie details ")
    void test063(){
        Cookie cookie = given()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .extract()
                .detailedCookie("__cfduid");

        System.out.println(cookie.getDomain());
        System.out.println(cookie.getValue());
        System.out.println(cookie.getExpiryDate());
    }

    //Class Task
    @Test(description = "print out ")
    void test064(){
        Headers headers = given().get(taskURL).getHeaders();
        Cookie cookie = given().get(taskURL).then().extract().detailedCookie("connect.sid");

        System.out.println(headers.get("etag"));
        System.out.println(headers.get("content-type"));

        System.out.println(cookie.getValue());
        System.out.println(cookie.isSecured());
    }

    //NOTE: PATH Parameters example

    @Test(description = "pathParam name should be inserted in .get method in {} braces")
    void test070(){
        given()
                .pathParam("resource", "users")
                .when()
                .get("https://gorest.co.in/public-api/{resource}")
                .then()
                .statusCode(200);
    }

    //NOTE: PATH parameter using DataProvider

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

    //Class task - resource: https://jsonplaceholder.typicode.com
    @DataProvider(name = "taskPathParam")
    public Object[] taskPathParam(){
        return new String[] {"posts", "comments", "albums", "photos", "todos", "users"};
    }

    @Test(dataProvider = "taskPathParam")
    void test072(String resource){
        given()
                .pathParam("paramName", resource)
                .when()
                .get("https://jsonplaceholder.typicode.com/{paramName}")
                .then()
                .statusCode(200)
                .log().headers();
    }


    //NOTE: QUERY PARAM examples

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

    //Class task
    @Test(description = "Find course based on query param")
    void test082(){
        given()
                .queryParam("name", "Java course")
                .get(taskURL)
                .then()
                .body("data[0].name", equalTo("Java course"))
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





}
