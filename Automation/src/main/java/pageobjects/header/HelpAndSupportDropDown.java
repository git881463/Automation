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
	 * Class representing HelpAndSupport Dropdown in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HelpAndSupportDropDown extends AbstractBasePageObject<HelpAndSupportDropDown> {

	    private static final Logger logger = LoggerFactory.getLogger(HelpAndSupportDropDown.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private NewFeatureRequestsPopup newFeatureRequestsPopup;

	    public HelpAndSupportDropDown(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the help & support dropdown page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "bloglist")
	    private WebElement dropDownContainer;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'Support Center')]")
	    private WebElement supportCenterLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'Watch Quick Videos')]")
	    private WebElement quickVideosLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'Read Startup Guides')]")
	    private WebElement startupGuidesLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'Business Checklist')]")
	    private WebElement businessChecklistLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'Tips and Tricks')]")
	    private WebElement tipsAndTricksLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'New Feature Requests')]")
	    private WebElement NewFeatureRequestsLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'Resources')]")
	    private WebElement resourcesLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='bloglist']/a[contains(text(),'Get Free Shirt')]")
	    private WebElement freeShirtLink;

	    public NewFeatureRequestsPopup getNewFeatureRequestsPopup() {
	        return newFeatureRequestsPopup;
	    }

	    public WebElement getDropDownContainer() {
	        return dropDownContainer;
	    }

	    public WebElement getSupportCenterLink() {
	        return supportCenterLink;
	    }

	    public WebElement getQuickVideosLink() {
	        return quickVideosLink;
	    }

	    public WebElement getStartupGuidesLink() {
	        return startupGuidesLink;
	    }

	    public WebElement getBusinessChecklistLink() {
	        return businessChecklistLink;
	    }

	    public WebElement getTipsAndTricksLink() {
	        return tipsAndTricksLink;
	    }

	    public WebElement getNewFeatureRequestsLink() {
	        return NewFeatureRequestsLink;
	    }

	    public WebElement getResourcesLink() {
	        return resourcesLink;
	    }

	    public WebElement getFreeShirtLink() {
	        return freeShirtLink;
	    }
	}
