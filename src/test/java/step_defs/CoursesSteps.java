package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.testng.Assert;
import utils.APIutils;
import utils.ConfigReader;
import utils.JsonUtils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CoursesSteps {
    TestContext TC;

    public CoursesSteps(TestContext testContext){
        this.TC = testContext;
    }

    @Given("Resource {string} is up and running")
    public void resource_is_up_and_running(String resource) {
        TC.request = RestAssured.given();
        TC.request.basePath(ConfigReader.readProperty(resource.toLowerCase(), "src\\test\\resources\\properties\\env.properties"));
    }

    @When("I send GET request using query parameter {string} equal to {string}")
    public void iSendGETRequestUsingQueryParameterEqualTo(String key, String value) {
        TC.response = TC.request
                .queryParam(key, value)
                .get();
    }

    @Then("Response code should be {int}")
    public void responseCodeShouldBe(int statusCode) {
        Assert.assertEquals(TC.getStatusCode(), statusCode);
        assertThat(TC.getStatusCode(), is(statusCode));
    }

    @Then("Print out and log the response body")
    public void printOutAndLogTheResponseBody() {
        TC.response
                .body().prettyPrint();
        TC.scenario.log(TC.getResponseBody());
    }

    @Then("Validate JsonSchema matches to {string} file")
    public void validateJsonSchemaMatchesToFile(String fileName) {
        assertThat(TC.getResponseBody(), matchesJsonSchemaInClasspath("data/jsonSchema/" + fileName));
        TC.scenario.log("RESPONSE BODY\n" + TC.response.body().prettyPrint());
        TC.scenario.log("JSON SCHEMA\n" + APIutils.printPrettyJSONObject(JsonUtils.readStringBodyFromJsonFile("src\\test\\resources\\data\\jsonSchema\\" + fileName)));
    }
}
