package pageobjects.automations;

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
	 * Class representing API & Automations Sidebar Navigator in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AutomationSideBarNavigator extends AbstractBasePageObject<AutomationSideBarNavigator> {

	    private static final Logger logger = LoggerFactory.getLogger(AutomationSideBarNavigator.class);

	    private static final String relativeUrl = "/";

	    public AutomationSideBarNavigator(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the automations side bar navigator page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='api']/ul//a[contains(text(),'Overview')]")
	    private WebElement overviewLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='api']/ul//a[contains(text(),'API Credentials')]")
	    private WebElement apiCredentialsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='api']/ul//a[contains(text(),'API Methods')]")
	    private WebElement apiMethodsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='api']/ul//a[contains(text(),'Error Messages')]")
	    private WebElement errorMessagesLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='api']/ul//a[contains(text(),'Examples')]")
	    private WebElement examplesLink;

	    public WebElement getOverviewLink() {
	        return overviewLink;
	    }

	    public WebElement getApiCredentialsLink() {
	        return apiCredentialsLink;
	    }

	    public WebElement getApiMethodsLink() {
	        return apiMethodsLink;
	    }

	    public WebElement getErrorMessagesLink() {
	        return errorMessagesLink;
	    }

	    public WebElement getExamplesLink() {
	        return examplesLink;
	    }
	}

