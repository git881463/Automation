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
	 * Class representing Change Favourite Provider Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ChangeFavouriteProviderPopup extends AbstractBasePageObject<ChangeFavouriteProviderPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ChangeFavouriteProviderPopup.class);

	    private static final String relativeUrl = "/";

	    public ChangeFavouriteProviderPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the change favourite popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='modifyLink']//h1[contains(text(),'Favorite Provider')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "vOptionValue")
	    private WebElement providerName;

	    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
	    private WebElement saveButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public void inputProviderName(String text) {
	        set_text(providerName, text);
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }
	}

