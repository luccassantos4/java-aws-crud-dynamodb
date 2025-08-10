
# Java AWS CRUD DynamoDB

![AWS][AWS_BADGE] ![spring][SPRING_BADGE] ![java][JAVA_BADGE]

## Descrição

Este projeto é uma API RESTful desenvolvida em Java 21 com Spring Boot, que permite gerenciar o histórico de pontuações de jogadores utilizando o banco de dados NoSQL DynamoDB da AWS. O objetivo é demonstrar como integrar aplicações Spring com serviços AWS de forma simples, utilizando o Spring Cloud AWS e LocalStack para testes locais.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Cloud AWS
- AWS DynamoDB (NoSQL)
- LocalStack (emulação local da AWS)
- Maven

## Arquitetura

- **Controller:** expõe endpoints REST para operações CRUD.
- **Entity:** mapeia o modelo `PlayerHistory` para a tabela DynamoDB.
- **DTO:** define o contrato de dados para requisições.
- **Config:** configura o cliente DynamoDB para uso local (LocalStack).
- **Integração AWS:** utiliza Spring Cloud AWS para abstrair operações no DynamoDB.

## Pré-requisitos

- Java 21+
- Maven 3.8+
- Docker (para rodar o LocalStack)
- LocalStack

## Como executar localmente

1. **Clone o repositório:**
     ```bash
     git clone https://github.com/luccassantos4/java-aws-crud-dynamodb.git
     cd java-aws-crud-dynamodb
     ```

2. **Suba o LocalStack (DynamoDB):**
     ```bash
     docker run --rm -it -p 4566:4566 -e SERVICES=dynamodb localstack/localstack
     ```

3. **Execute a aplicação:**
     ```bash
     mvn spring-boot:run
     ```

4. **Acesse a API:**  
     A aplicação estará disponível em `http://localhost:8080`.

## Configuração

O acesso ao DynamoDB é feito via LocalStack, configurado em `DynamoDbConfig.java`:
- Endpoint: `http://localhost:4566`
- Região: `us-east-1`
- Credenciais fictícias para uso local.

## Endpoints da API

| Método | Rota                                         | Descrição                        |
|--------|----------------------------------------------|----------------------------------|
| GET    | `/v1/players/{playerId}/games`               | Lista histórico de pontuações    |
| GET    | `/v1/players/{playerId}/games/{gameId}`      | Busca pontuação específica       |
| POST   | `/v1/players/{playerId}/games`               | Cria nova pontuação              |
| PUT    | `/v1/players/{playerId}/games/{gameId}`      | Atualiza pontuação               |
| DELETE | `/v1/players/{playerId}/games/{gameId}`      | Remove pontuação                 |

### Exemplos de Requisição e Resposta

#### Criar pontuação

**POST** `/v1/players/{playerId}/games`
```json
{
    "score": 10
}
```
**Resposta:** `200 OK`

#### Listar histórico

**GET** `/v1/players/{playerId}/games`
```json
[
    {
        "playerId": "50",
        "gameId": "09b0cc01-a846-472b-bf3a-611f05968463",
        "score": 10.0,
        "createdAt": "2024-11-06T03:18:53.709839Z"
    }
]
```

#### Atualizar pontuação

**PUT** `/v1/players/{playerId}/games/{gameId}`
```json
{
    "score": 50
}
```
**Resposta:** `204 NO_CONTENT`

#### Excluir pontuação

**DELETE** `/v1/players/{playerId}/games/{gameId}`  
**Resposta:** `204 NO_CONTENT`

## Testes

Para rodar os testes:
```bash
mvn test
```

## Observações

- O projeto utiliza LocalStack para simular o ambiente AWS localmente, facilitando o desenvolvimento e testes sem custos.
- As credenciais e endpoint do DynamoDB são fictícios e não devem ser usados em produção.
- Para produção, ajuste as configurações em `DynamoDbConfig.java` e `application.properties`.

[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[AWS_BADGE]:https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white
