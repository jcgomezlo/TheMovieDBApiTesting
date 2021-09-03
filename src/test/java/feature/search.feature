Feature: Search

  Scenario: Search query Request
    Given the name of a movie with results
    When the search query request is called
    Then the status code must be 200
    And the title in the payload must be the one expected
    And the results is the payload must be greater than 0