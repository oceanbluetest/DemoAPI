import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class a02_JsonArray {
    public static void main(String[] args) {

        String user = "{" +
                "students: " +
                "[{firstName:John, lastName:Smith}, " +
                "{firstName:Adam, lastName:White}]" +
                "}";

        JSONObject object = new JSONObject(user);

        List<String> list = new ArrayList<>();

        JSONArray array = object.getJSONArray("students");
        for(int i = 0; i < array.length(); i++){
            list.add(array.getJSONObject(i).getString("firstName"));
        }

        list.forEach(item -> System.out.println(item));
    }

}
