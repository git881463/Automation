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
	 * Class representing Client Affiliate Portal page Resources section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientAffiliatePortalPageResourcesSection extends AbstractBasePageObject<ClientAffiliatePortalPageResourcesSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientAffiliatePortalPageDetailsSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private ClientResourcesPage clientResourcesPage;

	    public ClientAffiliatePortalPageResourcesSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client/affiliate portal page resources section: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "resourcescontent")
	    private WebElement resourcesContainer;

	    @FindBy(how = How.ID, using = "show-r-page")
	    private WebElement showResourcesRadio;

	    @FindBy(how = How.ID, using = "hide-r-page")
	    private WebElement hideResourcesRadio;

	    @FindBy(how = How.XPATH, using = "//div[@id='resourcescontent']//a[contains(text(),'Modify Resources')]")
	    private WebElement modifyResourcesLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='resourcescontent']//a[contains(text(),'Reset to default')]")
	    private WebElement resetResourcesToDefaultLink;

	    public ClientResourcesPage getClientResourcesPage() {
	        return clientResourcesPage;
	    }

	    public WebElement getResourcesContainer() {
	        return resourcesContainer;
	    }

	    public WebElement getShowResourcesRadio() {
	        return showResourcesRadio;
	    }

	    public WebElement getHideResourcesRadio() {
	        return hideResourcesRadio;
	    }

	    public WebElement getModifyResourcesLink() {
	        return modifyResourcesLink;
	    }

	    public WebElement getResetResourcesToDefaultLink() {
	        return resetResourcesToDefaultLink;
	    }

	    public boolean isResourcePageHidden(){
	        return hideResourcesRadio.isSelected();
	    }

	}
