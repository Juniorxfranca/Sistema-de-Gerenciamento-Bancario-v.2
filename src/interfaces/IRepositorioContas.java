package interfaces; // Define o pacote ao qual esta interface pertence

import entidades.ContaBancaria; // Importa a classe ContaBancaria para uso na interface

import java.util.List; // Importa a classe List para a lista de contas

// Interface que define operações para o repositório de contas bancárias
public interface IRepositorioContas {

    // Método para adicionar uma nova conta ao repositório
    void adicionarConta(ContaBancaria conta);

    // Método para buscar uma conta no repositório com base na agência e número da conta
    ContaBancaria buscarContaPorAgenciaEConta(String agencia, String numeroConta);

    // Método para buscar uma conta no repositório com base no CPF do cliente
    ContaBancaria buscarContaPorCpf(String cpf);

    // Método para obter uma lista de todas as contas no repositório
    List<ContaBancaria> getContas();

    // Método para remover uma conta do repositório
    void removerConta(ContaBancaria conta);

    // Método para obter o último número de conta usado no repositório
    int getUltimoNumeroConta();
}
