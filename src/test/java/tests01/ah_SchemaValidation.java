package tests01;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ah_SchemaValidation {
    @Test
    void test01(){
        String responseBody = given()
                .queryParam("name", "Selenium course")
                .get("https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse")
                .body().asString();
        System.out.println(responseBody);

        assertThat(responseBody, matchesJsonSchemaInClasspath("./data/sdetCourse.json"));

    }

    @Test
    void test02(){
        given()
                .queryParam("name","Java course")
                .get("https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse")
                .then()
                .body(matchesJsonSchemaInClasspath("./data/sdetCourse.json"));
    }
}
