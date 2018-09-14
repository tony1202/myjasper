package com.tony.jasper.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Auther: tony
 * @Date: 2018/9/13
 * @Description:
 */
public class MysqlJDBC {

    private final static String url = "jdbc:mysql://localhost:3306/jasper";
    private final static String username = "root";
    private final static String password = "123456";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

