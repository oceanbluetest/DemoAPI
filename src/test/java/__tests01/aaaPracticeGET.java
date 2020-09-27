package __tests01;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class aaaPracticeGET {

    @Test(description = "resource: https://maps.googleapis.com/maps/api/place/nearbysearch/json")
    void practice(){
        given()
                .queryParam("location", "38.890759,-77.084747")
                .queryParam("radius", 1500)
                .queryParam("type", "school")
                .queryParam("key", "AIzaSyBmD8Ckoo9j1-VN2O93BY5MlTxSKxp6RAg")
        .when()
                .get("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
        .then()
                .statusCode(200)
                .body("results.name", hasItems("Strayer University", "Emerging Scholars"))
                .log().body();
    }
}
