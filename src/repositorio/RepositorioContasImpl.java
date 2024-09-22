package repositorio; // Define o pacote ao qual esta classe pertence

import entidades.ContaBancaria; // Importa a classe ContaBancaria para uso na implementação
import interfaces.IRepositorioContas; // Importa a interface RepositorioContas

import java.util.ArrayList; // Importa a classe ArrayList para armazenar contas
import java.util.List; // Importa a interface List

// Implementação da interface RepositorioContas
public class RepositorioContasImpl implements IRepositorioContas {
    // Lista para armazenar as contas bancárias
    private List<ContaBancaria> contas = new ArrayList<>();
    // Armazena o último número de conta utilizado
    private int ultimoNumeroConta = 0;

    @Override
    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta); // Adiciona a conta à lista
        ultimoNumeroConta = Integer.parseInt(conta.getNumeroConta()); // Atualiza o último número de conta
    }

    @Override
    public ContaBancaria buscarContaPorAgenciaEConta(String agencia, String numeroConta) {
        // Busca uma conta na lista com base na agência e número da conta
        for (ContaBancaria conta : contas) {
            if (conta.getAgencia().equals(agencia) && conta.getNumeroConta().equals(numeroConta)) {
                return conta; // Retorna a conta encontrada
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }

    @Override
    public ContaBancaria buscarContaPorCpf(String cpf) {
        // Busca uma conta na lista com base no CPF do cliente
        for (ContaBancaria conta : contas) {
            if (conta.getCliente().getCpf().equals(cpf)) {
                return conta; // Retorna a conta encontrada
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }

    @Override
    public List<ContaBancaria> getContas() {
        return contas; // Retorna a lista de todas as contas
    }

    @Override
    public void removerConta(ContaBancaria conta) {
        contas.remove(conta); // Remove a conta da lista
    }

    @Override
    public int getUltimoNumeroConta() {
        return ultimoNumeroConta; // Retorna o último número de conta utilizado
    }
}
