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
	 * Class representing Educate Page within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EducatePage  extends AbstractBasePageObject<EducatePage> {

	    private static final Logger logger = LoggerFactory.getLogger(EducatePage.class);

	    private static final String relativeUrl = "/organizer/index/";

	    @Autowired
	    private EducatePageClientOutstandingDebtsSection educatePageClientOutstandingDebtsSection;

	    @Autowired
	    private EducatePageClientExpensesSection educatePageClientExpensesSection;

	    @Autowired
	    private EducatePageCalculatorsSection educatePageCalculatorsSection;

	    public EducatePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the educate page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//h2[contains(text(),'OUTSTANDING DEBTS')]")
	    private WebElement clientsOutstandingDebts;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//h2[contains(text(),'EXPENSES')]")
	    private WebElement clientsExpenses;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//h2[contains(text(),'CALCULATORS')]")
	    private WebElement calculators;

	    public EducatePageClientOutstandingDebtsSection getEducatePageClientOutstandingDebtsSection() {
	        return educatePageClientOutstandingDebtsSection;
	    }

	    public EducatePageClientExpensesSection getEducatePageClientExpensesSection() {
	        return educatePageClientExpensesSection;
	    }

	    public EducatePageCalculatorsSection getEducatePageCalculatorsSection() {
	        return educatePageCalculatorsSection;
	    }

	    public WebElement getClientsOutstandingDebts() {
	        return clientsOutstandingDebts;
	    }

	    public WebElement getClientsExpenses() {
	        return clientsExpenses;
	    }

	    public WebElement getCalculators() {
	        return calculators;
	    }
	}

