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
	 * Class representing Inactive or Delete Team Member Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class InactivateOrDeleteMemberPopup  extends AbstractBasePageObject<InactivateOrDeleteMemberPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(InactivateOrDeleteMemberPopup.class);

	    private static final String relativeUrl = "/";

	    public InactivateOrDeleteMemberPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the inactivate member popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Inactive/Delete team member')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "inactive_team")
	    private WebElement inactiveTeamMemberButton;

	    @FindBy(how = How.ID, using = "delete_team")
	    private WebElement deleteTeamMemberButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getInactiveTeamMemberButton() {
	        return inactiveTeamMemberButton;
	    }

	    public WebElement getDeleteTeamMemberButton() {
	        return deleteTeamMemberButton;
	    }
	}

