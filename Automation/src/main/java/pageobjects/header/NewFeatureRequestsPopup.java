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

	/**
	 * Class representing New Feature Request Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class NewFeatureRequestsPopup extends AbstractBasePageObject<NewFeatureRequestsPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(NewFeatureRequestsPopup.class);

	    private static final String relativeUrl = "/";

	    public NewFeatureRequestsPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the new feature requests popup: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "uvw-dialog-uv-1")
	    private WebElement container;

	    @FindBy(how = How.ID, using = "uvw-dialog-close-uv-1")
	    private WebElement closeButton;

	    public WebElement getContainer() {
	        return container;
	    }

	    public WebElement getCloseButton() {
	        return closeButton;
	    }
	}

