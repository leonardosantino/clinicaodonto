package test;

import dao.impl.PacienteDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dao.config.ConnectionJDBC;
import dao.config.CreateTable;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class PacienteDAOTest {

    PacienteDAO paciente;
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    @BeforeAll
    static void setUpAll(){
        CreateTable.createTable();
    }

    @BeforeEach
    void setUpEach(){
        paciente = new PacienteDAO();
        connection = ConnectionJDBC.getConnection();
    }

    @Test
    void insert(){

        String nome = null;
        String sobrenome = null;
        String rg = null;
        String datadecadastro = null;

        // paciente.insert("NomeTest", "SobrenomeTest", "RgTest", "2000-10-01");

        try {

            statement = connection.prepareStatement("SELECT * FROM pacientes WHERE rg = 'RgTest'");
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                nome = resultSet.getString("nome");
                sobrenome = resultSet.getString("sobrenome");
                rg = resultSet.getString("rg");
                datadecadastro = resultSet.getString("datadecadastro");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        assertEquals("NomeTest", nome);
        assertEquals("SobrenomeTest", sobrenome);
        assertEquals("RgTest", rg);
        assertEquals("2000-10-01" , datadecadastro);
    }

    @Test
    void selectAll() {
    }

    @Test
    void getById() {

        String nome = null;
        String sobrenome = null;
        String rg = null;
        String datadecadastro = null;

        try {

            statement = connection.prepareStatement("SELECT * FROM pacientes WHERE id_paciente = 1");
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                nome = resultSet.getString("nome");
                sobrenome = resultSet.getString("sobrenome");
                rg = resultSet.getString("rg");
                datadecadastro = resultSet.getString("datadecadastro");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        assertEquals("NomeTest", nome);
        assertEquals("SobrenomeTest", sobrenome);
        assertEquals("RgTest", rg);
        assertEquals("2000-10-01" , datadecadastro);

    }

    @Test
    void deleteById() {

        Integer rowsAffect = null;
        try {
            connection = ConnectionJDBC.getConnection();
            statement = connection.prepareStatement(" DELETE FROM enderecos WHERE fk_paciente_endereco = ?; DELETE FROM pacientes WHERE id_paciente = ?;");

            statement.setInt(1, 1);
            statement.setInt(2, 1);

            rowsAffect = statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(0, rowsAffect);
    }
}