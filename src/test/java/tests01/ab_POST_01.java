package tests01;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ab_POST_01 {
    String usersURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test(description = "creating a json object using map and inserting in json object")
    void test01() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "CSS selectors");
        map.put("duration", "2 day");
        System.out.println(map);

        /*
        Need json library to convert map into json format
        get Gson dependency from google
         */
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

    @Test(description = "sending a POST Request, if Serialization related exception appear, get jackson-databind dependency")
    void test03() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Xpath selectors");
        jsonObject.put("duration", "2 days");

        given()
                .contentType("application/json")
                .body(jsonObject)
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

        JSONObject jsonObject = new JSONObject(map);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject)
                .when()
                .post(usersURL)
                .then()
                .statusCode(200)
                .log().body();
    }


}
