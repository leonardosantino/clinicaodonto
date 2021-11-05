package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static Connection getConnection(){

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/clinicaodonto", "clinica", "odonto");
            System.out.println("Conectado ao DB com Sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

}