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

	/**
	 * Class representing SavedOrPending Items Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MarkPaymentReceivedPopup extends AbstractBasePageObject<MarkPaymentReceivedPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(MarkPaymentReceivedPopup.class);

	    private static final String relativeUrl = "/";

	    public MarkPaymentReceivedPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the mark payment received popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'MARK PAYMENT AS RECEIVED')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "add_payment")
	    private WebElement addPaymentButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getAddPaymentButton() {
	        return addPaymentButton;
	    }
	}
