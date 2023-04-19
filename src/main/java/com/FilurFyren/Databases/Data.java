package com.FilurFyren.Databases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class Data {


    private static Data data;
    private OnlineDatabase database;
    Data(){
        database = new OnlineDatabase();
    }

    public static Data get(){
        if(data == null) data = new Data();
        return data;
    }

    public void execCommand(String command){
        database.manipulate(command);
    }
    public ArrayList<ArrayList<String>> getTable(String table){
        ResultSet resultSet = database.manipulate("SELECT * FROM " + table);
        try{
            ArrayList<ArrayList<String>> toReturn = new ArrayList<>();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            ArrayList<String> firstLine = new ArrayList<>();
            for(int i = 1; i <= columnCount; i++){
                firstLine.add(resultSetMetaData.getColumnName(i));
            }
            toReturn.add(firstLine);

            resultSet.beforeFirst();
            while (resultSet.next()){
                ArrayList<String> tableLines = new ArrayList<>();
                for(int i = 1; i <= columnCount; i++){
                    if(resultSet.getString(i) == null) tableLines.add("null");
                    else tableLines.add(resultSet.getString(i));
                }
                toReturn.add(tableLines);
            }
            return toReturn;
        }catch (Exception e){
            System.out.println("Command Failed");
            e.getCause();
            ArrayList<ArrayList<String>> failed = new ArrayList<>();
            ArrayList<String> firstLine = new ArrayList<>();
            firstLine.add("ERROR:" + e.getMessage());
            failed.add(firstLine);
            return failed;
        }
    }



}
