package pageobjects.company;

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
	 * Class representing Invoice Options page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class InvoiceOptionsPage extends AbstractBasePageObject<InvoiceOptionsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(InvoiceOptionsPage.class);

	    private static final String relativeUrl = "/cpoption/";

	    @Autowired
	    private AddInvoiceOptionPopup addInvoiceOptionPopup;

	    @Autowired
	    private PreviewInvoicePopup previewInvoicePopup;

	    public InvoiceOptionsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the invoice options page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Invoice Options')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@id='add_option']/a")
	    private WebElement addOptionsButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='cpoption_place']//tbody/tr[2]/td[4]/a[2]")
	    private WebElement removeFirstOptionLink;

	    @FindBy(how = How.ID, using = "pdi")
	    private WebElement previewInvoiceButton;

	    public AddInvoiceOptionPopup getAddInvoiceOptionPopup() {
	        return addInvoiceOptionPopup;
	    }

	    public PreviewInvoicePopup getPreviewInvoicePopup() {
	        return previewInvoicePopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getAddOptionsButton() {
	        return addOptionsButton;
	    }

	    public WebElement getRemoveFirstOptionLink() {
	        return removeFirstOptionLink;
	    }

	    public WebElement getPreviewInvoiceButton() {
	        return previewInvoiceButton;
	    }
	}
