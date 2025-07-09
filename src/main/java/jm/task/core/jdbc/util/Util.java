package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // set up a database connection
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/example_schema";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Hong30042002@";

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure() // Loads hibernate.properties or hibernate.cfg.xml (if present)
                    .addAnnotatedClass(User.class) // Register User entity
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // JDBC Connection (kept for backward compatibility if needed)
    public static Connection getJDBCConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static Connection getConnection() {
        return null;
    }
}
