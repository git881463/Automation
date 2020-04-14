package pageobjects.home;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Class representing NewTask Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageTaskSectionNewTaskPopup extends AbstractBasePageObject<HomePageTaskSectionNewTaskPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageTaskSectionNewTaskPopup.class);

	    private static final String relativeUrl = "/home";

	    public HomePageTaskSectionNewTaskPopup(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        //navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the home page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']//span[contains(text(),'Reminder')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using="reminder-form2")
	    private WebElement container;

	    @FindBy(how = How.ID, using="remainder_type")
	    private WebElement taskType;

	    @FindBy(how = How.ID, using="subject_reminder")
	    private WebElement taskSubject;

	    @FindBy(how = How.ID, using="startdate_remainder")
	    private WebElement taskDueDate;

	    @FindBy(how = How.ID, using="starttime")
	    private WebElement taskStartTime;

	    @FindBy(how = How.ID, using="client_id")
	    private WebElement taskClientId;

	    @FindBy(how = How.ID, using="iTeam_id")
	    private WebElement taskTeamMember;

	    @FindBy(how = How.ID, using="remark")
	    private WebElement taskNotes;

	    @FindBy(how = How.ID, using="submit_reminder")
	    private WebElement saveButton;

	    @FindBy(how = How.ID, using="Closebtn")
	    private WebElement closeButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getContainer() {
	        return container;
	    }

	    public WebElement getTaskType() {
	        return taskType;
	    }

	    public WebElement getTaskSubject() {
	        return taskSubject;
	    }

	    public WebElement getTaskDueDate() {
	        return taskDueDate;
	    }

	    public WebElement getTaskStartTime() {
	        return taskStartTime;
	    }

	    public WebElement getTaskClientId() {
	        return taskClientId;
	    }

	    public WebElement getTaskTeamMember() {
	        return taskTeamMember;
	    }

	    public WebElement getTaskNotes() {
	        return taskNotes;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }

	    public WebElement getCloseButton() {
	        return closeButton;
	    }

	    public void setTaskSubject(String taskSubjectInput) {
	        set_text(taskSubject, taskSubjectInput);
	    }
	}

