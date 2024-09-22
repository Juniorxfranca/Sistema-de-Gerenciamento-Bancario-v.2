package servicos;

import entidades.ContaBancaria;
import interfaces.IRepositorioContas;
import interfaces.IServicoTransferencias;

/**
 * Implementação do serviço de transferências bancárias.
 * Esta classe é responsável por realizar transferências entre contas bancárias.
 */
public class ServicoTransferenciasImpl implements IServicoTransferencias {

    // Repositório onde as contas bancárias estão armazenadas
    private IRepositorioContas repositorioContas;

    /**
     * Construtor da classe. Recebe o repositório de contas como parâmetro.
     *
     * @param repositorioContas Repositório de contas bancárias
     */
    public ServicoTransferenciasImpl(IRepositorioContas repositorioContas) {
        this.repositorioContas = repositorioContas;
    }

    /**
     * Realiza uma transferência de um valor de uma conta de origem para uma conta de destino.
     *
     * @param agenciaOrigem     Agência da conta de origem
     * @param numeroContaOrigem Número da conta de origem
     * @param agenciaDestino    Agência da conta de destino
     * @param numeroContaDestino Número da conta de destino
     * @param valor             Valor a ser transferido
     * @param senhaOrigem       Senha da conta de origem para autenticação
     */
    @Override
    public void transferir(String agenciaOrigem, String numeroContaOrigem, String agenciaDestino, String numeroContaDestino, double valor, String senhaOrigem) {
        // Busca a conta de origem e a conta de destino no repositório
        ContaBancaria contaOrigem = repositorioContas.buscarContaPorAgenciaEConta(agenciaOrigem, numeroContaOrigem);
        ContaBancaria contaDestino = repositorioContas.buscarContaPorAgenciaEConta(agenciaDestino, numeroContaDestino);

        // Verifica se ambas as contas foram encontradas
        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Conta de origem ou destino não encontrada.");
            return; // Sai do método se qualquer conta não for encontrada
        }

        // Verifica se a senha fornecida corresponde à senha da conta de origem
        if (!contaOrigem.getSenha().equals(senhaOrigem)) {
            System.out.println("Senha incorreta.");
            return; // Sai do método se a senha estiver incorreta
        }

        // Tenta sacar o valor da conta de origem
        if (contaOrigem.sacar(valor)) {
            // Se o saque for bem-sucedido, deposita o valor na conta de destino
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            // Se o saque falhar (saldo insuficiente), exibe uma mensagem de erro
            System.out.println("Saldo insuficiente.");
        }
    }
}
