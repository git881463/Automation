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
	 * Class representing Company Sidebar Navigator in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CompanySideBarNavigator extends AbstractBasePageObject<CompanySideBarNavigator> {

	    private static final Logger logger = LoggerFactory.getLogger(CompanySideBarNavigator.class);

	    private static final String relativeUrl = "/";

	    public CompanySideBarNavigator(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the company side bar navigator page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'My Company Profile')]")
	    private WebElement myCompanyProfileLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'My Team Members')]")
	    private WebElement myTeamMembersLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Roles & Permissions')]")
	    private WebElement rolesAndPermissionsLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Credit Monitoring Service')]")
	    private WebElement creditMonitoringServiceLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Client/Affiliate Portal')]")
	    private WebElement clientAffiliatePortalLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Website Tools')]")
	    private WebElement websiteToolsLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Simple Audit')]")
	    private WebElement simpleAuditLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Client Agreement')]")
	    private WebElement clientAgreementLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Digital Signature Records')]")
	    private WebElement digitalSignatureRecordsLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Dispute Options')]")
	    private WebElement disputeOptionsLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Automated Notifications')]")
	    private WebElement automatedNotificationsLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Client Status Types')]")
	    private WebElement clientStatusTypesLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Invoice Options')]")
	    private WebElement invoiceOptionsLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Affiliate Payments')]")
	    private WebElement affiliatePaymentsLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'Mandrill Integration')]")
	    private WebElement mandrillIntegrationLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'MailChimp Integration')]")
	    private WebElement mailchimpIntegrationLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'ChargeBee Integration')]")
	    private WebElement chargebeeIntegrationLink;

	    @FindBy(how = How.XPATH, using="//div[@id='vtab']/ul/li[contains(text(),'API & Automations')]")
	    private WebElement apiAndAutomationsLink;

	    public WebElement getMyCompanyProfileLink() {
	        return myCompanyProfileLink;
	    }

	    public WebElement getMyTeamMembersLink() {
	        return myTeamMembersLink;
	    }

	    public WebElement getRolesAndPermissionsLink() {
	        return rolesAndPermissionsLink;
	    }

	    public WebElement getCreditMonitoringServiceLink() {
	        return creditMonitoringServiceLink;
	    }

	    public WebElement getClientAffiliatePortalLink() {
	        return clientAffiliatePortalLink;
	    }

	    public WebElement getWebsiteToolsLink() {
	        return websiteToolsLink;
	    }

	    public WebElement getSimpleAuditLink() {
	        return simpleAuditLink;
	    }

	    public WebElement getClientAgreementLink() {
	        return clientAgreementLink;
	    }

	    public WebElement getDigitalSignatureRecordsLink() {
	        return digitalSignatureRecordsLink;
	    }

	    public WebElement getDisputeOptionsLink() {
	        return disputeOptionsLink;
	    }

	    public WebElement getAutomatedNotificationsLink() {
	        return automatedNotificationsLink;
	    }

	    public WebElement getClientStatusTypesLink() {
	        return clientStatusTypesLink;
	    }

	    public WebElement getInvoiceOptionsLink() {
	        return invoiceOptionsLink;
	    }

	    public WebElement getAffiliatePaymentsLink() {
	        return affiliatePaymentsLink;
	    }

	    public WebElement getMandrillIntegrationLink() {
	        return mandrillIntegrationLink;
	    }

	    public WebElement getMailchimpIntegrationLink() {
	        return mailchimpIntegrationLink;
	    }

	    public WebElement getChargebeeIntegrationLink() {
	        return chargebeeIntegrationLink;
	    }

	    public WebElement getApiAndAutomationsLink() {
	        return apiAndAutomationsLink;
	    }
	}
