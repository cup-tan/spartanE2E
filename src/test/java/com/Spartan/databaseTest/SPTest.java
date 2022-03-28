package com.Spartan.databaseTest;

import com.Spartan.utilities.ConfigurationReader;
import com.Spartan.utilities.DataBaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class SPTest {


    String databaseUrl = ConfigurationReader.getProperty("spartan.database.url");
    String username = ConfigurationReader.getProperty("spartan.database.username");
    String password = ConfigurationReader.getProperty("spartan.database.password");
    String query = "select NAME from SPARTANS where SPARTAN_ID = 109";

//    Connection connection = DriverManager.getConnection(databaseUrl, username, password);
//    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//    ResultSet resultSet = statement.executeQuery(query);
//    ResultSetMetaData metaData = resultSet.getMetaData();



    public SPTest() throws SQLException {
    }


    @Test
    public void spartanData() throws SQLException {

        DataBaseUtil.createConnection(databaseUrl,username,password);
        ResultSet resultSet = DataBaseUtil.runQuery(query);
        if (resultSet.next()) {
            resultSet.getString("Name");
        }
    }
}