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
	 * Class representing Dispute Items Report View Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeItemReportViewPage extends AbstractBasePageObject<DisputeItemReportViewPage> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeItemReportViewPage.class);

	    private static final String relativeUrl = "/userdesk/disputedetailcr/";

	    public DisputeItemReportViewPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute items report view page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'All Dispute Items')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']/ul/li[contains(text(),'List View')]")
	    private WebElement listViewTab;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']/ul/li[contains(text(),'Report View')]")
	    private WebElement reportViewTab;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']//div[@class='chbox normaltext1']")
	    private WebElement reportViewNotice;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']//a[contains(text(),'run the Dispute Wizard')]")
	    private WebElement runDisputeWizardLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']//a[contains(text(),'See video demo')]")
	    private WebElement seeVideoDemoLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']//a[contains(text(),'Dashboard')]")
	    private WebElement dashboardLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']//a[contains(text(),'Saved Letters')]")
	    private WebElement savedLettersLink;

	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    @FindBy(how = How.ID, using = "frm_dispute_list")
	    private WebElement manuallyEntereedItemsForm;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getListViewTab() {
	        return listViewTab;
	    }

	    public WebElement getReportViewTab() {
	        return reportViewTab;
	    }

	    public WebElement getReportViewNotice() {
	        return reportViewNotice;
	    }

	    public WebElement getRunDisputeWizardLink() {
	        return runDisputeWizardLink;
	    }

	    public WebElement getSeeVideoDemoLink() {
	        return seeVideoDemoLink;
	    }

	    public WebElement getDashboardLink() {
	        return dashboardLink;
	    }

	    public WebElement getSavedLettersLink() {
	        return savedLettersLink;
	    }

	    public WebElement getManuallyEntereedItemsForm() {
	        return manuallyEntereedItemsForm;
	    }

	    public WebElement getVideoPopup() {
	        return videoPopup;
	    }

	    public WebElement getVideoPopupCloseButton() {
	        return videoPopupCloseButton;
	    }
	}
