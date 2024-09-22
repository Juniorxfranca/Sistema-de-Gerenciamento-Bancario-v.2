package entidades; // Define o pacote ao qual esta classe pertence

public class Cliente { // Define a classe Cliente
    // Declaração dos atributos da classe Cliente
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String dataNascimento;
    private String rg;
    private String nomePai;
    private String nomeMae;
    private String estadoCivil;

    // Construtor da classe Cliente que inicializa todos os atributos
    public Cliente(String nome, String cpf, String endereco, String telefone, String dataNascimento, String rg, String nomePai, String nomeMae, String estadoCivil) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.estadoCivil = estadoCivil;
    }

    // Métodos getter para acessar os valores dos atributos
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    // Métodos setter para modificar os valores dos atributos
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
