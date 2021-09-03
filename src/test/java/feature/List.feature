Feature: List

  Scenario: Create List Request
    Given Valid credentials
    And a valid name, description and language for the list
    When the Create List request is called
    Then the status code must be 201
    And the list id in the payload shouldn't be null
    And the status message in the payload must reflect a list is created

  Scenario: Get List Details Request
    Given the id of an existing empty list created by a known user
    When the Get List Details request is called
    Then the status code must be 200
    And the creator of the list in the payload must be valid
    And the items list in the payload must be empty

  Scenario: Add Movie To List Request
    Given Valid credentials
    And the creation of a new list with valid parameters
    When the Add movie to list request is called
    Then the status code must be 201
    And the status message in the payload must reflect a list is created
    And the details of the list must reflect there is 1 item in the payload

  Scenario: Clear List Request
    Given Valid credentials
    And the creation of a new list with valid parameters
    And the addition of a movie to that list
    When the clear list request is called
    Then the status code must be 201
    And the status message in the payload must reflect a list is updated
    And the details of the list must reflect that the list is empty

  Scenario: Delete List Request
    Given Valid credentials
    And the creation of a new list with valid parameters
    When the delete list request is called
    Then the details of the list must reflect that the resource is not found