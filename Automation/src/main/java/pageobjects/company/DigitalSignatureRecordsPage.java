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
	 * Class representing Digital Signature Records page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DigitalSignatureRecordsPage extends AbstractBasePageObject<DigitalSignatureRecordsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(DigitalSignatureRecordsPage.class);

	    private static final String relativeUrl = "/digital_signature";

	    @Autowired
	    private AgreementPreviewPopup agreementPreviewPopup;

	    public DigitalSignatureRecordsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the digital signature page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//h4[contains(text(),'Digital Signature Records')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//form[@id='frm_agreement']//div[@class='gridtable']")
	    private WebElement clientList;

	    @FindBy(how = How.XPATH, using = "//div[@class='pagercount']//span")
	    private WebElement pageCount;

	    @FindBy(how = How.XPATH, using = "//form[@id='frm_agreement']//div[@class='gridtable']//tbody/tr[2]/td[6]/a")
	    private WebElement viewLink;

	    public AgreementPreviewPopup getAgreementPreviewPopup() {
	        return agreementPreviewPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClientList() {
	        return clientList;
	    }

	    public WebElement getPageCount() {
	        return pageCount;
	    }

	    public WebElement getViewLink() {
	        return viewLink;
	    }
	}

