Feature: Register Functionality

Scenario: User creates account with mandatory fields

Given User navigates to Create Account page
When User enters below fields 
|firstName  |akash								|
|lastName   |patil								|
|email			|arpitat123@gmail.com	|
|telephone	|1234567							|
|password		|12345tre							|
And User clicks privacy policy checkbox
And User clicks on continue button
Then User account should created successfully

Scenario: User creates account with all fields

Given User navigates to Create Account page
When User enters below fields 
|firstName  |akash								|
|lastName   |patil								|
|email			|arpitat123@gmail.com	|
|telephone	|1234567							|
|password		|12345tre							|
And User selects yes for newsettler
And User clicks privacy policy checkbox
And User clicks on continue button
Then User account should created successfully

Scenario: User creates duplicate account using duplicate email

Given User navigates to Create Account page
When User enters below fields with duplicate email 
|firstName  |akash								|
|lastName   |patil								|
|email			|arpita@gmail.com			|
|telephone	|1234567							|
|password		|1234568							|
And User clicks privacy policy checkbox
And User clicks on continue button
Then User should get duplicate email warning message

Scenario: User creates  account without entering fields

Given User navigates to Create Account page
When User clicks on continue button
Then User should get warning message for every mandatory fields