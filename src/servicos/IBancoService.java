package servicos; // Define o pacote ao qual esta interface pertence

import entidades.Cliente; // Importa a classe Cliente para uso na interface
import entidades.ContaBancaria; // Importa a classe ContaBancaria para uso na interface

// Interface para definir os serviços bancários disponíveis
public interface IBancoService {

    // Método para criar uma nova conta para um cliente
    void criarConta(Cliente cliente, int tipoConta);

    // Método para buscar uma conta com base no número da conta
    ContaBancaria buscarContaPorNumero(int numeroConta);

    // Método para excluir uma conta com base no número da conta
    void excluirConta(int numeroConta);

    // Método para listar todos os clientes
    void listarClientes();

    // Método para listar todas as contas
    void listarContas();

    // Outros métodos podem ser adicionados conforme necessário
}
