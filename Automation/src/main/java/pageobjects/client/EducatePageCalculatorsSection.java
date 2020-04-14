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
	 * Class representing Educate Page Calculators section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EducatePageCalculatorsSection extends AbstractBasePageObject<EducatePageCalculatorsSection> {

	    private static final Logger logger = LoggerFactory.getLogger(EducatePageCalculatorsSection.class);

	    private static final String relativeUrl = "/organizer/expenses/";

	    public EducatePageCalculatorsSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the educate page calculators section: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox mright']//h2[contains(text(),'STANDARD CALCULATOR')]")
	    private WebElement standardCalculatorSection;

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox mright']//h2[contains(text(),'MORTGAGE CALCULATOR')]")
	    private WebElement mortgageCalculatorSection;

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox']//h2[contains(text(),'SAVING CALCULATOR')]")
	    private WebElement savingCalculatorSection;

	    @FindBy(how = How.XPATH, using = "//div[@class='calcbox']//h2[contains(text(),'HOW LONG WILL IT TAKE TO PAY OFF MY CREDIT CARD?')]")
	    private WebElement creditCardCalculatorSection;

	    public WebElement getStandardCalculatorSection() {
	        return standardCalculatorSection;
	    }

	    public WebElement getMortgageCalculatorSection() {
	        return mortgageCalculatorSection;
	    }

	    public WebElement getSavingCalculatorSection() {
	        return savingCalculatorSection;
	    }

	    public WebElement getCreditCardCalculatorSection() {
	        return creditCardCalculatorSection;
	    }
	}

