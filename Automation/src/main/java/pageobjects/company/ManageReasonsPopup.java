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
	 * Class representing Manage Reasons Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ManageReasonsPopup extends AbstractBasePageObject<ManageReasonsPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ManageReasonsPopup.class);

	    private static final String relativeUrl = "/";

	    public ManageReasonsPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the manage reasons popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Manage Reasons')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Manage Reasons')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "reason_name")
	    private WebElement reason;

	    @FindBy(how = How.ID, using = "add_reason")
	    private WebElement addButton;

	    @FindBy(how = How.XPATH, using = "(//table[1]/tbody/tr)[last()]//td[2]/a[4]")
	    private WebElement removeLastItemLink;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public void inputReason(String text) {
	        set_text(reason, text);
	    }

	    public WebElement getAddButton() {
	        return addButton;
	    }

	    public WebElement getRemoveLastItemLink() {
	        return removeLastItemLink;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }
	}

