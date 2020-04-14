package pageobjects.affiliates;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.FlashMessage;
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
	 * Class representing Affiliates Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AffiliatesPage extends AbstractBasePageObject<AffiliatesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AffiliatesPage.class);

	    private static final String relativeUrl = "/affiliate";

	    @Autowired
	    private AddAffiliatePage addAffiliatePage;

	    @Autowired
	    private EditAffiliatePage editAffiliatePage;

	    @Autowired
	    private AffiliatesDashboardPage affiliatesDashboardPage;

	    @Autowired
	    private InactivateOrDeleteAffiliatePopup inactivateOrDeleteAffiliatePopup;

	    @Autowired
	    private ImportAffiliatesPopup importAffiliatesPopup;

	    @Autowired
	    private PrintAffiliatesPopup printAffiliatesPopup;

	    @Autowired
	    private FlashMessage flashMessage;

	    public AffiliatesPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the affiliates page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Affiliate Partners')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='addnew-btn']//a[contains(text(),'Add New Affiliate')]")
	    private WebElement addNewAffiliatesButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']")
	    private WebElement partnersList;

	    @FindBy(how = How.ID, using = "aname")
	    private WebElement name;

	    @FindBy(how = How.ID, using = "aemail")
	    private WebElement email;

	    @FindBy(how = How.ID, using = "acompany")
	    private WebElement company;

	    @FindBy(how = How.ID, using = "qf")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "search")
	    private WebElement searchButton;

	    @FindBy(how = How.ID, using = "ImportCSV")
	    private WebElement importCSVlink;

	    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Export CSV')]")
	    private WebElement exportCSVlink;

	    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Afiliate Stats Dashboard')]")
	    private WebElement printLink;

	    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Afiliate Stats Dashboard')]")
	    private WebElement affiliateStatusDashboard;

	    @FindBy(how = How.XPATH, using = "//div[@class='pagercount']//span")
	    private WebElement pageCount;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]/td[9]/a[2]")
	    private WebElement firstAffiliateDeleteLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']/table/tbody/tr[2]")
	    private WebElement searchResult;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//tbody/tr[2]/td[1]/a")
	    private WebElement firstAffiliateName;

	    public InactivateOrDeleteAffiliatePopup getInactivateOrDeleteAffiliatePopup() {
	        return inactivateOrDeleteAffiliatePopup;
	    }

	    public ImportAffiliatesPopup getImportAffiliatesPopup() {
	        return importAffiliatesPopup;
	    }

	    public PrintAffiliatesPopup getPrintAffiliatesPopup() {
	        return printAffiliatesPopup;
	    }

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public AddAffiliatePage getAddAffiliatePage() {
	        return addAffiliatePage;
	    }

	    public EditAffiliatePage getEditAffiliatePage() {
	        return editAffiliatePage;
	    }

	    public AffiliatesDashboardPage getAffiliatesDashboardPage() {
	        return affiliatesDashboardPage;
	    }

	    public WebElement getFirstAffiliateDeleteLink() {
	        return firstAffiliateDeleteLink;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getPartnersList() {
	        return partnersList;
	    }

	    public WebElement getAddNewAffiliatesButton() {
	        return addNewAffiliatesButton;
	    }

	    public WebElement getName() {
	        return name;
	    }

	    public WebElement getEmail() {
	        return email;
	    }

	    public WebElement getCompany() {
	        return company;
	    }

	    public WebElement getStatus() {
	        return status;
	    }

	    public void inputName(String text) {
	        set_text(name, text);
	    }

	    public void inputEmail(String text) {
	        set_text(email, text);
	    }

	    public void inputCompany(String text) {
	        set_text(company, text);
	    }

	    public void selectStatus(String text){
	        select_dropdown_by_value(status, text);
	    }

	    public WebElement getSearchButton() {
	        return searchButton;
	    }

	    public WebElement getPageCount() {
	        return pageCount;
	    }

	    public WebElement getSearchResult() {
	        return searchResult;
	    }

	    public WebElement getImportCSVlink() {
	        return importCSVlink;
	    }

	    public WebElement getExportCSVlink() {
	        return exportCSVlink;
	    }

	    public WebElement getPrintLink() {
	        return printLink;
	    }

	    public WebElement getAffiliateStatusDashboard() {
	        return affiliateStatusDashboard;
	    }

	    public WebElement getFirstAffiliateName() {
	        return firstAffiliateName;
	    }
	}

