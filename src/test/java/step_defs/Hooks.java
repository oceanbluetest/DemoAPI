package step_defs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks{
    TestContext testContext;
    public static Scenario scenario;
    private RestAssured restAssured;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void beforeHook(Scenario scenario){
        this.scenario = scenario;
        testContext.scenario = scenario;
        RestAssured.baseURI = "https://tla-school-api.herokuapp.com/api/school";
    }
}
