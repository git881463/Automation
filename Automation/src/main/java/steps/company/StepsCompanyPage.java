package steps.company;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.io.File;
	import java.util.List;

	/**
	 * Steps for My Company Page.
	 * Look at the feature file for more detail
	 */
	public class StepsCompanyPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsCompanyPage.class);

	    private class DummyMember{

	        private String firstName;
	        private String lastName;
	        private String email;
	        private String role;
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

	        public String getRole() {
	            return role;
	        }

	        public void setRole(String role) {
	            this.role = role;
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

	    private DummyMember getDummyMember(String role){
	        DummyMember dummyMember = new DummyMember();
	        long currentTimeInMillis = System.currentTimeMillis();
	        dummyMember.setFirstName("fname"+currentTimeInMillis);
	        dummyMember.setLastName("lname"+currentTimeInMillis);
	        dummyMember.setEmail("fname"+currentTimeInMillis+"@gmail.com");
	        dummyMember.setRole(role);
	        return dummyMember;
	    }

	    @Given("^Admin is on my company page$")
	    public void adminIsOnTheCompanyPage() {
	        companyPage.load();
	    }

	    @Then("^verify that company profile can be edited in My Company page$")
	    public void verify_that_company_profile_can_be_edited_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getCompanyWebsiteUrl()));
	        companyPage.inputWebsiteUrl("http://abc.com");
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Your company profile updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        companyPage.isLoaded();

	    }

	    @Then("^verify that admin should be able to watch the quick video in My Company Profile page$")
	    public void verify_that_admin_should_be_able_to_watch_the_quick_video_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getQuickVideoLink()));
	        companyPage.getMyCompanyProfilePage().getQuickVideoLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getVideoPopup()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getVideoPopupCloseButton()));
	        companyPage.getMyCompanyProfilePage().getVideoPopupCloseButton().click();
	    }

	    @Then("^verify that admin should be able to navigate to 'My Account' page from My Company Profile page$")
	    public void verify_that_admin_should_be_able_to_navigate_to_my_account_page_from_my_company_profile_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getMyAccountLink()));
	        companyPage.getMyCompanyProfilePage().getMyAccountLink().click();
	        myAccountPage.isLoaded();
	    }

	    @Then("^verify that admin should be able to check URL functionality in My Company Profile page$")
	    public void verify_that_admin_should_be_able_to_check_url_functionality_in_my_company_profile_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getWebsiteUrl()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getCheckUrlLink()));
	        companyPage.getMyCompanyProfilePage().inputWebsiteUrl(baseurl);
	        companyPage.getMyCompanyProfilePage().getCheckUrlLink().click();
	        homePage.isLoadedInTab();
	    }

	    @Then("^verify that admin should be able to view guided tours in My Company Profile page$")
	    public void verify_that_admin_should_be_able_to_view_guided_tours_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyCompanyProfilePage().getGuidedTourLink()));
	        companyPage.getMyCompanyProfilePage().getGuidedTourLink().click();
	        TestAssert.verifyEqual(companyPage.isTooltipShown(), true);
	        companyPage.getCloseTooltipLink().click();
	    }

	    @Then("^verify that team member can be added in My Company page$")
	    public void verify_that_team_member_can_be_added_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getMyTeamMembersLink().click();
	        companyPage.getMyTeamMembersPage().isLoaded();
	        if(companyPage.getMyTeamMembersPage().isTooltipShown()){
	            companyPage.getMyTeamMembersPage().getCloseTooltipLink().click();
	        }
	        companyPage.getMyTeamMembersPage().getAddNewTeamMemberButton().click();
	        companyPage.getMyTeamMembersPage().getAddTeamMemberPage().isLoaded();
	        //Add a team member
	        DummyMember dummyMember = getDummyMember("Admin");
	        companyPage.getMyTeamMembersPage().getAddTeamMemberPage().inputFirstName(dummyMember.getFirstName());
	        companyPage.getMyTeamMembersPage().getAddTeamMemberPage().inputLastName(dummyMember.getLastName());
	        companyPage.getMyTeamMembersPage().getAddTeamMemberPage().inputEmail(dummyMember.getEmail());
	        companyPage.getMyTeamMembersPage().getAddTeamMemberPage().selectRole(dummyMember.getRole());
	        companyPage.getMyTeamMembersPage().getAddTeamMemberPage().inputPassword("password");
	        companyPage.getMyTeamMembersPage().getAddTeamMemberPage().getSubmitButton().click();
	        companyPage.getMyTeamMembersPage().isLoaded();
	        if(companyPage.getMyTeamMembersPage().isTooltipShown()){
	            companyPage.getMyTeamMembersPage().getCloseTooltipLink().click();
	        }
	        //Verify the add operation
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyTeamMembersPage().getTeamMembersListContainer()));
	        //Now delete this newly added team member to keep env clean
	        companyPage.getMyTeamMembersPage().deleteNewlyAddedTeamMember();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyTeamMembersPage().getInactivateOrDeleteMemberPopup().getPageTitle()));
	        companyPage.getMyTeamMembersPage().getInactivateOrDeleteMemberPopup().getDeleteTeamMemberButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Team Member Deleted.");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        //Also handle this extra add-on popup
	        /* Apparently it is not showing all the time.
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyTeamMembersPage().getRemoveExtraUserAddonPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyTeamMembersPage().getRemoveExtraUserAddonPopup().getRemoveAddOnButton()));
	        companyPage.getMyTeamMembersPage().getRemoveExtraUserAddonPopup().getRemoveAddOnButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Add-on removed successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        */
	        companyPage.getMyTeamMembersPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to 'Disable team chat' in My Company page$")
	    public void verify_that_admin_should_be_able_to_disable_team_chat_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getMyTeamMembersLink().click();
	        companyPage.getMyTeamMembersPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMyTeamMembersPage().getChatButton()));
	        companyPage.getMyTeamMembersPage().getChatButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
//	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Team chat");
//	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        companyPage.getMyTeamMembersPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to view the permission granted for the 3 default user roles in My Company page$")
	    public void verify_that_admin_should_be_able_to_view_the_permission_granted_for_the_3_default_user_roles_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getRolesAndPermissionsLink().click();
	        companyPage.getRolesAndPermissionsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getViewPermissonLink1()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getViewPermissonLink2()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getViewPermissonLink3()));
	        companyPage.getRolesAndPermissionsPage().getViewPermissonLink1().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getEditPermissionHeader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getEditBackButton()));
	        companyPage.getRolesAndPermissionsPage().getEditBackButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getViewPermissonLink2()));
	        companyPage.getRolesAndPermissionsPage().getViewPermissonLink2().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getEditPermissionHeader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getEditBackButton()));
	        companyPage.getRolesAndPermissionsPage().getEditBackButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getViewPermissonLink3()));
	        companyPage.getRolesAndPermissionsPage().getViewPermissonLink3().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getEditPermissionHeader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getEditBackButton()));
	        companyPage.getRolesAndPermissionsPage().getEditBackButton().click();
	        companyPage.getRolesAndPermissionsPage().isLoaded();
	    }

	    private void loadRolesAndPersmissionsPage(){
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getRolesAndPermissionsLink().click();
	        companyPage.getRolesAndPermissionsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getAddRoleButton()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getRoleTable()));
	    }

	    private void addRole(String role){
	        loadRolesAndPersmissionsPage();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getAddRoleButton()));
	        companyPage.getRolesAndPermissionsPage().inputRoleName(role);
	        companyPage.getRolesAndPermissionsPage().getAddRoleButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Role added.");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    private WebElement findMatchingRole(String role){
	        WebElement roleTable = companyPage.getRolesAndPermissionsPage().getRoleTable();
	        List<WebElement> tableRows = roleTable.findElements(By.tagName("tr"));
	        WebElement matchingElement = null;
	        for(WebElement element: tableRows){
	            if(element.getText().toLowerCase().contains(role.toLowerCase())){
	                matchingElement =  element;
	                break;
	            }
	        }
	        List<WebElement> tds = matchingElement.findElements(By.tagName("td"));
	        WebElement secondTD = tds.get(1);
	        return secondTD;
	    }

	    private void editRole(String role){
	        loadRolesAndPersmissionsPage();
	        WebElement element = findMatchingRole(role);
	        List<WebElement> links = element.findElements(By.tagName("a"));
	        WebElement e = links.get(0);
	        e.click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getEditPermissionHeader()));
	        companyPage.getRolesAndPermissionsPage().getEditBackButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getRolesAndPermissionsPage().getAddRoleButton()));
	    }

	    private void deleteRole(String role){
	        loadRolesAndPersmissionsPage();
	        WebElement element = findMatchingRole(role);
	        List<WebElement> links = element.findElements(By.tagName("a"));
	        WebElement e = links.get(1);
	        e.click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	        companyPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Role deleted.");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that roles can be created edited deleted in My Company page$")
	    public void verify_that_new_roles_can_be_created_edited_deleted_in_my_company_page() throws Exception {
	        long currentTimeInMillis = System.currentTimeMillis();
	        String role = "Role"+currentTimeInMillis;
	        addRole(role);
	        editRole(role);
	        deleteRole(role);
	    }

	    @Then("^verify that admin should be able to edit credit monitoring service clients sign-up link in My Company page$")
	    public void verify_that_admin_should_be_able_to_edit_credit_monitoring_service_client_signup_link_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getCreditMonitoringServiceLink().click();
	        companyPage.getCreditMonitoringServicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getCreditMonitoringServicePage().getEditSignupButton()));
	        companyPage.getCreditMonitoringServicePage().getEditSignupButton().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getCreditMonitoringServicePage().getCreditMonitoringProviderSettingPopup().getCancelButton()));
	        companyPage.getCreditMonitoringServicePage().getCreditMonitoringProviderSettingPopup().inputLLink("dummylink");
	        companyPage.getCreditMonitoringServicePage().getCreditMonitoringProviderSettingPopup().getCancelButton().click();
	    }

	    @Then("^verify that admin should be able to request affiliate program information in My Company page$")
	    public void verify_that_admin_should_be_able_to_request_affiliate_program_information_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getCreditMonitoringServiceLink().click();
	        companyPage.getCreditMonitoringServicePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getCreditMonitoringServicePage().getLearnIdentityIQButton()));
	        companyPage.getCreditMonitoringServicePage().getLearnIdentityIQButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getCreditMonitoringServicePage().getLearnToBecomeAffiliatePopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getCreditMonitoringServicePage().getLearnToBecomeAffiliatePopup().getClosePopupLink()));
	        companyPage.getCreditMonitoringServicePage().getLearnToBecomeAffiliatePopup().getClosePopupLink().click();
	        companyPage.getCreditMonitoringServicePage().isLoaded();
	    }

	    @Then("^verify that admin should be able to set my company logo which will be displayed in 'Client/Affiliate' portal$")
	    public void verify_that_admin_should_be_able_to_set_my_company_logo_which_will_be_displayed() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getMyLogoTab()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageMyLogoSection().getChangeLogoLink()));

	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageMyLogoSection().getChangeLogoLink().click();

	        //String filePath = new File(this.getClass().getResource("/data/sample_agreement.docx").toURI()).getCanonicalPath();//Use logo file instead.
	        //companyPage.getClientAffiliatePortalPage().getFilePickerLink().sendKeys(filePath);
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	    }

	    @Then("^verify that client portal can be previewed in My Company page$")
	    public void verify_that_client_portal_can_be_previewed_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getViewMyClientPortalButton()));
	        companyPage.getClientAffiliatePortalPage().getViewMyClientPortalButton().click();
	        companyPage.getClientAffiliatePortalPage().secureAppLoadedInTab();
	    }

	    @Then("^verify that affiliate portal can be previewed in My Company page$")
	    public void verify_that_affiliate_portal_can_be_previewed_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getViewMyAffiliatePortalButton()));
	        companyPage.getClientAffiliatePortalPage().getViewMyAffiliatePortalButton().click();
	        companyPage.getClientAffiliatePortalPage().secureAppLoadedInTab();
	    }

	    @Then("^verify that admin should be able to select the useful details to be displayed in Client and Affiliate profile in My Company page$")
	    public void verify_that_admin_should_be_able_to_select_the_useful_details_to_be_displayed_in_Client_and_Affiliate_profile_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getDetailsTab()));
	        companyPage.getClientAffiliatePortalPage().getDetailsTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageDetailsSection().getDetailsContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageDetailsSection().getShowLetterOption()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageDetailsSection().getShowAgreementOption()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageDetailsSection().getShowDisputeDetailOption()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageDetailsSection().getShowClientSummaryOption()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageDetailsSection().getShowLetterOption().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        //Toggle the change
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageDetailsSection().getShowLetterOption().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to show useful resource in client portal$")
	    public void verify_that_admin_should_be_able_to_show_useful_resource_in_client_portal_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getClientAffiliatePortalPage().getResourcesTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getResourcesContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getShowResourcesRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getShowResourcesRadio().click();

	        if(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().isResourcePageHidden()){
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	            TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	            wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        }
	    }

	    @Then("^verify that admin should be able to hide useful resource in client portal$")
	    public void verify_that_admin_should_be_able_to_hide_useful_resource_in_client_portal_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getClientAffiliatePortalPage().getResourcesTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getResourcesContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getHideResourcesRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getHideResourcesRadio().click();

	        if(!companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().isResourcePageHidden()){
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	            TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	            wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        }
	    }

	    @Then("^verify that admin should be able to modify useful resource in client portal$")
	    public void verify_that_admin_should_be_able_to_modify_useful_resource_in_client_portal_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getClientAffiliatePortalPage().getResourcesTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getResourcesContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getModifyResourcesLink()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getModifyResourcesLink().click();
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getClientResourcesPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to reset the useful resource settings to default setting in client portal$")
	    public void verify_that_admin_should_be_able_to_reset_the_useful_resource_settings_to_default_setting_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getClientAffiliatePortalPage().getResourcesTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getResourcesContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getResetResourcesToDefaultLink()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageResourcesSection().getResetResourcesToDefaultLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Resources has been reset");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that credit info setting can be set to show in My Company page$")
	    public void verify_that_credit_info_setting_can_be_set_to_show_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getPageTitle()));
	        companyPage.getClientAffiliatePortalPage().getCreditInfoTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getCreditInfoContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getShowCreditInfoRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getShowCreditInfoRadio().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	    }

	    @Then("^verify that credit info setting can be set to hide in My Company page$")
	    public void verify_that_credit_info_setting_can_be_set_to_hide_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getPageTitle()));
	        companyPage.getClientAffiliatePortalPage().getCreditInfoTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getCreditInfoContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getHideCreditInfoRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getHideCreditInfoRadio().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to modify credit info in client portal in My Company page$")
	    public void verify_that_admin_should_be_able_to_modify_credit_info_in_client_portal_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getPageTitle()));
	        companyPage.getClientAffiliatePortalPage().getCreditInfoTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getCreditInfoContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getModifyCreditInfoLink()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getModifyCreditInfoLink().click();
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getEditCreditInfoPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to reset the credit info settings to default settings in client portal in My Company page$")
	    public void verify_that_admin_should_be_able_to_reset_the_credit_info_settings_to_default_settings_in_in_client_portal_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getPageTitle()));
	        companyPage.getClientAffiliatePortalPage().getCreditInfoTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getCreditInfoContainer()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getResetCreditInfoToDefaultLink()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageCreditInfoSection().getResetCreditInfoToDefaultLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Credit Info Page has been reset");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to turn ON Clients choice in client portal$")
	    public void verify_that_admin_should_be_able_to_turn_ON_clients_choice_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientChoiceTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageClientsChoiceSection().getClientChoiceOnRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageClientsChoiceSection().getClientChoiceOnRadio().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client's Choice is turned ON");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to turn OFF Clients choice in client portal$")
	    public void verify_that_admin_should_be_able_to_turn_OFF_clients_choice_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientChoiceTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageClientsChoiceSection().getClientChoiceOffRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageClientsChoiceSection().getClientChoiceOffRadio().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client's Choice is turned OFF");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to edit the Client/Affiliate portal theme color in My Company page$")
	    public void verify_that_admin_should_be_able_to_edit_the_portal_theme_color_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getPortalThemeTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPagePortalThemeSection().getPortalThemeColor()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPagePortalThemeSection().inputColor("#0558b8");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }


	    @Then("^verify that admin should be able to reset the Client/Affiliate theme color to default in My Company page$")
	    public void verify_that_admin_should_be_able_to_reset_the_portal_theme_color_to_default_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getPortalThemeTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPagePortalThemeSection().getResetPortalThemeToDefaultLink()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPagePortalThemeSection().getResetPortalThemeToDefaultLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to turn ON Clients Onboarding in client portal$")
	    public void verify_that_admin_should_be_able_to_turn_ON_clients_onboarding_in_client_portal() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientOnboardingTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientOnboardingOnRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientOnboardingOnRadio().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to turn OFF Clients Onboarding in client portal$")
	    public void verify_that_admin_should_be_able_to_turn_OFF_clients_onboarding_in_client_portal() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientOnboardingTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientOnboardingOffRadio()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientOnboardingOffRadio().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Client/Affiliate Portal options updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to rearrange the 6 default tasks in client portal$")
	    public void verify_that_admin_should_be_able_to_rearrange_the_6_default_tasks_in_client_portal_in_client_portal() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientOnboardingTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton()));
	        companyPage.getClientAffiliatePortalPage().scroll("2000","50");
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getResetTaskLink()));
	        Thread.sleep(5000);
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().shuffleTasks();
	        Thread.sleep(5000);
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getClosePopupLink().click();

	    }

	    @Then("^verify that admin should be able to delete the 6 default tasks in client portal$")
	    public void verify_that_admin_should_be_able_to_delete_the_6_default_tasks_in_client_portal() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientOnboardingTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton()));
	        companyPage.getClientAffiliatePortalPage().scroll("2000","50");
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getResetTaskLink()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask1Button()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask1Button().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task removed from onboarding list successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask2Button()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask2Button().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task removed from onboarding list successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask3Button()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask3Button().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task removed from onboarding list successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask4Button()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask4Button().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task removed from onboarding list successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask5Button()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask5Button().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task removed from onboarding list successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask6Button()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getDeleteTask6Button().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task removed from onboarding list successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getResetTaskLink()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getResetTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task order reset successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	    }

	    @Then("^verify that admin should be able to reset onboarding tasks to default tasks and order in client portal$")
	    public void verify_that_admin_should_be_able_to_reset_onboarding_tasks_to_default_tasks_and_order_in_client_portal() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientOnboardingTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getResetTaskLink()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getClientTaskForOnboardingPopup().getResetTaskLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task order reset successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to preview client onboarding tasks in client portal$")
	    public void verify_that_admin_should_be_able_to_preview_client_onboarding_tasks_in_client_portal() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientOnboardingTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton()));
	        companyPage.getClientAffiliatePortalPage().scroll("2000","document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getPreviewButton1()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getPreviewButton1().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getPreviewOfTaskPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getPreviewOfTaskPopup().getCloseButton()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getPreviewOfTaskPopup().getCloseButton().click();
	    }


	    @Then("^verify that admin should be able to edit client onboarding tasks in client portal$")
	    public void verify_that_admin_should_be_able_to_edit_client_onboarding_tasks_in_client_portal() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAffiliatePortalLink().click();
	        companyPage.getClientAffiliatePortalPage().isLoaded();
	        companyPage.getClientAffiliatePortalPage().getClientOnboardingTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditDefaultTasksButton()));
	        companyPage.getClientAffiliatePortalPage().scroll("2000","document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditButton1()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditButton1().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditTaskPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditTaskPopup().getTaskTitle()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditTaskPopup().inputTaskTitle("Welcome to your Client Portal");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditTaskPopup().getSaveButton()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditTaskPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Task updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditTaskPopup().getCancelButton()));
	        companyPage.getClientAffiliatePortalPage().getClientAffiliatePortalPageOnboardingAndTasksSection().getEditTaskPopup().getCancelButton().click();
	    }

	    @Then("^verify that admin should be able to edit web lead form in website tools$")
	    public void verify_that_admin_should_be_able_to_edit_web_lead_form_in_website_tools() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getWebsiteToolsLink().click();
	        companyPage.getWebsiteToolsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getWebLeadFormTab()));
	        companyPage.getWebsiteToolsPage().getWebLeadFormTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getLanguageEn()));
	        companyPage.getWebsiteToolsPage().getLanguageEn().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getSaveWebLeadFormButton()));
	        companyPage.getWebsiteToolsPage().getSaveWebLeadFormButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "web lead form updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to preview web lead form in website tools$")
	    public void verify_that_admin_should_be_able_to_preview_web_lead_form_in_website_tools() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getWebsiteToolsLink().click();
	        companyPage.getWebsiteToolsPage().isLoaded();
	        companyPage.getWebsiteToolsPage().getWebLeadFormTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getLanguageEn()));
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getPreviewWebLeadFormButton()));
	        companyPage.getWebsiteToolsPage().getPreviewWebLeadFormButton().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getPreviewPopupHeader()));
	        companyPage.getWebsiteToolsPage().getClosePreviewPopupLink().click();
	    }

	    @Then("^verify that admin should be able to copy the web lead form code in website tools$")
	    public void verify_that_admin_should_be_able_to_copy_the_web_lead_form_code_in_website_tools() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getWebsiteToolsLink().click();
	        companyPage.getWebsiteToolsPage().isLoaded();
	        companyPage.getWebsiteToolsPage().getWebLeadFormTab().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getLanguageEn()));
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWebsiteToolsPage().getCopyWebLeadFormButton()));
	        companyPage.getWebsiteToolsPage().getCopyWebLeadFormButton().click();
	        companyPage.getWebsiteToolsPage().isLoaded();
	    }

	    @Then("^verify that new simple audit template can be added in My Company page$")
	    public void verify_that_new_simple_audit_template_can_be_added_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getSimpleAuditLink().click();
	        companyPage.getSimpleAuditTemplate().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getAddTemplateButton()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        companyPage.getSimpleAuditTemplate().getAddTemplateButton().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getAddAuditTemplate().getPageTitle()));

	        //Add Template
	        long currentTimeInMillis = System.currentTimeMillis();
	        companyPage.getSimpleAuditTemplate().getAddAuditTemplate().inputAuditName("Audit"+currentTimeInMillis);
	        webdriver.switchTo().frame("agreement_txt_ifr");//switching the frame by ID
	        companyPage.getSimpleAuditTemplate().getAddAuditTemplate().inputLDetails("Sample Template");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getAddAuditTemplate().getSaveTemplateButton()));
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        companyPage.getSimpleAuditTemplate().getAddAuditTemplate().getSaveTemplateButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));

//	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Template loaded successfully");
//	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        //wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        //companyPage.getSimpleAuditTemplate().isLoaded();

	        //Now remove the template
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getRemoveTemplateLink()));
	        companyPage.getSimpleAuditTemplate().getRemoveTemplateLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	        companyPage.getWarningPopup().getOkButton().click();
	    }

	    @Then("^verify that admin should be able to change the Company logo just for simple audit report in My Company page$")
	    public void verify_that_admin_should_be_able_to_change_the_company_logo_for_simple_audit_report_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getSimpleAuditLink().click();
	        companyPage.getSimpleAuditTemplate().isLoaded();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getPageTitle()));
	        companyPage.scroll("0", "document.body.scrollHeight");
	        if(companyPage.getSimpleAuditTemplate().isLogoChangePossible()){
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getChagneLogoLink()));
	            companyPage.getSimpleAuditTemplate().getChagneLogoLink().click();
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getFilePickerLink()));
	            String filePath = new File(this.getClass().getResource("/data/default_company_logo.png").toURI()).getCanonicalPath();//Use logo file instead.
	            companyPage.getSimpleAuditTemplate().getFilePickerLink().sendKeys(filePath);
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	            TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Logo added successfully");
	            wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        }
	        companyPage.getSimpleAuditTemplate().isLoaded();
	    }

	    @Then("^verify that admin should be able to preview the Simple audit template in My Company page$")
	    public void verify_that_admin_should_be_able_to_preview_the_simple_audit_template_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getSimpleAuditLink().click();
	        companyPage.getSimpleAuditTemplate().isLoaded();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getAddTemplateButton()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getPreviewTemplateLink()));
	        companyPage.getSimpleAuditTemplate().getPreviewTemplateLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAjaxLoader()));
	        //Backend error needs to be solved first.
	    }

	    @Then("^verify that admin should be able to edit the Simple audit template in My Company page$")
	    public void verify_that_admin_should_be_able_to_edit_the_simple_audit_template_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getSimpleAuditLink().click();
	        companyPage.getSimpleAuditTemplate().isLoaded();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getAddTemplateButton()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getEditTemplateLink()));
	        companyPage.getSimpleAuditTemplate().getEditTemplateLink().click();
	        companyPage.getEditAuditTemplatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getEditAuditTemplatePage().getPageTitle()));
	        //Edit Template
	        long currentTimeInMillis = System.currentTimeMillis();
	        webdriver.switchTo().frame("agreement_txt_ifr");//switching the frame by ID
	        companyPage.getEditAuditTemplatePage().inputDetails("Sample Audit Template"+currentTimeInMillis);
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getEditAuditTemplatePage().getSaveTemplateButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	    }

	    @Then("^verify that admin should be able to select preference on online agreement in My Company page$")
	    public void verify_that_admin_should_be_able_to_select_preference_on_online_agreement_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAgreementLink().click();
	        companyPage.getClientAgreementPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getPreferenceDifferentAgreement()));
	        companyPage.getClientAgreementPage().getPreferenceDifferentAgreement().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Agreement option updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        companyPage.getClientAgreementPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to delete the added audit template in My Company page$")
	    public void verify_that_admin_should_be_able_to_delete_the_added_audit_template_in_my_company_page() throws Exception {
	        if (companyPage.isTooltipShown()) {
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getSimpleAuditLink().click();
	        companyPage.getSimpleAuditTemplate().isLoaded();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getAddTemplateButton()));

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getSimpleAuditTemplate().getEditTemplateLink()));
	        companyPage.getSimpleAuditTemplate().getEditTemplateLink().click();
	        companyPage.getEditAuditTemplatePage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getEditAuditTemplatePage().getPageTitle()));
	        //Edit Template
	        long currentTimeInMillis = System.currentTimeMillis();
	        webdriver.switchTo().frame("agreement_txt_ifr");//switching the frame by ID
	        companyPage.getEditAuditTemplatePage().inputDetails("Sample Audit Template"+currentTimeInMillis);
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getEditAuditTemplatePage().getSaveTemplateButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));

	        companyPage.getSimpleAuditTemplate().isLoaded();

	    }

	    @Then("^verify that new client agreement can be added in My Company page$")
	    public void verify_that_new_client_agreement_can_be_added_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAgreementLink().click();
	        companyPage.getClientAgreementPage().isLoaded();
	        companyPage.scroll("0", "document.body.scrollHeight");
	        if(companyPage.getClientAgreementPage().isTooltipShown()){
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getCloseTooltipLink()));
	            companyPage.getClientAgreementPage().getCloseTooltipLink().click();
	            //wait.until(ExpectedConditions.invisibilityOf(companyPage.getClientAgreementPage().getCloseTooltipLink()));

	        }
	        companyPage.scroll("2000", "-3000");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getAddNewAgreementButton()));
	        companyPage.getClientAgreementPage().getAddNewAgreementButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getAddAgreementPage().getPageTitle()));
	        //Add Agreement
	        long currentTimeInMillis = System.currentTimeMillis();
	        companyPage.getClientAgreementPage().getAddAgreementPage().inputAgreementName("Agreement    "+currentTimeInMillis);
	        webdriver.switchTo().frame("agreement_txt_ifr");//switching the frame by ID
	        companyPage.getClientAgreementPage().getAddAgreementPage().inputLDetails("Sample Agreement");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getClientAgreementPage().getAddAgreementPage().getSaveAgreementButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        companyPage.getClientAgreementPage().getAddAgreementPage().isLoaded();

	        //Now remove the template
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getRemoveAgreementLink()));
	        companyPage.getClientAgreementPage().getRemoveAgreementLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	        companyPage.getWarningPopup().getOkButton().click();
	    }

	    @Then("^verify that admin should be able to preview the agreement in My Company page$")
	    public void verify_that_admin_should_be_able_to_preview_the_agreement_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAgreementLink().click();
	        companyPage.getClientAgreementPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getPreviewAgreementLink()));
	        companyPage.getClientAgreementPage().getPreviewAgreementLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getAgreementPreviewPopup().getPageTitle()));
	        companyPage.getClientAgreementPage().getAgreementPreviewPopup().getClosePopupLink().click();
	    }

	    @Then("^verify that admin should be able to get the added agreement in spanish in My Company page$")
	    public void verify_that_admin_should_be_able_to_get_the_added_agreement_in_spanish_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAgreementLink().click();
	        companyPage.getClientAgreementPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getSpanishLink()));
	        companyPage.getClientAgreementPage().getSpanishLink().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Default Agreement(Spanish)added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to set the agreement status to default in My Company page$")
	    public void verify_that_admin_should_be_able_to_set_agreement_status_to_default_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientAgreementLink().click();
	        companyPage.getClientAgreementPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientAgreementPage().getPreferenceDefaultAgreement()));
	        companyPage.getClientAgreementPage().getPreferenceDefaultAgreement().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Agreement option updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to view the list of clients who have set the digital signature$")
	    public void verify_that_admin_should_be_able_to_view_the_list_of_clients_who_have_set_the_digital_signature() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getDigitalSignatureRecordsLink().click();
	        companyPage.getDigitalSignatureRecordsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getDigitalSignatureRecordsPage().getPageTitle());

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDigitalSignatureRecordsPage().getClientList()));
	    }

	    @Then("^verify that digital signature of the client can be viewed from My Company page$")
	    public void verify_that_digital_signature_of_the_client_can_be_viewed_from_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getDigitalSignatureRecordsLink().click();
	        companyPage.getDigitalSignatureRecordsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getDigitalSignatureRecordsPage().getPageTitle());

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDigitalSignatureRecordsPage().getClientList()));


	        if(!companyPage.getDigitalSignatureRecordsPage().getPageCount().getText().equals("0")){
	            companyPage.getDigitalSignatureRecordsPage().getViewLink().click();
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getDigitalSignatureRecordsPage().getAgreementPreviewPopup().getPageTitle()));
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getDigitalSignatureRecordsPage().getAgreementPreviewPopup().getOkButton()));
	            companyPage.getDigitalSignatureRecordsPage().getAgreementPreviewPopup().getOkButton().click();
	        }
	    }

	    @Then("^verify that new dispute reasons can be added in My Company page$")
	    public void verify_that_new_dispute_reasons_can_be_added_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getDisputeOptionsLink().click();
	        companyPage.getDisputeOptionsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getDisputeOptionsPage().getPageTitle());

	        //Add reason
	        companyPage.getDisputeOptionsPage().getManageReasonsButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getManageReasonsPopup().getPageTitle()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        companyPage.getDisputeOptionsPage().getManageReasonsPopup().inputReason("reason"+currentTimeInMillis);
	        companyPage.getDisputeOptionsPage().getManageReasonsPopup().getAddButton().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Reason added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        /*  Cleanup is not working due to CSS issue with containing div manageReson_ajaxplace
	        //Cleanup
	        companyPage.getDisputeOptionsPage().getManageReasonsPopup().scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getManageReasonsPopup().getRemoveLastItemLink()));
	        companyPage.getDisputeOptionsPage().getManageReasonsPopup().getRemoveLastItemLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	        companyPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Reason deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        */
	        companyPage.getDisputeOptionsPage().getManageReasonsPopup().getClosePopupLink().click();
	    }

	    @Then("^verify that new instructions can be added in My Company page$")
	    public void verify_that_new_instructions_can_be_added_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getDisputeOptionsLink().click();
	        companyPage.getDisputeOptionsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getDisputeOptionsPage().getPageTitle());

	        //Add instructions
	        companyPage.getDisputeOptionsPage().getManageInstructionsButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getManageInstructionsPopup().getPageTitle()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        companyPage.getDisputeOptionsPage().getManageInstructionsPopup().inputInstruction("instruction"+currentTimeInMillis);
	        companyPage.getDisputeOptionsPage().getManageInstructionsPopup().getAddButton().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Instruction added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        /*  Cleanup is not working due to CSS issue with containing div manageReson_ajaxplace
	        //Cleanup
	        companyPage.getDisputeOptionsPage().getManageInstructionsPopup().scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getManageInstructionsPopup().getRemoveLastItemLink()));
	        companyPage.getDisputeOptionsPage().getManageInstructionsPopup().getRemoveLastItemLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	        companyPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Instruction deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        */
	        companyPage.getDisputeOptionsPage().getManageInstructionsPopup().getClosePopupLink().click();
	    }

	    @Then("^verify that batch print can be activated in My Company page$")
	    public void verify_that_batch_print_can_be_activated_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getDisputeOptionsLink().click();
	        companyPage.getDisputeOptionsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getDisputeOptionsPage().getPageTitle());

	        //Toggle Batch Print
	        companyPage.getDisputeOptionsPage().getBatchPrintButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        companyPage.getDisputeOptionsPage().isLoaded();
	        companyPage.getDisputeOptionsPage().getBatchPrintButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        companyPage.getDisputeOptionsPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to modify the credit bureaus address in My Company page$")
	    public void verify_that_admin_should_be_able_to_modify_the_credit_bureaus_address_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getDisputeOptionsLink().click();
	        companyPage.getDisputeOptionsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getDisputeOptionsPage().getPageTitle());
	        companyPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getEquifaxModifyLink()));
	        companyPage.getDisputeOptionsPage().getEquifaxModifyLink().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getEditBureauDetailsPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getEditBureauDetailsPopup().getAddress()));
	        companyPage.getDisputeOptionsPage().getEditBureauDetailsPopup().inputAddress("Sample Address");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getEditBureauDetailsPopup().getSaveChangesButton()));
	        companyPage.getDisputeOptionsPage().getEditBureauDetailsPopup().getSaveChangesButton().click();
	// //Issue with Flash message. Behaviour is not consistent with rest of application
//	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Addresses have been changed successfully");
//	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        companyPage.getDisputeOptionsPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to reset the credit bureaus address in My Company page$")
	    public void verify_that_admin_should_be_able_to_reset_the_credit_bureaus_address_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getDisputeOptionsLink().click();
	        companyPage.getDisputeOptionsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getDisputeOptionsPage().getPageTitle());
	        companyPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getDisputeOptionsPage().getEquifaxResetLink()));
	        companyPage.getDisputeOptionsPage().getEquifaxResetLink().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	        companyPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
//	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Addresses have been changed successfully");
//	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        companyPage.getDisputeOptionsPage().isLoaded();
	    }


	    @Then("^verify that admin should be able to set automated notification options in My Company page$")
	    public void verify_that_admin_should_be_able_to_set_automated_notification_options_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getAutomatedNotificationsLink().click();
	        companyPage.getAutomatedNotificationOptionsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getAutomatedNotificationOptionsPage().getPageTitle());
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAutomatedNotificationOptionsPage().getMailAsCC()));
	        companyPage.getAutomatedNotificationOptionsPage().getMailAsCC().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Email Option updated successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        companyPage.getAutomatedNotificationOptionsPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to add new client status type in My Company page$")
	    public void verify_that_admin_should_be_able_to_add_new_client_status_type_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getClientStatusTypesLink().click();
	        companyPage.getClientStatusTypesPage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientStatusTypesPage().getAddStatusButton()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        String status = "Status"+currentTimeInMillis;
	        companyPage.getClientStatusTypesPage().inputStatus(status);
	        companyPage.getClientStatusTypesPage().getAddStatusButton().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Status added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        companyPage.getCompanySideBarNavigator().getClientStatusTypesLink().click();
	        companyPage.getClientStatusTypesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientStatusTypesPage().getAddStatusButton()));
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getClientStatusTypesPage().getStatusTable()));
	        Thread.sleep(3000);
	        WebElement element = companyPage.getClientStatusTypesPage().findDeleteLinkOfMatchingStatus(status);
	        if(element!=null){
	            element.click();
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	            companyPage.getWarningPopup().getOkButton().click();
	            wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	            TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Status deleted successfully");
	            wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        }
	    }

	    @Then("^verify that new invoice option can be added in My Company page$")
	    public void verify_that_new_invoice_option_can_be_added_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getInvoiceOptionsLink().click();
	        companyPage.getInvoiceOptionsPage().isLoaded();

	        TestAssert.verifyElementVisible(companyPage.getInvoiceOptionsPage().getPageTitle());

	        //Add Invoice option
	        companyPage.getInvoiceOptionsPage().getAddOptionsButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getInvoiceOptionsPage().getAddInvoiceOptionPopup().getPageTitle()));
	        long currentTimeInMillis = System.currentTimeMillis();
	        companyPage.getInvoiceOptionsPage().getAddInvoiceOptionPopup().inputTitle("optionTitle"+currentTimeInMillis);
	        companyPage.getInvoiceOptionsPage().getAddInvoiceOptionPopup().inputDescription("optionDescription"+currentTimeInMillis);
	        companyPage.getInvoiceOptionsPage().getAddInvoiceOptionPopup().getSubmitButton().click();

	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Option added successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));

	        //Remove the newly added option
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getInvoiceOptionsPage().getRemoveFirstOptionLink()));
	        companyPage.getInvoiceOptionsPage().getRemoveFirstOptionLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessage()));
	        companyPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Option deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that admin should be able to preview the invoice option in My Company page$")
	    public void verify_that_admin_should_be_able_to_preview_the_invoice_option_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getInvoiceOptionsLink().click();
	        companyPage.getInvoiceOptionsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getInvoiceOptionsPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getInvoiceOptionsPage().getPreviewInvoiceButton()));
	        companyPage.getInvoiceOptionsPage().getPreviewInvoiceButton().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getInvoiceOptionsPage().getPreviewInvoicePopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getInvoiceOptionsPage().getPreviewInvoicePopup().getClosePopupLink()));
	        companyPage.getInvoiceOptionsPage().getPreviewInvoicePopup().getClosePopupLink().click();
	        companyPage.getInvoiceOptionsPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to update affiliate commission settings in My Company page$")
	    public void verify_that_admin_should_be_able_to_update_affiliate_commission_settings_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getAffiliatePaymentsLink().click();
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getPaymentFrequency()));
	        companyPage.getAffiliatePaymentsPage().selectPaymentFrequency("Weekly");
	        companyPage.getAffiliatePaymentsPage().getUpdateSettingsButton().click();
//	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Affiliate Commission Settings has been saved");
//	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        commonHeaderSection.getCommonHeaderTabNavigationBar().getMyCompanyTab().click();
	    }

	    @Then("^verify that admin should be able to see the affiliate commission setting in affiliate profile page in My Company page$")
	    public void verify_that_admin_should_be_able_to_see_the_affiliate_commission_setting_in_affiliate_profile_page_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getCompanySideBarNavigator().getAffiliatePaymentsLink().click();
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getCommissionRate()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getCommissionFor()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getMinimumPayout()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getPaymentFrequency()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getAllowViewEarnings()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getForbidViewEarnings()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getUpdateSettingsButton()));
	    }

	    @Then("^verify that admin should be able to view affiliate payment history in My Company page$")
	    public void verify_that_admin_should_be_able_to_view_affiliate_payment_history_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getAffiliatePaymentsLink().click();
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getPageTitle()));
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getHistoryLink()));
	        companyPage.getAffiliatePaymentsPage().getHistoryLink().click();
	        companyPage.getAffiliatePaymentsPage().getPaymentHistoryPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to set the commission rate for the affiliate in My Company page$")
	    public void verify_that_admin_should_be_able_to_set_the_commission_rate_for_the_affiliate_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getAffiliatePaymentsLink().click();
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getPageTitle()));
	        companyPage.getAffiliatePaymentsPage().inputCommissionRate("1");
	        companyPage.getAffiliatePaymentsPage().getUpdateSettingsButton().click();
//	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Affiliate Commission Settings has been saved");
//	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        commonHeaderSection.getCommonHeaderTabNavigationBar().getMyCompanyTab().click();
	    }

	    @Then("^verify that admin should be able to set the Custom rate for the affiliate for future in My Company page$")
	    public void verify_that_admin_should_be_able_to_set_the_custom_rate_for_the_affiliate_for_future_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getAffiliatePaymentsLink().click();
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getPageTitle()));
	        companyPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getSettingsLink()));
	        companyPage.getAffiliatePaymentsPage().getSettingsLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getCustomRateChoice()));
	        companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getCustomRateChoice().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getCommission()));
	        companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().inputCommission("10");
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getSaveButton()));
	        companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(companyPage.getFlashMessage().getMessage(), "Changes saved successfully");
	        wait.until(ExpectedConditions.invisibilityOf(companyPage.getFlashMessage().getMessage()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getClosePopupLink()));
	        companyPage.getAffiliatePaymentsPage().getAffiliateCommissionSettingsPopup().getClosePopupLink().click();
	        companyPage.getAffiliatePaymentsPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to view the email template in My Company page$")
	    public void verify_that_admin_should_be_able_to_view_the_email_template_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getMandrillIntegrationLink().click();
	        companyPage.getMandrillIntegrationPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMandrillIntegrationPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMandrillIntegrationPage().getEmailTemplatesButton()));
	        companyPage.getMandrillIntegrationPage().getEmailTemplatesButton().click();
	        companyPage.getMandrillIntegrationPage().getEmailTemplatesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMandrillIntegrationPage().getEmailTemplatesPage().getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMandrillIntegrationPage().getEmailTemplatesPage().getViewTemplateLink()));
	        companyPage.getMandrillIntegrationPage().getEmailTemplatesPage().getViewTemplateLink().click();

	        companyPage.getMandrillIntegrationPage().getEmailTemplatesPage().getViewTemplatesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getMandrillIntegrationPage().getEmailTemplatesPage().getViewTemplatesPage().getPageTitle()));
	    }

	    @Then("^verify that chargebee integration can be activated in My Company page$")
	    public void verify_that_chargebee_integration_can_be_activated_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.getCompanySideBarNavigator().getChargebeeIntegrationLink().click();
	        companyPage.getChargebeeSettingsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getChargebeeSettingsPage().getCloseOverlayLink()));
	        companyPage.getChargebeeSettingsPage().getCloseOverlayLink().click();
	        wait.until(ExpectedConditions.visibilityOf(companyPage.getChargebeeSettingsPage().getChargebeeIntegrationButton()));
	        companyPage.getChargebeeSettingsPage().getChargebeeIntegrationButton().click();

	        wait.until(ExpectedConditions.visibilityOf(companyPage.getWarningPopup().getWarningMessageContainer()));
	        myClientsPage.getWarningPopup().getOkButton().click();
	    }

	    @Then("^verify that api & automation information can be accessed in My Company page$")
	    public void verify_that_api_and_automation_information_can_be_accessed_in_my_company_page() throws Exception {
	        if(companyPage.isTooltipShown()){
	            companyPage.getCloseTooltipLink().click();
	        }
	        companyPage.scroll("0", "document.body.scrollHeight");
	        companyPage.getCompanySideBarNavigator().getApiAndAutomationsLink().click();
	        companyPage.getAPIAndAutomationsPage().isLoaded();
	        companyPage.getAPIAndAutomationsPage().getAutomationSideBarNavigator().getOverviewLink().click();
	        companyPage.getAPIAndAutomationsPage().getAutomationsOverviewPage().isLoaded();
	        companyPage.getAPIAndAutomationsPage().getAutomationSideBarNavigator().getApiCredentialsLink().click();
	        companyPage.getAPIAndAutomationsPage().getApiCredentialsPage().isLoaded();
	        companyPage.getAPIAndAutomationsPage().getAutomationSideBarNavigator().getApiMethodsLink().click();
	        companyPage.getAPIAndAutomationsPage().getApiMethodsPage().isLoaded();
	        companyPage.getAPIAndAutomationsPage().getAutomationSideBarNavigator().getErrorMessagesLink().click();
	        companyPage.getAPIAndAutomationsPage().getAPIErrorMessagesPage().isLoaded();
	        companyPage.getAPIAndAutomationsPage().getAutomationSideBarNavigator().getExamplesLink().click();
	        companyPage.getAPIAndAutomationsPage().getAPIExamplesPage().isLoaded();
	    }
	}

