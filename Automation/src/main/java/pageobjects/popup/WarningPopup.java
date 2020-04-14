package pageobjects.popup;

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
	 * Class representing Warning Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class WarningPopup extends AbstractBasePageObject<WarningPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(WarningPopup.class);

	    private static final String relativeUrl = "/";

	    public WarningPopup(WebDriver driver, WebDriverWait wait, String url ) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        //navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the warning popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using="jconfirm-box-container")
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using="//div[@class='jconfirm-box-container']//div[contains(text(),'Are you sure')]")
	    private WebElement warningMessage;

	    @FindBy(how = How.XPATH, using="//div[@class='jconfirm-box-container']//button[text()='OK']")
	    private WebElement okButton;

	    @FindBy(how = How.XPATH, using="//div[@class='jconfirm-box-container']//button[text()='Cancel']")
	    private WebElement cancelButton;

	    @FindBy(how = How.XPATH, using="//div[@class='jconfirm-box-container']")
	    private WebElement warningMessageContainer;

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getWarningMessage() {
	        return warningMessage;
	    }

	    public WebElement getWarningMessageContainer() {
	        return warningMessageContainer;
	    }

	    public WebElement getOkButton() {
	        return okButton;
	    }

	    public WebElement getCancelButton() {
	        return cancelButton;
	    }
	}


