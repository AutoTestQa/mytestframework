package com.acceptance.Test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/Add_to_bag.feature", glue = {"com.aceptance.stepDefs", "com.base.component"})
public class AddToBagFeaturesTest {

}