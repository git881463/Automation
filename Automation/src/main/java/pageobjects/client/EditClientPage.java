package pageobjects.client;

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
	 * Class representing Edit Client Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditClientPage extends AbstractBasePageObject<EditClientPage> {

	    private static final Logger logger = LoggerFactory.getLogger(EditClientPage.class);

	    private static final String relativeUrl = "/userdesk/profile";

	    @Autowired
	    private AssignTeamMemberPopup assignTeamMemberPopup;

	    public EditClientPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the edit client page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "mname")
	    private WebElement middleName;

	    @FindBy(how = How.ID, using = "status")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "sub_button")
	    private WebElement submitButton;

	    @FindBy(how = How.XPATH, using = "//form[@id='addclient']//a[contains(text(),'Click to assign team member')]")
	    private WebElement assignTeamMemberLink;

	    @FindBy(how = How.ID, using = "on")
	    private WebElement portalAccessOnRadio;

	    @FindBy(how = How.ID, using = "off")
	    private WebElement portalAccessOffRadio;

	    @FindBy(how = How.ID, using = "agreement")
	    private WebElement agreement;

	    @FindBy(how = How.XPATH, using = "//tr[@id='PnlPortalAccess']//a[contains(text(),'Resend login details')]")
	    private WebElement resentLoginDetailsLink;

	    public AssignTeamMemberPopup getAssignTeamMemberPopup() {
	        return assignTeamMemberPopup;
	    }

	    public WebElement getMiddleName() {
	        return middleName;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }

	    public void inputMiddleName(String text) {
	        set_text(middleName, text);
	    }

	    public WebElement getAssignTeamMemberLink() {
	        return assignTeamMemberLink;
	    }

	    public WebElement getPortalAccessOnRadio() {
	        return portalAccessOnRadio;
	    }

	    public WebElement getPortalAccessOffRadio() {
	        return portalAccessOffRadio;
	    }

	    public WebElement getAgreement() {
	        return agreement;
	    }

	    public void selectStatus(String text){
	        select_dropdown_by_value(status, text);
	    }
	    public void selectNoAgreement(){
	        select_dropdown_by_value(agreement, "No Agreement");
	    }

	    public WebElement getResentLoginDetailsLink() {
	        return resentLoginDetailsLink;
	    }
	}
