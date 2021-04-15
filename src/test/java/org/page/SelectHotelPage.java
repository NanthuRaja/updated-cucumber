package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getNextpage() {
		return nextpage;
	}

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement radio;

	@FindBy(id = "continue")
	private WebElement nextpage;

	public void selectHotel() {
		click(getRadio());
		click(getNextpage());
	}

}
