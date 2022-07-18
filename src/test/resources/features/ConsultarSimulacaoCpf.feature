# encoding: iso-8859-1
Feature: Consultar as simulações cadastradas pelo CPF

  Scenario Outline: CPF que possui simulação cadastrada
    When informo um CPF "<cpf>"
    Then a API retorna o status "<status>" com a simulação cadastrada
    Examples:
      | cpf         | status |
      | 66414919004 | 200    |

  Scenario Outline: CPF que não possui simulação cadastrada
    When informo um CPF "<cpf>"
    Then a API retorna o status "<status>" de simulação inexistente
    Examples:
      | cpf         | status |
      | 19754986908 | 404    |