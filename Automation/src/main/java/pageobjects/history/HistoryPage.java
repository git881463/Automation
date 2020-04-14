package pageobjects.history;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.header.CommonHeaderSection;
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
	 * Class representing History Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HistoryPage extends AbstractBasePageObject<HistoryPage> {

	    private static final Logger logger = LoggerFactory.getLogger(HistoryPage.class);

	    private static final String relativeUrl = "/history";

	    @Autowired
	    private CommonHeaderSection commonHeaderSection;

	    public HistoryPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the history page: " + url, url.endsWith( relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using="//div[contains(text(),'History Log')]")
	    private WebElement historyLog;

	    @FindBy(how = How.CLASS_NAME, using="gridtable")
	    private WebElement historyLogTable;

	    public CommonHeaderSection getCommonHeaderSection() {
	        return commonHeaderSection;
	    }

	    public WebElement getHistoryLogTable() {
	        return historyLogTable;
	    }

	}

