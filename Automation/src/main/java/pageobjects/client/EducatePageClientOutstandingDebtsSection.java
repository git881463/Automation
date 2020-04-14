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
	 * Class representing Educate Page Outstanding Debts Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EducatePageClientOutstandingDebtsSection extends AbstractBasePageObject<EducatePageClientOutstandingDebtsSection> {

	    private static final Logger logger = LoggerFactory.getLogger(EducatePageClientOutstandingDebtsSection.class);

	    private static final String relativeUrl = "/organizer/debt/";

	    @Autowired
	    private EducatePageClientOutstandingDebtsSectionPrintPreviewPopup educatePageClientOutstandingDebtsSectionPrintPreviewPopup;

	    public EducatePageClientOutstandingDebtsSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the educate page outstanding debts section: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox mright']//h2[contains(text(),'DEBTS')]")
	    private WebElement debtsViewerHeader;

	    @FindBy(how = How.ID, using = "chart_div1")
	    private WebElement chartSection;

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox mright']//h2[contains(text(),'CREDIT ACCOUNTS')]")
	    private WebElement creditAccountsHeader;

	    @FindBy(how = How.XPATH, using = "//form[@id='debtForm']//input[@id='account_0']")
	    private WebElement account;

	    @FindBy(how = How.XPATH, using = "//form[@id='debtForm']//input[@id='aprtxt_0']")
	    private WebElement apr;

	    @FindBy(how = How.XPATH, using = "//form[@id='debtForm']//input[@id='limit_0']")
	    private WebElement limit;

	    @FindBy(how = How.XPATH, using = "//form[@id='debtForm']//input[@id='bal_0']")
	    private WebElement balance;

	    @FindBy(how = How.ID, using = "save")
	    private WebElement saveButton;

	    @FindBy(how = How.ID, using = "delete")
	    private WebElement deleteButton;

	    @FindBy(how = How.ID, using = "edit")
	    private WebElement updateButton;

	    @FindBy(how = How.ID, using = "print")
	    private WebElement printButton;

	    public EducatePageClientOutstandingDebtsSectionPrintPreviewPopup getEducatePageClientOutstandingDebtsSectionPrintPreviewPopup() {
	        return educatePageClientOutstandingDebtsSectionPrintPreviewPopup;
	    }

	    public WebElement getDebtsViewerHeader() {
	        return debtsViewerHeader;
	    }

	    public WebElement getChartSection() {
	        return chartSection;
	    }

	    public WebElement getCreditAccountsHeader() {
	        return creditAccountsHeader;
	    }

	    public WebElement getAccount() {
	        return account;
	    }

	    public WebElement getApr() {
	        return apr;
	    }

	    public WebElement getLimit() {
	        return limit;
	    }

	    public WebElement getBalance() {
	        return balance;
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }

	    public WebElement getDeleteButton() {
	        return deleteButton;
	    }

	    public WebElement getUpdateButton() {
	        return updateButton;
	    }

	    public WebElement getPrintButton() {
	        return printButton;
	    }

	    public void inputAccount(String text) {
	        set_text(account, text);
	    }

	    public void inputApr(String text) {
	        set_text(apr, text);
	    }

	    public void inputLimit(String text) {
	        set_text(limit, text);
	    }

	    public void inputBalance(String text) {
	        set_text(balance, text);
	    }

	}

