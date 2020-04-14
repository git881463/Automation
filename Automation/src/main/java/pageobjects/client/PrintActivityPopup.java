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
	 * Class representing Print Activity Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class PrintActivityPopup extends AbstractBasePageObject<PrintActivityPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(PrintActivityPopup.class);

	    private static final String relativeUrl = "/";

	    public PrintActivityPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the print activity popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[text()='Print Preview']")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[text()='Print Preview']//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.XPATH, using = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[text()='Ok']")
	    private WebElement okButton;

	    @FindBy(how = How.XPATH, using = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[text()='Print']")
	    private WebElement printButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getOkButton() {
	        return okButton;
	    }

	    public WebElement getPrintButton() {
	        return printButton;
	    }
	}

