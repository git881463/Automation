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
	 * Class representing Dashboard Page Client Status Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DashboardPageClientStatusSection extends AbstractBasePageObject<DashboardPageClientStatusSection> {

	    private static final Logger logger = LoggerFactory.getLogger(DashboardPageClientStatusSection.class);

	    private static final String relativeUrl = "/dashboard";

	    public DashboardPageClientStatusSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dashboard page client status section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }
	    @FindBy(how = How.ID, using = "client_statuses")
	    private WebElement clientStatus;

	    @FindBy(how = How.ID, using = "client_count_with_status")
	    private WebElement statusChart;

	    public void selectClientStatus(int index){
	        select_dropdown_by_index(clientStatus, index);
	    }

	    public WebElement getClientStatus() {
	        return clientStatus;
	    }

	    public WebElement getStatusChart() {
	        return statusChart;
	    }
	}

