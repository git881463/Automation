package pageobjects.client;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Client Dashboard Page Task Section Team Task Subsection within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageTaskSectionTeamTaskSubSection extends AbstractBasePageObject<ClientDashboardPageTaskSectionTeamTaskSubSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageTaskSectionTeamTaskSubSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private CompletedTeamTaskPopup completedTeamTaskPopup;

	    @Autowired
	    private AddTeamTaskPopup addTeamTaskPopup;

	    public ClientDashboardPageTaskSectionTeamTaskSubSection(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the client dashboard task section team task subsection page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='internal']")
	    private WebElement teamTasksContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='internal']//a[contains(text(),'View completed tasks')]")
	    private WebElement viewCompletedTaskLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='internal']//td[@align='right']/a")
	    private WebElement addTaskLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='internal']//tr[2]/td[2]")
	    private WebElement addedTask;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='internal']//tr[2]/td[4]/a[2]")
	    private WebElement deleteNewlyAddedTaskLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='internal']//tr[2]/td[1]/input")
	    private WebElement completeNewlyAddedTaskCheckbox;

	    @FindBy(how = How.XPATH, using = "//div[@id='internal']//span[contains(text(),'No internal tasks for this client')]")
	    private WebElement noInternalTaskLabel;

	    public CompletedTeamTaskPopup getCompletedTeamTaskPopup() {
	        return completedTeamTaskPopup;
	    }

	    public AddTeamTaskPopup getAddTeamTaskPopup() {
	        return addTeamTaskPopup;
	    }

	    public WebElement getTeamTasksContainer() {
	        return teamTasksContainer;
	    }

	    public WebElement getViewCompletedTaskLink() {
	        return viewCompletedTaskLink;
	    }

	    public WebElement getAddTaskLink() {
	        return addTaskLink;
	    }

	    public WebElement getAddedTask() {
	        return addedTask;
	    }

	    public WebElement getDeleteNewlyAddedTaskLink() {
	        return deleteNewlyAddedTaskLink;
	    }

	    public WebElement getCompleteNewlyAddedTaskCheckbox() {
	        return completeNewlyAddedTaskCheckbox;
	    }

	    public WebElement getNoInternalTaskLabel() {
	        return noInternalTaskLabel;
	    }
	}
