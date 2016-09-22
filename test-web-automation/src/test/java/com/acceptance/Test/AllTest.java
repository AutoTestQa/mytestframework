package com.acceptance.Test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/", glue = {"com.aceptance.stepDefs", "com.base.component"},format = {"pretty",
        "html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json"}, tags = {"@complete"})
public class AllTest {

}