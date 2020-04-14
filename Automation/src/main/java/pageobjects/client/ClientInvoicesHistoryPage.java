package pageobjects.client;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.invoice.EditInvoicePage;
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
	 * Class representing Client Invoices History Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientInvoicesHistoryPage extends AbstractBasePageObject<ClientInvoicesHistoryPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientInvoicesHistoryPage.class);

	    private static final String relativeUrl = "/invoices/client_invoices_history";

	    @Autowired
	    private MarkPaymentReceivedPopup markPaymentReceivedPopup;

	    @Autowired
	    private EditInvoicePage editInvoicePage;

	    public ClientInvoicesHistoryPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client invoices history page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    public void isLoadedWtihUrl(String urlEnding) throws Error {
	        isLoaded();
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the invoices history page: " + url, url.endsWith(urlEnding));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Invoices & Payments')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//td[contains(text(),'Client name')]//following-sibling::a")
	    private WebElement clientName;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Total outstanding')]")
	    private WebElement paymentInfoTotalOutstanding;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Past due')]")
	    private WebElement paymentInfoPastDue;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Paid in last 30 days')]")
	    private WebElement paymentInfoPaidInLast30Days;

	    @FindBy(how = How.ID, using = "vediopopup")
	    private WebElement quickVideoLink;

	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    @FindBy(how = How.XPATH, using = "//iframe[@class='fancybox-iframe']")
	    private WebElement videoOverlay;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[@class='addnew-btn']//a[contains(text(),'Create Invoice')]")
	    private WebElement createInvoiceButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[1]")
	    private WebElement invoicesContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[1]")
	    private WebElement firstInvoiceDate;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[2]/a")
	    private WebElement firstInvoiceNumberLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]/a[1]")
	    private WebElement firstInvoiceRecordPaymentLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]//a[contains(text(),'Preview')]")
	    private WebElement firstInvoicePreviewLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]//a[contains(text(),'More Actions')]")
	    private WebElement firstInvoiceMoreActionsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[7]")
	    private WebElement firstInvoiceStatusLabel;

	    @FindBy(how = How.ID, using = "filter")
	    private WebElement statusFilter;

	    public MarkPaymentReceivedPopup getMarkPaymentReceivedPopup() {
	        return markPaymentReceivedPopup;
	    }

	    public EditInvoicePage getEditInvoicePage() {
	        return editInvoicePage;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClientName() {
	        return clientName;
	    }

	    public WebElement getPaymentInfoTotalOutstanding() {
	        return paymentInfoTotalOutstanding;
	    }

	    public WebElement getPaymentInfoPastDue() {
	        return paymentInfoPastDue;
	    }

	    public WebElement getPaymentInfoPaidInLast30Days() {
	        return paymentInfoPaidInLast30Days;
	    }

	    public WebElement getQuickVideoLink() {
	        return quickVideoLink;
	    }

	    public WebElement getVideoPopup() {
	        return videoPopup;
	    }

	    public WebElement getVideoPopupCloseButton() {
	        return videoPopupCloseButton;
	    }

	    public WebElement getVideoOverlay() {
	        return videoOverlay;
	    }

	    public WebElement getCreateInvoiceButton() {
	        return createInvoiceButton;
	    }

	    public WebElement getInvoicesContainer() {
	        return invoicesContainer;
	    }

	    public WebElement getFirstInvoiceStatusLabel() {
	        return firstInvoiceStatusLabel;
	    }

	    public WebElement getFirstInvoiceRecordPaymentLink() {
	        return firstInvoiceRecordPaymentLink;
	    }

	    public WebElement getFirstInvoicePreviewLink() {
	        return firstInvoicePreviewLink;
	    }

	    public WebElement getFirstInvoiceMoreActionsLink() {
	        return firstInvoiceMoreActionsLink;
	    }

	    public WebElement getFirstInvoiceDate() {
	        return firstInvoiceDate;
	    }

	    public WebElement getFirstInvoiceNumberLink() {
	        return firstInvoiceNumberLink;
	    }

	    public WebElement getStatusFilter() {
	        return statusFilter;
	    }

	    public void selectStatus(String value){
	        select_dropdown_by_value(statusFilter, value);
	    }


	}
