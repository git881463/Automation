package steps.schedule;

	 import io.cucumber.java.en.Given;
	 import io.cucumber.java.en.Then;
     import pageobjects.schedule.SchedulePage;
     import steps.StepsNavigationHelper;

     import org.openqa.selenium.support.ui.ExpectedConditions;
 	 import org.slf4j.Logger;
	 import org.slf4j.LoggerFactory;

     import helper.TestAssert;

     import java.time.LocalDate;

	/**
	 * Steps for My Schedule Page.
	 * Look at the feature file for more detail
	 */
	public class StepsSchedulePage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsSchedulePage.class);

	    @Given("^Admin is on my schedule page$")
	    public void adminIsOnTheSchedulePage() {
	        schedulePage.load();
	    }

	    @Then("^verify that admin should be able to view all the tasks added to all the Team member for the current week in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_all_the_tasks_added_to_all_the_Team_member_for_the_current_week_in_My_Schedule_page() throws Exception {
	        schedulePage.selectTeamMember(1);
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getGridContainer()));
	        schedulePage.selectTeamMember(2);
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getGridContainer()));
	    }

	    @Then("^verify that admin should be able to view the My schedule calendar Day wise in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_my_schedule_calendar_day_wise_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayCalHeader()));
	    }

	    @Then("^verify that admin should be able to view the My schedule calendar Week wise in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_my_schedule_calendar_week_wise_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getWeekButton()));
	        schedulePage.getWeekButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getWeekCalHeader()));
	    }

	    @Then("^verify that admin should be able to view the My schedule calendar Month wise in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_my_schedule_calendar_month_wise_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getMonthButton()));
	        schedulePage.getMonthButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getMonthCalHeader()));
	    }

	    @Then("^verify that admin should be able to view Todays agenda in calendar by clicking 'Today' in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_todays_agenda_in_calendar_by_clicking_today_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getTodayButton()));
	        schedulePage.getTodayButton().click();

	        LocalDate localDate = LocalDate.now();
	        String searchString = ""+localDate.getMonth().getValue() + '/'+ localDate.getDayOfMonth();
	        logger.debug("searchString : {}", searchString);
	        TestAssert.verifyElementContent(schedulePage.getWeekDayName(), searchString);
	    }

	    @Then("^verify that admin should be able to view the next week on the calendar by clicking on '>' button in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_next_week_on_calendar_by_clicking_on_gt_button_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDateTimeValue()));
	        String valBefore = schedulePage.getDateTimeValue().getText();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getNextButton()));
	        schedulePage.getNextButton().click();
	        Thread.sleep(1000);
	        String valAfter = schedulePage.getDateTimeValue().getText();
	        TestAssert.verifyNotEqual(valBefore, valAfter);
	    }

	    @Then("^verify that admin should be able to view the previous week on the calendar by clicking on '<' button in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_previous_week_on_calendar_by_clicking_on_lt_button_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDateTimeValue()));
	        String valBefore = schedulePage.getDateTimeValue().getText();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getPrevButton()));
	        schedulePage.getPrevButton().click();
	        Thread.sleep(1000);
	        String valAfter = schedulePage.getDateTimeValue().getText();
	        TestAssert.verifyNotEqual(valBefore, valAfter);
	    }

	    @Then("^verify that admin should be able to view the next day on the calendar by clicking on '>' button in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_next_day_on_calendar_by_clicking_on_gt_button_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDateTimeValue()));
	        String valBefore = schedulePage.getDateTimeValue().getText();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getNextButton()));
	        schedulePage.getNextButton().click();
	        Thread.sleep(1000);
	        String valAfter = schedulePage.getDateTimeValue().getText();
	        TestAssert.verifyNotEqual(valBefore, valAfter);
	    }

	    @Then("^verify that admin should be able to view the previous day on the calendar by clicking on '<' button in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_previous_day_on_calendar_by_clicking_on_lt_button_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDateTimeValue()));
	        String valBefore = schedulePage.getDateTimeValue().getText();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getPrevButton()));
	        schedulePage.getPrevButton().click();
	        Thread.sleep(1000);
	        String valAfter = schedulePage.getDateTimeValue().getText();
	        TestAssert.verifyNotEqual(valBefore, valAfter);
	    }

	    @Then("^verify that admin should be able to view the next month on the calendar by clicking on '>' button in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_next_month_on_calendar_by_clicking_on_gt_button_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getMonthButton()));
	        schedulePage.getMonthButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDateTimeValue()));
	        String valBefore = schedulePage.getDateTimeValue().getText();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getNextButton()));
	        schedulePage.getNextButton().click();
	        Thread.sleep(1000);
	        String valAfter = schedulePage.getDateTimeValue().getText();
	        TestAssert.verifyNotEqual(valBefore, valAfter);
	    }

	    @Then("^verify that admin should be able to view the previous month on the calendar by clicking on '<' button in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_previous_month_on_calendar_by_clicking_on_lt_button_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getMonthButton()));
	        schedulePage.getMonthButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDateTimeValue()));
	        String valBefore = schedulePage.getDateTimeValue().getText();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getPrevButton()));
	        schedulePage.getPrevButton().click();
	        Thread.sleep(1000);
	        String valAfter = schedulePage.getDateTimeValue().getText();
	        TestAssert.verifyNotEqual(valBefore, valAfter);
	    }

	    @Then("^verify that admin should be able to view the tooltip in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_view_the_tooltip_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getTooltip()));
	        schedulePage.hoverHelpIcon();
	        Thread.sleep(2000);
	    }

	    @Then("^verify that admin should be able to refresh the 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_refresh_the_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getRefreshLink()));
	        schedulePage.getRefreshLink().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getRefreshLink()));
	    }

	    @Then("^verify that admin should be able to export the 'my Schedule' calendar in '.ics' format in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_export_the_my_schedule_calendar_in_ics_format_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getExportLink()));
	        schedulePage.getExportLink().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getExportLink()));
	    }

	    @Then("^verify that admin should be able to add new event by clicking on 'New Event' in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_add_new_event_by_clicking_on_new_event_in_My_Schedule_page() throws Exception {
	        schedulePage.getNewEventButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getPageTitle()));
	        webdriver.switchTo().frame(schedulePage.getCreateNewCalendarPopup().getFrameElement());//switching the frame by ID
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getSaveButton()));
	        schedulePage.getCreateNewCalendarPopup().selectEvent("Billing");
	        long currentTimeInMillis = System.currentTimeMillis();
	        schedulePage.getCreateNewCalendarPopup().inputSubject("Test"+currentTimeInMillis);
	        schedulePage.getCreateNewCalendarPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getWarningPopup().getPageContainer()));
	        schedulePage.getWarningPopup().getOkButton().click();
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        schedulePage.isLoaded();
	    }

	    @Then("^verify that new event can be created in My Schedule page$")
	    public void verify_that_new_event_can_be_created_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getTodayItem()));
	        schedulePage.getTodayItem().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getEventPopup()));
	        schedulePage.inputEventName("Sample Event");
	        schedulePage.getCreateEventButton().click();
	        schedulePage.isLoaded();
	    }

	    @Then("^verify that admin should be able to edit the details of the added event in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_edit_the_details_of_the_added_event_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        schedulePage.getNewEventButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getPageTitle()));
	        webdriver.switchTo().frame(schedulePage.getCreateNewCalendarPopup().getFrameElement());//switching the frame by ID
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getSaveButton()));
	        schedulePage.getCreateNewCalendarPopup().selectEvent("Billing");
	        long currentTimeInMillis = System.currentTimeMillis();
	        schedulePage.getCreateNewCalendarPopup().inputSubject("Test"+currentTimeInMillis);
	        schedulePage.getCreateNewCalendarPopup().getAllDayEvent().click();
	        schedulePage.getCreateNewCalendarPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getWarningPopup().getPageContainer()));
	        schedulePage.getWarningPopup().getOkButton().click();
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        schedulePage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getFirstCreatedEvent()));
	        schedulePage.getFirstCreatedEvent().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getEditEventLink()));
	        schedulePage.getEditEventLink().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getEditPageTitle()));
	        webdriver.switchTo().frame(schedulePage.getCreateNewCalendarPopup().getFrameElement());//switching the frame by ID
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getSaveButton()));
	        schedulePage.getCreateNewCalendarPopup().inputSubject("Test11");
	        schedulePage.getCreateNewCalendarPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getWarningPopup().getPageContainer()));
	        schedulePage.getWarningPopup().getOkButton().click();
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        schedulePage.isLoaded();
	    }

	    @Then("^verify that admin should be able to delete the added event in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_delete_the_added_event_in_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        schedulePage.getNewEventButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getPageTitle()));
	        webdriver.switchTo().frame(schedulePage.getCreateNewCalendarPopup().getFrameElement());//switching the frame by ID
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getCreateNewCalendarPopup().getSaveButton()));
	        schedulePage.getCreateNewCalendarPopup().selectEvent("Billing");
	        long currentTimeInMillis = System.currentTimeMillis();
	        schedulePage.getCreateNewCalendarPopup().inputSubject("Test"+currentTimeInMillis);
	        schedulePage.getCreateNewCalendarPopup().getAllDayEvent().click();
	        schedulePage.getCreateNewCalendarPopup().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getWarningPopup().getPageContainer()));
	        schedulePage.getWarningPopup().getOkButton().click();
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        schedulePage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDayButton()));
	        schedulePage.getDayButton().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getFirstCreatedEvent()));
	        schedulePage.getFirstCreatedEvent().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getDeleteEventLink()));
	        schedulePage.getDeleteEventLink().click();
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getWarningPopup().getPageContainer()));
	        schedulePage.getWarningPopup().getOkButton().click();
	        schedulePage.isLoaded();
	    }

	    @Then("^verify that admin should be able to navigate to 'Automated Notification Options' page upon clicking 'Click here to set automated notification' in 'My Schedule' page$")
	    public void verify_that_admin_should_be_able_to_navigate_to_automated_notification_options_page_from_My_Schedule_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(schedulePage.getAutomatedNotificationsLink()));
	        schedulePage.getAutomatedNotificationsLink().click();
	        companyPage.getAutomatedNotificationOptionsPage().isLoaded();
	    }
	}

