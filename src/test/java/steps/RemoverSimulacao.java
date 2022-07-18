package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.when;

public class RemoverSimulacao {
    private String id;

    @When("informo um ID {string}")
    public void informoUmId(String id){
        this.id = id;
    }

    @Then("a API retorna o status {string} informando sucesso na remoção")
    public void aAPIRetornaOStatusInformandoSucessoNaRemocao(String status) {
        //chamada da api e validacoes do retorno
        when()
                .delete("http://localhost:8082/api/v1/simulacoes/" + id)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)));
    }

    @Then("a API retorna o status {string} e a mensagem: {string}")
    public void aAPIRetornaOStatusEAMensagem(String status, String mensagem) {
        //chamada da api e validacoes do retorno
        when()
                .delete("http://localhost:8082/api/v1/simulacoes/" + id)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body(Matchers.is(mensagem));
    }
}
