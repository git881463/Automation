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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Add Invoice Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddInvoicePage extends AbstractBasePageObject<AddInvoicePage> {

	    private static final Logger logger = LoggerFactory.getLogger(AddInvoicePage.class);

	    private static final String relativeUrl = "/invoices/add";

	    @Autowired
	    private AddSavedInvoiceItemsPopup addSavedInvoiceItemsPopup;

	    public AddInvoicePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add invoice page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='add_invoice_frm']//div[contains(text(),'New Invoice')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//form[@id='add_invoice_frm']//div[@class='chbox']//p/strong[contains(text(),'Warning')]")
	    private WebElement chargebeeWarning;

	    @FindBy(how = How.ID, using = "ref_no")
	    private WebElement reference;

	    @FindBy(how = How.ID, using = "sname")
	    private WebElement clientName;

	    @FindBy(how = How.ID, using = "payment_due_term")
	    private WebElement termInDays;

	    @FindBy(how = How.XPATH, using = "//li[@class='ui-menu-item']/a")
	    private WebElement clientNameSelectionMenu;

	    @FindBy(how = How.ID, using = "item_desc_1")
	    private WebElement itemDescription;

	    @FindBy(how = How.ID, using = "savef_1")
	    private WebElement saveForFutureCheckbox;

	    @FindBy(how = How.ID, using = "item_price_1")
	    private WebElement itemPrice;

	    @FindBy(how = How.XPATH, using = "//tbody[@id='invoiceitems']/tr[1]//a")
	    private WebElement deleteBlankItemLink;

	    @FindBy(how = How.ID, using = "addnewitem")
	    private WebElement addNewItemButton;

	    @FindBy(how = How.ID, using = "disp_add_invoice")
	    private WebElement addSavedInvoiceItemButton;

	    @FindBy(how = How.ID, using = "save_invoice")
	    private WebElement saveInvoiceButton;

	    public AddSavedInvoiceItemsPopup getAddSavedInvoiceItemsPopup() {
	        return addSavedInvoiceItemsPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getChargebeeWarning() {
	        return chargebeeWarning;
	    }

	    public WebElement getReference() {
	        return reference;
	    }

	    public WebElement getTermInDays() {
	        return termInDays;
	    }

	    public void inputReference(String text) {
	        set_text(reference, text);
	    }

	    public void inputClientName(String text) {
	        set_text(clientName, text);
	    }

	    public void inputTermInDays(String text) {
	        set_text(termInDays, text);
	    }

	    public WebElement getClientNameSelectionMenu() {
	        return clientNameSelectionMenu;
	    }

	    public void inputItemDescription(String text) {
	        set_text(itemDescription, text);
	    }

	    public WebElement getSaveForFutureCheckbox() {
	        return saveForFutureCheckbox;
	    }

	    public void inputItemPrice(String text) {
	        set_text(itemPrice, text);
	    }

	    public WebElement getDeleteBlankItemLink() {
	        return deleteBlankItemLink;
	    }

	    public WebElement getAddNewItemButton() {
	        return addNewItemButton;
	    }

	    public WebElement getAddSavedInvoiceItemButton() {
	        return addSavedInvoiceItemButton;
	    }

	    public WebElement getSaveInvoiceButton() {
	        return saveInvoiceButton;
	    }

	}
