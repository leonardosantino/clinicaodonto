import dao.PacienteDAO;
import model.Paciente;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PacienteDAO paciente = new PacienteDAO();

        List<Paciente> pacientesList = paciente.selectAll();
        for (Paciente p : pacientesList) {
            System.out.println(p);
        }

        Paciente pacienteGetById4 = paciente.getById(4);
    }
}
