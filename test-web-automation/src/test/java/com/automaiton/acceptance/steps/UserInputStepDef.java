package com.automaiton.acceptance.steps;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.component.BaseGeneric;
import com.automation.base.component.LocatorFind;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class UserInputStepDef extends BaseGeneric {

	private final LocatorFind locatorFind;

	public UserInputStepDef(LocatorFind locatorFind, BaseGeneric baseGeneric) {
		this.locatorFind = locatorFind;
	}
	
	   @Rule
	    public ErrorCollector collector= new ErrorCollector();

	@When("^I enter (.*) in (.*)$")
	public void I_enter_value_into_element(String value, String element) {
	    element=formatInput(element);
        value=formatInput(value);
		try {
			WebElement elementToAction = locatorFind.getWebelement(driver, element);
			elementToAction.click();
			elementToAction.clear();
			elementToAction.sendKeys(value);
		} catch (NullPointerException  e) {
			System.out
					.println("Object " + "'" + element + "'" + " not exit/avaialble on application  " + e.getMessage());
			 collector.addError(e);
		}
	}
	
	@Given("^I Choose to select \"([^\"]*)\" CheckBox$")
    public void i_Choose_to_select_CheckBox(String element) throws Throwable {
        element=formatInput(element);
        try {
            locatorFind.getWebelement(driver, element).click();
        } catch (NullPointerException  e) {
            System.out
                    .println("Object " + "'" + element + "'" + " not exit/avaialble on application  ");
            collector.addError(e);
        }
    }

    @Given("^I choose to select \"([^\"]*)\" as a Visible Text from \"([^\"]*)\" dropdown$")
    public void i_choose_to_select_as_a_Visible_Text_from_dropdown(String value, String element) throws Throwable {
        element=formatInput(element);
        value=formatInput(value);
        try{
            Select select = new Select(locatorFind.getWebelement(driver, element));
            select.selectByVisibleText(value);
        }catch (NullPointerException  e){
            collector.addError(e);
        }
    }
}
