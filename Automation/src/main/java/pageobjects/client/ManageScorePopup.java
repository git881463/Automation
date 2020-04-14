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
	 * Class representing Manage Score Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ManageScorePopup extends AbstractBasePageObject<ManageScorePopup> {

	    private static final Logger logger = LoggerFactory.getLogger(ManageScorePopup.class);

	    private static final String relativeUrl = "/";

	    public ManageScorePopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the manage score popup page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Manage Scores')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Manage Scores')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//input[@id='scoreDateAdd']")
	    private WebElement scoreDate;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//input[@id='scoreAdd_1']")
	    private WebElement scoreEquifax;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//input[@id='scoreAdd_2']")
	    private WebElement scoreExperian;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//input[@id='scoreAdd_3']")
	    private WebElement scoreTransunion;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//input[@id='add_score_save']")
	    private WebElement addScoreButton;

	    private String xpathForExistingScore = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='gridDataScore']//tr[3]";

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='gridDataScore']//tr[3]")
	    private WebElement addedScore;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='gridDataScore']//tr[3]/td[5]/a[3]")
	    private WebElement editScoreLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='gridDataScore']//tr[3]/td[2]/input")
	    private WebElement editScoreEquifax;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='gridDataScore']//tr[3]/td[3]/input")
	    private WebElement editScoreExperian;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='gridDataScore']//tr[3]/td[4]/input")
	    private WebElement editScoreTransunion;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//div[@id='gridDataScore']//tr[3]/td[5]/a[1]")
	    private WebElement saveScoreButton;

	    public boolean isScorePresent(){
	        return isElementPresent(xpathForExistingScore);
	    }

	    public WebElement getScoreDate() {
	        return scoreDate;
	    }

	    public void inputScoreDate(String text) {
	        set_text(scoreDate, text);
	    }

	    public void inputEquifaxScore(String text) {
	        set_text(scoreEquifax, text);
	    }

	    public void inputExperianScore(String text) {
	        set_text(scoreExperian, text);
	    }

	    public void inputTransunionScore(String text) {
	        set_text(scoreTransunion, text);
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getAddScoreButton() {
	        return addScoreButton;
	    }

	    public WebElement getAddedScore() {
	        return addedScore;
	    }

	    public WebElement getEditScoreLink() {
	        return editScoreLink;
	    }

	    public void inputNewEquifaxScore(String text) {
	        set_text(editScoreEquifax, text);
	    }

	    public void inputNewExperianScore(String text) {
	        set_text(editScoreExperian, text);
	    }

	    public void inputNewTransunionScore(String text) {
	        set_text(editScoreTransunion, text);
	    }

	    public WebElement getSaveScoreButton() {
	        return saveScoreButton;
	    }
	}

