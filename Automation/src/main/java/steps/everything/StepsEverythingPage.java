package steps.everything;

	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Everything Page.
	 * Look at the feature file for more detail
	 */
	public class StepsEverythingPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsEverythingPage.class);

	    @Given("^Admin is on Everything page$")
	    public void adminIsOnEverythingPage() {
	        everythingPage.load();
	    }

	    @Then("^verify that on clicking 'Progress' tab, sequence of activities done by me and my team members are shown$")
	    public void verify_that_on_clicking_progress_tab_sequence_of_activitiess_are_shown() throws Exception {
	        everythingPage.getProgressLink().click();
	        everythingPage.getProgressPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTeamDropDown()));
	        everythingPage.getProgressPage().selectTeamFilter("Me");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTimeLine()));


	        everythingPage.getProgressPage().selectTeamFilter("Team Member");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getProgressPage().getAjaxFilterLoader()));

	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTeamMemberName()));
	        everythingPage.getProgressPage().inputTeamMemberName(loggedinUser);
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTeamMemberNameSelectionMenuItem()));
	        everythingPage.getProgressPage().getTeamMemberNameSelectionMenuItem().click();
	        everythingPage.getProgressPage().getSearchTeamMemberButton().click();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTimeLine()));
	    }

	    @Then("^verify that admin should be able to filter and view the sequence of activity$")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_sequence_of_activity() throws Exception {
	        everythingPage.getProgressLink().click();
	        everythingPage.getProgressPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTimeLineHeader()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTeamDropDown()));
	        everythingPage.getProgressPage().selectTeamFilter("Me");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTimeLineHeader()));
	        everythingPage.getProgressPage().getTimeLineHeader().click();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getActivityDetails()));
	    }

	    @Then("^verify that admin should be able to view only particular dates activity by clicking on the Date$")
	    public void verify_that_admin_should_be_able_to_view_only_particular_dates_activity_by_clicking_on_the_Date() throws Exception {
	        everythingPage.getProgressLink().click();
	        everythingPage.getProgressPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTeamDropDown()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getTimeLineHeader()));
	        everythingPage.getProgressPage().getTimeLineHeader().click();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getProgressPage().getActivityDetails()));
	    }

	    @Then("^verify that admin should be able to view List of all first work pending clients of the organization$")
	    public void verify_that_admin_should_be_able_to_view_list_of_all_first_work_pending_clients_of_the_organization() throws Exception {
	        everythingPage.getFirstWorkPendingLink().click();
	        everythingPage.getPendingClientsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getPendingClientsPage().getAllClientsContainer()));
	    }

	    @Then("^As a CRC Admin I should be able to filter and view the Pending work$")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_pending_work() throws Exception {
	        everythingPage.getFirstWorkPendingLink().click();
	        everythingPage.getPendingClientsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getPendingClientsPage().getAllClientsContainer()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getPendingClientsPage().getTeamDropDown()));
	        everythingPage.getProgressPage().selectTeamFilter("Me");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getPendingClientsPage().getAllClientsContainer()));
	    }

	    @Then("^verify that admin should be able to view List of all tasks added for him and his team member and clients$")
	    public void verify_that_admin_should_be_able_to_view_list_of_all_tasks_added_for_him_and_his_team_member_and_clients() throws Exception {
	        everythingPage.getAllTasksLink().click();
	        everythingPage.getAllTasksPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getDatacontainer()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getTeamDropDown()));
	    }

	    @Then("^verify that admin should be able to filter and view the list of all tasks assigned to him$")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_list_of_all_tasks_assinged_to_him() throws Exception {
	        everythingPage.getAllTasksLink().click();
	        everythingPage.getAllTasksPage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getTeamDropDown()));
	        everythingPage.getAllTasksPage().selectTeamFilter("Me");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getAllTasksPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to filter and view the list of all tasks assigned to his team members")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_list_of_all_tasks_assigned_to_his_team_members() throws Exception {
	        everythingPage.getAllTasksLink().click();
	        everythingPage.getAllTasksPage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getTeamDropDown()));
	        everythingPage.getAllTasksPage().selectTeamFilter("Team Member");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getTeamMemberName()));
	        everythingPage.getAllTasksPage().inputTeamMemberName("Member1");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getAllTasksPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getAllTasksPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to filter and view the list of all tasks assigned to his clients")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_list_of_all_tasks_assigned_to_his_clients() throws Exception {
	        everythingPage.getAllTasksLink().click();
	        everythingPage.getAllTasksPage().isLoaded();

	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getTeamDropDown()));
	        everythingPage.getAllTasksPage().selectTeamFilter("Client");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getClientName()));
	        everythingPage.getAllTasksPage().inputClientName("Client1");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllTasksPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getAllTasksPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getAllTasksPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to view list of all messages sent between team members and clients$")
	    public void verify_that_admin_should_be_able_to_view_list_of_all_messages_sent_between_team_members_and_clients() throws Exception {
	        everythingPage.getAllCommunicationsLink().click();
	        everythingPage.getEverythingAllMessagesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getTeamDropDown()));
	        everythingPage.getEverythingAllMessagesPage().selectTeamFilter("Client");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getClientName()));
	        everythingPage.getAllTasksPage().inputClientName("Sample Client");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to filter and view the list of messages between him and team members or clients$")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_list_of_messages_between_him_and_team_members_or_clients() throws Exception {
	        everythingPage.getAllCommunicationsLink().click();
	        everythingPage.getEverythingAllMessagesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getTeamDropDown()));
	        everythingPage.getEverythingAllMessagesPage().selectTeamFilter("Me");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to filter and view the conversation of selected team member$")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_conversation_of_selected_team_member() throws Exception {
	        everythingPage.getAllCommunicationsLink().click();
	        everythingPage.getEverythingAllMessagesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getTeamDropDown()));
	        everythingPage.getEverythingAllMessagesPage().selectTeamFilter("Team Member");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getTeamMemberName()));
	        everythingPage.getEverythingAllMessagesPage().inputTeamMemberName("Member1");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getEverythingAllMessagesPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to filter and view the conversation of selected affiliate$")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_conversation_of_selected_affiliate() throws Exception {
	        everythingPage.getAllCommunicationsLink().click();
	        everythingPage.getEverythingAllMessagesPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getTeamDropDown()));
	        everythingPage.getEverythingAllMessagesPage().selectTeamFilter("Affiliate");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getAffiliateName()));
	        everythingPage.getEverythingAllMessagesPage().inputAffiliateName("Sample Affiliate");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getEverythingAllMessagesPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getEverythingAllMessagesPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to view the list of all Files/Documents of his organisation$")
	    public void verify_that_admin_should_be_able_to_view_the_list_of_all_Files_Documents() throws Exception {
	        everythingPage.scroll("0", "document.body.scrollHeight");
	        everythingPage.getAllFilesLink().click();
	        everythingPage.getAllDocumentsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllDocumentsPage().getDatacontainer()));
	    }

	    @Then("^verify that admin should be able to filter and view the list of all Files/Documents$")
	    public void verify_that_admin_should_be_able_to_filter_and_view_the_list_of_all_Files_Documents() throws Exception {
	        everythingPage.scroll("0", "document.body.scrollHeight");
	        everythingPage.getAllFilesLink().click();

	        everythingPage.getAllDocumentsPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllDocumentsPage().getTeamDropDown()));
	        everythingPage.getEverythingAllMessagesPage().selectTeamFilter("Me");
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllDocumentsPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(everythingPage.getAllDocumentsPage().getAjaxFilterLoader()));
	        wait.until(ExpectedConditions.visibilityOf(everythingPage.getAllDocumentsPage().getDatacontainer()));
	    }
	}
