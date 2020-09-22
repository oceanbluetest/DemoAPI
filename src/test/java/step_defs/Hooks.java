package step_defs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Hooks {
    RequestSpecification reqSpec;
    Response response;
    Scenario scenario;

    @Before
    public void beforeHook(Scenario scenario){
        this.scenario = scenario;
    }
}
