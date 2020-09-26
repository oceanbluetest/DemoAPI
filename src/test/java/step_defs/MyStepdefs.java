package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs{
    TestContext testContext;

    public MyStepdefs(TestContext testContext){
        this.testContext = testContext;
    }

    @Given("Run")
    public void run() {
        Hooks.scenario.log("Test message");
        testContext.s = "Run step";
    }

    @When("Jump")
    public void jump() {
        System.out.println(testContext.s);
        testContext.s = "Jump now";
    }


    @And("I make {string}")
    public void iMake(String arg0) {
        testContext.s = arg0;
        testContext.scenario.log(arg0);
    }
}
