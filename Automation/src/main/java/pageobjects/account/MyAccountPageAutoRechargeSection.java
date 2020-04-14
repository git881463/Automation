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
	 * Class representing Home My Account Page Auto Recharge Section Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MyAccountPageAutoRechargeSection extends AbstractBasePageObject<MyAccountPageAutoRechargeSection> {

	    private static final Logger logger = LoggerFactory.getLogger(MyAccountPageAutoRechargeSection.class);

	    private static final String relativeUrl = "/";

	    public MyAccountPageAutoRechargeSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the my account auto recharge page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//h3[contains(text(),'Auto Recharge for Additional Client Slots ')]")
	    private WebElement header;

	    @FindBy(how = How.ID, using = "client_slots_limit")
	    private WebElement ClientSlotsInput;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//div[@class='main-startplane2']//input[@type='button' and @value='Save']")
	    private WebElement saveButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//div[@class='main-startplane2']//input[@type='button' and @value='Disable']")
	    private WebElement disableButton;

	    private String xpathForDisabledButton = "//div[@class='chleftbox ']//div[@class='main-startplane2']//input[@type='button' and @value='Disable']";

	    public void inputClientSlots(String text) {
	        set_text(ClientSlotsInput, text);
	    }

	    public WebElement getHeader() {
	        return header;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }

	    public WebElement getDisableButton() {
	        return disableButton;
	    }

	    public boolean isDisabled(){
	        return !isElementPresent(xpathForDisabledButton);
	    }
	}

