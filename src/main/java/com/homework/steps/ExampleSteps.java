package com.homework.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.google.inject.Inject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import com.homework.pageobjects.DefinitionPage;
import com.homework.pageobjects.LoginPage;

@ScenarioScoped
public class ExampleSteps {

  @Inject
  private LoginPage loginPage;

  @Inject
  private DefinitionPage definitionPage;

  @Given("^I have opened main page$")
  public void I_have_opened_main_page() {
    loginPage.open();
  }

  @When("^I provide corect user login$")
  public void i_provide_corect_user_login()  {
    loginPage.provideUserName();
    loginPage.clickNext();

  }

  @When("^correct pasword$")
  public void correct_pasword()  {
    // Write code here that turns the phrase above into concrete actions

  }

  @Then("^I am loged in$")
  public void i_am_loged_in()  {
    // Write code here that turns the phrase above into concrete actions

  }

  @When("^I search for \"(.+)\"$")
  public void I_search_for(String query) {
    loginPage.getSearchComponent().searchForQuery(query);
  }

  @Then("^Heading for page will be \"(.+)\"$")
  public void Heading_for_page_will_be(String heading) {
    assertThat(definitionPage.getHeading(), is(heading));
  }

}
