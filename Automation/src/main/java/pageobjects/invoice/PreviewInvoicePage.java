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
	 * Class representing Preview Invoice Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class PreviewInvoicePage extends AbstractBasePageObject<PreviewInvoicePage> {

	    private static final Logger logger = LoggerFactory.getLogger(PreviewInvoicePage.class);

	    private static final String relativeUrl = "/invoices/view";

	    @Autowired
	    private AddSavedInvoiceItemsPopup addSavedInvoiceItemsPopup;

	    public PreviewInvoicePage(WebDriver driver, WebDriverWait wait, String url) {
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

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'View Invoice')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "print_invoice")
	    private WebElement printInvoiceButton;

	    @FindBy(how = How.ID, using = "export_invoice_p")
	    private WebElement exportInvoiceButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getPrintInvoiceButton() {
	        return printInvoiceButton;
	    }

	    public WebElement getExportInvoiceButton() {
	        return exportInvoiceButton;
	    }
	}

