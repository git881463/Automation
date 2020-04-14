package pageobjects.schedule;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.WarningPopup;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing My Schedule Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SchedulePage extends AbstractBasePageObject<SchedulePage> {

	    private static final Logger logger = LoggerFactory.getLogger(SchedulePage.class);

	    private static final String relativeUrl = "/calendar";

	    @Autowired
	    private CreateNewCalendarPopup createNewCalendarPopup;

	    @Autowired
	    private WarningPopup warningPopup;

	    public SchedulePage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    public void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the schedule page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//span[contains(text(),'My Schedule')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using="showreflashbtn")
	    private WebElement refreshLink;

	    @FindBy(how = How.ID, using="showimportbtn")
	    private WebElement importLink;

	    @FindBy(how = How.XPATH, using="//div[@class='rightbtn']//span[contains(text(),'Export')]")
	    private WebElement exportLink;

	    @FindBy(how = How.ID, using="showreprintbtn")
	    private WebElement printButton;

	    @FindBy(how = How.ID, using="caltoolbar")
	    private WebElement toolbar;

	    @FindBy(how = How.CLASS_NAME, using="disp-help")
	    private WebElement tooltip;

	    @FindBy(how = How.ID, using="help-txt")
	    private WebElement tooltipText;

	    @FindBy(how = How.ID, using="faddbtn")
	    private WebElement newEventButton;

	    @FindBy(how = How.ID, using="showtodaybtn")
	    private WebElement todayButton;

	    @FindBy(how = How.ID, using="sfprevbtn")
	    private WebElement prevButton;

	    @FindBy(how = How.ID, using="sfnextbtn")
	    private WebElement nextButton;

	    @FindBy(how = How.ID, using="txtdatetimeshow")
	    private WebElement dateTimeValue;

	    @FindBy(how = How.ID, using="team_member")
	    private WebElement teamMemberDropDown;

	    @FindBy(how = How.ID, using="showdaybtn")
	    private WebElement dayButton;

	    @FindBy(how = How.ID, using="showweekbtn")
	    private WebElement weekButton;

	    @FindBy(how = How.ID, using="showmonthbtn")
	    private WebElement monthButton;

	    @FindBy(how = How.ID, using="showagendabtn")
	    private WebElement agendaButton;

	    @FindBy(how = How.ID, using="dvCalMain")
	    private WebElement scheduleContainer;

	    @FindBy(how = How.ID, using="gridcontainer")
	    private WebElement gridContainer;

	    @FindBy(how = How.ID, using="dvwkcontaienr")
	    private WebElement calHeader;

	    @FindBy(how = How.XPATH, using="//div[@id='dvwkcontaienr']/table/tbody/tr[1]/th[2]")
	    private WebElement dayCalHeader;

	    @FindBy(how = How.XPATH, using="//div[@id='dvwkcontaienr']/table/tbody/tr[1]/th[4]")
	    private WebElement weekCalHeader;

	    @FindBy(how = How.ID, using="mvcontainer")
	    private WebElement monthCalHeader;

	    @FindBy(how = How.CLASS_NAME, using="tg-col-eventwrapper")
	    private WebElement todayItem;

	    @FindBy(how = How.CLASS_NAME, using="wk-dayname")
	    private WebElement weekDayName;

	    @FindBy(how = How.ID, using="bbit-cal-buddle")
	    private WebElement eventPopup;

	    @FindBy(how = How.ID, using="bbit-cal-what")
	    private WebElement eventName;

	    @FindBy(how = How.ID, using="bbit-cal-quickAddBTN")
	    private WebElement createEventButton;

	    @FindBy(how = How.XPATH, using="//div[@id='weekViewAllDaywk']/table/tbody/tr[1]/td/div")
	    private WebElement firstCreatedEvent;

	    @FindBy(how = How.ID, using="bbit-cs-editLink")
	    private WebElement editEventLink;

	    @FindBy(how = How.ID, using="bbit-cs-delete")
	    private WebElement deleteEventLink;

	    @FindBy(how = How.XPATH, using="//a[contains(text(),'Click here to set automated notifications')]")
	    private WebElement automatedNotificationsLink;

	    public CreateNewCalendarPopup getCreateNewCalendarPopup() {
	        return createNewCalendarPopup;
	    }

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getNewEventButton() {
	        return newEventButton;
	    }

	    public WebElement getTodayButton() {
	        return todayButton;
	    }

	    public void selectTeamMember(int index){
	        select_dropdown_by_index(teamMemberDropDown, index);
	    }

	    public WebElement getGridContainer() {
	        return gridContainer;
	    }

	    public WebElement getDayButton() {
	        return dayButton;
	    }

	    public WebElement getWeekButton() {
	        return weekButton;
	    }

	    public WebElement getMonthButton() {
	        return monthButton;
	    }

	    public WebElement getRefreshLink() {
	        return refreshLink;
	    }

	    public WebElement getImportLink() {
	        return importLink;
	    }

	    public WebElement getExportLink() {
	        return exportLink;
	    }

	    public WebElement getCalHeader() {
	        return calHeader;
	    }

	    public WebElement getDayCalHeader() {
	        return dayCalHeader;
	    }

	    public WebElement getWeekCalHeader() {
	        return weekCalHeader;
	    }

	    public WebElement getMonthCalHeader() {
	        return monthCalHeader;
	    }

	    public WebElement getTodayItem() {
	        return todayItem;
	    }

	    public WebElement getEventPopup() {
	        return eventPopup;
	    }

	    public void inputEventName(String text) {
	        set_text(eventName, text);
	    }

	    public WebElement getCreateEventButton() {
	        return createEventButton;
	    }

	    public WebElement getFirstCreatedEvent() {
	        return firstCreatedEvent;
	    }

	    public WebElement getEditEventLink() {
	        return editEventLink;
	    }

	    public WebElement getDeleteEventLink() {
	        return deleteEventLink;
	    }

	    public WebElement getAutomatedNotificationsLink() {
	        return automatedNotificationsLink;
	    }

	    public WebElement getWeekDayName() {
	        return weekDayName;
	    }

	    public WebElement getDateTimeValue() {
	        return dateTimeValue;
	    }

	    public WebElement getPrevButton() {
	        return prevButton;
	    }

	    public WebElement getNextButton() {
	        return nextButton;
	    }

	    public WebElement getTooltip() {
	        return tooltip;
	    }

	    public WebElement getTooltipText() {
	        return tooltipText;
	    }

	    public void hoverHelpIcon(){
	        Actions builder = new Actions(webdriver);
	        builder.clickAndHold().moveToElement(tooltip);
	        builder.moveToElement(tooltip).build().perform();


	    }
	}

