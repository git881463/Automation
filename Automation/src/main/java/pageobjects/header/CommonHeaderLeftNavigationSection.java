package pageobjects.header;

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
	 * Class representing Common Header left navigation in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CommonHeaderLeftNavigationSection extends AbstractBasePageObject<CommonHeaderLeftNavigationSection> {

	    private static final Logger logger = LoggerFactory.getLogger(CommonHeaderLeftNavigationSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private MessagePopup messagePopup;

	    public CommonHeaderLeftNavigationSection(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
//	        navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the common header left navigation section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "newlead")
	    private WebElement newLeadLink;

	    @FindBy(how = How.ID, using = "leadpopup")
	    private WebElement leadPopup;

	    @FindBy(how = How.ID, using = "count_new_lead")
	    private WebElement newLeadsCount;

	    @FindBy(how = How.ID, using = "newmsg")
	    private WebElement newMessageLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='newmsg']/span[@class='redflag message_count_place']")
	    private WebElement newMessagesCount;

	    @FindBy(how = How.ID, using = "newrem")
	    private WebElement newTasksAndEventsLink;

	    @FindBy(how = How.ID, using = "rempopup")
	    private WebElement tasksAndEventsPopup;

	    @FindBy(how = How.ID, using = "count_new_reminder")
	    private WebElement newTasksAndEventsCount;

	    @FindBy(how = How.ID, using = "newprint")
	    private WebElement printLink;

	    @FindBy(how = How.ID, using = "count_new_letter")
	    private WebElement newLettersCount;

	    private String xpathForNewLetterCounts = "//div[@id='count_new_letter']";

	    public MessagePopup getMessagePopup() {
	        return messagePopup;
	    }

	    public WebElement getNewLeadLink() {
	        return newLeadLink;
	    }

	    public WebElement getLeadPopup() {
	        return leadPopup;
	    }

	    public WebElement getNewLeadsCount() {
	        return newLeadsCount;
	    }

	    public WebElement getNewMessageLink() {
	        return newMessageLink;
	    }

	    public WebElement getNewMessagesCount() {
	        return newMessagesCount;
	    }

	    public WebElement getNewTasksAndEventsLink() {
	        return newTasksAndEventsLink;
	    }

	    public WebElement getTasksAndEventsPopup() {
	        return tasksAndEventsPopup;
	    }

	    public WebElement getNewTasksAndEventsCount() {
	        return newTasksAndEventsCount;
	    }

	    public WebElement getPrintLink() {
	        return printLink;
	    }

	    public WebElement getNewLettersCount() {
	        return newLettersCount;
	    }

	    public boolean isPrintPending(){
	        return isElementPresent(xpathForNewLetterCounts);
	    }
	}

