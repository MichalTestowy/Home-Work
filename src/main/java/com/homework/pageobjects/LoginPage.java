package com.homework.pageobjects;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@PageObject
public class LoginPage {

    @Inject
    @Named("inbox.url")
    private String inboxURL;

    @Inject
    private WebDriver webDriver;

    @Inject
    private BobcatWait bobcatWait;

    @FindBy(id = "identifierId")
    private WebElement userNameField;

    @FindBy(id = "identifierNext")
    private WebElement identifierNext;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement passwordNext;

    @FindBy(css = "div[aria-live='assertive']")
    private WebElement inncorrectLoginMessage;

    public LoginPage open() {
        webDriver.get(inboxURL);
        return this;
    }

    public void provideUserName(String userName) {
        userNameField.sendKeys(userName);
        identifierNext.click();
    }

    public void providePassword() {
        passwordField.sendKeys("JoeCocker5");
        bobcatWait.withTimeout(5).until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordNext.click();
    }

    public boolean checkErrorMessage() {
        bobcatWait.withTimeout(5).until(ExpectedConditions.visibilityOf(inncorrectLoginMessage));
        return inncorrectLoginMessage.isDisplayed();
    }

}
