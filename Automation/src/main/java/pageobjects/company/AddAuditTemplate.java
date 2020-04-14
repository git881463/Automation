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
	 * Class representing Add Audit Template page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddAuditTemplate extends AbstractBasePageObject<AddAuditTemplate> {

	    private static final Logger logger = LoggerFactory.getLogger(AddAuditTemplate.class);

	    private static final String relativeUrl = "/addaudittemplate";

	    public AddAuditTemplate(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the add audit template page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='mycompany']/h4[contains(text(),'Add Audit')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "aname")
	    private WebElement auditName;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement letterEditor;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement saveTemplateButton;

	    public void inputAuditName(String text) {
	        set_text(auditName, text);
	    }

	    public void inputLDetails(String text) {
	        set_text(letterEditor, text);
	    }

	    public WebElement getSaveTemplateButton() {
	        return saveTemplateButton;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }
	}

