package steps.home;

	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Home Page Recent Login Activity Section.
	 * Look at the feature file for more detail
	 */
	public class StepsHomePageRecentLoginActivitySection extends StepsNavigationHelper {
		private static final Logger logger = LoggerFactory.getLogger(StepsHomePageRecentLoginActivitySection.class);

		@Then("^verify that on clicking 'Full History' link, admin is able to view the complete history$")
		public void verify_if_the_admin_is_able_to_view_the_complete_history(){
			homePage.scroll("0", "document.body.scrollHeight");
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageRecentLoginActivitySection().getFullHistoryLink()));
			homePage.getHomePageRecentLoginActivitySection().getFullHistoryLink().click();
			historyPage.isLoaded();
		}

	}
