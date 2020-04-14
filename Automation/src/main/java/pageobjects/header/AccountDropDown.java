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
	 * Class representing Account Dropdown in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AccountDropDown extends AbstractBasePageObject<AccountDropDown> {

	    private static final Logger logger = LoggerFactory.getLogger(AccountDropDown.class);

	    private static final String relativeUrl = "/";

	    public AccountDropDown(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the account dropdown page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "logoutbox")
	    private WebElement dropDownContainer;

	    @FindBy(how = How.XPATH, using = "//div[@id='logoutbox']/a[contains(text(),'Change Password')]")
	    private WebElement changePasswordLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='logoutbox']/a[contains(text(),'Log out')]")
	    private WebElement logoutLink;

	    public WebElement getDropDownContainer() {
	        return dropDownContainer;
	    }

	    public WebElement getChangePasswordLink() {
	        return changePasswordLink;
	    }

	    public WebElement getLogoutLink() {
	        return logoutLink;
	    }
	}

