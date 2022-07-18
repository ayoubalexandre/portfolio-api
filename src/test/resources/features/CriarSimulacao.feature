# encoding: iso-8859-1
Feature: Cadastrar simulação para CPF

  Scenario Outline: Realizar cadastro de simulação para CPF
    When forem informados os dados: cpf "<cpf>"
    And nome "<nome>"
    And email "<email>"
    And valor "<valor>"
    And parcela "<parcela>"
    And seguro "<seguro>"
    Then a API retorna o código "<status>" com uma lista dos dados
    Examples:
      | cpf         | nome           | email                   | valor | parcela | seguro | status |
      | 86746524418 | Ayrton Senna   | asenna@mailinator.com   | 25000 | 12      | true   | 201    |
      | 23471427120 | Sergio Perez   | sperez@mailinator.com   | 40000 | 48      | false  | 201    |
      | 32599230551 | Nikita Mazepin | nmazepin@mailinator.com | 40000 | 2       | true   | 201    |

    Scenario Outline: Solicitar cadastro de simulação com informações fora do padrão
      When forem informados os dados: cpf "<cpf>"
      And nome "<nome>"
      And email "<email>"
      And valor "<valor>"
      And parcela "<parcela>"
      And seguro "<seguro>"
      Then a API retorna o código "<status>" com uma lista dos erros
      Examples:
        | cpf         | nome             | email                    | valor  | parcela | seguro | status |
        | 0300        | Thiago Amaral    | tamaral@mailinator.com   | 5000   | 10      | true   | 400    |
        | 65596665657 |                  | branco@mailinator.com    | 6000   | 11      | true   | 400    |
        | 22134252219 | Carlos Gamarra   | cgamarra                 | 1500   | 5       | true   | 400    |
        | 01170938825 | Harry Potter     | hpotter@mailinator.com   | 520    | 8       | false  | 400    |
        | 61853082074 | Nise da Silveira | nsilveira@mailinator.com | 100000 | 10      | true   | 400    |
        | 24662271690 | Silvia Lane      | slane@mailinator.com     | 40000  | 1       | false  | 400    |
        | 73862767884 | Levy Vigotski    | lvig@mailinator.com      | 3000   | 72      | false  | 400    |
        | 21374073377 | Roberto Bolanos  | rbolanos@mailinator.com  | 5000   | 5       | confia | 400    |

  Scenario Outline: Solicitar cadastro de simulação para CPF que já possui simulação
    When forem informados os dados: cpf "<cpf>"
    And nome "<nome>"
    And email "<email>"
    And valor "<valor>"
    And parcela "<parcela>"
    And seguro "<seguro>"
    Then a API retorna o código "<status>" com a mensagem "<mensagem>"
    Examples:
      | cpf         | nome          | email               | valor | parcela | seguro | status | mensagem         |
      | 73862767884 | Levy Vigotski | lvig@mailinator.com | 3000  | 12      | false  | 409    | CPF já existente |