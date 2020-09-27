package __tests01;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ag_Deserialization {
    String taskURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    //NOTE: STORING SOME VALUES OF A RESPONSE IN A VARIABLE - aka PARSE JSON RESPONSE using <Extract> method
    @Test(description = "parse into a String")
    void test01(){
        String name = given()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("name");
        System.out.println("------------- " + name);
    }

    @Test(description = "extract method to get int")
    void test010(){
        int id = given()
                .get("https://gorest.co.in/public-api/users/4")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("data.id");
        System.out.println(id);
    }

    //Class task:
    @Test(description = "Get id of Selenium course")
    void test011(){
        List<String> name = given()
                .queryParam("name", "Selenium course")
                .get(taskURL)
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("data._id");
        System.out.println(name);
    }


    @Test(description = "Getting all id's of students")
    void test012(){
        List<String> id = given()
                .queryParam("firstName", "Donald")
                .get("https://tla-school-api.herokuapp.com/api/school/resources/students")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("data._id");
        id.forEach(i -> System.out.println(i));
    }

    //NOTE: PARSING USING .jsonPath() METHOD

    @Test(description = "using JSON Path")
    void test02(){
        String companyName = given()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .jsonPath()
                .getString("company.name");
        System.out.println(companyName);
    }

    @Test(description = "using JSON Path")
    void test020(){
        Response response = given()
                .get("https://jsonplaceholder.typicode.com/users/1");
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.get("company.name").toString());
    }

    @Test(description = "get one property from list of properties")
    void test021(){
        String companyName = given()
                .get("https://jsonplaceholder.typicode.com/users")
                .jsonPath()
                .getString("company.name[1]");
        System.out.println(companyName);
    }

    @Test(description = "get list of names")
    void test022(){
        List<String> companyName = given()
                .get("https://jsonplaceholder.typicode.com/users")
                .jsonPath()
                .getList("company.name");
        companyName.forEach(a -> System.out.println(a));
    }

    @Test(description = "objects inside the Json objects can be stored in a map")
    void test023(){
        Map<String, String> address = given()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .jsonPath()
                .getMap("address");
        System.out.println(address);
        System.out.println(address.get("suite"));
    }


}
