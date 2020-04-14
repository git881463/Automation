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
	 * Class representing Dashboard Page Client Overview Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPageClientOverviewSection extends AbstractBasePageObject<DashboardPageClientOverviewSection> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPageClientOverviewSection.class);

	    private static final String relativeUrl = "/dashboard";

	    public DashboardPageClientOverviewSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page client overview section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//select[@id='conversion_rates_dd'][@onchange='return update_overview_info(this.value);']")
	    private WebElement timePeriod;

	    @FindBy(how = How.ID, using = "new_leads_count")
	    private WebElement newLeadsCount;

	    @FindBy(how = How.ID, using = "new_cont_paid_count")
	    private WebElement convertedToPaidCount;

	    @FindBy(how = How.ID, using = "new_cs_count")
	    private WebElement suspendedCancelledCount;

	    public void selectTimePeriod(int index){
	        select_dropdown_by_index(timePeriod, index);
	    }

	    public WebElement getTimePeriod() {
	        return timePeriod;
	    }

	    public WebElement getNewLeadsCount() {
	        return newLeadsCount;
	    }

	    public WebElement getConvertedToPaidCount() {
	        return convertedToPaidCount;
	    }

	    public WebElement getSuspendedCancelledCount() {
	        return suspendedCancelledCount;
	    }
	}


