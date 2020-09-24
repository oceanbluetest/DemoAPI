package tests01;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ac_PUT_01 {
    String usersURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test(description = "updating a course name and duration")
    void test01() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Java");
        map.put("duration", "3 months");

        JSONObject jsonObject = new JSONObject(map);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("name", "Java course 1")
                .body(jsonObject)
        .when()
                .put(usersURL)
        .then()
                .statusCode(200)
        .log().all();
    }

    @Test(description = "API Key example as a query param - test ID: 5f6d17992021da00172f7159")
    void test090(){
        JSONObject requestParameters = new JSONObject();
        requestParameters.put("firstName", "Olivia");
        requestParameters.put("lastName", "Stones");
        requestParameters.put("email", "oliviastone@email.com");
        requestParameters.put("batch", 2);

        given()
                .header("content-type", "application/json")
                .queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .pathParam("studentID", "5f6d17992021da00172f7159")
                .body(requestParameters)
                .when()
                .put("https://tla-school-api.herokuapp.com/api/school/resources/students/{studentID}")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(description = "API Key example as a header param - testID: 5f6d1a882021da00172f715a")
    void test091(){
        JSONObject requestParameters = new JSONObject();
        requestParameters.put("firstName", "James");
        requestParameters.put("lastName", "Cash");
        requestParameters.put("email", "jamesCash@gmail.com");

        given()
                .header("content-type", "application/json")
                .header("Authorization", "d03e989018msh7f4691c614e87a9p1a8181j")
                .pathParam("instructorID", "5f6d1a882021da00172f715a")
                .body(requestParameters)
                .when()
                .put("https://tla-school-api.herokuapp.com/api/school/resources/instructors/{instructorID}")
                .then()
                .statusCode(200)
                .log().body();
    }
}
