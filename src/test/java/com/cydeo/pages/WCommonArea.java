package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WCommonArea {

    @FindBy(id="ctl00_logout")
    public WebElement logoutLink;

    @FindBy(linkText="View all orders")
    public WebElement viewAllOrdersTab;

    @FindBy(linkText="View all products")
    public WebElement viewAllProductsTab;

    @FindBy(linkText="Order")
    public WebElement orderTab;


    public WCommonArea() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public List<String> allTabs(){
        List<String> actualResult=new ArrayList<>();
        List<WebElement> allTabs=new ArrayList<>();

        allTabs.add(viewAllOrdersTab);
        allTabs.add(viewAllProductsTab);
        allTabs.add(orderTab);

        for (WebElement each:allTabs){
            actualResult.add(each.getText());
        }

        return actualResult;
    }
}
