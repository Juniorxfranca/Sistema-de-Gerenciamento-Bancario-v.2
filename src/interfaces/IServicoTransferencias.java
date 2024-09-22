package interfaces; // Define o pacote ao qual esta interface pertence

// Interface que define o serviço de transferências bancárias
public interface IServicoTransferencias {

    // Método para realizar uma transferência entre duas contas bancárias
    void transferir(
            String agenciaOrigem, // Agência da conta de origem
            String numeroContaOrigem, // Número da conta de origem
            String agenciaDestino, // Agência da conta de destino
            String numeroContaDestino, // Número da conta de destino
            double valor, // Valor a ser transferido
            String senhaOrigem // Senha da conta de origem para validação
    );
}
