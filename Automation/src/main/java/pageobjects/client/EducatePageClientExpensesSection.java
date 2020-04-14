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
	public class EducatePageClientExpensesSection extends AbstractBasePageObject<EducatePageClientExpensesSection> {

	    private static final Logger logger = LoggerFactory.getLogger(EducatePageClientExpensesSection.class);

	    private static final String relativeUrl = "/organizer/expenses/";

	    @Autowired
	    private EducatePageClientExpensesSectionPrintPreviewPopup educatePageClientExpensesSectionPrintPreviewPopup;

	    public EducatePageClientExpensesSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the educate page client expenses section: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox mright']//h2[contains(text(),'Daily Expenses')]")
	    private WebElement dailyExpensesSection;

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox mright']//h2[contains(text(),'Monthly Expenses')]")
	    private WebElement monthlyExpensesSection;

	    @FindBy(how = How.XPATH, using = "//form[@id='daily_expense']//input[@id='dailyexpname_0']")
	    private WebElement dailyExpenseName;

	    @FindBy(how = How.XPATH, using = "//form[@id='daily_expense']//input[@id='dailyexp_0']")
	    private WebElement dailyExpenseAmount;

	    @FindBy(how = How.ID, using = "daily_save")
	    private WebElement dailyExpensesSaveButton;

	    @FindBy(how = How.ID, using = "daily_delete")
	    private WebElement dailyExpensesDeleteButton;

	    @FindBy(how = How.ID, using = "daily_edit")
	    private WebElement dailyExpensesUpdateButton;

	    @FindBy(how = How.ID, using = "print")
	    private WebElement dailyExpensesPrintButton;

	    @FindBy(how = How.XPATH, using = "//form[@id='monthly_expense']//input[@id='monthlyexp_1']")
	    private WebElement monthlyExpenseAmount;

	    @FindBy(how = How.ID, using = "monthly_save")
	    private WebElement monthlyExpensesSaveButton;

	    @FindBy(how = How.ID, using = "monthly_delete")
	    private WebElement monthlyExpensesDeleteButton;

	    @FindBy(how = How.ID, using = "monthly_edit")
	    private WebElement monthlyExpensesUpdateButton;

	    @FindBy(how = How.ID, using = "monthly_print")
	    private WebElement monthlyExpensesPrintButton;

	    public EducatePageClientExpensesSectionPrintPreviewPopup getEducatePageClientExpensesSectionPrintPreviewPopup() {
	        return educatePageClientExpensesSectionPrintPreviewPopup;
	    }

	    public WebElement getDailyExpensesSection() {
	        return dailyExpensesSection;
	    }

	    public WebElement getMonthlyExpensesSection() {
	        return monthlyExpensesSection;
	    }

	    public WebElement getDailyExpenseName() {
	        return dailyExpenseName;
	    }

	    public WebElement getDailyExpenseAmount() {
	        return dailyExpenseAmount;
	    }

	    public WebElement getDailyExpensesSaveButton() {
	        return dailyExpensesSaveButton;
	    }

	    public WebElement getDailyExpensesDeleteButton() {
	        return dailyExpensesDeleteButton;
	    }

	    public WebElement getDailyExpensesUpdateButton() {
	        return dailyExpensesUpdateButton;
	    }

	    public WebElement getDailyExpensesPrintButton() {
	        return dailyExpensesPrintButton;
	    }

	    public WebElement getMonthlyExpenseAmount() {
	        return monthlyExpenseAmount;
	    }

	    public WebElement getMonthlyExpensesSaveButton() {
	        return monthlyExpensesSaveButton;
	    }

	    public WebElement getMonthlyExpensesDeleteButton() {
	        return monthlyExpensesDeleteButton;
	    }

	    public WebElement getMonthlyExpensesUpdateButton() {
	        return monthlyExpensesUpdateButton;
	    }

	    public WebElement getMonthlyExpensesPrintButton() {
	        return monthlyExpensesPrintButton;
	    }

	    public void inputDailyExpenseName(String text) {
	        set_text(dailyExpenseName, text);
	    }

	    public void inputDailyExpenseAmount(String text) {
	        set_text(dailyExpenseAmount, text);
	    }

	    public void inputMonthlyExpenseAmount(String text) {
	        set_text(monthlyExpenseAmount, text);
	    }

	}


