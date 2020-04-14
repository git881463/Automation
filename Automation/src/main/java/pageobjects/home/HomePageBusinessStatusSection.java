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
	 * Class representing Home Page Business Status Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageBusinessStatusSection extends AbstractBasePageObject<HomePageBusinessStatusSection> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageBusinessStatusSection.class);

	    private static final String relativeUrl = "/home";

	    public HomePageBusinessStatusSection(WebDriver driver, WebDriverWait wait, String url) {
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


	    @FindBy(how = How.XPATH, using="//div[@class='chleftbox']//strong[contains(text(),'Business Status')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using="activeclientlink")
	    private WebElement activeClientsLink;

	    @FindBy(how = How.ID, using="affilatelink")
	    private WebElement affiliatesLink;

	    @FindBy(how = How.ID, using="leadslink")
	    private WebElement leadsLink;

	    @FindBy(how = How.ID, using="clientsuccesslink")
	    private WebElement clientSuccessLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox']//a[contains(text(),'View Dashboard')]")
	    private WebElement viewDashboardLink;

	    @FindBy(how = How.ID, using="charttitle")
	    private WebElement chartTitle;

	    @FindBy(how = How.ID, using="linechart")
	    private WebElement lineChart;

	    @FindBy(how = How.XPATH, using="//div[@id='linechart']//*[text()='Area Chart']")
	    private WebElement activeClientsChart;

	    @FindBy(how = How.XPATH, using="//div[@id='linechart']//*[text()='Column Chart']")
	    private WebElement affiliatesChart;

	    @FindBy(how = How.XPATH, using="//div[@id='linechart']//*[text()='Multi-series Column Chart']")
	    private WebElement leadsChart;

	    @FindBy(how = How.XPATH, using="//div[@id='linechart']//*[text()='Doughnut Chart']")
	    private WebElement clientSuccessChart;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getActiveClientsLink() {
	        return activeClientsLink;
	    }

	    public WebElement getAffiliatesLink() {
	        return affiliatesLink;
	    }

	    public WebElement getLeadsLink() {
	        return leadsLink;
	    }

	    public WebElement getClientSuccessLink() {
	        return clientSuccessLink;
	    }

	    public WebElement getViewDashboardLink() {
	        return viewDashboardLink;
	    }

	    public WebElement getChartTitle() {
	        return chartTitle;
	    }

	    public WebElement getLineChart() {
	        return lineChart;
	    }

	    public WebElement getActiveClientsChart() {
	        return activeClientsChart;
	    }

	    public WebElement getAffiliatesChart() {
	        return affiliatesChart;
	    }

	    public WebElement getLeadsChart() {
	        return leadsChart;
	    }

	    public WebElement getClientSuccessChart() {
	        return clientSuccessChart;
	    }

	}
