package pageobjects.client;

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
	 * Class representing Search Client Page Basic Search in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SearchClientPageBasicSearchSection extends AbstractBasePageObject<SearchClientPageBasicSearchSection> {

	    private static final Logger logger = LoggerFactory.getLogger(SearchClientPageBasicSearchSection.class);

	    private static final String relativeUrl = "/";

	    public SearchClientPageBasicSearchSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the search client basic search page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "sname")
	    private WebElement clientNameInput;

	    @FindBy(how = How.XPATH, using = "//table[@id='pnlbasicsearch']//input[@class='btnsubmit']")
	    private WebElement searchLink;

	    @FindBy(how = How.XPATH, using = "//table[@id='pnlbasicsearch']//a[@class='lnkadvance']")
	    private WebElement advancedSearchLink;

	    public WebElement getClientNameInput() {
	        return clientNameInput;
	    }

	    public WebElement getSearchLink() {
	        return searchLink;
	    }

	    public WebElement getAdvancedSearchLink() {
	        return advancedSearchLink;
	    }

	    public void inputClientName(String text) {
	        set_text(clientNameInput, text);
	    }
	}
