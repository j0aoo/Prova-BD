package Modelo;

public class Consulta {
 
    //atributos
    private int codido;
    private int cod_Cliente;
    private int cod_procedimento;
    private String data_atu;
    private String data_consulta;
    private String preco_procedimento;
    
    //getters e setters

    public int getCodido() {
        return codido;
    }

    public void setCodido(int codido) {
        this.codido = codido;
    }

    public int getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public int getCod_procedimento() {
        return cod_procedimento;
    }

    public void setCod_procedimento(int cod_procedimento) {
        this.cod_procedimento = cod_procedimento;
    }

    public String getData_atu() {
        return data_atu;
    }

    public void setData_atu(String data_atu) {
        this.data_atu = data_atu;
    }

    public String getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getPreco_procedimento() {
        return preco_procedimento;
    }

    public void setPreco_procedimento(String preco_procedimento) {
        this.preco_procedimento = preco_procedimento;
    }
    
}
