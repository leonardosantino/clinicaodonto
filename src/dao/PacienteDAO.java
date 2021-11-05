package dao;

import model.Paciente;
import service.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public List<Paciente> selectAll(){

        List<Paciente> pacientes = new ArrayList<>();

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement selectAll = connection.prepareStatement("SELECT * FROM paciente");
            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()){

                Paciente paciente = new Paciente(resultSet.getInt("id"),resultSet.getString("nome"), resultSet.getString("sobrenome"), resultSet.getString("rg"), resultSet.getString("endereco"), resultSet.getDate("dataDeAlta"));

                pacientes.add(paciente);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return pacientes;
    }

    public Paciente getById(Integer id){

        Paciente paciente = null;

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement getById = connection.prepareStatement("SELECT * FROM paciente Where id = ?");

            getById.setInt(1, id);

            ResultSet resultSet = getById.executeQuery();

            if (resultSet.next()){
                paciente = new Paciente(resultSet.getInt("id"),resultSet.getString("nome"), resultSet.getString("sobrenome"), resultSet.getString("rg"), resultSet.getString("endereco"), resultSet.getDate("dataDeAlta"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return paciente;
    }
}
