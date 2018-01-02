package com.homework.pageobjects;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.utils.WebElementUtils;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@PageObject
public class SentMailPage {

    private static final String subjectXPath = "//span//b[contains(text(), '%s')]";

    @Inject
    @Named("sent.url")
    private String sentURL;

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

    public SentMailPage openSentMail() {
        webDriver.get(sentURL);
        return this;
    }

    public boolean findLastTitle() {
        WebElement titleElement = driver.findElement(By.xpath(String.format(subjectXPath, createEmailComponent.getTimeStamp())));
        return  webElementUtils.isDisplayed(titleElement);
        }
    }
