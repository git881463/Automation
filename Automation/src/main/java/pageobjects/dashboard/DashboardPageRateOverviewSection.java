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
	 * Class representing Dashboard Page Rate Overview Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPageRateOverviewSection extends AbstractBasePageObject<DashboardPageRateOverviewSection> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPageRateOverviewSection.class);

	    private static final String relativeUrl = "/dashboard";

	    public DashboardPageRateOverviewSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page rate overview section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//select[@id='conversion_rates_dd'][@onchange='return all_overview_rate(this.value);']")
	    private WebElement timePeriod;

	    @FindBy(how = How.ID, using = "conversation_per")
	    private WebElement conversionRate;

	    @FindBy(how = How.ID, using = "churn_per")
	    private WebElement churnRate;

	    @FindBy(how = How.ID, using = "avg_revenue_per")
	    private WebElement avgRevenuePerClient;

	    public void selectTimePeriod(int index){
	        select_dropdown_by_index(timePeriod, index);
	    }

	    public WebElement getTimePeriod() {
	        return timePeriod;
	    }

	    public WebElement getConversionRate() {
	        return conversionRate;
	    }

	    public WebElement getChurnRate() {
	        return churnRate;
	    }

	    public WebElement getAvgRevenuePerClient() {
	        return avgRevenuePerClient;
	    }
	}


