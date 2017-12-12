package com.homework.pageobjects;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@PageObject
public class InboxPage {
    private static final String URL =  "https://mail.google.com/mail/#inbox";

    @Inject
    private WebDriver webDriver;

    @Inject
    private BobcatWait bobcatWait;

    @FindBy(css = "div[gh='cm']")
    private WebElement composeButton;

    public boolean urlContainsText(String text){
        if (URL.contains(text)){
            return true;
        }else{
            return false;
        }
    }

    public InboxPage clickCompose(){
        bobcatWait.withTimeout(5).until(ExpectedConditions.elementToBeClickable(composeButton));
        composeButton.click();
        return this;
    }
}
