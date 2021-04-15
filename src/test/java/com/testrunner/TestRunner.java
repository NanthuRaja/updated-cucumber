package com.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Feature\\CancelBooking.feature",glue= "com.stepdefinition" , dryRun = false , snippets = SnippetType.CAMELCASE,monochrome = true)
public class TestRunner {
	
	

}
