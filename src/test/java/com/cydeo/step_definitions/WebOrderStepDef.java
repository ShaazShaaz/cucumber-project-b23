package com.cydeo.step_definitions;

import com.cydeo.pages.WAllProductPage;
import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WebOrderStepDef {
    WCommonArea commonArea=new WCommonArea();
    WOrderPage orderPage=new WOrderPage();



    @When("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {
        System.out.println("tabName = " + tabName);
        WCommonArea commonArea=new WCommonArea();
        switch (tabName){
            case "View all products":
                commonArea.viewAllProductsTab.click();
                break;
            case "View all orders":
                commonArea.viewAllOrdersTab.click();
                break;
            case "Order":
                commonArea.orderTab.click();
                break;
            default:
                System.out.println("error");
        }

    }

    @Then("we should see below options in Product dropdown list")
    public void weShouldSeeBelowOptionsInProductDropdownList(List<String> expectedOptions) {
        System.out.println("Expected options = " + expectedOptions);
        WOrderPage orderPage=new WOrderPage();

        List<String> actualOptions = orderPage.getAllProductOptionFromList();
        // assert if 2 lists are equal
        Assert.assertEquals(expectedOptions, actualOptions);
    }



    @Then("side bar tabs should be as below")
    public void sideBarTabsShouldBeAsBelow(List<String> expectedTabs) {

        Assert.assertEquals(expectedTabs, commonArea.allTabs());

    }

    @Then("we should see table with below content")
    public void weShouldSeeTableWithBelowContent(List<Map<String,String>> productList) {
        WAllProductPage allProductPage=new WAllProductPage();

        System.out.println("allProductPage.getRowMapFromWebTable() = " + allProductPage.getRowMapFromWebTable());

        Map<String,String> expectFirstRow=productList.get(0);

        // assert if 2 maps are equal
        Assert.assertEquals(expectFirstRow,allProductPage.getRowMapFromWebTable());

//       // System.out.println("productList = " + productList);
//        WAllProductPage allProductPage=new WAllProductPage();
//       // allProductPage.getAllHeaderText();
//        Set<String> headerSet=productList.get(0).keySet();
//       // System.out.println("headerSet = " + headerSet);
//
//        // get actual header
//        List<String> actualHeaders=allProductPage.getAllHeaderText();
//        System.out.println("actualHeaders = " + actualHeaders);
//
//        List<String> expectedHeaders=new ArrayList<>(headerSet);
//        Assert.assertEquals(expectedHeaders, actualHeaders);




    }

//    @Then("{string} should be as below")
//    public void sideBarTabsShouldBeAsBelow(List<String> expectedTabs) {
//
//    }
}
