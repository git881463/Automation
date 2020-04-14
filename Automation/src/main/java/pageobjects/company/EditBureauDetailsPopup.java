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
	 * Class representing Edit Bureau Details Popup page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditBureauDetailsPopup extends AbstractBasePageObject<EditBureauDetailsPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(EditBureauDetailsPopup.class);

	    private static final String relativeUrl = "/";

	    public EditBureauDetailsPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the edit bureau details popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'][contains(@style, 'display: block')]//span[contains(text(),'Edit Bureau Details')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'][contains(@style, 'display: block')]//span[contains(text(),'Edit Bureau Details')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "bureau_1")
	    private WebElement address;

	    @FindBy(how = How.ID, using = "submit_dispute_item")
	    private WebElement saveChangesButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getAddress() {
	        return address;
	    }

	    public void inputAddress(String text) {
	        set_text(address, text);
	    }


	    public WebElement getSaveChangesButton() {
	        return saveChangesButton;
	    }
	}
