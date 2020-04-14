package pageobjects.messages;

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
	 * Class representing Affiliates Messages Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AffiliateMessagesPage extends AbstractBasePageObject<AffiliateMessagesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AffiliateMessagesPage.class);

	    private static final String relativeUrl = "/messages/affiliate";

	    public AffiliateMessagesPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the affiliates-messages page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "search_user")
	    private WebElement searchBox;

	    public WebElement getSearchBox() {
	        return searchBox;
	    }

	    public void inputSearch(String text) {
	        set_text_for_autocomplete_forced(searchBox, text);
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[@class='messagelist']/table/tr[1]")
	    private WebElement searchResult;

	    public WebElement getSearchResult() {
	        return searchResult;
	    }
	}
