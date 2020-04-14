package pageobjects.affiliates;

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
	 * Class representing Import Affiliates Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ImportAffiliatesPopup extends AbstractBasePageObject<ImportAffiliatesPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ImportAffiliatesPopup.class);

	    private static final String relativeUrl = "/";

	    public ImportAffiliatesPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the import affiliates popup: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Import affiliates from csv file')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Import affiliates from csv file')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "upload_csv")
	    private WebElement filePickerLink;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement importButton;

	    @FindBy(how = How.ID, using = "inactive")
	    private WebElement importAsInactive;

	    @FindBy(how = How.ID, using = "mainchk")
	    private WebElement selectAllRadio;

	    @FindBy(how = How.ID, using = "header_dd_0")
	    private WebElement firstName;

	    @FindBy(how = How.ID, using = "header_dd_1")
	    private WebElement lastName;

	    @FindBy(how = How.ID, using = "header_dd_2")
	    private WebElement company;

	    @FindBy(how = How.ID, using = "header_dd_3")
	    private WebElement email;


	    @FindBy(how = How.ID, using = "ImportAffiliates")
	    private WebElement importAffiliatesButton;

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

	    public WebElement getImportAffiliatesButton() {
	        return importAffiliatesButton;
	    }

	    public WebElement getImportAsInactive() {
	        return importAsInactive;
	    }

	    public WebElement getSelectAllRadio() {
	        return selectAllRadio;
	    }

	    public void selectFirstName(String text){
	        select_dropdown_by_value(firstName, text);
	    }
	    public void selectLastName(String text){
	        select_dropdown_by_value(lastName, text);
	    }
	    public void selectCompany(String text){
	        select_dropdown_by_value(company, text);
	    }
	    public void selectEmail(String text){
	        select_dropdown_by_value(email, text);
	    }

	}

