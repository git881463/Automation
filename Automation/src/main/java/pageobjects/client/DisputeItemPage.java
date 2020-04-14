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
	 * Class representing Dispute Items List View Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeItemPage extends AbstractBasePageObject<DisputeItemPage> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeItemPage.class);

	    private static final String relativeUrl = "/userdesk/disputedetail/";

	    @Autowired
	    private EditDisputeItemPopup editDisputeItemPopup;

	    @Autowired
	    private AddDisputeItemPage addDisputeItemPage;

	    public DisputeItemPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute items list view page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'All Dispute Items')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "vediopopup")
	    private WebElement quickVideoLink;

	    @FindBy(how = How.ID, using = "add_new_dispute_item")
	    private WebElement addNewItemButton;

	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//div[@class='gridtable']")
	    private WebElement disputeItemsContainer;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']//a[contains(text(),'run Wizard 3')]")
	    private WebElement runWizrd3Link;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']/ul/li[contains(text(),'List View')]")
	    private WebElement listViewTab;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']/ul/li[contains(text(),'Report View')]")
	    private WebElement reportViewTab;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//div[@class='gridtable']/table[@id='gridtable_tbl']//tr[2]/td[8]/a[1]")
	    private WebElement firstItemEditLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//div[@class='gridtable']/table[@id='gridtable_tbl']//tr[2]/td[8]/a[2]")
	    private WebElement firstItemDeleteLink;

	    public EditDisputeItemPopup getEditDisputeItemPopup() {
	        return editDisputeItemPopup;
	    }

	    public AddDisputeItemPage getAddDisputeItemPage() {
	        return addDisputeItemPage;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getQuickVideoLink() {
	        return quickVideoLink;
	    }

	    public WebElement getAddNewItemButton() {
	        return addNewItemButton;
	    }

	    public WebElement getVideoPopup() {
	        return videoPopup;
	    }

	    public WebElement getVideoPopupCloseButton() {
	        return videoPopupCloseButton;
	    }

	    public WebElement getDisputeItemsContainer() {
	        return disputeItemsContainer;
	    }

	    public WebElement getRunWizrd3Link() {
	        return runWizrd3Link;
	    }

	    public WebElement getListViewTab() {
	        return listViewTab;
	    }

	    public WebElement getReportViewTab() {
	        return reportViewTab;
	    }

	    public WebElement getFirstItemEditLink() {
	        return firstItemEditLink;
	    }

	    public WebElement getFirstItemDeleteLink() {
	        return firstItemDeleteLink;
	    }
	}
