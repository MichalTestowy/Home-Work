package com.homework;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/features/example", format = {"pretty",
    "html:target/cucumber-gmail-html-report", "json:target/cucumber-gmail-report.json"})
public class RunGmailTest {
  // empty
}
