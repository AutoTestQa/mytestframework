package com.aceptance.stepDefs;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.support.ui.Select;

import com.base.component.BaseGeneric;
import com.base.component.LocatorFind;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class NavigationStepDef extends BaseGeneric {

    private final LocatorFind locatorFind;

    public NavigationStepDef(LocatorFind locatorFind) {
        this.locatorFind = locatorFind;

    }

    /**
     * Navigate application URL on selected browser/Device Application URL and Browser
     */

    @Given("^I Navigate to customer application$")
    public void i_Navigate_to_customer_application() throws InterruptedException, IOException {
        driver.get(CONFIG.getProperty("appURL"));
        driver.manage().deleteAllCookies();
    }

    @Given("^I wait for (.*) seconds$")
    public void i_wait_for_seconds(String waitSeconds) throws InterruptedException, IOException {
        String waitTime = waitSeconds + "000";
        Thread.sleep(Long.valueOf(waitTime));
    }

    @When("^I choose to click on (.*)$")
    public void I_click_on_choosedElement(String element) {
        element = element.replace("\"", "");
        try {
            locatorFind.getWebelement(driver, element).click();
        } catch (Exception e) {
            System.out.println("Object " + "'" + element + "'" + " not exit/avaialble on application  " + e.getMessage());
            Assert.assertFalse(true);
        }
    }

    @Given("^I Choose to select \"([^\"]*)\" CheckBox$")
    public void i_Choose_to_select_CheckBox(String element) throws Throwable {
        element = element.replace("\"", "");
        try {
            locatorFind.getWebelement(driver, element).click();
        } catch (Exception e) {
            System.out.println("Object " + "'" + element + "'" + " not exit/avaialble on application  " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Given("^I choose to select \"([^\"]*)\" as a Visible Text from \"([^\"]*)\" dropdown$")
    public void i_choose_to_select_as_a_Visible_Text_from_dropdown(String value, String element) throws Throwable {
        element = element.replace("\"", "");
        value = value.replace("\"", "");

        Select select = new Select(locatorFind.getWebelement(driver, element));
        select.selectByVisibleText(value);

    }

}
