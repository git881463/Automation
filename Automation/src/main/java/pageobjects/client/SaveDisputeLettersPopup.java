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
	 * Class representing Save Dispute Letters Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SaveDisputeLettersPopup extends AbstractBasePageObject<SaveDisputeLettersPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(SaveDisputeLettersPopup.class);

	    private static final String relativeUrl = "/";

	    public SaveDisputeLettersPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the save dispute letters popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'SAVE LETTER')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'SAVE LETTER')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "letter_name")
	    private WebElement name;

	    @FindBy(how = How.ID, using = "save_letter_button")
	    private WebElement saveButton;

	    public void inputName(String text) {
	        set_text(name, text);
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }
	}

