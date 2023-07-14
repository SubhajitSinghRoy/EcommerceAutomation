package com.CucumberTests;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/com/CucumberTests/SubmitOrder.feature",
        glue = "com.CucumberTests.stepDefinition",
       
        publish=false,
        monochrome=true,
        plugin = {	"pretty",
        			"html:target/report.html"
                 },
        tags = "@tag" )

public class RunnerClass extends AbstractTestNGCucumberTests {
	

	@Override
	@DataProvider(parallel = true)
public Object[][] scenarios(){
	
	return super.scenarios();
}



}
