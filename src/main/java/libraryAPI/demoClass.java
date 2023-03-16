package libraryAPI;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class demoClass {
    public static void main(String[] args){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "\n" +
                        "\"name\":\"Learn Appium Automation with Java\",\n" +
                        "\"isbn\":\"bqwecd\",\n" +
                        "\"aisle\":\"22745635\",\n" +
                        "\"author\":\"John gdffoe\"\n" +
                        "}\n").
                when().post("Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
    }
}
