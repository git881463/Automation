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
	 * Class representing Inactive or Delete Client Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class InactivateOrDeleteClientPopup extends AbstractBasePageObject<InactivateOrDeleteClientPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(InactivateOrDeleteClientPopup.class);

	    private static final String relativeUrl = "/";

	    public InactivateOrDeleteClientPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the inactivate client popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Inactive/Delete client')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "inactive_client")
	    private WebElement inactiveClientButton;

	    @FindBy(how = How.ID, using = "delete_client")
	    private WebElement deleteClientButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getInactiveClientButton() {
	        return inactiveClientButton;
	    }

	    public WebElement getDeleteClientButton() {
	        return deleteClientButton;
	    }
	}

