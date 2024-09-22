package servicos; // Define o pacote ao qual esta classe pertence

import estruturas.Fila; // Importa a classe Fila
import entidades.Cliente; // Importa a classe Cliente para uso na implementação
import entidades.ContaBancaria; // Importa a classe ContaBancaria para uso na implementação
import entidades.ContaCorrente; // Importa a classe ContaCorrente para uso na implementação
import entidades.ContaPoupanca; // Importa a classe ContaPoupanca para uso na implementação
import interfaces.IRepositorioContas; // Importa a interface RepositorioContas
import interfaces.IServicoTransferencias; // Importa a interface ServicoTransferencias

// Implementação dos serviços bancários
public class BancoServiceImpl {
    private IRepositorioContas repositorioContas; // Repositório para gerenciar as contas bancárias
    private IServicoTransferencias servicoTransferencias; // Serviço para gerenciar transferências entre contas
    private Fila<String> filaAtendimento; // Fila para gerenciar atendimentos

    // Construtor que inicializa o repositório de contas, o serviço de transferências e a fila
    public BancoServiceImpl(IRepositorioContas repositorioContas, IServicoTransferencias servicoTransferencias) {
        this.repositorioContas = repositorioContas;
        this.servicoTransferencias = servicoTransferencias;
        this.filaAtendimento = new Fila<>(); // Inicializa a fila
    }

    // Método para criar uma nova conta para um cliente
    public void criarConta(String tipoConta, Cliente cliente, String senha) {
        String agencia = "001"; // Agência padrão
        String numeroConta = gerarNumeroConta(); // Gera um novo número de conta
        ContaBancaria conta;

        // Cria uma conta poupança ou corrente com base no tipo fornecido
        if (tipoConta.equals("1")) {
            conta = new ContaPoupanca(cliente, agencia, numeroConta, senha);
        } else if (tipoConta.equals("2")) {
            conta = new ContaCorrente(cliente, agencia, numeroConta, senha);
        } else {
            throw new IllegalArgumentException("Tipo de conta inválido."); // Lança exceção se o tipo de conta for inválido
        }

        repositorioContas.adicionarConta(conta); // Adiciona a conta ao repositório
        System.out.println("Conta criada com sucesso.");
    }

    // Método para listar todas as contas bancárias
    public void listarContas() {
        for (ContaBancaria conta : repositorioContas.getContas()) {
            // Determina o tipo de conta e exibe as informações
            String tipoConta = conta instanceof ContaPoupanca ? "Poupança" : "Corrente";
            System.out.println("Agência: " + conta.getAgencia() +
                    ", Conta: " + conta.getNumeroConta() +
                    ", Tipo: " + tipoConta +
                    ", Cliente: " + conta.getCliente().getNome());
        }
    }

    // Método para atualizar os dados de um cliente com base no CPF
    public void editarCliente(String cpf, Cliente clienteAtualizado) {
        ContaBancaria conta = repositorioContas.buscarContaPorCpf(cpf); // Busca a conta com base no CPF
        if (conta != null) {
            Cliente cliente = conta.getCliente(); // Obtém o cliente da conta
            // Atualiza os dados do cliente
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
            cliente.setRg(clienteAtualizado.getRg());
            cliente.setNomePai(clienteAtualizado.getNomePai());
            cliente.setNomeMae(clienteAtualizado.getNomeMae());
            cliente.setEstadoCivil(clienteAtualizado.getEstadoCivil());
            System.out.println("Dados do cliente atualizados com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Método para excluir uma conta com base na agência e número da conta
    public void excluirConta(String agencia, String numeroConta) {
        ContaBancaria conta = repositorioContas.buscarContaPorAgenciaEConta(agencia, numeroConta); // Busca a conta
        if (conta != null) {
            repositorioContas.removerConta(conta); // Remove a conta do repositório
            System.out.println("Conta excluída com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Método para realizar um depósito em uma conta
    public void depositar(String agencia, String numeroConta, double valor) {
        ContaBancaria conta = repositorioContas.buscarContaPorAgenciaEConta(agencia, numeroConta); // Busca a conta
        if (conta != null) {
            conta.depositar(valor); // Realiza o depósito
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Método para realizar um saque de uma conta
    public void sacar(String agencia, String numeroConta, String senha, double valor) {
        ContaBancaria conta = repositorioContas.buscarContaPorAgenciaEConta(agencia, numeroConta); // Busca a conta
        if (conta != null) {
            if (conta.getSenha().equals(senha)) { // Verifica se a senha está correta
                if (conta.sacar(valor)) { // Tenta realizar o saque
                    System.out.println("Saque realizado com sucesso.");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            } else {
                System.out.println("Senha incorreta.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Método privado para gerar um novo número de conta
    private String gerarNumeroConta() {
        int numero = repositorioContas.getUltimoNumeroConta() + 1; // Incrementa o último número de conta
        return String.format("%02d", numero); // Formata o número para dois dígitos
    }

    // Método para realizar uma transferência entre contas
    public void transferir(String agenciaOrigem, String numeroContaOrigem, String agenciaDestino, String numeroContaDestino, double valor, String senhaOrigem) {
        servicoTransferencias.transferir(agenciaOrigem, numeroContaOrigem, agenciaDestino, numeroContaDestino, valor, senhaOrigem); // Delegar a transferência ao serviço
    }

    // Método para adicionar um atendimento à fila
    public void adicionarAtendimento(String atendimento) {
        filaAtendimento.enqueue(atendimento); // Adiciona atendimento à fila
        System.out.println("Atendimento adicionado à fila: " + atendimento);
    }

    // Método para processar o próximo atendimento na fila
    public void processarAtendimento() {
        if (!filaAtendimento.isEmpty()) {
            String atendimento = filaAtendimento.dequeue(); // Remove o próximo atendimento
            System.out.println("Atendendo: " + atendimento);
            // Lógica de atendimento aqui
        } else {
            System.out.println("Nenhum atendimento na fila.");
        }
    }
}
