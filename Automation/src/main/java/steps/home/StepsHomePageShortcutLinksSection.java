package steps.home;

	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;

    import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Home Page Shortcut Section.
	 * Look at the feature file for more detail
	 */
	public class StepsHomePageShortcutLinksSection extends StepsNavigationHelper {
	    private static final Logger logger = LoggerFactory.getLogger(StepsHomePageShortcutLinksSection.class);

	    @Then("^verify that on clicking 'My Company Profile' shortcut, admin navigates to 'My Company Profile' page$")
	    public void the_admin_is_able_to_navigate_to_mycompany_page() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getMyCompanyProfileLink()));
	        homePage.getHomePageShortcutsSection().getMyCompanyProfileLink().click();
	        companyPage.isLoaded();
	    }

	    @When("^Admin clicks on 'Get Help by Phone' shortcut$")
	    public void admin_clicks_on_get_help_by_phone_shortcut() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getGetHelpByPhoneLink()));
	        homePage.getHomePageShortcutsSection().getGetHelpByPhoneLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to support center page in a new tab$")
	    public void the_admin_is_able_to_navigate_to_support_center_page_in_a_new_tab() {
	        supportCenterPage.isLoadedInTab();
	    }

	    @Then("^verify that on clicking 'My Clients' shortcut, admin navigates to 'My Clients' page$")
	    public void the_admin_is_able_to_navigate_to_my_clients_page() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getMyClientsLink()));
	        homePage.getHomePageShortcutsSection().getMyClientsLink().click();
	        myClientsPage.getSearchClientPage().isLoaded();
	    }

	    @Then("^verify that on clicking 'My Contacts' shortcut, admin navigates to 'My Contacts' page$")
	    public void the_admin_is_able_to_navigate_to_my_contacts_page() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getMyContactsLink()));
	        homePage.getHomePageShortcutsSection().getMyContactsLink().click();
	        contactsPage.isLoaded();
	    }

	    @Then("^verify that on clicking 'Free Guides and Resources' shortcut, admin navigates to 'Guide' page$")
	    public void the_admin_is_able_to_navigate_to_guide_page() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getFreeGuidesAndResourcesLink()));
	        homePage.getHomePageShortcutsSection().getFreeGuidesAndResourcesLink().click();
	        guidePage.isLoaded();
	    }

	    @Then("^verify that on clicking 'Schedule' shortcut, admin navigates to 'Schedule' page$")
	    public void the_admin_is_able_to_navigate_to_schedule_page() {
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getScheduleLink()));
	        homePage.getHomePageShortcutsSection().getScheduleLink().click();
	        schedulePage.isLoaded();
	    }

	    @Then("^verify that on clicking 'My Library' shortcut, admin navigates to 'My Library' page$")
	    public void the_admin_is_able_to_navigate_to_library_page() {
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getLibraryOfDisputeLettersLink()));
	        homePage.getHomePageShortcutsSection().getLibraryOfDisputeLettersLink().click();
	        libraryPage.isLoaded();
	    }

	    @Then("^verify that on clicking 'Bonus Material' shortcut, admin navigates to 'Bonus Material' page$")
	    public void the_admin_is_able_to_navigate_to_bonus_material_page() {
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getBonusMaterialsLink()));
	        homePage.getHomePageShortcutsSection().getBonusMaterialsLink().click();
	        bonusMaterialPage.isLoaded();
	    }

	    @When("^Admin clicks on 'My Business website' shortcut$")
	    public void admin_clicks_on_my_business_website_shortcut() {
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getBusinessWebsiteLink()));
	        homePage.getHomePageShortcutsSection().getBusinessWebsiteLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to business website page$")
	    public void the_admin_is_able_to_navigate_to_business_website_page() {
	        businessWebsitePage.isLoaded();
	    }

	    @Then("^verify that on clicking 'Quick video' shortcut, admin navigates to 'Quick Videos' page in new tab$")
	    public void the_admin_is_able_to_navigate_to_quick_videos_page_in_a_new_tab() {
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getQuickVideosLink()));
	        homePage.getHomePageShortcutsSection().getQuickVideosLink().click();
	        quickVideosPage.isLoadedInTab();
	    }

	    @When("^Admin clicks on 'Client/Affiliate portal' shortcut$")
	    public void admin_clicks_on_client_portal_shortcut() {
	        homePage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageShortcutsSection().getBusinessWebsiteLink()));
	        homePage.getHomePageShortcutsSection().getClientsAndAffiliatePortalLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to client portal page in new tab$")
	    public void the_admin_is_able_to_navigate_to_client_portal_page_in_a_new_tab() {
	        clientAndAffiliatePortalPage.isLoaded();
	    }
	}


