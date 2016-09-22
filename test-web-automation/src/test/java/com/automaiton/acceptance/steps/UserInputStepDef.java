package com.automaiton.acceptance.steps;

import org.openqa.selenium.WebElement;

import com.automation.base.component.BaseGeneric;
import com.automation.base.component.LocatorFind;

import cucumber.api.java.en.When;

public class UserInputStepDef extends BaseGeneric {

	private final LocatorFind locatorFind;

	public UserInputStepDef(LocatorFind locatorFind, BaseGeneric baseGeneric) {
		this.locatorFind = locatorFind;
	}

	@When("^I enter (.*) in (.*)$")
	public void I_enter_value_into_element(String value, String element) {
		element = element.replace("\"", "");
		value = value.replace("\"", "");
		try {
			WebElement elementToAction = locatorFind.getWebelement(driver, element);
			elementToAction.click();
			elementToAction.clear();
			elementToAction.sendKeys(value);
		} catch (Exception e) {
			System.out
					.println("Object " + "'" + element + "'" + " not exit/avaialble on application  " + e.getMessage());
			e.printStackTrace();
		}

	}
}
