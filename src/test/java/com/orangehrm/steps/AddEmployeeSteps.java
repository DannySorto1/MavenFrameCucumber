package com.orangehrm.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	LoginPage login;
	HomePage home;
	AddEmployeePage emp;

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		login = new LoginPage();
		home = new HomePage();
		emp = new AddEmployeePage();
		login.Login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		click(home.Pim);
	}

	@When("I click on  Add Employee link")
	public void i_click_on_Add_Employee_link() {
		click(home.AddEmp);
	}

	@Given("I give details {string} and {string} and {string} and {string}")
	public void i_give_details_and_and_and_and(String fName, String mName, String lName, String location) {
		emp = new AddEmployeePage();
		sendText(emp.FirstName, fName);
		sendText(emp.MidName, mName);
		sendText(emp.LastName, lName);
		click(emp.location);
		selectList(emp.locationList, location);

	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		click(emp.saveBtn);
	}
	
	@Then("I see the following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
	    
		List<String> labels = addEmpLabels.asList();
		System.out.println("----Printing labels from cucumber dataTable----");
		for (String label: labels) {
			System.out.println(label);
		}
		
		System.out.println("----Printing labels text from the application----");
		List<WebElement> labelList=emp.addEmpLabels;
		for (WebElement label: labelList) {
			String labeltxt=label.getText();
			System.out.println(labeltxt.replace("*", ""));
		}
	}

}
