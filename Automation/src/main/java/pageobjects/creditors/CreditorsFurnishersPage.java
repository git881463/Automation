package pageobjects.creditors;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.FlashMessage;
	import pageobjects.popup.WarningPopup;
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
	 * Class representing Creditors/Furnishers Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CreditorsFurnishersPage extends AbstractBasePageObject<CreditorsFurnishersPage> {

	    private static final Logger logger = LoggerFactory.getLogger(CreditorsFurnishersPage.class);

	    private static final String relativeUrl = "/furnishers";

	    @Autowired
	    private FlashMessage flashMessage;

	    @Autowired
	    private WarningPopup warningPopup;

	    @Autowired
	    private ImportCreditorsFurnishersPopup importCreditorsFurnishersPopup;

	    @Autowired
	    private PrintCreditorsFurnishersPopup printCreditorsFurnishersPopup;

	    public CreditorsFurnishersPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the creditors/furnishers page: " + url, url.endsWith( relativeUrl ));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "ajax_loader_new")
	    private WebElement ajaxLoader;

	    @FindBy(how = How.XPATH, using = "//form[@id='furnishers']//div[contains(text(),'Creditors/Furnishers')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "cname")
	    private WebElement companyNameInput;

	    @FindBy(how = How.XPATH, using = "//form[@id='furnishers']//input[@placeholder='Enter a location']")
	    private WebElement addressInput;

	    @FindBy(how = How.ID, using = "city")
	    private WebElement cityInput;

	    @FindBy(how = How.ID, using = "state")
	    private WebElement stateInput;

	    @FindBy(how = How.ID, using = "zip")
	    private WebElement zipInput;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    @FindBy(how = How.ID, using = "import_creditor_furnisher")
	    private WebElement importLink;

	    @FindBy(how = How.ID, using = "export_creditor_furnisher")
	    private WebElement exportLink;

	    @FindBy(how = How.ID, using = "print_creditor_furnisher")
	    private WebElement printLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='alphe-pager']//a[contains(text(),'B')]")
	    private WebElement alphabetFilter;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//tbody//a[contains(text(),'B')]")
	    private WebElement filteredResult;

	    @FindBy(how = How.ID, using = "quick_search")
	    private WebElement quickSearchInput;

	    @FindBy(how = How.XPATH, using = "//form[@id='furnishers']//div[@id='gridData']//tbody/tr[1]/td[1]/a")
	    private WebElement firstCredFurnLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='furnishers']//div[@id='gridData']//tbody/tr[1]")
	    private WebElement searchResult;

	    @FindBy(how = How.XPATH, using = "//form[@id='furnishers']//div[@id='gridData']//tbody/tr[1]/td[1]/a")
	    private WebElement searchResultDetailLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='furnishers']//div[@id='gridData']//tbody/tr[1]/td[2]/a")
	    private WebElement searchResultDeleteLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='furnishers']//div[@id='gridData']")
	    private WebElement creditorsList;

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public ImportCreditorsFurnishersPopup getImportCreditorsFurnishersPopup() {
	        return importCreditorsFurnishersPopup;
	    }

	    public PrintCreditorsFurnishersPopup getPrintCreditorsFurnishersPopup() {
	        return printCreditorsFurnishersPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getCreditorsList() {
	        return creditorsList;
	    }

	    public WebElement getCompanyNameInput() {
	        return companyNameInput;
	    }

	    public void inputCompanyName(String text) {
	        set_text(companyNameInput, text);
	    }

	    public void inputAddress(String text) {
	        set_text(addressInput, text);
	    }

	    public void inputCity(String text) {
	        set_text(cityInput, text);
	    }

	    public void inputState(String text) {
	        set_text(stateInput, text);
	    }

	    public void inputZip(String text) {
	        set_text(zipInput, text);
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }

	    public WebElement getQuickSearchInput() {
	        return quickSearchInput;
	    }

	    public void inputQuickSerarch(String text) {
	        set_text_for_autocomplete(quickSearchInput, text);
	    }

	    public WebElement getAjaxLoader() {
	        return ajaxLoader;
	    }

	    public WebElement getSearchResultDeleteLink() {
	        return searchResultDeleteLink;
	    }

	    public WebElement getImportLink() {
	        return importLink;
	    }

	    public WebElement getExportLink() {
	        return exportLink;
	    }

	    public WebElement getPrintLink() {
	        return printLink;
	    }

	    public WebElement getAlphabetFilter() {
	        return alphabetFilter;
	    }

	    public WebElement getFilteredResult() {
	        return filteredResult;
	    }

	    public WebElement getSearchResult() {
	        return searchResult;
	    }

	    public WebElement getSearchResultDetailLink() {
	        return searchResultDetailLink;
	    }

	    public WebElement getFirstCredFurnLink() {
	        return firstCredFurnLink;
	    }
	}
