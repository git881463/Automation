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
	 * Class representing Add QuickNote Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddQuickNotePage extends AbstractBasePageObject<AddQuickNotePage> {

	    private static final Logger logger = LoggerFactory.getLogger(AddQuickNotePage.class);

	    private static final String relativeUrl = "/quicknotes/add";

	    public AddQuickNotePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add quick note page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "title")
	    private WebElement title;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement messageEditor;

	    @FindBy(how = How.XPATH, using = "//div[@class='back-btn']//a[contains(text(),'Back')]")
	    private WebElement backButton;

	    public WebElement getTitle() {
	        return title;
	    }

	    public WebElement getMessageEditor() {
	        return messageEditor;
	    }

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    public WebElement getBackButton() {
	        return backButton;
	    }

	    public void inputTitle(String text) {
	        set_text(title, text);
	    }

	    public void inputMessage(String text) {
	        set_text(messageEditor, text);
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }
	}

