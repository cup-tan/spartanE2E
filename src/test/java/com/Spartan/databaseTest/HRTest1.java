package com.Spartan.databaseTest;

import com.Spartan.utilities.DataBaseUtil;

import java.sql.*;

public class HRTest1 {
    public static void main(String[] args) throws SQLException {


        String connURL = "jdbc:oracle:thin:@35.172.118.223:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connectionDB = DriverManager.getConnection(connURL, username, password);
        Statement statement = connectionDB.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM COUNTRIES");
//        resultSet.next();
//        System.out.println(resultSet.getString(1));
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + "\t");
            System.out.print(resultSet.getString(2)+ "\t");
            System.out.println(resultSet.getString(3));
        }

        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println("metaData.getColumnName(3) = " + metaData.getColumnName(3));
        System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());

    }
}
