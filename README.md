# 🦅 **PRODUCT API**
**Microservice And Web Engineering**

* *Turma:* 3SIT FIAP
* *Graduação:* Sistemas de Informação
* *Ano:* 2022

| Autor               | RM                                                |
| ----------------- | ---------------------------------------------------------------- |
| Isabela Caovila Baldim        | 84141 |
| Matheus Nathan Modanez        | 86065 |


## 👨🏻‍💻 O Projeto
Nossa aplicação se trata de um CRUD funcional desenvolvido seguindo os princípios de Clean Architecture e Design Patterns, em especial, o padrão Command. É possível criar, editar e deletar um produto. Em docs, você pode encontrar a collection com o modelo de requisições do postman. 

# Setup
Antes de realizar a criação de um novo produto, é necessário inserir as categorias no banco de dados.
Posteriormente, poderemos ter endpoints para também inserir categorias. 
Script para setup:
```sql
INSERT INTO `cathegory` (`id`, `name`)
VALUES (1, 'Electronics');

INSERT INTO `cathegory` (`id`, `name`)
VALUES (2, 'Computers and Accessories');

INSERT INTO `cathegory` (`id`, `name`)
VALUES (3, 'Healthcare');
```
