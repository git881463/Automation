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
	 * Class representing Email Templates page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EmailTemplatesPage extends AbstractBasePageObject<EmailTemplatesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(EmailTemplatesPage.class);

	    private static final String relativeUrl = "/email_templates/";

	    @Autowired
	    private ViewTemplatesPage viewTemplatesPage;

	    public EmailTemplatesPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the email templates page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Email Templates')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]/td[3]/a")
	    private WebElement viewTemplateLink;

	    public ViewTemplatesPage getViewTemplatesPage() {
	        return viewTemplatesPage;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getViewTemplateLink() {
	        return viewTemplateLink;
	    }
	}


