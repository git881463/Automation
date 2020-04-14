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
	 * Class representing Client Agreement page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAgreementPage extends AbstractBasePageObject<ClientAgreementPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAgreementPage.class);

	    private static final String relativeUrl = "/agreement";

	    @Autowired
	    private AddAgreementPage addAgreementPage;

	    @Autowired
	    private AgreementPreviewPopup agreementPreviewPopup;

	    public ClientAgreementPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client agreement page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Client Agreement Options')]")
	    private WebElement pageTitle;

	    private String xpathForTooltip = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Set up your client agreement')]//following-sibling::a[3]";

	    @FindBy(how = How.XPATH, using = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Set up your client agreement')]//following-sibling::a[2]")
	    private WebElement closeTooltipLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='add_member']/a")
	    private WebElement addNewAgreementButton;

	    @FindBy(how = How.ID, using = "usemyagreement")
	    private WebElement preferenceDefaultAgreement;

	    @FindBy(how = How.ID, using = "differentagreement")
	    private WebElement preferenceDifferentAgreement;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]/td[3]/a[1]")
	    private WebElement previewAgreementLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]/td[3]/a[2]")
	    private WebElement editAgreementLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[3]/td[3]/a[3]")
	    private WebElement removeAgreementLink;

	    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Need an agreement in Spanish?')]//following-sibling::a")
	    private WebElement spanishLink;

	    public AddAgreementPage getAddAgreementPage() {
	        return addAgreementPage;
	    }

	    public AgreementPreviewPopup getAgreementPreviewPopup() {
	        return agreementPreviewPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public boolean isTooltipShown(){
	        return isElementPresent(xpathForTooltip);
	    }

	    public WebElement getCloseTooltipLink() {
	        return closeTooltipLink;
	    }

	    public WebElement getAddNewAgreementButton() {
	        return addNewAgreementButton;
	    }

	    public WebElement getPreferenceDefaultAgreement() {
	        return preferenceDefaultAgreement;
	    }

	    public WebElement getPreferenceDifferentAgreement() {
	        return preferenceDifferentAgreement;
	    }

	    public WebElement getPreviewAgreementLink() {
	        return previewAgreementLink;
	    }

	    public WebElement getEditAgreementLink() {
	        return editAgreementLink;
	    }

	    public WebElement getRemoveAgreementLink() {
	        return removeAgreementLink;
	    }

	    public WebElement getSpanishLink() {
	        return spanishLink;
	    }
	}

