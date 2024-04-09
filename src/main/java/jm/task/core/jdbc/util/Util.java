package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class Util {
    //    private static final String DB_URL = "jdbc:mysql://localhost:3306/users";
//    private static final String DB_NAME = "root";
//    private static final String DB_PASSWORD = "root";
    private static SessionFactory sessionFactory;

    public static SessionFactory getConnection() {

        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/users")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "root")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .addAnnotatedClass(User.class)
                    .setProperty("hibernate.c3p0.min_size","5")
                    .setProperty("hibernate.c3p0.max_size","200")
                    .setProperty("hibernate.c3p0.max_statements","200");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
//    public static Connection getConnection () {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
//            System.out.println("Соединение с БД установлено");
//        } catch (SQLException e) {
//            System.out.println("Не удалось подключиться к БД");
//        }
//        return conn;
//    }

}



