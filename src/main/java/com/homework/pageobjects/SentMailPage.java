package com.homework.pageobjects;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.utils.WebElementUtils;
import com.google.inject.Inject;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@PageObject
public class SentMailPage {

    private static final String sentURL= "https://mail.google.com/mail/u/1/#sent";

    private static final String titeleXPath ="//span//b[contains(text(), '%s')]";

    @Inject
    private WebDriver webDriver;

    @Inject
    private BobcatWait bobcatWait;

    @Inject
    private WebElementUtils webElementUtils;

    @Inject
    private CreateEmailComponent createEmailComponent;

    @Inject
    private WebDriver driver;

    public SentMailPage openSentMail(){
        webDriver.get(sentURL);
        return this;
    }

    public boolean findLastTitle(){
        WebElement titleElement = driver.findElement(By.xpath(String.format(titeleXPath,createEmailComponent.getTimeStamp())));
        if(webElementUtils.isDisplayed(titleElement)){
            return true;
        }else{
            return false;
        }

    }


}
