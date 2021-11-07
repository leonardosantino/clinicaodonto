package dao;

public interface IDAOEndereco <T>{
    void setEnderecoByIdPaciente(Integer idPaciente ,String rua, String numero, String cidade, String estado);
    void getEnderecoByIdPaciente(Integer idPaciente);
    void updateRuaByIdPaciente(Integer idPaciente, String rua);
    void updateNumeroByIdPaciente(Integer idPaciente, String rua);
    void updateCidadeByIdPaciente(Integer idPaciente, String rua);
    void updateEstadoByIdPaciente(Integer idPaciente, String rua);
}
