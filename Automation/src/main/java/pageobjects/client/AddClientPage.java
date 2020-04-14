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

	/**
	 * Class representing Add Client Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddClientPage extends AbstractBasePageObject<AddClientPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AddClientPage.class);

	    private static final String relativeUrl = "/myclients/add";

	    public AddClientPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add client page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='addclient']//div[text()='Add Client']")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "fname")
	    private WebElement firstName;

	    @FindBy(how = How.ID, using = "lname")
	    private WebElement lastName;

	    @FindBy(how = How.ID, using = "email")
	    private WebElement email;

	    @FindBy(how = How.ID, using = "phoneh")
	    private WebElement phoneHome;

	    @FindBy(how = How.ID, using = "referred_by_dd")
	    private WebElement referrer;

	    @FindBy(how = How.ID, using = "status")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "on")
	    private WebElement portalAccessOnRadio;

	    @FindBy(how = How.ID, using = "off")
	    private WebElement portalAccessOffRadio;

	    @FindBy(how = How.ID, using = "agreement")
	    private WebElement agreement;

	    @FindBy(how = How.ID, using = "sub_button")
	    private WebElement submitButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getPortalAccessOnRadio() {
	        return portalAccessOnRadio;
	    }

	    public WebElement getPortalAccessOffRadio() {
	        return portalAccessOffRadio;
	    }

	    public WebElement getSubmitButton()  {
	        return submitButton;
	    }

	    public void inputFirstName(String text) {
	        set_text(firstName, text);
	    }

	    public void inputLastName(String text) {
	        set_text(lastName, text);
	    }

	    public void inputEmail(String text) {
	        set_text(email, text);
	    }

	    public void inputPhoneHome(String text) {
	        set_text(phoneHome, text);
	    }

	    public void selectReferrer(String text){
	        select_dropdown_by_value(referrer, text);
	    }

	    public void selectStatus(String text){
	        select_dropdown_by_value(status, text);
	    }

	    public void selectNoAgreement(){
	        select_dropdown_by_value(agreement, "No Agreement");
	    }

	}

