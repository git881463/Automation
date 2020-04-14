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
	 * Class representing Import CSV Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ImportCSVPopup extends AbstractBasePageObject<ImportCSVPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ImportCSVPopup.class);

	    private static final String relativeUrl = "/";

	    public ImportCSVPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the import csv popup  page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Import clients from csv file')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "csvfrm")
	    private WebElement uploadForm;

	    @FindBy(how = How.XPATH, using = "html/body//form[@name='csvfrm']//input[@id='upload_csv']")
	    private WebElement filePickerLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='csvfrm']//a[@id='vediopopup']")
	    private WebElement quickVideoLink;

	    @FindBy(how = How.XPATH, using = "html/body//form[@name='csvfrm']//input[@id='submit']")
	    private WebElement importButton;

	    @FindBy(how = How.XPATH, using = "html/body//form[@name='frmgrid']//select[@id='header_dd_0']")
	    private WebElement selectFirstNameInput;

	    @FindBy(how = How.XPATH, using = "html/body//form[@name='frmgrid']//select[@id='header_dd_2']")
	    private WebElement selectLastNameInput;

	    @FindBy(how = How.XPATH, using = "html/body//form[@name='frmgrid']//select[@id='header_dd_4']")
	    private WebElement selectEmailInput;

	    @FindBy(how = How.XPATH, using = "html/body//form[@name='frmgrid']//input[@id='chk_2']")
	    private WebElement newClientCheckBox;

	    @FindBy(how = How.XPATH, using = "html/body//form[@name='frmgrid']//input[@id='ImportClients']")
	    private WebElement importClientsButton;

	    @FindBy(how = How.XPATH, using = "html/body//center/b[contains(text(),'Clients imported successfully')]")
	    private WebElement importSuccessMsg;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog-buttonset']/button")
	    private WebElement closePopupButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getUploadForm() {
	        return uploadForm;
	    }

	    public WebElement getFilePickerLink() {
	        return filePickerLink;
	    }

	    public WebElement getQuickVideoLink() {
	        return quickVideoLink;
	    }

	    public WebElement getImportButton() {
	        return importButton;
	    }

	    public WebElement getNewClientCheckBox() {
	        return newClientCheckBox;
	    }

	    public WebElement getImportClientsButton() {
	        return importClientsButton;
	    }

	    public void selectFirstName(){
	        select_dropdown_by_value(selectFirstNameInput, "FirstName");
	    }

	    public void selectLastName(){
	        select_dropdown_by_value(selectLastNameInput, "LastName");
	    }

	    public void selectEmail(){
	        select_dropdown_by_value(selectEmailInput, "Email");
	    }

	    public WebElement getImportSuccessMsg() {
	        return importSuccessMsg;
	    }

	    public WebElement getClosePopupButton() {
	        return closePopupButton;
	    }
	}
