import dao.PacienteDAO;
import model.Paciente;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Realizar operações query com a Instancia de PacienteDAO
        PacienteDAO paciente = new PacienteDAO();

        // Selecionar toda a tabela de pacientes
        List<Paciente> pacientesList = paciente.selectAll();

        // Selecionar paciente por ID
        Paciente pacienteGetById2 = paciente.getById(2);

        // Inserir paciente
        // Paciente pacienteInsert = paciente.insert("Miguel", "Santos", " 852357984","Rua Dos Carvalhos","2021-09-01");

        // Deletar por ID
        // paciente.delete(9);

        // Atualizações por ID
        paciente.updateName(2, "Elliot");
        paciente.updateSobrenome(2, "Alderson");
        paciente.updateRg(2, "514873652");
        paciente.updateDataDeAlta(2,"2021-08-26");
    }
}
