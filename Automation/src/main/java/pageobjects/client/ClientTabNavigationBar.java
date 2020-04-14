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
	 * Client Tabs Navigation Bar to navigate across the client tabs.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientTabNavigationBar  extends AbstractBasePageObject<ClientTabNavigationBar> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientTabNavigationBar.class);

	    private static final String relativeUrl = "/";

	    public ClientTabNavigationBar(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
//	        navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the client tab navigation bar page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[1]/a")
	    private WebElement clientDashboardTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[2]/a")
	    private WebElement importAuditTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[3]/a")
	    private WebElement pendingReportTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[4]/a")
	    private WebElement disputeWizardTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[5]/a")
	    private WebElement disputeItemsTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[6]/a")
	    private WebElement educateTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[7]/a")
	    private WebElement messagesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[8]/a")
	    private WebElement internalNotesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[9]/a")
	    private WebElement invoicesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[10]/a")
	    private WebElement activityTab;

	    public WebElement getClientDashboardTab() {
	        return clientDashboardTab;
	    }

	    public WebElement getImportAuditTab() {
	        return importAuditTab;
	    }

	    public WebElement getPendingReportTab() {
	        return pendingReportTab;
	    }

	    public WebElement getDisputeWizardTab() {
	        return disputeWizardTab;
	    }

	    public WebElement getDisputeItemsTab() {
	        return disputeItemsTab;
	    }

	    public WebElement getEducateTab() {
	        return educateTab;
	    }

	    public WebElement getMessagesTab() {
	        return messagesTab;
	    }

	    public WebElement getInternalNotesTab() {
	        return internalNotesTab;
	    }

	    public WebElement getInvoicesTab() {
	        return invoicesTab;
	    }

	    public WebElement getActivityTab() {
	        return activityTab;
	    }
	}

