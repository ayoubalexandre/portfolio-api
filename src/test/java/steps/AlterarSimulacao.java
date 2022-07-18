package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlterarSimulacao {
    public static final String HTTP_LOCALHOST_8082_API_V_1_SIMULACOES = "http://localhost:8082/api/v1/";
    private String cpf, nome, email, valor, parcela, seguro, retorno;

    @When("forem informados os dados para edição: cpf {string}")
    public void receberCpf(String cpf) {
        this.cpf = cpf;
    }

    @When("nome editado {string}")
    public void nome(String nome) {
        this.nome = nome;
    }

    @When("email editado {string}")
    public void email(String email) {
        this.email = email;
    }

    @When("valor editado {string}")
    public void valor(String valor) {
        this.valor = valor;
    }

    @When("parcela editada {string}")
    public void parcela(String parcela) {
        this.parcela = parcela;
    }

    @When("seguro editado {string}")
    public void seguro(String seguro) {
        this.seguro = seguro;
    }

    @Then("a API retorna o código {string} em caso de sucesso")
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
                .put(HTTP_LOCALHOST_8082_API_V_1_SIMULACOES + "simulacoes/" + cpf)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body("nome", Matchers.is(nome))
                .body("cpf", Matchers.is(cpf))
                .body("email", Matchers.is(email))
                .body("valor", Matchers.is(Float.valueOf(valor)))
                .body("parcelas", Matchers.is(Integer.valueOf(parcela)))
                .body("seguro", Matchers.is(Boolean.valueOf(seguro)));
    }

    @Then("a API retorna o código {string} e a mensagem {string}")
    public void aAPIRetornaOCodigoEAMensagem(String status, String mensagem) {
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
                .put("http://localhost:8082/api/v1/simulacoes/" + cpf)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body("mensagem", Matchers.is(mensagem));
    }

    @Then("a API retorna o código {string} e a mensagem de falha: {string}")
    public void aAPIRetornaOCodigoIndicandoAFalha(String status, String mensagem) {
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
                .put("http://localhost:8082/api/v1/simulacoes/" + cpf)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body(Matchers.is(mensagem));
    }
}
