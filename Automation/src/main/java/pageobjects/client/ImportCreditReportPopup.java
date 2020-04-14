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
	 * Class representing Import Credit Report Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ImportCreditReportPopup extends AbstractBasePageObject<ImportCreditReportPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ImportCreditReportPopup.class);

	    private static final String relativeUrl = "/";

	    public ImportCreditReportPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the import credit report popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Import Credit Report')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Import Credit Report')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.CLASS_NAME, using = "new-auto-import-box")
	    private WebElement newAutoImportButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='autoreportimport']//h3[contains(text(),'Enter & Confirm Credit Monitoring Access Details')]")
	    private WebElement nextPageHeader;

	    @FindBy(how = How.ID, using = "auto_selprovider")
	    private WebElement supportedProvider;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getNewAutoImportButton() {
	        return newAutoImportButton;
	    }

	    public WebElement getNextPageHeader() {
	        return nextPageHeader;
	    }

	    public void selectProvider(int index){
	        select_dropdown_by_index(supportedProvider, index);
	    }
	}
