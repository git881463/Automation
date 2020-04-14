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
	 * Class representing Home Page Schedule Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageScheduleSection extends AbstractBasePageObject<HomePageScheduleSection> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageScheduleSection.class);

	    private static final String relativeUrl = "/home";

	    public HomePageScheduleSection(WebDriver driver, WebDriverWait wait, String url) {
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

	    @FindBy(how = How.XPATH, using="//div[@class='chrightbox date-time']//strong[contains(text(), 'Schedule:')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using="//div[@class='chrightbox date-time']//a[text()= 'Manage Schedule']")
	    private WebElement manageScheduleLink;

	    @FindBy(how = How.ID, using="scheduleDate")
	    private WebElement scheduleDate;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getManageScheduleLink() {
	        return manageScheduleLink;
	    }

	    public WebElement getScheduleDate() {
	        return scheduleDate;
	    }
	}

