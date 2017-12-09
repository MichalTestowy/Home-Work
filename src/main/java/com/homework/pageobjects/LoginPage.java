package com.homework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class LoginPage {

  private static final String URL =  "https://mail.google.com/mail/?pc=topnav-about-en#inbox";

  @Inject
  private WebDriver webDriver;

  @FindBy(id = "p-search")
  private SearchComponent searchComponent;

  @FindBy(id ="identifierId")
  private WebElement userNameField;

  @FindBy(id = "identifierNext")
  private WebElement identifierNext;

  @FindBy(css = "type[password]")
  private WebElement passwordField;

  @FindBy(id="passwordNext")
  private WebElement passwordNext;

  public SearchComponent getSearchComponent() {
    return searchComponent;
  }

  public LoginPage open() {
    webDriver.get(URL);
    return this;
  }

  public void provideUserName(){
    userNameField.sendKeys("mike.tste@gmail.com");
    identifierNext.click();
  }

  public void providePassword(){
    passwordField.sendKeys("JoeCocker5");
    passwordNext.click();;
  }

}
