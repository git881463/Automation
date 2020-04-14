package pageobjects.company;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Class representing Client Task for onboarding Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientTaskForOnboardingPopup extends AbstractBasePageObject<ClientTaskForOnboardingPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientTaskForOnboardingPopup.class);

	    private static final String relativeUrl = "/";

	    public ClientTaskForOnboardingPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the credit monitoring provider setting popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Client Task for onboarding')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Client Task for onboarding')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='dialog_edit_default']/a[contains(text(),'Reset onboarding tasks to default tasks and order')]")
	    private WebElement resetTaskLink;

	    @FindBy(how = How.ID, using = "li_1")
	    private WebElement task1;

	    @FindBy(how = How.ID, using = "li_4")
	    private WebElement task4;

	    @FindBy(how = How.XPATH, using = "//li[@id='li_1']/button")
	    private WebElement deleteTask1Button;

	    @FindBy(how = How.XPATH, using = "//li[@id='li_2']/button")
	    private WebElement deleteTask2Button;

	    @FindBy(how = How.XPATH, using = "//li[@id='li_3']/button")
	    private WebElement deleteTask3Button;

	    @FindBy(how = How.XPATH, using = "//li[@id='li_4']/button")
	    private WebElement deleteTask4Button;

	    @FindBy(how = How.XPATH, using = "//li[@id='li_5']/button")
	    private WebElement deleteTask5Button;

	    @FindBy(how = How.XPATH, using = "//li[@id='li_6']/button")
	    private WebElement deleteTask6Button;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getResetTaskLink() {
	        return resetTaskLink;
	    }

	    public void shuffleTasks(){
	        Actions actions = new Actions(webdriver);

	        //Dragged and dropped
	        actions.dragAndDrop(task1, task4).build().perform();

	    }

	    public WebElement getDeleteTask1Button() {
	        return deleteTask1Button;
	    }

	    public WebElement getDeleteTask2Button() {
	        return deleteTask2Button;
	    }

	    public WebElement getDeleteTask3Button() {
	        return deleteTask3Button;
	    }

	    public WebElement getDeleteTask4Button() {
	        return deleteTask4Button;
	    }

	    public WebElement getDeleteTask5Button() {
	        return deleteTask5Button;
	    }

	    public WebElement getDeleteTask6Button() {
	        return deleteTask6Button;
	    }
	}


