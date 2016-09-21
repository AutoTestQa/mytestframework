@completed

Feature: Item Add to bag

Scenario: 001 - Item Add to bag

Given I Navigate to customer application
#And I choose to select "English" as a Visible Text from "Country" dropdown
And I choose to click on "SignIn"
And I enter "9711130038" in "MobileNumber"
And I enter singh in "Password"
And I Choose to select "LoginOTP" CheckBox
And I choose to click on "Login"
Then I should see the "SignInImage" is Exit
Then I should see the text of "forgotLink" as "Forgot your password?"



