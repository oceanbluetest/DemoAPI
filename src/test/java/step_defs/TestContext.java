package step_defs;

import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {
    String s;
    Scenario scenario;
    RequestSpecification request;
    Response response;

    public void setBaseURI(){

    }
}
