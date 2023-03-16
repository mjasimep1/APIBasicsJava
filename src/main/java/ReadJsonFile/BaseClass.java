package ReadJsonFile;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class BaseClass {

    @Test()
    public void post() throws IOException {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\artdsktp44user\\Desktop\\AddPlace.txt")))).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
        System.out.println(response);
        JsonPath js = ResusableMethods.rawToJson(response); //for parsing Json
        String placeId = js.getString("place_id");
        System.out.println(placeId);
    }
}

