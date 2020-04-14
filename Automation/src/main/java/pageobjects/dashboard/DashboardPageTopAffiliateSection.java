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
	 * Class representing Dashboard Page Top Affiliates Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPageTopAffiliateSection extends AbstractBasePageObject<DashboardPageTopAffiliateSection> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPageTopAffiliateSection.class);

	    private static final String relativeUrl = "/dashboard";

	    public DashboardPageTopAffiliateSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page top affiliates section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "affiliates_dd")
	    private WebElement timePeriod;

	    @FindBy(how = How.ID, using = "referrals_txt")
	    private WebElement referralsText;

	    @FindBy(how = How.ID, using = "referrals_lnk")
	    private WebElement referralsLink;

	    @FindBy(how = How.ID, using = "aff_active_c_txt")
	    private WebElement clientsText;

	    @FindBy(how = How.ID, using = "aff_active_c_lnk")
	    private WebElement clientsLink;

	    @FindBy(how = How.ID, using = "aff_revenue_txt")
	    private WebElement revenuesText;

	    @FindBy(how = How.ID, using = "aff_revenue_lnk")
	    private WebElement revenuesLink;

	    @FindBy(how = How.ID, using = "top_affiliates_place")
	    private WebElement topAffiliatesPlace;

	    public void selectTimePeriod(int index){
	        select_dropdown_by_index(timePeriod, index);
	    }

	    public WebElement getTimePeriod() {
	        return timePeriod;
	    }

	    public WebElement getReferralsText() {
	        return referralsText;
	    }

	    public WebElement getReferralsLink() {
	        return referralsLink;
	    }

	    public WebElement getClientsText() {
	        return clientsText;
	    }

	    public WebElement getClientsLink() {
	        return clientsLink;
	    }

	    public WebElement getRevenuesText() {
	        return revenuesText;
	    }

	    public WebElement getRevenuesLink() {
	        return revenuesLink;
	    }

	    public WebElement getTopAffiliatesPlace() {
	        return topAffiliatesPlace;
	    }
	}

