package dao.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {

    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/clinicaodonto", "clinica", "odonto");
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}