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
	 * Class representing My Invoices Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MyInvoicesPage extends AbstractBasePageObject<MyInvoicesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(MyInvoicesPage.class);

	    private static final String relativeUrl = "/invoices";

	    @Autowired
	    private AddInvoicePage addInvoicePage;

	    @Autowired
	    private PreviewInvoicePage previewInvoicePage;

	    @Autowired
	    private BillingRemindersPopup billingRemindersPopup;

	    public MyInvoicesPage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    public void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the my invoices page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Invoices (all clients)')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "vediopopup")
	    private WebElement quickVideoLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[@class='addnew-btn']//a[contains(text(),'Create Invoice')]")
	    private WebElement createInvoiceButton;

	    @FindBy(how = How.ID, using = "sname")
	    private WebElement clientNameOrEmail;

	    @FindBy(how = How.ID, using = "advancedlink")
	    private WebElement advancedSearchLink;

	    @FindBy(how = How.ID, using = "invoice_from_date")
	    private WebElement invoiceFromDate;

	    @FindBy(how = How.ID, using = "invoice_no")
	    private WebElement invoiceNumber;

	    @FindBy(how = How.ID, using = "invoice_ref_no")
	    private WebElement invoiceReferenceNumber;

	    @FindBy(how = How.ID, using = "txtdue")
	    private WebElement termInDays;

	    @FindBy(how = How.ID, using = "search_filter")
	    private WebElement searchButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[1]/td[1]")
	    private WebElement searchResultContainerHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[1]/a")
	    private WebElement firstClientName;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[2]//a")
	    private WebElement firstClientInvoiceStatusLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[3]/a[2]")
	    private WebElement firstClientInvoiceReminderLink;

	    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Total Outstanding')]")
	    private WebElement totalOutstandingLabel;

	    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Past Due')]")
	    private WebElement pastDueLabel;

	    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Paid in last 30 days')]")
	    private WebElement paidInLast30Days;

	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    public AddInvoicePage getAddInvoicePage() {
	        return addInvoicePage;
	    }

	    public PreviewInvoicePage getPreviewInvoicePage() {
	        return previewInvoicePage;
	    }

	    public BillingRemindersPopup getBillingRemindersPopup() {
	        return billingRemindersPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getQuickVideoLink() {
	        return quickVideoLink;
	    }

	    public WebElement getCreateInvoiceButton() {
	        return createInvoiceButton;
	    }

	    public void inputClientNameOrEmail(String text) {
	        set_text(clientNameOrEmail, text);
	    }

	    public WebElement getSearchButton() {
	        return searchButton;
	    }

	    public WebElement getFirstClientName() {
	        return firstClientName;
	    }

	    public WebElement getFirstClientInvoiceStatusLink() {
	        return firstClientInvoiceStatusLink;
	    }

	    public WebElement getSearchResultContainerHeader() {
	        return searchResultContainerHeader;
	    }

	    public WebElement getTotalOutstandingLabel() {
	        return totalOutstandingLabel;
	    }

	    public WebElement getPastDueLabel() {
	        return pastDueLabel;
	    }

	    public WebElement getPaidInLast30Days() {
	        return paidInLast30Days;
	    }

	    public WebElement getAdvancedSearchLink() {
	        return advancedSearchLink;
	    }

	    public WebElement getInvoiceFromDate() {
	        return invoiceFromDate;
	    }

	    public WebElement getInvoiceNumber() {
	        return invoiceNumber;
	    }

	    public void inputFromDate(String text) {
	        set_text(invoiceFromDate, text);
	    }

	    public void inputInvoiceNumber(String text) {
	        set_text(invoiceNumber, text);
	    }

	    public WebElement getInvoiceReferenceNumber() {
	        return invoiceReferenceNumber;
	    }

	    public WebElement getTermInDays() {
	        return termInDays;
	    }

	    public void inputInvoiceReferenceNumber(String text) {
	        set_text(invoiceReferenceNumber, text);
	    }

	    public void inputTermInDays(String text) {
	        set_text(termInDays, text);
	    }


	    public WebElement getVideoPopup() {
	        return videoPopup;
	    }

	    public WebElement getVideoPopupCloseButton() {
	        return videoPopupCloseButton;
	    }

	    public WebElement getFirstClientInvoiceReminderLink() {
	        return firstClientInvoiceReminderLink;
	    }
	}
