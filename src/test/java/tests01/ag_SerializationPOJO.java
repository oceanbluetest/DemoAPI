package tests01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import tests01.pojo.Student;

public class ag_SerializationPOJO {

    @Test
    void test01(){
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("jdoe@aa.com");
        student.setBatch(3);

        RestAssured.baseURI = "https://tla-school-api.herokuapp.com/api/school/resources/students";
        RequestSpecification request = RestAssured.given();
        request.queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .post()
                .then()
                .log().body();
    }
}
