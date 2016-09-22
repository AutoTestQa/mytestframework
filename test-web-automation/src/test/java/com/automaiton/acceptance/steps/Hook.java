package com.automaiton.acceptance.steps;

import java.io.IOException;

import com.automation.base.component.BaseGeneric;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseGeneric {

	@Before
	public void invokeApplication() throws InterruptedException, IOException {

		initializeTestBaseSetup();
	}

	@After
	public void closeApplication() throws InterruptedException, IOException {

		driver.quit();
	}

}
