package spring;

	import pageobjects.account.*;
	import pageobjects.affiliates.*;
	import pageobjects.automations.*;
	import pageobjects.client.*;
	import pageobjects.company.*;
	import pageobjects.contacts.ContactsPage;
	import pageobjects.creditors.CreditorsFurnishersPage;
	import pageobjects.creditors.ImportCreditorsFurnishersPopup;
	import pageobjects.creditors.PrintCreditorsFurnishersPopup;
	import pageobjects.dashboard.*;
	import pageobjects.everything.*;
	import pageobjects.header.*;
	import pageobjects.history.HistoryPage;
	import pageobjects.home.*;
	import pageobjects.invoice.*;
	import pageobjects.landing.LandingPage;
	import pageobjects.landing.LandingPageLoginSection;
	import pageobjects.library.AddNewLettersPage;
	import pageobjects.library.EditLetterPage;
	import pageobjects.library.LibraryPage;
	import pageobjects.messages.*;
	import pageobjects.navigation.NavigationHelper;
	import pageobjects.others.*;
	import pageobjects.popup.FlashMessage;
	import pageobjects.popup.WarningPopup;
	import pageobjects.schedule.CreateNewCalendarPopup;
	import pageobjects.schedule.SchedulePage;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.test.context.ContextConfiguration;


	/**
	 * Main Spring Configuration class. You should be adding a page specific bean in this class.
	 *
	 */
	@Configuration
	@ContextConfiguration(classes={SeleniumContext.class})
	public class PageObjectsContext {

	    private static final Logger logger = LoggerFactory.getLogger(PageObjectsContext.class);

	    @Autowired
	    protected WebDriver webdriver;

	    @Autowired
	    protected String baseurl;

	    @Autowired
	    protected WebDriverWait wait;

	    @Bean
	    public LandingPageLoginSection landingPageLoginSection() {
	        logger.debug("Creating Bean LandingPageLoginSection");
	        return new LandingPageLoginSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public LandingPage landingPage() {
	        logger.debug("Creating Bean LandingPage");
	        return new LandingPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CommonHeaderLeftNavigationSection commonHeaderLeftNavigationSection() {
	        logger.debug("Creating Bean CommonHeaderLeftNavigationSection");
	        return new CommonHeaderLeftNavigationSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HelpAndSupportDropDown helpAndSuuportDropDown() {
	        logger.debug("Creating Bean HelpAndSupportDropDown");
	        return new HelpAndSupportDropDown(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public NewFeatureRequestsPopup newFeatureRequestsPopup() {
	        logger.debug("Creating Bean NewFeatureRequestsPopup");
	        return new NewFeatureRequestsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AccountDropDown accountDropDown() {
	        logger.debug("Creating Bean AccountDropDown");
	        return new AccountDropDown(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CommonHeaderRightNavigationSection commonHeaderRightNavigationSection() {
	        logger.debug("Creating Bean CommonHeaderRightNavigationSection");
	        return new CommonHeaderRightNavigationSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CommonHeaderTabNavigationBar commonHeaderTabNavigationBar() {
	        logger.debug("Creating Bean CommonHeaderTabNavigationBar");
	        return new CommonHeaderTabNavigationBar(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CommonHeaderSection commonHeaderSection() {
	        logger.debug("Creating Bean CommonHeaderSection");
	        return new CommonHeaderSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePage homePage() {
	        logger.debug("Creating Bean HomePage");
	        return new HomePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HistoryPage historyPage() {
	        logger.debug("Creating Bean HistoryPage");
	        return new HistoryPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EverythingPage everythingPage() {
	        logger.debug("Creating Bean SchedulePage");
	        return new EverythingPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ProgressPage progressPage() {
	        logger.debug("Creating Bean ProgressPage");
	        return new ProgressPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PendingClientsPage pendingClientsPage() {
	        logger.debug("Creating Bean PendingClientsPage");
	        return new PendingClientsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AllTasksPage allTasksPage() {
	        logger.debug("Creating Bean AllTasksPage");
	        return new AllTasksPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EverythingAllMessagesPage everythingAllMessagesPage() {
	        logger.debug("Creating Bean EverythingAllMessagesPage");
	        return new EverythingAllMessagesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AllDocumentsPage allDocumentsPage() {
	        logger.debug("Creating Bean AllDocumentsPage");
	        return new AllDocumentsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CreditorsFurnishersPage creditorsFurnishersPage() {
	        logger.debug("Creating Bean CreditorsFurnishersPage");
	        return new CreditorsFurnishersPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ImportCreditorsFurnishersPopup importCreditorsFurnishersPopup() {
	        logger.debug("Creating Bean ImportCreditorsFurnishersPopup");
	        return new ImportCreditorsFurnishersPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PrintCreditorsFurnishersPopup printCreditorsFurnishersPopup() {
	        logger.debug("Creating Bean PrintCreditorsFurnishersPopup");
	        return new PrintCreditorsFurnishersPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SchedulePage schedulePage() {
	        logger.debug("Creating Bean SchedulePage");
	        return new SchedulePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public LibraryPage libraryPage() {
	        logger.debug("Creating Bean LibraryPage");
	        return new LibraryPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddNewLettersPage addNewLettersPage() {
	        logger.debug("Creating Bean AddNewLettersPage");
	        return new AddNewLettersPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditLetterPage editLetterPage() {
	        logger.debug("Creating Bean EditLetterPage");
	        return new EditLetterPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AffiliatesPage affiliatesPage() {
	        logger.debug("Creating Bean AffiliatesPage");
	        return new AffiliatesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AffiliateCommissionSettingsPopup affiliateCommissionSettingsPopup() {
	        logger.debug("Creating Bean AffiliateCommissionSettingsPopup");
	        return new AffiliateCommissionSettingsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddAffiliatePage addAffiliatePage() {
	        logger.debug("Creating Bean AddAffiliatePage");
	        return new AddAffiliatePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditAffiliatePage editAffiliatePage() {
	        logger.debug("Creating Bean EditAffiliatePage");
	        return new EditAffiliatePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public InactivateOrDeleteAffiliatePopup inactivateOrDeleteAffiliatePopup() {
	        logger.debug("Creating Bean InactivateOrDeleteAffiliatePopup");
	        return new InactivateOrDeleteAffiliatePopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ImportAffiliatesPopup importAffiliatesPopup() {
	        logger.debug("Creating Bean ImportAffiliatesPopup");
	        return new ImportAffiliatesPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PrintAffiliatesPopup printAffiliatesPopup() {
	        logger.debug("Creating Bean PrintAffiliatesPopup");
	        return new PrintAffiliatesPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AffiliatesDashboardPage affiliatesDashboardPage() {
	        logger.debug("Creating Bean AffiliatesDashboardPage");
	        return new AffiliatesDashboardPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CreateNewCalendarPopup createNewCalendarPopup() {
	        logger.debug("Creating Bean CreateNewCalendarPopup");
	        return new CreateNewCalendarPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CompanyPage companyPage() {
	        logger.debug("Creating Bean CompanyPage");
	        return new CompanyPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CompanySideBarNavigator companySideBarNavigator() {
	        logger.debug("Creating Bean CompanySideBarNavigator");
	        return new CompanySideBarNavigator(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyCompanyProfilePage myCompanyProfilePage() {
	        logger.debug("Creating Bean MyCompanyProfilePage");
	        return new MyCompanyProfilePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyTeamMembersPage myTeamMembersPage() {
	        logger.debug("Creating Bean MyTeamMembersPage");
	        return new MyTeamMembersPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddTeamMemberPage addTeamMemberPage() {
	        logger.debug("Creating Bean AddTeamMemberPage");
	        return new AddTeamMemberPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public InactivateOrDeleteMemberPopup inactivateOrDeleteMemberPopup() {
	        logger.debug("Creating Bean InactivateOrDeleteMemberPopup");
	        return new InactivateOrDeleteMemberPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public RemoveExtraUserAddonPopup removeExtraUserAddonPopup() {
	        logger.debug("Creating Bean RemoveExtraUserAddonPopup");
	        return new RemoveExtraUserAddonPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPage clientAffiliatePortalPage(){
	        logger.debug("Creating Bean ClientAffiliatePortalPage");
	        return new ClientAffiliatePortalPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPageMyLogoSection clientAffiliatePortalPageMyLogoSection(){
	        logger.debug("Creating Bean ClientAffiliatePortalPageMyLogoSection");
	        return new ClientAffiliatePortalPageMyLogoSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPageDetailsSection clientAffiliatePortalPageDetailsSection(){
	        logger.debug("Creating Bean ClientAffiliatePortalPageDetailsSection");
	        return new ClientAffiliatePortalPageDetailsSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPageResourcesSection clientAffiliatePortalPageResourcesSection(){
	        logger.debug("Creating Bean ClientAffiliatePortalPageResourcesSection");
	        return new ClientAffiliatePortalPageResourcesSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPageCreditInfoSection clientAffiliatePortalPageCreditInfoSection(){
	        logger.debug("Creating Bean ClientAffiliatePortalPageCreditInfoSection");
	        return new ClientAffiliatePortalPageCreditInfoSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPageClientsChoiceSection clientAffiliatePortalPageClientsChoiceSection(){
	        logger.debug("Creating Bean clientAffiliatePortalPageClientsChoiceSection");
	        return new ClientAffiliatePortalPageClientsChoiceSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPagePortalThemeSection clientAffiliatePortalPagePortalThemeSection(){
	        logger.debug("Creating Bean ClientAffiliatePortalPagePortalThemeSection");
	        return new ClientAffiliatePortalPagePortalThemeSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAffiliatePortalPageOnboardingAndTasksSection clientAffiliatePortalPageOnboardingAndTasksSection(){
	        logger.debug("Creating Bean ClientAffiliatePortalPageOnboardingAndTasksSection");
	        return new ClientAffiliatePortalPageOnboardingAndTasksSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientResourcesPage clientResourcesPage(){
	        logger.debug("Creating Bean ClientResourcesPage");
	        return new ClientResourcesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditCreditInfoPage editCreditInfoPage(){
	        logger.debug("Creating Bean EditCreditInfoPage");
	        return new EditCreditInfoPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientTaskForOnboardingPopup clientTaskForOnboardingPopup() {
	        logger.debug("Creating Bean ClientTaskForOnboardingPopup");
	        return new ClientTaskForOnboardingPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PreviewOfTaskPopup previewOfTaskPopup() {
	        logger.debug("Creating Bean PreviewOfTaskPopup");
	        return new PreviewOfTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditTaskPopup editTaskPopup() {
	        logger.debug("Creating Bean EditTaskPopup");
	        return new EditTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public WebsiteToolsPage websiteToolsPage() {
	        logger.debug("Creating Bean WebsiteToolsPage");
	        return new WebsiteToolsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SimpleAuditTemplate simpleAuditTemplate() {
	        logger.debug("Creating Bean SimpleAuditTemplate");
	        return new SimpleAuditTemplate(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddAuditTemplate addAuditTemplate() {
	        logger.debug("Creating Bean AddAuditTemplate");
	        return new AddAuditTemplate(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditAuditTemplatePage editAuditTemplatePage() {
	        logger.debug("Creating Bean EditAuditTemplatePage");
	        return new EditAuditTemplatePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientAgreementPage clientAgreementPage() {
	        logger.debug("Creating Bean ClientAgreementPage");
	        return new ClientAgreementPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CreditMonitoringServicePage creditMonitoringServicePage() {
	        logger.debug("Creating Bean CreditMonitoringServicePage");
	        return new CreditMonitoringServicePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CreditMonitoringProviderSettingPopup creditMonitoringProviderSettingPopup() {
	        logger.debug("Creating Bean CreditMonitoringProviderSettingPopup");
	        return new CreditMonitoringProviderSettingPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public LearnToBecomeAffiliatePopup learnToBecomeAffiliatePopup() {
	        logger.debug("Creating Bean LearnToBecomeAffiliatePopup");
	        return new LearnToBecomeAffiliatePopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AutomatedNotificationOptionsPage automatedNotificationOptionsPage() {
	        logger.debug("Creating Bean AutomatedNotificationOptionsPage");
	        return new AutomatedNotificationOptionsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientStatusTypesPage clientStatusTypesPage() {
	        logger.debug("Creating Bean ClientStatusTypesPage");
	        return new ClientStatusTypesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AffiliatePaymentsPage affiliatePaymentsPage() {
	        logger.debug("Creating Bean AffiliatePaymentsPage");
	        return new AffiliatePaymentsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PaymentHistoryPage paymentHistoryPage() {
	        logger.debug("Creating Bean PaymentHistoryPage");
	        return new PaymentHistoryPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddAgreementPage addAgreementPage() {
	        logger.debug("Creating Bean AddAgreementPage");
	        return new AddAgreementPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MandrillIntegrationPage mandrillIntegrationPage() {
	        logger.debug("Creating Bean MandrillIntegrationPage");
	        return new MandrillIntegrationPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EmailTemplatesPage emailTemplatesPage() {
	        logger.debug("Creating Bean EmailTemplatesPage");
	        return new EmailTemplatesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ViewTemplatesPage viewTemplatesPage() {
	        logger.debug("Creating Bean ViewTemplatesPage");
	        return new ViewTemplatesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public TemplatePreviewPopup templatePreviewPopup() {
	        logger.debug("Creating Bean TemplatePreviewPopup");
	        return new TemplatePreviewPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DigitalSignatureRecordsPage digitalSignatureRecordsPage() {
	        logger.debug("Creating Bean DigitalSignatureRecordsPage");
	        return new DigitalSignatureRecordsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AgreementPreviewPopup agreementPreviewPopup() {
	        logger.debug("Creating Bean AgreementPreviewPopup");
	        return new AgreementPreviewPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeOptionsPage disputeOptionsPage() {
	        logger.debug("Creating Bean DisputeOptionsPage");
	        return new DisputeOptionsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditBureauDetailsPopup editBureauDetailsPopup() {
	        logger.debug("Creating Bean EditBureauDetailsPopup");
	        return new EditBureauDetailsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ManageReasonsPopup manageReasonsPopup() {
	        logger.debug("Creating Bean ManageReasonsPopup");
	        return new ManageReasonsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ManageInstructionsPopup manageInstructionsPopup() {
	        logger.debug("Creating Bean ManageInstructionsPopup");
	        return new ManageInstructionsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public InvoiceOptionsPage invoiceOptionsPage() {
	        logger.debug("Creating Bean InvoiceOptionsPage");
	        return new InvoiceOptionsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddInvoiceOptionPopup addInvoiceOptionPopup() {
	        logger.debug("Creating Bean AddInvoiceOptionPopup");
	        return new AddInvoiceOptionPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PreviewInvoicePopup previewInvoicePopup() {
	        logger.debug("Creating Bean PreviewInvoicePopup");
	        return new PreviewInvoicePopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public APIAndAutomationsPage apiAndAutomationsPage() {
	        logger.debug("Creating Bean APIAndAutomationsPage");
	        return new APIAndAutomationsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public RolesAndPermissionsPage rolesAndPermissionsPage() {
	        logger.debug("Creating Bean RolesAndPermissionsPage");
	        return new RolesAndPermissionsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AutomationSideBarNavigator automationSideBarNavigator() {
	        logger.debug("Creating Bean AutomationSideBarNavigator");
	        return new AutomationSideBarNavigator(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AutomationsOverviewPage automationsOverviewPage() {
	        logger.debug("Creating Bean AutomationsOverviewPage");
	        return new AutomationsOverviewPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public APICredentialsPage apiCredentialsPage() {
	        logger.debug("Creating Bean APICredentialsPage");
	        return new APICredentialsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public APIMethodsPage apiMethodsPage() {
	        logger.debug("Creating Bean APIMethodsPage");
	        return new APIMethodsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public APIErrorMessagesPage apiErrorMessagesPage() {
	        logger.debug("Creating Bean APIErrorMessagesPage");
	        return new APIErrorMessagesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public APIExamplesPage apiExamplesPage() {
	        logger.debug("Creating Bean APIExamplesPage");
	        return new APIExamplesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SampleReportPage sampleReportPage() {
	        logger.debug("Creating Bean SampleReportPage");
	        return new SampleReportPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ChargebeeSettingsPage chargebeeSettingsPage() {
	        logger.debug("Creating Bean ChargebeeSettingsPage");
	        return new ChargebeeSettingsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageTaskSection homePageTaskSection() {
	        logger.debug("Creating Bean homePageTaskSection");
	        return new HomePageTaskSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageBusinessStatusSection homePageBusinessStatusSection() {
	        logger.debug("Creating Bean homePageBusinessStatusSection");
	        return new HomePageBusinessStatusSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageQuickStartSection homePageQuickStartSection() {
	        logger.debug("Creating Bean homePageQuickStartSection");
	        return new HomePageQuickStartSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageRecentLoginActivitySection homePageRecentLoginActivitySection() {
	        logger.debug("Creating Bean homePageRecentLoginActivitySection");
	        return new HomePageRecentLoginActivitySection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageScheduleSection homePageScheduleSection() {
	        logger.debug("Creating Bean homePageScheduleSection");
	        return new HomePageScheduleSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageShortcutsSection homePageShortcutsSection() {
	        logger.debug("Creating Bean homePageShortcutsSection");
	        return new HomePageShortcutsSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyClientsPage myClientsPage(){
	        logger.debug("Creating Bean MyClientsPage");
	        return new MyClientsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientTabNavigationBar clientTabNavigationBar() {
	        logger.debug("Creating Bean ClientTabNavigationBar");
	        return new ClientTabNavigationBar(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientNavigationHelper clientNavigationHelper(){
	        logger.debug("Creating bean ClientNavigationHelper");
	        return new ClientNavigationHelper();
	    }

	    @Bean
	    public AddClientPage addClientPage(){
	        logger.debug("Creating Bean AddClientPage");
	        return new AddClientPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditClientPage editClientPage(){
	        logger.debug("Creating Bean EditClientPage");
	        return new EditClientPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AssignTeamMemberPopup assignTeamMemberPopup(){
	        logger.debug("Creating Bean AssignTeamMemberPopup");
	        return new AssignTeamMemberPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditLeadPage editLeadPage(){
	        logger.debug("Creating Bean EditLeadPage");
	        return new EditLeadPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SearchClientPage searchClientPage(){
	        logger.debug("Creating Bean SearchClientPage");
	        return new SearchClientPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SearchClientPageBasicSearchSection searchClientPageBasicSearchSection(){
	        logger.debug("Creating Bean SearchClientPageBasicSearchSection");
	        return new SearchClientPageBasicSearchSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SearchClientPageAdvancedSearchSection searchClientPageAdvancedSearchSection(){
	        logger.debug("Creating Bean SearchClientPageAdvancedSearchSection");
	        return new SearchClientPageAdvancedSearchSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SearchClientPageResultSection searchClientPageResultSection(){
	        logger.debug("Creating Bean SearchClientPageResultSection");
	        return new SearchClientPageResultSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ImportCSVPopup importCSVPopup(){
	        logger.debug("Creating Bean ImportCSVPopup");
	        return new ImportCSVPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PrintClientListPopup printClientListPopup(){
	        logger.debug("Creating Bean PrintClientListPopup");
	        return new PrintClientListPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public InactivateOrDeleteClientPopup inactivateOrDeleteClientPopup(){
	        logger.debug("Creating Bean InactivateOrDeleteClientPopup");
	        return new InactivateOrDeleteClientPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public InternalNotePage internalNotesPage(){
	        logger.debug("Creating Bean InternalNotePage");
	        return new InternalNotePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditInternalNotePage editInternalNotePage(){
	        logger.debug("Creating Bean EditInternalNotePage");
	        return new EditInternalNotePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public InternalNotesPage internalNotesListPage(){
	        logger.debug("Creating Bean InternalNotesPage");
	        return new InternalNotesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PendingReportPage pendingReportPage(){
	        logger.debug("Creating Bean PendingReportPage");
	        return new PendingReportPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EducatePage educatePage(){
	        logger.debug("Creating Bean EducatePage");
	        return new EducatePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EducatePageClientOutstandingDebtsSection educatePageClientOutstandingDebtsSection(){
	        logger.debug("Creating Bean EducatePageClientOutstandingDebtsSection");
	        return new EducatePageClientOutstandingDebtsSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EducatePageClientOutstandingDebtsSectionPrintPreviewPopup educatePageClientOutstandingDebtsSectionPrintPreviewPopup(){
	        logger.debug("Creating Bean EducatePageClientOutstandingDebtsSectionPrintPreviewPopup");
	        return new EducatePageClientOutstandingDebtsSectionPrintPreviewPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EducatePageClientExpensesSection educatePageClientExpensesSection(){
	        logger.debug("Creating Bean EducatePageClientExpensesSection");
	        return new EducatePageClientExpensesSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EducatePageClientExpensesSectionPrintPreviewPopup educatePageClientExpensesSectionPrintPreviewPopup(){
	        logger.debug("Creating Bean EducatePageClientExpensesSectionPrintPreviewPopup");
	        return new EducatePageClientExpensesSectionPrintPreviewPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EducatePageCalculatorsSection educatePageCalculatorsSection(){
	        logger.debug("Creating Bean EducatePageCalculatorsSection");
	        return new EducatePageCalculatorsSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ActivityPage activityPage(){
	        logger.debug("Creating Bean ActivityPage");
	        return new ActivityPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PrintActivityPopup printActivityPopup(){
	        logger.debug("Creating Bean PrintActivityPopup");
	        return new PrintActivityPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }
	    @Bean
	    public DisputeWizardPage disputeWizardPage(){
	        logger.debug("Creating Bean DisputeWizardPage");
	        return new DisputeWizardPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeWizardStep1Page disputeWizardStep1Page(){
	        logger.debug("Creating Bean DisputeWizardStep1Page");
	        return new DisputeWizardStep1Page(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeWizardStep1aPage disputeWizardStep1aPage(){
	        logger.debug("Creating Bean DisputeWizardStep1aPage");
	        return new DisputeWizardStep1aPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ChangeFavouriteProviderPopup changeFavouriteProviderPopup(){
	        logger.debug("Creating Bean ChangeFavouriteProviderPopup");
	        return new ChangeFavouriteProviderPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeWizardStep1cPage disputeWizardStep1cPage(){
	        logger.debug("Creating Bean DisputeWizardStep1cPage");
	        return new DisputeWizardStep1cPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeWizardStep2Page disputeWizardStep2Page(){
	        logger.debug("Creating Bean DisputeWizardStep2Page");
	        return new DisputeWizardStep2Page(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeWizardStep3Page disputeWizardStep3Page(){
	        logger.debug("Creating Bean DisputeWizardStep3Page");
	        return new DisputeWizardStep3Page(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SavedPendingItemPopup savedPendingItemPopup(){
	        logger.debug("Creating Bean SavedPendingItemPopup");
	        return new SavedPendingItemPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SaveDisputeLettersPopup saveDisputeLettersPopup(){
	        logger.debug("Creating Bean SaveDisputeLettersPopup");
	        return new SaveDisputeLettersPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddFurnisherPopup addFurnisherPopup(){
	        logger.debug("Creating Bean AddFurnisherPopup");
	        return new AddFurnisherPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PreviewLettersPopup previewLettersPopup(){
	        logger.debug("Creating Bean PreviewLettersPopup");
	        return new PreviewLettersPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public UnsavedLetterWarningPopup unsavedLetterWarningPopup(){
	        logger.debug("Creating Bean UnsavedLetterWarningPopup");
	        return new UnsavedLetterWarningPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPage clientDashboardPage(){
	        logger.debug("Creating Bean ClientDashboardPage");
	        return new ClientDashboardPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageClientSection clientDashboardPageClientSection(){
	        logger.debug("Creating Bean ClientDashboardPageClientSection");
	        return new ClientDashboardPageClientSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageContactSection clientDashboardPageContactSection(){
	        logger.debug("Creating Bean ClientDashboardPageContactSection");
	        return new ClientDashboardPageContactSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageDisputeStatusSection clientDashboardPageDisputeStatusSection(){
	        logger.debug("Creating Bean ClientDashboardPageDisputeStatusSection");
	        return new ClientDashboardPageDisputeStatusSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DocumentStoragePopup documentStoragePopup(){
	        logger.debug("Creating Bean DocumentStoragePopup");
	        return new DocumentStoragePopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SavedLettersPage savedLettersPage(){
	        logger.debug("Creating Bean SavedLettersPage");
	        return new SavedLettersPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageDocumentSection clientDashboardPageDocumentSection(){
	        logger.debug("Creating Bean ClientDashboardPageDocumentSection");
	        return new ClientDashboardPageDocumentSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CustomizeDocumentListPopup customizeDocumentListPopup(){
	        logger.debug("Creating Bean CustomizeDocumentListPopup");
	        return new CustomizeDocumentListPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }


	    @Bean
	    public ClientDashboardPageInvoiceSection clientDashboardPageInvoiceSection(){
	        logger.debug("Creating Bean ClientDashboardPageInvoiceSection");
	        return new ClientDashboardPageInvoiceSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CreateNewInvoicePage createNewInvoicePage(){
	        logger.debug("Creating Bean CreateNewInvoicePage");
	        return new CreateNewInvoicePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AllClientInvoicesPage allClientInvoicesPage(){
	        logger.debug("Creating Bean MyInvoicesPage");
	        return new AllClientInvoicesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyInvoicesPage myInvoicesPage(){
	        logger.debug("Creating Bean MyInvoicesPage");
	        return new MyInvoicesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddInvoicePage addInvoicePage(){
	        logger.debug("Creating Bean AddInvoicePage");
	        return new AddInvoicePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditInvoicePage editInvoicePage(){
	        logger.debug("Creating Bean EditInvoicePage");
	        return new EditInvoicePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public PreviewInvoicePage previewInvoicePage(){
	        logger.debug("Creating Bean PreviewInvoicePage");
	        return new PreviewInvoicePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public BillingRemindersPopup billingRemindersPopup(){
	        logger.debug("Creating Bean PreviewInvoicePage");
	        return new BillingRemindersPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddSavedInvoiceItemsPopup addSavedInvoiceItemsPopup(){
	        logger.debug("Creating Bean AddSavedInvoiceItemsPopup");
	        return new AddSavedInvoiceItemsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientInvoicesHistoryPage clientInvoicesHistoryPage(){
	        logger.debug("Creating Bean ClientInvoicesHistoryPage");
	        return new ClientInvoicesHistoryPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MarkPaymentReceivedPopup markPaymentReceivedPopup(){
	        logger.debug("Creating Bean MarkPaymentReceivedPopup");
	        return new MarkPaymentReceivedPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageMemoSection clientDashboardPageMemoSection(){
	        logger.debug("Creating Bean ClientDashboardPageMemoSection");
	        return new ClientDashboardPageMemoSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageScoreSection clientDashboardPageScoreSection(){
	        logger.debug("Creating Bean ClientDashboardPageScoreSection");
	        return new ClientDashboardPageScoreSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ManageScorePopup manageScorePopup(){
	        logger.debug("Creating Bean ManageScorePopup");
	        return new ManageScorePopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageTaskSection clientDashboardPageTaskSection(){
	        logger.debug("Creating Bean ClientDashboardPageTaskSection");
	        return new ClientDashboardPageTaskSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageTaskSectionTeamTaskSubSection clientDashboardPageTaskSectionTeamTaskSubSection(){
	        logger.debug("Creating Bean ClientDashboardPageTaskSectionTeamTaskSubSection");
	        return new ClientDashboardPageTaskSectionTeamTaskSubSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CompletedTeamTaskPopup completedTeamTaskPopup(){
	        logger.debug("Creating Bean CompletedTeamTaskPopup");
	        return new CompletedTeamTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddTeamTaskPopup addTeamTaskPopup(){
	        logger.debug("Creating Bean AddTeamTaskPopup");
	        return new AddTeamTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientDashboardPageTaskSectionClientTaskSubSection clientDashboardPageTaskSectionClientTaskSubSection(){
	        logger.debug("Creating Bean ClientDashboardPageTaskSectionClientTaskSubSection");
	        return new ClientDashboardPageTaskSectionClientTaskSubSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CompletedClientTaskPopup completedClientTaskPopup(){
	        logger.debug("Creating Bean CompletedClientTaskPopup");
	        return new CompletedClientTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddClientTaskPopup addClientTaskPopup(){
	        logger.debug("Creating Bean AddClientTaskPopup");
	        return new AddClientTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public CompleteClientTaskPopup completeClientTaskPopup(){
	        logger.debug("Creating Bean CompleteClientTaskPopup");
	        return new CompleteClientTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeItemPage disputeItemPage(){
	        logger.debug("Creating Bean DisputeItemPage");
	        return new DisputeItemPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditDisputeItemPopup editDisputeItemPopup(){
	        logger.debug("Creating Bean EditDisputeItemPopup");
	        return new EditDisputeItemPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddDisputeItemPage addDisputeItemPage(){
	        logger.debug("Creating Bean AddDisputeItemPage");
	        return new AddDisputeItemPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DisputeItemReportViewPage disputeItemReportViewPage(){
	        logger.debug("Creating Bean DisputeItemReportViewPage");
	        return new DisputeItemReportViewPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ImportAuditPage importAuditPage(){
	        logger.debug("Creating Bean ImportAuditPage");
	        return new ImportAuditPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ImportCreditReportPopup importCreditReportPopup(){
	        logger.debug("Creating Bean ImportCreditReportPopup");
	        return new ImportCreditReportPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPage dashboardPage(){
	        logger.debug("Creating Bean DashboardPage");
	        return new DashboardPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPageClientOverviewSection dashboardPageClientOverviewSection(){
	        logger.debug("Creating Bean DashboardPageClientOverviewSection");
	        return new DashboardPageClientOverviewSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPageRateOverviewSection dashboardPageRateOverviewSection(){
	        logger.debug("Creating Bean DashboardPageRateOverviewSection");
	        return new DashboardPageRateOverviewSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPageSalesGrowthSection dashboardPageSalesGrowthSection(){
	        logger.debug("Creating Bean DashboardPageSalesGrowthSection");
	        return new DashboardPageSalesGrowthSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPageClientStagesSection dashboardPageClientStagesSection(){
	        logger.debug("Creating Bean DashboardPageSalesGrowthSection");
	        return new DashboardPageClientStagesSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPageClientStatusSection dashboardPageClientStatusSection(){
	        logger.debug("Creating Bean DashboardPageClientStatusSection");
	        return new DashboardPageClientStatusSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPageTopAffiliateSection dashboardPageTopAffiliateSection(){
	        logger.debug("Creating Bean DashboardPageTopAffiliateSection");
	        return new DashboardPageTopAffiliateSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public DashboardPageTopTeamMembersSection dashboardPageTopTeamMembersSection(){
	        logger.debug("Creating Bean DashboardPageTopTeamMembersSection");
	        return new DashboardPageTopTeamMembersSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public WarningPopup warningPopup(){
	        logger.debug("Creating Bean WarningPopup");
	        return new WarningPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public FlashMessage flashMessage(){
	        logger.debug("Creating Bean FlashMessage");
	        return new FlashMessage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageTaskSectionNewTaskPopup newTaskPopup(){
	        logger.debug("Creating Bean HomePageTaskSectionNewTaskPopup");
	        return new HomePageTaskSectionNewTaskPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public HomePageTaskSectionTaskSelectionWidget taskSelectionWidget(){
	        logger.debug("Creating Bean HomePageTaskSectionTaskSelectionWidget");
	        return new HomePageTaskSectionTaskSelectionWidget(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }


	    @Bean
	    public HomePageQuickStartSectionClientSelectionWidget homePageQuickStartSectionClientSelectionWidget(){
	        logger.debug("Creating Bean HomePageQuickStartSectionClientSelectionWidget");
	        return new HomePageQuickStartSectionClientSelectionWidget(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EverythingTodaysLetterPage everythingTodaysLetterPage(){
	        logger.debug("Creating Bean EverythingTodaysLetterPage");
	        return new EverythingTodaysLetterPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClaimShirtPage claimShirtPage(){
	        logger.debug("Creating Bean ClaimShirtPage");
	        return new ClaimShirtPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ResourcesPage resourcesPage(){
	        logger.debug("Creating Bean ResourcesPage");
	        return new ResourcesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ChangePasswordPage changePasswordPage(){
	        logger.debug("Creating Bean ChangePasswordPage");
	        return new ChangePasswordPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ContactsPage contactsPage(){
	        logger.debug("Creating Bean ContactsPage");
	        return new ContactsPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public GuidePage guidePage(){
	        logger.debug("Creating Bean GuidePage");
	        return new GuidePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public BonusMaterialPage bonusMaterialPage(){
	        logger.debug("Creating Bean BonusMaterialPage");
	        return new BonusMaterialPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MessagePopup messagePopup(){
	        logger.debug("Creating Bean MessagePopup");
	        return new MessagePopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SendMessagePage sendMessagePage(){
	        logger.debug("Creating Bean SendMessagePage");
	        return new SendMessagePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MessageSectionHelper messageSectionHelper(){
	        logger.debug("Creating Bean MessageSectionHelper");
	        return new MessageSectionHelper();
	    }

	    @Bean
	    public MessageSectionNavigationBar messageSectionNavigationBar(){
	        logger.debug("Creating Bean MessageSectionNavigationBar");
	        return new MessageSectionNavigationBar(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AllMessagesPage allMessagesPage(){
	        logger.debug("Creating Bean AllMessagesPage");
	        return new AllMessagesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ClientMessagesPage clientMessagesPage(){
	        logger.debug("Creating Bean ClientMessagesPage");
	        return new ClientMessagesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AffiliateMessagesPage affiliateMessagesPage(){
	        logger.debug("Creating Bean AffiliateMessagesPage");
	        return new AffiliateMessagesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public TeamMemberMessagesPage teamMemberMessagesPage(){
	        logger.debug("Creating Bean TeamMemberMessagesPage");
	        return new TeamMemberMessagesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SendNewMessagePage sendNewMessagePage(){
	        logger.debug("Creating Bean SendNewMessagePage");
	        return new SendNewMessagePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public ManageQuickNotesPage manageQuickNotesPage(){
	        logger.debug("Creating Bean ManageQuickNotesPage");
	        return new ManageQuickNotesPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public AddQuickNotePage addQuickNotePage(){
	        logger.debug("Creating Bean AddQuickNotePage");
	        return new AddQuickNotePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public EditQuickNotePage editQuickNotePage(){
	        logger.debug("Creating Bean EditQuickNotePage");
	        return new EditQuickNotePage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public NavigationHelper navigationHelper(){
	        logger.debug("Creating bean NavigationHelper");
	        return new NavigationHelper();
	    }

	    @Bean
	    public BusinessCheckListPage businessCheckListPage(){
	        logger.debug("Creating Bean BusinessCheckListPage");
	        return new BusinessCheckListPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public NewFeatureRequestsPopup newFeatureRequests(){
	        logger.debug("Creating Bean NewFeatureRequestsPopup");
	        return new NewFeatureRequestsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyAccountPage myAccountPage(){
	        logger.debug("Creating Bean MyAccountPage");
	        return new MyAccountPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyAccountPageCurrentPlanDetailsSection myAccountPageCurrentPlanDetailsSection(){
	        logger.debug("Creating Bean MyAccountPageCurrentPlanDetailsSection");
	        return new MyAccountPageCurrentPlanDetailsSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyAccountPageUsageSection myAccountPageUsageSection(){
	        logger.debug("Creating Bean MyAccountPageUsageSection");
	        return new MyAccountPageUsageSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public UpdateCreditCardDetailsPopup updateCreditCardDetailsPopup(){
	        logger.debug("Creating Bean UpdateCreditCardDetailsPopup");
	        return new UpdateCreditCardDetailsPopup(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyAccountPageStatusSection myAccountPageStatusSection(){
	        logger.debug("Creating Bean MyAccountPageStatusSection");
	        return new MyAccountPageStatusSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public SubscriptionPage subscription(){
	        logger.debug("Creating Bean SubscriptionPage");
	        return new SubscriptionPage(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    @Bean
	    public MyAccountPageAutoRechargeSection myAccountPageAutoRechargeSection(){
	        logger.debug("Creating Bean MyAccountPageAutoRechargeSection");
	        return new MyAccountPageAutoRechargeSection(
	                webdriver,
	                wait,
	                baseurl
	        );
	    }

	    //Beans with baseURL different than the environment.

	    @Bean
	    public QuickVideosPage quickVideosPage(){
	        logger.debug("Creating Bean QuickVideosPage");
	        return new QuickVideosPage(
	                webdriver,
	                wait,
	                "https://www.creditrepaircloud.com"
	        );
	    }

	    @Bean
	    public SupportCenterPage supportCenterPage(){
	        logger.debug("Creating Bean SupportCenterPage");
	        return new SupportCenterPage(
	                webdriver,
	                wait,
	                "http://support.creditrepaircloud.com/"
	        );
	    }

	    @Bean
	    public ReadStartupGuidePage readStartupGuidePage(){
	        logger.debug("Creating Bean ReadStartupGuidePage");
	        return new ReadStartupGuidePage(
	                webdriver,
	                wait,
	                "https://www.creditrepaircloud.com"
	        );
	    }

	    @Bean
	    public TipsAndTricksPage tipsAndTricksPage(){
	        logger.debug("Creating Bean TipsAndTricksPage");
	        return new TipsAndTricksPage(
	                webdriver,
	                wait,
	                "https://www.creditrepaircloud.com"
	        );
	    }

	    @Bean
	    public BusinessWebsitePage businessWebsitePage(){
	        logger.debug("Creating Bean BusinessWebsitePage");
	        return new BusinessWebsitePage(
	                webdriver,
	                wait,
	                "https://www.mycreditrepairsite.com/"
	        );
	    }

	    @Bean
	    public ClientAndAffiliatePortalPage clientAndAffiliatePortalPage(){
	        logger.debug("Creating Bean ClientAndAffiliatePortalPage");
	        return new ClientAndAffiliatePortalPage(
	                webdriver,
	                wait,
	                "https://www.secureclientaccess.com/"
	        );
	    }

	    @Bean
	    public SecureClientAccessPage secureClientAccessPage(){
	        logger.debug("Creating Bean ClientAndAffiliatePortalPage");
	        return new SecureClientAccessPage(
	                webdriver,
	                wait,
	                "https://www.secureclientaccess.com/"
	        );
	    }

	    @Bean
	    public CancelAccountPage cancelAccountPage(){
	        logger.debug("Creating Bean CancelAccountPage");
	        return new CancelAccountPage(
	                webdriver,
	                wait,
	                "https://w.creditrepaircloud.com"
	        );
	    }

	    @Bean
	    public AnnualCreditReportPage annualCreditReportPage(){
	        logger.debug("Creating Bean AnnualCreditReportPage");
	        return new AnnualCreditReportPage(
	                webdriver,
	                wait,
	                "https://www.annualcreditreport.com"
	        );
	    }

	    @Bean
	    public PrivacyGuardPage privacyGuardPage(){
	        logger.debug("Creating Bean PrivacyGuardPage");
	        return new PrivacyGuardPage(
	                webdriver,
	                wait,
	                "https://www.privacyguard.com"
	        );
	    }

	    @Bean
	    public OrderCreditReportPage orderCreditReportPage(){
	        logger.debug("Creating Bean OrderCreditReportPage");
	        return new OrderCreditReportPage(
	                webdriver,
	                wait,
	                "https://support.creditrepaircloud.com"
	        );
	    }
	}

