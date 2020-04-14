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
	 * Class representing Activity Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ActivityPage extends AbstractBasePageObject<ActivityPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ActivityPage.class);

	    private static final String relativeUrl = "/report/index/";

	    @Autowired
	    private PrintActivityPopup printActivityPopup;

	    public ActivityPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the activity page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Credit Repair Activity Report')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "gridDisputeData")
	    private WebElement disputeDataContainer;

	    @FindBy(how = How.ID, using = "gridScoreData")
	    private WebElement creditScoreDataContainer;

	    @FindBy(how = How.ID, using = "gridInvoiceData")
	    private WebElement invoiceDataContainer;

	    @FindBy(how = How.ID, using = "report_print")
	    private WebElement printButton;

	    public PrintActivityPopup getPrintActivityPopup() {
	        return printActivityPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getDisputeDataContainer() {
	        return disputeDataContainer;
	    }

	    public WebElement getCreditScoreDataContainer() {
	        return creditScoreDataContainer;
	    }

	    public WebElement getInvoiceDataContainer() {
	        return invoiceDataContainer;
	    }

	    public WebElement getPrintButton() {
	        return printButton;
	    }
	}
