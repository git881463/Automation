package steps.client;

	import helper.TestAssert;
	import pageobjects.messages.EditQuickNotePage;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.codehaus.plexus.util.StringUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.io.File;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

	/**
	 * Steps for My Clients Page.
	 * Look at the feature file for more detail
	 */
	public class StepsClientPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsClientPage.class);

	    private class DummyClient{

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

	    private DummyClient getDummyClient(String status){
	        DummyClient dummyClient = new DummyClient();
	        long currentTimeInMillis = System.currentTimeMillis();
	        dummyClient.setFirstName("fname"+currentTimeInMillis);
	        dummyClient.setLastName("lname"+currentTimeInMillis);
	        dummyClient.setEmail("fname"+currentTimeInMillis+"@gmail.com");
	        dummyClient.setStatus(status);
	        return dummyClient;
	    }

	    private DummyClient getDummyClient(String status, String phoneNumber){
	        DummyClient dummyClient = getDummyClient(status);
	        dummyClient.setPhoneNumber(phoneNumber);
	        return dummyClient;
	    }

	    private DummyClient getDummyClient(String status, String phoneNumber, String referrer){
	        DummyClient dummyClient = getDummyClient(status, phoneNumber);
	        dummyClient.setReferrer(referrer);
	        return dummyClient;
	    }

	    private void addNewClient(DummyClient dummyClient, boolean portalAccess){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getAddNewClientLink());
	        myClientsPage.getSearchClientPage().getAddNewClientLink().click();
	        myClientsPage.getAddClientPage().isLoaded();
	        myClientsPage.getAddClientPage().inputFirstName(dummyClient.getFirstName());
	        myClientsPage.getAddClientPage().inputLastName(dummyClient.getLastName());
	        myClientsPage.getAddClientPage().inputEmail(dummyClient.getEmail());
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getAddClientPage().selectStatus(dummyClient.getStatus());
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        if(StringUtils.isNotBlank(dummyClient.getPhoneNumber())){
	            myClientsPage.getAddClientPage().inputPhoneHome(dummyClient.getPhoneNumber());
	        }
	        if(StringUtils.isNotBlank(dummyClient.getReferrer())){
	            myClientsPage.getAddClientPage().selectReferrer(dummyClient.getReferrer());
	        }
	        if(portalAccess){
	            myClientsPage.scroll("0", "document.body.scrollHeight");
	            myClientsPage.getAddClientPage().getPortalAccessOnRadio().click();
	            myClientsPage.getAddClientPage().selectNoAgreement();
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getAddClientPage().getSubmitButton().click();
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAddClientPage().getWarningPopup().getWarningMessage()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));

	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client profile added successfully");
	    }

	    private void filterNewlyAddedClient(DummyClient dummyClient){
	        myClientsPage.getSearchClientPage().get();
	        myClientsPage.scroll("0", "0");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getClientNameInput()));
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().inputClientName(dummyClient.getFirstName());
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getSearchLink().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        verifyPageCount();
	    }

	    private void loadClientDashboardForNewlyAddedClient(DummyClient dummyClient){
	        filterNewlyAddedClient(dummyClient);
	        try{
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientName().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientName().click();
	        }
	        myClientsPage.getClientDashboardPage().isLoaded();
	    }

	    private void verifyPageCount(){
	        try{
	            TestAssert.verifyNotEqual(myClientsPage.getSearchClientPage().getPageCount().getText(), "0");
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            TestAssert.verifyNotEqual(myClientsPage.getSearchClientPage().getPageCount().getText(), "0");
	        }
	    }

	    private void cleanupClient(String firstName){
	        myClientsPage.getSearchClientPage().get();
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().inputClientName(firstName);
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getSearchLink().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPageCount()));
	            verifyPageCount();
	            myClientsPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteClientLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteClientLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPageCount()));
	            verifyPageCount();
	            myClientsPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteClientLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteClientLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getInactivateOrDeleteClientPopup().getPageTitle()));
	        myClientsPage.getSearchClientPage().getInactivateOrDeleteClientPopup().getDeleteClientButton().click();
	        //In headless mode, sometimes the tests are failing at below line for the flash message visibility.
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client Deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	    }

	    private void cleanupLead(String firstName){
	        myClientsPage.getSearchClientPage().get();
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().inputClientName(firstName);
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getSearchLink().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPageCount()));
	            verifyPageCount();
	            myClientsPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteLeadLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteLeadLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPageCount()));
	            verifyPageCount();
	            myClientsPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteLeadLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteLeadLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Lead has been deleted.");
	    }

	    private void cleanupSuspended(String firstName){
	        myClientsPage.getSearchClientPage().get();
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().inputClientName(firstName);
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getSearchLink().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPageCount()));
	            verifyPageCount();
	            myClientsPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteSuspendedLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteSuspendedLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPageCount()));
	            verifyPageCount();
	            myClientsPage.scroll("2000", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteSuspendedLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteSuspendedLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getInactivateOrDeleteClientPopup().getPageTitle()));
	        myClientsPage.getSearchClientPage().getInactivateOrDeleteClientPopup().getDeleteClientButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client Deleted successfully");
	    }

	    @Given("^Admin is on my clients search page$")
	    public void adminIsOnTheClientPage() {
	        myClientsPage.getSearchClientPage().load();
	    }

	    @Then("^verify if the admin is able to view the clients list$")
	    public void verify_if_the_admin_is_able_to_view_the_clients_list(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	    }

	    @Then("^verify if the admin is able to add a new client without portal access$")
	    public void verify_if_the_admin_is_able_to_add_a_new_client_without_portal_access(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to add a new client with portal access$")
	    public void verify_if_the_admin_is_able_to_add_a_new_client_with_portal_access(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, true);
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to watch the video about adding a new client$")
	    public void verify_if_the_admin_is_able_to_watch_the_video_about_adding_a_new_client(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getWatchQuickVideoLink());
	        myClientsPage.getSearchClientPage().getWatchQuickVideoLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getVideoPopupCloseButton()));
	        myClientsPage.getSearchClientPage().getVideoPopupCloseButton().click();
	        myClientsPage.getSearchClientPage().load();
	    }

	    @Then("^verify if the admin is able to search the client by name$")
	    public void verify_if_the_admin_is_able_to_search_the_client_by_name(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, true);
	        filterNewlyAddedClient(dummyClient);
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to search the client by email$")
	    public void verify_if_the_admin_is_able_to_search_the_client_by_email(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientName().click();
	            myClientsPage.getClientDashboardPage().isLoaded();
	            String email = myClientsPage.getClientDashboardPage().getClientEmail().getText();
	            myClientsPage.getSearchClientPage().get();
	            logger.debug("first client email: {}", email);
	            myClientsPage.scroll("0", "0");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getClientNameInput()));
	            myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().inputClientName(email);
	            myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getSearchLink().click();
	            myClientsPage.scroll("0", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            verifyPageCount();
	           // TestAssert.verifyNotEqual(myClientsPage.getSearchClientPage().getPageCount().getText(), "0");
	        }
	    }

	    @Then("^verify if the admin is able to search by client start date$")
	    public void verify_if_the_admin_is_able_to_search_by_client_start_date(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            String firstClientStartDate = myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientStartDate().getText().trim();
	            myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink().click();
	            //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            myClientsPage.scroll("0", "0");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getStartDateInput()));
	            ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('sdate').removeAttribute('readonly',0);"); // Enables the date box
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getStartDateInput().clear();
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().inputStartDate(firstClientStartDate);
	            myClientsPage.scroll("0", "document.body.scrollHeight");
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getSubmitButton().click();
	            //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            verifyPageCount();
	            //TestAssert.verifyNotEqual(myClientsPage.getSearchClientPage().getPageCount().getText(), "0");
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getBasicSearchButton().click();
	        }
	    }

	    @Then("^verify if the admin is able to search by client added date$")
	    public void verify_if_the_admin_is_able_to_search_by_cliient_added_date(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            String firstClientAddedDate = myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientAddedDate().getText().trim();
	            myClientsPage.scroll("0", "0");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink().click();
	            //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getAddedFromDateInput()));
	            ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('addedfrom').removeAttribute('readonly',0);"); // Enables the date box
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getAddedFromDateInput().clear();
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().inputAddedFromDate(firstClientAddedDate);
	            myClientsPage.scroll("0", "document.body.scrollHeight");
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getSubmitButton().click();
	            //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            verifyPageCount();
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getBasicSearchButton().click();
	        }
	    }

	    @Then("^verify if the admin is able to search by client status$")
	    public void verify_if_the_admin_is_able_to_search_by_client_status(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            String firstClientStatus = myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientStatus().getText().trim();
	            myClientsPage.scroll("0", "0");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink()));
	            myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink().click();
	            //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getStatusFilter()));
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().selectStatus(firstClientStatus);
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getSubmitButton().click();
	            myClientsPage.scroll("0", "document.body.scrollHeight");
	            //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            verifyPageCount();
	            myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getBasicSearchButton().click();
	        }
	    }

	    @Then("^verify if the admin is able to search by client phone number$")
	    public void verify_if_the_admin_is_able_to_search_by_client_phone_number(){

	        DummyClient dummyClient = getDummyClient("Client", "(310) 111-2229");
	        addNewClient(dummyClient, false);

	        myClientsPage.getSearchClientPage().get();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink()));
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink().click();
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getPhoneNumberInput()));

	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getPhoneNumberInput().clear();
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().inputPhoneNumber(dummyClient.getPhoneNumber());
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getSubmitButton().click();
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        verifyPageCount();
	        myClientsPage.scroll("0", "0");
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getBasicSearchButton().click();
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to search by client referrer$")
	    public void verify_if_the_admin_is_able_to_search_by_client_referrer(){
	        DummyClient dummyClient = getDummyClient("Client", "(310) 111-2230", "Sample Affiliate");
	        addNewClient(dummyClient,false);

	        myClientsPage.getSearchClientPage().get();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink()));
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink().click();
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getReferrer()));
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().selectReferrer(dummyClient.getReferrer());
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getSubmitButton().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        verifyPageCount();
	        myClientsPage.scroll("0", "0");
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getBasicSearchButton().click();
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to search by assigned team member$")
	    public void verify_if_the_admin_is_able_to_search_by_assigned_team_member(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);

	        //By default, a team member gets assigned anyway.
	        myClientsPage.getSearchClientPage().get();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink()));
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getAdvancedSearchLink().click();
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getReferrer()));
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().selectAssignedTeamMemberByIndex(1);
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getSubmitButton().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        verifyPageCount();
	        myClientsPage.scroll("0", "0");
	        myClientsPage.getSearchClientPage().getSearchClientPageAdvancedSearchSection().getBasicSearchButton().click();
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to access Sample Client$")
	    public void verify_if_the_admin_is_able_to_access_sample_client(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            String clientName = "Sample Client";
	            myClientsPage.scroll("0", "0");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getClientNameInput()));
	            myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().inputClientName(clientName);
	            myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getSearchLink().click();
	            myClientsPage.scroll("0", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            verifyPageCount();
	        }
	    }

	    @Then("^verify if the admin is able to apply quick filter on status$")
	    public void verify_if_the_admin_is_able_to_apply_quick_filter_on_status(){
	        DummyClient dummyClient = getDummyClient("Lead");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        String quickFilter = "Lead";
	        myClientsPage.scroll("0", "0");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getQuickFilterDropdown()));
	        myClientsPage.getSearchClientPage().selectQuickFilter(quickFilter);
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getSearchClientPage().getFilterLoader()));
	        verifyPageCount();
	        cleanupLead(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to watch quick video about searching and filtering the clients faster$")
	    public void verify_if_the_admin_is_able_to_watch_quick_video_on_filtering_and_searching_clients_faster(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getWatchQuickVideoLink());
	        myClientsPage.getSearchClientPage().getFindClientFasterVideoLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getVideoPopupCloseButton()));
	        myClientsPage.getSearchClientPage().getVideoPopupCloseButton().click();
	        myClientsPage.getSearchClientPage().load();
	    }

	    @Then("^verify if the admin is able to import CSV file to add new clients$")
	    public void verify_if_the_admin_is_able_to_import_csv_file_to_add_new_clients() throws Exception{
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getImportCSVLink());
	        myClientsPage.getSearchClientPage().getImportCSVLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getImportCSVPopup().getPageTitle()));

	        webdriver.switchTo().frame("iframeDialog{rnd}");//switching the frame by ID
	        String filePath = new File(this.getClass().getResource("/data/new_clients.csv").toURI()).getCanonicalPath();
	        myClientsPage.getSearchClientPage().getImportCSVPopup().getFilePickerLink().sendKeys(filePath);
	        myClientsPage.getSearchClientPage().getImportCSVPopup().getImportButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getImportCSVPopup().getNewClientCheckBox()));
	        myClientsPage.getSearchClientPage().getImportCSVPopup().selectFirstName();
	        myClientsPage.getSearchClientPage().getImportCSVPopup().selectLastName();;
	        myClientsPage.getSearchClientPage().getImportCSVPopup().selectEmail();
	        myClientsPage.getSearchClientPage().getImportCSVPopup().getNewClientCheckBox().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getImportCSVPopup().getImportClientsButton()));
	        myClientsPage.getSearchClientPage().getImportCSVPopup().getImportClientsButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getImportCSVPopup().getImportSuccessMsg()));
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.getSearchClientPage().getImportCSVPopup().getClosePopupButton().click();
	        //Import is successful.
	    }

	    @Then("^remove the newly imported client so that next time import does not fail$")
	    public void remove_the_newly_imported_client_so_that_next_time_import_does_not_fail(){
	        //Now delete this user, or else next time test will fail due to a duplicate user.
	        myClientsPage.getSearchClientPage().get();
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().inputClientName("Cody");//It must match with csv client
	        myClientsPage.getSearchClientPage().getSearchClientPageBasicSearchSection().getSearchLink().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        verifyPageCount();
	        //TestAssert.verifyNotEqual(myClientsPage.getSearchClientPage().getPageCount().getText(), "0");
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientDeleteLeadLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Lead has been deleted.");
	    }

	    @Then("^verify if the admin is able to export CSV file$")
	    public void verify_if_the_admin_is_able_to_export_csv_file(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        myClientsPage.scroll("2000", "0");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getExportCSVLink());
	        myClientsPage.getSearchClientPage().getExportCSVLink().click();
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	    }

	    @Then("^verify if the admin is able to print client list$")
	    public void verify_if_the_admin_is_able_to_print_client_list(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        myClientsPage.scroll("2000", "0");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPrintClientListLink());
	        myClientsPage.getSearchClientPage().getPrintClientListLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getPrintClientListPopup().getPageContainer()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //myClientsPage.getSearchClientPage().getPrintClientListPopup().getOkButton().click();
	        myClientsPage.getSearchClientPage().getPrintClientListPopup().getCloseButton().click();
	    }

	    @Then("^verify if the admin is able to add notes to client$")
	    public void verify_if_the_admin_is_able_to_add_notes_to_client(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, true);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientInternalNotesLink().click();
	        myClientsPage.getInternalNotesPage().getInternalNotePage().isLoaded();
	        webdriver.switchTo().frame("note_area_ifr");//switching the frame by ID
	        myClientsPage.getInternalNotesPage().getInternalNotePage().inputNotes("Sample Note");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getInternalNotesPage().getInternalNotePage().getSaveNoteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Note added successfully");
	        //wait.until(ExpectedConditions.urlContains("/notes/index/"));
	        myClientsPage.getInternalNotesPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to edit client$")
	    public void verify_if_the_admin_is_able_to_edit_client(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "-2000");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientEditClientLink().click();
	        wait.until(ExpectedConditions.urlContains("/userdesk/profile"));
	        myClientsPage.getEditClientPage().isLoaded();
	        myClientsPage.getEditClientPage().inputMiddleName("MiddleName");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getEditClientPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        myClientsPage.getEditClientPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());

	    }

	    @Then("^verify if the admin is able to delete a client$")
	    public void verify_if_the_admin_is_able_to_delete_a_client(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify if the admin is able to sort client names alphabetically$")
	    public void verify_if_the_admin_is_able_sort_client_names_alphabetically(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getNameHeader().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        }
	    }

	    @Then("^verify if the admin is able to sort by referred by name$")
	    public void verify_if_the_admin_is_able_sort_by_referred_by_name(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            myClientsPage.scroll("0", "0");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getReferredByHeader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getReferredByHeader().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        }
	    }

	    @Then("^verify if the admin is able to sort by added date$")
	    public void verify_if_the_admin_is_able_sort_by_added_date(){
	        myClientsPage.getSearchClientPage().load();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            myClientsPage.scroll("0", "0");
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getAddedDateHeader().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        }
	    }

	    @Then("^verify if the admin is able to sort by start date$")
	    public void verify_if_the_admin_is_able_sort_by_start_date(){
	        myClientsPage.getSearchClientPage().load();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            myClientsPage.scroll("0", "0");
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getStartDateHeader().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        }
	    }

	    @Then("^verify if the admin is able to sort by status$")
	    public void verify_if_the_admin_is_able_to_sort_by_status(){
	        myClientsPage.getSearchClientPage().load();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getClientTable()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myClientsPage.getSearchClientPage().getPageCount());
	        if(!myClientsPage.getSearchClientPage().getPageCount().getText().equals("0")){
	            myClientsPage.scroll("0", "0");
	            myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getStatusHeader().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        }
	    }

	    @Then("^verify that newly added client with status 'Lead' is shown with green background in the list$")
	    public void admin_adds_the_new_lead_without_portal_access(){
	        DummyClient dummyClient = getDummyClient("Lead");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        try{
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientLeadStyle()));
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientLeadStyle()));
	        }
	        cleanupLead(dummyClient.getFirstName());
	    }

	    @Then("^verify that newly added client with status 'Suspended' is shown with pink background in the list$")
	    public void admin_adds_the_new_client_with_suspended_status_without_portal_access(){
	        DummyClient dummyClient = getDummyClient("Suspended");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientSuspendedStyle()));

	        cleanupSuspended(dummyClient.getFirstName());
	    }

	    @Then("^verify that newly added client with status 'Prospect' is shown with blue background in the list$")
	    public void admin_adds_the_new_client_with_prospect_status_without_portal_access(){
	        DummyClient dummyClient = getDummyClient("Prospect");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientProspectStyle()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on clicking clients name in list, dashboard is shown$")
	    public void verify_that_on_clicking_clients_name_in_list_dashboard_is_shown(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on clicking 'edit client' link, profile page is shown$")
	    public void verify_that_on_clicking_edit_client_link_profile_page_is_shown(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientEditClientLink().click();
	        myClientsPage.getEditClientPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on edit profile page, a team member can be unassigned and assigned$")
	    public void verify_that_on_edit_profile_page_a_team_member_can_be_unassigned_and_assigned(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientEditClientLink().click();
	        myClientsPage.getEditClientPage().isLoaded();
	        //Open AssignTeamMember Popup
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEditClientPage().getAssignTeamMemberLink()));
	        myClientsPage.getEditClientPage().getAssignTeamMemberLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getPageTitle()));

	        if(myClientsPage.getEditClientPage().getAssignTeamMemberPopup().isNoTeamMemberAssigned()) {//They might or might not be assigned
	            if(myClientsPage.getEditClientPage().getAssignTeamMemberPopup().isMemberAvailableToBeAssigned()){//If no one is available, stop
	                myClientsPage.getEditClientPage().getAssignTeamMemberPopup().selectAssignableTeamMemberByIndex(1);
	                wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getAssignButton()));
	                myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getAssignButton().click();
	                wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	                TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Team member assigned");
	                wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	                myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getClosePopupLink().click();
	            }
	        }else{
	            //Firstly remove the team member
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getRemoveAssignedTeamMemberLink()));
	            myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getRemoveAssignedTeamMemberLink().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	            myClientsPage.getWarningPopup().getOkButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	            TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Team member deleted successfully.");
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	            TestAssert.verifyEqual(myClientsPage.getEditClientPage().getAssignTeamMemberPopup().isMemberAvailableToBeAssigned(), true);

	            //Now assign a team member
	            myClientsPage.getEditClientPage().getAssignTeamMemberPopup().selectAssignableTeamMemberByIndex(1);
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getAssignButton()));
	            myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getAssignButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	            TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Team member assigned");
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	            myClientsPage.getEditClientPage().getAssignTeamMemberPopup().getClosePopupLink().click();
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on edit profile page, portal access can be given$")
	    public void verify_that_on_edit_profile_page_portal_access_can_be_given(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientEditClientLink().click();
	        myClientsPage.getEditClientPage().isLoaded();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getEditClientPage().getPortalAccessOnRadio().click();
	        //myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getEditClientPage().selectNoAgreement();
	        myClientsPage.getEditClientPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        myClientsPage.getEditClientPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on edit profile page, portal access can be revoked$")
	    public void verify_that_on_edit_profile_page_portal_access_can_be_revoked(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, true);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientEditClientLink().click();
	        myClientsPage.getEditClientPage().isLoaded();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getEditClientPage().getPortalAccessOffRadio().click();
	        //myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getEditClientPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        myClientsPage.getEditClientPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on edit profile page, login details can be resend$")
	    public void verify_that_on_edit_profile_page_portal_login_details_can_be_resend(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, true);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientEditClientLink().click();
	        myClientsPage.getEditClientPage().isLoaded();
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEditClientPage().getResentLoginDetailsLink()));
	        myClientsPage.getEditClientPage().getResentLoginDetailsLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Login Details sent to "+dummyClient.getFirstName());
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on edit profile page, status of selected 'Lead' can be changed$")
	    public void verify_that_on_edit_profile_page_status_of_selected_Lead_can_be_changed(){
	        DummyClient dummyClient = getDummyClient("Lead");
	        addNewClient(dummyClient, false);
	        filterNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getSearchClientPage().getSearchClientPageResultSection().getFirstClientEditLeadLink().click();
	        myClientsPage.getEditLeadPage().isLoaded();
	        myClientsPage.getEditLeadPage().selectStatus("Client");
	        //wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        myClientsPage.getEditLeadPage().isLoaded();

	        cleanupLead(dummyClient.getFirstName());
	    }

	    @Then("^verify that on clicking client name, dashboard page is shown$")
	    public void verify_that_on_clicking_client_name_dashboard_page_is_shown(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that client document can be uploaded from client dashboard$")
	    public void verify_that_client_document_can_be_uploaded_from_client_dashboard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getClientAgreementCheckBox()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getClientAgreementCheckBox().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Document status changed to received.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        String filePath = new File(this.getClass().getResource("/data/sample_agreement.docx").toURI()).getCanonicalPath();
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getClientAgreementUploadLink().sendKeys(filePath);
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Document uploaded successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that document list can be customized on client dashboard$")
	    public void verify_that_document_list_can_be_customized_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeListLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeListLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeDocumentListPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeDocumentListPopup().getAddButton()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeDocumentListPopup().inputDocumentName("SampleDoc");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeDocumentListPopup().getAddButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Document type added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeDocumentListPopup().getNewlyAddedDoc()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeDocumentListPopup().getRemoveNewlyAddedDocLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Document type deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDocumentSection().getCustomizeDocumentListPopup().getClosePopupLink().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that pending team tasks are visible on client dashboard")
	    public void verify_that_pending_team_tasks_are_visible_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection().getTeamTasksContainer());

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that pending client tasks are visible on client dashboard")
	    public void verify_that_pending_client_tasks_are_visible_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionClientTaskSubSection().getClientTasksContainer());

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that completed team tasks can be viewed on client dashboard")
	    public void verify_that_completed_team_tasks_are_viewed_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection().getTeamTasksContainer());
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getViewCompletedTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection()
	                .getViewCompletedTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompletedTeamTaskPopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompletedTeamTaskPopup().getClosePopupLink().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that completed client tasks can be viewed on client dashboard")
	    public void verify_that_completed_client_tasks_are_viewed_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionClientTaskSubSection().getClientTasksContainer());
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getViewCompletedClientTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionClientTaskSubSection()
	                .getViewCompletedClientTaskLink().click();
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getCompletedClientTaskPopup().getPageTitle()));

	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getCompletedClientTaskPopup().getClosePopupLink().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that new team task can be added and then removed on client dashboard")
	    public void verify_that_new_team_task_can_be_added_and_then_removed_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection().getTeamTasksContainer());
	        //Add the task
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection()
	                .getAddTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTeamTaskPopup().getPageTitle()));

	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTeamTaskPopup().inputSubject("Team task 1");

	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTeamTaskPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Task added successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        //Verify the task
	        TestAssert.verifyElementContent(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                        .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddedTask(),
	                "Team task 1");
	        //Now remove the task
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getDeleteNewlyAddedTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getDeleteNewlyAddedTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Task has been deleted.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that new client task can be added and then removed on client dashboard")
	    public void verify_that_new_client_task_can_be_added_and_then_removed_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getClientTasksContainer());
	        //Add the task
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionClientTaskSubSection()
	                .getAddClientTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskPopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskPopup().selectTaskType("Welcome Step");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskPopup().getAssignTaskToClientButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Portal task assigned successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Verify the task
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab().click();
	        TestAssert.verifyElementContent(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                        .getClientDashboardPageTaskSectionClientTaskSubSection().getAddedTask(),
	                "Welcome Step");
	        //Now remove the task
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().selectAction("Delete");
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessageContainer()));
	        TestAssert.verifyElementContent(myClientsPage.getWarningPopup().getWarningMessageContainer(), "Warning!");
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Portal task deleted successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that new team task can be marked as complete on client dashboard$")
	    public void verify_that_new_team_task_can_be_marked_as_complete_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getTeamTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection().getTeamTasksContainer());
	        //Add the task
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection()
	                .getAddTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTeamTaskPopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTeamTaskPopup().inputSubject("Team task 1");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddTeamTaskPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Task added successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        //Verify the task
	        TestAssert.verifyElementContent(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                        .getClientDashboardPageTaskSectionTeamTaskSubSection().getAddedTask(),
	                "Team task 1");
	        //Now complete the task
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompleteNewlyAddedTaskCheckbox()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompleteNewlyAddedTaskCheckbox().click();
	        //This task should not appear in the list anymore
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getNoInternalTaskLabel()));
	        //But It should be visible in completed task though
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getViewCompletedTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionTeamTaskSubSection()
	                .getViewCompletedTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompletedTeamTaskPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompletedTeamTaskPopup().getFirstCompletedTask()));
	        TestAssert.verifyElementContent(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompletedTeamTaskPopup().getFirstCompletedTask(), "Team task 1");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionTeamTaskSubSection().getCompletedTeamTaskPopup().getClosePopupLink().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that new client task can be marked as complete on client dashboard")
	    public void verify_that_new_client_task_can_be_marked_as_complete_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab().click();
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getClientTasksContainer());
	        //Add the task
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientDashboardPageTaskSectionClientTaskSubSection()
	                .getAddClientTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskPopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskPopup().selectTaskType("Welcome Step");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getAddClientTaskPopup().getAssignTaskToClientButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Portal task assigned successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        //Verify the task
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection().getClientTasksTab().click();
	        TestAssert.verifyElementContent(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                        .getClientDashboardPageTaskSectionClientTaskSubSection().getAddedTask(),"Welcome Step");
	        //Now complete the task
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().selectAction("Complete");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getCompleteClientTaskPopup().getPageTitle()));

//	        for(String windowName: webdriver.getWindowHandles()){
//	            System.out.println("**********Windowname : "+ windowName);
//	            webdriver.switchTo().window(windowName);
//	        }
//	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
//	                .getClientDashboardPageTaskSectionClientTaskSubSection().getCompleteClientTaskPopup().scroll("0", "document.body.scrollHeight");
	        //myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getCompleteClientTaskPopup().getCompleteNowButton()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageTaskSection()
	                .getClientDashboardPageTaskSectionClientTaskSubSection().getCompleteClientTaskPopup().getCompleteNowButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Portal task completed successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that a memo can be added on client dashboard$")
	    public void verify_that_a_memo_can_be_added_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageMemoSection().getEditMemoButton()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageMemoSection().getEditMemoButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageMemoSection().getMemoText()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageMemoSection().inputMemoText("Memo1");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageMemoSection().getSaveMemoButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageMemoSection().getMemoContainer()));
	        TestAssert.verifyElementContent(myClientsPage.getClientDashboardPage().getClientDashboardPageMemoSection().getEditMemoButton(), "Memo1");

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that team member assigned to client is specified on client dashboard$")
	    public void verify_that_team_member_assigned_to_client_is_specified_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageContactSection().getPageContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageContactSection().getSendEmailLink()));
	        TestAssert.verifyElementContent(myClientsPage.getClientDashboardPage().getClientDashboardPageContactSection().getPageContainer(), loggedinUser);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that scores are visible on client dashboard$")
	    public void verify_that_scores_are_visible_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getScoreContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getAddEditScoreLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getChartContainer());

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that scores can be added on client dashboard$")
	    public void verify_that_scores_can_be_added_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getScoreContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getAddEditScoreLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getChartContainer());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getAddEditScoreLink().click();
	        //Add the scores
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputEquifaxScore("0");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputExperianScore("0");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputTransunionScore("0");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getScoreDate()));
	        ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('scoreDateAdd').removeAttribute('readonly',0);"); // Enables the date box
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getScoreDate().clear();
	        LocalDate date = LocalDate.now();
	        String scoreDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputScoreDate(scoreDate);
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getAddScoreButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Record inserted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        //Verify the scores
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getAddedScore()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getClosePopupLink().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that scores can be edited on client dashboard$")
	    public void verify_that_scores_can_be_edited_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getScoreContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getAddEditScoreLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getChartContainer());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getAddEditScoreLink().click();
	        //Add the scores
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputEquifaxScore("0");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputExperianScore("0");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputTransunionScore("0");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getScoreDate()));
	        ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('scoreDateAdd').removeAttribute('readonly',0);"); // Enables the date box
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getScoreDate().clear();
	        LocalDate date = LocalDate.now();
	        String scoreDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputScoreDate(scoreDate);
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getAddScoreButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Record inserted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        //Verify the scores
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getAddedScore()));
	        //Now Edit the scores
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getEditScoreLink()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getEditScoreLink().click();
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputNewEquifaxScore("1");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputNewExperianScore("1");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().inputNewTransunionScore("1");
	        //Save the edited scored
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getSaveScoreButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Record updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageScoreSection().getManageScorePopup().getClosePopupLink().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that disputed items are visible on client dashboard$")
	    public void verify_that_disputed_items_are_visible_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getStatusContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getChartContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getViewUpdateAllDisputeItemsButton());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getImportOnlineCreditReportsButton());

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on clicking 'All dispute items' button on client dashboard, dispute detail page is shown$")
	    public void verify_that_on_clicking_all_dispute_items_button_on_client_dashboard_dispute_detail_page_is_shown(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getStatusContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getChartContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getViewUpdateAllDisputeItemsButton());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getImportOnlineCreditReportsButton());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getViewUpdateAllDisputeItemsButton().click();
	        myClientsPage.getDisputeItemPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on clicking 'Import Online Credit Reports' button on client dashboard, import audit page is shown$")
	    public void verify_that_on_clicking_import_online_credit_reports_button_on_client_dashboard_import_audit_page_is_shown(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getStatusContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getChartContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getViewUpdateAllDisputeItemsButton());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getImportOnlineCreditReportsButton());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getImportOnlineCreditReportsButton().click();
	        myClientsPage.getImportAuditPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that graphical representation of dispute status of each bureau can be shown on client dashboard$")
	    public void verify_that_graphical_representation_of_disputed_status_of_each_bureau_can_be_shonw_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getStatusContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getChartContainer());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getViewUpdateAllDisputeItemsButton());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getImportOnlineCreditReportsButton());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().selectBureau("Equifax");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getBureauChart()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().selectBureau("Experian");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getBureauChart()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().selectBureau("Transunion");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getBureauChart()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on clicking 'Document Storage' link on client dashboard, document storage popop is shown$")
	    public void verify_that_on_clicking_document_storage_link_on_client_dashboard_document_storage_popup_is_shown(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getClientsSavedLettersLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStorageLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStorageLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStoragePopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStoragePopup().getClosePopupLink().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that client documents can be added via document storage popup$")
	    public void verify_that_client_documents_can_be_added_via_document_storage_popup() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getClientsSavedLettersLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStorageLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStorageLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStoragePopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStoragePopup().getFilePickerLink()));
	        String filePath = new File(this.getClass().getResource("/data/sample_agreement.docx").toURI()).getCanonicalPath();
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStoragePopup().getFilePickerLink().sendKeys(filePath);
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStoragePopup().getSubmitButton().click();
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Document uploaded successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that on clicking 'Clients Saved Letters' link on client dashboard, saved letters page is shown$")
	    public void verify_that_on_clicking_clients_saved_letter_link_on_client_dashboard_saved_letters_page_is_shown(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getClientsSavedLettersLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getDocumentStorageLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getClientsSavedLettersLink().click();
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getSavedLettersPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that invoice details are shown on client dashboard$")
	    public void verify_that_invoice_details_are_shown_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getCreateInvoiceLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getAllInvoicesLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPaymentsLink());
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getNewTaskLink());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getTotalInvoicedValue()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getReceivedValue()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getOutstandingValue()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPastDueValue()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getChargebeeTxHistoryLink());

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that new invoice can be created on client dashboard$")
	    public void verify_that_new_invoice_can_be_created_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getCreateInvoiceLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getCreateInvoiceLink().click();
	        myClientsPage.getCreateNewInvoicePage().isLoaded();
	        myClientsPage.getCreateNewInvoicePage().inputItemDescription("Item 1");
	        myClientsPage.getCreateNewInvoicePage().inputItemPrice("100");
	        myClientsPage.getCreateNewInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        myClientsPage.getAllClientInvoicesPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that all invoices can be viewed on client dashboard$")
	    public void verify_that_all_invoices_can_be_viewed_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getAllInvoicesLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getAllInvoicesLink().click();
	        myClientsPage.getClientInvoicesHistoryPage().isLoadedWtihUrl("item");

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that clients payments can be viewed on client dashboard$")
	    public void verify_that_clients_payments_can_be_viewed_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPaymentsLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPaymentsLink().click();
	        myClientsPage.getClientInvoicesHistoryPage().isLoadedWtihUrl("payment");

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that billing related tasks can be added on client dashboard$")
	    public void verify_that_billing_related_tasks_can_be_added_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getNewTaskLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getNewTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getAddTeamTaskPopup().getPageTitle()));
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getAddTeamTaskPopup().inputSubject("Billing task 1");
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getAddTeamTaskPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Task added successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that 'Chargebee Transaction History' can be viewed on client dashboard$")
	    public void verify_that_chargebee_tranwaction_history_can_be_viewed_on_client_dashboard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getPageContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getChargebeeTxHistoryLink());
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getChargebeeTxHistoryLink().click();
	        myClientsPage.getClientDashboardPage().getClientDashboardPageInvoiceSection().getChargebeeContinueLink().click();
	        companyPage.getChargebeeSettingsPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that credit report can be imported with 1-click in Import Audit Tab$")
	    public void verify_that_credit_report_can_be_imported_with_1_click_in_Import_Audit_Tab(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickImportAuditTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getImportAuditPage().getImportCreditReportPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getImportAuditPage().getImportCreditReportPopup().getNewAutoImportButton()));
	        myClientsPage.getImportAuditPage().getImportCreditReportPopup().getNewAutoImportButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getImportAuditPage().getImportCreditReportPopup().getNextPageHeader()));
	        myClientsPage.getImportAuditPage().getImportCreditReportPopup().selectProvider(1);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that 'Step1' page can be viewed by clicking on 'Step1' link in Dispute Wizard$")
	    public void verify_that_Step1_page_can_be_viewed_by_clicking_on_Step1_link_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that 'Credit Report Overview' overlay is shown when clicking on 'Order credit History Report' in Dispute Wizard$")
	    public void verify_that_credit_report_overview_overlay_is_shown_when_clicking_on_order_credit_history_report_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that quick video can be viewed by Method 1 quick video shortcut in Dispute Wizard$")
	    public void verify_that_quick_video_can_be_viewed_by_method1_quick_video_shortcut_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getMethod1QuickVidepLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getMethod1QuickVidepLink().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getVideoPopup()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getVideoPopupCloseButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getVideoPopupCloseButton().click();
	            Thread.sleep(2000);
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that quick video can be viewed by Method 2 quick video shortcut in Dispute Wizard$")
	    public void verify_that_quick_video_can_be_viewed_by_method2_quick_video_shortcut_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getMethod2QuickVidepLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getMethod2QuickVidepLink().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getVideoPopup()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getVideoPopupCloseButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getVideoPopupCloseButton().click();
	            Thread.sleep(2000);
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that report providers list can be viewed in Dispute Wizard$")
	    public void verify_that_report_providers_list_can_be_viewed_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));

	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getReportProvidersLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getReportProvidersLink().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getReportProvidersListPopup()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().scroll("2000","0");
	            //Problem with the Application : popup has absolute CSS which is creating problem in headless mode where window is half hidden(so as the close link)
//	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseReportProvdersListPopupLink()));
//	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseReportProvdersListPopupLink().click();
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that sample report can be viewed in Dispute Wizard$")
	    public void verify_that_sample_report_can_be_viewed_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));

	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getSampleReportLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getSampleReportLink().click();
	            sampleReportPage.isLoadedInTab();
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'Import/Audit' tab upon clicking 'import online credit reports' link in 'Dispute wizard' screen$")
	    public void verify_that_admin_can_navigate_to_import_audit_tab_from_dispute_wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getImportReportLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getImportReportLink().click();
	            myClientsPage.getImportAuditPage().isLoadedInTab();
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can order free annual reports by mail in 'Dispute wizard' screen$")
	    public void verify_that_admin_can_order_free_annual_reports_by_mail_in_dispute_wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOrderFreeReportsByMailLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOrderFreeReportsByMailLink().click();
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1aPage().isLoaded();
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1aPage().getEquifaxOption().click();
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1aPage().getNextButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1aPage().getFormEditor()));
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can order free annual reports online in 'Dispute wizard' screen$")
	    public void verify_that_admin_can_order_free_annual_reports_online_in_dispute_wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOrderFreeReportsByOnlineLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOrderFreeReportsByOnlineLink().click();
	            annualCreditReportPage.isLoadedInTab();
	        }
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can request credit reports by mail in 'Dispute wizard' screen$")
	    public void verify_that_admin_can_request_credit_reports_by_mail_in_dispute_wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getRequestCreditReportsByMailLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getRequestCreditReportsByMailLink().click();

	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1cPage().isLoaded();
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1cPage().getEquifaxOption().click();
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1cPage().getDisputeOption().click();
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1aPage().getNextButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getDisputeWizardStep1aPage().getFormEditor()));
	        }

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can order credit report from favourite provider$")
	    public void verify_that_admin_can_order_credit_report_from_favourite_provider() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOrderReportFromMyFavProviderLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOrderReportFromMyFavProviderLink().click();
	            privacyGuardPage.isLoadedInTab();
	        }
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can change favourite provider$")
	    public void verify_that_admin_can_change_favourite_provider() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getModifyFavProviderLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getModifyFavProviderLink().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getChangeFavouriteProviderPopup().getPageTitle()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getChangeFavouriteProviderPopup().inputProviderName("http://www.privacyguard.com");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getChangeFavouriteProviderPopup().getSaveButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getChangeFavouriteProviderPopup().getSaveButton().click();
	        }
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'Import/Audit' tab upon clicking 'Click here for details'$")
	    public void verify_that_admin_can_navigate_to_import_audit_upon_clicking_on_details_link() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	            myClientsPage.scroll("0", "document.body.scrollHeight");
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getMoreDetailsLink()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getMoreDetailsLink().click();
	            myClientsPage.getImportAuditPage().isLoaded();
	        }
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'Import/Audit' tab upon clicking 'import online credit reports' displayed on under 'Tips'$")
	    public void verify_that_admin_can_navigate_to_import_audit_upon_clicking_import_online_credit_reports_link_under_tips() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsImportOnlineCreditReportsLink()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsImportOnlineCreditReportsLink().click();
	        myClientsPage.getImportAuditPage().isLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'https://www.privacyguard.com/' upon clicking the link 'Privacy guard' displayed on under 'Tips'$")
	    public void verify_that_admin_can_navigate_to_privacygard_site_upon_clicking_privacy_gard_link_link_under_tips() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getOverlayTitle()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsPrivacyGuardLink()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsPrivacyGuardLink().click();
	        privacyGuardPage.isLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to navigate to 'Import/Audit' tap upon clicking the link 'Importing credit reports' displayed on under 'Tips' in Dispute Wizard$")
	    public void verify_that_admin_should_be_able_to_navigate_to_import_audit_tap_upon_clicking_the_link_importing_credit_reports_displayed_under_tips_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsImportingCreditReportsLink()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsImportingCreditReportsLink().click();
	        myClientsPage.getImportAuditPage().isLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to navigate to 'Dashboard' page upon clicking the link 'Sample client' displayed on under 'Tips' in Dispute Wizard$")
	    public void verify_that_admin_should_be_able_to_navigate_to_dashboard_page_upon_clicking_the_link_sample_client_displayed_under_tips_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsSampleClientLink()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsSampleClientLink().click();
	        myClientsPage.getClientDashboardPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to navigate to 'Sample Report' page upon clicking the link 'Sample report' displayed on under 'Tips' in Dispute Wizard$")
	    public void verify_that_admin_should_be_able_to_navigate_to_sample_report_page_upon_clicking_the_link_sample_report_displayed_under_tips_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsSampleReportLink()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getTipsSampleReportLink().click();
	        sampleReportPage.isLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that 'Step2' page can be viewed by clicking on 'Step2' button in Dispute Wizard$")
	    public void verify_that_Step2_page_can_be_viewed_by_clicking_on_Step2_button_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep2Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to navigate to previous page by 'Back' button in Dispute Wizard$")
	    public void verify_that_admin_should_be_able_to_navigate_to_previous_page_by_back_button_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep1Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isLoaded();

	        if(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().isOverlayShown()){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getCloseOverlayButton().click();
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getBackButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep1Page().getBackButton().click();
	        myClientsPage.getDisputeWizardPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to navigate to 'Who orders the credit reports' page upon clicking 'Client Report' button in Dispute Wizard$")
	    public void verify_that_admin_should_be_able_to_navigate_to_who_orders_the_credit_report_page_upon_clicking_client_report_button_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));

	        myClientsPage.getDisputeWizardPage().getStep2Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().isLoaded();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().getReportButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().getReportButton().click();
	        orderCreditReportPage.isLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that 'Step3' page can be viewed by clicking on 'Step3' link in 'Step 2' page in Dispute Wizard$")
	    public void verify_that_Step3_page_can_be_viewed_by_clicking_on_Step3_link_in_Step_2_page_in_Dispute_Wizard(){
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep2Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().isLoaded();
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().getStep3Link()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that 'Step3' page can be viewed by clicking on 'Step3' button in 'Step 2' page in Dispute Wizard$")
	    public void verify_that_Step3_page_can_be_viewed_by_clicking_on_Step3_button_in_Step_2_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep2Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().isLoaded();
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().getStep3Link()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep2Page().getStep3Button().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to watch a quick video on 'Adding report items manually' in Dispute Wizard$")
	    public void verify_that_admin_should_be_able_to_watch_a_quick_video_on_adding_report_items_manually_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddingReportQuickVideo()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddingReportQuickVideo().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getVideoPopupCloseButton()));
	        myClientsPage.getDisputeItemReportViewPage().getVideoPopupCloseButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to watch a quick video on 'Working with Saved or Imported Items' in Dispute Wizard$")
	    public void verify_that_admin_should_be_able_to_watch_a_quick_video_on_working_with_saved_or_imoported_items_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedItemsQuickVideo()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedItemsQuickVideo().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getVideoPopupCloseButton()));
	        myClientsPage.getDisputeItemReportViewPage().getVideoPopupCloseButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    private void addDisputeItemForReport() throws Exception{
	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound1Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getReportNumberSection()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddNewItemButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getDisputeForm()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().inputAccountNumber("1111111");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectReason(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectInstruction(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainerHeader()));
	        }catch(org.openqa.selenium.StaleElementReferenceException ex) {
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainerHeader()));
	        }
	        verifyAddedLetter();
	    }

	    private void verifyAddedLetter() throws Exception{
	        try{
	            Thread.sleep(3000);
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                    .getFirstDisputedItemCheckbox()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getFirstDisputedItemCheckbox().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            Thread.sleep(3000);
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                    .getFirstDisputedItemCheckbox()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getFirstDisputedItemCheckbox().click();
	        }
	    }

	    private void addDisputeItemForReportRound2(boolean letterToCredFurn, boolean all){
	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound2Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getBureauFurnisherSection()));
	        if(letterToCredFurn){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterToCredFurn()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterToCredFurn().click();
	        }
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddNewItemRound2Button().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getDisputeForm()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox().click();
	        if(all){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getExperianCheckbox()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getExperianCheckbox().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTransunionCheckbox()));
	            myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTransunionCheckbox().click();
	        }
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().inputAccountNumber("1111111");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectReason(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectInstruction(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        verifyAddedLetterRound2();
	    }

	    private void verifyAddedLetterRound2(){
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemForm()));
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemForm()));
	        }
	    }

	    @Then("^verify that letter for 'Round 1: Basic Dispute' can be created by adding new items in Step3 page in Dispute Wizard$")
	    public void verify_that_letter_for_round1_can_be_created_by_adding_new_items_in_Step_3_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();

	        cleanupClient(dummyClient.getFirstName());
	    }


	    @Then("^verify that admin should be able to add creditor/furnisher while adding a new item for Round 1 letter$")
	    public void verify_that_admin_should_be_able_to_add_creditor_furnisher_while_adding_a_new_item_for_round1_letter() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound1Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getReportNumberSection()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddNewItemButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getDisputeForm()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddCredtorFurnisher()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddCredtorFurnisher().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddFurnisherPopup().getPageTitle()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddFurnisherPopup().inputFurnisherName("Furnisher"+ currentTimeInMillis);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddFurnisherPopup().getAddFurnisherButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Furnisher added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().inputAccountNumber("1111111");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectReason(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectInstruction(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainerHeader()));
	        verifyAddedLetter();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new reason while adding a new item for Round 1 letter$")
	    public void verify_that_admin_should_be_able_to_add_new_reason_while_adding_a_new_item_for_round1_letter() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound1Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getReportNumberSection()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddNewItemButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getDisputeForm()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().inputAccountNumber("1111111");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getManageReason().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getManageReasonsPopup().getPageTitle()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getManageReasonsPopup().inputReason("reason"+currentTimeInMillis);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getManageReasonsPopup().getAddButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Reason added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getManageReasonsPopup().getClosePopupLink().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectReason(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectInstruction(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainerHeader()));
	        verifyAddedLetter();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new instruction while adding a new item for Round 1 letter$")
	    public void verify_that_admin_should_be_able_to_add_new_instruction_while_adding_a_new_item_for_round1_letter() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound1Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getReportNumberSection()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddNewItemButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getDisputeForm()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().inputAccountNumber("1111111");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectReason(1);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getManageInstruction().click();
	        long currentTimeInMillis = System.currentTimeMillis();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().inputInstruction("instruction"+currentTimeInMillis);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainerHeader()));
	        verifyAddedLetter();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that letter for 'Round 1: Basic Dispute' can be created by adding saved items in Step3 page in Dispute Wizard$")
	    public void verify_that_letter_for_round1_can_be_created_by_adding_saved_items_in_Step_3_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound1Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getReportNumberSection()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddSavedPendingItemsButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getAllCredFurnCheckBox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedPendingItemPopup().getAllCredFurnCheckBox().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedPendingItemPopup().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin is able to edit the dispute letter$")
	    public void verify_that_admin_is_able_to_edit_the_dispute_letter_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));

	        webdriver.switchTo().frame("1_editor_ifr");//switching the frame by ID
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterContent()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().inputLetterContent("bla");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin is able to preview the dispute letter$")
	    public void verify_that_admin_is_able_to_preview_the_dispute_letter_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLetterButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLetterButton().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLettersPopup().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLettersPopup().scroll("2000","0");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLettersPopup().getClosePopupLink()));
	        //In headless mode, due to small window side, popup close link is not accessible.
//	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
//	                .getPreviewLettersPopup().getClosePopupLink().click();
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin is able to navigate to saved letters page$")
	    public void verify_that_admin_is_able_to_navigate_to_saved_letters_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getMySavedLettersButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getMySavedLettersButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getUnsavedLetterWarningPopup().getLeaveButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getUnsavedLetterWarningPopup().getLeaveButton().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedLettersPage().isLoaded();
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that dispute letter can be exported as PDF in Dispute Wizard$")
	    public void verify_that_dispute_letter_can_be_exported_as_PDF_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getExportAsPDFButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getExportAsPDFButton().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().pdfLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that dispute letter can be saved in Dispute Wizard$")
	    public void verify_that_dispute_letter_can_be_saved_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveLettersButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveLettersButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().getSaveButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().inputName("Letter1");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Letter saved successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that letter for 'Round 2: All other letters' can be created by adding new item in Step3 page in Dispute Wizard$")
	    public void verify_that_letter_for_round2_can_be_created_by_adding_new_item_in_Step_3_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, false);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that letter for 'Round 2: All other letters' can be created by adding saved item in Step3 page in Dispute Wizard$")
	    public void verify_that_letter_for_round2_can_be_created_by_adding_saved_item_in_Step_3_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, false);
	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound2Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getBureauFurnisherSection()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddSavedPendingItemsRound2Button().click();


	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageTitleRound2()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getAllCredFurnCheckBox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedPendingItemPopup().getAllCredFurnCheckBox().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedPendingItemPopup().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageTitleRound2()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditor()));

	        cleanupClient(dummyClient.getFirstName());

	    }

	    @Then("^verify that letter for 'Round 2: All other letters' to creditor-furnisher can be created by adding new item in Step3 page in Dispute Wizard$")
	    public void verify_that_letter_for_round2_to_creditor_furnisher_can_be_created_by_adding_new_item_in_Step_3_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(true, false);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that letter for 'Round 2: All other letters' to creditor-furnisher can be created by adding saved items in Step3 page in Dispute Wizard$")
	    public void verify_that_letter_for_round2_to_creditor_furnisher_can_be_created_by_adding_saved_items_in_Step_3_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(true, false);
	        clientNavigationHelper.clickDisputeWizardTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getPageTitle()));
	        myClientsPage.getDisputeWizardPage().getStep3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getRound2Radio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getBureauFurnisherSection()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterToCredFurn().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddSavedPendingItemsRound2Button().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageTitleRound2()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getAllCredFurnCheckBox()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedPendingItemPopup().getAllCredFurnCheckBox().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedPendingItemPopup().getContinueButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSavedPendingItemPopup().getPageTitleRound2()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getAddedDisputeItemContainer()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditor()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that letter for 'Round 2: All other letters' can not be created without selecting the letter in Step3 page in Dispute Wizard$")
	    public void verify_that_letter_for_round2_can_not_be_created_without_selecting_letter_in_Step_3_page_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, false);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessageContainer()));
	        myClientsPage.getWarningPopup().getOkButton().click();

	        cleanupClient(dummyClient.getFirstName());

	    }

	    @Then("^verify that Round 2 dispute letter can be exported as PDF in Dispute Wizard$")
	    public void verify_that_round2_dispute_letter_can_be_exported_as_PDF_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, false);
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getExportAsPDFButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getExportAsPDFButton().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().pdfLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that Round 2 dispute letter can be saved in Dispute Wizard$")
	    public void verify_that_round2_dispute_letter_can_be_saved_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, false);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveLettersButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveLettersButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().getSaveButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().inputName("Letter1");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getSaveDisputeLettersPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Letter saved successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that Round 2 dispute letter can be previewed in Dispute Wizard$")
	    public void verify_that_round2_dispute_letter_can_be_previewed_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, false);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getLetterEditorContent()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLetterButton()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLetterButton().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLettersPopup().getPageTitle()));

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
	                .getPreviewLettersPopup().getOkButton()));
//	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page()
//	                .getPreviewLettersPopup().getOkButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can view all the bureaus letter in their respective tabs$")
	    public void verify_that_admin_can_view_all_the_bureaus_letters_in_their_respective_tabs_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, true);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getExperianTab()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTransUnionTab()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getClientDocsTab()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getExperianTab().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTransUnionTab().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getClientDocsTab().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getClientDocsContainer()));
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can view the clients documents in Dispute Wizard$")
	    public void verify_that_admin_can_view_the_clients_documents_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReportRound2(false, false);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterFromLibraryRadio().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLibraryContainer()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterFromLibrary(1);
	        Thread.sleep(3000);
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().selectLetterName(1);
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getClientDocsTab()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getClientDocsTab().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getClientDocsContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'My saved letters' page upon clicking 'Saved letters' link under tips in Dispute Wizard$")
	    public void verify_that_admin_can_navigate_to_my_saved_letters_page_upon_clicking_saved_letters_link_under_tips_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTipSavedLettersLink()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTipSavedLettersLink().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getSavedLettersPage().isLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'Clients Dashboard' page upon clicking 'clients dashboard' link under tips in Dispute Wizard$")
	    public void verify_that_admin_can_navigate_to_clients_dashboard_page_upon_clicking_clients_dashboard_link_under_tips_in_Dispute_Wizard() throws Exception{
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getNextButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getLetterEditor()));
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTipClientDashboardLink()));
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().getTipClientDashboardLink().click();
	        myClientsPage.getClientDashboardPage().isLoadedInTab();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can view the dispute items in 'List view' in Dispute Items page$")
	    public void verify_that_admin_can_view_the_dispute_items_in_list_view_in_dispute_item_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getListViewTab());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getDisputeItemsContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can edit the dispute item in Dispute Items page$")
	    public void verify_that_admin_can_edit_the_dispute_item_in_dispute_items_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getDisputeItemsContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getFirstItemEditLink()));
	        myClientsPage.getDisputeItemPage().getFirstItemEditLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().getSaveButton()));
	        myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().selectReason(2);
	        myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().selectStatus(2);
	        myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().inputAccountName(" account1");
	        myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item updated successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that update of dispute item status is possible in Dispute item page$")
	    public void verify_that_update_of_dispute_item_status_is_possible_in_dispute_item_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getDisputeItemsContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getFirstItemEditLink()));
	        myClientsPage.getDisputeItemPage().getFirstItemEditLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().getSaveButton()));
	        myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().selectStatus(2);
	        myClientsPage.getDisputeItemPage().getEditDisputeItemPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item updated successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'Dispute wizard' tab upon clicking 'run wizard 3' link in 'Dispute items' List view page$")
	    public void verify_that_admin_can_navigate_to_dispute_wizard_tab_upon_clicking_run_wizard3_link_in_dispute_items_list_view_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getDisputeItemsContainer()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getListViewTab());
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getRunWizrd3Link());
	        myClientsPage.getDisputeItemPage().getRunWizrd3Link().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can view the dispute items in 'Report view' in Dispute Items page$")
	    public void verify_that_admin_can_view_the_dispute_items_in_report_view_in_dispute_item_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getReportViewTab());
	        myClientsPage.getDisputeItemPage().getReportViewTab().click();
	        myClientsPage.getDisputeItemReportViewPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getReportViewNotice()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getManuallyEntereedItemsForm()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that delete of dispute item is possible in Dispute item page$")
	    public void verify_that_delete_of_dispute_item_is_possible_in_dispute_item_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getDisputeItemsContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getFirstItemDeleteLink()));
	        myClientsPage.getDisputeItemPage().getFirstItemDeleteLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item deleted successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'Dispute wizard' tab upon clicking 'run the dispute wizard' link in 'Dispute items' Report view page$")
	    public void verify_that_admin_can_navigate_to_dispute_wizard_tab_upon_clicking_run_the_dispute_wizard_link_in_dispute_items_report_view_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getReportViewTab());
	        myClientsPage.getDisputeItemPage().getReportViewTab().click();
	        myClientsPage.getDisputeItemReportViewPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getReportViewNotice()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getManuallyEntereedItemsForm()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemReportViewPage().getRunDisputeWizardLink());
	        myClientsPage.getDisputeItemReportViewPage().getRunDisputeWizardLink().click();
	        myClientsPage.getDisputeWizardPage().getDisputeWizardStep3Page().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can view the demo video upon clicking 'See video demo' link displayed in 'Dispute items' Report view page$")
	    public void verify_that_admin_can_view_the_demo_video_upon_clicking_see_video_demo_link_in_dispute_items_report_view_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getReportViewTab());
	        myClientsPage.getDisputeItemPage().getReportViewTab().click();
	        myClientsPage.getDisputeItemReportViewPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getReportViewNotice()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemReportViewPage().getSeeVideoDemoLink());
	        myClientsPage.getDisputeItemReportViewPage().getSeeVideoDemoLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getVideoPopupCloseButton()));
	        myClientsPage.getDisputeItemReportViewPage().getVideoPopupCloseButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to clients dashboard page upon clicking 'clients dashboard' link displayed in 'Dispute items' Report view page$")
	    public void verify_that_admin_can_navigate_to_clients_dashboard_page_upon_clicking_clients_dashboard_link_in_dispute_items_report_view_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getReportViewTab());
	        myClientsPage.getDisputeItemPage().getReportViewTab().click();
	        myClientsPage.getDisputeItemReportViewPage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getReportViewNotice()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemReportViewPage().getDashboardLink());
	        myClientsPage.getDisputeItemReportViewPage().getDashboardLink().click();
	        myClientsPage.getClientDashboardPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can navigate to 'My saved letters' page upon clicking 'Saved letters' link displayed in 'Dispute items' Report view page$")
	    public void verify_that_admin_can_navigate_to_my_saved_letters_page_upon_clicking_saved_letters_link_in_dispute_items_report_view_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getReportViewTab());
	        myClientsPage.getDisputeItemPage().getReportViewTab().click();
	        myClientsPage.getDisputeItemReportViewPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemReportViewPage().getReportViewNotice()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemReportViewPage().getSavedLettersLink());
	        myClientsPage.getDisputeItemReportViewPage().getSavedLettersLink().click();
	        myClientsPage.getClientDashboardPage().getClientDashboardPageDisputeStatusSection().getSavedLettersPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin can watch the quick video on 'How to add the dispute items manually' in 'Dispute items' List view page$")
	    public void verify_that_admin_can_watch_the_quick_video_on_how_to_add_the_dispute_items_manually_dispute_items_list_view_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getQuickVideoLink());
	        myClientsPage.getDisputeItemPage().getQuickVideoLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getVideoPopupCloseButton()));
	        myClientsPage.getDisputeItemPage().getVideoPopupCloseButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new dispute item$")
	    public void verify_that_admin_should_be_able_to_add_new_dispute_item() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getAddNewItemButton());
	        myClientsPage.getDisputeItemPage().getAddNewItemButton().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputAccountNumber("1111111");
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectReason(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectInstruction(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item was added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new dispute item by selecting the mode 'Different for each bureau'$")
	    public void verify_that_admin_should_be_able_to_add_new_dispute_item_by_selecting_the_mode_different_for_each_bureau() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        //addDisputeItemForReport();
	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getAddNewItemButton());
	        myClientsPage.getDisputeItemPage().getAddNewItemButton().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getExperianCheckbox().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectCreditorFurnisher(1);
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getDifferentAccountNuumberLink()));
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getDifferentAccountNuumberLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getAccountNumber1()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getAccountNumber2()));
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputAccountNumber1("1111111");
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputAccountNumber2("22222222");
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectReason(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectInstruction(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item was added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new 'creditor/furnisher' while adding a new dispute item$")
	    public void verify_that_admin_should_be_able_to_add_new_cred_furn_while_adding_a_new_dispute_item() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getAddNewItemButton());
	        myClientsPage.getDisputeItemPage().getAddNewItemButton().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getAddNewCreditorFurnisher().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getAddFurnisherPopup().getPageTitle()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getAddFurnisherPopup().inputFurnisherName("Furnisher"+ currentTimeInMillis);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getAddFurnisherPopup().getAddFurnisherButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Furnisher added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputAccountNumber("1111111");
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectReason(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectInstruction(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item was added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new 'Dispute Reason' while adding a new dispute item$")
	    public void verify_that_admin_should_be_able_to_add_new_dispute_reason_while_adding_a_new_dispute_item() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getAddNewItemButton());
	        myClientsPage.getDisputeItemPage().getAddNewItemButton().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputAccountNumber("1111111");
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getManageReason().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getManageReasonsPopup().getPageTitle()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getManageReasonsPopup().inputReason("reason"+currentTimeInMillis);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getManageReasonsPopup().getAddButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Reason added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getManageReasonsPopup().getClosePopupLink().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectReason(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectInstruction(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item was added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new 'Instruction' while adding a new dispute item$")
	    public void verify_that_admin_should_be_able_to_add_new_instruction_while_adding_a_new_dispute_item() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getAddNewItemButton());
	        myClientsPage.getDisputeItemPage().getAddNewItemButton().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputAccountNumber("1111111");
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectReason(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getManageInstruction().click();
	        long currentTimeInMillis = System.currentTimeMillis();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputInstruction("instruction"+currentTimeInMillis);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item was added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should not be able to add new dispute item without entering mandatory fields$")
	    public void verify_that_admin_should_be_able_to_add_new_dispute_item_without_entering_mandatory_fields() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickDisputeItemsTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getDisputeItemPage().getPageTitle()));
	        TestAssert.verifyElementVisible(myClientsPage.getDisputeItemPage().getAddNewItemButton());
	        myClientsPage.getDisputeItemPage().getAddNewItemButton().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessageContainer()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        Thread.sleep(2000);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getEquifaxCheckbox().click();
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectCreditorFurnisher(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().inputAccountNumber("1111111");
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectReason(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().selectInstruction(1);
	        myClientsPage.getDisputeItemPage().getAddDisputeItemPage().getSubmitButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Dispute item was added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to view clients Outstanding Debt in educate page$")
	    public void verify_that_admin_should_be_able_to_view_clients_outstanding_debt_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsOutstandingDebts()));
	        myClientsPage.getEducatePage().getClientsOutstandingDebts().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDebtsViewerHeader()));
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getChartSection()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add clients Outstanding Debt in educate page$")
	    public void verify_that_admin_should_be_able_to_add_clients_outstanding_debt_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsOutstandingDebts()));
	        myClientsPage.getEducatePage().getClientsOutstandingDebts().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDebtsViewerHeader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getCreditAccountsHeader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getAccount()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getApr()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getLimit()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getBalance()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputAccount("111111");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputLimit("10");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputBalance("10");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //Add
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client debt details added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        //view the changes
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getChartSection()));
	        //cleanup
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client debt details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to update clients Outstanding Debt in educate page$")
	    public void verify_that_admin_should_be_able_to_update_clients_outstanding_debt_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsOutstandingDebts()));
	        myClientsPage.getEducatePage().getClientsOutstandingDebts().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDebtsViewerHeader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getCreditAccountsHeader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getAccount()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getApr()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getLimit()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getBalance()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputAccount("111111");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputLimit("10");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputBalance("10");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //Add
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client debt details added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        //view the changes
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getChartSection()));

	        //Update
	        myClientsPage.scroll("0", "-1000");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getAccount()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getApr()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getLimit()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getBalance()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputAccount("111111");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputLimit("10");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputBalance("5");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getUpdateButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getUpdateButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client debt details updated");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //cleanup
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client debt details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to print clients Outstanding Debt in educate page$")
	    public void verify_that_admin_should_be_able_to_print_clients_outstanding_debt_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsOutstandingDebts()));
	        myClientsPage.getEducatePage().getClientsOutstandingDebts().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDebtsViewerHeader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getCreditAccountsHeader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getAccount()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getApr()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getLimit()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getBalance()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputAccount("111111");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputLimit("10");
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().inputBalance("10");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        //Add
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client debt details added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //view the changes
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getChartSection()));

	        //print
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getPrintButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getPrintButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getEducatePageClientOutstandingDebtsSectionPrintPreviewPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getEducatePageClientOutstandingDebtsSectionPrintPreviewPopup().getClosePopupLink()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getEducatePageClientOutstandingDebtsSectionPrintPreviewPopup().getOkButton()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getEducatePageClientOutstandingDebtsSectionPrintPreviewPopup().getPrintButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getEducatePageClientOutstandingDebtsSectionPrintPreviewPopup().getOkButton().click();

	        //cleanup
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientOutstandingDebtsSection().getDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Client debt details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add daily expenses on Client in educate page$")
	    public void verify_that_admin_should_be_able_to_add_daily_expenses_on_client_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsExpenses()));
	        myClientsPage.getEducatePage().getClientsExpenses().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpenseName()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpenseAmount()));

	        //Add Daily Expense
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseName("Fuel");
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseAmount("100");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Daily expense added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Cleanup
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Daily expense details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to update daily expenses on Client in educate page$")
	    public void verify_that_admin_should_be_able_to_update_daily_expenses_on_client_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsExpenses()));
	        myClientsPage.getEducatePage().getClientsExpenses().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpenseName()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpenseAmount()));

	        //Add Daily Expense
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseName("Fuel");
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseAmount("100");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Daily expense added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Update
	        myClientsPage.scroll("0", "-1000");
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseName("Fuel");
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseAmount("50");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesUpdateButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesUpdateButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Daily expense details updated");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Cleanup
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Daily expense details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to print daily expenses on Client in educate page$")
	    public void verify_that_admin_should_be_able_to_print_daily_expenses_on_client_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsExpenses()));
	        myClientsPage.getEducatePage().getClientsExpenses().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpenseName()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpenseAmount()));

	        //Add Daily Expense
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseName("Fuel");
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputDailyExpenseAmount("100");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Daily expense added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Print
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesPrintButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesPrintButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getClosePopupLink()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getOkButton()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getPrintButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getOkButton().click();

	        //Cleanup
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getDailyExpensesDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Daily expense details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add monthly expenses on Client in educate page$")
	    public void verify_that_admin_should_be_able_to_add_monthly_expenses_on_client_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsExpenses()));
	        myClientsPage.getEducatePage().getClientsExpenses().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpenseAmount()));

	        //Add Daily Expense
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputMonthlyExpenseAmount("100");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Monthly expense added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Cleanup
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Monthly expense details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to update monthly expenses on Client in educate page$")
	    public void verify_that_admin_should_be_able_to_update_monthly_expenses_on_client_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsExpenses()));
	        myClientsPage.getEducatePage().getClientsExpenses().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpenseAmount()));

	        //Add Daily Expense
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputMonthlyExpenseAmount("100");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Monthly expense added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Update
	        myClientsPage.scroll("0", "-1000");
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputMonthlyExpenseAmount("50");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesUpdateButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesUpdateButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Monthly expense details updated");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Cleanup
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Monthly expense details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to print monthly expenses on Client in educate page$")
	    public void verify_that_admin_should_be_able_to_print_monthly_expenses_on_client_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getClientsExpenses()));
	        myClientsPage.getEducatePage().getClientsExpenses().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSection()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpenseAmount()));

	        //Add Daily Expense
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().inputMonthlyExpenseAmount("100");
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSaveButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Monthly expense added");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        //Print
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesPrintButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesPrintButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getClosePopupLink()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getOkButton()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getPrintButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getEducatePageClientExpensesSectionPrintPreviewPopup().getOkButton().click();

	        //Cleanup
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesDeleteButton()));
	        myClientsPage.getEducatePage().getEducatePageClientExpensesSection().getMonthlyExpensesDeleteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Monthly expense details deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to access Standard Calculator in educate page$")
	    public void verify_that_admin_should_be_able_access_standard_calculator_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getCalculators()));
	        myClientsPage.getEducatePage().getCalculators().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageCalculatorsSection().getStandardCalculatorSection()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to access Mortgage Calculator in educate page$")
	    public void verify_that_admin_should_be_able_access_mortgage_calculator_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getCalculators()));
	        myClientsPage.getEducatePage().getCalculators().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageCalculatorsSection().getMortgageCalculatorSection()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to access Saving Calculator in educate page$")
	    public void verify_that_admin_should_be_able_access_saving_calculator_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getCalculators()));
	        myClientsPage.getEducatePage().getCalculators().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageCalculatorsSection().getSavingCalculatorSection()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to access CreditCard Calculator in educate page$")
	    public void verify_that_admin_should_be_able_access_creditcard_calculator_in_educate_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickEducateTab();
	        myClientsPage.getEducatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getCalculators()));
	        myClientsPage.getEducatePage().getCalculators().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getEducatePage().getEducatePageCalculatorsSection().getCreditCardCalculatorSection()));

	        cleanupClient(dummyClient.getFirstName());
	    }


	    @Then("^verify that admin should be able to view all the messages/conversations with its clients and team members$")
	    public void verify_that_admin_should_be_able_to_view_all_the_messages_with_its_clients_and_team_members() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }


	    @Then("^verify that admin should be able to view all the conversation with clients under 'Clients messages' tab$")
	    public void verify_that_admin_should_be_able_to_view_all_the_conversation_with_clients_under_clients_messages_tab() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	        messageSectionHelper.getMessageSectionNavigationBar().getClientMessagesTab().click();
	        messageSectionHelper.getClientMessagesPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to send a new message to a client$")
	    public void verify_that_admin_should_be_able_to_send_a_new_message_to_a_client() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",false, false);
	        deleteSentMessage(false);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to reply to the client message$")
	    public void verify_that_admin_should_be_able_to_reply_to_the_client_message() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",false, false);
	        sendReply(false, false);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to attach files while sending a message reply to client$")
	    public void verify_that_admin_should_be_able_to_attach_files_while_sending_a_message_reply_to_client() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",false, false);
	        sendReply(true, false);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to select the quick note as a reply to the client message$")
	    public void verify_that_admin_should_be_able_to_select_the_quick_note_as_a_reply_to_the_client_message() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",false, false);
	        sendReply(false, true);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to delete the sent message to client$")
	    public void verify_that_admin_should_be_able_delete_the_sent_message_to_client() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",false, false);
	        deleteSentMessage(false);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to attach files while sending a new message to client$")
	    public void verify_that_admin_should_be_able_to_attach_files_while_sending_a_new_message_to_client() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",true, false);
	        deleteSentMessage(false);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to save the message as 'Quick Note' while sending the new message to client$")
	    public void verify_that_admin_should_be_able_to_save_the_message_as_quick_notes_while_sending_a_new_message_to_client() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",true, true);
	        deleteSentMessage(false);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to navigate to 'Quick Notes' page by clicking 'Manage Quick Notes'$")
	    public void verify_that_admin_should_be_able_to_navigate_to_quick_notes_page_by_clicking_manage_quick_notes() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	        messageSectionHelper.getMessageSectionNavigationBar().getSendNewMessageTab().click();
	        messageSectionHelper.getSendNewMessagePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesLink()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesLink().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to add new 'Quick Note'$")
	    public void verify_that_admin_should_be_able_to_add_new_quick_note() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	        messageSectionHelper.getMessageSectionNavigationBar().getSendNewMessageTab().click();
	        messageSectionHelper.getSendNewMessagePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesLink()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesLink().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddButton().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().isLoaded();

	        //Add QuickNote
	        long currentTimeInMillis = System.currentTimeMillis();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getTitle()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().inputTitle("QuickNote"+currentTimeInMillis);
	        webdriver.switchTo().frame("body_area_ifr");//switching the frame by ID
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().inputMessage("Sample Message"+currentTimeInMillis);
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getSubmitButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Quick Note has been added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));


	        //Search QuickNote
	        myClientsPage.scroll("2000", "-1000");
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getBackButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getBackButton().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSearchInput()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().inputSearch("QuickNote"+currentTimeInMillis);
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSubmitButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSubmitButton().click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getRemoveSearchedNoteLink()));

	        //Remove QuickNote
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getRemoveSearchedNoteLink().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Quick Note has been deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to edit 'Quick Note'$")
	    public void verify_that_admin_should_be_able_to_edit_quick_note() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	        messageSectionHelper.getMessageSectionNavigationBar().getSendNewMessageTab().click();
	        messageSectionHelper.getSendNewMessagePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesLink()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesLink().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddButton().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().isLoaded();

	        //Add QuickNote
	        long currentTimeInMillis = System.currentTimeMillis();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getTitle()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().inputTitle("QuickNote"+currentTimeInMillis);
	        webdriver.switchTo().frame("body_area_ifr");//switching the frame by ID
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().inputMessage("Sample Message"+currentTimeInMillis);
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getSubmitButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Quick Note has been added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));


	        //Search QuickNote
	        myClientsPage.scroll("2000", "-1000");
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getBackButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getAddQuickNotePage().getBackButton().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSearchInput()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().inputSearch("QuickNote"+currentTimeInMillis);
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSubmitButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSubmitButton().click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditSearchedNoteLink()));


	        //Edit QuickNote
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditSearchedNoteLink().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditQuickNotePage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditQuickNotePage().getTitle()));
	        webdriver.switchTo().frame("body_area_ifr");//switching the frame by ID
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditQuickNotePage().inputMessage("Sample Message"+currentTimeInMillis);
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditQuickNotePage().getSubmitButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditQuickNotePage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Quick Note has been updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));


	        //Search Again and Remove QuickNote
	        myClientsPage.scroll("2000", "-1000");
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditQuickNotePage().getBackButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getEditQuickNotePage().getBackButton().click();
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSearchInput()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().inputSearch("QuickNote"+currentTimeInMillis);
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSubmitButton()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getSubmitButton().click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getRemoveSearchedNoteLink()));
	        messageSectionHelper.getSendNewMessagePage().getManageQuickNotesPage().getRemoveSearchedNoteLink().click();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Quick Note has been deleted");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        cleanupClient(dummyClient.getFirstName());
	    }


	    @Then("^verify that admin should be able to view all the conversation with affiliates under 'Affiliates messages' tab$")
	    public void verify_that_admin_should_be_able_to_view_all_the_conversation_with_affiliates_under_affiliates_messages_tab() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	        messageSectionHelper.getMessageSectionNavigationBar().getAffiliateMessagesTab().click();
	        messageSectionHelper.getAffiliateMessagesPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to should be able to search for a client by entering the name$")
	    public void verify_that_admin_should_be_able_to_search_for_a_client_by_entering_the_name() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("client",false, false);
	        searchByType("client");
	        deleteSentMessage(false);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to should be able to search for an affiliate by entering the name$")
	    public void verify_that_admin_should_be_able_to_search_for_an_affiliate_by_entering_the_name() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("affiliate",false, false);
	        searchByType("affiliate");
	        deleteSentMessage(false);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to send a new message to an affiliate")
	    public void verify_that_admin_should_be_able_to_send_a_new_message_to_an_affiliate() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("affiliate",false, false);
	        deleteSentMessage(false);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }



	    @Then("^verify that admin should be able to reply to the affiliate message$")
	    public void verify_that_admin_should_be_able_to_reply_to_the_affiliate_message() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("affiliate",false, false);
	        sendReply(false, false);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to attach files while sending a message reply to affiliate")
	    public void verify_that_admin_should_be_able_to_attach_files_while_sending_a_message_reply_to_affiliate() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("affiliate",false, false);
	        sendReply(true, false);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to select the quick note as a reply to the affiliate message$")
	    public void verify_that_admin_should_be_able_to_select_the_quick_note_as_a_reply_to_the_affiliate_message() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("affiliate", false, false);
	        sendReply(false, true);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to delete the sent message to affiliate")
	    public void verify_that_admin_should_be_able_delete_the_sent_message_to_affiliate() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("affiliate", false, false);
	        deleteSentMessage(false);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to view all the conversation with affiliates under 'Team member messages' tab$")
	    public void verify_that_admin_should_be_able_to_view_all_the_conversation_with_affiliates_under_team_member_messages_tab() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	        messageSectionHelper.getMessageSectionNavigationBar().getTeamMemberMessagesTab().click();
	        messageSectionHelper.getTeamMemberMessagesPage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    private void sendMessageTo(String to, boolean withAttachment, boolean saveAsQuickNote) throws Exception{
	        clientNavigationHelper.clickMessagesTab();
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	        messageSectionHelper.getMessageSectionNavigationBar().getSendNewMessageTab().click();
	        messageSectionHelper.getSendNewMessagePage().isLoaded();
	        if(to.equalsIgnoreCase("client")){
	            messageSectionHelper.getSendNewMessagePage().getToClient().click();
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getClientSelect()));
	            messageSectionHelper.getSendNewMessagePage().selectClient(1);
	        }else if(to.equalsIgnoreCase("affiliate")){
	            messageSectionHelper.getSendNewMessagePage().getToAffiliate().click();
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getAffiliateSelect()));
	            messageSectionHelper.getSendNewMessagePage().selectAffiliate(1);
	        }else if(to.equalsIgnoreCase("teamMember")){
	            messageSectionHelper.getSendNewMessagePage().getToTeamMember().click();
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getTeamMemberSelect()));
	            messageSectionHelper.getSendNewMessagePage().selectTeamMember(1);
	        }

	        long currentTimeInMillis = System.currentTimeMillis();
	        messageSectionHelper.getSendNewMessagePage().inputSubject("Sample Subject"+currentTimeInMillis);
	        webdriver.switchTo().frame("message_area_ifr");//switching the frame by ID
	        messageSectionHelper.getSendNewMessagePage().inputMessage("Sample Message"+currentTimeInMillis);
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        if(withAttachment){
	            String filePath = new File(this.getClass().getResource("/data/new_clients.csv").toURI()).getCanonicalPath();
	            messageSectionHelper.getSendNewMessagePage().getAttachments().sendKeys(filePath);
	        }
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        if(saveAsQuickNote){
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getSaveAsQuoteCheckbox()));
	            messageSectionHelper.getSendNewMessagePage().getSaveAsQuoteCheckbox().click();
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getQuickNoteTitle()));
	            messageSectionHelper.getSendNewMessagePage().inputQuickNoteTitle("QuickNote"+currentTimeInMillis);
	        }
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getSubmitButton()));
	        messageSectionHelper.getSendNewMessagePage().getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Your message was sent");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	    }

//	    private void sendMessageToTeamMember(){
//	        clientNavigationHelper.clickMessagesTab();
//	        messageSectionHelper.getAllMessagesPage().isLoaded();
//	        messageSectionHelper.getMessageSectionNavigationBar().getSendNewMessageTab().click();
//	        messageSectionHelper.getSendNewMessagePage().isLoaded();
//	        messageSectionHelper.getSendNewMessagePage().getToTeamMember().click();
//	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getTeamMemberSelect()));
//	        messageSectionHelper.getSendNewMessagePage().selectTeamMember(1);
//	        long currentTimeInMillis = System.currentTimeMillis();
//	        messageSectionHelper.getSendNewMessagePage().inputSubject("Sample Subject"+currentTimeInMillis);
//	        webdriver.switchTo().frame("message_area_ifr");//switching the frame by ID
//	        messageSectionHelper.getSendNewMessagePage().inputMessage("Sample Message"+currentTimeInMillis);
//	        webdriver.switchTo().defaultContent();//Move out of iframe
//	        myClientsPage.scroll("0", "document.body.scrollHeight");
//	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getSendNewMessagePage().getSubmitButton()));
//	        messageSectionHelper.getSendNewMessagePage().getSubmitButton().click();
//	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Your message was sent");
//	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
//	    }

	    private void searchByType(String userType) throws Exception{

	        if(userType.equalsIgnoreCase("client")){
	            messageSectionHelper.getMessageSectionNavigationBar().getClientMessagesTab().click();
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getClientMessagesPage().getSearchBox()));
	            ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('search_user').removeAttribute('readonly',0);"); // Enables the date box
	            messageSectionHelper.getClientMessagesPage().inputSearch("sample");
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getClientMessagesPage().getSearchResult()));
	        }
	        if(userType.equalsIgnoreCase("affiliate")){
	            messageSectionHelper.getMessageSectionNavigationBar().getAffiliateMessagesTab().click();
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getAffiliateMessagesPage().getSearchBox()));
	            ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('search_user').removeAttribute('readonly',0);"); // Enables the date box
	            messageSectionHelper.getAffiliateMessagesPage().inputSearch("sample");
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getAffiliateMessagesPage().getSearchResult()));
	        }


	    }

	    private void sendReply(boolean withAttachment, boolean withQuickNotes) throws Exception{
	        messageSectionHelper.getMessageSectionNavigationBar().getAllMessagesTab().click();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getAllMessagesPage().getFirstItem()));
	        messageSectionHelper.getAllMessagesPage().getFirstItem().click();
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getAllMessagesPage().getReplyForm()));

	        if(withQuickNotes){
	            messageSectionHelper.getAllMessagesPage().selectQuickNotes(1);
	        }
	        long currentTimeInMillis = System.currentTimeMillis();
	        webdriver.switchTo().frame("message_area_ifr");//switching the frame by ID
	        messageSectionHelper.getAllMessagesPage().inputReply("Sample Reply "+currentTimeInMillis);
	        webdriver.switchTo().defaultContent();//Move out of iframe

	        if(withAttachment){
	            String filePath = new File(this.getClass().getResource("/data/new_clients.csv").toURI()).getCanonicalPath();
	            messageSectionHelper.getAllMessagesPage().getReplyAttachments().sendKeys(filePath);
	        }
	        messageSectionHelper.getAllMessagesPage().getReplyButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Your message was sent");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	    }

	    private void deleteSentMessage(boolean includingSingleReply){
	        messageSectionHelper.getMessageSectionNavigationBar().getAllMessagesTab().click();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getAllMessagesPage().getFirstItem()));
	        messageSectionHelper.getAllMessagesPage().getFirstItem().click();
	        wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getAllMessagesPage().getFirstSentItem()));
	        messageSectionHelper.getAllMessagesPage().getRemoveFirstSentItemLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Message deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));

	        if(includingSingleReply){
	            wait.until(ExpectedConditions.visibilityOf(messageSectionHelper.getAllMessagesPage().getFirstSentItem()));
	            messageSectionHelper.getAllMessagesPage().getRemoveFirstSentItemLink().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	            myClientsPage.getWarningPopup().getOkButton().click();
	            wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	            TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Message deleted successfully");
	            wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        }
	    }

	    @Then("^verify that admin should be able to send a new message to a team member$")
	    public void verify_that_admin_should_be_able_to_send_a_new_message_to_a_team_member() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("teamMember",false, false);
	        deleteSentMessage(false);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to reply to the team member message$")
	    public void verify_that_admin_should_be_able_to_reply_to_the_team_member_message() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("teamMember",false, false);
	        sendReply(false, false);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to attach files while sending a message reply$")
	    public void verify_that_admin_should_be_able_to_attach_files_while_sending_a_message_reply() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("teamMember",false, false);
	        sendReply(true, false);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to select the quick note as a reply to the team member message$")
	    public void verify_that_admin_should_be_able_to_select_the_quick_note_as_a_reply_to_the_team_member_message() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("teamMember",false, false);
	        sendReply(false, true);
	        deleteSentMessage(true);//Cleanup to avoid pollution

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to delete the sent message$")
	    public void verify_that_admin_should_be_able_delete_the_sent_message() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        sendMessageTo("teamMember",false, false);
	        deleteSentMessage(false);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    private void addInternalNote(boolean withAttachment) throws Exception{
	        clientNavigationHelper.clickInternalNotesTab();
	        myClientsPage.getInternalNotesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getInternalNotesPage().getPageTitle()));
	        myClientsPage.getInternalNotesPage().getAddNoteButton().click();
	        myClientsPage.getInternalNotesPage().getInternalNotePage().isLoaded();
	        webdriver.switchTo().frame("note_area_ifr");//switching the frame by ID
	        myClientsPage.getInternalNotesPage().getInternalNotePage().inputNotes("Sample Note");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        if(withAttachment){
	            String filePath = new File(this.getClass().getResource("/data/new_clients.csv").toURI()).getCanonicalPath();
	            myClientsPage.getInternalNotesPage().getInternalNotePage().getAttachments().sendKeys(filePath);
	        }
	        myClientsPage.getInternalNotesPage().getInternalNotePage().getSaveNoteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Note added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getInternalNotesPage().isLoaded();

	        //remove the newly added note
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getInternalNotesPage().getRemoveNoteLink()));
	        myClientsPage.getInternalNotesPage().getRemoveNoteLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Note deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getInternalNotesPage().isLoaded();
	    }

	    private void addAndEditInternalNote(boolean withAttachment) throws Exception{
	        clientNavigationHelper.clickInternalNotesTab();
	        myClientsPage.getInternalNotesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getInternalNotesPage().getPageTitle()));
	        myClientsPage.getInternalNotesPage().getAddNoteButton().click();
	        myClientsPage.getInternalNotesPage().getInternalNotePage().isLoaded();
	        webdriver.switchTo().frame("note_area_ifr");//switching the frame by ID
	        myClientsPage.getInternalNotesPage().getInternalNotePage().inputNotes("Sample Note");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        if(withAttachment){
	            String filePath = new File(this.getClass().getResource("/data/new_clients.csv").toURI()).getCanonicalPath();
	            myClientsPage.getInternalNotesPage().getInternalNotePage().getAttachments().sendKeys(filePath);
	        }
	        myClientsPage.getInternalNotesPage().getInternalNotePage().getSaveNoteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Note added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getInternalNotesPage().isLoaded();

	        //Edit the newly added note
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getInternalNotesPage().getEditNoteLink()));
	        myClientsPage.getInternalNotesPage().getEditNoteLink().click();

	        myClientsPage.getInternalNotesPage().getEditInternalNotePage().isLoaded();
	        webdriver.switchTo().frame("note_area_ifr");//switching the frame by ID
	        myClientsPage.getInternalNotesPage().getEditInternalNotePage().inputNotes("Sample Note");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        myClientsPage.scroll("0", "document.body.scrollHeight");

	        myClientsPage.getInternalNotesPage().getEditInternalNotePage().getSaveNoteButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Note updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getInternalNotesPage().isLoaded();

	        //remove the newly added note
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getInternalNotesPage().getRemoveNoteLink()));
	        myClientsPage.getInternalNotesPage().getRemoveNoteLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Note deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getInternalNotesPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to save an internal note for each client$")
	    public void verify_that_admin_should_be_able_save_an_internal_note_for_each_client() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addInternalNote(false);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to edit the internal note added for each client$")
	    public void verify_that_admin_should_be_able_edit_an_internal_note_for_each_client() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addAndEditInternalNote(false);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to attach files with the internal note$")
	    public void verify_that_admin_should_be_able_attach_files_with_the_internal_note() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        addInternalNote(true);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that invoices and payment details of the selected client can be viewed in Invoices page$")
	    public void verify_that_invoices_and_payment_details_of_the_selected_client_can_be_viewed_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        TestAssert.verifyElementContent(myClientsPage.getClientInvoicesHistoryPage().getClientName(), dummyClient.getFirstName());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoTotalOutstanding());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoPastDue());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoPaidInLast30Days());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getInvoicesContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to watch the quick video on how to create new invoice in Invoices page$")
	    public void verify_that_admin_should_be_able_to_watch_the_quick_videos_on_how_to_created_invoice_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getQuickVideoLink()));
	        myClientsPage.getClientInvoicesHistoryPage().getQuickVideoLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getVideoPopupCloseButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getVideoPopupCloseButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to view clients Past/Outstanding/Paid payments$")
	    public void verify_that_admin_should_be_able_to_view_clients_Past_Outstanding_Paid_payments() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        TestAssert.verifyElementContent(myClientsPage.getClientInvoicesHistoryPage().getClientName(), dummyClient.getFirstName());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoTotalOutstanding());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoPastDue());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoPaidInLast30Days());

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to filter only invoices from the invoices and payments list in Invoices page$")
	    public void verify_that_admin_should_be_able_to_filter_only_invoices_from_the_invoices_and_payments_list_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getStatusFilter()));
	        myClientsPage.getClientInvoicesHistoryPage().selectStatus("Invoices");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getInvoicesContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to filter only payments from the invoices and payments list in Invoices page$")
	    public void verify_that_admin_should_be_able_to_filter_only_payments_from_the_invoices_and_payments_list_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getStatusFilter()));
	        myClientsPage.getClientInvoicesHistoryPage().selectStatus("Payments");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getInvoicesContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to filter only pending from the invoices and payments list in Invoices page$")
	    public void verify_that_admin_should_be_able_to_filter_only_pending_from_the_invoices_and_payments_list_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getStatusFilter()));
	        myClientsPage.getClientInvoicesHistoryPage().selectStatus("Pending");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getInvoicesContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to filter only paid from the invoices and payments list in Invoices page$")
	    public void verify_that_admin_should_be_able_to_filter_only_paid_from_the_invoices_and_payments_list_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getStatusFilter()));
	        myClientsPage.getClientInvoicesHistoryPage().selectStatus("Paid");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getInvoicesContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that chargebee warning can be seen while creating a new invoice in Invoices page$")
	    public void verify_that_chargebee_warning_can_be_seen_while_creating_a_new_invoice_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to search the invoices by entering clients name in Invoices page$")
	    public void verify_that_admin_should_be_able_to_serach_the_invoices_by_entering_client_name_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        filterInvoicedClientByName(dummyClient);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to search the invoices by entering clients email address in Invoices page$")
	    public void verify_that_admin_should_be_able_to_serach_the_invoices_by_entering_client_email_address_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        filterInvoicedClient(dummyClient);

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to search the invoices by Invoice date under 'Advanced search' in Invoices page$")
	    public void verify_that_admin_should_be_able_to_serach_the_invoices_by_invoice_date_under_advanced_search_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));

	        filterInvoicedClient(dummyClient);
	        myInvoicesPage.getFirstClientName().click();
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceDate()));

	        String invoiceDate = myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceDate().getText();
	        //logger.info("******************************** invoiceNumber : {}",invoiceNumber);

	        myInvoicesPage.load();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAdvancedSearchLink()));
	        myInvoicesPage.getAdvancedSearchLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getInvoiceFromDate()));

	        ((JavascriptExecutor)webdriver).executeScript ("document.getElementById('invoice_from_date').removeAttribute('readonly',0);"); // Enables the date box
	        myInvoicesPage.getInvoiceFromDate().clear();
	        myInvoicesPage.inputFromDate(invoiceDate);
	        myInvoicesPage.getSearchButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to search the invoices by Invoice number under 'Advanced search' in Invoices page$")
	    public void verify_that_admin_should_be_able_to_serach_the_invoices_by_invoice_number_under_advanced_search_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));

	        filterInvoicedClient(dummyClient);
	        myInvoicesPage.getFirstClientName().click();
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceNumberLink()));

	        String invoiceNumber = myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceNumberLink().getText();
	        //logger.info("******************************** invoiceNumber : {}",invoiceNumber);

	        myInvoicesPage.load();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAdvancedSearchLink()));
	        myInvoicesPage.getAdvancedSearchLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getInvoiceNumber()));
	        myInvoicesPage.inputInvoiceNumber(invoiceNumber);
	        myInvoicesPage.getSearchButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to search the invoices by Invoice reference under 'Advanced search' in Invoices page$")
	    public void verify_that_admin_should_be_able_to_serach_the_invoices_by_invoice_reference_under_advanced_search_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getReference()));
	        myInvoicesPage.getAddInvoicePage().inputReference("111111");
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        myInvoicesPage.load();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAdvancedSearchLink()));
	        myInvoicesPage.getAdvancedSearchLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getInvoiceReferenceNumber()));
	        myInvoicesPage.inputInvoiceReferenceNumber("111111");
	        myInvoicesPage.getSearchButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to search the invoices by Invoice Terms in Days under 'Advanced search' in Invoices page$")
	    public void verify_that_admin_should_be_able_to_serach_the_invoices_by_invoice_terms_in_days_under_advanced_search_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getTermInDays()));
	        myInvoicesPage.getAddInvoicePage().inputTermInDays("30");
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        myInvoicesPage.load();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAdvancedSearchLink()));
	        myInvoicesPage.getAdvancedSearchLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getTermInDays()));
	        myInvoicesPage.inputTermInDays("30");
	        myInvoicesPage.getSearchButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to view the invoice and payment details upon clicking 'Clients name' in Invoices page$")
	    public void verify_that_admin_should_be_able_to_view_the_invoice_and_payment_details_upon_clicking_clients_name_in_invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));

	        filterInvoicedClient(dummyClient);
	        myInvoicesPage.getFirstClientName().click();
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();

	        TestAssert.verifyElementContent(myClientsPage.getClientInvoicesHistoryPage().getClientName(), dummyClient.getFirstName());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoTotalOutstanding());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoPastDue());
	        TestAssert.verifyElementVisible(myClientsPage.getClientInvoicesHistoryPage().getPaymentInfoPaidInLast30Days());
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getInvoicesContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that invoice can be created by selecting saved invoice items in Invoices page$")
	    public void verify_that_invoice_can_be_created_by_selecting_saved_invoice_items_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        loadAddInvoicePageForSpecifiedClient(dummyClient);
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemButton()));
	        myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getFirstSavedItemCheckBox()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getAddButton()));
	        myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getFirstSavedItemCheckBox().click();
	        myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getAddButton().click();
	        myClientsPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getDeleteBlankItemLink()));//Remove the default blank item
	        myInvoicesPage.getAddInvoicePage().getDeleteBlankItemLink().click();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        cleanupAddedInvoiceItem();
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        myInvoicesPage.isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that invoice can be created by adding new invoice item in Invoices page$")
	    public void verify_that_invoice_can_be_created_by_adding_new_invoice_item_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
//	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Invoice created successfully");
//	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        loadAddInvoicePageForSpecifiedClient(dummyClient);
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        cleanupAddedInvoiceItem();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to set billing reminders for all the clients listed in Invoices page$")
	    public void verify_that_admin_should_be_able_to_set_billing_reminders_for_all_the_clients_listed_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));

	        filterInvoicedClient(dummyClient);
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceReminderLink()));
	        myInvoicesPage.getFirstClientInvoiceReminderLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getBillingRemindersPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getBillingRemindersPopup().getTaskSubject()));

	        myInvoicesPage.getBillingRemindersPopup().setTaskSubject("BillingReminder1");
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getBillingRemindersPopup().getSaveButton()));
	        myInvoicesPage.getBillingRemindersPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Task added successfully.");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        cleanupClient(dummyClient.getFirstName());
	    }

	    private void filterInvoicedClient(DummyClient dummyClient){
	        myInvoicesPage.isLoaded();
	        myInvoicesPage.inputClientNameOrEmail(dummyClient.getEmail());
	        myInvoicesPage.getSearchButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getSearchResultContainerHeader()));
	        verifyPageCount();
	    }

	    private void filterInvoicedClientByName(DummyClient dummyClient){
	        myInvoicesPage.isLoaded();
	        myInvoicesPage.inputClientNameOrEmail(dummyClient.getFirstName());
	        myInvoicesPage.getSearchButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getSearchResultContainerHeader()));
	        verifyPageCount();
	    }

	    private void loadAddInvoicePageForSpecifiedClient(DummyClient dummyClient){
	        filterInvoicedClient(dummyClient);
	        try{
	            myInvoicesPage.getFirstClientName().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            myInvoicesPage.getFirstClientName().click();
	        }
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	    }

	    private void cleanupAddedInvoiceItem(){
	        //Cleanup the saved item which otherwise will create issues further
	        myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getFirstSavedItemCheckBox()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getFirstSavedItemDeleteLink()));
	        myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getFirstSavedItemDeleteLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getWarningPopup().getWarningMessage()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Saved invoice item deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myInvoicesPage.getAddInvoicePage().getAddSavedInvoiceItemsPopup().getClosePopupLink().click();
	    }

	    @Then("^verify that invoice status can be set from pending to received in Invoices page$")
	    public void verify_that_invoice_status_can_be_set_from_pending_to_received_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        filterInvoicedClient(dummyClient);
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceRecordPaymentLink()));
	        myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceRecordPaymentLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getMarkPaymentReceivedPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getMarkPaymentReceivedPopup().getAddPaymentButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getMarkPaymentReceivedPopup().getAddPaymentButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getStatusFilter()));
	        myClientsPage.getClientInvoicesHistoryPage().selectStatus("Invoices");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        //wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getInvoicesContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceStatusLabel()));
	        TestAssert.verifyElementContent(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceStatusLabel(), "Paid");

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to edit the invoice by clicking on 'More Actions' in Invoices page$")
	    public void verify_that_admin_should_be_able_to_edit_the_invoice_by_clicking_on_more_actions_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        filterInvoicedClient(dummyClient);
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceMoreActionsLink()));
	        myClientsPage.getClientInvoicesHistoryPage().getFirstInvoiceMoreActionsLink().click();
	        myClientsPage.getClientInvoicesHistoryPage().getEditInvoicePage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getEditInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getEditInvoicePage().getPaymentDueTerm()));
	        myClientsPage.getClientInvoicesHistoryPage().getEditInvoicePage().inputPaymentDueTerm("20");
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getEditInvoicePage().getSaveInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getEditInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(myClientsPage.getFlashMessage().getMessage(), "Invoice updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getFlashMessage().getMessage()));
	        myClientsPage.getClientInvoicesHistoryPage().getEditInvoicePage().isLoaded();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to preview the invoice by clicking on 'Preview' in Invoices page$")
	    public void verify_that_admin_should_be_able_to_preview_the_invoice_by_clicking_on_Preview_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        filterInvoicedClient(dummyClient);
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoicePreviewLink()));
	        myClientsPage.getClientInvoicesHistoryPage().getFirstInvoicePreviewLink().click();
	        myInvoicesPage.getPreviewInvoicePage().isLoaded();
	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to print the invoice in Invoices page$")
	    public void verify_that_admin_should_be_able_to_print_the_invoice_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        filterInvoicedClient(dummyClient);
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoicePreviewLink()));
	        myClientsPage.getClientInvoicesHistoryPage().getFirstInvoicePreviewLink().click();
	        myInvoicesPage.getPreviewInvoicePage().isLoaded();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getPreviewInvoicePage().getPrintInvoiceButton()));
//	        ((JavascriptExecutor)webdriver).executeScript("window.print=function(){};");//Disable the print popup
//	        myInvoicesPage.getPreviewInvoicePage().getPrintInvoiceButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that admin should be able to export the invoice in PDF format in Invoices page$")
	    public void verify_that_admin_should_be_able_to_export_the_invoice_in_PDF_format_in_Invoices_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickInvoicesTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton()));
	        myClientsPage.getClientInvoicesHistoryPage().getCreateInvoiceButton().click();
	        myInvoicesPage.getAddInvoicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getAddInvoicePage().getChargebeeWarning()));
	        myInvoicesPage.getAddInvoicePage().inputItemDescription("Item1");
	        myInvoicesPage.getAddInvoicePage().getSaveForFutureCheckbox().click();
	        myInvoicesPage.getAddInvoicePage().inputItemPrice("100");
	        myInvoicesPage.getAddInvoicePage().getSaveInvoiceButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(myClientsPage.getAjaxLoader()));
	        filterInvoicedClient(dummyClient);
	        try{
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }catch(org.openqa.selenium.StaleElementReferenceException ex){
	            wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getFirstClientInvoiceStatusLink()));
	            myInvoicesPage.getFirstClientInvoiceStatusLink().click();
	        }
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getClientInvoicesHistoryPage().getFirstInvoicePreviewLink()));
	        myClientsPage.getClientInvoicesHistoryPage().getFirstInvoicePreviewLink().click();
	        myInvoicesPage.getPreviewInvoicePage().isLoaded();
	        myClientsPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myInvoicesPage.getPreviewInvoicePage().getExportInvoiceButton()));
	        myInvoicesPage.getPreviewInvoicePage().getExportInvoiceButton().click();//It streams the PDF in local machine
	        myInvoicesPage.getPreviewInvoicePage().isLoaded();
	        webdriver.navigate().refresh();

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that Credit Repair Activity Report can be viewed in Activity page$")
	    public void verify_that_credit_repair_activity_report_can_be_viewed_in_activity_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickActivityTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getDisputeDataContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getCreditScoreDataContainer()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getInvoiceDataContainer()));

	        cleanupClient(dummyClient.getFirstName());
	    }

	    @Then("^verify that Credit Repair Activity Report can be printed in Activity page$")
	    public void verify_that_credit_repair_activity_report_can_be_printed_in_activity_page() throws Exception {
	        DummyClient dummyClient = getDummyClient("Client");
	        addNewClient(dummyClient, false);
	        loadClientDashboardForNewlyAddedClient(dummyClient);

	        clientNavigationHelper.clickActivityTab();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getPrintButton()));
	        myClientsPage.getActivityPage().getPrintButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getPrintActivityPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(myClientsPage.getActivityPage().getPrintActivityPopup().getPrintButton()));
	        myClientsPage.getActivityPage().getPrintActivityPopup().getOkButton().click();

	        cleanupClient(dummyClient.getFirstName());
	    }
	}




