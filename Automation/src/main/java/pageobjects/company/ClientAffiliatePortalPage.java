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

	import java.util.ArrayList;

	/**
	 * Class representing Client Affiliate Portal page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPage extends AbstractBasePageObject<ClientAffiliatePortalPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPage.class);

	    private static final String relativeUrl = "/client_affiliate_portal";

	    @Autowired
	    private ClientAffiliatePortalPageMyLogoSection clientAffiliatePortalPageMyLogoSection;

	    @Autowired
	    private ClientAffiliatePortalPageDetailsSection clientAffiliatePortalPageDetailsSection;

	    @Autowired
	    private ClientAffiliatePortalPageResourcesSection clientAffiliatePortalPageResourcesSection;

	    @Autowired
	    private ClientAffiliatePortalPageCreditInfoSection clientAffiliatePortalPageCreditInfoSection;

	    @Autowired
	    private ClientAffiliatePortalPageClientsChoiceSection clientAffiliatePortalPageClientsChoiceSection;

	    @Autowired
	    private ClientAffiliatePortalPagePortalThemeSection clientAffiliatePortalPagePortalThemeSection;

	    @Autowired
	    private ClientAffiliatePortalPageOnboardingAndTasksSection clientAffiliatePortalPageOnboardingAndTasksSection;

	    public ClientAffiliatePortalPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal pagee: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'Client/Affiliate Portal Options')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//form[@id='form1client']/input[@id='signin']")
	    private WebElement viewMyClientPortalButton;

	    @FindBy(how = How.XPATH, using = "//form[@id='form2']/input[@id='signin']")
	    private WebElement viewMyAffiliatePortalButton;

	    @FindBy(how = How.ID, using = "mylogo")
	    private WebElement myLogoTab;

	    @FindBy(how = How.ID, using = "details")
	    private WebElement detailsTab;

	    @FindBy(how = How.ID, using = "resources")
	    private WebElement resourcesTab;

	    @FindBy(how = How.ID, using = "creditinfo")
	    private WebElement creditInfoTab;

	    @FindBy(how = How.ID, using = "clientchoice")
	    private WebElement clientChoiceTab;

	    @FindBy(how = How.ID, using = "portaltheme")
	    private WebElement portalThemeTab;

	    @FindBy(how = How.ID, using = "client_onboarding")
	    private WebElement clientOnboardingTab;

	    public ClientAffiliatePortalPageMyLogoSection getClientAffiliatePortalPageMyLogoSection() {
	        return clientAffiliatePortalPageMyLogoSection;
	    }

	    public ClientAffiliatePortalPageDetailsSection getClientAffiliatePortalPageDetailsSection() {
	        return clientAffiliatePortalPageDetailsSection;
	    }

	    public ClientAffiliatePortalPageResourcesSection getClientAffiliatePortalPageResourcesSection() {
	        return clientAffiliatePortalPageResourcesSection;
	    }

	    public ClientAffiliatePortalPageCreditInfoSection getClientAffiliatePortalPageCreditInfoSection() {
	        return clientAffiliatePortalPageCreditInfoSection;
	    }

	    public ClientAffiliatePortalPageClientsChoiceSection getClientAffiliatePortalPageClientsChoiceSection() {
	        return clientAffiliatePortalPageClientsChoiceSection;
	    }

	    public ClientAffiliatePortalPagePortalThemeSection getClientAffiliatePortalPagePortalThemeSection() {
	        return clientAffiliatePortalPagePortalThemeSection;
	    }

	    public ClientAffiliatePortalPageOnboardingAndTasksSection getClientAffiliatePortalPageOnboardingAndTasksSection() {
	        return clientAffiliatePortalPageOnboardingAndTasksSection;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getViewMyClientPortalButton() {
	        return viewMyClientPortalButton;
	    }

	    public WebElement getViewMyAffiliatePortalButton() {
	        return viewMyAffiliatePortalButton;
	    }

	    public void secureAppLoadedInTab() throws Error {
	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
	        String url = getDriver().getCurrentUrl();
	        logger.debug("url before: {}", url);
	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab
	        getDriver().close();
	        webdriver.switchTo().window(tabs.get(0)); //switches to old tab
	    }

	    public WebElement getMyLogoTab() {
	        return myLogoTab;
	    }

	    public WebElement getDetailsTab() {
	        return detailsTab;
	    }

	    public WebElement getResourcesTab() {
	        return resourcesTab;
	    }

	    public WebElement getCreditInfoTab() {
	        return creditInfoTab;
	    }

	    public WebElement getClientChoiceTab() {
	        return clientChoiceTab;
	    }

	    public WebElement getPortalThemeTab() {
	        return portalThemeTab;
	    }

	    public WebElement getClientOnboardingTab() {
	        return clientOnboardingTab;
	    }

	}

