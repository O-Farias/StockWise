# StockWise

**Simulador de Estoque - Projeto Backend em Java**

## Descrição

O StockWise é uma aplicação backend desenvolvida em Java, utilizando o framework Spring Boot. A aplicação simula um sistema de gerenciamento de estoque, permitindo:

- **Listar produtos**
- **Buscar produtos por ID**
- **Adicionar novos produtos**
- **Atualizar produtos existentes**
- **Deletar produtos por ID**

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.1.4**
- **PostgreSQL**
- **Hibernate (JPA)**
- **Jakarta Validation**
- **Lombok**
- **Jacoco** (para cobertura de testes)

## Estrutura do Projeto

```plaintext
src
├── main
│   ├── java/com/stockwise
│   │   ├── controller
│   │   │   └── ProductController.java
│   │   ├── model
│   │   │   └── Product.java
│   │   ├── repository
│   │   │   └── ProductRepository.java
│   │   ├── service
│   │   │   └── ProductService.java
│   │   └── StockWiseApplication.java
│   └── resources
│       ├── application.properties
│       └── data.sql
├── test/java/com/stockwise
│   └── ProductControllerTest.java
```

## Configuração

1. Certifique-se de ter o **PostgreSQL** instalado e rodando.
2. Crie o banco de dados necessário:

```sql
CREATE DATABASE stockwise;
```

3. Configure o arquivo `application.properties` com as credenciais do banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/stockwise
spring.datasource.username=<seu-usuario>
spring.datasource.password=<sua-senha>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Como Rodar a Aplicação

### Pré-requisitos

- **Java 21** ou superior instalado.
- **Maven** configurado no PATH.

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/O-Farias/StockWise
cd StockWise
```

2. Execute o projeto:

```bash
mvn spring-boot:run
```

3. Acesse a API em: `http://localhost:8080/products`

## Endpoints Disponíveis

### **Produtos**

| Método | Endpoint           | Descrição                       |
|--------|--------------------|---------------------------------|
| GET    | `/products`        | Lista todos os produtos         |
| GET    | `/products/{id}`   | Busca um produto pelo ID        |
| POST   | `/products`        | Adiciona um novo produto        |
| DELETE | `/products/{id}`   | Deleta um produto pelo ID       |

### Exemplo de Payload para Criar/Atualizar Produto

```json
{
    "name": "Notebook",
    "quantity": 10,
    "price": 2500.00
}
```

## Testes

1. Para executar os testes automatizados:

```bash
mvn test
```

2. Para gerar o relatório de cobertura de testes:

```bash
mvn verify
```

O relatório será gerado na pasta `target/site/jacoco/index.html`.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
