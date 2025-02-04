# Jogo da Velha

O Jogo da Velha é um jogo clássico de dois jogadores onde o objetivo é alinhar três símbolos (X ou O) em uma linha, coluna ou diagonal. Este projeto implementa o jogo utilizando WebSocket para permitir que os jogadores joguem em tempo real pela web.

## Tecnologias Usadas no Backend
- **Java 22**
- **Spring Boot** (para a estrutura do servidor)
- **WebSocket** (para comunicação em tempo real)

## Como Rodar o Projeto

1. Clone o repositório e abra o projeto no seu IDE de preferência.
   
2. Inicie a aplicação no Spring Boot (classe principal com `@SpringBootApplication`), e clique em **Run** ou utilize o terminal no bash para rodar os comandos abaixo:

   - **Limpeza (opcional, caso esteja com problemas de build)**:
     ```bash
     $ mvn clean
     ```

   - **Instalação das dependências**:
     ```bash
     $ mvn install
     ```

   - **Rodar o servidor**:
     ```bash
     $ mvn spring-boot:run
     ```

3. Acesse a URL [http://localhost:8080](http://localhost:8080) no seu navegador. Se o servidor estiver funcionando corretamente, você verá a mensagem: **Servidor está funcionando!**.

4. Para acessar o Jogo da Velha, vá até a URL [http://localhost:8080/Jogo-da-velha](http://localhost:8080/Jogo-da-velha). Você verá a mensagem: **Welcome to SockJS!**, o que indica que a conexão com o WebSocket foi estabelecida corretamente.

## Dependências
- **Java 22** 
- **Maven**
- **Spring Boot**
- **WebSocket**

Se você não tiver o Maven ou o Java instalados, consulte a documentação oficial do [Maven](https://maven.apache.org/) e do [Java](https://www.oracle.com/java/technologies/javase-downloads.html) para mais informações.
