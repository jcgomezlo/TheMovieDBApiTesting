Feature: Movie

  Scenario: Get Details of Movie Request
    Given the id of a movie
    When the movie details request is called
    Then the status code must be 200
    And the title in the payload must be the one expected
    And the genre in the payload must be the one expected

  Scenario: Rate Movie Request
    Given the id of a movie
    And a valid rate
    And Valid credentials
    When the rate movie request is called
    Then the status code must be 201

