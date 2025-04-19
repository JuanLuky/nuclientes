
---

## 🟣 NuClientes API – Desafio Estilo Nubank

API REST para cadastro de **clientes e seus contatos**, desenvolvida como simulação de um desafio técnico de backend júnior.

---

### 📌 Funcionalidades

- ✅ Cadastro de clientes
- ✅ Cadastro de contatos vinculados a clientes
- ✅ Listagem de clientes e seus contatos
- ✅ Busca por cliente ou contatos
- ✅ Exclusão de clientes e contatos
- ✅ Validações com `@Valid`
- ✅ Uso de DTOs e MapStruct para separação de entidades e transporte de dados
- ✅ Docker e PostgreSQL com Docker Compose

---

### 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MapStruct
- PostgreSQL
- Maven
- Docker & Docker Compose
- Postman (testes manuais)

---

### ⚙️ Como Rodar Localmente

> Pré-requisitos: Docker e Java 17 instalados

#### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/nuclientes-api.git
cd nuclientes-api
```

#### 2. Suba o banco de dados com Docker

```bash
docker-compose up -d
```

#### 3. Configure o `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/NU_DB
spring.datasource.username=postgres
spring.datasource.password=231020
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

#### 4. Rode o projeto

```bash
./mvnw spring-boot:run
```

---

### 📭 Endpoints Principais

#### 📌 Clientes

| Método | Rota                 | Descrição                  |
|--------|----------------------|----------------------------|
| GET    | `/clientes`          | Lista todos os clientes    |
| GET    | `/clientes/{id}`     | Busca cliente por ID       |
| POST   | `/clientes`          | Cadastra novo cliente      |
| DELETE | `/clientes/{id}`     | Deleta cliente             |
| GET    | `/clientes/{id}/contatos` | Lista contatos de um cliente |

#### 📌 Contatos

| Método | Rota                 | Descrição                  |
|--------|----------------------|----------------------------|
| GET    | `/contatos`          | Lista todos os contatos    |
| POST   | `/contatos`          | Cadastra contato (vincula a um cliente) |
| DELETE | `/contatos/{id}`     | Deleta contato             |

---

### 📁 Estrutura do Projeto

```
src
 └── main
     ├── java
     │   └── com.seuprojeto.nuclientes
     │       ├── controller
     │       ├── dto
     │       ├── entity
     │       ├── mapper
     │       ├── repository
     │       └── service
     └── resources
         └── application.properties
```

---

### ✅ Validações

- Campos como nome, email e telefone são obrigatórios.
- `@Valid` usado nos endpoints para garantir integridade.
- Erros são tratados com retorno 400 (Bad Request).

---

### 🐳 Docker Compose

```yaml
version: '3.7'
services:
  conta-nu:
    image: postgres:15.3
    container_name: conta-nubank
    restart: always
    volumes:
      - postgres_data:/var/lib/postgresql/data
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: 231020
      POSTGRES_DB: NU_DB
    ports:
      - "5432:5432"
volumes:
  postgres_data:
```

---

### 👨‍💻 Autor

**Juan Carlos**  
Desenvolvedor Front-end & Back-end   
💼 Atualmente: Analista de Suporte N1 na Pulse  
🎓 Experiência com Angular, React, Spring Boot, Docker

---

### 📬 Contato

- [LinkedIn](https://www.linkedin.com/in/juansantosdev/)
- Email: juandev33@gmail.com

---

Se quiser, posso te gerar ele como um arquivo `.md` pronto pra subir no GitHub. Quer?