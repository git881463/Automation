package steps.invoices;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Invoices Page.
	 * Look at the feature file for more detail
	 */
	public class StepsInvoicesPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsInvoicesPage.class);

	    @Given("^Admin is on Invoices page$")
	    public void adminIsOnInvoicesPage() {
	        myInvoicesPage.load();
	    }

	    @Then("^verify that admin should be able to filter the invoice and payment by 'Total Outstanding' status$")
	    public void verify_that_admin_should_be_able_to_filter_the_invoice_and_payment_by_total_outstanding_status() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getPageTitle()));
	        TestAssert.verifyElementVisible(myInvoicesPage.getTotalOutstandingLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPastDueLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPaidInLast30Days());
	        myInvoicesPage.getTotalOutstandingLabel().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getSearchResultContainerHeader()));
	    }

	    @Then("^verify that admin should be able to filter the invoice and payment by 'Past due' status$")
	    public void verify_that_admin_should_be_able_to_filter_the_invoice_and_payment_by_past_due_status() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getPageTitle()));
	        TestAssert.verifyElementVisible(myInvoicesPage.getTotalOutstandingLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPastDueLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPaidInLast30Days());
	        myInvoicesPage.getPastDueLabel().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getSearchResultContainerHeader()));
	    }

	    @Then("^verify that admin should be able to filter the invoice and payment by 'Paid in last 30 days' status$")
	    public void verify_that_admin_should_be_able_to_filter_the_invoice_and_payment_by_paid_in_last_30_days_status() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getPageTitle()));
	        TestAssert.verifyElementVisible(myInvoicesPage.getTotalOutstandingLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPastDueLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPaidInLast30Days());
	        myInvoicesPage.getPaidInLast30Days().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getSearchResultContainerHeader()));
	    }

	    @Then("^verify that invoices details are shown on the page$")
	    public void verify_that_invoices_details_are_shown_on_the_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getPageTitle()));
	        TestAssert.verifyElementVisible(myInvoicesPage.getTotalOutstandingLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPastDueLabel());
	        TestAssert.verifyElementVisible(myInvoicesPage.getPaidInLast30Days());
	    }

	    @Then("^verify that admin should be able to watch quick videos on 'How to create invoices'$")
	    public void verify_that_admin_should_be_able_to_watch_quick_videos_on_how_to_create_invoices() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getQuickVideoLink()));
	        myInvoicesPage.getQuickVideoLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getVideoPopupCloseButton()));
	        myInvoicesPage.getVideoPopupCloseButton().click();
	    }
	}

