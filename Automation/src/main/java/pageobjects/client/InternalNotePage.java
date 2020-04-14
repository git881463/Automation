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
	 * Class representing Internal Note Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class InternalNotePage extends AbstractBasePageObject<InternalNotePage> {

	    private static final Logger logger = LoggerFactory.getLogger(InternalNotePage.class);

	    private static final String relativeUrl = "/notes/add";

	    public InternalNotePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the internal note page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "addnote")
	    private WebElement form;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement noteEditor;

	    @FindBy(how = How.XPATH, using = "//div[@class='MultiFile-wrap']/input")
	    private WebElement attachments;

	    @FindBy(how = How.XPATH, using = "//form[@id='addnote']//input[@id='submit']")
	    private WebElement saveNoteButton;

	    public void inputNotes(String text) {
	        set_text(noteEditor, text);
	    }

	    public WebElement getAttachments() {
	        return attachments;
	    }

	    public WebElement getSaveNoteButton() {
	        return saveNoteButton;
	    }
	}

