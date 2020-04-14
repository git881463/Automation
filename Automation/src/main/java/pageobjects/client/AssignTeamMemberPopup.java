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

	/**
	 * Class representing Assign Team Member Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AssignTeamMemberPopup extends AbstractBasePageObject<AssignTeamMemberPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(AssignTeamMemberPopup.class);

	    private static final String relativeUrl = "/";

	    public AssignTeamMemberPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the assign team member popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-contact_assign_place']")
	    private WebElement pageContainer;

	    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-contact_assign_place']//span[@id='ui-dialog-title-contact_assign_place']")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-contact_assign_place']//a[@class='ui-dialog-titlebar-close ui-corner-all']")
	    private WebElement closePopupLink;

	    @FindBy(how = How.XPATH, using = "//div[@id='contact_assign_form']//select[@id='team_member']")
	    private WebElement assignableTeamMembers;

	    @FindBy(how = How.XPATH, using = "//div[@id='contact_assign_form']//input[@id='assign_to_this']")
	    private WebElement assignButton;


	    @FindBy(how = How.XPATH, using = "//div[@id='list_assigned_contact']//tr[1]/td[2]/a")
	    private WebElement removeAssignedTeamMemberLink;


//	    @FindBy(how = How.XPATH, using = "//div[@id='list_assigned_contact']//td[contains(text(),'No Team Member Assigned.')]")
//	    private WebElement noTeamMemberAssignedLabel;

	    private String xpathForNoTeamMemberAssignedLabel = "//div[@id='list_assigned_contact']//td[contains(text(),'No Team Member Assigned.')]";


	    public boolean isMemberAvailableToBeAssigned(){
	        int optionCount = count_options_in_select_dropdown(assignableTeamMembers);
	        return optionCount > 1; // Option with value 'Select' is not counted
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getAssignableTeamMembers() {
	        return assignableTeamMembers;
	    }

	    public WebElement getAssignButton() {
	        return assignButton;
	    }

	    public boolean isNoTeamMemberAssigned(){
	        return isElementPresent(xpathForNoTeamMemberAssignedLabel);
	    }

	    public void selectAssignableTeamMemberByIndex(int index){
	        select_dropdown_by_index(assignableTeamMembers, index);
	    }

	    public WebElement getRemoveAssignedTeamMemberLink() {
	        return removeAssignedTeamMemberLink;
	    }

	    //    public WebElement getNoTeamMemberAssignedLabel() {
//	        return noTeamMemberAssignedLabel;
//	    }
	}
