@complete
Feature: Multiple Items Add to bag

  Scenario Outline: 001 - Item Add to bag
    Given I Navigate to customer application
    Then I should see the "Shop By Department" is Exit
    When I enter "<product>" in "SearchBox"
    And I choose to click on "searchContinue"
    And I choose to click on "FirstProduct"
    And I choose to click on "SizeDropdown"
    And I choose to click on "SizeMedium"
    And I choose to select "3" as a Visible Text from "Select Quantity" dropdown
    And I choose to click on "Add To Bag"

    Examples: 
      | product |
      | t-shirt |
      | t-shirt |
