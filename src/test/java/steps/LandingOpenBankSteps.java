package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandingOpenBankSteps {

    static ExtentReports report;
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @Test
    void testOpenBankLanding() {
        ExtentSparkReporter sparks = new ExtentSparkReporter("target/extent-report.html");
        extent.attachReporter(sparks);
        test = extent.createTest("Test Landing Page OpenBank 200");
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("https://www.openbank.es")
                .request()
                .get();




        int statusCode = response.getStatus();
        assertEquals(200, statusCode);

        response.close();
        client.close();
        extent.flush();
    }

    @Test
    void testLandingShouldFail404() {
        test = extent.createTest("Test Landing Page OpenBank Fail 404");
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("https://www.openbank.es/nonexistentpage")
                .request()
                .get();


        assertEquals(404, response.getStatus(), "Expected 200 but got " + response.getStatus());
        client.close();
        extent.flush();
    }
}
