package steps.landing;

	import helper.TestAssert;
	import pageobjects.landing.LandingPage;
	import steps.ParentSteps;
    import io.cucumber.java.After;
    import io.cucumber.java.Before;
    import io.cucumber.java.Scenario;
    import io.cucumber.java.en.And;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	import java.io.IOException;

	/**
	 * Steps for Landing Page.
	 * Look at the feature file for more detail
	 */
	public class StepsLandingPage extends ParentSteps {

	    private static final Logger logger = LoggerFactory.getLogger(StepsLandingPage.class);

	    @Autowired
	    private LandingPage landingPage;

	    @Before
	    public void beforeScenario(Scenario scenario) {
	        super.beforeScenario(scenario);
	        logger.debug("This will run before the Scenario. Starting - {}",  scenario.getName());
	    }

	    @After
	    public void afterScenario(Scenario scenario) throws IOException {
	        super.afterScenario(scenario);
	        logger.debug("This will run after the Scenario. Stopping - {}, Status - {}", scenario.getName(), scenario.getStatus());
	    }

	    @Given("^I am on the landing page$")
	    public void i_am_on_the_landing_page() throws Throwable {
	        //webdriver.navigate().refresh();
	        landingPage.get();
	    }

	    @Then("^I should see page container$")
	    public void i_should_see_page_container() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getPageContainer());
	    }

	    @And("^I should see login section$")
	    public void i_should_see_login_section() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginSection());
	    }

	    @And("^I should see advert section$")
	    public void i_should_see_advert_section() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getAdvertSection());
	    }

	}

