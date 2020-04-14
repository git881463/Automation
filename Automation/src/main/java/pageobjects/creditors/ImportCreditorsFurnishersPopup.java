package pageobjects.creditors;

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
	 * Class representing Import Creditors/Furnishers Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ImportCreditorsFurnishersPopup extends AbstractBasePageObject<ImportCreditorsFurnishersPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ImportCreditorsFurnishersPopup.class);

	    private static final String relativeUrl = "/";

	    public ImportCreditorsFurnishersPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the import creditors/furnishers popup: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Import furnishers from csv file')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Import furnishers from csv file')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "upload_csv")
	    private WebElement filePickerLink;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement importButton;

	    @FindBy(how = How.ID, using = "mainchk")
	    private WebElement selectAllRadio;

	    @FindBy(how = How.ID, using = "header_dd_0")
	    private WebElement companyName;

	    @FindBy(how = How.ID, using = "header_dd_1")
	    private WebElement address;

	    @FindBy(how = How.ID, using = "ImportFurn")
	    private WebElement importFurnishersButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getFilePickerLink() {
	        return filePickerLink;
	    }

	    public WebElement getImportButton() {
	        return importButton;
	    }

	    public WebElement getSelectAllRadio() {
	        return selectAllRadio;
	    }

	    public void selectCompanyName(String text){
	        select_dropdown_by_value(companyName, text);
	    }

	    public void selectAddress(String text){
	        select_dropdown_by_value(address, text);
	    }

	    public WebElement getImportFurnishersButton() {
	        return importFurnishersButton;
	    }
	}


