Feature: Verifying the Adactin hotel search functionality 

Scenario Outline: Verifying the application navigates to Select Hotel page after entering all the fields 
	Given user is in login page 
	When user should login with valid "<userName>"and"<password>" 
	Then user should click search button after selecting the following details 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Sydney | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 1 - One | 2 - Two |
		|Adelaide | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 13/04/2021 | 2 - Two | 1 - One |
	And user should verify the "Select Hotel" title is displayed 
	
	Examples: 
		|userName|password|
		|prakash0|J5M3AD|
		
		
Scenario Outline: Verifying the application navigates to Select Hotel page after entering mandatory fields
	Given user is in login page 
	When user should login with valid "<userName>"and"<password>" 
	Then user should click search button after selecting the mandatory details 
		| location | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | 
		|Melbourne | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 
		|Sydney | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 
		|Adelaide | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 
	And user should verify the "Select Hotel" title is displayed 
	
	Examples: 
		|userName|password|
		|prakash0|J5M3AD|
		
		
Scenario Outline: Verifying checkindate and checkoutdate functionality 
	Given user is in login page 
	When user should login with valid "<userName>"and"<password>" 
	Then user should click search button after selecting the following details 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 14/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Sydney | Hotel Sunshine | Deluxe | 1 - One | 14/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Adelaide | Hotel Sunshine | Deluxe | 1 - One | 14/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
	And user should verify the "Check-In Date shall be before than Check-Out Date", "Check-Out Date shall be after than Check-In Date" message is displayed 
	
	Examples: 
		|userName|password|
		|prakash0|J5M3AD|
		
		
Scenario Outline: Verifying application navigates to Select Hotel page without entering any fields 
	Given user is in login page 
	When user should login with valid "<userName>"and"<password>" 
	Then user should click on search button 
	And user should verify the "Please Select a Location" error message is displayed 
	
	Examples: 
		|userName|password|
		|prakash0|J5M3AD|
		
	