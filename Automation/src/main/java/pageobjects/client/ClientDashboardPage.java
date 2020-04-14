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

	import java.util.ArrayList;

	/**
	 * Class representing Client Dashboard Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPage extends AbstractBasePageObject<ClientDashboardPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPage.class);

	    private static final String relativeUrl = "/userdesk/index/";

	    @Autowired
	    private ClientDashboardPageClientSection clientDashboardPageClientSection;

	    @Autowired
	    private ClientDashboardPageContactSection clientDashboardPageContactSection;

	    @Autowired
	    private ClientDashboardPageDisputeStatusSection clientDashboardPageDisputeStatusSection;

	    @Autowired
	    private ClientDashboardPageDocumentSection clientDashboardPageDocumentSection;

	    @Autowired
	    private ClientDashboardPageInvoiceSection clientDashboardPageInvoiceSection;

	    @Autowired
	    private ClientDashboardPageMemoSection clientDashboardPageMemoSection;

	    @Autowired
	    private ClientDashboardPageScoreSection clientDashboardPageScoreSection;

	    @Autowired
	    private ClientDashboardPageTaskSection clientDashboardPageTaskSection;

	    public ClientDashboardPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    public void isLoadedInTab() throws Error {
	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
	        String url = getDriver().getCurrentUrl();
	        logger.debug("url before: {}", url);
	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab

	        url = getDriver().getCurrentUrl();
	        logger.debug("url now: {}", url);
	        Assert.assertTrue("Not on the sample report page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	        getDriver().close();
	        webdriver.switchTo().window(tabs.get(0)); //switches to old tab
	    }

	    @FindBy(how = How.ID, using = "email-confirm")
	    private WebElement clientEmail;

	    public ClientDashboardPageClientSection getClientDashboardPageClientSection() {
	        return clientDashboardPageClientSection;
	    }

	    public ClientDashboardPageContactSection getClientDashboardPageContactSection() {
	        return clientDashboardPageContactSection;
	    }

	    public ClientDashboardPageDisputeStatusSection getClientDashboardPageDisputeStatusSection() {
	        return clientDashboardPageDisputeStatusSection;
	    }

	    public ClientDashboardPageDocumentSection getClientDashboardPageDocumentSection() {
	        return clientDashboardPageDocumentSection;
	    }

	    public ClientDashboardPageInvoiceSection getClientDashboardPageInvoiceSection() {
	        return clientDashboardPageInvoiceSection;
	    }

	    public ClientDashboardPageMemoSection getClientDashboardPageMemoSection() {
	        return clientDashboardPageMemoSection;
	    }

	    public ClientDashboardPageScoreSection getClientDashboardPageScoreSection() {
	        return clientDashboardPageScoreSection;
	    }

	    public ClientDashboardPageTaskSection getClientDashboardPageTaskSection() {
	        return clientDashboardPageTaskSection;
	    }

	    public WebElement getClientEmail() {
	        return clientEmail;
	    }
	}
