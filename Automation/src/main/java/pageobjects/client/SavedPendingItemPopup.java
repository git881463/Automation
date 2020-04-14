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
	public class SavedPendingItemPopup extends AbstractBasePageObject<SavedPendingItemPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(SavedPendingItemPopup.class);

	    private static final String relativeUrl = "/";

	    public SavedPendingItemPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the saved/pending item popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'SAVED/PENDING ITEM')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.CLASS_NAME, using = "gridtable")
	    private WebElement pageContainer;

	    @FindBy(how = How.ID, using = "checkall_cred_furni")
	    private WebElement allCredFurnCheckBox;

	    @FindBy(how = How.ID, using = "select_dispute_item")
	    private WebElement continueButton;

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'SAVED ITEM')]")
	    private WebElement pageTitleRound2;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getPageTitleRound2() {
	        return pageTitleRound2;
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getAllCredFurnCheckBox() {
	        return allCredFurnCheckBox;
	    }

	    public WebElement getContinueButton() {
	        return continueButton;
	    }
	}
