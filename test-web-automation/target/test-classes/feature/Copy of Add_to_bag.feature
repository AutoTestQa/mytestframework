@completed

Feature: Item Add to bag

Scenario: 001 - Item Add to bag

Given I enter Ravi in id_firstname
And I am don here
And I enter Ravi in id_firstname
And I enter singh in id_lastname
And I choose to click on id_signin
Then I should see the text of xpath_locator as "Create account"

