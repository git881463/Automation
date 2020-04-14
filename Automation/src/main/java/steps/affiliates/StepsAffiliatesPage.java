package steps.affiliates;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.io.File;

	/**
	 * Steps for Everything Page.
	 * Look at the feature file for more detail
	 */
	public class StepsAffiliatesPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsAffiliatesPage.class);

	    private class DummyAffiliate{

	        private String firstName;
	        private String lastName;
	        private String email;
	        private String status;
	        private String phoneNumber;
	        private String referrer;

	        public String getFirstName() {
	            return firstName;
	        }

	        public void setFirstName(String firstName) {
	            this.firstName = firstName;
	        }

	        public String getLastName() {
	            return lastName;
	        }

	        public void setLastName(String lastName) {
	            this.lastName = lastName;
	        }

	        public String getEmail() {
	            return email;
	        }

	        public void setEmail(String email) {
	            this.email = email;
	        }

	        public String getStatus() {
	            return status;
	        }

	        public void setStatus(String status) {
	            this.status = status;
	        }

	        public String getPhoneNumber() {
	            return phoneNumber;
	        }

	        public void setPhoneNumber(String phoneNumber) {
	            this.phoneNumber = phoneNumber;
	        }

	        public String getReferrer() {
	            return referrer;
	        }

	        public void setReferrer(String referrer) {
	            this.referrer = referrer;
	        }
	    }

	    private DummyAffiliate getDummyAffiliate(String status){
	        DummyAffiliate dummyAffiliate = new DummyAffiliate();
	        long currentTimeInMillis = System.currentTimeMillis();
	        dummyAffiliate.setFirstName("fname"+currentTimeInMillis);
	        dummyAffiliate.setLastName("lname"+currentTimeInMillis);
	        dummyAffiliate.setEmail("fname"+currentTimeInMillis+"@gmail.com");
	        dummyAffiliate.setPhoneNumber("444444444");
	        dummyAffiliate.setStatus(status);
	        return dummyAffiliate;
	    }

	    private void addNewAffiliate(DummyAffiliate dummyAffiliate){
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        affiliatesPage.getAddNewAffiliatesButton().click();
	        affiliatesPage.getAddAffiliatePage().isLoaded();

	        affiliatesPage.getAddAffiliatePage().inputFirstName(dummyAffiliate.getFirstName());
	        affiliatesPage.getAddAffiliatePage().inputLastName(dummyAffiliate.getLastName());
	        affiliatesPage.getAddAffiliatePage().getGender().click();

	        affiliatesPage.getAddAffiliatePage().inputEmail(dummyAffiliate.getEmail());
	        affiliatesPage.getAddAffiliatePage().inputPhone(dummyAffiliate.getPhoneNumber());

	        affiliatesPage.getAddAffiliatePage().selectStatus(dummyAffiliate.getStatus());

	        wait.until(ExpectedConditions.invisibilityOf(creditorsFurnishersPage.getAjaxLoader()));
	        affiliatesPage.scroll("0", "document.body.scrollHeight");

	        if(dummyAffiliate.getStatus().equalsIgnoreCase("Active (recommended)")){
	            ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('username').removeAttribute('readonly',0);");
	            affiliatesPage.getAddAffiliatePage().inputUserName(dummyAffiliate.getEmail());
	        }
	        affiliatesPage.getAddAffiliatePage().getSubmitButton().click();
	        affiliatesPage.isLoaded();
	    }

	    private void filterNewlyAddedAffiliate(DummyAffiliate dummyAffiliate){
	        affiliatesPage.get();
	        affiliatesPage.scroll("0", "0");
	        affiliatesPage.inputEmail(dummyAffiliate.getEmail());
	        affiliatesPage.getSearchButton().click();
	        affiliatesPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPartnersList()));
	        //wait.until(ExpectedConditions.invisibilityOf(affiliatesPage.getAjaxLoader()));
	        verifyPageCount();
	    }

	    private void cleanupAffiliate(DummyAffiliate dummyAffiliate){
	        filterNewlyAddedAffiliate(dummyAffiliate);
	        try{
	            affiliatesPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getFirstAffiliateDeleteLink()));
	            affiliatesPage.getFirstAffiliateDeleteLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            affiliatesPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getFirstAffiliateDeleteLink()));
	            affiliatesPage.getFirstAffiliateDeleteLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getInactivateOrDeleteAffiliatePopup().getPageTitle()));
	        affiliatesPage.getInactivateOrDeleteAffiliatePopup().getDeleteAffiliateButton().click();
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(affiliatesPage.getFlashMessage().getMessage(), "Affiliate partner deleted.");
	        wait.until(ExpectedConditions.invisibilityOf(affiliatesPage.getFlashMessage().getMessage()));
	    }

	    private void verifyPageCount(){
	        try{
	            TestAssert.verifyNotEqual(affiliatesPage.getPageCount().getText(), "0");
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            TestAssert.verifyNotEqual(affiliatesPage.getPageCount().getText(), "0");
	        }
	    }

	    @Given("^Admin is on Affiliates page$")
	    public void adminIsOnAffiliatesPage() {
	        affiliatesPage.load();
	    }

	    @Then("^verify that list of affiliates is shown on the page$")
	    public void verify_that_list_of_affiliates_is_shown_on_the_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPartnersList()));
	    }

	    @Then("^verify that admin should be able to search for an affiliate by 'Affiliate Name'$")
	    public void verify_that_admin_should_be_able_to_search_for_an_affiliate_by_affiliate_name() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getName()));
	        affiliatesPage.inputName("Sample Affiliate");
	        affiliatesPage.getSearchButton().click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getSearchResult()));
	    }

	    @Then("^verify that admin should be able to search for an affiliate by 'Company'$")
	    public void verify_that_admin_should_be_able_to_search_for_an_affiliate_by_company() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getCompany()));
	        affiliatesPage.inputCompany("ABC Mortgage");
	        affiliatesPage.getSearchButton().click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getSearchResult()));
	    }

	    @Then("^verify that admin should be able to search for an affiliate by 'Affiliate Email'$")
	    public void verify_that_admin_should_be_able_to_search_for_an_affiliate_by_affiliate_email() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getEmail()));
	        affiliatesPage.inputEmail("sample@affiliate.com");
	        affiliatesPage.getSearchButton().click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getSearchResult()));
	    }

	    @Then("^verify that admin should be able to search for an affiliate by 'Status'$")
	    public void verify_that_admin_should_be_able_to_search_for_an_affiliate_by_status() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getStatus()));
	        affiliatesPage.selectStatus("Active");
	        affiliatesPage.getSearchButton().click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getSearchResult()));
	    }

	    @Then("^verify that new affiliate can be added without portal access$")
	    public void verify_that_new_affiliate_can_be_added_without_portal_access() throws Exception {
	        DummyAffiliate dummyAffiliate = getDummyAffiliate("Inactive");
	        addNewAffiliate(dummyAffiliate);
	        cleanupAffiliate(dummyAffiliate);
	    }

	    @Then("^verify that new affiliate can be added with portal access$")
	    public void verify_that_new_affiliate_can_be_added_with_portal_access() throws Exception {
	        DummyAffiliate dummyAffiliate = getDummyAffiliate("Active (recommended)");
	        addNewAffiliate(dummyAffiliate);
	        cleanupAffiliate(dummyAffiliate);
	    }

	    @Then("^verify that admin should be able to import affiliate details CSV file$")
	    public void verify_that_admin_should_be_able_to_import_affiliate_details_CSV_file() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getImportCSVlink()));
	        affiliatesPage.getImportCSVlink().click();
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getImportAffiliatesPopup().getPageTitle()));
	        webdriver.switchTo().frame("iframeDialog{rnd}");//switching the frame by ID
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getImportAffiliatesPopup().getImportButton()));
	        String filePath = new File(this.getClass().getResource("/data/sample_affiliates.csv").toURI()).getCanonicalPath();
	        affiliatesPage.getImportAffiliatesPopup().getFilePickerLink().sendKeys(filePath);
	        affiliatesPage.getImportAffiliatesPopup().getImportButton().click();
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getImportAffiliatesPopup().getImportAffiliatesButton()));
	        affiliatesPage.getImportAffiliatesPopup().getImportAsInactive().click();
	        affiliatesPage.getImportAffiliatesPopup().getSelectAllRadio().click();
	        affiliatesPage.getImportAffiliatesPopup().selectFirstName("First Name");
	        affiliatesPage.getImportAffiliatesPopup().selectLastName("Last Name");
	        affiliatesPage.getImportAffiliatesPopup().selectCompany("Company");
	        affiliatesPage.getImportAffiliatesPopup().selectEmail("Email");
	        affiliatesPage.getImportAffiliatesPopup().getImportAffiliatesButton().click();
	        //wait.until(ExpectedConditions.invisibilityOf(affiliatesPage.getAjaxLoader()));
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        affiliatesPage.getImportAffiliatesPopup().getClosePopupLink().click();
	    }

	    @Then("^verify that admin should be able to export affiliate details CSV file$")
	    public void verify_that_admin_should_be_able_to_export_affiliate_details_CSV_file() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getExportCSVlink()));
	        affiliatesPage.getExportCSVlink().click();
	        affiliatesPage.isLoaded();
	    }

	    @Then("^verify that admin should be able to print affiliate list$")
	    public void verify_that_admin_should_be_able_to_print_affiliate_list() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPrintLink()));
	        affiliatesPage.getPrintLink().click();
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPrintAffiliatesPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPrintAffiliatesPopup().getOkButton()));
	        affiliatesPage.getPrintAffiliatesPopup().getOkButton().click();
	        affiliatesPage.isLoaded();
	    }

	    @Then("^verify that admin should be able to navigate to 'Edit Affiliate Profile' page upon clicking 'Affiliate name'$")
	    public void verify_that_admin_should_be_able_to_navigate_to_edit_affiliate_profile_page_upon_clicking_affiliate_name() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getFirstAffiliateName()));
	        affiliatesPage.getFirstAffiliateName().click();
	        affiliatesPage.getEditAffiliatePage().isLoaded();
	    }

	    @Then("^verify that admin should be able to edit affiliate profile$")
	    public void verify_that_admin_should_be_able_to_edit_affiliate_profile() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getFirstAffiliateName()));
	        affiliatesPage.getFirstAffiliateName().click();
	        affiliatesPage.getEditAffiliatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getEditAffiliatePage().getGender()));
	        affiliatesPage.getEditAffiliatePage().getGender().click();
	        affiliatesPage.getEditAffiliatePage().inputPhone("444444444");
	        affiliatesPage.scroll("0", "document.body.scrollHeight");
	        affiliatesPage.getEditAffiliatePage().getSubmitButton().click();
//	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(affiliatesPage.getFlashMessage().getMessage(), "Affiliate Partner Updates Successfully");
//	        wait.until(ExpectedConditions.invisibilityOf(affiliatesPage.getFlashMessage().getMessage()));
	        affiliatesPage.getEditAffiliatePage().isLoaded();
	   }

	    @Then("^verify that admin should be able to view affiliates client referral stats$")
	    public void verify_that_admin_should_be_view_affiliates_client_referral_stats() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(affiliatesPage.getAffiliateStatusDashboard()));
	        affiliatesPage.getAffiliateStatusDashboard().click();
	        affiliatesPage.getAffiliatesDashboardPage().isLoaded();
	    }
	}
