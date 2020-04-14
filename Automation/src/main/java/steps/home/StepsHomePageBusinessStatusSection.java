package steps.home;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Home Page Business Status Section.
	 * Look at the feature file for more detail
	 */
	public class StepsHomePageBusinessStatusSection extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsHomePageBusinessStatusSection.class);

	    @Then("^verify if the admin is able to view the contents of Business Status Section$")
	    public void verify_if_the_admin_is_able_to_view_the_contents_of_business_status_section(){
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getPageTitle());
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getActiveClientsLink());
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getAffiliatesLink());
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getLeadsLink());
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getClientSuccessLink());
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getChartTitle());
	        TestAssert.verifyElementVisible(homePage.getHomePageBusinessStatusSection().getLineChart());
	        homePage.getHomePageBusinessStatusSection().getActiveClientsLink().click();
	        try{
	            wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageBusinessStatusSection().getActiveClientsChart()));
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageBusinessStatusSection().getActiveClientsChart()));
	        }
	        TestAssert.verifyElementContent(homePage.getHomePageBusinessStatusSection().getChartTitle(),"Active Clients");
	        homePage.getHomePageBusinessStatusSection().getAffiliatesLink().click();
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageBusinessStatusSection().getAffiliatesChart()));
	        TestAssert.verifyElementContent(homePage.getHomePageBusinessStatusSection().getChartTitle(),"Affiliates");
	        homePage.getHomePageBusinessStatusSection().getLeadsLink().click();
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageBusinessStatusSection().getLeadsChart()));
	        TestAssert.verifyElementContent(homePage.getHomePageBusinessStatusSection().getChartTitle(),"Leads");
	        homePage.getHomePageBusinessStatusSection().getClientSuccessLink().click();
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageBusinessStatusSection().getClientSuccessChart()));
	        TestAssert.verifyElementContent(homePage.getHomePageBusinessStatusSection().getChartTitle(),"Client Success");
	    }

	    @Then("^verify that on clicking 'View Dashboard' shortcut, admin navigates to 'Dashboard' page$")
	    public void adminShouldBeNavigatedToDashboard() {
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageBusinessStatusSection().getViewDashboardLink()));
	        homePage.getHomePageBusinessStatusSection().getViewDashboardLink().click();
	        dashboardPage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	    }
	}

