Feature: Login page

  User will login and manage the varios orders.

  Background:
  Given User is already on login page

Scenario: Login with valid credentials
  Given User enters abcd@gmail.com and abcd@1234
  When Click on login button
  Then Login is successful


  Scenario Outline: Login with invalid credentials
    Given User enters invalid username and password
    When Click on login button
    Then I should see an error message indicating "<error_message>"
    Examples:
      | username          | password     | error-message |
      | abc@gmail.com     | abc@1234     |  Warning: No match for E-Mail Address and/or Password. |
      | invalid@gmail.com | invalid@9878 |  Warning: No match for E-Mail Address and/or Password. |


  Scenario: Navigate to the forgot password page
      When User clicks on forgot password link
      Then user is redirected to the password reset page