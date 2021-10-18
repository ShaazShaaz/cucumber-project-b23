package com.cydeo.pages;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage {
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameField;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordField;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Invalid Login or Password.']")
    public WebElement errorMsg;

    // now instruct the selenium to start looking for element
    // when this constructor is called
    public WLoginPage(){
        // Page factory is a selenium class that supports Page Object Model
        // it has method called initElements
        // once its called it will locate all the element
        // using the @FindBy annotation with locator
        // initElements accepts 2 arguments
        //WebDriver instance and page class instance(this) means current instance of this class
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // create a method to goTo
    // accept no param just navigate to login page
    // use config.properties for url

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("webOrder_url"));

    }

    public void login(String username, String password){
       this.usernameField.sendKeys(username);
       this.passwordField.sendKeys(password);
       this.loginButton.click();
    }

    // check error msg is displayed if wrong credentials provided
    // loginErrorMsgDisplayed
    public boolean loginErrorMsgPresent(){
       return this.errorMsg.isDisplayed();

    }


}
