package com.automaiton.acceptance.steps;

import java.io.IOException;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.component.BaseGeneric;
import com.automation.base.component.LocatorFind;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class NavigationStepDef extends BaseGeneric {

	private final LocatorFind locatorFind;

	public NavigationStepDef(LocatorFind locatorFind) {
		this.locatorFind = locatorFind;
	}
	
	@Rule
    public ErrorCollector collector= new ErrorCollector();
	
	Actions action = new Actions(driver);
	

	/**
	 * Navigate application URL on selected browser/Device Application URL and
	 * Browser
	 */
	@Given("^I Navigate to customer application$")
	public void i_Navigate_to_customer_application() throws InterruptedException, IOException {
	    try{
	        driver.get(CONFIG.getProperty("appURL"));
	        driver.manage().deleteAllCookies();
	    }catch (NullPointerException  e){
	        collector.addError(e);
	    }
	}

	@Given("^I wait for (.*) seconds$")
	public void i_wait_for_seconds(String waitSeconds) throws InterruptedException, IOException {
		String waitTime = waitSeconds + "000";
		Thread.sleep(Long.valueOf(waitTime));
	}

	@When("^I choose to click on (.*)$")
	public void I_click_on_choosedElement(String element) {
	    element=formatInput(element);  
		try {
		    locatorFind.getWebelement(driver, element).click();
		} catch (NullPointerException  e) {
			System.out
					.println("Object " + "'" + element + "'" + " not exit/avaialble on application  ");
			collector.addError(e);
		}
		
	}
	
	
	@When("^I choose to Doubleclick on (.*)$")
    public void I_Doubleclick_on_choosedElement(String element) {
	    element=formatInput(element);
        try {
            action.doubleClick(locatorFind.getWebelement(driver, element)).perform();
        } catch (NullPointerException  e) {
            System.out
                    .println("Object " + "'" + element + "'" + " not exit/avaialble on application  ");
            collector.addError(e);
        }
    }
}
