package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;
import com.orangehrm.utils.CommonMethods;

public class LoginPage extends BaseClass {
	@FindBy(id = "txtUsername")
	public WebElement userName;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(css = "img[src*='logo.png']")
	public WebElement logo;

	@FindBy(css = "div.dashboardCard-title-for-card")
	public WebElement retrylog;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	public WebElement errorMessage;

	public void Login(String uname, String pwd) {
		CommonMethods.sendText(userName, uname);
		CommonMethods.sendText(password, pwd);
		CommonMethods.click(loginBtn);

	}
}
