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
	 * Class representing Client Dashboard Page Task Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageTaskSection extends AbstractBasePageObject<ClientDashboardPageTaskSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageTaskSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private ClientDashboardPageTaskSectionTeamTaskSubSection clientDashboardPageTaskSectionTeamTaskSubSection;

	    @Autowired
	    private ClientDashboardPageTaskSectionClientTaskSubSection clientDashboardPageTaskSectionClientTaskSubSection;

	    public ClientDashboardPageTaskSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard task section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//ul[@class='tab']//a[contains(text(),'Team tasks')]")
	    private WebElement teamTasksTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='reminder']//ul[@class='tab']//a[contains(text(),'Client')]")
	    private WebElement clientTasksTab;

	    public ClientDashboardPageTaskSectionTeamTaskSubSection getClientDashboardPageTaskSectionTeamTaskSubSection() {
	        return clientDashboardPageTaskSectionTeamTaskSubSection;
	    }

	    public ClientDashboardPageTaskSectionClientTaskSubSection getClientDashboardPageTaskSectionClientTaskSubSection() {
	        return clientDashboardPageTaskSectionClientTaskSubSection;
	    }

	    public WebElement getTeamTasksTab() {
	        return teamTasksTab;
	    }

	    public WebElement getClientTasksTab() {
	        return clientTasksTab;
	    }
	}

