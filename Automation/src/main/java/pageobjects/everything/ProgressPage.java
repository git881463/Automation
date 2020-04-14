package pageobjects.everything;

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
	 * Class representing Progress Page in Everything tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ProgressPage extends AbstractBasePageObject<ProgressPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ProgressPage.class);

	    private static final String relativeUrl = "/progress";

	    public ProgressPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the everything progress page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "team_mem_name")
	    private WebElement teamMemberNameInHeader;

	    @FindBy(how = How.ID, using = "teamdropdown")
	    private WebElement teamDropDown;

	    @FindBy(how = How.ID, using = "filter_loader")
	    private WebElement ajaxFilterLoader;

	    @FindBy(how = How.ID, using = "cd-timeline")
	    private WebElement timeLine;

	    @FindBy(how = How.XPATH, using = "//div[@class='cd-timeline-img cd-picture']")
	    private WebElement timeLineHeader;

	    @FindBy(how = How.ID, using = "activitydetailmain")
	    private WebElement activityDetails;

	    @FindBy(how = How.ID, using = "tname")
	    private WebElement teamMemberName;

	    @FindBy(how = How.XPATH, using = "//li[@class='ui-menu-item']/a")
	    private WebElement teamMemberNameSelectionMenuItem;

	    @FindBy(how = How.ID, using = "teamtbutton")
	    private WebElement searchTeamMemberButton;

	    public void selectTeamFilter(String text){
	        select_dropdown_by_value(teamDropDown, text);
	    }

	    public void inputTeamMemberName(String text) {
	        set_text_for_autocomplete(teamMemberName, text);
	    }

	    public WebElement getTeamMemberNameInHeader() {
	        return teamMemberNameInHeader;
	    }

	    public WebElement getTeamDropDown() {
	        return teamDropDown;
	    }

	    public WebElement getAjaxFilterLoader() {
	        return ajaxFilterLoader;
	    }

	    public WebElement getTimeLine() {
	        return timeLine;
	    }

	    public WebElement getTimeLineHeader() {
	        return timeLineHeader;
	    }

	    public WebElement getActivityDetails() {
	        return activityDetails;
	    }

	    public WebElement getTeamMemberName() {
	        return teamMemberName;
	    }

	    public WebElement getSearchTeamMemberButton() {
	        return searchTeamMemberButton;
	    }

	    public WebElement getTeamMemberNameSelectionMenuItem() {
	        return teamMemberNameSelectionMenuItem;
	    }
	}

