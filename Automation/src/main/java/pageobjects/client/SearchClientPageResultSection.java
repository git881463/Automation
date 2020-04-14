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
	 * Class representing Search Client Page Result in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SearchClientPageResultSection extends AbstractBasePageObject<SearchClientPageResultSection> {

	    private static final Logger logger = LoggerFactory.getLogger(SearchClientPageResultSection.class);

	    private static final String relativeUrl = "/";

	    public SearchClientPageResultSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the search client result page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "gridtable")
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[1]/td[1]")
	    private WebElement nameHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[1]/td[3]")
	    private WebElement referredByHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[1]/td[4]")
	    private WebElement addedDateHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[1]/td[5]")
	    private WebElement startDateHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[1]/td[7]")
	    private WebElement statusHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2][@style='background:#99ff99']")
	    private WebElement firstClientLeadStyle;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2][@style='background:#ffb2c5']")
	    private WebElement firstClientSuspendedStyle;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2][@style='background:#80E6FF']")
	    private WebElement firstClientProspectStyle;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[1]//a")
	    private WebElement firstClientName;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[4]")
	    private WebElement firstClientAddedDate;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[5]")
	    private WebElement firstClientStartDate;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[7]//a")
	    private WebElement firstClientStatus;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]//a[1]")
	    private WebElement firstClientInternalNotesLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]//a[2]")
	    private WebElement firstClientAssignMemberLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]//a[3]")
	    private WebElement firstClientEditClientLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]//a[2]")
	    private WebElement firstClientEditLeadLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]//a[4]")
	    private WebElement firstClientDeleteClientLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]//a[3]")
	    private WebElement firstClientDeleteLeadLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tr[2]/td[8]//a[3]")
	    private WebElement firstClientDeleteSuspendedLink;

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getFirstClientName() {
	        return firstClientName;
	    }

	    public WebElement getFirstClientStartDate() {
	        return firstClientStartDate;
	    }

	    public WebElement getFirstClientAddedDate() {
	        return firstClientAddedDate;
	    }

	    public WebElement getFirstClientStatus() {
	        return firstClientStatus;
	    }

	    public WebElement getFirstClientInternalNotesLink() {
	        return firstClientInternalNotesLink;
	    }

	    public WebElement getFirstClientEditClientLink() {
	        return firstClientEditClientLink;
	    }

	    public WebElement getFirstClientEditLeadLink() {
	        return firstClientEditLeadLink;
	    }

	    public WebElement getFirstClientDeleteClientLink() {
	        return firstClientDeleteClientLink;
	    }

	    public WebElement getFirstClientDeleteLeadLink() {
	        return firstClientDeleteLeadLink;
	    }

	    public WebElement getFirstClientDeleteSuspendedLink() {
	        return firstClientDeleteSuspendedLink;
	    }

	    public WebElement getNameHeader() {
	        return nameHeader;
	    }

	    public WebElement getReferredByHeader() {
	        return referredByHeader;
	    }

	    public WebElement getAddedDateHeader() {
	        return addedDateHeader;
	    }

	    public WebElement getStartDateHeader() {
	        return startDateHeader;
	    }

	    public WebElement getStatusHeader() {
	        return statusHeader;
	    }

	    public WebElement getFirstClientLeadStyle() {
	        return firstClientLeadStyle;
	    }

	    public WebElement getFirstClientSuspendedStyle() {
	        return firstClientSuspendedStyle;
	    }

	    public WebElement getFirstClientProspectStyle() {
	        return firstClientProspectStyle;
	    }
	}
