package __tests01;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ae_DataDriven_01 {
    String usersURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @DataProvider(name = "userData")
    public Object[][] userData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "Synchronization";
        data[0][1] = "1 day";
        data[1][0] = "iFrames";
        data[1][1] = "2 hours";
        return data;
    }

    @Test(dataProvider = "userData", description = "POST request using DataProvider")
    void testPOST01(String name, String duration) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("duration", duration);

        given()
                .contentType(ContentType.JSON)
                .body(jsonObject)
                .when()
                .post(usersURL)
                .then()
                .statusCode(201)
                .log().all();
    }

    @DataProvider(name = "userData2")
    public Object[][] userData2(){
       return new Object[][]{
               {"Selenium Alerts", "30 min" },
               {"Action class", "1 hour"}
       };
    }

    @Test(dataProvider = "userData2", description = "POST request using DataProvider")
    void testPOST02(String name, String duration) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("duration", duration);

        given()
                .contentType(ContentType.JSON)
                .body(jsonObject)
                .when()
                .post(usersURL)
                .then()
                .statusCode(201)
                .log().all();
    }

    @DataProvider(name = "dataToDelete")
    public Object[] userDataForDelete(){
        return new Object[]{
                "Synchronization", "iFrames", "Selenium Alerts", "Action class"
        };
    }

    @Test(dataProvider = "dataToDelete", description = "deleting courses from DataProvider")
    void testDELETE01(String courseName) {
        given()
                .queryParam("name", courseName)
                .when()
                .delete(usersURL)
                .then()
                .statusCode(204)
                .log().all();
    }
}
