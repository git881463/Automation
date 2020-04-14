package pageobjects.client;

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
	 * Class representing MyClients Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MyClientsPage extends AbstractBasePageObject<MyClientsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(MyClientsPage.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private FlashMessage flashMessage;

	    @Autowired
	    private WarningPopup warningPopup;

	    @Autowired
	    private ClientTabNavigationBar clientTabNavigationBar;

	    @Autowired
	    private AddClientPage addClientPage;

	    @Autowired
	    private EditClientPage editClientPage;

	    @Autowired
	    private EditLeadPage editLeadPage;

	    @Autowired
	    private SearchClientPage searchClientPage;

	    @Autowired
	    private DisputeWizardPage disputeWizardPage;

	    @Autowired
	    private DisputeItemPage disputeItemPage;

	    @Autowired
	    private DisputeItemReportViewPage disputeItemReportViewPage;

	    @Autowired
	    private CreateNewInvoicePage createNewInvoicePage;

	    @Autowired
	    private AllClientInvoicesPage allClientInvoicesPage;

	    @Autowired
	    private ClientInvoicesHistoryPage clientInvoicesHistoryPage;

	    @Autowired
	    private ImportAuditPage importAuditPage;

	    @Autowired
	    private ClientDashboardPage clientDashboardPage;

	    @Autowired
	    private InternalNotesPage internalNotesPage;

	    @Autowired
	    private PendingReportPage pendingReportPage;

	    @Autowired
	    private EducatePage educatePage;

	    @Autowired
	    private ActivityPage activityPage;

	    public MyClientsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the my account page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.CLASS_NAME, using = "contentbg")
	    private WebElement pageContainer;

	    @FindBy(how = How.ID, using = "ajax_loader_new")
	    private WebElement ajaxLoader;

	    public ClientTabNavigationBar getClientTabNavigationBar() {
	        return clientTabNavigationBar;
	    }

	    public AddClientPage getAddClientPage() {
	        return addClientPage;
	    }

	    public EditClientPage getEditClientPage() {
	        return editClientPage;
	    }

	    public EditLeadPage getEditLeadPage() {
	        return editLeadPage;
	    }

	    public SearchClientPage getSearchClientPage() {
	        return searchClientPage;
	    }

	    public DisputeWizardPage getDisputeWizardPage() {
	        return disputeWizardPage;
	    }

	    public DisputeItemPage getDisputeItemPage() {
	        return disputeItemPage;
	    }

	    public DisputeItemReportViewPage getDisputeItemReportViewPage() {
	        return disputeItemReportViewPage;
	    }

	    public CreateNewInvoicePage getCreateNewInvoicePage() {
	        return createNewInvoicePage;
	    }

	    public AllClientInvoicesPage getAllClientInvoicesPage() {
	        return allClientInvoicesPage;
	    }

	    public ClientInvoicesHistoryPage getClientInvoicesHistoryPage() {
	        return clientInvoicesHistoryPage;
	    }

	    public ImportAuditPage getImportAuditPage() {
	        return importAuditPage;
	    }

	    public ClientDashboardPage getClientDashboardPage() {
	        return clientDashboardPage;
	    }

	    public InternalNotesPage getInternalNotesPage() {
	        return internalNotesPage;
	    }

	    public PendingReportPage getPendingReportPage() {
	        return pendingReportPage;
	    }

	    public EducatePage getEducatePage() {
	        return educatePage;
	    }

	    public ActivityPage getActivityPage() {
	        return activityPage;
	    }

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public WebElement getAjaxLoader() {
	        return ajaxLoader;
	    }
	}
