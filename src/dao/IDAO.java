package dao;

public interface IDAO<T> {

    void insert(String nome, String sobrenome, String rg, String datadecadastro);
    void selectAll();
    void getById(Integer id);
    void deleteById(Integer id);
    void updateNameById(Integer id, String nome);
    void updateSobrenomeById(Integer id, String sobrenome);
    void updateRgById(Integer id, String rg);
    void updateDataDeCadastroById(Integer id, String datadecadastro);
}
