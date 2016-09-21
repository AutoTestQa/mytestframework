@completed
Feature: Item Add to bag

  Scenario: 001 - Item Add to bag
    Given I Navigate to customer application
    Then I should see the "Shop By Department" is Exit
    And I enter "shirt" in "SearchBox"
    And I choose to click on "searchContinue"
    And I wait for 3 seconds
    And I choose to click on "FirstProduct"
    And I wait for 10 seconds
