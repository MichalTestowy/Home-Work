package com.homework.pageobjects;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;


@PageObject
public class CreateEmailComponent {

    private static final String RECIPIENT = "mike.tste@gmail.com";

    private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

    public String getTimeStamp() {
        return timeStamp;
    }

    @Inject
    private WebDriver webDriver;

    @Inject
    private BobcatWait bobcatWait;

    @FindBy(css = "[name='to']")
    private WebElement recipientAddress;

    @FindBy(css = "[name='subjectbox']")
    private WebElement subject;

    @FindBy(xpath = "//div[contains(@aria-label, 'Ctrl-Enter')]")
    private WebElement sendButton;

    @FindBy(xpath = "//span[contains(text(), 'Sending...')]")
    private WebElement sendingPrompt;

    public void addRecipient(String mailAddress) {
        bobcatWait.withTimeout(15).until(ExpectedConditions.visibilityOf(recipientAddress));
        recipientAddress.click();
        recipientAddress.sendKeys(mailAddress);
        recipientAddress.sendKeys(Keys.ENTER);
    }

    public void addSubject(String Subject) {
        bobcatWait.withTimeout(5).until(ExpectedConditions.visibilityOf(subject));
        subject.click();
        subject.sendKeys(Subject + " " + timeStamp);
    }

    public void addMessageBody(String Message) {
        subject.click();
        subject.sendKeys(Keys.TAB, Message);
    }

    public void acceptAlert(){
        bobcatWait.withTimeout(10).until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();
        try{
            bobcatWait.withTimeout(10).until(ExpectedConditions.alertIsPresent());
            if(webDriver.switchTo().alert() != null){
                webDriver.switchTo().alert().accept();
            }
        }catch(Exception e){}
        bobcatWait.withTimeout(10).until(ExpectedConditions.invisibilityOf(sendingPrompt));

    }

    public void sendEmail() {
        bobcatWait.withTimeout(10).until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();
        bobcatWait.withTimeout(10).until(ExpectedConditions.invisibilityOf(sendingPrompt));

    }

}
