package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Used for connect to database
public class DatabaseConnection {
    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/BOOKING?useUnicode=true&serverTimezone=UTC&useSSL=false";
        String dbUsername = "root";
        String dbPassword = "1234";
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL,
                dbUsername,
                dbPassword);
        return con;
    }
}