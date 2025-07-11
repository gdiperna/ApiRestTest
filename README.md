## API Landing Page Validation (NTT / OpenBank)

This project validates the landing page accessibility of various banking or enterprise websites using:

- JUnit (Unit Testing)
- RESTEasy (HTTP Client)
- Cucumber (BDD with Gherkin)

---

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/gdiperna/ApiRestTest
cd ApiRestTest
```

2. Run tests with Maven:

```bash
mvn clean install
```

---

##  Project Structure

```plaintext
ApiRestTest/
├── pom.xml
├── README.md
└── src/
    └── test/
        ├── java/
        │   ├── runner/
        │   │   └── CucumberTestRunner.java
        │   └── steps/
        │       ├── LandingNttSteps.java
        │       └── LandingOpenBankSteps.java
        └── resources/
            └── features/
                ├── landing_ntt.feature
                
```

---

##  Java Test Example (RESTEasy)

```java
Client client = ClientBuilder.newClient();
Response response = client
    .target("https://www.openbank.es")
    .request()
    .get();

int statusCode = response.getStatus();
assertEquals(200, statusCode);

response.close();
client.close();
```

---

## Gherkin Feature with Dynamic Data

```gherkin
Feature: Validate NTT Landing Page

  Scenario Outline: Verify response from the landing endpoint
    Given the user accesses the "<site>" landing page
    Then the API should respond with status code <status>

  Examples:
    | site                               | status |
    | https://es.nttdata.com             | 200    |
    | https://www.openbank.es            | 200    |
    | https://everisgroup.sharepoint.com| 301    |
    | https://www.nttdata.it             | 404    |
```

---

## Cucumber Report

Test reports generated with Maven Cucumber can be found at:

```plaintext
target/cucumber-report.html
```

