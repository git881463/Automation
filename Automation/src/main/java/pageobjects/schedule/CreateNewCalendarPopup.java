package pageobjects.schedule;

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
	 * Class representing Create New Calendar Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CreateNewCalendarPopup extends AbstractBasePageObject<CreateNewCalendarPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(CreateNewCalendarPopup.class);

	    private static final String relativeUrl = "/";

	    public CreateNewCalendarPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the create new calendar popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'Create New Calendar')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "remainder_type")
	    private WebElement event;

	    @FindBy(how = How.ID, using = "Subject")
	    private WebElement subject;

	    @FindBy(how = How.ID, using = "IsAllDayEvent")
	    private WebElement allDayEvent;

	    @FindBy(how = How.ID, using = "Savebtn")
	    private WebElement saveButton;

	    @FindBy(how = How.XPATH, using = "//*[starts-with(@id,'dailog_iframe_')]")
	    private WebElement frameElement;

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'Manage  The Calendar')]")
	    private WebElement editPageTitle;

	    public void selectEvent(String text){
	        select_dropdown_by_value(event, text);
	    }

	    public void inputSubject(String text) {
	        set_text(subject, text);
	    }

	    public WebElement getAllDayEvent() {
	        return allDayEvent;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }

	    public WebElement getFrameElement() {
	        return frameElement;
	    }

	    public WebElement getEditPageTitle() {
	        return editPageTitle;
	    }
	}
