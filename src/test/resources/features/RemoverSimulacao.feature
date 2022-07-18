# encoding: iso-8859-1
Feature: Remover simulação previamente cadastrada pelo seu ID

  Scenario Outline: Remover simulação previamente cadastrada pelo ID
    When informo um ID "<id>"
    Then a API retorna o status "<status>" informando sucesso na remoção
    Examples:
      | id | status |
      | 11 | 204    |

  Scenario Outline: Informar ID que não corresponde a uma simulação
    When informo um ID "<id>"
    Then a API retorna o status "<status>" e a mensagem: "<mensagem>"
    Examples:
      | id   | status | mensagem                 |
      | 9000 | 404    | Simulação não encontrada |
