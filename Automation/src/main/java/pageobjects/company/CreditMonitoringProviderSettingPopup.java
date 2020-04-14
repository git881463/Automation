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
	 * Class representing Credit Monitoring Provider Setting Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CreditMonitoringProviderSettingPopup extends AbstractBasePageObject<CreditMonitoringProviderSettingPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(CreditMonitoringProviderSettingPopup.class);

	    private static final String relativeUrl = "/";

	    public CreditMonitoringProviderSettingPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the credit monitoring provider setting popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Credit Monitoring Provider Settings')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Credit Monitoring Provider Settings')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "referral_link_text_1")
	    private WebElement link;

	    @FindBy(how = How.XPATH, using = "//div[@id='edit_affiliate_commission_1']//button[contains(text(),'Cancel')]")
	    private WebElement cancelButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='edit_affiliate_commission_1']//button[contains(text(),'Save')]")
	    private WebElement saveButton;

	    public void inputLLink(String text) {
	        set_text(link, text);
	    }

	    public WebElement getCancelButton() {
	        return cancelButton;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }
	}

