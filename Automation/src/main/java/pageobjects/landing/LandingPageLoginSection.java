package pageobjects.landing;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.home.HomePage;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;


	/**
	 * Class representing Login Section on top of Landing Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class LandingPageLoginSection extends AbstractBasePageObject<LandingPageLoginSection> {

	    private static final Logger logger = LoggerFactory.getLogger(LandingPageLoginSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private HomePage homePage;

	    public LandingPageLoginSection(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the landing page: " + url, url.endsWith("creditrepaircloud.com/"));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using="new-login-left-form")
	    private WebElement loginForm;

	    @FindBy(how = How.XPATH, using="//div[@class='new-login-left-form']//h1[text()='Hello again!']")
	    private WebElement loginFormTitle;

	    @FindBy(how = How.ID, using="username")
	    private WebElement username;

	    @FindBy(how = How.ID, using="password")
	    private WebElement password;

	    @FindBy(how = How.ID, using="signin")
	    private WebElement loginButton;

	    @FindBy(how = How.ID, using="forgotpassword")
	    private WebElement forgotpassword;

	    @FindBy(how = How.ID, using="ajax_error")
	    private WebElement errorMessageContainer;

	    @FindBy(how = How.ID, using="recaptch")
	    private WebElement captchaContainer;

	    public HomePage getHomePage() {
	        return homePage;
	    }

	    public WebElement getLoginForm() {
	        return loginForm;
	    }

	    public WebElement getLoginFormTitle() {
	        return loginFormTitle;
	    }

	    public WebElement getUsername() {
	        return username;
	    }

	    public WebElement getPassword() {
	        return password;
	    }

	    public WebElement getLoginButton() {
	        return loginButton;
	    }

	    public WebElement getForgotpassword() {
	        return forgotpassword;
	    }

	    public WebElement getErrorMessageContainer() {
	        return errorMessageContainer;
	    }

	    public WebElement getCaptchaContainer() {
	        return captchaContainer;
	    }

	    public void inputUsername(String text) {
	        set_text(username, text);
	    }

	    public void inputPassword(String text) {
	        set_text(password, text);
	    }

	    public void clickOnSigninButton() {
	        wait.until(ExpectedConditions.visibilityOf(loginButton));
	        loginButton.click();
	    }
	}

