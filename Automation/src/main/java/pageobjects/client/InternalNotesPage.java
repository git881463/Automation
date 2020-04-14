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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Internal Notes Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class InternalNotesPage extends AbstractBasePageObject<InternalNotesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(InternalNotesPage.class);

	    private static final String relativeUrl = "/notes/index";

	    @Autowired
	    private InternalNotePage internalNotePage;

	    @Autowired
	    private EditInternalNotePage editInternalNotePage;

	    public InternalNotesPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the internal notes page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='frmsearch']//div[contains(text(),'Internal notes')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//form[@id='frmsearch']//a[contains(text(),'Add Internal Notes')]")
	    private WebElement addNoteButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']/table/tbody/tr[2]/td[5]/a[1]")
	    private WebElement editNoteLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']/table/tbody/tr[2]/td[5]/a[2]")
	    private WebElement removeNoteLink;

	    public InternalNotePage getInternalNotePage() {
	        return internalNotePage;
	    }

	    public EditInternalNotePage getEditInternalNotePage() {
	        return editInternalNotePage;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getAddNoteButton() {
	        return addNoteButton;
	    }

	    public WebElement getEditNoteLink() {
	        return editNoteLink;
	    }

	    public WebElement getRemoveNoteLink() {
	        return removeNoteLink;
	    }
	}
