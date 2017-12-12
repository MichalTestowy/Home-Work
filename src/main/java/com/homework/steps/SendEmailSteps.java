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

    @Then("^The message is visible in sent folder$")
    public void the_message_is_visible_in_sent_forlder() {
        sentMailPage.openSentMail();
        assertTrue("The mail with timestamp is visible in on the page", sentMailPage.findLastTitle());

    }
}
