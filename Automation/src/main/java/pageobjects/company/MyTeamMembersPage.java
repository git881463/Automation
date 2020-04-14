package pageobjects.company;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing My Team Members page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MyTeamMembersPage extends AbstractBasePageObject<MyTeamMembersPage> {

	    private static final Logger logger = LoggerFactory.getLogger(MyTeamMembersPage.class);

	    private static final String relativeUrl = "/team";

	    @Autowired
	    private AddTeamMemberPage addTeamMemberPage;

	    @Autowired
	    private InactivateOrDeleteMemberPopup inactivateOrDeleteMemberPopup;

	    @Autowired
	    private RemoveExtraUserAddonPopup removeExtraUserAddonPopup;

	    public MyTeamMembersPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the my team members page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    private String xpathForTooltip = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Fill in your team member profile')]//following-sibling::a[3]";
	    //private String xpathForDisableChat = "//a[contains(text(),'Disable team chat now')]";

	    @FindBy(how = How.XPATH, using = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Fill in your team member profile')]//following-sibling::a[3]")
	    private WebElement closeTooltipLink;

	    @FindBy(how = How.XPATH, using = "//a[contains(text(),'team chat now')]")
	    private WebElement chatButton;

//	    @FindBy(how = How.ID, using = "enable_chat")
//	    private WebElement enableChatButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='add_member']/a")
	    private WebElement addNewTeamMemberButton;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']")
	    private WebElement teamMembersListContainer;

	    @FindBy(how = How.XPATH, using = "//div[@id='gridData']//div[@id='access2']/a")
	    private WebElement newlyAddedMemberDeleteLink;

	    public AddTeamMemberPage getAddTeamMemberPage() {
	        return addTeamMemberPage;
	    }

	    public InactivateOrDeleteMemberPopup getInactivateOrDeleteMemberPopup() {
	        return inactivateOrDeleteMemberPopup;
	    }

	    public RemoveExtraUserAddonPopup getRemoveExtraUserAddonPopup() {
	        return removeExtraUserAddonPopup;
	    }

	    public boolean isTooltipShown(){
	        return isElementPresent(xpathForTooltip);
	    }
//	    public boolean isChatDisabled(){
//	        return isElementPresent(xpathForDisableChat);
//	    }

	    public WebElement getCloseTooltipLink() {
	        return closeTooltipLink;
	    }

	    public WebElement getAddNewTeamMemberButton() {
	        return addNewTeamMemberButton;
	    }

	    public WebElement getNewlyAddedMemberDeleteLink() {
	        return newlyAddedMemberDeleteLink;
	    }

	    public WebElement getTeamMembersListContainer() {
	        return teamMembersListContainer;
	    }

	    public void deleteNewlyAddedTeamMember() throws  Exception{
	        Thread.sleep(5000);
	        WebElement menu = webdriver.findElement(By.xpath("//div[@id='gridData']/div/div[2]"));
	        Actions act = new Actions(webdriver);
	        act.moveToElement(menu).perform();
	        Actions actions = new Actions(webdriver);
//	        actions.moveToElement(menu).clickAndHold();
	        WebElement subMenu = webdriver.findElement(By.xpath("//div[@id='gridData']//div[@id='access2']/a"));
	        actions.moveToElement(subMenu);
	        actions.click().build().perform();
	    }

	    public WebElement getChatButton() {
	        return chatButton;
	    }
	}
