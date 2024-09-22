package entidades; // Define o pacote ao qual esta classe pertence

// Classe que estende ContaBancaria para representar uma conta poupança
public class ContaPoupanca extends ContaBancaria {

    // Construtor da classe ContaPoupanca
    public ContaPoupanca(Cliente cliente, String agencia, String numeroConta, String senha) {
        super(cliente, agencia, numeroConta, senha); // Chama o construtor da classe pai (ContaBancaria)
    }

    // Implementação do método abstrato exibirTipo() da classe pai
    @Override
    public void exibirTipo() {
        System.out.println("Tipo de Conta: Poupança"); // Exibe o tipo de conta no console
    }
}
