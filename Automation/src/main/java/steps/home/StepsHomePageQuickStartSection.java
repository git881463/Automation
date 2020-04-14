package steps.home;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Home Page Quick Start Section.
	 * Look at the feature file for more detail
	 */
	public class StepsHomePageQuickStartSection extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsHomePageQuickStartSection.class);

	    @Then("^verify that on clicking 'Add a New Client' shortcut, admin navigates to 'Add Client' page$")
	    public void add_client_page_is_shown() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getQuickStartSection().getAddNewClientLink()));
	        homePage.getQuickStartSection().getAddNewClientLink().click();
	        myClientsPage.getAddClientPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAddClientPage().getPageTitle()));
	    }

	    @Then("^verify that on clicking 'Select an Existing Client' shortcut, admin navigates to 'Search Client' page$")
	    public void search_client_page_is_shown() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getQuickStartSection().getSelectExistingClientLink()));
	        homePage.getQuickStartSection().getSelectExistingClientLink().click();
	        myClientsPage.getSearchClientPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPageTitle()));
	    }

	    @When("^the admin clicks on 'Run Credit Dispute Wizard'$")
	    public void the_admin_clicks_on_run_credit_dispute_wizard() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getQuickStartSection().getRunCreditDisputeWizardLink()));
	        homePage.getQuickStartSection().getRunCreditDisputeWizardLink().click();
	    }

	    @Then("^'Select a client' widget is shown$")
	    public void select_a_client_widget_shown() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getQuickStartSection().getHomePageQuickStartSectionClientSelectionWidget().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(homePage.getQuickStartSection().getHomePageQuickStartSectionClientSelectionWidget().getClientListTable()));
	        TestAssert.verifyElementVisible(homePage.getQuickStartSection().getHomePageQuickStartSectionClientSelectionWidget().getLinkToFirstClientInList());
	    }

	    @Then("^clicking on a client, I should navigate to dispute wizard$")
	    public void clicking_on_a_clinet_navigates_to_dispute_wizard() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getQuickStartSection().getHomePageQuickStartSectionClientSelectionWidget().getLinkToFirstClientInList()));
	        homePage.getQuickStartSection().getHomePageQuickStartSectionClientSelectionWidget().getLinkToFirstClientInList().click();
	        myClientsPage.getDisputeWizardPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	    }


	}

