Este projeto é uma prova de conceito usando angularjs e java 

Autor: hernand.azevedo@gmail.com
24/01/2017

---------------- Ferramentas utilizadas - ------------------
HSQLDB: download em http://hsqldb.org/
Maven: https://maven.apache.org/download.cgi
Git: https://git-scm.com/downloads
Plugin do Chrome Advanced REST client oferecido por chromerestclient.com


Dependencias principais do maven
Spring 3  - Injecao de dependencia e Gerenciamento transacional
Junit - Testes
Mockito - Mock dos testes
JPA - Gravar no Banco de Dados
Jersey - Framework para webservices restful

- ----- Instalacao ---------------- 

--Para ver o banco de dados e fazer os selects
java -cp hsqldb.jar org.hsqldb.util.DatabaseManager

URL: jdbc:hsqldb:hsql://localhost/xdb
Usuario: sa
Senha: (sem senha)


--Para Inicializar o banco HSQLDB
java -cp hsqldb.jar org.hsqldb.Server -database.0 file:dbtest --dbname.0 xdb

--Para iniciar o projeto basta utilizar o comando abaixo para executar no Tomcat do maven 
mvn tomcat:run

------ Instalacao ---------------- 
