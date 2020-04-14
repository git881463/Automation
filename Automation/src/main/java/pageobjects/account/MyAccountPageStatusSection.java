package pageobjects.account;

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
	 * Class representing Home My Account Page Status Section Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MyAccountPageStatusSection extends AbstractBasePageObject<MyAccountPageStatusSection> {

	    private static final Logger logger = LoggerFactory.getLogger(MyAccountPageStatusSection.class);

	    private static final String relativeUrl = "/";

	    public MyAccountPageStatusSection(WebDriver driver, WebDriverWait wait, String url) {
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
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the my account status page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "chbox")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "changeEmail")
	    private WebElement changeEmailLink;

	    @FindBy(how = How.ID, using = "change_email_ok")
	    private WebElement changeEmailOkButton;

	    @FindBy(how = How.ID, using = "changeEmail_popup")
	    private WebElement changeEmailPopup;

	    @FindBy(how = How.ID, using = "submitnewEmail")
	    private WebElement updateEmailButton;

	    public WebElement getStatus() {
	        return status;
	    }

	    public WebElement getChangeEmailLink() {
	        return changeEmailLink;
	    }

	    public WebElement getChangeEmailOkButton() {
	        return changeEmailOkButton;
	    }

	    public WebElement getChangeEmailPopup() {
	        return changeEmailPopup;
	    }

	    public WebElement getUpdateEmailButton() {
	        return updateEmailButton;
	    }
	}
