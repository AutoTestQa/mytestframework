package com.automaiton.acceptance.steps;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import com.automation.base.component.BaseGeneric;
import com.automation.base.component.LocatorFind;

import cucumber.api.java.en.Then;

public class VerifyStepDef extends BaseGeneric {

    private final LocatorFind locatorFind;

    public VerifyStepDef(LocatorFind locatorFind) {
        this.locatorFind = locatorFind;
    }

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @SuppressWarnings("deprecation")
    @Then("^I should see the text of (.*) as (.*)$")
    public void I_should_see_the_text_of_element_as_giventext(
            String element, String value) {
        element = formatInput(element);
        value = formatInput(value);
        try {
            String textOutput = locatorFind.getWebelement(driver, element).getText();
            Assert.assertTrue("Expected string =" + value + "and Actual string =" + textOutput + " are not equal",
                    textOutput.contains(value));
        } catch (NullPointerException e) {
            collector.addError(e);
        }
    }

    @SuppressWarnings({"deprecation"})
    @Then("^I should see the (.*) is Exit$")
    public void I_should_see_the_object_is_Exit(
            String element) {
        element = formatInput(element);
        try {
            Assert.assertTrue("Object " + element + " is not exist", locatorFind.getWebelement(driver, element)
                    .isDisplayed());
        } catch (NullPointerException e) {
            collector.addError(e);
        }
    }

}
