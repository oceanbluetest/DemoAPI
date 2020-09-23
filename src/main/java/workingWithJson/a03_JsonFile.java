package workingWithJson;

//import jdk.nashorn.internal.parser.JSONParser;  <- MAKE SURE NOT TO GET THIS IMPORT
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class a03_JsonFile {
    public static void main(String[] args) {
        //NOTE: First demo without creating methods then refactor

        //NOTE: part 1 - getting property
        System.out.println(readPropertyFromJsonFile("firstName", "basicJsonObject.json") + "\n");

        //NOTE: part 2 - getting an array

        //Class Task: 1. Print out names of all schools 2. Print out names + global code of each school
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

    public static String readBodyFromJsonFile(String fileName){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try{
            Object object = parser.parse(new FileReader(fileName));
            jsonObject = (JSONObject)object;

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
