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
	import org.springframework.beans.factory.annotation.Autowired;


	/**
	 * Class representing Dashboard Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPage extends AbstractBasePageObject<DashboardPage> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

	    private static final String relativeUrl = "/dashboard";

	    @Autowired
	    private DashboardPageClientOverviewSection dashboardPageClientOverviewSection;

	    @Autowired
	    private DashboardPageRateOverviewSection dashboardPageRateOverviewSection;

	    @Autowired
	    private DashboardPageSalesGrowthSection dashboardPageSalesGrowthSection;

	    @Autowired
	    private DashboardPageClientStagesSection dashboardPageClientStagesSection;

	    @Autowired
	    private DashboardPageClientStatusSection dashboardPageClientStatusSection;

	    @Autowired
	    private DashboardPageTopAffiliateSection dashboardPageTopAffiliateSection;

	    @Autowired
	    private DashboardPageTopTeamMembersSection dashboardPageTopTeamMembersSection;

	    public DashboardPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page: " + url, url.endsWith( relativeUrl ));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Business Dashboard')]")
	    private WebElement pageTitle;

	    public DashboardPageClientOverviewSection getDashboardPageClientOverviewSection() {
	        return dashboardPageClientOverviewSection;
	    }

	    public DashboardPageRateOverviewSection getDashboardPageRateOverviewSection() {
	        return dashboardPageRateOverviewSection;
	    }

	    public DashboardPageSalesGrowthSection getDashboardPageSalesGrowthSection() {
	        return dashboardPageSalesGrowthSection;
	    }

	    public DashboardPageClientStagesSection getDashboardPageClientStagesSection() {
	        return dashboardPageClientStagesSection;
	    }

	    public DashboardPageClientStatusSection getDashboardPageClientStatusSection() {
	        return dashboardPageClientStatusSection;
	    }

	    public DashboardPageTopAffiliateSection getDashboardPageTopAffiliateSection() {
	        return dashboardPageTopAffiliateSection;
	    }

	    public DashboardPageTopTeamMembersSection getDashboardPageTopTeamMembersSection() {
	        return dashboardPageTopTeamMembersSection;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	}
