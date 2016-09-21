package com.aceptance.stepDefs;

import junit.framework.Assert;

import com.base.component.BaseGeneric;
import com.base.component.LocatorFind;

import cucumber.api.java.en.Then;

public class VerifyStepDef extends BaseGeneric {

    private final LocatorFind locatorFind;

    public VerifyStepDef(LocatorFind locatorFind) {
        this.locatorFind = locatorFind;
    }

    @Then("^I should see the text of (.*) as (.*)$")
    public void I_should_see_the_text_of_element_as_giventext(String element, String value) {
        element = element.replace("\"", "");
        value = value.replace("\"", "");
        String textOutput = locatorFind.getWebelement(driver, element).getText();
        Assert.assertTrue("Expected string =" + value + "and Actual string =" + textOutput + " are not equal", textOutput.contains(value));
    }

    @Then("^I should see the (.*) is Exit$")
    public void I_should_see_the_object_is_Exit(String element) {
        element = element.replace("\"", "");
        //locatorFind.getWebelement(driver, element).isDisplayed();
        Assert.assertTrue("Object " + element + " is not exist", locatorFind.getWebelement(driver, element).isDisplayed());
    }

}
