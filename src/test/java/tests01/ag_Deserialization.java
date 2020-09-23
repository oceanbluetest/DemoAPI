package tests01;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ag_Deserialization {

    //STORING SOME VALUES OF A RESPONSE IN A VARIABLE - aka PARSE JSON RESPONSE
    @Test(description = "Using Extract method")
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

    @Test(description = "CLASS TASK")
    void test011(){

    }

    //-------------------------------------------------------------

    @Test(description = "using JSON Path")
    void test02(){
        String companyName = given().get("https://jsonplaceholder.typicode.com/users/1").jsonPath().getString("company.name");
        System.out.println(companyName);
    }

    @Test(description = "get one property from list of properties")
    void test021(){
        String companyName = given().get("https://jsonplaceholder.typicode.com/users").jsonPath().getString("company.name[1]");
        System.out.println(companyName);
    }

    @Test(description = "CLASS TASK - print out all user names")
    void test022(){
        List<String> companyName = given().get("https://jsonplaceholder.typicode.com/users").jsonPath().getList("company.name");
        companyName.forEach(a -> System.out.println(a));
    }

    @Test(description = "objects inside the Json objects can be stored in a map")
    void test023(){
        Map<String, String> address = given().get("https://jsonplaceholder.typicode.com/users/1").jsonPath().getMap("address");
        System.out.println(address.get("suite"));
    }


}
