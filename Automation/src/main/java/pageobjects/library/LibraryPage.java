package pageobjects.library;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.FlashMessage;
	import pageobjects.popup.WarningPopup;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Library Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class LibraryPage extends AbstractBasePageObject<LibraryPage> {

	    private static final Logger logger = LoggerFactory.getLogger(LibraryPage.class);

	    private static final String relativeUrl = "/mediacenter";

	    @Autowired
	    private AddNewLettersPage addNewLettersPage;

	    @Autowired
	    private EditLetterPage editLetterPage;

	    @Autowired
	    private WarningPopup warningPopup;

	    @Autowired
	    private FlashMessage flashMessage;

	    public LibraryPage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    public void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the library page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Search Letters')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "librarylist")
	    private WebElement lettersList;

	    @FindBy(how = How.XPATH, using = "//div[@class='addnew-btn']/a[contains(text(),'Add New Letter')]")
	    private WebElement addNewLettersButton;

	    @FindBy(how = How.ID, using = "sortletter")
	    private WebElement sortLettersButton;

	    @FindBy(how = How.ID, using = "sortdone")
	    private WebElement sortDoneButton;

	    @FindBy(how = How.ID, using = "srch_title")
	    private WebElement searchTitle;

	    @FindBy(how = How.ID, using = "srch_cat")
	    private WebElement searchCategory;

	    @FindBy(how = How.ID, using = "qfilter")
	    private WebElement quickFilter;

	    @FindBy(how = How.ID, using = "button")
	    private WebElement searchButton;

	    @FindBy(how = How.XPATH, using = "//table[@id='librarylist']//tr[2]/td[4]//img")
	    private WebElement favoriteItemLink;

	    @FindBy(how = How.XPATH, using = "//table[@id='librarylist']//tr[2]/td[5]/a[2]")
	    private WebElement deleteItemLink;

	    @FindBy(how = How.XPATH, using = "//table[@id='librarylist']/tbody/tr[2]/td[1]/a")
	    private WebElement searchResult;

	    @FindBy(how = How.XPATH, using = "//table[@id='librarylist']/tbody/tr[2]")
	    private WebElement letter1;

	    @FindBy(how = How.XPATH, using = "//table[@id='librarylist']/tbody/tr[4]")
	    private WebElement letter3;

	    public AddNewLettersPage getAddNewLettersPage() {
	        return addNewLettersPage;
	    }

	    public EditLetterPage getEditLetterPage() {
	        return editLetterPage;
	    }

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getLettersList() {
	        return lettersList;
	    }

	    public WebElement getAddNewLettersButton() {
	        return addNewLettersButton;
	    }

	    public WebElement getSortLettersButton() {
	        return sortLettersButton;
	    }

	    public WebElement getSortDoneButton() {
	        return sortDoneButton;
	    }

	    public WebElement getSearchTitle() {
	        return searchTitle;
	    }

	    public WebElement getSearchCategory() {
	        return searchCategory;
	    }

	    public WebElement getQuickFilter() {
	        return quickFilter;
	    }

	    public void inputSearchTitle(String text) {
	        set_text(searchTitle, text);
	    }

	    public void selectSearchCategory(String text){
	        select_dropdown_by_value(searchCategory, text);
	    }

	    public void selectQuickFilter(String text){
	        select_dropdown_by_value(quickFilter, text);
	    }

	    public WebElement getSearchButton() {
	        return searchButton;
	    }

	    public WebElement getFavoriteItemLink() {
	        return favoriteItemLink;
	    }

	    public WebElement getDeleteItemLink() {
	        return deleteItemLink;
	    }

	    public WebElement getSearchResult() {
	        return searchResult;
	    }

	    public void shuffleLetters(){
	        Actions actions = new Actions(webdriver);

	        //Dragged and dropped
	        actions.dragAndDrop(letter1, letter3).build().perform();
	    }
	}

