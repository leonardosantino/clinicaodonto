import dao.impl.EnderecoDAO;
import dao.impl.PacienteDAO;
import dao.config.CreateTable;

public class Main {
    public static void main(String[] args) {

        // CRIAR TABELA Se não existir pacientes e enderecos
        CreateTable.createTable();

        // Instancias de acesso ao banco de dados
        PacienteDAO paciente = new PacienteDAO();
        EnderecoDAO endereco = new EnderecoDAO();

        // Adicionar pacientes e seus endereços
        paciente.insert("Ana", "Lima", "123456789", "2021-11-06");
        endereco.setEnderecoByIdPaciente(1,"Carvalhos", "2", "São Paulo", "SP");

        paciente.insert("Maria", "Tavares", "321654987", "2021-11-05");
        endereco.setEnderecoByIdPaciente(2,"Oliveiras", "520", "Barueri", "SP");

        paciente.insert("João", "Ferreira", "456789123", "2021-11-01");
        endereco.setEnderecoByIdPaciente(3,"Jaguaré", "10", "Osasco", "SP");

        // Pesquisa banco de dados
        paciente.getById(1);
        paciente.getById(2);
        paciente.getById(3);

        // Exluir paciente
        paciente.deleteById(3);
        paciente.getById(3);

        // Selecionar todos os pacientes
        paciente.selectAll();

        // atualizar Dados por ID paciente
        paciente.updateNameById(1,"Nome atualizado");
        paciente.updateSobrenomeById(1,"Sobrenome atualizado");
        paciente.updateRgById(1,"RG atualizado");
        paciente.updateDataDeCadastroById(1 ,"2021-01-01");

        // atualizar endereco por ID paciente
        endereco.updateRuaByIdPaciente(1, "Rua atualizada");
        endereco.updateNumeroByIdPaciente(1, "Numero atualizado");
        endereco.updateCidadeByIdPaciente(1, "Cidade atualizada");
        endereco.updateEstadoByIdPaciente(1, "Estado atualizado");

    }
}
