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

Ainda falta desenvolver:

Refatorar fluxo do relacionamento entre Cart e Product

Refatorar fluxo das services e data providers para anteder a alteração à cima citada

Criar endpoint de checkout
