Feature: Verifying the Adactin details 

Scenario: Verifying Adactin login with valid credentials 
	Given user is in login page 
	When user should  login enter userName and password 
		|userName|password|
		|prakash0|J5M3AD|
	Then user should  search hotel after select the location,hotel,roomType,numberOfRooms,checkInDate,checkOutDate,adultsPerRoom and childrenPerRoom 
		| location | hotel| roomType | numberOfRooms | checkInDate| checkOutDate | adultsPerRoom | childrenPerRoom |
		|Melbourne | Hotel Sunshine | Deluxe | 1 - One | 10/04/2021 | 12/04/2021 | 2 - Two | 2 - Two |
	Then user should click on radiobutton and continue button
	Then user should book hotel after enter firstName,lastname,billingAddress,creditCardNo,creditCardType,expiryMonth,expiryYear and cvv 
		| firstName | lastname | billingAddress | creditCardNo | creditCardType | expiryMonth | expiryYear | cvv |
		| Nantha | Kumar | Australia | 9876543210123456 |  VISA | May | 2021 | 111 |
	
	
