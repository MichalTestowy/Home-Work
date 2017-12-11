package com.homework.pageobjects;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;

@PageObject
public class InboxPage {
    private static final String URL =  "https://mail.google.com/mail/?pc=topnav-about-en#inbox";

    @Inject
    private WebDriver webDriver;

    public boolean urlContainsText(String text){
        if (URL.contains(text)){
            return true;
        }else{
            return false;
        }
    }
}
