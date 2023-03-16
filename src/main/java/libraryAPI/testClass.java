package libraryAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshetty.PayLoad;
import rahulshetty.ResusableMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class testClass {
    @BeforeTest
    public void Base() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }
    //POST
    @Test(dataProvider = "BooksData")
    public void post(String isbn,String isle) {
        String response = given().log().all().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(Payload.addBook(isbn, isle)).
                when().post("Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
        JsonPath js = Payload.rawToJson(response); //for parsing Json
        String actMsg = js.getString("Msg");
        String expMsg = "successfully added";
        Assert.assertEquals(expMsg, actMsg);
    }

    @DataProvider(name = "BooksData")
    public Object[][] getData(){
        return new Object[][] {{"abcd4","1234"},{"abcd2","3456"},{"abcd5","4567"}};
    }

       // System.out.println(placeId);*/
//GET
        /*String getPlaceResponse=given().log().all()
                .queryParam("ID","bdsfcd22227")
                .when().get("Library/GetBook.php")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();*/
        /*JsonPath js1=ResusableMethods.rawToJson(getPlaceResponse);
        String actualAddress =js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAddress);*/


}
