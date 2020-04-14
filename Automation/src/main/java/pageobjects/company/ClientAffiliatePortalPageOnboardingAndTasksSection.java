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
	 * Class representing Client Affiliate Portal page Clients Onboarding & Tasks  section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPageOnboardingAndTasksSection extends AbstractBasePageObject<ClientAffiliatePortalPageOnboardingAndTasksSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPageOnboardingAndTasksSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private ClientTaskForOnboardingPopup clientTaskForOnboardingPopup;

	    @Autowired
	    private PreviewOfTaskPopup previewOfTaskPopup;

	    @Autowired
	    private EditTaskPopup editTaskPopup;

	    public ClientAffiliatePortalPageOnboardingAndTasksSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal page onboarding and tasks section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "client_task_control_on")
	    private WebElement clientOnboardingOnRadio;

	    @FindBy(how = How.ID, using = "client_task_control_off")
	    private WebElement clientOnboardingOffRadio;

	    @FindBy(how = How.ID, using = "default_edit")
	    private WebElement editDefaultTasksButton;

	    @FindBy(how = How.ID, using = "welcome_preview")
	    private WebElement previewButton1;

	    @FindBy(how = How.ID, using = "welcome_edit")
	    private WebElement editButton1;

	    @FindBy(how = How.ID, using = "or_report_preview")
	    private WebElement previewButton2;

	    @FindBy(how = How.ID, using = "signature_preview")
	    private WebElement previewButton3;

	    @FindBy(how = How.ID, using = "preview_edit")
	    private WebElement previewButton4;

	    @FindBy(how = How.ID, using = "upload_pid_preview")
	    private WebElement previewButton5;

	    @FindBy(how = How.ID, using = "upload_aid_preview")
	    private WebElement previewButton6;

	    public ClientTaskForOnboardingPopup getClientTaskForOnboardingPopup() {
	        return clientTaskForOnboardingPopup;
	    }

	    public PreviewOfTaskPopup getPreviewOfTaskPopup() {
	        return previewOfTaskPopup;
	    }

	    public EditTaskPopup getEditTaskPopup() {
	        return editTaskPopup;
	    }

	    public WebElement getClientOnboardingOnRadio() {
	        return clientOnboardingOnRadio;
	    }

	    public WebElement getClientOnboardingOffRadio() {
	        return clientOnboardingOffRadio;
	    }

	    public WebElement getEditDefaultTasksButton() {
	        return editDefaultTasksButton;
	    }

	    public WebElement getPreviewButton1() {
	        return previewButton1;
	    }

	    public WebElement getEditButton1() {
	        return editButton1;
	    }

	    public WebElement getPreviewButton2() {
	        return previewButton2;
	    }

	    public WebElement getPreviewButton3() {
	        return previewButton3;
	    }

	    public WebElement getPreviewButton4() {
	        return previewButton4;
	    }

	    public WebElement getPreviewButton5() {
	        return previewButton5;
	    }

	    public WebElement getPreviewButton6() {
	        return previewButton6;
	    }
	}


