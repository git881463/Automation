package pageobjects.dashboard;

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
	 * Class representing Dashboard Page Top Team members Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPageTopTeamMembersSection extends AbstractBasePageObject<DashboardPageTopTeamMembersSection> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPageTopTeamMembersSection.class);

	    private static final String relativeUrl = "/dashboard";

	    public DashboardPageTopTeamMembersSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page top team members section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "teammember_dd")
	    private WebElement timePeriod;

	    @FindBy(how = How.ID, using = "signup_txt")
	    private WebElement signupText;

	    @FindBy(how = How.ID, using = "signup_lnk")
	    private WebElement signupLink;

	    @FindBy(how = How.ID, using = "tm_revenue_txt")
	    private WebElement revenuesText;

	    @FindBy(how = How.ID, using = "tm_revenue_lnk")
	    private WebElement revenuesLink;

	    @FindBy(how = How.ID, using = "tm_repaired_txt")
	    private WebElement repairedText;

	    @FindBy(how = How.ID, using = "tm_repaired_lnk")
	    private WebElement repairedLink;

	    @FindBy(how = How.ID, using = "top_team_place")
	    private WebElement topTeamPlace;

	    public void selectTimePeriod(int index){
	        select_dropdown_by_index(timePeriod, index);
	    }

	    public WebElement getTimePeriod() {
	        return timePeriod;
	    }

	    public WebElement getSignupText() {
	        return signupText;
	    }

	    public WebElement getSignupLink() {
	        return signupLink;
	    }

	    public WebElement getRevenuesText() {
	        return revenuesText;
	    }

	    public WebElement getRevenuesLink() {
	        return revenuesLink;
	    }

	    public WebElement getRepairedText() {
	        return repairedText;
	    }

	    public WebElement getRepairedLink() {
	        return repairedLink;
	    }

	    public WebElement getTopTeamPlace() {
	        return topTeamPlace;
	    }
	}


