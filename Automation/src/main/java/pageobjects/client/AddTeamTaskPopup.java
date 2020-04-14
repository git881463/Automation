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
	 * Class representing Add Team Task Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddTeamTaskPopup extends AbstractBasePageObject<AddTeamTaskPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(AddTeamTaskPopup.class);

	    private static final String relativeUrl = "/";

	    public AddTeamTaskPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add team task popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[text()='Task']")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[text()='Task']//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "cd_remainder_type")
	    private WebElement taskType;

	    @FindBy(how = How.ID, using = "cd_subject")
	    private WebElement subject;

	    @FindBy(how = How.ID, using = "cd_submit_reminder_1")
	    private WebElement saveButton;

	    @FindBy(how = How.ID, using = "cd_cancel_reminder_1")
	    private WebElement cancelButton;


	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public void inputSubject(String text) {
	        set_text(subject, text);
	    }

	    public void selectTaskType(String text){
	        select_dropdown_by_value(taskType, text);
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }

	    public WebElement getCancelButton() {
	        return cancelButton;
	    }
	}

