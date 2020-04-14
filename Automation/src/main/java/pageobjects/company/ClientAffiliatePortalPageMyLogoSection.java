package pageobjects.company;

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
	 * Class representing Client Affiliate Portal page My Logo section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPageMyLogoSection extends AbstractBasePageObject<ClientAffiliatePortalPageMyLogoSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPageMyLogoSection.class);

	    private static final String relativeUrl = "/";

	    public ClientAffiliatePortalPageMyLogoSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal page my logo section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='mycompany']//a[contains(text(),'Change')]")
	    private WebElement ChangeLogoLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='mycompany']//input[@id='logo']")
	    private WebElement filePickerLink;

	    public WebElement getChangeLogoLink() {
	        return ChangeLogoLink;
	    }

	    public WebElement getFilePickerLink() {
	        return filePickerLink;
	    }
	}

