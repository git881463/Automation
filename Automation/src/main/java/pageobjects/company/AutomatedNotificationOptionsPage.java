package pageobjects.company;

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
	 * Class representing Automated Notification Options page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AutomatedNotificationOptionsPage extends AbstractBasePageObject<AutomatedNotificationOptionsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AutomatedNotificationOptionsPage.class);

	    private static final String relativeUrl = "/email_options";

	    public AutomatedNotificationOptionsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the automated notification options page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Automated Notification Options')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "cc")
	    private WebElement mailAsCC;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getMailAsCC() {
	        return mailAsCC;
	    }
	}

