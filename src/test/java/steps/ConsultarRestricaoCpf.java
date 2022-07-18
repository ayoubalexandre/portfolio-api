package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.when;


public class ConsultarRestricaoCpf {

    private String cpf;

    @When("informo o CPF {string}")
    public void cpfPossuiRestricao(String cpf) {
        this.cpf = cpf;
    }

    @Then("a API retorna o código {string} com a mensagem: {string}")
    public void retornaCodigo(String status, String mensagem) {
        //chamada da api e validacoes do retorno
        when()
                .get("http://localhost:8082/api/v1/restricoes/" + cpf)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)))
                .body("mensagem", Matchers.is(mensagem));
    }

    @Then("a API retorna o código {string}")
    public void retornaCodigo(String status) {
        //chamada da api e validacoes do retorno
        when()
                .get("http://localhost:8082/api/v1/restricoes/" + cpf)
                .then()
                .statusCode(Matchers.is(Integer.valueOf(status)));
    }
}
