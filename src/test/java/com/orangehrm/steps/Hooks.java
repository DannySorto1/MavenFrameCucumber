package com.orangehrm.steps;

import com.orangehrm.utils.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting test: " + scenario.getName());
		BaseClass.setUpDriver();
	}

	@After
	public void end(Scenario scenario) {
		System.out.println("Ending test: " + scenario.getName());
		BaseClass.tearDown();
	}

}
