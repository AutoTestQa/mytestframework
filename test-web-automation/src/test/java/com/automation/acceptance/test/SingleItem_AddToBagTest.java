package com.automation.acceptance.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/SingleItem_Add_to_bag.feature", glue = {
		"com.automaiton.acceptance.steps", "com.automation.base.component" }, format = { "pretty",
				"html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json" }, tags = { "@completed" })
public class SingleItem_AddToBagTest {

}