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
	 * Class representing Chargebee Settings page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ChargebeeSettingsPage extends AbstractBasePageObject<ChargebeeSettingsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ChargebeeSettingsPage.class);

	    private static final String relativeUrl = "/chargebee_settings";

	    public ChargebeeSettingsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the chargebee settings page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Have a Merchant Account for Credit Repair')]//following-sibling::a[2]")
	    private WebElement closeOverlayLink;

	    @FindBy(how = How.ID, using = "first_cb_text")
	    private WebElement chargebeeIntegrationButton;

	    public WebElement getCloseOverlayLink() {
	        return closeOverlayLink;
	    }

	    public WebElement getChargebeeIntegrationButton() {
	        return chargebeeIntegrationButton;
	    }
	}

