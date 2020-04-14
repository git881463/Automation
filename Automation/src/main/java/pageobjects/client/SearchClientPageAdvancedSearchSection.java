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
	 * Class representing Search Client Page Advanced Search in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SearchClientPageAdvancedSearchSection extends AbstractBasePageObject<SearchClientPageAdvancedSearchSection> {

	    private static final Logger logger = LoggerFactory.getLogger(SearchClientPageAdvancedSearchSection.class);

	    private static final String relativeUrl = "/";


	    public SearchClientPageAdvancedSearchSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the search client advanced search page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "sdate")
	    private WebElement startDateInput;

	    @FindBy(how = How.ID, using = "addedfrom")
	    private WebElement addedFromDateInput;

	    @FindBy(how = How.ID, using = "qfilter")
	    private WebElement statusFilter;

	    @FindBy(how = How.ID, using = "referred_by")
	    private WebElement referrer;

	    @FindBy(how = How.ID, using = "assigned_to")
	    private WebElement assignedTeamMember;

	    @FindBy(how = How.ID, using = "phone")
	    private WebElement phoneNumberInput;

	    @FindBy(how = How.XPATH, using = "//table[@id='pnladvanced']//input[@id='button']")
	    private WebElement submitButton;

	    @FindBy(how = How.XPATH, using = "//table[@id='pnladvanced']//a[@id='lnkbasic']")
	    private WebElement basicSearchButton;

	    public WebElement getStartDateInput() {
	        return startDateInput;
	    }

	    public WebElement getAddedFromDateInput() {
	        return addedFromDateInput;
	    }

	    public WebElement getStatusFilter() {
	        return statusFilter;
	    }

	    public WebElement getReferrer() {
	        return referrer;
	    }

	    public WebElement getAssignedTeamMember() {
	        return assignedTeamMember;
	    }

	    public WebElement getPhoneNumberInput() {
	        return phoneNumberInput;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }

	    public void inputStartDate(String text) {
	        set_text(startDateInput, text);
	    }

	    public void inputAddedFromDate(String text) {
	        set_text(addedFromDateInput, text);
	    }

	    public void selectStatus(String value){
	        select_dropdown_by_value(statusFilter, value);
	    }

	    public void selectReferrer(String value){
	        select_dropdown_by_value(referrer, value);
	    }

	    public void selectAssignedTeamMemberByIndex(int index){
	        select_dropdown_by_index(assignedTeamMember, index);
	    }

	    public void inputPhoneNumber(String text) {
	        set_text(phoneNumberInput, text);
	    }

	    public WebElement getBasicSearchButton() {
	        return basicSearchButton;
	    }
	}

