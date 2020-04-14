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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Manage QuickNotes Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ManageQuickNotesPage extends AbstractBasePageObject<ManageQuickNotesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ManageQuickNotesPage.class);

	    private static final String relativeUrl = "/quicknotes";

	    @Autowired
	    private AddQuickNotePage addQuickNotePage;

	    @Autowired
	    private EditQuickNotePage editQuickNotePage;

	    public ManageQuickNotesPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the manage quick notes page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='addnew-btn']/a[contains(text(),'Add Quick Note')]")
	    private WebElement addButton;

	    @FindBy(how = How.ID, using = "search_txt")
	    private WebElement searchInput;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//table/tbody/tr[2]/td[4]/a[1]")
	    private WebElement editSearchedNoteLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//table/tbody/tr[2]/td[4]/a[2]")
	    private WebElement removeSearchedNoteLink;

	    public AddQuickNotePage getAddQuickNotePage() {
	        return addQuickNotePage;
	    }

	    public EditQuickNotePage getEditQuickNotePage() {
	        return editQuickNotePage;
	    }

	    public WebElement getAddButton() {
	        return addButton;
	    }

	    public WebElement getSearchInput() {
	        return searchInput;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }

	    public void inputSearch(String text) {
	        set_text(searchInput, text);
	    }

	    public WebElement getEditSearchedNoteLink() {
	        return editSearchedNoteLink;
	    }

	    public WebElement getRemoveSearchedNoteLink() {
	        return removeSearchedNoteLink;
	    }
	}

