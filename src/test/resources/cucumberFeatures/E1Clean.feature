Feature: Create and update a user in Todo.ly
  Scenario: create and update the user
    Given I use none authentication
    When I use the POST request to /api/user.json with the body
    """
    {
        "Email": "santitest100@gmail.com",
        "Full Name": "Santiago Vargas",
        "Password": "Santiago123"
    }
    """
    Then the code that I receive should be 200