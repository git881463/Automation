package pageobjects.company;
	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.FlashMessage;
	import pageobjects.popup.WarningPopup;
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
	 * Class representing Company Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CompanyPage extends AbstractBasePageObject<CompanyPage> {

	    private static final Logger logger = LoggerFactory.getLogger(CompanyPage.class);

	    private static final String relativeUrl = "/mycompany";

	    @Autowired
	    private MyCompanyProfilePage myCompanyProfilePage;

	    @Autowired
	    private ChargebeeSettingsPage chargebeeSettingsPage;

	    @Autowired
	    private FlashMessage flashMessage;

	    @Autowired
	    private WarningPopup warningPopup;

	    @Autowired
	    private CompanySideBarNavigator companySideBarNavigator;

	    @Autowired
	    private MyTeamMembersPage myTeamMembersPage;

	    @Autowired
	    private ClientAffiliatePortalPage clientAffiliatePortalPage;

	    @Autowired
	    private SimpleAuditTemplate simpleAuditTemplate;

	    @Autowired
	    private EditAuditTemplatePage editAuditTemplatePage;

	    @Autowired
	    private ClientAgreementPage clientAgreementPage;

	    @Autowired
	    private DigitalSignatureRecordsPage digitalSignatureRecordsPage;

	    @Autowired
	    private DisputeOptionsPage disputeOptionsPage;

	    @Autowired
	    private InvoiceOptionsPage invoiceOptionsPage;

	    @Autowired
	    private APIAndAutomationsPage APIAndAutomationsPage;

	    @Autowired
	    private RolesAndPermissionsPage rolesAndPermissionsPage;

	    @Autowired
	    private CreditMonitoringServicePage creditMonitoringServicePage;

	    @Autowired
	    private WebsiteToolsPage websiteToolsPage;

	    @Autowired
	    private AutomatedNotificationOptionsPage automatedNotificationOptionsPage;

	    @Autowired
	    private ClientStatusTypesPage clientStatusTypesPage;

	    @Autowired
	    private AffiliatePaymentsPage affiliatePaymentsPage;

	    @Autowired
	    private MandrillIntegrationPage mandrillIntegrationPage;

	    public CompanyPage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    public void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the company page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "ajax_loader_new")
	    private WebElement ajaxLoader;

	    @FindBy(how = How.XPATH, using = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Success with Credit Repair Cloud')]//following-sibling::a[3]")
	    private WebElement closeTooltipLink;

	    @FindBy(how = How.ID, using = "company_url")
	    private WebElement companyWebsiteUrl;

	    private String xpathForTooltip = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Success with Credit Repair Cloud')]//following-sibling::a[3]";

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public MyCompanyProfilePage getMyCompanyProfilePage() {
	        return myCompanyProfilePage;
	    }

	    public CompanySideBarNavigator getCompanySideBarNavigator() {
	        return companySideBarNavigator;
	    }

	    public ChargebeeSettingsPage getChargebeeSettingsPage() {
	        return chargebeeSettingsPage;
	    }

	    public MyTeamMembersPage getMyTeamMembersPage() {
	        return myTeamMembersPage;
	    }

	    public ClientAffiliatePortalPage getClientAffiliatePortalPage() {
	        return clientAffiliatePortalPage;
	    }

	    public SimpleAuditTemplate getSimpleAuditTemplate() {
	        return simpleAuditTemplate;
	    }

	    public EditAuditTemplatePage getEditAuditTemplatePage() {
	        return editAuditTemplatePage;
	    }

	    public ClientAgreementPage getClientAgreementPage() {
	        return clientAgreementPage;
	    }

	    public DigitalSignatureRecordsPage getDigitalSignatureRecordsPage() {
	        return digitalSignatureRecordsPage;
	    }

	    public DisputeOptionsPage getDisputeOptionsPage() {
	        return disputeOptionsPage;
	    }

	    public InvoiceOptionsPage getInvoiceOptionsPage() {
	        return invoiceOptionsPage;
	    }

	    public APIAndAutomationsPage getAPIAndAutomationsPage() {
	        return APIAndAutomationsPage;
	    }

	    public RolesAndPermissionsPage getRolesAndPermissionsPage() {
	        return rolesAndPermissionsPage;
	    }

	    public CreditMonitoringServicePage  getCreditMonitoringServicePage() {
	        return creditMonitoringServicePage;
	    }

	    public WebsiteToolsPage getWebsiteToolsPage() {
	        return websiteToolsPage;
	    }

	    public AutomatedNotificationOptionsPage getAutomatedNotificationOptionsPage() {
	        return automatedNotificationOptionsPage;
	    }

	    public ClientStatusTypesPage getClientStatusTypesPage() {
	        return clientStatusTypesPage;
	    }

	    public AffiliatePaymentsPage getAffiliatePaymentsPage() {
	        return affiliatePaymentsPage;
	    }

	    public MandrillIntegrationPage getMandrillIntegrationPage() {
	        return mandrillIntegrationPage;
	    }

	    public WebElement getAjaxLoader() {
	        return ajaxLoader;
	    }

	    public boolean isTooltipShown(){
	        return isElementPresent(xpathForTooltip);
	    }

	    public WebElement getCloseTooltipLink() {
	        return closeTooltipLink;
	    }

	    public void inputWebsiteUrl(String text) {
	        set_text(companyWebsiteUrl, text);
	    }

	    public WebElement getCompanyWebsiteUrl() {
	        return companyWebsiteUrl;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }
	}
