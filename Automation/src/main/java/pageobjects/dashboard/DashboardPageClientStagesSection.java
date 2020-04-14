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
	 * Class representing Dashboard Page Client Stages Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPageClientStagesSection extends AbstractBasePageObject<DashboardPageClientStagesSection> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPageClientStagesSection.class);

	    private static final String relativeUrl = "/dashboard";

	    public DashboardPageClientStagesSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page client stages section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }
	    @FindBy(how = How.ID, using = "client_life_cycle")
	    private WebElement clientLifeCycle;

	    @FindBy(how = How.ID, using = "life_cycle_chart")
	    private WebElement lifeCycleChart;

	    public void selectClientLifeCycle(int index){
	        select_dropdown_by_index(clientLifeCycle, index);
	    }

	    public WebElement getClientLifeCycle() {
	        return clientLifeCycle;
	    }

	    public WebElement getLifeCycleChart() {
	        return lifeCycleChart;
	    }
	}


