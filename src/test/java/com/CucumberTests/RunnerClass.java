package com.CucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import jdk.management.resource.internal.ResourceNatives;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/java/com/CucumberTests/SubmitOrder.feature",
        glue = {"stepDefinition"},
        tags = "tag",
        monochrome=true,
        plugin = {"pretty",
               "html:target/report.html"
})
public class RunnerClass extends AbstractTestNGCucumberTests {




}
