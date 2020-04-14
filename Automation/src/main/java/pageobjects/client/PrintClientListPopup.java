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
	 * Class representing Print Client List Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class PrintClientListPopup extends AbstractBasePageObject<PrintClientListPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(PrintClientListPopup.class);

	    private static final String relativeUrl = "/";

	    public PrintClientListPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the print client list popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "print_client_list_place" )
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-print_client_list_place']//a[@class='ui-dialog-titlebar-close ui-corner-all']" )
	    private WebElement closeButton;

	    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-print_client_list_place']//input[@id='btnok']" )
	    private WebElement okButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='print_client_list_place']//input[@id='btnprint']" )
	    private WebElement printButton;

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getCloseButton() {
	        return closeButton;
	    }

	    public WebElement getOkButton() {
	        return okButton;
	    }

	    public WebElement getPrintButton() {
	        return printButton;
	    }
	}
