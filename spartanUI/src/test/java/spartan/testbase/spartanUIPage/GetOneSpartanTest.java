package spartan.testbase.spartanUIPage;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spartan.utilities.ConfigurationReader;
import spartan.utilities.Driver;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetOneSpartanTest {
     WebDriver driver = Driver.getDriver();
  Response response;
  int spartanId;



    @BeforeMethod
    public void setUp(){
        driver.get(ConfigurationReader.getProperty("spartan.base_url"));
        driver.manage().window().maximize();

    }
//    @AfterMethod
//    public  void tearDown(){
//
//        driver.quit();
//    }

    @Test
    public void getSpartanTest(){

        String payLoad = "{\n" +
                "    \"name\" : \"Sari\",\n" +
                "    \"gender\" : \"Male\",\n" +
                "    \"phone\"  : 12334525454\n" +
                "}";

        response =
                given()    .log().all()
                        .contentType(ContentType.JSON)
                        .auth().basic("admin","admin")
                        .body(payLoad).
                        when()
                        .post(ConfigurationReader.getProperty("baseURI")+
                                ConfigurationReader.getProperty("basePath")+
                                "/spartans").

                        then()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .assertThat()
                        .statusCode(is(201)).extract().response();

        String actualName =  response.prettyPeek().jsonPath().getString("data.name");
        String expectedName = "Sari"    ;

        assertThat(actualName, is(expectedName));
        spartanId = response.jsonPath().getInt("data.id");
        System.out.println("spartanId = " + spartanId);

    }
}
