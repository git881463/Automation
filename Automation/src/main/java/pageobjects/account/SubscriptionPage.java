package pageobjects.account;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.popup.FlashMessage;
	import pageobjects.popup.WarningPopup;
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
	 * Class representing SubscriptionPage Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SubscriptionPage extends AbstractBasePageObject<SubscriptionPage> {

	    private static final Logger logger = LoggerFactory.getLogger(SubscriptionPage.class);

	    private static final String relativeUrl = "/myplan";

	    @Autowired
	    private WarningPopup warningPopup;

	    @Autowired
	    private FlashMessage flashMessage;

	    public SubscriptionPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the subscriptionPage page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "plan_information")
	    private WebElement planInformation;

	    @FindBy(how = How.ID, using = "monthly_div")
	    private WebElement monthlyOption;

	    @FindBy(how = How.XPATH, using = "//div[@class='maincont']//div[@class='switch']")
	    private WebElement duration;

	    @FindBy(how = How.XPATH, using = "//div[@for='plan9']//div[@class='column-four']")
	    private WebElement scalePlan;

	    @FindBy(how = How.XPATH, using = "//div[@id='plan_information']//div[@class='table-plan addoncont ']//div[@class='row-table'][1]//a[1]")
	    private WebElement addOnTeamMembersLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='plan_information']//div[@class='table-plan addoncont ']//div[@class='row-table'][2]//a[1]")
	    private WebElement addOnClinetShotsLink;

	    @FindBy(how = How.ID, using = "subscription_costs")
	    private WebElement subscriptionCosts;

	    @FindBy(how = How.ID, using = "savechanges")
	    private WebElement saveChangesButton;

	    public WarningPopup getWarningPopup() {
	        return warningPopup;
	    }

	    public FlashMessage getFlashMessage() {
	        return flashMessage;
	    }

	    public WebElement getPlanInformation() {
	        return planInformation;
	    }

	    public WebElement getMonthlyOption() {
	        return monthlyOption;
	    }

	    public WebElement getScalePlan() {
	        return scalePlan;
	    }

	    public WebElement getDuration() {
	        return duration;
	    }

	    public WebElement getAddOnTeamMembersLink() {
	        return addOnTeamMembersLink;
	    }

	    public WebElement getAddOnClinetShotsLink() {
	        return addOnClinetShotsLink;
	    }

	    public WebElement getSubscriptionCosts() {
	        return subscriptionCosts;
	    }

	    public WebElement getSaveChangesButton() {
	        return saveChangesButton;
	    }
	}
