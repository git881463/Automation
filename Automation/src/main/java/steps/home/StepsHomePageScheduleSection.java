package steps.home;

	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Home Page Schedule Section.
	 * Look at the feature file for more detail
	 */
	public class StepsHomePageScheduleSection extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsHomePageScheduleSection.class);

	    @Then("^verify that on clicking 'Manage Schedule' shortcut, admin navigates to 'My Schedule' page$")
	    public void my_schedule_page_is_shown() {
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageScheduleSection().getManageScheduleLink()));
	        homePage.getHomePageScheduleSection().getManageScheduleLink().click();
	        schedulePage.isLoaded();
	    }
	}
