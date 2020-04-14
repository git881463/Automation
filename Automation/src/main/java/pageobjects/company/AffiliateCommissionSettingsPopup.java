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
	 * Class representing Affiliates Commission Settings Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AffiliateCommissionSettingsPopup extends AbstractBasePageObject<AffiliateCommissionSettingsPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(AffiliateCommissionSettingsPopup.class);

	    private static final String relativeUrl = "/";

	    public AffiliateCommissionSettingsPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the affiliate commission settings popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Affiliate commission setting')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Affiliate commission setting')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "custom_rate")
	    private WebElement customRateChoice;

	    @FindBy(how = How.ID, using = "ccr_commission")
	    private WebElement commission;

	    @FindBy(how = How.ID, using = "save_global_changes")
	    private WebElement saveButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getCustomRateChoice() {
	        return customRateChoice;
	    }

	    public WebElement getCommission() {
	        return commission;
	    }

	    public void inputCommission(String text) {
	        set_text(commission, text);
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }
	}


