package workingWithJson;//import jdk.nashorn.internal.parser.JSONParser;  <- MAKE SURE NOT TO GET THIS IMPORT

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class a03_JsonFile {
    public static void main(String[] args) {
        System.out.println(readPropertyFromJsonFile("firstName", "basicJsonObject.json") + "\n");

        JSONArray jsonArray = readArrayFromJsonFile("results", "arrayJsonObject.json");
        for (Object jsonObject: jsonArray){
            JSONObject object = (JSONObject)jsonObject;
            System.out.println(object.get("name") + " | open now: " + ((JSONObject)object.get("plus_code")).get("global_code"));
        }
    }

    static String readPropertyFromJsonFile(String key, String fileName){
        String value = null;
        JSONParser parser = new JSONParser();
        try{
            Object object = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject)object;
            value = (String)jsonObject.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    static JSONArray readArrayFromJsonFile(String key, String fileName){
        JSONParser parser = new JSONParser();
        JSONArray array = new JSONArray();
        try{
            Object object = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject)object;
            array = (JSONArray)jsonObject.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return array;
    }
}
