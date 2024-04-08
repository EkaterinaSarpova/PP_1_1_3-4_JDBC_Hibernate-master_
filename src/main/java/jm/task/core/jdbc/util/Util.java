package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/users";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnection () {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            System.out.println("Соединение с БД установлено");
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к БД");
        }
        return conn;
    }

}



