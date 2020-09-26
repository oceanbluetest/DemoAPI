package step_defs;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import utils.ConfigReader;


public class CoursesSteps {
    TestContext testContext;

    public CoursesSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @Given("Resource {string} is up and running")
    public void resource_is_up_and_running(String resource) {
        testContext.request = RestAssured.given();
        testContext.request.basePath(ConfigReader.readProperty(resource.toLowerCase(), "src\\test\\resources\\properties\\env.properties"));
    }

}
