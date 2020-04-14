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
	 * Class representing Edit Dispute Item Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditDisputeItemPopup extends AbstractBasePageObject<EditDisputeItemPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(EditDisputeItemPopup.class);

	    private static final String relativeUrl = "/";

	    public EditDisputeItemPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the edit dispute item popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div//span[contains(text(),'Edit Dispute Item')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.CLASS_NAME, using = "//div[@id='disp_item-form']//form[@id='dispItemFrm']")
	    private WebElement pageContainer;

	    @FindBy(how = How.ID, using = "dispute_reason")
	    private WebElement reason;

	    @FindBy(how = How.ID, using = "dispute_item_status_1")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "accountname_1")
	    private WebElement accountName;

	    @FindBy(how = How.ID, using = "submit_dispute_item")
	    private WebElement saveButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public void selectReason(int index){
	        select_dropdown_by_index(reason, index);
	    }

	    public void selectStatus(int index){
	        select_dropdown_by_index(status, index);
	    }

	    public void inputAccountName(String text) {
	        set_text(accountName, text);
	    }

	    public WebElement getSaveButton() {
	        return saveButton;
	    }
	}

