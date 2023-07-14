package com.CucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features = "src/test/java/com/CucumberTests/SubmitOrder.feature",
        glue = "com.CucumberTests.stepDefinition",
       
        publish=false,
        monochrome=true,
        plugin = {"pretty",
               "html:target/report.html"
                 },
        tags = "@tag" )

public class RunnerClass extends AbstractTestNGCucumberTests {
	





}
