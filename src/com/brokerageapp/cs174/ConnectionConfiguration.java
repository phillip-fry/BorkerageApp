package com.brokerageapp.cs174;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ConnectionConfiguration {


    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CS174?autoReconnect=true&useSSL=false",
                                                    "root",
                                                    "21watermelon");

        } catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
