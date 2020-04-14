package pageobjects.company;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.automations.*;
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
	 * Class representing API and Automations page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class APIAndAutomationsPage extends AbstractBasePageObject<APIAndAutomationsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(APIAndAutomationsPage.class);

	    private static final String relativeUrl = "/webapi/";

	    @Autowired
	    private AutomationSideBarNavigator automationSideBarNavigator;

	    @Autowired
	    private AutomationsOverviewPage automationsOverviewPage;

	    @Autowired
	    private APICredentialsPage apiCredentialsPage;

	    @Autowired
	    private APIMethodsPage apiMethodsPage;

	    @Autowired
	    private APIErrorMessagesPage APIErrorMessagesPage;

	    @Autowired
	    private APIExamplesPage APIExamplesPage;

	    public APIAndAutomationsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the api & automations page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'API & Automations')]")
	    private WebElement pageTitle;

	    public AutomationSideBarNavigator getAutomationSideBarNavigator() {
	        return automationSideBarNavigator;
	    }

	    public AutomationsOverviewPage getAutomationsOverviewPage() {
	        return automationsOverviewPage;
	    }

	    public APICredentialsPage getApiCredentialsPage() {
	        return apiCredentialsPage;
	    }

	    public APIMethodsPage getApiMethodsPage() {
	        return apiMethodsPage;
	    }

	    public APIErrorMessagesPage getAPIErrorMessagesPage() {
	        return APIErrorMessagesPage;
	    }

	    public APIExamplesPage getAPIExamplesPage() {
	        return APIExamplesPage;
	    }
	}

