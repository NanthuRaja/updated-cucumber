package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	
	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardno() {
		return cardno;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getExpmonth() {
		return expmonth;
	}

	public WebElement getExpyear() {
		return expyear;
	}

	public WebElement getCcv() {
		return ccv;
	}

	public WebElement getBook() {
		return book;
	}

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement firstname;

	@FindBy(id = "last_name")
	private WebElement lastname;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement cardno;

	@FindBy(id = "cc_type")
	private WebElement cardtype;

	@FindBy(id = "cc_exp_month")
	private WebElement expmonth;

	@FindBy(id = "cc_exp_year")
	private WebElement expyear;

	@FindBy(id = "cc_cvv")
	private WebElement ccv;

	@FindBy(id = "book_now")
	private WebElement book;

	@FindBy(xpath = "//label[text()='Please Enter your First Name']")
	private WebElement checkfirstname;

	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement checklastname;

	@FindBy(xpath = "//label[text()='Please Enter your Address']")
	private WebElement checkaddress;

	@FindBy(xpath = "//label[text()='Please Select your Credit Card Type']")
	private WebElement checkcardtype;

	@FindBy(xpath = "//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement checkcardnumber;

	@FindBy(xpath = "//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement checkexpirymonth;

	@FindBy(xpath = "//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement checkcardcvv;
	
	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement confirmation;
	
	public WebElement getConfirmation() {
		return confirmation;
	}

	public WebElement getCheckfirstname() {
		return checkfirstname;
	}

	public WebElement getChecklastname() {
		return checklastname;
	}

	public WebElement getCheckaddress() {
		return checkaddress;
	}

	public WebElement getCheckcardtype() {
		return checkcardtype;
	}

	public WebElement getCheckcardnumber() {
		return checkcardnumber;
	}

	public WebElement getCheckexpirymonth() {
		return checkexpirymonth;
	}

	public WebElement getCheckcardcvv() {
		return checkcardcvv;
	}

	public void bookHotel(String firstName, String lastName, String billingAddress, String creditCardNo,
			String creditCardType, String expiryMonth, String expiryYear, String cvv) {
		byEnterText(firstName, lastName, billingAddress, creditCardNo, cvv);
		byVisibleText(creditCardType, expiryMonth, expiryYear);
		click(getBook());
	}

	public void byEnterText(String firstName, String lastName, String billingAddress, String creditCardNo, String cvv) {
		enterText(getFirstname(), firstName);
		enterText(getLastname(), lastName);
		enterText(getAddress(), billingAddress);
		enterText(getCardno(), creditCardNo);
		enterText(getCcv(), cvv);
	}

	public void byVisibleText(String creditCardType, String expiryMonth, String expiryYear) {
		selectByVisibleText(getCardtype(), creditCardType);
		selectByVisibleText(getExpmonth(), expiryMonth);
		selectByVisibleText(getExpyear(), expiryYear);
	}

	public void errorMessageVerification(String Checkfirstname, String Checklastname, String Checkaddress,
			String Checkcardnumber, String Checkcardtype, String Checkexpirymonth, String Checkcardcvv) {
		conditionAssert( Checkfirstname, getCheckfirstname().getText());
		conditionAssert( Checklastname, getChecklastname().getText());
		conditionAssert( Checkaddress, getCheckaddress().getText());
		conditionAssert( Checkcardnumber, getCheckcardnumber().getText());
		conditionAssert( Checkcardtype, getCheckcardtype().getText());
		conditionAssert( Checkexpirymonth, getCheckexpirymonth().getText());
		conditionAssert( Checkcardcvv, getCheckcardcvv().getText());
	}
	
	public void clickBook() {

		click(getBook());
	}

	public void verifyBooking(String message) {

		conditionAssert(message, getConfirmation().getText());

	}

}
