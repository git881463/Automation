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
	 * Class representing Client Dashboard Page Contact Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageContactSection extends AbstractBasePageObject<ClientDashboardPageContactSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageContactSection.class);

	    private static final String relativeUrl = "/";

	    public ClientDashboardPageContactSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard contact section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='assigncontactlist normaltext1']")
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='assigncontactlist normaltext1']/a")
	    private WebElement sendEmailLink;

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getSendEmailLink() {
	        return sendEmailLink;
	    }
	}

