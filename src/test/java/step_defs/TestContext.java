package step_defs;

import io.cucumber.java.Scenario;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class TestContext {
     Scenario scenario;

     RequestSpecification request;
     Response response;

     Headers headers;
     JSONObject jsonObject;

     public int getStatusCode(){
          return response
                  .getStatusCode();
     }

     public String getResponseBody(){
          return response.getBody().asString();
     }


}
