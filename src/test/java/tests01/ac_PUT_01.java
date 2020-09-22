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
}
