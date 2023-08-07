package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features",
        glue = "steps",
       
        publish=false,
        monochrome=true,
        plugin = {	"pretty",
        			"html:target/report.html",
        			"json:target/report.json",
        			"junit:target/report.xml"
                 },
        tags = "@tag" )

public class RunnerClass extends AbstractTestNGCucumberTests {
	
//
//	@Override
//	@DataProvider(parallel = true)
//public Object[][] scenarios(){
//	
//	return super.scenarios();
//}



}
