package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks{
    TestContext testContext;
    public static final Logger logger = LogManager.getLogger("Log");

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void beforeHook(Scenario scenario){
        testContext.scenario = scenario;
        RestAssured.baseURI = "https://tla-school-api.herokuapp.com/api/school";
        logger.info("Startring Scenario -----------------");
    }

    @After
    public void tearDown(){
        logger.info("Ending Scenario ---------------------");
    }
}
