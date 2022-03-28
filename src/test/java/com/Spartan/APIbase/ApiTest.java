package com.Spartan.APIbase;

import com.Spartan.utilities.ConfigurationReader;
import com.Spartan.utilities.DataBaseUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;

import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import  static org.hamcrest.MatcherAssert.*;

public class ApiTest {
    static int spartanId;
    static Response response;
    String databaseUrl = ConfigurationReader.getProperty("spartan.database.url");
    String username = ConfigurationReader.getProperty("spartan.database.username");
    String password = ConfigurationReader.getProperty("spartan.database.password");
    String query = "select NAME from SPARTANS where SPARTAN_ID = "+spartanId;

 @BeforeAll
 public static void setUp(){
   baseURI ="http://35.172.118.223:8000";
   basePath ="/api";
 }
 @AfterAll
 public static void tearDown(){
     reset();
 }

 @Test
 public void  acreateOneSpartan(){

     String payLoad = "{\n" +
             "    \"name\" : \"Maya\",\n" +
             "    \"gender\" : \"Female\",\n" +
             "    \"phone\"  : 1233452210\n" +
             "}";

     response =
     given()    .log().all()
             .contentType(ContentType.JSON)
             .auth().basic("admin","admin")
             .body(payLoad).
     when()
             .post("/spartans").

     then()
             .log().all()
             .contentType(ContentType.JSON)
             .assertThat()
             .statusCode(is(201)).extract().response();

   String actualName =  response.prettyPeek().jsonPath().getString("data.name");
    String expectedName = "Maya"    ;

     assertThat(actualName, is(expectedName));
     spartanId = response.jsonPath().getInt("data.id");
     System.out.println("spartanId = " + spartanId);
 }


 @Test
 public void bgetSpartan() throws SQLException {


     response =
     given()
             .log().all()
             .accept(ContentType.JSON)
             .pathParam("id",spartanId).
     when()
             .get("/spartans/{id}").
     then()
             .log().all()
             .assertThat()
             .statusCode(is(200))
             .contentType(ContentType.JSON).extract().response();


     String actualSpartanName = response.jsonPath().getString("name");
     String expectedSpartanName = "Maya";
     assertThat(actualSpartanName, is(expectedSpartanName));


     DataBaseUtil.createConnection(databaseUrl,username,password);
     System.out.println("query = " + query);
     ResultSet resultSet = DataBaseUtil.runQuery(query);
     if (resultSet.next()) {
         String actualName = resultSet.getString("Name");
         String expectedName = "Maya";

         assertThat(expectedName,is(actualName));
     }


 }





}
