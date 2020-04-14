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
	 * Class representing Client Affiliate Portal page Details section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPageDetailsSection extends AbstractBasePageObject<ClientAffiliatePortalPageDetailsSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPageDetailsSection.class);

	    private static final String relativeUrl = "/";

	    public ClientAffiliatePortalPageDetailsSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal page details section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "detailscontent")
	    private WebElement detailsContainer;

	    @FindBy(how = How.ID, using = "show_letter")
	    private WebElement showLetterOption;

	    @FindBy(how = How.ID, using = "show_agreement")
	    private WebElement showAgreementOption;

	    @FindBy(how = How.ID, using = "show_dispute_detail")
	    private WebElement showDisputeDetailOption;

	    @FindBy(how = How.ID, using = "show_client_summary")
	    private WebElement showClientSummaryOption;

	    public WebElement getDetailsContainer() {
	        return detailsContainer;
	    }

	    public WebElement getShowLetterOption() {
	        return showLetterOption;
	    }

	    public WebElement getShowAgreementOption() {
	        return showAgreementOption;
	    }

	    public WebElement getShowDisputeDetailOption() {
	        return showDisputeDetailOption;
	    }

	    public WebElement getShowClientSummaryOption() {
	        return showClientSummaryOption;
	    }
	}
