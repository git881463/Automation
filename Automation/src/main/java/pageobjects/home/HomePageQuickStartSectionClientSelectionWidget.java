package pageobjects.home;

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
	 * Class representing QuickStartSection Client Selection popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageQuickStartSectionClientSelectionWidget extends AbstractBasePageObject<HomePageTaskSectionTaskSelectionWidget> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageQuickStartSectionClientSelectionWidget.class);

	    private static final String relativeUrl = "/home";

	    public HomePageQuickStartSectionClientSelectionWidget(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        //navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the home page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "ui-dialog-title-client-list-place")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using ="//div[@aria-labelledby='ui-dialog-title-client-list-place']//a[@class='ui-dialog-titlebar-close ui-corner-all']")
	    private WebElement closeButton;

	    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-client-list-place']//tbody/tr[1]/td[1]")
	    private WebElement clientListTable;

	    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-client-list-place']//tbody/tr[2]/td[1]/a")
	    private WebElement linkToFirstClientInList;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getCloseButton() {
	        return closeButton;
	    }

	    public WebElement getClientListTable() {
	        return clientListTable;
	    }

	    public WebElement getLinkToFirstClientInList() {
	        return linkToFirstClientInList;
	    }
	}
