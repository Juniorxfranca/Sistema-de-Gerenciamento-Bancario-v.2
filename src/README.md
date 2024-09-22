Documentação do Sistema de Gerenciamento de Contas Bancárias
Descrição
O Sistema de Gerenciamento de Contas Bancárias é uma aplicação desenvolvida em Java que permite gerenciar contas bancárias e clientes de forma eficiente. O sistema oferece funcionalidades para criar, editar, excluir e consultar contas, além de realizar operações financeiras como depósitos, saques e transferências.

Funcionalidades
1. Criação de Conta
   Permite criar novas contas bancárias do tipo Corrente ou Poupança associadas a um cliente.
   Gera automaticamente um número de conta único e define uma agência padrão.
2. Listagem de Contas
   Lista todas as contas bancárias cadastradas, apresentando informações como agência, número da conta, tipo de conta e nome do cliente.
3. Edição de Cliente
   Atualiza os dados de um cliente existente com base no CPF, incluindo nome, endereço, telefone, data de nascimento, RG e informações sobre os pais.
4. Consulta de Conta
   Permite consultar os dados de uma conta bancária utilizando o CPF do cliente associado.
5. Depósito
   Realiza depósitos em contas bancárias, atualizando o saldo da conta correspondente.
6. Saque
   Permite saques em contas, exigindo a validação da senha e verificando se há saldo suficiente.
7. Transferência
   Realiza transferências entre contas, exigindo a validação da senha da conta de origem e garantindo que o saldo seja suficiente para a operação.
8. Exclusão de Conta
   Remove uma conta bancária do sistema, liberando os recursos associados.
9. Atendimento ao Cliente
   Implementa um sistema de fila para gerenciar solicitações de atendimento, processando-as na ordem de chegada.
   Requisitos do Sistema
   Java 11 ou superior
   IDE: IntelliJ IDEA ou outra IDE compatível com Java
   Maven: Para gerenciamento de dependências e construção do projeto
   Instruções de Execução
   Clone o repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/nome-do-repositorio.git
Navegue até o diretório do projeto:

bash
Copiar código
cd nome-do-repositorio
Compile e execute o projeto:

bash
Copiar código
mvn clean install
mvn exec:java
Estrutura do Projeto
Pacotes:
entidades: Contém as classes que representam as entidades do sistema, como Cliente e ContaBancaria.
interfaces: Define as interfaces para repositórios e serviços.
repositorios: Implementa a lógica de armazenamento e recuperação de contas.
servicos: Implementa a lógica de negócios, incluindo serviços de transferência e gerenciamento de contas.
Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests ou relatar problemas.

Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.
```   