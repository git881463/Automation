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
	 * Class representing Roles & Permissions page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class RolesAndPermissionsPage extends AbstractBasePageObject<RolesAndPermissionsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(RolesAndPermissionsPage.class);

	    private static final String relativeUrl = "/role_permission";

	    public RolesAndPermissionsPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the roles and permissions page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    private String xpathForTooltip = "//div[@class='joyride-content-wrapper']/h2[contains(text(),'Fill in your team member profile')]//following-sibling::a[3]";

	    @FindBy(how = How.ID, using = "role")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "vrole_name")
	    private WebElement roleName;

	    @FindBy(how = How.ID, using = "btnAddRole")
	    private WebElement addRoleButton;

	    @FindBy(how = How.CLASS_NAME, using = "gridtable")
	    private WebElement roleTable;

	    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Manage Permission')]")
	    private WebElement editPermissionHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='back-btn']/a")
	    private WebElement editBackButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[2]//a[contains(text(),'View Permissions')]")
	    private WebElement viewPermissonLink1;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[3]//a[contains(text(),'View Permissions')]")
	    private WebElement viewPermissonLink2;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//tbody/tr[4]//a[contains(text(),'View Permissions')]")
	    private WebElement viewPermissonLink3;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public void inputRoleName(String text) {
	        set_text(roleName, text);
	    }

	    public WebElement getAddRoleButton() {
	        return addRoleButton;
	    }

	    public WebElement getRoleTable() {
	        return roleTable;
	    }

	    public WebElement getEditPermissionHeader() {
	        return editPermissionHeader;
	    }

	    public WebElement getEditBackButton() {
	        return editBackButton;
	    }

	    public WebElement getViewPermissonLink1() {
	        return viewPermissonLink1;
	    }

	    public WebElement getViewPermissonLink2() {
	        return viewPermissonLink2;
	    }

	    public WebElement getViewPermissonLink3() {
	        return viewPermissonLink3;
	    }
	}

