package spartan.testbase.spartanCRUD;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spartan.basepage.SpartanHomePage;
import spartan.basepage.SpartanUIPage;
import spartan.testbase.BaseTest;
import spartan.utilities.ConfigurationReader;
import spartan.utilities.Driver;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpartanHappyPath extends BaseTest {
    String actualName;
    int spartanId;
    SpartanUIPage spartanUIPage = new SpartanUIPage();
    SpartanHomePage spartanHomePage = new SpartanHomePage();


    @Test
    public void postCreateSpartanData() {
        String payload = "{\n" +
                "    \"name\":\"Gigi\",\n" +
                "    \"gender\":\"Female\",\n" +
                "    \"phone\" :1243533451\n" +
                "}";
        Response response =
                given()
                        .log().all()
                        .auth().basic("admin","admin")
                        .contentType(ContentType.JSON)
                        .body(payload).
                when()
                        .post(ConfigurationReader.getProperty("baseURI") +
                                ConfigurationReader.getProperty("basePath") + "/spartans").
                then()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .assertThat()
                        .statusCode(is(201)).extract().response();

        actualName = response.jsonPath().getString("data.name");
        String expectedName = "Gigi";
        assertThat(actualName, is(expectedName));

        spartanId = response.jsonPath().getInt("data.id");
        System.out.println("spartanId = " + spartanId);




    }
    @Test
    public void verifyUICreatedSpartan(){
        spartanHomePage.getWebDataButton().click();
      //List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='myTable']//tr//td[2]"));
      List<WebElement> allNames = spartanUIPage.getAllSpartanNames();
for (WebElement eachSpartanName : allNames){
    System.out.println("eachSpartanName = " + eachSpartanName.getText());
    assertThat(actualName,is(eachSpartanName.getText()));
}
    }

    @Test
    public void getReadSpartan(){

}

    }




