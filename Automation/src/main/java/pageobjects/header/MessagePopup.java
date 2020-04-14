package pageobjects.header;

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
	 * Class representing MessagePopup  in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MessagePopup extends AbstractBasePageObject<MessagePopup> {

	    private static final Logger logger = LoggerFactory.getLogger(MessagePopup.class);

	    private static final String relativeUrl = "/";

	    public MessagePopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the message dropdown page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }


	    @FindBy(how = How.XPATH, using = "//div[@id='msgpopup']//a[contains(text(),'Send a new message')]")
	    private WebElement sendMessageLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='msgpopup']//div[@class='seeall']/a")
	    private WebElement seeAllMessagesLink;

	    @FindBy(how = How.ID, using = "fb_msgs_place")
	    private WebElement newMessages;

	    public WebElement getSendMessageLink() {
	        return sendMessageLink;
	    }

	    public WebElement getSeeAllMessagesLink() {
	        return seeAllMessagesLink;
	    }

	    public WebElement getNewMessages() {
	        return newMessages;
	    }
	}

