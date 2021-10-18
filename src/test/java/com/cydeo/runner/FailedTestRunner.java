package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// this test runner has only one purpose.
// to run failed scenario that is stored inside rerun.txt
@RunWith(Cucumber.class)
@CucumberOptions(
                 glue = "com/cydeo/step_definitions",
                 features = "@target/rerun.txt",
                 tags = "@ui")
public class FailedTestRunner {
}
