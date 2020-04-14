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

	import java.util.ArrayList;


	/**
	 * Class representing Home Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePage extends AbstractBasePageObject<HomePage> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

	    private static final String relativeUrl = "/home";

	    @Autowired
	    private FlashMessage flashMessage;

	    @Autowired
	    private WarningPopup warningPopup;

	    @Autowired
	    private HomePageTaskSection homePageTaskSection;

	    @Autowired
	    private HomePageQuickStartSection quickStartSection;

	    @Autowired
	    private HomePageBusinessStatusSection homePageBusinessStatusSection;

	    @Autowired
	    private HomePageRecentLoginActivitySection homePageRecentLoginActivitySection;

	    @Autowired
	    private HomePageShortcutsSection homePageShortcutsSection;

	    @Autowired
	    private HomePageScheduleSection homePageScheduleSection;

	    public HomePage(WebDriver driver, WebDriverWait wait, String url) {
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
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the home page: " + url, url.endsWith( relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    public void isLoadedInTab() throws Error {
	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
	        String url = getDriver().getCurrentUrl();
	        logger.debug("url before: {}", url);
	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab

	        url = getDriver().getCurrentUrl();
	        logger.debug("url now: {}", url);
	        Assert.assertTrue("Not on the home page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	        getDriver().close();
	        webdriver.switchTo().window(tabs.get(0)); //switches to old tab
	    }

	    @FindBy(how = How.CLASS_NAME, using = "contentbg")
	    private WebElement homePageContainer;

	    public WebElement getHomePageContainer()
	    {
	        return homePageContainer;
	    }

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public HomePageTaskSection getHomePageTaskSection() {
	        return homePageTaskSection;
	    }

	    public HomePageQuickStartSection getQuickStartSection() {
	        return quickStartSection;
	    }

	    public HomePageBusinessStatusSection getHomePageBusinessStatusSection() {
	        return homePageBusinessStatusSection;
	    }

	    public HomePageRecentLoginActivitySection getHomePageRecentLoginActivitySection() {
	        return homePageRecentLoginActivitySection;
	    }

	    public HomePageShortcutsSection getHomePageShortcutsSection() {
	        return homePageShortcutsSection;
	    }

	    public HomePageScheduleSection getHomePageScheduleSection() {
	        return homePageScheduleSection;
	    }

	}
