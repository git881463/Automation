package pageobjects.messages;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.client.ClientTabNavigationBar;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Messages Tabs Navigation Bar to navigate across the message tabs.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MessageSectionNavigationBar extends AbstractBasePageObject<MessageSectionNavigationBar> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientTabNavigationBar.class);

	    private static final String relativeUrl = "/";

	    public MessageSectionNavigationBar(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
//	        navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the Message Section navigation bar page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[1]/a")
	    private WebElement allMessagesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[2]/a")
	    private WebElement clientMessagesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[3]/a")
	    private WebElement affiliateMessagesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[4]/a")
	    private WebElement teamMemberMessagesTab;

	    @FindBy(how = How.XPATH, using = "//div[@class='innermenu']//ul/li[5]/a")
	    private WebElement sendNewMessageTab;

	    public WebElement getAllMessagesTab() {
	        return allMessagesTab;
	    }

	    public WebElement getClientMessagesTab() {
	        return clientMessagesTab;
	    }

	    public WebElement getAffiliateMessagesTab() {
	        return affiliateMessagesTab;
	    }

	    public WebElement getTeamMemberMessagesTab() {
	        return teamMemberMessagesTab;
	    }

	    public WebElement getSendNewMessageTab() {
	        return sendNewMessageTab;
	    }
	}
