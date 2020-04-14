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
	 * Class representing Affiliate Payments page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AffiliatePaymentsPage extends AbstractBasePageObject<AffiliatePaymentsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AffiliatePaymentsPage.class);

	    private static final String relativeUrl = "/affiliatecommissions";

	    @Autowired
	    private PaymentHistoryPage paymentHistoryPage;

	    @Autowired
	    private AffiliateCommissionSettingsPopup affiliateCommissionSettingsPopup;

	    public AffiliatePaymentsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the affiliate payments page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Affiliate Payments')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "commission_rate")
	    private WebElement commissionRate;

	    @FindBy(how = How.ID, using = "commission_whom")
	    private WebElement commissionFor;

	    @FindBy(how = How.ID, using = "minimum_payout")
	    private WebElement minimumPayout;

	    @FindBy(how = How.ID, using = "payment_frequency")
	    private WebElement paymentFrequency;

	    @FindBy(how = How.ID, using = "see_earnings_yes")
	    private WebElement allowViewEarnings;

	    @FindBy(how = How.ID, using = "see_earnings_no")
	    private WebElement forbidViewEarnings;

	    @FindBy(how = How.XPATH, using = "//form[@id='affiliate_commission_setting']//input[@class='btnsubmit']")
	    private WebElement updateSettingsButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]/td[6]/a[2]")
	    private WebElement settingsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]/td[6]/a[3]")
	    private WebElement historyLink;

	    public PaymentHistoryPage getPaymentHistoryPage() {
	        return paymentHistoryPage;
	    }

	    public AffiliateCommissionSettingsPopup getAffiliateCommissionSettingsPopup() {
	        return affiliateCommissionSettingsPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getCommissionRate() {
	        return commissionRate;
	    }

	    public WebElement getCommissionFor() {
	        return commissionFor;
	    }

	    public WebElement getMinimumPayout() {
	        return minimumPayout;
	    }

	    public void inputCommissionRate(String text) {
	        set_text(commissionRate, text);
	    }

	    public WebElement getPaymentFrequency() {
	        return paymentFrequency;
	    }

	    public void selectPaymentFrequency(String text){
	        select_dropdown_by_value(paymentFrequency, text);
	    }

	    public WebElement getAllowViewEarnings() {
	        return allowViewEarnings;
	    }

	    public WebElement getForbidViewEarnings() {
	        return forbidViewEarnings;
	    }

	    public WebElement getUpdateSettingsButton() {
	        return updateSettingsButton;
	    }

	    public WebElement getSettingsLink() {
	        return settingsLink;
	    }

	    public WebElement getHistoryLink() {
	        return historyLink;
	    }
	}

