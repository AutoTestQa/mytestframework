package com.acceptance.Test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/SingleItem_Add_to_bag.feature", glue = {"com.aceptance.stepDefs", "com.base.component"},format = {"pretty",
        "html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json"}, tags = {"@completed"})
public class SingleItem_AddToBagTest {

}