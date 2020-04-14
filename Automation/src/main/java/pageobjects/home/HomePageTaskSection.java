package pageobjects.home;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.FlashMessage;
	import pageobjects.popup.WarningPopup;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;


	/**
	 * Class representing Home Page Task Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageTaskSection extends AbstractBasePageObject<HomePageTaskSection> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageTaskSection.class);

	    private static final String relativeUrl = "/home";

	    @Autowired
	    private HomePage homePage;

	    @Autowired
	    private HomePageTaskSectionNewTaskPopup homePageTaskSectionNewTaskPopup;

	    @Autowired
	    private WarningPopup warningPopup;

	    @Autowired
	    private FlashMessage flashMessage;

	    @Autowired
	    private HomePageTaskSectionTaskSelectionWidget homePageTaskSectionTaskSelectionWidget;

	    public HomePageTaskSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the home page: " + url, url.endsWith( relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "ref_todo")
	    private WebElement todaysTaskContainer;

	    @FindBy(how = How.XPATH, using = "//div[@id='ref_todo']/table//a/img")
	    private WebElement newTaskLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='ref_todo']/table//a[contains(text(),'View All Tasks')]")
	    private WebElement viewAllTasksLink;

	    @FindBy(how = How.XPATH, using="//div[@id='ref_todo']//table/tbody/tr[1]/td[2]/a")
	    private WebElement deleteTaskLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='ref_todo']/div/table/tbody/tr[1]/td[1]/input[@type='checkbox']")
	    private WebElement firstTaskInList;

	    public HomePage getHomePage() {
	        return homePage;
	    }

	    public HomePageTaskSectionNewTaskPopup getHomePageTaskSectionNewTaskPopup() {
	        return homePageTaskSectionNewTaskPopup;
	    }

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public HomePageTaskSectionTaskSelectionWidget getHomePageTaskSectionTaskSelectionWidget() {
	        return homePageTaskSectionTaskSelectionWidget;
	    }

	    public WebElement getTodaysTaskContainer() {
	        return todaysTaskContainer;
	    }

	    public WebElement getFirstTaskInList() {
	        return firstTaskInList;
	    }

	    public WebElement getNewTaskLink() {
	        return newTaskLink;
	    }

	    public WebElement getDeleteTaskLink() {
	        return deleteTaskLink;
	    }

	    public WebElement getViewAllTasksLink() {
	        return viewAllTasksLink;
	    }

	}

