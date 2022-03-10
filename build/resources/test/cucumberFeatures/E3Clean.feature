Feature: Create a Token and then delete the Token
  Scenario: Create a Token and then delete the Token

    Given I use basic authentication
    When I use the GET request to /api/authentication/token.json with the body
    """

    """
    Then the code that I receive should be 200
    And I save TokenString of the response in token_str
    And the expected body should be
    """
    {
        "TokenString": token_str,
        "UserEmail": "santiavctf@gmail.com",
        "ExpirationTime": "IGNORE"
    }
    """
    When I send a DELETE request with token_str to /api/authentication/token.json
    Then the code that I receive should be 200
    And the expected body should be
    """
    {
        "TokenString": token_str,
        "UserEmail": "santiavctf@gmail.com",
        "ExpirationTime": "IGNORE"
    }
    """