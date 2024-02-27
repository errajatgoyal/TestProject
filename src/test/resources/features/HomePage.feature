Feature: Home Page validations for Halo powered website

  As a user of the Halo Powered website
  I want to be able to land on the homepage
  So that I can access the information provided by the org

  Background:
    Given I am on the Halo powered home page

  Scenario: Able to see the mission statement
    Then I should be able to see their mission statement successfully

  Scenario Outline: Able to submit my contact details successfully
    Given I clicked on the contact button on the top
    And I have entered valid "<name>", "<emailAddress>" and a "<message>"
    When I click on the Submit button
    Then I should be able to submit the details successfully

    Examples:
      | name       | emailAddress | message  |
      | Abram Khan | al@gmail.com | Not spam |