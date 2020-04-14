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
	 * Class representing Client Affiliate Portal page Credit Info section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPageCreditInfoSection extends AbstractBasePageObject<ClientAffiliatePortalPageCreditInfoSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPageCreditInfoSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private EditCreditInfoPage editCreditInfoPage;

	    public ClientAffiliatePortalPageCreditInfoSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal page credit info section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "creditinfocontent")
	    private WebElement creditInfoContainer;

	    @FindBy(how = How.ID, using = "show-c-i-page")
	    private WebElement showCreditInfoRadio;

	    @FindBy(how = How.ID, using = "hide-c-i-page")
	    private WebElement hideCreditInfoRadio;

	    @FindBy(how = How.XPATH, using = "//div[@id='creditinfocontent']//a[contains(text(),'Modify content')]")
	    private WebElement modifyCreditInfoLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='creditinfocontent']//a[contains(text(),'Reset to default')]")
	    private WebElement resetCreditInfoToDefaultLink;

	    public EditCreditInfoPage getEditCreditInfoPage() {
	        return editCreditInfoPage;
	    }

	    public WebElement getCreditInfoContainer() {
	        return creditInfoContainer;
	    }

	    public WebElement getShowCreditInfoRadio() {
	        return showCreditInfoRadio;
	    }

	    public WebElement getHideCreditInfoRadio() {
	        return hideCreditInfoRadio;
	    }

	    public WebElement getModifyCreditInfoLink() {
	        return modifyCreditInfoLink;
	    }

	    public WebElement getResetCreditInfoToDefaultLink() {
	        return resetCreditInfoToDefaultLink;
	    }

	    public boolean isCreditInfoPageHidden(){
	        return hideCreditInfoRadio.isSelected();
	    }
	}

