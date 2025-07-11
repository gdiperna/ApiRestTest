package steps;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandingNttSteps {

    private Response response;

    @Given("the user accesses the {string} landing page")
    public void the_user_accesses_the_landing_page(String siteUrl) {
        Client client = ClientBuilder.newClient();

        response = client
                .target(siteUrl)
                .request()
                .get();
        client.close();
    }

    @Then("the API should respond with status code {int}")
    public void the_api_should_respond_with_status_code(Integer expectedStatus) {
        int actualStatus = response.getStatus();
        assertEquals(expectedStatus.intValue(), actualStatus,
                "Expected: " + expectedStatus + ", but got: " + actualStatus);
    }
}

