package dao;

import model.Endereco;
import model.Paciente;
import service.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacienteDAO {

    public void insert(String nome, String sobrenome, String rg, String datadecadastro){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT INTO pacientes (nome, sobrenome, rg, datadecadastro) VALUES (?, ?, ?, ?)");

            insert.setString(1, nome);
            insert.setString(2, sobrenome);
            insert.setString(3, rg);
            insert.setString(4, datadecadastro);

            Integer rowsAffect = insert.executeUpdate();
            System.out.println("Paciente adicionado" + " | Nome: " + nome + " | Sobrenome: " + sobrenome + " | RG: " + rg + " | Data de Cadastro: " + datadecadastro + " | Linhas afetadas: " + rowsAffect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectAll(){

        Paciente paciente;
        Endereco endereco;
        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement selectAll = connection.prepareStatement("SELECT * FROM pacientes INNER JOIN enderecos ON pacientes.id_paciente = enderecos.fk_paciente_endereco");

            ResultSet resultSet = selectAll.executeQuery();
            while (resultSet.next()){
                paciente = new Paciente(resultSet.getInt("id_paciente"), resultSet.getString("nome"), resultSet.getString("sobrenome"), resultSet.getString("rg"), resultSet.getDate("datadecadastro"));
                endereco = new Endereco(resultSet.getInt("id_endereco"),resultSet.getString("rua"), resultSet.getString("numero"), resultSet.getString("cidade"), resultSet.getString("estado"));
                System.out.println("Paciente" + " | Nome: " + paciente.getNome() + " | Sobrenome: " + paciente.getSobrenome() + " | RG: " + paciente.getRg() + " | Data de Cadastro: " + paciente.getDataDeCadastro() + " |");
                System.out.println("Endereço" + " | Rua: " + endereco.getRua() + " | Número: " + endereco.getNumero() + " | Cidade: " + endereco.getCidade() + " | Estado: " + endereco.getEstado() + " |\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getById(Integer id){

        Paciente paciente;
        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement getById = connection.prepareStatement("SELECT * FROM pacientes WHERE id_paciente = ?");

            getById.setInt(1, id);
            ResultSet resultSet = getById.executeQuery();
            if (resultSet.next()){
                paciente = new Paciente(resultSet.getInt("id_paciente"), resultSet.getString("nome"), resultSet.getString("sobrenome"), resultSet.getString("rg"), resultSet.getDate("datadecadastro"));
                System.out.println("Paciente" + " | Nome: " + paciente.getNome() + " | Sobrenome: " + paciente.getSobrenome() + " | RG: " + paciente.getRg() + " | Data de Cadastro: " + paciente.getDataDeCadastro() + " |");
            } else {
                System.out.println("Paciente não existe");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement delete = connection.prepareStatement(" DELETE FROM enderecos WHERE fk_paciente_endereco = ?; DELETE FROM pacientes WHERE id_paciente = ?;");

            delete.setInt(1, id);
            delete.setInt(2, id);

            Integer rowsAffect = delete.executeUpdate();
            if (rowsAffect.equals(0)){
                System.out.println("Paciente não existe");
            }else {
                System.out.println("Paciente deletado" + " | ID: " + id + " | Linhas afetadas: " + rowsAffect);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateNameById(Integer id, String nome){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE pacientes SET nome=? WHERE id_paciente=? ");

            update.setString(1, nome);
            update.setInt(2, id);

            Integer rowsAffect = update.executeUpdate();
            if (rowsAffect.equals(0)){
                System.out.println("Paciente não Existe");
            }else {
                System.out.println("Nome paciente atualizado" + " | ID: " + id + " | Nome: " + nome + " | Linhas Afetadas: " + rowsAffect);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateSobrenomeById(Integer id, String sobrenome){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE pacientes SET sobrenome=? WHERE id=? ");

            update.setString(1, sobrenome);
            update.setInt(2, id);

            Integer rowsAffect = update.executeUpdate();
            if (rowsAffect.equals(0)){
                System.out.println("Paciente não Existe");
            }else {
                System.out.println("Sobrenome paciente atualizado" + " | ID: " + id + " | Sobrenome: " + sobrenome + " | Linhas Afetadas: " + rowsAffect);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateRgById(Integer id, String rg){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE pacientes SET rg=? WHERE id=? ");

            update.setString(1, rg);
            update.setInt(2, id);

            Integer rowsAffect = update.executeUpdate();
            if (rowsAffect.equals(0)){
                System.out.println("Paciente não Existe");
            }else {
                System.out.println("RG paciente atualizado" + " | ID: " + id + " | RG: " + rg + " | Linhas Afetadas: " + rowsAffect);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateDataDeCadastroById(Integer id, String datadecadastro){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement update = connection.prepareStatement("UPDATE pacientes SET datadecadastro=? WHERE id=? ");

            update.setString(1, datadecadastro);
            update.setInt(2, id);


            Integer rowsAffect = update.executeUpdate();
            if (rowsAffect.equals(0)){
                System.out.println("Paciente não Existe");
            }else {
                System.out.println("Data de cadastro paciente atualizada" + "ID: " + id + " Data de cadastro: " + datadecadastro + " Linhas Afetadas: " + rowsAffect);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
