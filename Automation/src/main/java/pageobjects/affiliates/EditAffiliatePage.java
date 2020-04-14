package pageobjects.affiliates;

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
	 * Class representing Edit Affiliate Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditAffiliatePage extends AbstractBasePageObject<EditAffiliatePage> {

	    private static final Logger logger = LoggerFactory.getLogger(EditAffiliatePage.class);

	    private static final String relativeUrl = "/edit";

	    public EditAffiliatePage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    public void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the edit affiliates page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='addclient']//div[contains(text(),'Add Affiliate Partner')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "fname")
	    private WebElement firstName;

	    @FindBy(how = How.ID, using = "lname")
	    private WebElement lastName;

	    @FindBy(how = How.ID, using = "gender_male")
	    private WebElement gender;

	    @FindBy(how = How.ID, using = "email")
	    private WebElement email;

	    @FindBy(how = How.ID, using = "mobile")
	    private WebElement phone;

	    @FindBy(how = How.ID, using = "status")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "username")
	    private WebElement username;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    public void inputFirstName(String text) {
	        set_text(firstName, text);
	    }

	    public void inputLastName(String text) {
	        set_text(lastName, text);
	    }

	    public WebElement getGender() {
	        return gender;
	    }

	    public void inputEmail(String text) {
	        set_text(email, text);
	    }

	    public void inputPhone(String text) {
	        set_text(phone, text);
	    }
	    public void selectStatus(int index){
	        select_dropdown_by_index(status, index);
	    }

	    public void inputUserName(String text) {
	        set_text(username, text);
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }
	}

