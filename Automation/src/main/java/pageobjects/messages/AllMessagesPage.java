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
	 * Class representing All-Messages Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AllMessagesPage extends AbstractBasePageObject<AllMessagesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AllMessagesPage.class);

	    private static final String relativeUrl = "/messages/allmessage";

	    public AllMessagesPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the all-messages page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "messagelistbox")
	    private WebElement messageListPanel;

	    @FindBy(how = How.CLASS_NAME, using = "messagerightbox")
	    private WebElement messageListRightPanel;

	    @FindBy(how = How.ID, using = "search_user")
	    private WebElement searchBox;

	    @FindBy(how = How.XPATH, using = "//div[@class='messagelistbox']/div[@class='messagelist']")
	    private WebElement messageList;

	    @FindBy(how = How.XPATH, using = "//div[@class='messagelistbox']/div[@class='messagelist']/table/tr[1]")
	    private WebElement firstItem;

	    @FindBy(how = How.XPATH, using = "//div[@class='messagedetaillist']/table/tbody/tr[1]")
	    private WebElement firstSentItem;

	    @FindBy(how = How.XPATH, using = "//div[@class='messagedetaillist']/table/tbody/tr[1]//a[@title='Remove from list']")
	    private WebElement removeFirstSentItemLink;

	    @FindBy(how = How.ID, using = "reply_form")
	    private WebElement replyForm;

	    @FindBy(how = How.ID, using = "choose_from_quicknotes")
	    private WebElement quickNotes;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement replyEditor;

	    public void inputSearchText(String text) {
	        set_text(searchBox, text);
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='MultiFile-wrap']/input")
	    private WebElement replyAttachments;

	    @FindBy(how = How.ID, using = "btnreply")
	    private WebElement replyButton;

	    public WebElement getMessageListPanel() {
	        return messageListPanel;
	    }

	    public WebElement getMessageListRightPanel() {
	        return messageListRightPanel;
	    }

	    public WebElement getSearchBox() {
	        return searchBox;
	    }

	    public WebElement getMessageList() {
	        return messageList;
	    }

	    public WebElement getFirstItem() {
	        return firstItem;
	    }

	    public WebElement getFirstSentItem() {
	        return firstSentItem;
	    }

	    public WebElement getRemoveFirstSentItemLink() {
	        return removeFirstSentItemLink;
	    }

	    public WebElement getReplyForm() {
	        return replyForm;
	    }

	    public WebElement getReplyEditor() {
	        return replyEditor;
	    }

	    public WebElement getReplyAttachments() {
	        return replyAttachments;
	    }

	    public WebElement getReplyButton() {
	        return replyButton;
	    }

	    public void inputReply(String text) {
	        set_text(replyEditor, text);
	    }

	    public void selectQuickNotes(int index){
	        select_dropdown_by_index(quickNotes, index);
	    }

	    public void inputSearch(String text) {
	        set_text(searchBox, text);
	    }

	}

