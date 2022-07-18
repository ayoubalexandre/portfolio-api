package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.when;

public class ConsultarSimulacaoCpf {
    private String cpf;

    @When("informo um CPF {string}")
    public void informoUmCpf(String cpf){
        this.cpf = cpf;
    }
    @Then("a API retorna o status {string} com a simulação cadastrada")
    public void aAPIRetornaOStatusComASimulacaoCadastrada(String status) {
        //chamada da api e validacoes do retorno
        when()
                .get("http://localhost:8082/api/v1/simulacoes/" + cpf)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body("cpf", Matchers.is(cpf))
                .body("id", Matchers.notNullValue())
                .body("nome", Matchers.notNullValue())
                .body("email", Matchers.notNullValue())
                .body("valor", Matchers.notNullValue())
                .body("parcelas", Matchers.notNullValue())
                .body("seguro", Matchers.notNullValue());
    }

    @Then("a API retorna o status {string} de simulação inexistente")
    public void aAPIRetornaOStatusDeSimulacaoInexistente(String status) {
        //chamada da api e validacoes do retorno
        when()
                .get("http://localhost:8082/api/v1/simulacoes/" + cpf)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)));
    }
}
