package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import java.util.*;


public class CriarSimulacao {
    private String cpf, nome, email, valor, parcela, seguro;

    @When("forem informados os dados: cpf {string}")
    public void receberCpf(String cpf) {
        this.cpf = cpf;
    }

    @When("nome {string}")
    public void nome(String nome) {
        this.nome = nome;
    }

    @When("email {string}")
    public void email(String email) {
        this.email = email;
    }

    @When("valor {string}")
    public void valor(String valor) {
        this.valor = valor;
    }

    @When("parcela {string}")
    public void parcela(String parcela) {
        this.parcela = parcela;
    }

    @When("seguro {string}")
    public void seguro(String seguro) {
        this.seguro = seguro;
    }

    @Then("a API retorna o código {string} com uma lista dos dados")
    public void apiRetornaCodigoLista(String status) {
        //mapeamento das strings para criação do json
        Map<String, String> map = new LinkedHashMap<>();
        map.put("nome", nome);
        map.put("cpf", cpf);
        map.put("email", email);
        map.put("valor", valor);
        map.put("parcelas", parcela);
        map.put("seguro", seguro);
        JSONObject jo = new JSONObject(map);

        //chamada da api e validacoes do retorno
        RestAssured.given()
                .body(jo.toString())
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8082/api/v1/simulacoes/")
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body("nome", Matchers.is(nome))
                .body("cpf", Matchers.is(cpf))
                .body("email", Matchers.is(email))
                .body("valor", Matchers.is(Integer.valueOf(valor)))
                .body("parcelas", Matchers.is(Integer.valueOf(parcela)))
                .body("seguro", Matchers.is(Boolean.valueOf(seguro)));
    }

    @Then("a API retorna o código {string} com uma lista dos erros")
    public void aAPIRetornaOCodigoComUmaListaDosErros(String status) {
        //mapeamento das strings para criação do json
        Map<String, String> map = new LinkedHashMap<>();
        map.put("nome", nome);
        map.put("cpf", cpf);
        map.put("email", email);
        map.put("valor", valor);
        map.put("parcelas", parcela);
        map.put("seguro", seguro);
        JSONObject jo = new JSONObject(map);

        //chamada da api e validacoes do retorno
        RestAssured.given()
                .body(jo.toString())
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8082/api/v1/simulacoes/")
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body(Matchers.notNullValue());
    }

    @Then("a API retorna o código {string} com a mensagem {string}")
    public void aAPIRetornaOCodigoComUmaMensagemDeErro(String status, String mensagem) {
        //mapeamento das strings para criação do json
        Map<String, String> map = new LinkedHashMap<>();
        map.put("nome", nome);
        map.put("cpf", cpf);
        map.put("email", email);
        map.put("valor", valor);
        map.put("parcelas", parcela);
        map.put("seguro", seguro);
        JSONObject jo = new JSONObject(map);

        //chamada da api e validacoes do retorno
        RestAssured.given()
                .body(jo.toString())
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8082/api/v1/simulacoes/")
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body("mensagem", Matchers.is(mensagem));
    }
}
