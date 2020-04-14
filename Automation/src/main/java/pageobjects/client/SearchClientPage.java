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
	 * Class representing Search Client Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SearchClientPage extends AbstractBasePageObject<SearchClientPage> {

	    private static final Logger logger = LoggerFactory.getLogger(SearchClientPage.class);

	    private static final String relativeUrl = "/myclients/clientlist";

	    @Autowired
	    private SearchClientPageBasicSearchSection searchClientPageBasicSearchSection;

	    @Autowired
	    private SearchClientPageAdvancedSearchSection searchClientPageAdvancedSearchSection;

	    @Autowired
	    private SearchClientPageResultSection searchClientPageResultSection;

	    @Autowired
	    private ImportCSVPopup importCSVPopup;

	    @Autowired
	    private PrintClientListPopup printClientListPopup;

	    @Autowired
	    private InactivateOrDeleteClientPopup inactivateOrDeleteClientPopup;

	    public SearchClientPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the search client page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[contains(text(),'Search My Clients')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//td//a[@class='vediopopup']")
	    private WebElement watchQuickVideoLink;

	    @FindBy(how = How.ID, using = "filter_loader")
	    private WebElement filterLoader;

	    @FindBy(how = How.XPATH, using = "//div[@class='addnew-btn']//a")
	    private WebElement addNewClientLink;

	    @FindBy(how = How.ID, using = "quickfilter")
	    private WebElement quickFilterDropdown;

	    @FindBy(how = How.XPATH, using = "//div[@class='formboxtext']//a[@class='vediopopup']")
	    private WebElement findClientFasterVideoLink;

	    @FindBy(how = How.CLASS_NAME, using = "ImportCSV")
	    private WebElement importCSVLink;

	    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Export CSV')]")
	    private WebElement exportCSVLink;

	    @FindBy(how = How.CLASS_NAME, using = "print_client_list")
	    private WebElement printClientListLink;

	    @FindBy(how = How.ID, using = "delete_selected_client")
	    private WebElement deleteSelectedClientButton;

	    @FindBy(how = How.CLASS_NAME, using = "gridtable")
	    private WebElement clientTable;

	    @FindBy(how = How.XPATH, using = "//div[@class='pagercount']//span")
	    private WebElement pageCount;

	    //@FindBy(how = How.XPATH, using = "//a[@class='ytp-title-link yt-uix-sessionlink']")
	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    @FindBy(how = How.XPATH, using = "//iframe[@class='fancybox-iframe']")
	    private WebElement videoOverlay;

	    public SearchClientPageBasicSearchSection getSearchClientPageBasicSearchSection() {
	        return searchClientPageBasicSearchSection;
	    }

	    public SearchClientPageAdvancedSearchSection getSearchClientPageAdvancedSearchSection() {
	        return searchClientPageAdvancedSearchSection;
	    }

	    public SearchClientPageResultSection getSearchClientPageResultSection() {
	        return searchClientPageResultSection;
	    }

	    public ImportCSVPopup getImportCSVPopup() {
	        return importCSVPopup;
	    }

	    public PrintClientListPopup getPrintClientListPopup() {
	        return printClientListPopup;
	    }

	    public InactivateOrDeleteClientPopup getInactivateOrDeleteClientPopup() {
	        return inactivateOrDeleteClientPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getWatchQuickVideoLink() {
	        return watchQuickVideoLink;
	    }

	    public WebElement getFilterLoader() {
	        return filterLoader;
	    }

	    public WebElement getAddNewClientLink() {
	        return addNewClientLink;
	    }

	    public WebElement getQuickFilterDropdown() {
	        return quickFilterDropdown;
	    }

	    public WebElement getFindClientFasterVideoLink() {
	        return findClientFasterVideoLink;
	    }

	    public WebElement getImportCSVLink() {
	        return importCSVLink;
	    }

	    public WebElement getExportCSVLink() {
	        return exportCSVLink;
	    }

	    public WebElement getPrintClientListLink() {
	        return printClientListLink;
	    }

	    public WebElement getDeleteSelectedClientButton() {
	        return deleteSelectedClientButton;
	    }

	    public WebElement getClientTable() {
	        return clientTable;
	    }

	    public WebElement getPageCount() {
	        return pageCount;
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

	    public void selectQuickFilter(String text){
	        select_dropdown_by_value(quickFilterDropdown, text);
	    }

	}
