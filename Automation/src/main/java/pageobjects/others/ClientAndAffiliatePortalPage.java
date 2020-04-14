package pageobjects.others;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Class representing Client & Affiliate Portal Page in SecureClientAccess application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAndAffiliatePortalPage extends AbstractBasePageObject<ClientAndAffiliatePortalPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAndAffiliatePortalPage.class);

	    private static final String relativeUrl = "/";

	    public ClientAndAffiliatePortalPage(WebDriver driver, WebDriverWait wait, String url) {
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
//	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
//	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab

	        String url = webdriver.getCurrentUrl();
	        Assert.assertTrue("Not on the secureclientaccess page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }


	}
