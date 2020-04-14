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
	 * Class representing Home My Account Page Current Plan Details Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MyAccountPageCurrentPlanDetailsSection extends AbstractBasePageObject<MyAccountPageCurrentPlanDetailsSection> {

	    private static final Logger logger = LoggerFactory.getLogger(MyAccountPageCurrentPlanDetailsSection.class);

	    private static final String relativeUrl = "/";

	    public MyAccountPageCurrentPlanDetailsSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the my account current plan details page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox']//a[text()='(Change Plan)']")
	    private WebElement changePlanLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox']//h3[contains(text(),'Current Plan Details')]")
	    private WebElement header;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox']//a[contains(text(),'View Receipts')]")
	    private WebElement viewReceiptLink;

	    public WebElement getChangePlanLink() {
	        return changePlanLink;
	    }

	    public WebElement getHeader() {
	        return header;
	    }

	    public WebElement getViewReceiptLink() {
	        return viewReceiptLink;
	    }
	}

