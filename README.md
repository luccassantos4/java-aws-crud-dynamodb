## :rocket: Tecnologias utilizadas
  
* Java 21
* Spring Boot
* Spring Cloud AWS
* AWS
* DynamoDB (NoSQL Database)
* Localstack


[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[AWS_BADGE]:https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white


<h1 align="left" style="font-weight: bold;">Crud DynamoDb with Spring 💻</h1>
<center>

![AWS][AWS_BADGE]
![spring][SPRING_BADGE]
![java][JAVA_BADGE]

<h3>Prerequisites</h3>

- [Spring](https://spring.io)
- [LocalStack](https://www.localstack.cloud)

<h3>Cloning</h3>

How to clone your project

```bash
git clone https://github.com/luccassantos4/java-aws-crud-dynamodb.git
```

<h3>Starting</h3>

```bash
cd /caminho/para/seu/projeto
mvn spring-boot:run
``````


<h2 id="routes">📍 API Endpoints</h2>

Routes API and request body.
​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /v1/players/{playerId}/games</kbd>     | Retorna o histórico de pontuação [response details](#get-auth-detail)
| <kbd>POST /v1/players/{playerId}/games</kbd>     |  Grava uma nova pontuação [request details](#post-auth-detail)
| <kbd>PUT /v1/players/{playerId}/games/{gameId}</kbd>     | Atualiza uma nova pontuação [request details](#put-auth-detail)
| <kbd>DELETE /v1/players/{playerId}/games/{gameId}</kbd>     | Exclui uma pontuação [request details](#delete-auth-detail)

<h3 id="get-auth-detail">GET /v1/players/{playerId}/games</h3>

**RESPONSE**
```json
{
    "playerId": "50",
    "gameId": "09b0cc01-a846-472b-bf3a-611f05968463",
    "score": 10.0,
    "createdAt": "2024-11-06T03:18:53.709839Z"
}
```

<h3 id="post-auth-detail">POST /v1/players/{playerId}/games</h3>

**REQUEST**
```json
{
    "score": 10
}
```

**RESPONSE**
```text
200 OK
```

<h3 id="put-auth-detail">PUT /v1/players/{playerId}/games/{gameId}</h3>

**REQUEST**
```json
{
    "score": 50
}
```

**RESPONSE**
```text
204 NO_CONTENT
```

<h3 id="delete-auth-detail">DELETE /v1/players/{playerId}/games/{gameId}</h3>

**REQUEST**
```json

```

**RESPONSE**
```text
204 NO_CONTENT
```
