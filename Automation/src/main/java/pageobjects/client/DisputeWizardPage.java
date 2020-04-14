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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Dispute Wizard Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeWizardPage extends AbstractBasePageObject<DisputeWizardPage> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeWizardPage.class);

	    private static final String relativeUrl = "/wizard/index/";

	    @Autowired
	    private DisputeWizardStep1Page disputeWizardStep1Page;

	    @Autowired
	    private DisputeWizardStep2Page disputeWizardStep2Page;

	    @Autowired
	    private DisputeWizardStep3Page disputeWizardStep3Page;

	    public DisputeWizardPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute wizard page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Credit Wizard')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[@class='headfront']//div[@class='btngray1']/a[1]")
	    private WebElement step1Link;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[@class='headfront']//div[@class='btngray1']/a[2]")
	    private WebElement step2Link;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[@class='headfront']//div[@class='btngray1']/a[3]")
	    private WebElement step3Link;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[@id='createletter']/a")
	    private WebElement createLetterLink;

	    public DisputeWizardStep1Page getDisputeWizardStep1Page() {
	        return disputeWizardStep1Page;
	    }

	    public DisputeWizardStep2Page getDisputeWizardStep2Page() {
	        return disputeWizardStep2Page;
	    }

	    public DisputeWizardStep3Page getDisputeWizardStep3Page() {
	        return disputeWizardStep3Page;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getStep1Link() {
	        return step1Link;
	    }

	    public WebElement getStep2Link() {
	        return step2Link;
	    }

	    public WebElement getStep3Link() {
	        return step3Link;
	    }

	    public WebElement getCreateLetterLink() {
	        return createLetterLink;
	    }
	}
