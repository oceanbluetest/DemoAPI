package tests01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ab_POST_01 {
    String usersURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    //NOTE: Creating json objects. Request body also called as a PAYLOAD

    @Test(description = "creating a json object using map and inserting in json object")
    void test01() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "CSS selectors");
        map.put("duration", "2 day");
        System.out.println(map);

        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
    }

    @Test(description = "creating a json object without using a map")
    void test02() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Apache POI");
        jsonObject.put("duration", "1 day");
        System.out.println(jsonObject);
    }

    @Test(description = "creating a json object from .json file, need to modify existing re-usable method in a03_JsonFile.class")
    void test020(){
        JSONObject object = JsonUtils.readBodyFromJsonFile("src\\test\\resources\\data\\sdetCourse.json");
        System.out.println(object.toString());
    }

    //NOTE: SENDING POST REQUESTS

    @Test(description = "sending a POST Request, if Serialization related exception appear, get jackson-databind dependency")
    void test03() {
        JSONObject requestParameters = new JSONObject();
        requestParameters.put("name", "Xpath selectors");
        requestParameters.put("duration", "2 days");

        given()
                .contentType("application/json")
                .body(requestParameters)
                .when()
                .post(usersURL)
                .then()
                .statusCode(200);
    }

    @Test(description = "header parameters")
    void test04() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Multiple windows");
        map.put("duration", "2 hours");

        JSONObject requestParameters = new JSONObject(map);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestParameters)
                .when()
                .post(usersURL)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(description = "POST request with variables")
    void test030(){
        RestAssured.baseURI = "https://tla-school-api.herokuapp.com/api/school/resources";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParameters = new JSONObject();
        requestParameters.put("firstName", "Anderson");
        requestParameters.put("lastName", "Cooper");
        requestParameters.put("email", "oliviastone@email.com");
        requestParameters.put("batch", 2);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j");
        httpRequest.body(requestParameters);

        Response response = httpRequest.request(Method.POST, "/students");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        int status = response.getStatusCode();
        System.out.println(status);
        Assert.assertEquals(status, 200);
    }

    @Test(description = "API Key example as a query param")
    void test090(){
        JSONObject requestParameters = new JSONObject();
        requestParameters.put("firstName", "James");
        requestParameters.put("lastName", "Cash");
        requestParameters.put("email", "oliviastone@email.com");
        requestParameters.put("batch", 2);

        given()
                .header("content-type", "application/json")
                .body(requestParameters)
                .when()
                .post("https://tla-school-api.herokuapp.com/api/school/resources/students")
                .then()
                .statusCode(200)
                .log().body();
    }

    //Class task
    @Test(description = "create an instructor")
    void test091(){
        JSONObject requestParameters = new JSONObject();
        requestParameters.put("firstName", "James");
        requestParameters.put("lastName", "Cash");
        requestParameters.put("email", "jamesCash@email.com");
        requestParameters.put("batch", 2);

        given()
                .header("content-type", "application/json")
                .body(requestParameters)
                .when()
                .post("https://tla-school-api.herokuapp.com/api/school/resources/instructors")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(description = "Bearer token example, get token using api in postman and then use in request")
    void test10(){
        String token = "2e93a51c1044d5e261dd2c08198f9a02d1cb00edb22a875c534e1589ff0f8e73";

        JSONObject requestParameters = new JSONObject();
        requestParameters.put("name", "Cameron Orange");
        requestParameters.put("gender", "Female");
        requestParameters.put("email", "orange@email.com");
        requestParameters.put("status", "Active");

        given()
                .header("Authorization", "Bearer " + token)
                .header("content-type", ContentType.JSON)
                .body(requestParameters)
                .when()
                .post("https://gorest.co.in/public-api/users")
                .then()
                .statusCode(200)
                .log().body();

    }



}
