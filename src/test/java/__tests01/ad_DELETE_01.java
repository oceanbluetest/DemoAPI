package __tests01;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ad_DELETE_01 {
    String usersURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test(description = "deleting a course")
    void test01() {
        given()
                .queryParam("name", "Java course 1")
        .when()
                .delete(usersURL)
        .then()
                .statusCode(200)
        .log().all();
    }
}
