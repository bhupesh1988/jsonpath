import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
        //RestAssured.basePath="todos/29";


    }

    @Test
    public void todos(){

               Response response = given()
                       .basePath("todos/29")
                       .when().get( );
               System.out.println(response.body().asString());
               Assert.assertEquals(200,response.statusCode());
        JsonPath responseJson = response.getBody().jsonPath();
        Assert.assertEquals("laborum aut in quam",responseJson.getString("title"));
        Assert.assertEquals("false",responseJson.getString("completed"));
    }
    @Test
    public void users(){
        Response response = given()
                .basePath("users/5")
                .when().get( );
        System.out.println(response.body().asString());
        JsonPath responseJson = response.getBody().jsonPath();
        Assert.assertEquals("Chelsey Dietrich",responseJson.getString("name"));
        Assert.assertEquals("Skiles Walks",responseJson.getString("address.street"));
        Assert.assertEquals("-31.8129",responseJson.getString("address.geo.lat"));
        Assert.assertEquals("User-centric fault-tolerant solution",responseJson.getString("company.catchPhrase"));
    }
    @Test
    public void post(){
        Response response = given()
                .basePath("posts/15")
                .when().get( );
        System.out.println(response.body().asString());
        JsonPath responseJson = response.getBody().jsonPath();
        Assert.assertEquals("2",responseJson.getString("userId"));
        Assert.assertEquals("eveniet quod temporibus",responseJson.getString("title"));


    }

}
