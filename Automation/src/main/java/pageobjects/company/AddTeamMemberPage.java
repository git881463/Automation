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
	 * Class representing Add Team Member page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddTeamMemberPage extends AbstractBasePageObject<AddTeamMemberPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AddTeamMemberPage.class);

	    private static final String relativeUrl = "/addteammember";

	    public AddTeamMemberPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add team member page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "fname")
	    private WebElement firstName;

	    @FindBy(how = How.ID, using = "lname")
	    private WebElement lastName;

	    @FindBy(how = How.ID, using = "email")
	    private WebElement email;

	    @FindBy(how = How.ID, using = "role")
	    private WebElement role;

	    @FindBy(how = How.ID, using = "password")
	    private WebElement password;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    public void inputFirstName(String text) {
	        set_text(firstName, text);
	    }

	    public void inputLastName(String text) {
	        set_text(lastName, text);
	    }

	    public void inputEmail(String text) {
	        set_text(email, text);
	    }

	    public void inputPassword(String text) {
	        set_text(password, text);
	    }

	    public void selectRole(String text){
	        select_dropdown_by_value(role, text);
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }
	}
