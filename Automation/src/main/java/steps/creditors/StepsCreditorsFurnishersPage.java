package steps.creditors;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.io.File;

	/**
	 * Steps for Creditors Furnishers Page.
	 * Look at the feature file for more detail
	 */
	public class StepsCreditorsFurnishersPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsCreditorsFurnishersPage.class);

	    @Given("^Admin is on Creditors/Furnishers page$")
	    public void adminIsOnTheCreditorsPage() {
	        creditorsFurnishersPage.load();
	    }

	    @Then("^verify that list of Creditors/Furnishers is shown on the page$")
	    public void verify_that_list_of_creditors_furnishers_is_shown_on_the_page() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getCreditorsList()));
	    }

	    @Then("^verify that admin should be able to search Creditors/Furnishers by their name$")
	    public void verify_that_admin_should_be_able_to_asearch_creditors_furnishers_by_their_name() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getQuickSearchInput()));
	        creditorsFurnishersPage.inputQuickSerarch("American Express");
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        TestAssert.verifyElementContent(creditorsFurnishersPage.getSearchResult(), "American Express");
	    }


	    @Then("^verify that admin is able to add new Creditors/Furnishers$")
	    public void verify_that_admin_is_able_to_add_new_creditors_furnishers() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        long currentTimeInMillis = System.currentTimeMillis();
	        String companyName = "companyname"+currentTimeInMillis;
	        creditorsFurnishersPage.inputCompanyName(companyName);
	        creditorsFurnishersPage.inputAddress("6700 South Main Street");
	        creditorsFurnishersPage.inputCity("Houston");
	        creditorsFurnishersPage.inputState("Texas");
	        creditorsFurnishersPage.inputZip("77025");


	        creditorsFurnishersPage.getSubmitButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(creditorsFurnishersPage.getFlashMessage().getMessage(), "Creditors/Furnishers inserted successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Now cleanup the newly added creditor/furnisher
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getQuickSearchInput()));
	        creditorsFurnishersPage.inputQuickSerarch(companyName);
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        //Delete behaviour seems to have ajax related bug in the application itself. Issue with Delete
//	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getSearchResultDeleteLink()));
	//
//	        creditorsFurnishersPage.getSearchResultDeleteLink().click();
	//
//	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getWarningPopup().getWarningMessageContainer()));
//	        creditorsFurnishersPage.getWarningPopup().getOkButton().click();
	//
//	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(creditorsFurnishersPage.getFlashMessage().getMessage(), "Creditor/furnisher deleted successfully");
//	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	    }

	    @Then("^verify that admin should be able to view Creditor/Furnisher detail by clicking on the name$")
	    public void verify_that_admin_should_be_bale_to_view_creditor_furnisher_detail_by_clicking_on_the_name() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getCreditorsList()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getFirstCredFurnLink()));
	        String name = creditorsFurnishersPage.getFirstCredFurnLink().getText();
	        creditorsFurnishersPage.getFirstCredFurnLink().click();
	        Thread.sleep(2000);
	        String newValue = creditorsFurnishersPage.getCompanyNameInput().getAttribute("value");
	        TestAssert.verifyEqual(name, newValue);
	    }

	    @Then("^verify that admin should be able to filter the Creditor/Furnisher list by clicking on the alphabet$")
	    public void verify_that_admin_should_be_bale_to_filter_the_creditor_furnisher_list_by_clicking_on_the_alphabet() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getCreditorsList()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getAlphabetFilter()));
	        creditorsFurnishersPage.getAlphabetFilter().click();
	        wait.until(ExpectedConditions.invisibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getFilteredResult()));
	        creditorsFurnishersPage.isLoaded();
	    }

	    @Then("^verify that admin should be able to import Creditor/Furnisher details CSV file$")
	    public void verify_that_admin_should_be_bale_to_import_creditor_furnishers_details_csv_file() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getCreditorsList()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getImportLink()));
	        creditorsFurnishersPage.getImportLink().click();

	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getPageTitle()));
	        webdriver.switchTo().frame("iframeDialog{rnd}");//switching the frame by ID
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getImportButton()));
	        String filePath = new File(this.getClass().getResource("/data/sample_furnishers.csv").toURI()).getCanonicalPath();
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getFilePickerLink().sendKeys(filePath);
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getImportButton().click();

	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getSelectAllRadio()));
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getSelectAllRadio().click();
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().selectCompanyName("Company Name");
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().selectAddress("Address");
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getImportFurnishersButton()));
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getImportFurnishersButton().click();
	        //wait.until(ExpectedConditions.invisibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        creditorsFurnishersPage.getImportCreditorsFurnishersPopup().getClosePopupLink().click();
	        creditorsFurnishersPage.isLoaded();
	    }

	    @Then("^verify that admin should be able to export Creditor/Furnisher details CSV file$")
	    public void verify_that_admin_should_be_bale_to_export_creditor_furnishers_details_csv_file() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getCreditorsList()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getExportLink()));
	        creditorsFurnishersPage.getExportLink().click();
	        creditorsFurnishersPage.isLoaded();
	    }

	    @Then("^verify that admin should be able to print Creditor/Furnisher list$")
	    public void verify_that_admin_should_be_bale_to_print_creditor_furnishers_lists() throws Exception {
	        TestAssert.verifyElementVisible(creditorsFurnishersPage.getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getCreditorsList()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getPrintLink()));
	        creditorsFurnishersPage.getPrintLink().click();
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getPrintCreditorsFurnishersPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(creditorsFurnishersPage.getPrintCreditorsFurnishersPopup().getOkButton()));
	        creditorsFurnishersPage.getPrintCreditorsFurnishersPopup().getOkButton().click();
	        creditorsFurnishersPage.isLoaded();
	    }
	}

