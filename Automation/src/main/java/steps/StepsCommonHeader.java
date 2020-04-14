package steps;

	import io.cucumber.java.en.And;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
    import steps.home.*;

    import org.junit.Assert;
	import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.Wait;
    import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

     import helper.TestAssert;


	public class StepsCommonHeader extends StepsNavigationHelper
	{

	    private static final Logger logger = LoggerFactory.getLogger(StepsHomePage.class);

	    @Then("^verify if the admin is able to view the common links on top right navigation$")
	    public void verify_if_the_admin_is_able_to_view_the_common_links_on_top_right_navigation(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderRightNavigationSection().getMyAccountLink());
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderRightNavigationSection().getNewFeaturesLink());
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink());
	    }

	    @Then("^verify if the admin is able to view the common links on top left navigation and access them$")
	    public void verify_if_the_admin_is_able_to_view_the_common_links_on_left_navigation(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewLeadLink());
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewMessageLink());
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewTasksAndEventsLink());
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getPrintLink());
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewLeadLink().click();
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getLeadPopup());
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewMessageLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getSeeAllMessagesLink()));
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getSendMessageLink());
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewTasksAndEventsLink().click();
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getTasksAndEventsPopup());
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getPrintLink().click();
	        everythingTodaysLetterPage.isLoaded();
	        TestAssert.verifyElementVisible(everythingTodaysLetterPage.getPageTitle());
	    }

	    @Then("^verify if the admin is able to view badge count displaying the pending batch prints on Batch print icon$")
	    public void verify_if_the_admin_is_able_to_view_the_badge_count_on_batch_print(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        if(commonHeaderSection.getCommonHeaderLeftNavigationSection().isPrintPending()) {//As badges are optional, they might be absent
	            logger.debug("****** print count {}", Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewLettersCount().getText()));
	            Assert.assertTrue(Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewLettersCount().getText()) > 0);
	        }
	    }

	    @Then("^verify if the admin is able to view badge count displaying the new message count on Message icon$")
	    public void verify_if_the_admin_is_able_to_view_the_badge_count_on_message_icon(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        if(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewMessagesCount().isDisplayed()) {//As badges are optional, they might be absent
	            logger.debug("****** message count {}", Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewMessagesCount().getText()));
	            Assert.assertTrue(Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewMessagesCount().getText()) > 0);
	        }
	    }

	    @Then("^verify if the admin is able to view badge count displaying the new lead count on Leads icon$")
	    public void verify_if_the_admin_is_able_to_view_the_badge_count_on_leads_icon(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        if(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewLeadsCount().isDisplayed()) {//As badges are optional, they might be absent
	            logger.debug("****** leads count {}", Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewLeadsCount().getText()));
	            Assert.assertTrue(Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewLeadsCount().getText()) > 0);
	        }
	    }

	    @Then("^verify if the admin is able to view badge count displaying the task count on task icon$")
	    public void verify_if_the_admin_is_able_to_view_the_badge_count_on_task_icon(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        if(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewTasksAndEventsCount().isDisplayed()) {//As badges are optional, they might be absent
	            logger.debug("****** tasks count {}", Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewTasksAndEventsCount().getText()));
	            Assert.assertTrue(Integer.parseInt(commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewTasksAndEventsCount().getText()) > 0);
	        }
	    }

	    @Then("^verify if the admin is able to navigate to all the pages displayed in 'Help & Support' drop down list$")
	    public void verify_if_the_admin_is_able_to_navigate_to_all_the_pages_displayed_in_helpandsupport_dropdown(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));

	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getResourcesLink().click();
	        resourcesPage.isLoaded();
	        homePage.get();//Go back to home page

	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getFreeShirtLink().click();
	        claimShirtPage.isLoaded();
	        homePage.get();//Go back to home page
	    }

	    @When("^Admin clicks on messages icon in header left section$")
	    public void admin_clicks_on_messages_icon_in_header_left_section(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getNewMessageLink().click();
	    }

	    @And("^clicks on 'send a new message' link in the message popup$")
	    public void clicks_on_send_a_new_message_link_in_the_message_popup(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getSeeAllMessagesLink()));
	        TestAssert.verifyElementVisible(commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getSendMessageLink());
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getSendMessageLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to send message page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_send_message_page(){
	        messageSectionHelper.getSendNewMessagePage().isLoaded();
	    }

	    @And("^clicks on 'see all messages' link in the message popup$")
	    public void clicks_on_see_all_messages_link_in_the_message_popup(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getSeeAllMessagesLink()));
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getSeeAllMessagesLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to allmessages page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_all_messages_page(){
	        messageSectionHelper.getAllMessagesPage().isLoaded();
	    }


	    @When("^Admin clicks on batch print icon in header left section$")
	    public void admin_clicks_on_batch_print_icon_in_header_left_section(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        commonHeaderSection.getCommonHeaderLeftNavigationSection().getPrintLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to batch print page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_batch_print_page(){
	        everythingTodaysLetterPage.isLoaded();
	    }

	    @Then("^verify if the admin is able to view the new messages$")
	    public void verify_if_the_admin_is_able_to_view_the_new_messages(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderLeftNavigationSection().getMessagePopup().getNewMessages()));
	    }

	    @When("^Admin clicks on 'Help & Support' link and clicks on 'Support Center' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_support_center_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getSupportCenterLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to support center page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_support_center_page(){
	        supportCenterPage.isLoaded();
	    }


	    @When("^Admin clicks on 'Help & Support' link and clicks on 'Watch Quick Videos' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_watch_quick_videos_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getQuickVideosLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to quick videos page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_quick_videos_page(){
	        quickVideosPage.isLoaded();
	    }

	    @When("^Admin clicks on 'Help & Support' link and clicks on 'Read Startup Guides' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_read_startup_guide_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getStartupGuidesLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to read startup guide page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_read_startup_guide_page(){
	        readStartupGuidePage.isLoaded();
	    }

	    @When("^Admin clicks on 'Help & Support' link and clicks on 'Business Checklist' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_business_checklist_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getBusinessChecklistLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to business checklist page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_business_checklist_page(){
	        businessCheckListPage.isLoaded();
	    }

	    @When("^Admin clicks on 'Help & Support' link and clicks on 'Tips and tricks' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_tips_and_tricks_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getTipsAndTricksLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to tips and tricks page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_tips_and_tricks_page(){
	        tipsAndTricksPage.isLoaded();
	    }

	    @When("^Admin clicks on 'Help & Support' link and clicks on 'New Feature Requests' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_new_feature_requests_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getNewFeatureRequestsLink().click();
	    }

	    @Then("^verify if the admin is able to view 'New Feature Requests' popup$")
	    public void verify_if_the_admin_is_able_to_view_new_feature_requests_popup() {
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().
	                getHelpAndSupportDropDown().getNewFeatureRequestsPopup().getContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown()
	                .getNewFeatureRequestsPopup().getCloseButton().click();
	    }

	    @When("^Admin clicks on 'Help & Support' link and clicks on 'Resources' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_resources_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getResourcesLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to resources page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_resources_page(){
	        resourcesPage.isLoaded();
	    }

	    @When("^Admin clicks on 'Help & Support' link and clicks on 'Get Free Shirt' menu item$")
	    public void admin_clicks_on_help_and_support_link_and_click_get_free_shirt_menu_item(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getHelpAndSupportDropDown().getFreeShirtLink().click();
	    }

	    @Then("^verify if the admin is able to navigate to get free shirt page$")
	    public void verify_if_the_admin_is_able_to_navigate_to_get_free_shirt_page(){
	        claimShirtPage.isLoaded();
	    }
	}


