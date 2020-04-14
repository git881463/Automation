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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Client Dashboard Page Score Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageScoreSection extends AbstractBasePageObject<ClientDashboardPageScoreSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageScoreSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private ManageScorePopup manageScorePopup;

	    public ClientDashboardPageScoreSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard score section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "project")
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='project']//div[@id='storescontent']")
	    private WebElement scoreContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='project']//div[@id='chart_column']")
	    private WebElement chartContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='project']//a[contains(text(),'Add/Edit Scores')]")
	    private WebElement addEditScoreLink;

	    public ManageScorePopup getManageScorePopup() {
	        return manageScorePopup;
	    }

	    public void setManageScorePopup(ManageScorePopup manageScorePopup) {
	        this.manageScorePopup = manageScorePopup;
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getScoreContainer() {
	        return scoreContainer;
	    }

	    public WebElement getChartContainer() {
	        return chartContainer;
	    }

	    public WebElement getAddEditScoreLink() {
	        return addEditScoreLink;
	    }
	}

