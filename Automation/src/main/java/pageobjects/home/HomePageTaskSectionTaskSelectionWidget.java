package pageobjects.home;

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
	 * Class representing Task Selection popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageTaskSectionTaskSelectionWidget extends AbstractBasePageObject<HomePageTaskSectionTaskSelectionWidget> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageTaskSectionTaskSelectionWidget.class);

	    private static final String relativeUrl = "/home";

	    public HomePageTaskSectionTaskSelectionWidget(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        //navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the home page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "all_todo_form")
	    private WebElement allTasksForm;

	    @FindBy(how = How.XPATH, using ="//div[@id='all_todo_form']//table/tbody/tr[1]/td[1]/input[@type='checkbox']")
	    private WebElement taskCheckBox;

	    @FindBy(how = How.XPATH, using ="//div[@aria-labelledby='ui-dialog-title-all_todo_form']//a[@class='ui-dialog-titlebar-close ui-corner-all']")
	    private WebElement closeWidgetLink;

	    public WebElement getAllTasksForm() {
	        return allTasksForm;
	    }

	    public WebElement getTaskCheckBox() {
	        return taskCheckBox;
	    }

	    public WebElement getCloseWidgetLink() {
	        return closeWidgetLink;
	    }
	}

