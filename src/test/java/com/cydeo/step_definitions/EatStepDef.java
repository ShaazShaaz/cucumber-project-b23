package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EatStepDef {
    @Given("John is hungry")
    public void john_is_hungry() {
        System.out.println("this is @Given code: John is hungry");


    }
    @When("He eats {int} cucumbers")
    public void he_eats_cucumbers(Integer quantity) {
        System.out.println("this is @When code: He eats cucumber "+ quantity);

    }
    @Then("He will be full")
    public void he_will_be_full() {
        System.out.println("this is @Then code: He will be full");

    }

    @Given("Ivan is hungry")
    public void ivan_is_hungry() {
        System.out.println("@Given Ivan is hungry code");

    }
    @Then("he faints")
    public void he_faints() {
        System.out.println("@Then he faints code");
    }

    // eating_cucumber.feature
    @Given("there are {int} cucumbers")
    public void there_are_cucumbers(Integer startingCount) {
        System.out.println("startingCount = " + startingCount);
    }
    @When("I eat {int} cucumbers")
    public void i_eat_cucumbers(Integer ateCount) {
        System.out.println("ateCount = " + ateCount);
    }
    @Then("I should have {int} cucumbers")
    public void i_should_have_cucumbers(Integer leftCount) {
        System.out.println("leftCount = " + leftCount);
    }

}
