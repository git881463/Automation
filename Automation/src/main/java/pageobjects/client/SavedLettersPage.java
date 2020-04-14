package pageobjects.client;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.util.ArrayList;

	/**
	 * Class representing Saved Letters Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SavedLettersPage extends AbstractBasePageObject<SavedLettersPage> {

	    private static final Logger logger = LoggerFactory.getLogger(SavedLettersPage.class);

	    private static final String relativeUrl = "/userdesk/saved_letters/";

	    public SavedLettersPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the saved letters page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    public void isLoadedInTab() throws Error {
	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
	        String url = getDriver().getCurrentUrl();
	        logger.debug("url before: {}", url);
	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab

	        url = getDriver().getCurrentUrl();
	        logger.debug("url now: {}", url);
	        Assert.assertTrue("Not on the sample report page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	        getDriver().close();
	        webdriver.switchTo().window(tabs.get(0)); //switches to old tab
	    }

	}

