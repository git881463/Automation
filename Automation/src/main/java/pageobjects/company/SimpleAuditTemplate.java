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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Simple Audit Template page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SimpleAuditTemplate extends AbstractBasePageObject<SimpleAuditTemplate> {

	    private static final Logger logger = LoggerFactory.getLogger(SimpleAuditTemplate.class);

	    private static final String relativeUrl = "/audittemplate";

	    @Autowired
	    private AddAuditTemplate addAuditTemplate;

	    public SimpleAuditTemplate(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the simple audit page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Simple Audit Template Settings')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='addnew-btn']/a[contains(text(),'Add New Simple Audit Template')]")
	    private WebElement addTemplateButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[3]/td[3]/a[1]")
	    private WebElement previewTemplateLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[3]/td[3]/a[2]")
	    private WebElement editTemplateLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[3]/td[3]/a[3]")
	    private WebElement removeTemplateLink;

	    @FindBy(how = How.XPATH, using = "//form[@id='mycompany_audittemplate']//a[contains(text(),'Change')]")
	    private WebElement chagneLogoLink;

	    @FindBy(how = How.ID, using = "logo_simpleaudit")
	    private WebElement filePickerLink;

	    private String xpathForChangeLogoLink = "//form[@id='mycompany_audittemplate']//a[contains(text(),'Change')]";

	    private String xpathForResetToDefaultLogoLink = "//form[@id='mycompany_audittemplate']//a[contains(text(),'Reset to default logo')]";

	    public boolean isLogoChangePossible(){
	        return isElementPresent(xpathForChangeLogoLink);
	    }

	    public AddAuditTemplate getAddAuditTemplate() {
	        return addAuditTemplate;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getAddTemplateButton() {
	        return addTemplateButton;
	    }

	    public WebElement getPreviewTemplateLink() {
	        return previewTemplateLink;
	    }

	    public WebElement getEditTemplateLink() {
	        return editTemplateLink;
	    }

	    public WebElement getRemoveTemplateLink() {
	        return removeTemplateLink;
	    }

	    public WebElement getChagneLogoLink() {
	        return chagneLogoLink;
	    }

	    public WebElement getFilePickerLink() {
	        return filePickerLink;
	    }
	}

