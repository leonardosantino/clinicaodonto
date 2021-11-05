import dao.PacienteDAO;
import model.Paciente;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PacienteDAO paciente = new PacienteDAO();

        List<Paciente> pacientesList = paciente.selectAll();

        Paciente pacienteGetById4 = paciente.getById(3);

        Paciente pacienteInsert = paciente.insert("Ana", "Lopes", " 147852369","Rua 12","2021-11-05");

        paciente.delete(4);
    }
}
