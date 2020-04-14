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
	 * Class representing Client Dashboard Page Task Section Client Task Subsection within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageTaskSectionClientTaskSubSection extends AbstractBasePageObject<ClientDashboardPageTaskSectionClientTaskSubSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageTaskSectionClientTaskSubSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private CompletedClientTaskPopup completedClientTaskPopup;

	    @Autowired
	    private AddClientTaskPopup addClientTaskPopup;

	    @Autowired
	    private CompleteClientTaskPopup completeClientTaskPopup;

	    public ClientDashboardPageTaskSectionClientTaskSubSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard task section client task subsection page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='client-portal']")
	    private WebElement clientTasksContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='client-portal']//a[contains(text(),'View completed client tasks')]")
	    private WebElement viewCompletedClientTaskLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='client-portal']//a[contains(text(),'Add task for client')]")
	    private WebElement addClientTaskLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='client-portal']//table[@class='odd-even-table']//tr[1]/td[1]")
	    private WebElement addedTask;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//div[@class='task-tab']//div[@id='client-portal']//table[@class='odd-even-table']//tr[1]/td[2]//select")
	    private WebElement action;

	    public CompletedClientTaskPopup getCompletedClientTaskPopup() {
	        return completedClientTaskPopup;
	    }

	    public AddClientTaskPopup getAddClientTaskPopup() {
	        return addClientTaskPopup;
	    }

	    public CompleteClientTaskPopup getCompleteClientTaskPopup() {
	        return completeClientTaskPopup;
	    }

	    public WebElement getClientTasksContainer() {
	        return clientTasksContainer;
	    }

	    public WebElement getViewCompletedClientTaskLink() {
	        return viewCompletedClientTaskLink;
	    }

	    public WebElement getAddClientTaskLink() {
	        return addClientTaskLink;
	    }

	    public WebElement getAddedTask() {
	        return addedTask;
	    }

	    public void selectAction(String text){
	        select_dropdown_by_value(action, text);
	    }

	}
