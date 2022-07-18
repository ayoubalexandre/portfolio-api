# encoding: iso-8859-1
Feature: Consultar restri��o de CPF

  Scenario Outline: Realizar consulta na API de CPF com restri��o
    When informo o CPF "<cpf>"
    Then a API retorna o c�digo "<status>" com a mensagem: "<mensagem>"
    Examples:
      | cpf         | status | mensagem                           |
      | 97093236014 | 200    | O CPF 97093236014 possui restri��o |
      | 60094146012 | 200    | O CPF 60094146012 possui restri��o |
      | 84809766080 | 200    | O CPF 84809766080 possui restri��o |
      | 62648716050 | 200    | O CPF 62648716050 possui restri��o |
      | 26276298085 | 200    | O CPF 26276298085 possui restri��o |
      | 01317496094 | 200    | O CPF 01317496094 possui restri��o |
      | 55856777050 | 200    | O CPF 55856777050 possui restri��o |
      | 19626829001 | 200    | O CPF 19626829001 possui restri��o |
      | 24094592008 | 200    | O CPF 24094592008 possui restri��o |
      | 58063164083 | 200    | O CPF 58063164083 possui restri��o |

  Scenario Outline: Realizar consulta na API de CPF sem restri��o
    When informo o CPF "<cpf>"
    Then a API retorna o c�digo "<status>"
    Examples:
      | cpf         | status |
      | 25877990586 | 204    |
      | 53922905668 | 204    |
      | 53537957840 | 204    |
      | 18168188527 | 204    |






