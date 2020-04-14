package pageobjects.others;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.util.ArrayList;

	/**
	 * Class representing Business Website Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class BusinessWebsitePage extends AbstractBasePageObject<BusinessWebsitePage> {

	    private static final Logger logger = LoggerFactory.getLogger(BusinessWebsitePage.class);

	    private static final String relativeUrl = "/";

	    public BusinessWebsitePage(WebDriver driver, WebDriverWait wait, String url) {
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
	    public void isLoaded() throws Error {//Opens in new tab
	        //((JavascriptExecutor)webdriver).executeScript("window.open()");

	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab

	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the business website page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	        webdriver.switchTo().window(tabs.get(0)); //switches to old tab
	    }

	}

