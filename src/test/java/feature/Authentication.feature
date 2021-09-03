Feature: Authentication

  Scenario: Valid Authentication
    Given A request token given by the API
    And the authentication is successful with the credentials given
    When the get session id request gets called
    Then the status code must be 200
    And the success in the payload must be true
    And the session id in the payload must not be null

  Scenario: Valid Authentication
    Given A request token given by the API
    And invalid credentials
    When the  validate with login request gets called
    Then the status code must be 401
    And the success in the payload must be false
