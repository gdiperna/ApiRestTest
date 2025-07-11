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
      | https://www.google.com                 | 200    |
      | https://www.nttdata.fake               | 0      |
      | https://nttdata.com/contact            | 200    |
      | https://api.openbank.es                | 404    |
      | https://www.example.com/404            | 404    |