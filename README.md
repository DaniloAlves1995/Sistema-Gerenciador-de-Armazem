# Sistema Gerenciador de Armazem

Sistema para realizar o gerenciamento administrativo, operacional e financeiro de Armazens. Desenvolvido através de análises de requisitos do contexto de trabalho da empresa solicitante, o sistema apresenta gerenciamento de funcionários, clientes, mercadorias, caminhões e estoque. Possui exportação para PDF de nota de venda, nota avulsa e relatórios (vendas, entradas em estoque, estado atual do estoque, produção de sacas e entrada de caminhões).

## Introdução

Esse repositório é sobre um sistema desenvolvido para gerenciar uma empresa de armazens. O desenvolvimento da aplicação foi realizado utilizando a premissa de "Sistema sensível ao contexto", buscando adaptar as funcionalidades do sistema às necessidades da empresa, de forma a automatizar e otimizar o fluxo de trabalho. Nesse projeto foram contempladas as etapas:

- Levantamento e análise de requisitos
- Modelagem e implementação do banco de dados
- Implementação do software
- Testes de funcionalidade
- Implantação na empresa cliente

## Arquitetura

A arquitetura utiliza Design Pattern DAO (Data Access Object) que permite isolar a camada de negócios da aplicação, abstraindo a complexidade de operações no banco de dados para mecanismos de persistencia das classes DAO. Dessa forma, a responsabilidade para o acesso ao banco fica concentrada em uma camada específica da aplicação, deixando a camada de negócios para a lógica das funcionalidades.

## Organização

| Package | Description |
| --- | --- |
| Connection | Conexão com banco de dados |
| DAO | Camada de acesso ao banco de dados |
| Models | Entidades do negócio |
| Forms | GUI do sistema |
| Images | Imagens utilizadas na interface gráfica |
| Jasper | Arquivos binários para relatórios |
| Utils | Funções gerais |

## Tecnologias utilizadas

* Plataforma Java SE 8
* JasperReports
* MySQL

## Algumas telas do sistema

