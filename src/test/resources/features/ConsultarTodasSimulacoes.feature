# encoding: iso-8859-1
Feature: Consultar lista com todas as simula��es cadastradas

 Scenario Outline: Consultar lista quando h� simula��es cadastradas
   Given que h� uma ou mais de uma simula��o cadastrada
   Then a API deve retornar status de sucesso "<status>"
   Examples:
     | status |
     | 200    |

  Scenario Outline: Consultar lista quando n�o h� simula��es cadastradas
    Given que n�o h� simula��o cadastrada
    Then a API deve retornar status de falha "<status>"
    Examples:
      | status |
      | 204    |