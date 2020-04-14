package helper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

/**
 * Runner class, providing configurable hooks for all the aspects.
 * If you prefer parallel execution, then comment this runner and uncomment the plugin cucumber-jvm-parallel-plugin in pom.xml
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
//		glue = {steps,homePage},
//		tags = {"@Smoke", "@Regression},  //Not required, can be provided at command-line instead
		plugin = {
				"pretty:target/cucumber-pretty.txt",
				"html:target/test-output-html",
				"json:target/json_output/cucumber.json",
				"junit:target/junit_xml/cucumber.xml",
				"rerun:target/cucumber-reports/re-run.txt",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/report.html"
		})
public class CucumberRunnerTest {

}
