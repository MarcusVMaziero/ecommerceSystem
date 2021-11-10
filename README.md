# ecommerceSystem
Sistema para simulação de um e-commerce

## Iformações sobre o projeto
Java 11

Springboot

H2

RabbitMQ

A documentação do projeto esta no swagger que foi inserido, após subir o projeto é possível visualizar no: http://localhost:8081/swagger-ui.html

A aplicação roda na porta 8081.

Foi criado um endpoint para cadastro de produtos que chama o RabbitMQ para efetivar este cadastro(esse endpoint é para teste)

Para acessar o banco de dados H2: http://localhost:8081/user_db

Alterar JDBC URL para: jdbc:h2:./user_db

Username H2: root / Password: root

## Melhorias a desenvolver

* Criar novos objetos.
* Desvincular fluxo para nova tabela no BD.
* Criar testes de integração
