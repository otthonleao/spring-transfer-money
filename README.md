# Transfer Money
Esta API RESTful foi desenvolvida para simular operações financeiras como transferências, depósitos e pagamentos entre contas de usuários comuns e lojistas. O projeto utiliza boas práticas de desenvolvimento backend para garantir um código limpo, manutenível e escalável.

## 🚀 Funcionalidades
- **Cadastrar Conta**
  - Registra a carteira como Cliente Pessoa Física ou Pessoa Jurídica
  - CPF/CNPJ e Emails devem ser únicos no sistema
  - Pessoa Física pode enviar dinheiro para Pessoa Jurídica e Pessoa Física
  - Pessoa Jurídica só recebe transferência
  - Validar se o usuário tem saldo antes da transferência
  - Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, como o Mocky para simular o serviço utilizando o verbo GET
  - A operação de transferência é revestida em qualquer inconsistência
  - Envia notificação para o destinatário para transferência
 
## ⚙️ Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cloud Open Feign
- Postgres
- Docker
- H2 Database
- ControllerAdvice & Problem Details
- Hibernate Validator
