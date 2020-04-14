package steps.landing;

	import helper.TestAssert;
	import pageobjects.header.CommonHeaderSection;
	import pageobjects.home.HomePage;
	import pageobjects.landing.LandingPage;
	import steps.ParentSteps;
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	import java.io.IOException;

	/**
	 * Steps for Landing Page Login Section.
	 * Look at the feature file for more detail
	 */
	public class StepsLandingPageLoginSection extends ParentSteps {

	    private static final Logger logger = LoggerFactory.getLogger(StepsLandingPageLoginSection.class);

	    @Autowired
	    private CommonHeaderSection commonHeaderSection;

	    @Autowired
	    private LandingPage landingPage;

	    @Autowired
	    private HomePage homePage;

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

	    @Then("^I should see login section title$")
	    public void i_should_see_login_section_title() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginHeaderTitle());
	    }

	    @And("^I should see login form$")
	    public void i_should_see_login_form() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginPanelSection().getLoginForm());
	    }

	    @And("^I should see login form title$")
	    public void i_should_see_login_form_title() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginPanelSection().getLoginFormTitle());
	    }

	    @And("^I should see login form username input$")
	    public void i_should_see_login_form_username_input() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginPanelSection().getUsername());
	    }

	    @And("^I should see login form password input$")
	    public void i_should_see_login_form_password_input() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginPanelSection().getPassword());
	    }

	    @Then("^I should see login form signin button$")
	    public void i_should_see_login_signin_button() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginPanelSection().getLoginButton());
	    }

	    @Then("^I should see login form forgot password link$")
	    public void i_should_see_login_form_forgot_password_link() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        TestAssert.verifyElementVisible(landingPage.getLoginPanelSection().getForgotpassword());
	    }

	    @When("^I enter username$")
	    public void i_enter_username() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        landingPage.getLoginPanelSection().inputUsername(username);
	    }

	    @And("^I enter password$")
	    public void i_enter_password() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        landingPage.getLoginPanelSection().inputPassword(password);
	    }

	    @And("^I press the login button$")
	    public void i_press_the_login_button() throws Throwable {
	        landingPage.getLoginPanelSection().clickOnSigninButton();
	    }

	    @Then("^I should be logged in$")
	    public void i_should_be_logged_in() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementContent(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton(), loggedinUser);
	    }

	    @And("^I enter incorrect password$")
	    public void i_enter_incorrect_password() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getPageContainer()));
	        landingPage.getLoginPanelSection().inputPassword("1234");
	    }

	    @Then("^I should not be logged in and should see error message instead$")
	    public void i_should_not_be_logged_in() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(landingPage.getLoginPanelSection().getErrorMessageContainer()));
	        TestAssert.verifyElementContent(landingPage.getLoginPanelSection().getErrorMessageContainer(), "Sorry wrong Email/User ID or Password try again");
	    }
	}

