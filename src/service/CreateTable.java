package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public  class CreateTable {

    public static void createTable(){

        try {
            Connection connection = ConnectionJDBC.getConnection();
            PreparedStatement createPacientes = connection.prepareStatement("CREATE TABLE IF NOT EXISTS pacientes (id_paciente INT NOT NULL AUTO_INCREMENT, nome VARCHAR NOT NULL, sobrenome VARCHAR NOT NULL,rg VARCHAR NOT NULL,datadecadastro DATE NOT NULL,PRIMARY KEY (id_paciente));");
            PreparedStatement createEnderecos = connection.prepareStatement("CREATE TABLE IF NOT EXISTS enderecos (id_endereco INT NOT NULL AUTO_INCREMENT,rua VARCHAR NOT NULL,numero VARCHAR NOT NULL,cidade VARCHAR NOT NULL,estado VARCHAR NOT NULL,fk_paciente_endereco INT NOT NULL,PRIMARY KEY (id_endereco),CONSTRAINT fk_paciente_endereco FOREIGN KEY (fk_paciente_endereco)REFERENCES pacientes(id_paciente));");

            createPacientes.executeUpdate();
            createEnderecos.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
