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
public class InboxPage {

    @Inject
    @Named("inbox.url")
    private String inboxURL;

    @Inject
    private WebDriver webDriver;

    @Inject
    private BobcatWait bobcatWait;

    @FindBy(css = "div[gh='cm']")
    private WebElement composeButton;

    public boolean urlContainsText(String text) {
        return inboxURL.contains(text);
    }

    public InboxPage clickCompose() {
        bobcatWait.withTimeout(5).until(ExpectedConditions.elementToBeClickable(composeButton));
        composeButton.click();
        return this;
    }
}
