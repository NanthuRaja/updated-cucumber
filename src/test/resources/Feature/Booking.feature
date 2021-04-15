Feature: Verifying the adactin hotel booking functionality 

Scenario Outline: Verifying the booking details after entering all the fields 
	Given user is in login page 
	When user should login with valid "<userName>"and"<password>" 
	Then user should click search button after selecting the following details 
		| location | hotel| roomType | numberOfRooms|checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Sydney | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 11/04/2021 | 2 - Two | 2 - Two |
		|Adelaide | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 13/04/2021 | 2 - Two | 2 - Two |
	Then user should click on radiobutton and continue button 
	Then user should click book button after entering "<firstName>","<lastName>","<billingAddress>" and selecting the following details 
		| creditCardNo | creditCardType | expiryMonth | expiryYear | cvv |
		| 9876543210123456 |  VISA | July | 2021 | 111 |
		| 9876543210123477 |  Master Card | April| 2022 | 121 |
		| 9976543210123477 |  American Express| June | 2021 | 131 |
	And user should verify the "Booking Confirmation" message is displayed 
	
	Examples: 
		|userName|password|firstName|lastName|billingAddress|
		|prakash0|J5M3AD|Nantha|Kumar|Australia|
		
		
Scenario Outline: Verifying the booking details without entering any fields 
	Given user is in login page 
	When user should login with valid "<userName>"and"<password>" 
	Then user should click search button after selecting the following details 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Adelaide | Hotel Sunshine | Deluxe | 1 - One | 11/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Sydney | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 13/04/2021 | 2 - Two | 2 - Two |
	Then user should click on radiobutton and continue button 
	Then user should click on book button 
	And user should verify the "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month", "Please Enter your Credit Card CVV Number" message is displayed 
	
	Examples: 
		|userName|password|
		|prakash0|J5M3AD|