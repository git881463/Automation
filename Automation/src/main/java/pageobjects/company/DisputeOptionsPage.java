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
	 * Class representing Dispute Options page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeOptionsPage extends AbstractBasePageObject<DisputeOptionsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeOptionsPage.class);

	    private static final String relativeUrl = "/bureau";

	    @Autowired
	    private ManageReasonsPopup manageReasonsPopup;

	    @Autowired
	    private ManageInstructionsPopup manageInstructionsPopup;

	    @Autowired
	    private EditBureauDetailsPopup editBureauDetailsPopup;

	    public DisputeOptionsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute options page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Manage Dispute Reasons and Instructions')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "manageReson_global")
	    private WebElement manageReasonsButton;

	    @FindBy(how = How.ID, using = "manageInstruction_global")
	    private WebElement manageInstructionsButton;

	    @FindBy(how = How.ID, using = "act_batch_txt")
	    private WebElement batchPrintButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']/table/tbody/tr[2]//a[contains(text(),'Modify')]")
	    private WebElement equifaxModifyLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']/table/tbody/tr[2]//a[contains(text(),'Reset')]")
	    private WebElement equifaxResetLink;

	    public ManageReasonsPopup getManageReasonsPopup() {
	        return manageReasonsPopup;
	    }

	    public ManageInstructionsPopup getManageInstructionsPopup() {
	        return manageInstructionsPopup;
	    }

	    public EditBureauDetailsPopup getEditBureauDetailsPopup() {
	        return editBureauDetailsPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getManageReasonsButton() {
	        return manageReasonsButton;
	    }

	    public WebElement getManageInstructionsButton() {
	        return manageInstructionsButton;
	    }

	    public WebElement getBatchPrintButton() {
	        return batchPrintButton;
	    }

	    public WebElement getEquifaxModifyLink() {
	        return equifaxModifyLink;
	    }

	    public WebElement getEquifaxResetLink() {
	        return equifaxResetLink;
	    }
	}
