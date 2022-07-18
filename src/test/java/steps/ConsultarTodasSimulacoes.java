package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.when;

public class ConsultarTodasSimulacoes {

    @Given("que h� uma ou mais de uma simula��o cadastrada")
    public void queHaUmaOuMaisDeUmaSimulacaoCadastrada() {
        //n�o h� implementa��o necess�ria para esse m�todo
    }

    @Then("a API deve retornar status de sucesso {string}")
    public void aAPIDeveRetornarOStatus(String status) {
        //chamada da api e validacoes do retorno
        when()
                .get("http://localhost:8082/api/v1/simulacoes/")
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body(Matchers.notNullValue());
    }

    @Given("que n�o h� simula��o cadastrada")
    public void queNaoHaSimulacaoCadastrada() {
        //n�o h� implementa��o necess�ria para esse m�todo
    }

    @Then("a API deve retornar status de falha {string}")
    public void aAPIDeveRetornarStatusDeFalha(String status) {
        //chamada da api e validacoes do retorno
        when()
                .get("http://localhost:8082/api/v1/simulacoes/")
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body(Matchers.emptyOrNullString());
    }
}
