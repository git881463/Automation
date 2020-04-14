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
	 * Class representing Edit Task Popup page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditTaskPopup extends AbstractBasePageObject<EditTaskPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(EditTaskPopup.class);

	    private static final String relativeUrl = "/";

	    public EditTaskPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the edit task popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable'][contains(@style, 'display: block')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "dialog_welcome_edit_title_text")
	    private WebElement taskTitle;

	    @FindBy(how = How.ID, using = "welcome_edit_cancel")
	    private WebElement cancelButton;

	    @FindBy(how = How.ID, using = "welcome_edit_save")
	    private WebElement saveButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getTaskTitle() {
	        return taskTitle;
	    }

	    public void inputTaskTitle(String text) {
	        set_text(taskTitle, text);
	    }

	    public WebElement getCancelButton() {
	        return cancelButton;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }
	}

