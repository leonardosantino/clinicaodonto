import dao.PacienteDAO;
import model.Paciente;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PacienteDAO paciente = new PacienteDAO();

        List<Paciente> pacientesList = paciente.selectAll();

        Paciente pacienteGetById4 = paciente.getById(3);

        Paciente pacienteInsert = paciente.insert("Miguel", "Santos", " 852357984","Rua Dos Carvalhos","2021-09-01");

        paciente.delete(9);
    }
}
