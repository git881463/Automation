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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Client Dashboard Page Invoice Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageInvoiceSection extends AbstractBasePageObject<ClientDashboardPageInvoiceSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageInvoiceSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private AddTeamTaskPopup addTeamTaskPopup;

	    public ClientDashboardPageInvoiceSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard invoice section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "invoice")
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoice']//a[contains(text(),'Chargebee Transaction History')]")
	    private WebElement chargebeeTxHistoryLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoice']//a[contains(text(),'click here')]")
	    private WebElement chargebeeContinueLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoice']/div[@class='balance']")
	    private WebElement balanceContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoice']/div[@class='balance']//span[@id='Total_Invoice']")
	    private WebElement totalInvoicedValue;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoice']/div[@class='balance']//span[@id='received_total']")
	    private WebElement receivedValue;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoice']/div[@class='balance']//span[@id='Total_Outstanding']")
	    private WebElement outstandingValue;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoice']/div[@class='balance']//span[@id='Past_Due']")
	    private WebElement pastDueValue;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoicetext']//a[contains(text(),'Create Invoice')]")
	    private WebElement createInvoiceLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoicetext']//a[contains(text(),'All Invoices')]")
	    private WebElement allInvoicesLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoicetext']//a[contains(text(),'Payments')]")
	    private WebElement paymentsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='invoicetext']//a[contains(text(),'New Task')]")
	    private WebElement newTaskLink;

	    public AddTeamTaskPopup getAddTeamTaskPopup() {
	        return addTeamTaskPopup;
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getChargebeeTxHistoryLink() {
	        return chargebeeTxHistoryLink;
	    }

	    public WebElement getChargebeeContinueLink() {
	        return chargebeeContinueLink;
	    }

	    public WebElement getBalanceContainer() {
	        return balanceContainer;
	    }

	    public WebElement getTotalInvoicedValue() {
	        return totalInvoicedValue;
	    }

	    public WebElement getReceivedValue() {
	        return receivedValue;
	    }

	    public WebElement getOutstandingValue() {
	        return outstandingValue;
	    }

	    public WebElement getPastDueValue() {
	        return pastDueValue;
	    }

	    public WebElement getCreateInvoiceLink() {
	        return createInvoiceLink;
	    }

	    public WebElement getAllInvoicesLink() {
	        return allInvoicesLink;
	    }

	    public WebElement getPaymentsLink() {
	        return paymentsLink;
	    }

	    public WebElement getNewTaskLink() {
	        return newTaskLink;
	    }
	}

