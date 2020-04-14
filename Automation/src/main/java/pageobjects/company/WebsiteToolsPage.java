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
	 * Class representing Website Tools page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class WebsiteToolsPage extends AbstractBasePageObject<WebsiteToolsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(WebsiteToolsPage.class);

	    private static final String relativeUrl = "/website_tools";

	    public WebsiteToolsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the website tools page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Website Tools')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "webleadtab")
	    private WebElement webLeadFormTab;

	    @FindBy(how = How.ID, using = "affsignuptab")
	    private WebElement affiliateSignupTab;

	    @FindBy(how = How.ID, using = "loginoptions")
	    private WebElement loginOptionsTab;

	    @FindBy(how = How.ID, using = "videosoptions")
	    private WebElement videosOptionsTab;

	    @FindBy(how = How.ID, using = "lang_en")
	    private WebElement languageEn;

	    @FindBy(how = How.ID, using = "lang_es")
	    private WebElement languageEs;

	    @FindBy(how = How.XPATH, using = "//form[@id='frm_web']//input[@class='btnsubmit']")
	    private WebElement saveWebLeadFormButton;

	    @FindBy(how = How.XPATH, using = "//form[@id='frm_web']//following-sibling::div/button")
	    private WebElement copyWebLeadFormButton;

	    @FindBy(how = How.ID, using = "preview")
	    private WebElement previewWebLeadFormButton;

	    @FindBy(how = How.XPATH, using = "//span[@id='ui-dialog-title-preview_popup']")
	    private WebElement previewPopupHeader;

	    @FindBy(how = How.XPATH, using = "//span[@id='ui-dialog-title-preview_popup']//following-sibling::a")
	    private WebElement closePreviewPopupLink;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getWebLeadFormTab() {
	        return webLeadFormTab;
	    }

	    public WebElement getAffiliateSignupTab() {
	        return affiliateSignupTab;
	    }

	    public WebElement getLoginOptionsTab() {
	        return loginOptionsTab;
	    }

	    public WebElement getVideosOptionsTab() {
	        return videosOptionsTab;
	    }

	    public WebElement getLanguageEn() {
	        return languageEn;
	    }

	    public WebElement getLanguageEs() {
	        return languageEs;
	    }

	    public WebElement getSaveWebLeadFormButton() {
	        return saveWebLeadFormButton;
	    }

	    public WebElement getCopyWebLeadFormButton() {
	        return copyWebLeadFormButton;
	    }

	    public WebElement getPreviewWebLeadFormButton() {
	        return previewWebLeadFormButton;
	    }

	    public WebElement getPreviewPopupHeader() {
	        return previewPopupHeader;
	    }

	    public WebElement getClosePreviewPopupLink() {
	        return closePreviewPopupLink;
	    }
	}

