package entidades; // Define o pacote ao qual esta classe pertence

// Classe que estende ContaBancaria para representar uma conta corrente
public class ContaCorrente extends ContaBancaria {

    // Construtor da classe ContaCorrente
    public ContaCorrente(Cliente cliente, String agencia, String numeroConta, String senha) {
        super(cliente, agencia, numeroConta, senha); // Chama o construtor da classe pai (ContaBancaria)
    }

    // Implementação do método abstrato exibirTipo() da classe pai
    @Override
    public void exibirTipo() {
        System.out.println("Tipo de Conta: Corrente"); // Exibe o tipo de conta no console
    }
}
