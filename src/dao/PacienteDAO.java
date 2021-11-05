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

    public Paciente insert(String nome, String sobrenome, String rg, String endereco, String dataDeAlta){

        Paciente paciente = null;
        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT INTO paciente (nome, sobrenome, rg, endereco, dataDeAlta) VALUES (?, ?, ?, ?, ?)");

            insert.setString(1, nome);
            insert.setString(2, sobrenome);
            insert.setString(3, rg);
            insert.setString(4, endereco);
            insert.setString(5, dataDeAlta);

            Integer rowsAffect = insert.executeUpdate();
            System.out.println("Adicionado com sucesso - " + "Nome:  " + nome + " Sobrenome:  " + sobrenome + " Linha: " + rowsAffect);
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    public void delete(Integer id){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement delete = connection.prepareStatement(" DELETE FROM paciente WHERE id = ?");

            delete.setInt(1, id);

            Integer rowsAffect = delete.executeUpdate();
            System.out.println("Deletado com sucesso -" + "ID: " + id + " Linhas afetadas: " + rowsAffect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateName(Integer id, String nome){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE paciente SET nome=? WHERE id=? ");

            update.setString(1, nome);
            update.setInt(2, id);

            Integer rowsAffect = update.executeUpdate();
            System.out.println("Atualizado com sucesso - " + "ID: " + id + " Nome: " + nome + " Linhas Afetadas: " + rowsAffect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateSobrenome(Integer id, String sobrenome){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE paciente SET sobrenome=? WHERE id=? ");

            update.setString(1, sobrenome);
            update.setInt(2, id);

            Integer rowsAffect = update.executeUpdate();
            System.out.println("Atualizado com sucesso - " + "ID: " + id + " Sobrenome: " + sobrenome + " Linhas Afetadas: " + rowsAffect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateRg(Integer id, String rg){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE paciente SET rg=? WHERE id=? ");

            update.setString(1, rg);
            update.setInt(2, id);

            Integer rowsAffect = update.executeUpdate();
            System.out.println("Atualizado com sucesso - " + "ID: " + id + " RG: " + rg + " Linhas Afetadas: " + rowsAffect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateDataDeAlta(Integer id, String dataDeAlta){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE paciente SET dataDeAlta=? WHERE id=? ");

            update.setString(1, dataDeAlta);
            update.setInt(2, id);

            Integer rowsAffect = update.executeUpdate();
            System.out.println("Atualizado com sucesso - " + "ID: " + id + " Data de Alta: " + dataDeAlta + " Linhas Afetadas: " + rowsAffect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
