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
	 * Class representing Dashboard Page Sales Growth Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPageSalesGrowthSection extends AbstractBasePageObject<DashboardPageSalesGrowthSection> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPageSalesGrowthSection.class);

	    private static final String relativeUrl = "/dashboard";

	    public DashboardPageSalesGrowthSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page sales growth section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "dd_2")
	    private WebElement timePeriod;

	    @FindBy(how = How.ID, using = "revenue_lnk")
	    private WebElement revenuLink;

	    @FindBy(how = How.ID, using = "revenue_txt")
	    private WebElement revenuText;

	    @FindBy(how = How.ID, using = "new_leads_lnk")
	    private WebElement newLeadsLink;

	    @FindBy(how = How.ID, using = "new_leads_txt")
	    private WebElement newLeadsText;

	    @FindBy(how = How.ID, using = "active_clients_lnk")
	    private WebElement activeClientsLink;

	    @FindBy(how = How.ID, using = "active_clients_txt")
	    private WebElement activeClientsText;

	    @FindBy(how = How.ID, using = "affiliate_lnk")
	    private WebElement affiliatesLink;

	    @FindBy(how = How.ID, using = "affiliate_txt")
	    private WebElement affiliatesText;

	    @FindBy(how = How.ID, using = "revenuechart")
	    private WebElement revenueChart;

	    public void selectTimePeriod(int index){
	        select_dropdown_by_index(timePeriod, index);
	    }

	    public WebElement getTimePeriod() {
	        return timePeriod;
	    }

	    public WebElement getRevenuLink() {
	        return revenuLink;
	    }

	    public WebElement getNewLeadsLink() {
	        return newLeadsLink;
	    }

	    public WebElement getActiveClientsLink() {
	        return activeClientsLink;
	    }

	    public WebElement getAffiliatesLink() {
	        return affiliatesLink;
	    }

	    public WebElement getRevenuText() {
	        return revenuText;
	    }

	    public WebElement getNewLeadsText() {
	        return newLeadsText;
	    }

	    public WebElement getActiveClientsText() {
	        return activeClientsText;
	    }

	    public WebElement getAffiliatesText() {
	        return affiliatesText;
	    }

	    public WebElement getRevenueChart() {
	        return revenueChart;
	    }
	}

