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
	 * Class representing Update CreditCard Details Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class UpdateCreditCardDetailsPopup extends AbstractBasePageObject<UpdateCreditCardDetailsPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(UpdateCreditCardDetailsPopup.class);

	    private static final String relativeUrl = "/";

	    public UpdateCreditCardDetailsPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the update credit card details popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "change_cc_details")
	    private WebElement pageContainer;

	    @FindBy(how = How.ID, using = "card_number")
	    private WebElement cardNumberInput;

	    @FindBy(how = How.ID, using = "card_name")
	    private WebElement cardNameInput;

	    @FindBy(how = How.ID, using = "card_expiry")
	    private WebElement cardExpiryInput;

	    @FindBy(how = How.ID, using = "card_cvv")
	    private WebElement cardCvvInput;

	    @FindBy(how = How.ID, using = "change_cc_billing_zip")
	    private WebElement billingZipInput;

	    @FindBy(how = How.XPATH, using = "//footer//a[@class=' btn-small upgrade custom-next']")
	    private WebElement updateButton;

	    @FindBy(how = How.ID, using = "recurly_error")
	    private WebElement errorContainer;

	    @FindBy(how = How.XPATH, using = "//div[@id='change_cc_details']//a[@class='js-modal-close custom-close close']")
	    private WebElement closeButton;

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public void inputCardNumber(String text) {
	        set_text(cardNumberInput, text);
	    }

	    public void inputCardName(String text) {
	        set_text(cardNameInput, text);
	    }

	    public void inputCardExpiry(String text) {
	        set_text(cardExpiryInput, text);
	    }
	    public void inputCardCvv(String text) {
	        set_text(cardCvvInput, text);
	    }
	    public void inputBillingZip(String text) {
	        set_text(billingZipInput, text);
	    }

	    public WebElement getUpdateButton() {
	        return updateButton;
	    }

	    public WebElement getErrorContainer() {
	        return errorContainer;
	    }

	    public void closePopup() {
	        closeButton.click();
	    }


	}
