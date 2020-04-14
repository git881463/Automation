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
	 * Class representing Edit Audit Template page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditAuditTemplatePage extends AbstractBasePageObject<EditAuditTemplatePage> {

	    private static final Logger logger = LoggerFactory.getLogger(EditAuditTemplatePage.class);

	    private static final String relativeUrl = "/editaudittemplate";

	    public EditAuditTemplatePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the edit audit template page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//form[@id='mycompany']/h4[contains(text(),'Edit Audit')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "agreement_txt")
	    private WebElement agreementText;

	    @FindBy(how = How.ID, using = "aname")
	    private WebElement auditName;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement templateEditor;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement saveTemplateButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getAgreementText() {
	        return agreementText;
	    }

	    public void inputDetails(String text) {
	        set_text(templateEditor, text);
	    }

	    public WebElement getSaveTemplateButton() {
	        return saveTemplateButton;
	    }
	}
