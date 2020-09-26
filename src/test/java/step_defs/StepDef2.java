package step_defs;

import io.cucumber.java.en.Then;

public class StepDef2 {
    TestContext testContext;

    public StepDef2(TestContext testContext){
        this.testContext = testContext;
    }
    @Then("Sleep")
    public void sleep() {
        System.out.println(testContext.s);
    }
}
