Feature: Search Functionality

Scenario: User searches for valid product

Given User opens the application
When User enters valid product "HP" into search field
And User clicks on search button
Then User should get valid product displayed in search results

Scenario: User searches for invalid product

Given User opens the application
When User enters invalid product "Honda" into search field
And User clicks on search button
Then User should get No product warning message

Scenario: User searches for product without entering any product

Given User opens the application
When User clicks on search button
Then User should get No product warning message

 
