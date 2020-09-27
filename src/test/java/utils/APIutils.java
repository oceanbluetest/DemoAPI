package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import step_defs.TestContext;

public class APIutils {
    TestContext TC;

    public APIutils(TestContext testContext){
        this.TC = testContext;
    }

    public static String printPrettyJSONObject(String jsonString){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        return gson.toJson(jsonElement);
    }
}
