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
	 * Class representing Dispute Wizard Step2 Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeWizardStep2Page extends AbstractBasePageObject<DisputeWizardStep2Page> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeWizardStep2Page.class);

	    private static final String relativeUrl = "/wizard/step2/";

	    public DisputeWizardStep2Page(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute wizard step 2 page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[@class='formboxtext']//div[@class='tips']//a/strong[contains(text(),'Step 3')]")
	    private WebElement step3Link;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[@class='indata']//a[contains(text(),'Step 3')]")
	    private WebElement step3Button;

	    @FindBy(how = How.CLASS_NAME, using = "gray-btn-big")
	    private WebElement reportButton;


	    public WebElement getStep3Link() {
	        return step3Link;
	    }

	    public WebElement getStep3Button() {
	        return step3Button;
	    }

	    public WebElement getReportButton() {
	        return reportButton;
	    }
	}

