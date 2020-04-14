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
	 * Class representing Document Storage Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DocumentStoragePopup extends AbstractBasePageObject<DocumentStoragePopup> {

	    private static final Logger logger = LoggerFactory.getLogger(DocumentStoragePopup.class);

	    private static final String relativeUrl = "/";

	    public DocumentStoragePopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the document storage popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Document Storage')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Document Storage')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='pdf_upload']//input[@id='pdf_file']")
	    private WebElement filePickerLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='pdf_upload']//input[@id='submit']")
	    private WebElement submitButton;


	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getFilePickerLink() {
	        return filePickerLink;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }
	}

