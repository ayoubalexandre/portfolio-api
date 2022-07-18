# encoding: iso-8859-1
Feature: Remover simula��o previamente cadastrada pelo seu ID

  Scenario Outline: Remover simula��o previamente cadastrada pelo ID
    When informo um ID "<id>"
    Then a API retorna o status "<status>" informando sucesso na remo��o
    Examples:
      | id | status |
      | 11 | 204    |

  Scenario Outline: Informar ID que n�o corresponde a uma simula��o
    When informo um ID "<id>"
    Then a API retorna o status "<status>" e a mensagem: "<mensagem>"
    Examples:
      | id   | status | mensagem                 |
      | 9000 | 404    | Simula��o n�o encontrada |
