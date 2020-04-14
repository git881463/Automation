package pageobjects.header;

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
	 * Class representing Common Header tabbed navigation in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CommonHeaderTabNavigationBar extends AbstractBasePageObject<CommonHeaderTabNavigationBar> {

	    private static final Logger logger = LoggerFactory.getLogger(CommonHeaderTabNavigationBar.class);

	    private static final String relativeUrl = "/";

	    public CommonHeaderTabNavigationBar(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the common header tab navigation bar page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'Home')]")
	    private WebElement homeTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'My Clients')]")
	    private WebElement myClientsTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'My Schedule')]")
	    private WebElement myScheduleTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'My Company')]")
	    private WebElement myCompanyTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'My Invoices')]")
	    private WebElement myInvoicesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'My Library')]")
	    private WebElement myLibraryTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'My Affiliates')]")
	    private WebElement myAffiliatesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'Creditors')]")
	    private WebElement creditorsTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'Everything')]")
	    private WebElement everythingTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='middlemenu']//a[contains(text(),'Dashboard')]")
	    private WebElement dashboardTab;

	    public WebElement getHomeTab() {
	        return homeTab;
	    }

	    public WebElement getMyClientsTab() {
	        return myClientsTab;
	    }

	    public WebElement getMyScheduleTab() {
	        return myScheduleTab;
	    }

	    public WebElement getMyCompanyTab() {
	        return myCompanyTab;
	    }

	    public WebElement getMyInvoicesTab() {
	        return myInvoicesTab;
	    }

	    public WebElement getMyLibraryTab() {
	        return myLibraryTab;
	    }

	    public WebElement getMyAffiliatesTab() {
	        return myAffiliatesTab;
	    }

	    public WebElement getCreditorsTab() {
	        return creditorsTab;
	    }

	    public WebElement getEverythingTab() {
	        return everythingTab;
	    }

	    public WebElement getDashboardTab() {
	        return dashboardTab;
	    }
	}

