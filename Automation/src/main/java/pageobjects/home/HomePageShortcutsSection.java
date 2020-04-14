package pageobjects.home;

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
	 * Class representing Home Page Shortcut Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class HomePageShortcutsSection extends AbstractBasePageObject<HomePageShortcutsSection> {

	    private static final Logger logger = LoggerFactory.getLogger(HomePageShortcutsSection.class);

	    private static final String relativeUrl = "/home";

	    public HomePageShortcutsSection(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        //navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the home page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='My Company Profile']")
	    private WebElement myCompanyProfileLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='My Clients']")
	    private WebElement myClientsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()=' My Contacts']")
	    private WebElement myContactsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Schedule']")
	    private WebElement scheduleLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Client and Affiliate Portal']")
	    private WebElement clientsAndAffiliatePortalLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Library of Dispute Letters']")
	    private WebElement libraryOfDisputeLettersLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Get Help By Phone']")
	    private WebElement getHelpByPhoneLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Credit Repair Academy']")
	    private WebElement creditRepairAcadamyLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Free Guides & Resources']")
	    private WebElement freeGuidesAndResourcesLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Quick Videos']")
	    private WebElement quickVideosLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()=' Business Website']")
	    private WebElement businessWebsiteLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chrightbox']//strong[text()='Bonus Materials']")
	    private WebElement bonusMaterialsLink;

	    public WebElement getMyCompanyProfileLink() {
	        return myCompanyProfileLink;
	    }

	    public WebElement getMyClientsLink() {
	        return myClientsLink;
	    }

	    public WebElement getMyContactsLink() {
	        return myContactsLink;
	    }

	    public WebElement getScheduleLink() {
	        return scheduleLink;
	    }

	    public WebElement getClientsAndAffiliatePortalLink() {
	        return clientsAndAffiliatePortalLink;
	    }

	    public WebElement getLibraryOfDisputeLettersLink() {
	        return libraryOfDisputeLettersLink;
	    }

	    public WebElement getGetHelpByPhoneLink() {
	        return getHelpByPhoneLink;
	    }

	    public WebElement getCreditRepairAcadamyLink() {
	        return creditRepairAcadamyLink;
	    }

	    public WebElement getFreeGuidesAndResourcesLink() {
	        return freeGuidesAndResourcesLink;
	    }

	    public WebElement getQuickVideosLink() {
	        return quickVideosLink;
	    }

	    public WebElement getBusinessWebsiteLink() {
	        return businessWebsiteLink;
	    }

	    public WebElement getBonusMaterialsLink() {
	        return bonusMaterialsLink;
	    }
	}
