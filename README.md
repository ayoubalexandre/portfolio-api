# Portfólio de Teste de API

Portfólio de teste de API com Java, Cucumber e RestAssured

##  Requisitos
* Java 8+ JDK deve estar instalado
* Maven deve estar instalado e configurado no path da aplicação
* Encoding da IDE estar setado como ISO-8859-1
* A aplicação da API estar disponível na porta 8082

## Como executar a aplicação

Na raiz do projeto, através de seu Prompt de Commando/Terminal/Console execute o comando

```bash
mvn clean install
```

Por dentro da IDE, você pode acessar as opções do Lifecycle do Maven e executar os comandos, na seguinte ordem:
```bash
1 - clean;
2 - install;
```
É possível, ainda, executar somente a classe RunCucumberTest, onde está configurado o runner do projeto.
Para isso, basta acessar a classe e executá-la.

## Organização do código

O código está organizado em steps, runners e features.
As features, são os cenários cucumber dos testes e estão no caminho: scr/test/resources/features.
Os steps são as classes com o código fonte e estão no caminho: scr/test/java/steps.
O runner, que é a classe executora dos steps, está no caminho: scr/test/java/steps.
