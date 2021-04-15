package org.page;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingpage extends BaseClass {

	public static String bookingId;

	public CancelBookingpage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "my_itinerary")
	private WebElement itinerary;

	@FindBy(xpath = "//td//strong[text()='Cancel ']//parent::td//parent::tr//following-sibling::tr//child::td[3]//input")
	private List<WebElement> cancel;

	@FindBy(id = "search_result_error")
	private WebElement bookingCancelled;

	@FindBy(id = "order_no")
	private WebElement orderno;

	public WebElement getBookingCancelled() {
		return bookingCancelled;
	}

	public WebElement getItinerary() {
		return itinerary;
	}

	public List<WebElement> getCancel() {
		return cancel;
	}

	public WebElement getOrderno() {
		return orderno;
	}

	public void clickMyItinerary() {

		click(getItinerary());
	}

	public void verifyOrderId() {

		for (WebElement elements : getCancel()) {
			String text = elements.getAttribute("value");
			System.out.println(getCancel().size());
			System.out.println(text);
			System.out.println(bookingId);
			if (bookingId.contains(text)) {
				click(elements);
			}
		}
	}

	public void verifyCancelBooking(String message) {
		System.out.println(getBookingCancelled().getText());
		conditionAssert(message, getBookingCancelled().getText());
	}

	public String verifyOrderNumber() {

		bookingId = getOrderno().getAttribute("value");
		return bookingId;

	}

}
