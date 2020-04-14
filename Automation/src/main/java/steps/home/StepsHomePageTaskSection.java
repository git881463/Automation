package steps.home;


	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Home Page Task Section.
	 * Look at the feature file for more detail
	 */
	public class StepsHomePageTaskSection extends StepsNavigationHelper {
		private static final Logger logger = LoggerFactory.getLogger(StepsHomePageTaskSection.class);

		private void addTask(String task){
			homePage.scroll("0","300");
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getNewTaskLink()));
			homePage.getHomePageTaskSection().getNewTaskLink().click();
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getHomePageTaskSectionNewTaskPopup().getPageTitle()));
			homePage.getHomePageTaskSection().getHomePageTaskSectionNewTaskPopup().setTaskSubject(task);
			homePage.getHomePageTaskSection().getHomePageTaskSectionNewTaskPopup().getSaveButton().click();
			wait.until(ExpectedConditions.visibilityOf(homePage.getFlashMessage().getMessage()));
			TestAssert.verifyElementContent(homePage.getFlashMessage().getMessage(), "Task added successfully.");
			wait.until(ExpectedConditions.invisibilityOf(homePage.getFlashMessage().getMessage()));
		}

		private void verifyTask(String task){
			webdriver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getFirstTaskInList()));
			//TestAssert.verifyElementContent(homePage.getHomePageTaskSection().getTodaysTaskContainer(), task);
		}

		private void deleteTask(String task){
			webdriver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getFirstTaskInList()));
			//TestAssert.verifyElementContent(homePage.getHomePageTaskSection().getTodaysTaskContainer(), task);
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getDeleteTaskLink()));
			homePage.getHomePageTaskSection().getDeleteTaskLink().click();
			wait.until(ExpectedConditions.visibilityOf(homePage.getWarningPopup().getWarningMessage()));
			homePage.getWarningPopup().getOkButton().click();
			wait.until(ExpectedConditions.visibilityOf(homePage.getFlashMessage().getMessage()));
			TestAssert.verifyElementContent(homePage.getFlashMessage().getMessage(), "Task deleted successfully.");
			wait.until(ExpectedConditions.invisibilityOf(homePage.getFlashMessage().getMessage()));
		}

		private void completeTask(String task){
			webdriver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getFirstTaskInList()));
			homePage.getHomePageTaskSection().getFirstTaskInList().click();
			wait.until(ExpectedConditions.visibilityOf(homePage.getFlashMessage().getMessage()));
			TestAssert.verifyElementContent(homePage.getFlashMessage().getMessage(), "Task marked as complete");
			wait.until(ExpectedConditions.invisibilityOf(homePage.getFlashMessage().getMessage()));
		}

		private void incompleteTask(String task){
			webdriver.navigate().refresh();
			homePage.scroll("0","300");
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getViewAllTasksLink()));
			homePage.getHomePageTaskSection().getViewAllTasksLink().click();

			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getAllTasksForm()));
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getTaskCheckBox()));
			homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getTaskCheckBox().click();

			wait.until(ExpectedConditions.visibilityOf(homePage.getFlashMessage().getMessage()));
			TestAssert.verifyElementContent(homePage.getFlashMessage().getMessage(), "Task marked as incomplete");
			wait.until(ExpectedConditions.invisibilityOf(homePage.getFlashMessage().getMessage()));
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getCloseWidgetLink()));
			homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getCloseWidgetLink().click();
		}

		@Then("^verify that if admin creates a new task for today’s date then the created task should be visible under Today’s schedule$")
		public void admin_creates_a_new_task_for_todays_date_and_the_created_task_should_be_visible_under_Todays_schedule() {
			long currentTimeInMillis = System.currentTimeMillis();
			String task = "Task"+currentTimeInMillis;
			addTask(task);
			verifyTask(task);
			deleteTask(task);
		}

		@Then("^verify that admin can mark the task as completed$")
		public void admin_can_mark_the_task_as_completed() {
			long currentTimeInMillis = System.currentTimeMillis();
			String task = "Task"+currentTimeInMillis;
			addTask(task);
			verifyTask(task);
			completeTask(task);
		}

		@Then("^verify that admin can mark the task as incomplete$")
		public void admin_can_mark_the_task_as_incomplete() {
			long currentTimeInMillis = System.currentTimeMillis();
			String task = "Task"+currentTimeInMillis;
			addTask(task);
			verifyTask(task);
			incompleteTask(task);
			verifyTask(task);
			deleteTask(task);
		}

		@Then("^admin should be able to view all tasks by clicking on 'View All Tasks' link$")
		public void the_task_selection_widget_should_be_shown() {
			webdriver.navigate().refresh();
			homePage.scroll("0","300");
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getViewAllTasksLink()));
			homePage.getHomePageTaskSection().getViewAllTasksLink().click();
			TestAssert.verifyElementVisible(homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getAllTasksForm());
			wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getCloseWidgetLink()));
			homePage.getHomePageTaskSection().getHomePageTaskSectionTaskSelectionWidget().getCloseWidgetLink().click();
		}

	}

