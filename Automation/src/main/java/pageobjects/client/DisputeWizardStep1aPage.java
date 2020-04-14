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
	 * Class representing Dispute Wizard Step1a Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeWizardStep1aPage extends AbstractBasePageObject<DisputeWizardStep1aPage> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeWizardStep1aPage.class);

	    private static final String relativeUrl = "/wizard/step1a/";

	    public DisputeWizardStep1aPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute wizard step 1a page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "equifax_1")
	    private WebElement equifaxOption;

	    @FindBy(how = How.XPATH, using = "//div[@class='next-btn-big next']/a")
	    private WebElement nextButton;

	    @FindBy(how = How.ID, using = "frm_bureaus_editor")
	    private WebElement formEditor;

	    public WebElement getEquifaxOption() {
	        return equifaxOption;
	    }

	    public WebElement getNextButton() {
	        return nextButton;
	    }

	    public WebElement getFormEditor() {
	        return formEditor;
	    }
	}
