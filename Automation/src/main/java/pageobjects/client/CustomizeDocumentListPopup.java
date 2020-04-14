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
	 * Class representing Customize Document List Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CustomizeDocumentListPopup extends AbstractBasePageObject<CustomizeDocumentListPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(CustomizeDocumentListPopup.class);

	    private static final String relativeUrl = "/";

	    public CustomizeDocumentListPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the customize document list popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'New Client Checklist')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//form[@id='addppr']//input[@id='n_item']")
	    private WebElement newDocumentInput;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//form[@id='addppr']//input[@id='add']")
	    private WebElement addButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'New Client Checklist')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='paperwork_issued_form']//following-sibling::td[contains(text(),'SampleDoc')]")
	    private WebElement newlyAddedDoc;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='paperwork_issued_form']//following-sibling::a")
	    private WebElement removeNewlyAddedDocLink;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public void inputDocumentName(String text) {
	        set_text(newDocumentInput, text);
	    }

	    public WebElement getAddButton() {
	        return addButton;
	    }

	    public WebElement getNewlyAddedDoc() {
	        return newlyAddedDoc;
	    }

	    public WebElement getRemoveNewlyAddedDocLink() {
	        return removeNewlyAddedDocLink;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }
	}

