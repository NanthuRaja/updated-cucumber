package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement location;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getRoomnos() {
		return roomnos;
	}

	public WebElement getDatein() {
		return datein;
	}

	public WebElement getDateout() {
		return dateout;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getSubmit() {
		return submit;
	}

	@FindBy(id = "hotels")
	private WebElement hotel;

	@FindBy(id = "room_type")
	private WebElement room;

	@FindBy(id = "room_nos")
	private WebElement roomnos;

	@FindBy(id = "datepick_in")
	private WebElement datein;

	@FindBy(id = "datepick_out")
	private WebElement dateout;

	@FindBy(id = "adult_room")
	private WebElement adult;

	@FindBy(id = "child_room")
	private WebElement child;

	@FindBy(id = "Submit")
	private WebElement submit;

	@FindBy(xpath = "//span[text()='Check-In Date shall be before than Check-Out Date']")
	private WebElement checkInDate;

	@FindBy(xpath = "//span[text()='Check-Out Date shall be after than Check-In Date']")
	private WebElement checkOutDate;

	@FindBy(xpath = "//span[text()='Please Select a Location']")
	private WebElement checkLocation;

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getCheckLocation() {
		return checkLocation;
	}

	public void searchByAll(String location, String hotel, String roomType, String numberOfRooms, String adultsPerRoom,
			String childrenPerRoom, String checkOutDate, String checkInDate) {

		byVisibleText(location, hotel, roomType, numberOfRooms, adultsPerRoom, childrenPerRoom);
		byEnterText(checkInDate, checkOutDate);
		click(getSubmit());
	}

	public void searchByMandatory(String location, String numberOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		byVisibleTextMandatory(location, numberOfRooms, adultsPerRoom);
		byEnterText(checkInDate, checkOutDate);
		click(getSubmit());
	}

	public void byEnterText(String checkInDate, String checkOutDate) {
		enterText(getDatein(), checkInDate);
		enterText(getDateout(), checkOutDate);
	}

	public void byVisibleText(String location, String hotel, String roomType, String numberOfRooms,
			String adultsPerRoom, String childrenPerRoom) {
		selectByVisibleText(getLocation(), location);
		selectByVisibleText(getHotel(), hotel);
		selectByVisibleText(getRoom(), roomType);
		selectByVisibleText(getRoomnos(), numberOfRooms);
		selectByVisibleText(getAdult(), adultsPerRoom);
		selectByVisibleText(getChild(), childrenPerRoom);
	}

	public void byVisibleTextMandatory(String location, String numberOfRooms, String adultsPerRoom) {
		selectByVisibleText(getLocation(), location);
		selectByVisibleText(getRoomnos(), numberOfRooms);
		selectByVisibleText(getAdult(), adultsPerRoom);
	}

	public void submit() {

		click(getSubmit());
	}
}
