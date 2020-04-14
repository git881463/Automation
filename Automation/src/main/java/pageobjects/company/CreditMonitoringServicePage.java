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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Credit Monitoring Service page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CreditMonitoringServicePage extends AbstractBasePageObject<ClientAffiliatePortalPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPage.class);

	    private static final String relativeUrl = "/credit_monitoring_service";

	    @Autowired
	    private CreditMonitoringProviderSettingPopup creditMonitoringProviderSettingPopup;

	    @Autowired
	    private LearnToBecomeAffiliatePopup learnToBecomeAffiliatePopup;

	    public CreditMonitoringServicePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the credit monitoring service page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Manage Credit Monitoring Services')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@id='content_for_credit_monitoring']//div[@class='importing-eligible-box'][1]//div[@class='importing-eligible-edit-signup-btn']")
	    private WebElement editSignupButton;

	    @FindBy(how = How.ID, using = "learn_IdentityIQ")
	    private WebElement learnIdentityIQButton;

	    public CreditMonitoringProviderSettingPopup getCreditMonitoringProviderSettingPopup() {
	        return creditMonitoringProviderSettingPopup;
	    }

	    public LearnToBecomeAffiliatePopup getLearnToBecomeAffiliatePopup() {
	        return learnToBecomeAffiliatePopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getEditSignupButton() {
	        return editSignupButton;
	    }

	    public WebElement getLearnIdentityIQButton() {
	        return learnIdentityIQButton;
	    }
	}

