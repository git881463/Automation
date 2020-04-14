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
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Client Dashboard Page Document Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageDocumentSection extends AbstractBasePageObject<ClientDashboardPageDocumentSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageDocumentSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private CustomizeDocumentListPopup customizeDocumentListPopup;

	    public ClientDashboardPageDocumentSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard document section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='paperwork']//input[@id='chk_paperwork_1']")
	    private WebElement clientAgreementCheckBox;

	    @FindBy(how = How.XPATH, using = "//div[@class='paperwork']//input[@id='chk_paperwork_4']")
	    private WebElement photoIdCheckBox;

	    @FindBy(how = How.XPATH, using = "//div[@class='paperwork']//input[@id='chk_paperwork_5']")
	    private WebElement utilityBillCheckBox;

	    @FindBy(how = How.XPATH, using = "//div[@class='paperwork']//input[@id='chk_paperwork_6']")
	    private WebElement socialSecurityCardCheckBox;

	    @FindBy(how = How.XPATH, using = "//div[@class='paperwork']//form[@id='uploadDoc_1']//input[@id='upload_document_1']")
	    private WebElement clientAgreementUploadLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='paperwork']//a[contains(text(),'Customize list')]")
	    private WebElement customizeListLink;

	    public CustomizeDocumentListPopup getCustomizeDocumentListPopup() {
	        return customizeDocumentListPopup;
	    }

	    public WebElement getClientAgreementCheckBox() {
	        return clientAgreementCheckBox;
	    }

	    public WebElement getPhotoIdCheckBox() {
	        return photoIdCheckBox;
	    }

	    public WebElement getUtilityBillCheckBox() {
	        return utilityBillCheckBox;
	    }

	    public WebElement getSocialSecurityCardCheckBox() {
	        return socialSecurityCardCheckBox;
	    }

	    public WebElement getClientAgreementUploadLink() {
	        return clientAgreementUploadLink;
	    }

	    public WebElement getCustomizeListLink() {
	        return customizeListLink;
	    }
	}

