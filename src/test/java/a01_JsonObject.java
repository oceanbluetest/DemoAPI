import org.json.JSONObject;

public class a01_JsonObject {
    public static void main(String[] args) {
        String s = "{\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"The Hon. Akshita Singh\",\n" +
                "        \"email\": \"hon_the_singh_akshita@predovic.com\",\n" +
                "        \"gender\": \"Male\",\n" +
                "        \"status\": \"Active\",\n" +
                "        \"created_at\": \"2020-09-11T03:50:03.870+05:30\",\n" +
                "        \"updated_at\": \"2020-09-11T03:50:03.870+05:30\"\n" +
                "    }";

        JSONObject object = new JSONObject(s);

        System.out.println(object.getInt("id"));
        System.out.println(object.getString("name"));
        System.out.println("---------------");

        for(String key: object.keySet()){
            System.out.println(key + " : " + object.optString(key));
        }

    }
}
