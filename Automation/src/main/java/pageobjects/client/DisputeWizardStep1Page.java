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
	 * Class representing Dispute Wizard Step1 Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeWizardStep1Page extends AbstractBasePageObject<DisputeWizardStep1Page> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeWizardStep1Page.class);

	    private static final String relativeUrl = "/wizard/step1/";

	    @Autowired
	    private DisputeWizardStep1aPage disputeWizardStep1aPage;

	    @Autowired
	    private DisputeWizardStep1cPage disputeWizardStep1cPage;

	    @Autowired
	    private ChangeFavouriteProviderPopup changeFavouriteProviderPopup;

	    public DisputeWizardStep1Page(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute wizard step 1 page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    private String xpathForTooltip = "//div[@id='overviewpopup'][2]//strong[contains(text(),'Credit Report Overview')]";

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][2]//strong[contains(text(),'Credit Report Overview')]")
	    private WebElement overlayTitle;

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][2]/a")
	    private WebElement closeOverlayButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][2]//table/tbody/tr[1]/td[2]/a[@class='vediopopup']")
	    private WebElement method1QuickVidepLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][2]//table/tbody/tr[2]/td[2]/a[@class='vediopopup']")
	    private WebElement method2QuickVidepLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][2]//table/tbody/tr[2]/td[2]/a[1]")
	    private WebElement reportProvidersLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][2]//table/tbody/tr[3]/td[2]/a[4]")
	    private WebElement sampleReportLink;

	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][1]")
	    private WebElement reportProvidersListPopup;

	    @FindBy(how = How.XPATH, using = "//div[@id='overviewpopup'][1]/a")
	    private WebElement closeReportProvdersListPopupLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='formboxtext normaltext1']//a[contains(text(),'import online credit reports')]")
	    private WebElement importReportLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='btngray1']/a[1]")
	    private WebElement orderFreeReportsByMailLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='btngray1']/a[2]")
	    private WebElement orderFreeReportsByOnlineLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='btngray1']/a[3]")
	    private WebElement requestCreditReportsByMailLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='btngray1']/a[4]")
	    private WebElement orderReportFromMyFavProviderLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='btngray1']//span[@id='modify']")
	    private WebElement modifyFavProviderLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chbox normaltext1']//a[contains(text(),'Click here for details')]")
	    private WebElement moreDetailsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='tips']//a[contains(text(),'import online credit reports')]")
	    private WebElement tipsImportOnlineCreditReportsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='tips']//a[contains(text(),'Importing credit reports')]")
	    private WebElement tipsImportingCreditReportsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='tips']//a[contains(text(),'Privacy Guard')][1]")
	    private WebElement tipsPrivacyGuardLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='tips']//a[contains(text(),'Sample Client')]")
	    private WebElement tipsSampleClientLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='tips']//a[contains(text(),'Sample Report')]")
	    private WebElement tipsSampleReportLink;

	    @FindBy(how = How.CLASS_NAME, using = "back-btn-big")
	    private WebElement backButton;

	    public DisputeWizardStep1aPage getDisputeWizardStep1aPage() {
	        return disputeWizardStep1aPage;
	    }

	    public DisputeWizardStep1cPage getDisputeWizardStep1cPage() {
	        return disputeWizardStep1cPage;
	    }

	    public ChangeFavouriteProviderPopup getChangeFavouriteProviderPopup() {
	        return changeFavouriteProviderPopup;
	    }

	    public WebElement getVideoPopup() {
	        return videoPopup;
	    }

	    public WebElement getVideoPopupCloseButton() {
	        return videoPopupCloseButton;
	    }

	    public WebElement getOverlayTitle() {
	        return overlayTitle;
	    }

	    public WebElement getCloseOverlayButton() {
	        return closeOverlayButton;
	    }

	    public boolean isOverlayShown(){
	        return isElementPresent(xpathForTooltip);
	    }

	    public WebElement getMethod1QuickVidepLink() {
	        return method1QuickVidepLink;
	    }

	    public WebElement getMethod2QuickVidepLink() {
	        return method2QuickVidepLink;
	    }

	    public WebElement getReportProvidersLink() {
	        return reportProvidersLink;
	    }

	    public WebElement getReportProvidersListPopup() {
	        return reportProvidersListPopup;
	    }

	    public WebElement getCloseReportProvdersListPopupLink() {
	        return closeReportProvdersListPopupLink;
	    }

	    public WebElement getSampleReportLink() {
	        return sampleReportLink;
	    }

	    public WebElement getImportReportLink() {
	        return importReportLink;
	    }

	    public WebElement getOrderFreeReportsByMailLink() {
	        return orderFreeReportsByMailLink;
	    }

	    public WebElement getOrderFreeReportsByOnlineLink() {
	        return orderFreeReportsByOnlineLink;
	    }

	    public WebElement getRequestCreditReportsByMailLink() {
	        return requestCreditReportsByMailLink;
	    }

	    public WebElement getOrderReportFromMyFavProviderLink() {
	        return orderReportFromMyFavProviderLink;
	    }

	    public WebElement getModifyFavProviderLink() {
	        return modifyFavProviderLink;
	    }

	    public WebElement getMoreDetailsLink() {
	        return moreDetailsLink;
	    }

	    public WebElement getTipsImportOnlineCreditReportsLink() {
	        return tipsImportOnlineCreditReportsLink;
	    }

	    public WebElement getTipsPrivacyGuardLink() {
	        return tipsPrivacyGuardLink;
	    }

	    public WebElement getTipsImportingCreditReportsLink() {
	        return tipsImportingCreditReportsLink;
	    }

	    public WebElement getTipsSampleClientLink() {
	        return tipsSampleClientLink;
	    }

	    public WebElement getTipsSampleReportLink() {
	        return tipsSampleReportLink;
	    }

	    public WebElement getBackButton() {
	        return backButton;
	    }
	}

