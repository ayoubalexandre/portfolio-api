# encoding: iso-8859-1
Feature: Consultar as simula��es cadastradas pelo CPF

  Scenario Outline: CPF que possui simula��o cadastrada
    When informo um CPF "<cpf>"
    Then a API retorna o status "<status>" com a simula��o cadastrada
    Examples:
      | cpf         | status |
      | 66414919004 | 200    |

  Scenario Outline: CPF que n�o possui simula��o cadastrada
    When informo um CPF "<cpf>"
    Then a API retorna o status "<status>" de simula��o inexistente
    Examples:
      | cpf         | status |
      | 19754986908 | 404    |