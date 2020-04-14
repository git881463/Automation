    package pageobjects.account;

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
	 * Class representing My Account Page Usage Section in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	    public class MyAccountPageUsageSection extends AbstractBasePageObject<MyAccountPageUsageSection> {

	    private static final Logger logger = LoggerFactory.getLogger(MyAccountPageUsageSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private UpdateCreditCardDetailsPopup updateCreditCardDetailsPopup;

	    public MyAccountPageUsageSection(WebDriver driver, WebDriverWait wait, String url) {
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
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the my account usage page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//h3[contains(text(),'Usage & Add-ons')]")
	    private WebElement header;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//a[contains(text(),'Manage Add-ons')]")
	    private WebElement manageAddOnsLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//tbody/tr[2]/td[1]")
	    private WebElement teamMember;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//tbody/tr[3]/td[1]")
	    private WebElement clientSlots;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//a[contains(text(),'Change card')]")
	    private WebElement changeCardLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//h3[contains(text(),'You are the account owner')]")
	    private WebElement accountOwnershipHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='chleftbox ']//a[contains(text(),'Transfer account ownership to another team member')]")
	    private WebElement accountOwnershipTransferLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='newAdmindiv normaltext1']")
	    private WebElement accountOwnershipForm;

	    public UpdateCreditCardDetailsPopup getUpdateCreditCardDetailsPopup() {
	        return updateCreditCardDetailsPopup;
	    }

	    public WebElement getHeader() {
	        return header;
	    }

	    public WebElement getManageAddOnsLink() {
	        return manageAddOnsLink;
	    }

	    public WebElement getTeamMember() {
	        return teamMember;
	    }

	    public WebElement getClientSlots() {
	        return clientSlots;
	    }

	    public WebElement getChangeCardLink() {
	        return changeCardLink;
	    }

	    public WebElement getAccountOwnershipHeader() {
	        return accountOwnershipHeader;
	    }

	    public WebElement getAccountOwnershipTransferLink() {
	        return accountOwnershipTransferLink;
	    }

	    public WebElement getAccountOwnershipForm() {
	        return accountOwnershipForm;
	    }
	}

