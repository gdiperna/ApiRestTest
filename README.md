-This Project validates landing page 
accessibility of different banking or anterprise 
websites uising:

-Junit (Unit Testing)
-RESTEasy (HTTP client)
-Cocumber (BDD with Gherkin)

-How to get started?
git clone <https://github.com/gdiperna/ApiRestTest.git>

Once you have cloned it, you can use the Maven command:
mvn -U clean install


-Project Structure

├───src
│   └───test
│       ├───java
│       │   ├───runner
│       │   │       CucumberTestRunner.java # This file runs all the CucumberTest.
│       │   │
│       │   └───steps                      # Here we find all the steps used in the tests.
│       │           LandingNttSteps.java
│       │           LandingOpenBankSteps.java
│       │
│       └───resources
│           └───features
│                   landing_ntt.feature  # Gherkin Features
│
└───target
    │   cucumber-report.html 				 #Report Cucumber 
    │
    ├───generated-test-sources
    │   └───test-annotations
    └───test-classes
        ├───features
        │       landing_ntt.feature
        │
        ├───runner
        │       CucumberTestRunner.class 
        │
        └───steps  						
                LandingNttSteps.class 
                LandingOpenBankSteps.class

Java Test - RESTEeasy

Client client = ClientBuilder.newClient();
        Response response = client
                .target("https://www.openbank.es");
                .request()
                .get();

int statusCode = response.getStatus();
assertEquals(200, statusCode);

response.close();
lient.close();



Dynamic Gherkin Scenario

Feature: Validate NTT Landing Page

  Scenario Outline: Verify response from the landing endpoint
    Given the user accesses the "<site>" landing page
    Then the API should respond with status code <status>

    Examples:
      | site                                   | status |
      | https://es.nttdata.com                 | 200    |
      | https://www.openbank.es                | 200    |
      | https://everisgroup.sharepoint.com     | 403    |
      | https://es.nttdata.com/about-us        | 404    |


Test Reports 
target/cucumber-report.html





