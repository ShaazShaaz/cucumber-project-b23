package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTableStepDef {
    @Given("I have a {word}")
    public void i_have_a(String animal) {
        System.out.println("Given I have a "+animal);
    }
    @When("I call their names")
    public void i_call_their_names() {
        System.out.println("When I call their names");
    }
    @Then("They come to me.")
    public void they_come_to_me() {
        System.out.println("They come to me.");
    }


    @Given("I have following animals")
    public void i_have_following_animals(List<String> animalList) {

        System.out.println("animalList = " + animalList);
    }

    @When("I call their names with below names")
    public void iCallTheirNamesWithBelowNames(List<String> nameList) {
        System.out.println("names = " + nameList);
    }

    @Then("They come to me with below noise")
    public void they_come_to_me_with_below_noise(Map<String,String> animalNoiseMap) {
        System.out.println("animalNoiseMap = " + animalNoiseMap);
        // this can also be represented with List<List<String>>

    }

    @When("we provide below credentials")
    public void weProvideBelowCredentials(Map<String,String> credentialMap) {
        System.out.println("credentialMap = " + credentialMap);
        String usernameFromTable=credentialMap.get("username");
        String passwordFromTable=credentialMap.get("password");
        WLoginPage loginPage=new WLoginPage();
        loginPage.login(usernameFromTable,passwordFromTable);
    }

    @Given("this is the product reference")
    public void thisIsTheProductReference(List<Map<String,Object>> productMapList) {
        System.out.println("productMapList = " + productMapList);
        for (Map<String,Object> eachRow:productMapList){
            System.out.println("eachRow = " + eachRow);
        }
    }
}

