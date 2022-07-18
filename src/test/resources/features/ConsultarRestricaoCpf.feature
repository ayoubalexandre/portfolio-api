# encoding: iso-8859-1
Feature: Consultar restrição de CPF

  Scenario Outline: Realizar consulta na API de CPF com restrição
    When informo o CPF "<cpf>"
    Then a API retorna o código "<status>" com a mensagem: "<mensagem>"
    Examples:
      | cpf         | status | mensagem                           |
      | 97093236014 | 200    | O CPF 97093236014 possui restrição |
      | 60094146012 | 200    | O CPF 60094146012 possui restrição |
      | 84809766080 | 200    | O CPF 84809766080 possui restrição |
      | 62648716050 | 200    | O CPF 62648716050 possui restrição |
      | 26276298085 | 200    | O CPF 26276298085 possui restrição |
      | 01317496094 | 200    | O CPF 01317496094 possui restrição |
      | 55856777050 | 200    | O CPF 55856777050 possui restrição |
      | 19626829001 | 200    | O CPF 19626829001 possui restrição |
      | 24094592008 | 200    | O CPF 24094592008 possui restrição |
      | 58063164083 | 200    | O CPF 58063164083 possui restrição |

  Scenario Outline: Realizar consulta na API de CPF sem restrição
    When informo o CPF "<cpf>"
    Then a API retorna o código "<status>"
    Examples:
      | cpf         | status |
      | 25877990586 | 204    |
      | 53922905668 | 204    |
      | 53537957840 | 204    |
      | 18168188527 | 204    |






