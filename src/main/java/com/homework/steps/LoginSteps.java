package com.homework.steps;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.google.inject.Inject;

import com.homework.pageobjects.InboxPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import com.homework.pageobjects.LoginPage;
import org.junit.Assert;


@ScenarioScoped
public class LoginSteps {

    @Inject
    private LoginPage loginPage;

    @Inject
    private InboxPage inboxPage;

    @Given("^Im loggded in$")
    public void im_logded_in() {
        loginPage.openInboxURL();
        loginPage.provideUserName("mike.tste@gmail.com");
        loginPage.providePassword();

    }

    @Given("^I have opened main page$")
    public void I_have_opened_main_page() {
        loginPage.openInboxURL();
    }

    @When("^I provide correct user login$")
    public void i_provide_corect_user_login() {
        loginPage.provideUserName("mike.tste@gmail.com");
    }

    @When("^correct password$")
    public void correct_pasword() {
        loginPage.providePassword();
    }

    @Then("^I am logged in$")
    public void i_am_loged_in() {
        assertThat("URL contains inbox", inboxPage.urlContainsText("inbox"), is(Boolean.TRUE));

    }

    @When("^I provide incorrect login$")
    public void i_provide_incorretc_password() {
        loginPage.provideUserName("dkflksdjflksdajfqwe");

    }

    @Then("^I can see error message$")
    public void i_can_see_error_message() {
        Assert.assertTrue("The error message is should be visible", loginPage.checkErrorMessage());
    }
}
