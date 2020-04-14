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
	 * Class representing Client Affiliate Portal page Portal Theme section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPagePortalThemeSection extends AbstractBasePageObject<ClientAffiliatePortalPagePortalThemeSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPagePortalThemeSection.class);

	    private static final String relativeUrl = "/";

	    public ClientAffiliatePortalPagePortalThemeSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal page portal theme section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "portalthemecontent")
	    private WebElement portalThemeContainer;

	    @FindBy(how = How.ID, using = "hue-demo")
	    private WebElement portalThemeColor;

	    @FindBy(how = How.XPATH, using = "//div[@id='portalthemecontent']//a[contains(text(),'Reset to default')]")
	    private WebElement resetPortalThemeToDefaultLink;

	    public WebElement getPortalThemeContainer() {
	        return portalThemeContainer;
	    }

	    public WebElement getPortalThemeColor() {
	        return portalThemeColor;
	    }

	    public WebElement getResetPortalThemeToDefaultLink() {
	        return resetPortalThemeToDefaultLink;
	    }

	    public void inputColor(String text) {
	        set_text_for_autocomplete_forced(portalThemeColor, text);
	    }

	}


