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
	 * Class representing Edit Lead Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditLeadPage extends AbstractBasePageObject<EditLeadPage> {

	    private static final Logger logger = LoggerFactory.getLogger(EditLeadPage.class);

	    private static final String relativeUrl = "/userdesk/lead_edit";

	    public EditLeadPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the edit Lead page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "lead_status")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    public void selectStatus(String text){
	        select_dropdown_by_value(status, text);
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }
	}
