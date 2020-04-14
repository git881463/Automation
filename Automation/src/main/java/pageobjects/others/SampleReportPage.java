package pageobjects.others;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.util.ArrayList;

	/**
	 * Class representing Quick videos Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SampleReportPage extends AbstractBasePageObject<SampleReportPage> {

	    private static final Logger logger = LoggerFactory.getLogger(SampleReportPage.class);

	    private static final String relativeUrl = "/samplereport";

	    public SampleReportPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the sample report page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    public void isLoadedInTab() throws Error {
	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
	        String url = getDriver().getCurrentUrl();
	        logger.debug("url before: {}", url);
	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab

	        url = getDriver().getCurrentUrl();
	        logger.debug("url now: {}", url);
	        Assert.assertTrue("Not on the sample report page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	        getDriver().close();
	        webdriver.switchTo().window(tabs.get(0)); //switches to old tab
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='FtgMenuHeaderContent']//a")
	    private WebElement viewFullReportLink;

	    @FindBy(how = How.CLASS_NAME, using = "FtgMenuHeaderContent")
	    private WebElement subHeader;

	    @FindBy(how = How.XPATH, using = "//div[@id='FtgCrTabContent1']//div[contains(text(),'Your Personal Profile')]")
	    private WebElement fullReportHeader;

	    public WebElement getViewFullReportLink() {
	        return viewFullReportLink;
	    }

	    public WebElement getFullReportHeader() {
	        return fullReportHeader;
	    }

	    public WebElement getSubHeader() {
	        return subHeader;
	    }
	}


