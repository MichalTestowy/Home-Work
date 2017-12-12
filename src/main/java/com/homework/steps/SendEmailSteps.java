package com.homework.steps;

import com.homework.pageobjects.CreateEmailComponent;
import com.homework.pageobjects.SentMailPage;
import cucumber.runtime.java.guice.ScenarioScoped;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.google.inject.Inject;

import com.homework.pageobjects.InboxPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ScenarioScoped
public class SendEmailSteps {

    @Inject
    private InboxPage inboxPage;

    @Inject
    private CreateEmailComponent createEmailComponent;

    @Inject
    private SentMailPage sentMailPage;

    @Given("^I create a new e-mail message$")
    public void i_create_a_new_e_mail_message() {
        inboxPage.clickCompose();
        createEmailComponent.addRecipient("mike.tste@gmail.com");
        createEmailComponent.addSubject("Test Message");
        createEmailComponent.addMessageBody("Hello world");
    }

    @When("^I click send$")
    public void i_cleck_send() {
        createEmailComponent.sendEmail();

    }

    @When("^I accept the alert$")
    public void I_accept_the_alert() {
        createEmailComponent.acceptAlert();

    }

    @Then("^The message is visible in sent folder$")
    public void the_message_is_visible_in_sent_forlder() {
        sentMailPage.openSentMail();
        assertTrue("The mail with timestamp is visible in on the page", sentMailPage.findLastTitle());
    }

    @When("^I choose a file to be attached$")
    public void i_choose_a_file_to_be_attached() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^The File attached is visible in message$")
    public void the_File_attached_is_visible_in_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I create a new e-mail message without any text$")
    public void i_create_a_new_e_mail_message_without_any_text() {
        inboxPage.clickCompose();
        createEmailComponent.addRecipient("mike.tste@gmail.com");
        createEmailComponent.addSubject("Test Message");
    }

    @Given("^I have an unread message in the inbox$")
    public void i_have_an_unread_message_in_the_inbox() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I open the message$")
    public void i_open_the_message() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I open the inbox again$")
    public void i_open_the_inbox_again() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the message is marked as read$")
    public void the_message_is_marked_as_read() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I create new mesage$")
    public void i_create_new_mesage() {
        // Write code here that turns the phrase above into concrete actions
    }
}
