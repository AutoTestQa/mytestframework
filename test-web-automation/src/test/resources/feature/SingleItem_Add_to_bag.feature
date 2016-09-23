@complete
Feature: Single Item Add to bag

  Scenario: 001 - Item Add to bag
    Given I Navigate to customer application
    Then I should see the "Shop By Department" is Exit
    When I enter "t-shirt" in "SearchBox"
    And I choose to click on "searchContinue"
    And I wait for 5 seconds
    And I choose to click on "FirstProduct"
    And I choose to click on "SizeDropdown"
    And I choose to click on "SizeMedium"
    And I choose to select "3" as a Visible Text from "Select Quantity" dropdown
    And I choose to click on "Add To Bag"
