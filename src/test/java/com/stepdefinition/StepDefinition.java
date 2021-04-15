package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.page.BookHotelPage;
import org.page.CancelBookingpage;
import org.page.LoginPage;
import org.page.SearchHotelPage;
import org.page.SelectHotelPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {

	@Given("user is in login page")
	public void userIsInLoginPage() {

		getdriver();
		loadUrl("https://adactinhotelapp.com/index.php");
	}

	@When("user should login with valid {string}and{string}")
	public void userShouldLoginWithValidAnd(String username, String password) {

		LoginPage lp = new LoginPage();
		lp.login(username, password);
	}

	@Then("user should click search button after selecting the following details")
	public void userShouldClickSearchButtonAfterSelectingTheFollowingDetails(
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> list = dataTable.asMaps();
		Map<String, String> map = list.get(0);
		String location = map.get("location");
		String hotel = map.get("hotel");
		String roomType = map.get("roomType");
		String numberOfRooms = map.get("numberOfRooms");
		String checkInDate = map.get("checkInDate");
		String checkOutDate = map.get("checkOutDate");
		String adultsPerRoom = map.get("adultsPerRoom");
		String childrenPerRoom = map.get("childrenPerRoom");

		SearchHotelPage sh = new SearchHotelPage();
		sh.searchByAll(location, hotel, roomType, numberOfRooms, adultsPerRoom, childrenPerRoom, checkOutDate,
				checkInDate);
	}

	@Then("user should verify the {string} title is displayed")
	public void userShouldVerifyTheTitleIsDisplayed(String message) {

		conditionAssert(message, title().contains(message));
	}

	@Then("user should click search button after selecting the mandatory details")
	public void userShouldClickSearchButtonAfterSelectingTheMandatoryDetails(
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> list = dataTable.asMaps();
		Map<String, String> map = list.get(0);
		String location = map.get("location");
		String numberOfRooms = map.get("numberOfRooms");
		String checkInDate = map.get("checkInDate");
		String checkOutDate = map.get("checkOutDate");
		String adultsPerRoom = map.get("adultsPerRoom");

		SearchHotelPage sh = new SearchHotelPage();
		sh.searchByMandatory(location, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	@Then("user should verify the {string}, {string} message is displayed")
	public void userShouldVerifyTheMessageIsDisplayed(String checkin, String checkout) {

		SearchHotelPage sh = new SearchHotelPage();
		conditionAssert(checkin, sh.getCheckInDate().getText());
		conditionAssert(checkout, sh.getCheckOutDate().getText());

	}

	@Then("user should click on search button")
	public void userShouldClickOnSearchButton() {

		SearchHotelPage sh = new SearchHotelPage();
		sh.submit();
	}

	@Then("user should verify the {string} error message is displayed")
	public void userShouldVerifyTheErrorMessageIsDisplayed(String message) {

		SearchHotelPage sh = new SearchHotelPage();
		conditionAssert(message, sh.getCheckLocation().getText());
	}

	@Then("user should click on radiobutton and continue button")
	public void userShouldClickOnRadiobuttonAndContinueButton() {

		SelectHotelPage selectpage = new SelectHotelPage();
		selectpage.selectHotel();
	}

	@Then("user should click book button after entering {string},{string},{string} and selecting the following details")
	public void userShouldClickBookButtonAfterEnteringAndSelectingTheFollowingDetails(String firstName, String lastName,
			String billingAddress, io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> list = dataTable.asMaps();
		Map<String, String> map = list.get(0);
		String creditCardNo = map.get("creditCardNo");
		String creditCardType = map.get("creditCardType");
		String expiryMonth = map.get("expiryMonth");
		String expiryYear = map.get("expiryYear");
		String cvv = map.get("cvv");

		BookHotelPage bookpage = new BookHotelPage();
		bookpage.bookHotel(firstName, lastName, billingAddress, creditCardNo, creditCardType, expiryMonth, expiryYear,
				cvv);
	}

	@Then("user should verify the {string} message is displayed")
	public void userShouldVerifyTheMessageIsDisplayed(String message) {

		BookHotelPage bookpage = new BookHotelPage();
		bookpage.verifyBooking(message);

	}

	@Then("user should click on book button")
	public void userShouldClickOnBookButton() {

		BookHotelPage bookpage = new BookHotelPage();
		bookpage.clickBook();
	}

	@Then("user should verify the {string}, {string}, {string}, {string}, {string}, {string}, {string} message is displayed")
	public void userShouldVerifyTheMessageIsDisplayed(String Checkfirstname, String Checklastname, String Checkaddress,
			String Checkcardtype, String Checkcardnumber, String Checkexpirymonth, String Checkcardcvv) {

		BookHotelPage bookpage = new BookHotelPage();
		bookpage.errorMessageVerification(Checkfirstname, Checklastname, Checkaddress, Checkcardtype, Checkcardnumber,
				Checkexpirymonth, Checkcardcvv);

	}

	@Then("user should get orderId and click on My Itinerary")
	public void userShouldGetOrderIdAndClickOnMyItinerary() throws Exception {
		
		CancelBookingpage cb = new CancelBookingpage();
		cb.verifyOrderNumber();
		Thread.sleep(3000);
		cb.clickMyItinerary();
	}

	@Then("user should compare orderId and click on cancel booking")
	public void userShouldCompareOrderIdAndClickOnCancelBooking() {
		
		CancelBookingpage cb = new CancelBookingpage();
		cb.verifyOrderId();
	}

	@Then("user should verify the {string} success message is displayed")
	public void userShouldVerifyTheSuccessMessageIsDisplayed(String message) {

		CancelBookingpage cb = new CancelBookingpage();
		cb.verifyCancelBooking(message);

	}
}
