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
	 * Class representing Client Dashboard Page Dispute Status Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageDisputeStatusSection extends AbstractBasePageObject<ClientDashboardPageDisputeStatusSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageDisputeStatusSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private DocumentStoragePopup documentStoragePopup;

	    @Autowired
	    private SavedLettersPage savedLettersPage;

	    public ClientDashboardPageDisputeStatusSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard dispute status section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "statusbg")
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='statusbg']//div[@class='statuscontent']")
	    private WebElement statusContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='statusbg']//div[@class='chart2']")
	    private WebElement chartContainer;

	    @FindBy(how = How.ID, using = "bureau_drop_down")
	    private WebElement bureauDropdown;

	    @FindBy(how = How.XPATH, using = "//div[@class='statusbg']//div[@class='chart2']//div[@id='chart_div']")
	    private WebElement bureauChart;

	    @FindBy(how = How.XPATH, using = "//div[@class='statusbg']//a[contains(text(),'View/Update All Dispute Items')]")
	    private WebElement viewUpdateAllDisputeItemsButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='statusbg']//a[contains(text(),'Import Online Credit Reports')]")
	    private WebElement importOnlineCreditReportsButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='statusbg']//div[@class='chart2']//a[contains(text(),'Document Storage')]")
	    private WebElement documentStorageLink;

	    @FindBy(how = How.ID, using = "my_save_letter_pp")
	    private WebElement clientsSavedLettersLink;

	    public DocumentStoragePopup getDocumentStoragePopup() {
	        return documentStoragePopup;
	    }

	    public SavedLettersPage getSavedLettersPage() {
	        return savedLettersPage;
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getStatusContainer() {
	        return statusContainer;
	    }

	    public WebElement getChartContainer() {
	        return chartContainer;
	    }

	    public WebElement getViewUpdateAllDisputeItemsButton() {
	        return viewUpdateAllDisputeItemsButton;
	    }

	    public WebElement getImportOnlineCreditReportsButton() {
	        return importOnlineCreditReportsButton;
	    }

	    public void selectBureau(String text){
	        select_dropdown_by_value(bureauDropdown, text);
	    }

	    public WebElement getBureauChart() {
	        return bureauChart;
	    }

	    public WebElement getDocumentStorageLink() {
	        return documentStorageLink;
	    }

	    public WebElement getClientsSavedLettersLink() {
	        return clientsSavedLettersLink;
	    }
	}

