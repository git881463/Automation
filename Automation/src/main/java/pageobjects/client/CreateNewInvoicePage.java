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
	 * Class representing Create New Invoice Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CreateNewInvoicePage extends AbstractBasePageObject<CreateNewInvoicePage> {

	    private static final Logger logger = LoggerFactory.getLogger(CreateNewInvoicePage.class);

	    private static final String relativeUrl = "/invoices/add/";

	    public CreateNewInvoicePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the create new invoice page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='add_invoice_frm']//tbody[@id='invoiceitems']//input[@id='item_desc_1']")
	    private WebElement invoiceItemDescription;

	    @FindBy(how = How.XPATH, using = "//form[@id='add_invoice_frm']//tbody[@id='invoiceitems']//input[@id='item_price_1']")
	    private WebElement invoiceItemPrice;

	    @FindBy(how = How.XPATH, using = "//form[@id='add_invoice_frm']//input[@id='save_invoice']")
	    private WebElement saveInvoiceButton;

	    public void inputItemDescription(String text) {
	        set_text(invoiceItemDescription, text);
	    }

	    public void inputItemPrice(String text) {
	        set_text(invoiceItemPrice, text);
	    }

	    public WebElement getSaveInvoiceButton() {
	        return saveInvoiceButton;
	    }
	}
