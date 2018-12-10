package Modelo;

public class Consulta {
 
    //Atributos
    private int codigo;
    private int cod_cliente;
    private int cod_procedimento;
    private String preco_procedimento;
    private String horario;
    private String nomeCli;
    private String dataAtual;
    private String dataConsulta;

    //getters e setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_procedimento() {
        return cod_procedimento;
    }

    public void setCod_procedimento(int cod_procedimento) {
        this.cod_procedimento = cod_procedimento;
    }

    public String getPreco_procedimento() {
        return preco_procedimento;
    }

    public void setPreco_procedimento(String preco_procedimento) {
        this.preco_procedimento = preco_procedimento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    
       
}
