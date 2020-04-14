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
	 * Class representing Unsaved letter Warning Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class UnsavedLetterWarningPopup extends AbstractBasePageObject<UnsavedLetterWarningPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(UnsavedLetterWarningPopup.class);

	    private static final String relativeUrl = "/";

	    public UnsavedLetterWarningPopup(WebDriver driver, WebDriverWait wait, String url ) {
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
	        Assert.assertTrue("Not on the unsaved letters warning popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    //https://devhints.io/xpath : Excellent Reference
	    @FindBy(how = How.XPATH, using="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons'][contains(@style, 'display: block')]")
	    private WebElement pageContainer;

	    @FindBy(how = How.ID, using="ui-dialog-title-preview_letter_place")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons'][contains(@style, 'display: block')]//div[@class='ui-dialog-buttonset']//span[contains(text(),'Save Letters')]")
	    private WebElement saveButton;

	    @FindBy(how = How.XPATH, using="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons'][contains(@style, 'display: block')]//div[@class='ui-dialog-buttonset']//span[contains(text(),'Leave Page')]")
	    private WebElement leaveButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }

	    public WebElement getLeaveButton() {
	        return leaveButton;
	    }
	}


