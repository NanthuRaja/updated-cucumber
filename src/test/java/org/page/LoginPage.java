package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private WebElement txtuser;

	@FindBy(id = "password")
	private WebElement txtpass;

	@FindBy(id = "login")
	private WebElement btnlogin;

	public WebElement getTxtuser() {
		return txtuser;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public void login(String user, String pass) {
		enterText(getTxtuser(), user);
		enterText(getTxtpass(), pass);
		click(getBtnlogin());
	}

}
