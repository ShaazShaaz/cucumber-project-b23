package com.cydeo.step_definitions;

import com.cydeo.pages.LibLoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LibraryLoginStepDef {
    LibLoginPage loginPage=new LibLoginPage();
    @Given("user is at library login page")
    public void user_is_at_library_login_page() {
        loginPage.goTo();
    }
    @When("user use username {string} and passcode {string}")
    public void user_use_username_student42_library_and_passcode_sdet2022(String email,String password) {
        loginPage.login(email, password);
    }
    @Then("user should be dashboard page")
    public void user_should_be_dashboard_page() {
        // verify if user is now on dashboard page
        BrowserUtil.waitFor(2);
        Assert.assertEquals("Library", Driver.getDriver().getTitle());
    }

}
