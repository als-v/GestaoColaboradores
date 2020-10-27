<h1 align="center"> Gestão Colaboradores 
<div align="center">
<a href="https://travis-ci.com/github/als-v/GestaoColaboradores/builds">
<img  src="https://travis-ci.com/als-v/GestaoColaboradores.svg?branch=master">
</a>
</div>
</h1>
<br>


<!-- TABLE OF CONTENTS -->
## Conteúdos

* [Sobre o Sistema](#about-the-project)
  * [Tecnologias](#built-with)
* [Principais Funcionalidades](#features)
* [Como rodar a apresentação](#getting-started)
  * [Pré-requisitos](#prerequisites)
  * [Instalação](#installation)
* [Contato](#contact)



<!-- ABOUT THE PROJECT -->
## Sobre o sistema

Em poucas palavras, é um sistema de gestão de pessoas. É uma tecnologia que auxilia a equipe de Relações Humanas a controlar todas as tarefas operacionais do setor. Ela realiza tal feito aplicando, monitorando e arquivando diferentes tipos de avaliações, sejam elas de desempenho, plano de carreira, treinamentos, feedback, pacotes de remuneração, entre outras diversas avaliações.

### Tecnologias
O sistema está sendo feito com as seguintes tecnologias:
* [Java](https://www.java.com/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [PostgreSQL](https://www.postgresql.org/download/)


<!-- FEATURES -->
## Principais Funcionalidades
Nosso sistema apresentará as principais funcionalidades:
* O sistema deve permitir ao usuário realizar testes de desempenho.
* O sistema deve permitir a empresa criar diferentes testes que serão feitos pelos seus colaboradores.
* O sistema deve permitir a empresa visualizar os resultados referentes aos testes em diferentes gráficos.
* O sistema deve permitir o controle da aplicação dos testes, mostrando qual colaborador ainda não realizou.


<!-- GETTING STARTED -->
## Como rodar a aplicação

O tutorial abaixo foi feito utilizando o sistema operacional Ubuntu 18.04.5.

### Pré-requisitos

[Java SE 11](https://www.oracle.com/java/technologies/javase-downloads.html)
[PostgreSQL](https://www.postgresql.org/download/)
[Maven](https://maven.apache.org/)

### Instalação

1. Clone o repositorio
```sh
git clone https://github.com/als-v/GestaoColaboradores
```
2. No terminal rode os seguintes comandos:
	```sh
	sudo -i -u postgres
	```
	```sh
	createdb gestaocolaboradores
	```
	E caso não tenha uma senha definida para o usuário padrão do PostgreSQL 'postgres', defina uma nova senha com o seguinte comando:
	```sh
	sudo passwd postgres
	Digite a nova senha UNIX:teste
	Redigite a nova senha UNIX:teste
	passwd: senha atualizada com sucesso
	```
3. Na pasta do projeto, acesse o seguinte caminho: 
	```sh
	GestaoColaboradores/src/main/resources
	```
	E dentro desta pasta, acesse o arquivo 'aplication.properties' altere o valor da variável 'spring.datasource.password' com a senha criada anteriormente, exemplo:
	```sh
	spring.datasource.password=teste
	```
4. Novamente na pasta do projeto, rode o seguinte comando:
	```sh
	mvn spring-boot:run
	```
5. Agora, no seu navegador, acesse o seguinte endereço:	
	```sh	
	http://localhost:8080	
	```
<!-- USAGE EXAMPLES 
## Exemplo de uso
Colocar imagens aqui
-->
<!-- CONTACT -->
## Contato

Alisson da Silva Vieira - alisson.v3@hotmail.com  
Guilherme Valério - heatsone84@gmail.com

Project Link: [https://github.com/als-v/GestaoColaboradores.git](https://github.com/als-v/GestaoColaboradores.git)



