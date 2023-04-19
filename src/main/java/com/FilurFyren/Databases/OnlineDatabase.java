package com.FilurFyren.Databases;

import com.FilurFyren.Connection.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineDatabase {
    Connection dbConnection;
    Scanner scanner;
    String host = getConfig("HOST");
    String port = getConfig("PORT");;
    String database = getConfig("DATABASE");
    String cp = getConfig("CP");
    String username = getConfig("USER");
    String password = getConfig("PASSWORD");
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?characterEncoding=" + cp;

    private String getConfig(String s){
        return Config.get().getConfig(s);
    }

    public OnlineDatabase() {
        dbConnection = getConnection(url, username, password);
        scanner = new Scanner(System.in, "CP850");
    }
    public Connection getConnection(String url, String username, String password){
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        }catch (Exception e){
            System.out.println("Connection failed");
        }
        return null;
    }
    public ResultSet manipulate(String command){
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            return resultSet;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
