# encoding: iso-8859-1
Feature: Consultar lista com todas as simulações cadastradas

 Scenario Outline: Consultar lista quando há simulações cadastradas
   Given que há uma ou mais de uma simulação cadastrada
   Then a API deve retornar status de sucesso "<status>"
   Examples:
     | status |
     | 200    |

  Scenario Outline: Consultar lista quando não há simulações cadastradas
    Given que não há simulação cadastrada
    Then a API deve retornar status de falha "<status>"
    Examples:
      | status |
      | 204    |