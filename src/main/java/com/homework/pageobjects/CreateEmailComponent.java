package com.homework.pageobjects;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import jdk.nashorn.internal.objects.annotations.Function;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;
import org.openqa.selenium.support.ui.ExpectedConditions;


@PageObject
public class CreateEmailComponent {

    private static final String RECIPIENT = "mike.tste@gmail.com";

    @Inject
    private WebDriver webDriver;

    @Inject
    private BobcatWait bobcatWait;

    @FindBy(css = "[name='to']")
    private WebElement recipientAddress;

    @FindBy (css = "[name='subjectbox']")
    private WebElement subject;

    @FindBy (xpath = "//div[contains(@aria-label, 'Ctrl-Enter')]")
    private WebElement sendButton;

    public void addRecipient(String adresMailowy){
        bobcatWait.withTimeout(5).until(ExpectedConditions.visibilityOf(recipientAddress));
        recipientAddress.click();
        recipientAddress.sendKeys(adresMailowy);
    }

    public void addSubject(String Subject){
        bobcatWait.withTimeout(5).until(ExpectedConditions.visibilityOf(subject));
        subject.click();
        subject.sendKeys(Subject);
    }

    public void addMessageBody(String Message){
        subject.click();
        subject.sendKeys(Keys.TAB, Message);
    }

    public void sendEmail(){
        bobcatWait.withTimeout(5).until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();

    }




}
