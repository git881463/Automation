package pageobjects.company;

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
	 * Class representing Add Agreement page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddAgreementPage extends AbstractBasePageObject<AddAgreementPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AddAgreementPage.class);

	    private static final String relativeUrl = "/addagreement";

	    public AddAgreementPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add agreement page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='mycompany']/h4[contains(text(),'Add Agreement')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "aname")
	    private WebElement agreementName;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement letterEditor;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement saveAgreementButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public void inputAgreementName(String text) {
	        set_text(agreementName, text);
	    }

	    public void inputLDetails(String text) {
	        set_text(letterEditor, text);
	    }

	    public WebElement getSaveAgreementButton() {
	        return saveAgreementButton;
	    }
	}


