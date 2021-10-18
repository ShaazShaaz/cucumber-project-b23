package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebOrderPage {
    @FindBy(xpath = "//h2[normalize-space(.)= 'List of All Orders']")
    public WebElement header;

    @FindBy(id="ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id="ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[1]/th")
    public List<WebElement> headerCells;

    public WebOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // HW: create a method to loop through all header cells and return true if the header are as below:
    // Name # Date Street City State Zip Card CardNumber Exp



}
