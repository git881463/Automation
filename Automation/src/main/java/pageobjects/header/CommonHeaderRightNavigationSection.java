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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Common Header right navigation in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CommonHeaderRightNavigationSection extends AbstractBasePageObject<CommonHeaderRightNavigationSection> {

	    private static final Logger logger = LoggerFactory.getLogger(CommonHeaderRightNavigationSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private HelpAndSupportDropDown helpAndSupportDropDown;

	    @Autowired
	    private AccountDropDown accountDropDown;

	    public CommonHeaderRightNavigationSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the common header right navigation section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='toprightbuttons']//a[contains(text(),'My Account')]")
	    private WebElement myAccountLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='toprightbuttons']//a[contains(text(),'New Features')]")
	    private WebElement newFeaturesLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='toprightbuttons']//a[contains(text(),'Help & Support')]")
	    private WebElement helpAndSupportLink;

	    @FindBy(how = How.ID, using = "logoutbtn")
	    private WebElement logoutButton;

	    public HelpAndSupportDropDown getHelpAndSupportDropDown() {
	        return helpAndSupportDropDown;
	    }

	    public AccountDropDown getAccountDropDown() {
	        return accountDropDown;
	    }

	    public WebElement getMyAccountLink() {
	        return myAccountLink;
	    }

	    public WebElement getNewFeaturesLink() {
	        return newFeaturesLink;
	    }

	    public WebElement getHelpAndSupportLink() {
	        return helpAndSupportLink;
	    }

	    public WebElement getLogoutButton() {
	        return logoutButton;
	    }
	}

