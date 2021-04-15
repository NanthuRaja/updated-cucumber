Feature: Verifying the adactin hotel cancel booking functionality 

Scenario Outline: Verifying the booking details and cancel booking 
	Given user is in login page 
	When user should login with valid "<userName>"and"<password>" 
	Then user should click search button after selecting the following details 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Sydney | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
		|Adelaide| Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
	Then user should click on radiobutton and continue button 
	Then user should click book button after entering "<firstName>","<lastname>","<billingAddress>" and selecting the following details 
		| creditCardNo | creditCardType | expiryMonth | expiryYear | cvv |
		| 9876543210123456 |  VISA | May | 2021 | 211 |
		| 9776543210123456 |  Master Card| May | 2021 | 111 |
		| 9976543210123456 |  American Express | May | 2021 | 181 |
	Then user should verify the "Booking Confirmation" message is displayed 
	Then user should get orderId and click on My Itinerary 
	Then user should compare orderId and click on cancel booking 
	#	And user should verify the "The booking has been cancelled" success message is displayed 
	
	Examples: 
		|userName|password|firstName|lastname|billingAddress|
		|prakash0|J5M3AD|Nantha|Kumar|Australia|
		
		
		#Scenario Outline: Cancel booking with existing Order id 
		#	Given user is in login page 
		#	When user should login with valid "<userName>"and"<password>" 
		#	Then user should click on Booked Itinerary 
		#	Then user should verify "<orderId>" and cancel booking 
		#	And user should verify the "The booking has been cancelled" message is displayed 
		#	
		#	Examples: 
		#		|userName|password|orderId|
		#		|prakash0|J5M3AD|N64F8H8G6R|