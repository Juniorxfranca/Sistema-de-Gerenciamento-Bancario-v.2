package servicos; // Define o pacote ao qual esta classe pertence

import entidades.Cliente; // Importa a classe Cliente para uso na implementação
import entidades.ContaBancaria; // Importa a classe ContaBancaria para uso na implementação
import entidades.ContaPoupanca; // Importa a classe ContaPoupanca para uso na implementação
import interfaces.IRepositorioContas; // Importa a interface RepositorioContas
import interfaces.IServicoTransferencias; // Importa a interface ServicoTransferencias
import repositorio.RepositorioContasImpl; // Importa a implementação do repositório de contas

import java.util.Scanner; // Importa a classe Scanner para leitura de entrada do usuário

// Classe principal para executar o sistema bancário
public class Main {
    public static void main(String[] args) {
        // Criação das implementações das interfaces
        IRepositorioContas repositorioContas = new RepositorioContasImpl();
        IServicoTransferencias servicoTransferencias = new ServicoTransferenciasImpl(repositorioContas);
        BancoServiceImpl bancoService = new BancoServiceImpl(repositorioContas, servicoTransferencias);

        Scanner scanner = new Scanner(System.in); // Scanner para ler a entrada do usuário
        boolean continuar = true; // Variável para controle do loop

        // Loop principal para interação com o usuário
        while (continuar) {
            System.out.println("Bem-vindo ao Purple Bank!"); // Mensagem de boas-vindas
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Listar Contas");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Consultar Conta");
            System.out.println("5 - Depositar");
            System.out.println("6 - Sacar");
            System.out.println("7 - Transferir");
            System.out.println("8 - Excluir Conta");
            System.out.println("9 - Sair");

            int opcao = scanner.nextInt(); // Lê a opção do usuário
            scanner.nextLine(); // Limpa o buffer para evitar problemas com entradas subsequentes

            switch (opcao) {
                case 1:
                    // Criação de nova conta
                    System.out.print("Tipo de conta (1 - Poupança, 2 - Corrente): ");
                    String tipoConta = scanner.nextLine();

                    // Coleta de dados do cliente
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("RG: ");
                    String rg = scanner.nextLine();
                    System.out.print("Nome do Pai: ");
                    String nomePai = scanner.nextLine();
                    System.out.print("Nome da Mãe: ");
                    String nomeMae = scanner.nextLine();
                    System.out.print("Estado Civil: ");
                    String estadoCivil = scanner.nextLine();
                    System.out.print("Senha da conta: ");
                    String senha = scanner.nextLine();

                    // Criação do objeto Cliente e chamada do serviço para criar a conta
                    Cliente cliente = new Cliente(nome, cpf, endereco, telefone, dataNascimento, rg, nomePai, nomeMae, estadoCivil);
                    bancoService.criarConta(tipoConta, cliente, senha);
                    break;

                case 2:
                    // Listagem de todas as contas
                    bancoService.listarContas();
                    break;

                case 3:
                    // Edição de dados do cliente
                    System.out.print("CPF do cliente para edição: ");
                    String cpfEditar = scanner.nextLine();

                    // Coleta dos novos dados do cliente
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Endereço: ");
                    String novoEndereco = scanner.nextLine();
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Nova Data de Nascimento: ");
                    String novaDataNascimento = scanner.nextLine();

                    System.out.print("Novo RG: ");
                    String novoRg = scanner.nextLine();
                    System.out.print("Novo Nome do Pai: ");
                    String novoNomePai = scanner.nextLine();
                    System.out.print("Novo Nome da Mãe: ");
                    String novoNomeMae = scanner.nextLine();
                    System.out.print("Novo Estado Civil: ");
                    String novoEstadoCivil = scanner.nextLine();

                    // Criação do objeto Cliente atualizado e chamada do serviço para editar o cliente
                    Cliente clienteAtualizado = new Cliente(novoNome, cpfEditar, novoEndereco, novoTelefone, novaDataNascimento, novoRg, novoNomePai, novoNomeMae, novoEstadoCivil);
                    bancoService.editarCliente(cpfEditar, clienteAtualizado);
                    break;

                case 4:
                    // Consulta de conta por CPF
                    System.out.print("Digite o CPF da conta para consulta: ");
                    String cpfConsulta = scanner.nextLine();
                    ContaBancaria contaConsulta = repositorioContas.buscarContaPorCpf(cpfConsulta);
                    if (contaConsulta != null) {
                        System.out.println("Agência: " + contaConsulta.getAgencia());
                        System.out.println("Número da Conta: " + contaConsulta.getNumeroConta());
                        System.out.println("Tipo: " + (contaConsulta instanceof ContaPoupanca ? "Poupança" : "Corrente"));
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    // Depósito em uma conta
                    System.out.print("Digite a agência da conta: ");
                    String agenciaDeposito = scanner.nextLine();
                    System.out.print("Digite o número da conta: ");
                    String numeroContaDeposito = scanner.nextLine();
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer

                    bancoService.depositar(agenciaDeposito, numeroContaDeposito, valorDeposito);
                    break;

                case 6:
                    // Saque de uma conta
                    System.out.print("Digite a agência da conta: ");
                    String agenciaSaque = scanner.nextLine();
                    System.out.print("Digite o número da conta: ");
                    String numeroContaSaque = scanner.nextLine();
                    System.out.print("Digite a senha da conta: ");
                    String senhaSaque = scanner.nextLine();
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer

                    bancoService.sacar(agenciaSaque, numeroContaSaque, senhaSaque, valorSaque);
                    break;

                case 7:
                    // Transferência entre contas
                    System.out.print("Digite a agência da conta de origem: ");
                    String agenciaOrigem = scanner.nextLine();
                    System.out.print("Digite o número da conta de origem: ");
                    String numeroContaOrigem = scanner.nextLine();
                    System.out.print("Digite a agência da conta de destino: ");
                    String agenciaDestino = scanner.nextLine();
                    System.out.print("Digite o número da conta de destino: ");
                    String numeroContaDestino = scanner.nextLine();
                    System.out.print("Digite o valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite a senha da conta de origem: ");
                    String senhaOrigem = scanner.nextLine();

                    bancoService.transferir(agenciaOrigem, numeroContaOrigem, agenciaDestino, numeroContaDestino, valorTransferencia, senhaOrigem);
                    break;

                case 8:
                    // Exclusão de uma conta
                    System.out.print("Digite a agência da conta: ");
                    String agenciaExcluir = scanner.nextLine();
                    System.out.print("Digite o número da conta: ");
                    String numeroContaExcluir = scanner.nextLine();

                    bancoService.excluirConta(agenciaExcluir, numeroContaExcluir);
                    break;

                case 9:
                    // Encerrar o programa
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    // Opção inválida
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close(); // Fecha o scanner para liberar recursos
    }
}
