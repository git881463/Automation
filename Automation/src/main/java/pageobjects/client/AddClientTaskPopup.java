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
	 * Class representing Add Client Task Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddClientTaskPopup extends AbstractBasePageObject<AddClientTaskPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(AddClientTaskPopup.class);

	    private static final String relativeUrl = "/";

	    public AddClientTaskPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add client task popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Add Task For Client')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Add Task For Client')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "onboarding_dd")
	    private WebElement taskType;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//button[@id='assign_new_task_client_cancel']//following-sibling::button")
	    private WebElement assignTaskToClientButton;

	    @FindBy(how = How.ID, using = "assign_new_task_client_cancel")
	    private WebElement cancelButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public void selectTaskType(String text){
	        select_dropdown_by_value(taskType, text);
	    }

	    public WebElement getAssignTaskToClientButton() {
	        return assignTaskToClientButton;
	    }

	    public WebElement getCancelButton() {
	        return cancelButton;
	    }
	}

