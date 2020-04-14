package pageobjects.invoice;

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
	 * Class representing Add Saved Invoice Items Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddSavedInvoiceItemsPopup extends AbstractBasePageObject<AddSavedInvoiceItemsPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(AddSavedInvoiceItemsPopup.class);

	    private static final String relativeUrl = "/";

	    public AddSavedInvoiceItemsPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add saved invoice items popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'ADD COMMON ITEM TO INVOICE')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'ADD COMMON ITEM TO INVOICE')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.CLASS_NAME, using = "gridtable")
	    private WebElement pageContainer;

	    @FindBy(how = How.ID, using = "checkallitem_all")
	    private WebElement checkAllItemsCheckBox;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[1]//input[@class='check_item']")
	    private WebElement firstSavedItemCheckBox;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[4]/a")
	    private WebElement firstSavedItemDeleteLink;

	    @FindBy(how = How.ID, using = "add_selected_item")
	    private WebElement addButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getCheckAllItemsCheckBox() {
	        return checkAllItemsCheckBox;
	    }

	    public WebElement getFirstSavedItemCheckBox() {
	        return firstSavedItemCheckBox;
	    }

	    public WebElement getFirstSavedItemDeleteLink() {
	        return firstSavedItemDeleteLink;
	    }

	    public WebElement getAddButton() {
	        return addButton;
	    }
	}
