# encoding: iso-8859-1
Feature: Alterar simulação cadastrada para um CPF

  Scenario Outline: Alterar simulação previamente cadastrada para um CPF
    When forem informados os dados para edição: cpf "<cpf>"
    And nome editado "<nome>"
    And email editado "<email>"
    And valor editado "<valor>"
    And parcela editada "<parcela>"
    And seguro editado "<seguro>"
    Then a API retorna o código "<status>" em caso de sucesso
    Examples:
      | cpf         | nome              | email              | valor | parcela | seguro | status |
      | 66414919004 | Fulano de Tal     | fulano@gmail.com   | 11000 | 3       | true   | 201    |
      | 17822386034 | Deltrano da Silva | deltrano@gmail.com | 20000 | 5       | false  | 201    |

  Scenario Outline: Solicitar alteração para um CPF que não possui simulação
    When forem informados os dados para edição: cpf "<cpf>"
    And nome editado "<nome>"
    And email editado "<email>"
    And valor editado "<valor>"
    And parcela editada "<parcela>"
    And seguro editado "<seguro>"
    Then a API retorna o código "<status>" e a mensagem "<mensagem>"
    Examples:
      | cpf         | nome           | email                  | valor | parcela | seguro | status | mensagem           |
      | 28674324800 | Alberto Soares | asoares@mailinator.com | 5900  | 24      | false  | 404    | CPF não encontrado |

  Scenario Outline: Solicitar alteração de uma simulação com dados fora do padrão
    When forem informados os dados para edição: cpf "<cpf>"
    And nome editado "<nome>"
    And email editado "<email>"
    And valor editado "<valor>"
    And parcela editada "<parcela>"
    And seguro editado "<seguro>"
    Then a API retorna o código "<status>" e a mensagem de falha: "<mensagem>"
    Examples:
      | cpf         | nome              | email  | valor | parcela | seguro | status | mensagem         |
      | 17822386034 | Deltrano da Silva | deltra | 20000 | 5       | false  | 409    | CPF já existente |