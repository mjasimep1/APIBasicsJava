package libraryAPI;

import io.restassured.path.json.JsonPath;

public class Payload {
public static String addBook(String isbn, String aisle){
    String postString="{\n" +
            "\n" +
            "\"name\":\"Learn Appium Automation with Java\",\n" +
            "\"isbn\":\""+isbn+"\",\n" +
            "\"aisle\":\""+aisle+"\",\n" +
            "\"author\":\"retwtre\"\n" +
            "}";
    return postString;
}
    public static JsonPath rawToJson(String response){
        JsonPath js=new JsonPath(response);
        return js;
    }
}
