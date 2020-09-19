package workingWithJson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class classTask_jsonArray_Covid19 {
    public static void main(String[] args) {
        String s = "{\"data\": {\"paginationMeta\": {\"currentPage\": 1, \"currentPageSize\": 10, \"totalPages\": 22, \"totalRecords\": 220}, \"last_update\": \"Sep, 17 2020, 16:55, UTC\", \"rows\": [{\"country\": \"World\", \"country_abbreviation\": \"\", \"total_cases\": \"4,525,103\", \"new_cases\": \"3,077\", \"total_deaths\": \"303,351\", \"new_deaths\": \"269\", \"total_recovered\": \"1,703,742\", \"active_cases\": \"2,518,010\", \"serious_critical\": \"45,560\", \"cases_per_mill_pop\": \"581.0\", \"flag\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/International_Flag_of_Planet_Earth.svg/800px-International_Flag_of_Planet_Earth.svg.png\"}, {\"country\": \"USA\", \"country_abbreviation\": \"US\", \"total_cases\": \"1,457,593\", \"new_cases\": \"0\", \"total_deaths\": \"86,912\", \"new_deaths\": \"0\", \"total_recovered\": \"318,027\", \"active_cases\": \"1,052,654\", \"serious_critical\": \"16,240\", \"cases_per_mill_pop\": \"4,404.0\", \"flag\": \"https://www.worldometers.info/img/flags/us-flag.gif\"}, {\"country\": \"Spain\", \"country_abbreviation\": \"ES\", \"total_cases\": \"272,646\", \"new_cases\": \"0\", \"total_deaths\": \"27,321\", \"new_deaths\": \"0\", \"total_recovered\": \"186,480\", \"active_cases\": \"58,845\", \"serious_critical\": \"1,376\", \"cases_per_mill_pop\": \"5,831.0\", \"flag\": \"https://www.worldometers.info/img/flags/sp-flag.gif\"}, {\"country\": \"Russia\", \"country_abbreviation\": \"RU\", \"total_cases\": \"252,245\", \"new_cases\": \"0\", \"total_deaths\": \"2,305\", \"new_deaths\": \"0\", \"total_recovered\": \"53,530\", \"active_cases\": \"196,410\", \"serious_critical\": \"2,300\", \"cases_per_mill_pop\": \"1,728.0\", \"flag\": \"https://www.worldometers.info/img/flags/rs-flag.gif\"}, {\"country\": \"UK\", \"country_abbreviation\": \"GB\", \"total_cases\": \"233,151\", \"new_cases\": \"0\", \"total_deaths\": \"33,614\", \"new_deaths\": \"0\", \"total_recovered\": \"N/A\", \"active_cases\": \"199,193\", \"serious_critical\": \"1,559\", \"cases_per_mill_pop\": \"3,434.0\", \"flag\": \"https://www.worldometers.info/img/flags/uk-flag.gif\"}, {\"country\": \"Italy\", \"country_abbreviation\": \"IT\", \"total_cases\": \"223,096\", \"new_cases\": \"0\", \"total_deaths\": \"31,368\", \"new_deaths\": \"0\", \"total_recovered\": \"115,288\", \"active_cases\": \"76,440\", \"serious_critical\": \"855\", \"cases_per_mill_pop\": \"3,690.0\", \"flag\": \"https://www.worldometers.info/img/flags/it-flag.gif\"}, {\"country\": \"Brazil\", \"country_abbreviation\": \"BR\", \"total_cases\": \"203,165\", \"new_cases\": \"247\", \"total_deaths\": \"13,999\", \"new_deaths\": \"6\", \"total_recovered\": \"79,479\", \"active_cases\": \"109,687\", \"serious_critical\": \"8,318\", \"cases_per_mill_pop\": \"956.0\", \"flag\": \"https://www.worldometers.info/img/flags/br-flag.gif\"}, {\"country\": \"France\", \"country_abbreviation\": \"FR\", \"total_cases\": \"178,870\", \"new_cases\": \"0\", \"total_deaths\": \"27,425\", \"new_deaths\": \"0\", \"total_recovered\": \"59,605\", \"active_cases\": \"91,840\", \"serious_critical\": \"2,299\", \"cases_per_mill_pop\": \"2,740.0\", \"flag\": \"https://www.worldometers.info/img/flags/fr-flag.gif\"}, {\"country\": \"Germany\", \"country_abbreviation\": \"DE\", \"total_cases\": \"174,975\", \"new_cases\": \"0\", \"total_deaths\": \"7,928\", \"new_deaths\": \"0\", \"total_recovered\": \"150,300\", \"active_cases\": \"16,747\", \"serious_critical\": \"1,329\", \"cases_per_mill_pop\": \"2,088.0\", \"flag\": \"https://www.worldometers.info/img/flags/gm-flag.gif\"}, {\"country\": \"Turkey\", \"country_abbreviation\": \"TR\", \"total_cases\": \"144,749\", \"new_cases\": \"0\", \"total_deaths\": \"4,007\", \"new_deaths\": \"0\", \"total_recovered\": \"104,030\", \"active_cases\": \"36,712\", \"serious_critical\": \"963\", \"cases_per_mill_pop\": \"1,716.0\", \"flag\": \"https://www.worldometers.info/img/flags/tu-flag.gif\"}]}, \"status\": \"success\"}";

        JSONObject object = new JSONObject(s);
        List<String> list = new ArrayList<>();

        JSONObject dataObject = (JSONObject)object.get("data");
        JSONArray array = dataObject.getJSONArray("rows");

        for(int i = 0; i < array.length(); i++){
            list.add(array.getJSONObject(i).getString("country"));
        }

        list.forEach(item -> System.out.println(item));
    }
}
