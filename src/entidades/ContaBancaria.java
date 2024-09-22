package entidades; // Define o pacote ao qual esta classe pertence

// Classe abstrata ContaBancaria
public abstract class ContaBancaria {
    // Declaração dos atributos da classe ContaBancaria
    private Cliente cliente; // Referência ao objeto Cliente associado a esta conta
    private String agencia; // Número da agência da conta
    private String numeroConta; // Número da conta
    private String senha; // Senha para acesso à conta
    private double saldo; // Saldo atual da conta

    // Construtor da classe ContaBancaria que inicializa todos os atributos
    public ContaBancaria(Cliente cliente, String agencia, String numeroConta, String senha) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = 0.0; // Inicializa o saldo com 0.0
    }

    // Métodos getter para acessar os valores dos atributos
    public Cliente getCliente() {
        return cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para sacar um valor da conta
    public boolean sacar(double valor) {
        if (valor <= saldo) { // Verifica se há saldo suficiente
            saldo -= valor; // Deduz o valor do saldo
            return true; // Operação bem-sucedida
        }
        return false; // Falha na operação
    }

    // Método para depositar um valor na conta
    public void depositar(double valor) {
        saldo += valor; // Adiciona o valor ao saldo
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract void exibirTipo();
}
