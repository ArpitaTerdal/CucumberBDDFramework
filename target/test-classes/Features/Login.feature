Feature: Login Functionality

Scenario Outline: Login with valid credentials

Given User navigates to login Page
When User enters valid username <Email>
And User enters valid password <Password>
And User clicks on Login button
Then User should login successfully.
Examples:
|Email           |Password   |
|arpita@gmail.com|Arpita@1998|

Scenario: Login with Invalid credentials

Given User navigates to login Page
When User enters invalid username
And User enters invalid password "test123"
And User clicks on Login button
Then User should get proper warning message

Scenario: Login with valid email and Invalid password

Given User navigates to login Page
When User enters valid username "arpita@gmail.com"
And User enters invalid password "test123"
And User clicks on Login button
Then User should get proper warning message

Scenario: Login with invalid email and valid password

Given User navigates to login Page
When User enters invalid username
And User enters valid password "Arpita@1998"
And User clicks on Login button
Then User should get proper warning message

Scenario: Login without entering username and paaword

Given User navigates to login Page
When User clicks on Login button
Then User should get proper warning message