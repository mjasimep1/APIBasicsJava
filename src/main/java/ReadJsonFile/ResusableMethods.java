package ReadJsonFile;

import io.restassured.path.json.JsonPath;

public class ResusableMethods {
    public static JsonPath rawToJson(String response){
        JsonPath js=new JsonPath(response);
        return js;
    }
}
