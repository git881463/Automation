package pageobjects.client;

	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;


	public class ClientNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(ClientNavigationHelper.class);

	    @Autowired
	    protected WebDriverWait wait;

	    @Autowired
	    private ClientTabNavigationBar clientTabNavigationBar;

	    @Autowired
	    private MyClientsPage myClientsPage;

	    public void clickClientDashboardTab(){
	        clientTabNavigationBar.getClientDashboardTab().click();
	        myClientsPage.getClientDashboardPage().isLoaded();
	    }

	    public void clickImportAuditTab(){
	        clientTabNavigationBar.getImportAuditTab().click();
	        myClientsPage.getImportAuditPage().isLoaded();
	    }

	    public void clickPendingReportTab(){
	        clientTabNavigationBar.getPendingReportTab().click();
	        myClientsPage.getPendingReportPage().isLoaded();
	    }

	    public void clickDisputeWizardTab(){
	        clientTabNavigationBar.getDisputeWizardTab().click();
	        myClientsPage.getDisputeWizardPage().isLoaded();
	    }

	    public void clickDisputeItemsTab(){
	        clientTabNavigationBar.getDisputeItemsTab().click();
	        myClientsPage.getDisputeItemPage().isLoaded();
	    }

	    public void clickEducateTab(){
	        clientTabNavigationBar.getEducateTab().click();
	        myClientsPage.getEducatePage().isLoaded();
	    }

	    public void clickMessagesTab(){
	        clientTabNavigationBar.getMessagesTab().click();
	    }

	    public void clickInternalNotesTab(){
	        clientTabNavigationBar.getInternalNotesTab().click();
	        myClientsPage.getInternalNotesPage().isLoaded();
	    }

	    public void clickInvoicesTab(){
	        clientTabNavigationBar.getInvoicesTab().click();
	        myClientsPage.getClientInvoicesHistoryPage().isLoaded();
	    }

	    public void clickActivityTab(){
	        clientTabNavigationBar.getActivityTab().click();
	        myClientsPage.getActivityPage().isLoaded();
	    }
	}

