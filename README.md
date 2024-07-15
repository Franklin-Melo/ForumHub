# Fórum Hub API
## Descrição
ForumHub é uma API desenvolvida em Spring Boot que permite a interação de fóruns online.
Ela oferece endpoints para criação de tópicos postagem de mensagem. Para ter acesso a este tópicois o usuário precisar fazer login na API, 
depois que o mesmo já esteja logado ele precisa enviar junto da mensagem o token de autentucação para que consiga interagir nos outros tópicos.
É um serviço de gerenciamento de identidade e acesso), entre outras funcionalidades essenciais para um sistema de fórum.

### Funcionalidades Principais
- **Autenticação**:
    - `POST /login`: Autenticação.

- **Tópicos**:
    - `POST /topicos`: Cria um novo tópico.
    - `DELETE /topicos/{id}`: Deleta um tópico pelo ID.
    - `PUT /topicos/{id}`: Atualiza um tópico existente.
    - `GET /topicos`: Retorna todos os tópicos.
    - `GET /topicos/{id}`: Retorna um tópico específico pelo ID.

  - **Segurança**:
    - Implementação de segurança com Spring Security e JWT para proteção dos endpoints.
### Tecnologias Usadas

    - Java 21
    - Spring Boot 3
    - Spring Security
    - Maven
    - MySQL
    - Lombok
    - Flyway (migrações de banco de dados)
    - MySQL
