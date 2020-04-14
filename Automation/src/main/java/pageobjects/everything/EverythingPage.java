package pageobjects.everything;

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
	 * Class representing Everything Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EverythingPage extends AbstractBasePageObject<EverythingPage> {

	    private static final Logger logger = LoggerFactory.getLogger(EverythingPage.class);

	    private static final String relativeUrl = "/everything";

	    @Autowired
	    private ProgressPage progressPage;

	    @Autowired
	    private PendingClientsPage pendingClientsPage;

	    @Autowired
	    private AllTasksPage allTasksPage;

	    @Autowired
	    private EverythingAllMessagesPage everythingAllMessagesPage;

	    @Autowired
	    private AllDocumentsPage allDocumentsPage;

	    public EverythingPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the everything page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//section[@id='cd-timeline']//a[@class='vediopopup']")
	    private WebElement quickVideoLink;

	    @FindBy(how = How.XPATH, using = "//section[@id='cd-timeline']//section[@class='everything']/header")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//section[@id='cd-timeline']//a[contains(text(),'Progress')]")
	    private WebElement progressLink;

	    @FindBy(how = How.XPATH, using = "//section[@id='cd-timeline']//a[contains(text(),'First work pending')]")
	    private WebElement firstWorkPendingLink;

	    @FindBy(how = How.XPATH, using = "//section[@id='cd-timeline']//a[contains(text(),'All Tasks')]")
	    private WebElement allTasksLink;

	    @FindBy(how = How.XPATH, using = "//section[@id='cd-timeline']//a[contains(text(),'All communication')]")
	    private WebElement allCommunicationsLink;

	    @FindBy(how = How.XPATH, using = "//section[@id='cd-timeline']//a[contains(text(),'All files')]")
	    private WebElement allFilesLink;

	    public ProgressPage getProgressPage() {
	        return progressPage;
	    }

	    public PendingClientsPage getPendingClientsPage() {
	        return pendingClientsPage;
	    }

	    public AllTasksPage getAllTasksPage() {
	        return allTasksPage;
	    }

	    public EverythingAllMessagesPage getEverythingAllMessagesPage() {
	        return everythingAllMessagesPage;
	    }

	    public AllDocumentsPage getAllDocumentsPage() {
	        return allDocumentsPage;
	    }

	    public WebElement getQuickVideoLink() {
	        return quickVideoLink;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getProgressLink() {
	        return progressLink;
	    }

	    public WebElement getFirstWorkPendingLink() {
	        return firstWorkPendingLink;
	    }

	    public WebElement getAllTasksLink() {
	        return allTasksLink;
	    }

	    public WebElement getAllCommunicationsLink() {
	        return allCommunicationsLink;
	    }

	    public WebElement getAllFilesLink() {
	        return allFilesLink;
	    }
	}

