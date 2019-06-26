package com.orangehrm.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.rules.ExpectedException;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {

	LoginPage login;

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
		login = new LoginPage();
		boolean isDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid usernameand password")
	public void i_enter_valid_usernameand_password() {
		sendText(login.userName, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I clicked Login button")
	public void i_clicked_Login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.dashboard.isDisplayed());
	}

	@Then("I close the browser")
	public void i_close_the_browser() {
		driver.close();
	}

	@When("I enter Invalid usernameand password")
	public void i_enter_Invalid_usernameand_password() {
		sendText(login.userName, "teste");
		sendText(login.password, "12903ndf");
	}

	@Then("I see error messagen is displayed")
	public void i_see_error_messagen_is_displayed() {
		Assert.assertTrue(login.errorMessage.isDisplayed());
		String error = login.errorMessage.getText();
		System.out.println(error);
		Assert.assertEquals("Invalid Credentials", error.trim());

	}

	@When("I enter invalid username and password I see errorMessage")
	public void i_enter_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
		List<Map<String, String>> maps = wrongCredentials.asMaps();

		for (Map<String, String> map : maps) {
			// printing values of the keys
			System.out.println(map.get("Username"));
			System.out.println(map.get("Password"));
			System.out.println("ErrorMessage");
			System.out.println("-----------------------");
            //passing username and password values from datatable/map
			sendText(login.userName, map.get("Username"));
			sendText(login.password, map.get("Password"));
			click(login.loginBtn);
            // verifying text of error message 
			String actualError = login.errorMessage.getText().trim();
			String expectedError = map.get("ErrorMessage");
			Assert.assertEquals(expectedError, actualError);

		}

	}
}
