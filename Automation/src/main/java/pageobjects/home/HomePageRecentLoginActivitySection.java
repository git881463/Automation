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
	 * Class representing Home Page Recent Login Activity Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageRecentLoginActivitySection extends AbstractBasePageObject<HomePageRecentLoginActivitySection> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageRecentLoginActivitySection.class);

	    private static final String relativeUrl = "/home";

	    public HomePageRecentLoginActivitySection(WebDriver driver, WebDriverWait wait, String url) {
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

	    @FindBy(how = How.XPATH, using="//div[@class='chrightbox']//strong[contains(text(),  'Recent Login Activity')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//a[contains(text(),'Full History')]")
	    private WebElement fullHistoryLink;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getFullHistoryLink() {
	        return fullHistoryLink;
	    }
	}

