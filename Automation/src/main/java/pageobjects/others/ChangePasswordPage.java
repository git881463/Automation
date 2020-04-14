package pageobjects.others;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.FlashMessage;
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
	 * Class representing Change Password Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ChangePasswordPage extends AbstractBasePageObject<ChangePasswordPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ChangePasswordPage.class);

	    private static final String relativeUrl = "/home/changepassword";

	    @Autowired
	    private FlashMessage flashMessage;

	    public ChangePasswordPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the ChangePassword page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "formboxtitle")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "old_password")
	    private WebElement oldPassword;

	    @FindBy(how = How.ID, using = "new_password")
	    private WebElement newPassword;

	    @FindBy(how = How.ID, using = "confirm_password")
	    private WebElement confirmPassword;

	    @FindBy(how = How.XPATH, using = "//div[@class='formbox']//input[@class='btnsubmit']")
	    private WebElement submitButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='formbox']//span[contains(text(),'Old password does not match')]")
	    private WebElement errorOldPasswordNotMatching;

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getOldPassword() {
	        return oldPassword;
	    }

	    public WebElement getNewPassword() {
	        return newPassword;
	    }

	    public WebElement getConfirmPassword() {
	        return confirmPassword;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }

	    public WebElement getErrorOldPasswordNotMatching() {
	        return errorOldPasswordNotMatching;
	    }

	    public void inputOldPassword(String text) {
	        set_text(oldPassword, text);
	    }

	    public void inputNewPassword(String text) {
	        set_text(newPassword, text);
	    }

	    public void inputConfirmPassword(String text) {
	        set_text(confirmPassword, text);
	    }


	}
