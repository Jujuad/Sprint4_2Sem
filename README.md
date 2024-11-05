# Projeto Sprint4_2sem

Este projeto, desenvolvido para a entrega da Sprint 4 do segundo semestre de ADS, é uma aplicação completa baseada em arquitetura Spring Boot, com foco em funcionalidades de CRUD, segurança e documentação de API. A aplicação permite o gerenciamento de dados com persistência em um banco de dados Oracle, integração de autenticação e autorização por meio de JWT, além de um front-end para interação dos usuários.

## Tecnologias Utilizadas
- **Spring Boot**: Framework principal para a construção da aplicação, que fornece suporte para inicialização rápida e configuração.
- **Spring Data JPA**: Facilita a interação com o banco de dados Oracle, gerenciando operações CRUD e mapeamento objeto-relacional (ORM).
- **Jakarta EE**: Utilizado em componentes de segurança e filtro de requisições, implementando funcionalidades de interceptação e autorização com JWT.
- **JWT (JSON Web Token)**: Para autenticação e autorização seguras, garantindo acesso apenas a usuários autenticados nos endpoints protegidos.
- **Swagger**: Documentação interativa da API para fácil compreensão e testes dos endpoints disponíveis.
- **Lombok**: Reduz a quantidade de código boilerplate, como getters, setters e construtores.

## Funcionalidades Principais
- **Gerenciamento de Dados (CRUD)**: A aplicação permite o cadastro, consulta, atualização e remoção de informações, de acordo com as entidades definidas no modelo de dados.
- **Segurança com JWT**: Proteção dos endpoints através de autenticação JWT, onde somente usuários autenticados podem acessar determinados recursos da API.
- **Filtragem e Autorização**: Implementação de um filtro para validar o token JWT e permitir ou negar o acesso com base nas permissões do usuário.
- **Documentação da API com Swagger**: Fornece uma interface visual para explorar e testar os endpoints disponíveis, facilitando o desenvolvimento e manutenção.
- **Validação e Tratamento de Erros**: Tratamento robusto de erros e validações de dados, com feedback claro para o usuário.

## Estrutura do Projeto
- **Config**: Configurações da aplicação, incluindo Swagger e outras dependências.
- **Security**: Implementação das classes de segurança e filtros de autenticação JWT.
- **Controller**: Controladores responsáveis por expor os endpoints e gerenciar as requisições dos usuários.
- **Service**: Camada de lógica de negócios que processa as regras e validações aplicadas aos dados.
- **Repository**: Interface para acesso e manipulação de dados no banco Oracle, facilitada pelo Spring Data JPA.
- **DTOs (Data Transfer Objects)**: Estruturas para transferência de dados entre as camadas de apresentação e serviço, garantindo o encapsulamento e segurança das informações.

## Estrutura de Dependências (pom.xml)
No `pom.xml`, foram incluídas dependências essenciais para Spring Boot, Spring Security, JWT, Jakarta EE e Swagger, além das configurações para o banco de dados Oracle e o uso do Lombok para simplificação do código.

## Como Executar
1. Clonar o repositório e configurar o banco de dados Oracle com as tabelas e dados necessários.
2. Configurar o arquivo `application.properties` com as informações do banco de dados.
3. Executar o projeto através do Spring Boot.
4. Acessar o Swagger na URL `/swagger-ui.html` para explorar os endpoints e testar a API.

## Integrantes
- **Julia Andrade Dias** – RM552332
- **Emile de Moura Maia** – RM552235
- **Caio Vitor Urbano Neves** – RM552392
- **Guilherme Pereira de Oliveira** – RM552238
- **Maria Eduarda Costa de Araújo Vieira** – RM98760

---

Esse resumo cobre desde a estrutura do projeto e suas tecnologias até os principais objetivos e funcionalidades. Ele pode ser complementado com detalhes específicos sobre cada endpoint e instruções de configuração adicionais, caso necessário.
