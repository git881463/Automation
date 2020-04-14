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
	 * Class representing Client Affiliate Portal page Clients Choice section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPageClientsChoiceSection  extends AbstractBasePageObject<ClientAffiliatePortalPageClientsChoiceSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPageClientsChoiceSection.class);

	    private static final String relativeUrl = "/";

	    public ClientAffiliatePortalPageClientsChoiceSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal page clients choice section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "client_choice_control_on")
	    private WebElement clientChoiceOnRadio;

	    @FindBy(how = How.ID, using = "client_choice_control_off")
	    private WebElement clientChoiceOffRadio;

	    public WebElement getClientChoiceOnRadio() {
	        return clientChoiceOnRadio;
	    }

	    public WebElement getClientChoiceOffRadio() {
	        return clientChoiceOffRadio;
	    }
	}

