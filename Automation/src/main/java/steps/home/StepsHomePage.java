package steps.home;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Home Page.
	 * Look at the feature file for more detail
	 */
	public class StepsHomePage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsHomePage.class);

	    @Given("^Admin is on the home page$")
	    public void adminIsOnTheHomePage() {
	        homePage.load();
	    }

	    @Then("^verify if the admin is able to view the shortcuts to common items$")
	    public void verify_if_the_admin_is_able_to_view_the_shortcuts_to_common_items(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(homePage.getQuickStartSection().getPageTitle());
	        TestAssert.verifyElementVisible(homePage.getHomePageTaskSection().getTodaysTaskContainer());
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getPageTitle());
	        TestAssert.verifyElementVisible(homePage.getHomePageRecentLoginActivitySection().getPageTitle());
	        TestAssert.verifyElementVisible(homePage.getHomePageShortcutsSection().getMyCompanyProfileLink());
	        TestAssert.verifyElementVisible(homePage.getHomePageScheduleSection().getPageTitle());
	    }

	}


