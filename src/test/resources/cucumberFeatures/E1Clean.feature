Feature: Create and update a user in Todo.ly
  Scenario: create and update the user
    Given I use none authentication
    When I use the POST request to /api/user.json with the body
    """
    {
        "Email": "santitest116@gmail.com",
        "FullName": "Santiago Vargas",
        "Password": "Santiago123"
    }
    """
    Then the code that I receive should be 200
    And the expected body should be
    """
    {
        "Id": "IGNORE",
        "Email": "santitest116@gmail.com",
        "Password": null,
        "FullName": "Santiago Vargas",
        "TimeZone": 0,
        "IsProUser": false,
        "DefaultProjectId": "IGNORE",
        "AddItemMoreExpanded": false,
        "EditDueDateMoreExpanded": false,
        "ListSortType": 0,
        "FirstDayOfWeek": 0,
        "NewTaskDueDate": -1,
        "TimeZoneId": "IGNORE"
    }
    """
    When I update in /api/user.json with the user santitest116@gmail.com, the password Santiago123 and the body
    """
    {
        "FullName": "Alejandro Vargas"
    }
    """
    Then the code that I receive should be 200