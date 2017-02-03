Este projeto � um webservice para envio de sms 

Autor: Hernand Dos Santos Azevedo
24/01/2017

---------------- Ferramentas utilizadas - ------------------
IDE: Eclipse Neon : http://www.eclipse.org/downloads/eclipse-packages/
Plugin para eclipse de Cobertura de testes: Eclemma 2.3.3 em http://www.eclemma.org/download.html
HSQLDB: download em http://hsqldb.org/
Maven: https://maven.apache.org/download.cgi
Git: https://git-scm.com/downloads
Plugin do Chrome Advanced REST client oferecido por chromerestclient.com


Dependencias principais do maven
Spring 3  - Injecao de dependencia e Gerenciamento transacional
Junit - Testes
Mockito - Mock dos testes
JPA - Grava��o no Banco de Dados
Jersey - Framework para webservices restful

- ----- Instala��o ---------------- 

--Para ver o banco de dados e fazer os selects
java -cp hsqldb.jar org.hsqldb.util.DatabaseManager

URL: jdbc:hsqldb:hsql://localhost/xdb
Usuario: sa
Senha: (sem senha)


--Para Inicializar o banco HSQLDB
java -cp hsqldb.jar org.hsqldb.Server -database.0 file:dbtest --dbname.0 xdb

--Para iniciar o projeto basta utilizar o comando abaixo para executar no Tomcat do maven 
mvn tomcat:run

------ Instala��o ---------------- 

-------------- Para chamar o WebService ---------------

Utilizando o plugin do chrome Advaced Rest Client realizar as chamadas usando o endere�o abaixo

PUT http://localhost:8080/api/v1/sms
Content-Type: application/json

{
  "id": 1,
  "from": "5521973448438",
  "to": "5521975405717",
  "body": "Oi tudo bem",
  "validade": "25/05/2017"
}

-- Observa��o importante -- Caso seja usado o mesmo id em subsequentes testes, n�o ser� poss�vel gravar no banco de dados, visto que usamos o id que vem da chamada ao Webservice para gravar na tabela.
-- Como forma de minimizar este problema, uma melhoria seria gerar o ID automaticamente na tabela usando JPA. 

------------ Considera��es sobre a implementa��o ------------ 

A principal classe do projeto � ApiService - esta classe � o Webservice Restful respons�vel por receber as 
chamadas para o envio de SMS.

O projeto foi criado seguindo algumas boas pr�ticas 
A. Daos
B. Programa��o orientada a interfaces
C. Separa��o de responsabilidades em classes de neg�cio.
D. Inje��o de Depend�ncia
E. Testes Unit�rios com mais de 90% de cobertura de testes(veja a imagem CoberturaJunit.PNG)
F. Gerenciamento transacional
G. Javadocs
H. Tratamento de Exceptions

Al�m disso foi criada uma classe para futura implementa��o da chamada a API real da Operadora chamada OperadoraSmsServiceBoImpl.