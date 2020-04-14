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
	 * Class representing Edit Invoice Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditInvoicePage extends AbstractBasePageObject<EditInvoicePage> {

	    private static final Logger logger = LoggerFactory.getLogger(EditInvoicePage.class);

	    private static final String relativeUrl = "/invoices/edit";

	    public EditInvoicePage(WebDriver driver, WebDriverWait wait, String url) {
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

	    @FindBy(how = How.XPATH, using = "//form[@id='edit_invoice_frm']//div[contains(text(),'Edit Invoice')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "payment_due_term")
	    private WebElement paymentDueTerm;

	    @FindBy(how = How.ID, using = "save_invoice")
	    private WebElement saveInvoiceButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getPaymentDueTerm() {
	        return paymentDueTerm;
	    }

	    public void inputPaymentDueTerm(String text) {
	        set_text(paymentDueTerm, text);
	    }

	    public WebElement getSaveInvoiceButton() {
	        return saveInvoiceButton;
	    }
	}

