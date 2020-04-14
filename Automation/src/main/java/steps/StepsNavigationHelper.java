package steps;

	import pageobjects.account.MyAccountPage;
	import pageobjects.account.SubscriptionPage;
	import pageobjects.affiliates.AffiliatesPage;
	import pageobjects.client.ClientNavigationHelper;
	import pageobjects.client.MyClientsPage;
	import pageobjects.company.CompanyPage;
	import pageobjects.contacts.ContactsPage;
	import pageobjects.creditors.CreditorsFurnishersPage;
	import pageobjects.dashboard.DashboardPage;
	import pageobjects.everything.EverythingPage;
	import pageobjects.everything.EverythingTodaysLetterPage;
	import pageobjects.header.CommonHeaderSection;
	import pageobjects.header.NewFeatureRequestsPopup;
	import pageobjects.history.HistoryPage;
	import pageobjects.home.HomePage;
	import pageobjects.invoice.MyInvoicesPage;
	import pageobjects.library.LibraryPage;
	import pageobjects.messages.MessageSectionHelper;
	import pageobjects.navigation.NavigationHelper;
	import pageobjects.others.*;
	import pageobjects.schedule.SchedulePage;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Steps Helper class containing common items to be shared across steps.
	 * All Steps file should inherit from this class, to avail access to application beans.
	 */
	public class StepsNavigationHelper extends ParentSteps {
	    private static final Logger logger = LoggerFactory.getLogger(StepsNavigationHelper.class);

	    @Autowired
	    protected CommonHeaderSection commonHeaderSection;

	    @Autowired
	    protected HomePage homePage;

	    @Autowired
	    protected SchedulePage schedulePage;

	    @Autowired
		protected HistoryPage historyPage;

	    @Autowired
	    protected MyClientsPage myClientsPage;

	    @Autowired
	    protected EverythingPage everythingPage;

	    @Autowired
	    protected EverythingTodaysLetterPage everythingTodaysLetterPage;

	    @Autowired
	    protected CreditorsFurnishersPage creditorsFurnishersPage;

	    @Autowired
	    protected LibraryPage libraryPage;

	    @Autowired
	    protected AffiliatesPage affiliatesPage;

	    @Autowired
	    protected ClaimShirtPage claimShirtPage;

	    @Autowired
	    protected ResourcesPage resourcesPage;

	    @Autowired
	    protected DashboardPage dashboardPage;

	    @Autowired
	    protected CompanyPage companyPage;

	    @Autowired
	    protected ContactsPage contactsPage;

	    @Autowired
	    protected GuidePage guidePage;

	    @Autowired
	    protected BonusMaterialPage bonusMaterialPage;

	    @Autowired
	    protected ChangePasswordPage changePasswordPage;

	    @Autowired
	    protected MessageSectionHelper messageSectionHelper;

	    @Autowired
	    protected NewFeatureRequestsPopup newFeatureRequestsPopup;

	    @Autowired
	    protected BusinessCheckListPage businessCheckListPage;

	    @Autowired
	    protected NavigationHelper navigationHelper;

	    @Autowired
	    protected ClientNavigationHelper clientNavigationHelper;

	    @Autowired
	    protected QuickVideosPage quickVideosPage;

	    @Autowired
	    protected SupportCenterPage supportCenterPage;

	    @Autowired
	    protected ReadStartupGuidePage readStartupGuidePage;

	    @Autowired
	    protected TipsAndTricksPage tipsAndTricksPage;

	    @Autowired
	    protected BusinessWebsitePage businessWebsitePage;

	    @Autowired
	    protected ClientAndAffiliatePortalPage clientAndAffiliatePortalPage;

	    @Autowired
	    protected MyAccountPage myAccountPage;

	    @Autowired
	    protected SubscriptionPage subscriptionPage;

	    @Autowired
	    protected CancelAccountPage cancelAccountPage;

	    @Autowired
	    protected MyInvoicesPage myInvoicesPage;

	    @Autowired
	    protected SampleReportPage sampleReportPage;

	    @Autowired
	    protected SecureClientAccessPage secureClientAccessPage;

	    @Autowired
	    protected AnnualCreditReportPage annualCreditReportPage;

	    @Autowired
	    protected PrivacyGuardPage privacyGuardPage;

	    @Autowired
	    protected  OrderCreditReportPage orderCreditReportPage;
	}

