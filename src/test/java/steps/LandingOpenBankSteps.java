package steps;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandingOpenBankSteps {

    @Test
    void testOpenBankLanding() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("https://www.openbank.es")
                .request()
                .get();

        int statusCode = response.getStatus();
        assertEquals(200, statusCode);

        response.close();
        client.close();
    }

    @Test
    void testLandingShouldFail404() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("https://www.openbank.es/nonexistentpage")
                .request()
                .get();


        assertEquals(404, response.getStatus(), "Expected 200 but got " + response.getStatus());
        client.close();
    }
}
