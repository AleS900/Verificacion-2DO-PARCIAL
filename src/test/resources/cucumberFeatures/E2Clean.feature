Feature: Create a project, then create, edit and delete an item in Todo.ly
  Scenario: create a project, then create, edit and delete an item

    Given I use basic authentication

    When I use the POST request to /api/projects.json with the body
    """
    {
        "Content":"E2Project",
        "Icon":4
    }
    """
    Then the code that I receive should be 200
    And the expected body should be
    """
    {
        "Id": "IGNORE",
        "Content": "E2Project",
        "ItemsCount": 0,
        "Icon": 4,
        "ItemType": "IGNORE",
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    And I save Id of the response in E2_Project_Id


    When I use the POST request to /api/items.json with the body
    """
    {
        "Content":"FirstItem",
        "ProjectId": E2_Project_Id
    }
    """
    Then the code that I receive should be 200
    And the expected body should be
    """
    {
        "Id": "IGNORE",
        "Content": "FirstItem",
        "ItemType": "IGNORE",
        "Checked": false,
        "ProjectId": E2_Project_Id,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": "IGNORE",
        "Priority": 4,
        "LastSyncedDateTime": "IGNORE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "IGNORE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": "IGNORE"
    }
    """
    And I save Id of the response in E2_Item_Id


    When I use the PUT request to /api/items.json with the body
    """
    {
        "Checked":true
    }
    """
    Then the code that I receive should be 200


    When I use the DELETE request to /api/items/E2_Item_Id.json with the body
    """
    """
    Then the code that I receive should be 200



