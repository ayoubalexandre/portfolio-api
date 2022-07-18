package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.when;

public class ConsultarTodasSimulacoes {

    @Given("que há uma ou mais de uma simulação cadastrada")
    public void queHaUmaOuMaisDeUmaSimulacaoCadastrada() {
        //não há implementação necessária para esse método
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

    @Given("que não há simulação cadastrada")
    public void queNaoHaSimulacaoCadastrada() {
        //não há implementação necessária para esse método
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
