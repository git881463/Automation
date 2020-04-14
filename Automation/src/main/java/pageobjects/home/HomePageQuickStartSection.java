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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Home Page Quick Start Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageQuickStartSection extends AbstractBasePageObject<HomePageQuickStartSection> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageQuickStartSection.class);

	    private static final String relativeUrl = "/home";

	    @Autowired
	    private HomePageQuickStartSectionClientSelectionWidget homePageQuickStartSectionClientSelectionWidget;

	    public HomePageQuickStartSection(WebDriver driver, WebDriverWait wait, String url) {
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

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox']//strong[contains(text(),'Quick Start')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using="//div[@class='chleftboxtab']//span[contains(text(),'Add a New Client')]")
	    private WebElement addNewClientLink;

	    @FindBy(how = How.XPATH, using="//div[@class='chleftboxtab']//span[contains(text(),'Select an Existing Client')]")
	    private WebElement selectExistingClientLink;

	    @FindBy(how = How.XPATH, using="//div[@class='chleftboxtab credit_dispute_wizard']//span[contains(text(), 'Run Credit Dispute Wizard')]")
	    private WebElement runCreditDisputeWizardLink;

	    public HomePageQuickStartSectionClientSelectionWidget getHomePageQuickStartSectionClientSelectionWidget() {
	        return homePageQuickStartSectionClientSelectionWidget;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getAddNewClientLink() {
	        return addNewClientLink;
	    }

	    public WebElement getSelectExistingClientLink() {
	        return selectExistingClientLink;
	    }

	    public WebElement getRunCreditDisputeWizardLink() {
	        return runCreditDisputeWizardLink;
	    }
	}

