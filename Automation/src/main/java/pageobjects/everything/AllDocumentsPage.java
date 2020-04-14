package pageobjects.everything;

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
	 * Class representing All Documents Page in Everything tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AllDocumentsPage extends AbstractBasePageObject<AllDocumentsPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AllDocumentsPage.class);

	    private static final String relativeUrl = "/alldocuments";

	    public AllDocumentsPage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    public void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the everything all documents page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "teamdropdown")
	    private WebElement teamDropDown;

	    @FindBy(how = How.ID, using = "filter_loader")
	    private WebElement ajaxFilterLoader;

	    @FindBy(how = How.ID, using = "cd-timeline")
	    private WebElement timeLine;

	    @FindBy(how = How.ID, using = "datacontainer")
	    private WebElement datacontainer;

	    public WebElement getTeamDropDown() {
	        return teamDropDown;
	    }
	    public void selectTeamFilter(String text){
	        select_dropdown_by_value(teamDropDown, text);
	    }

	    public WebElement getAjaxFilterLoader() {
	        return ajaxFilterLoader;
	    }

	    public WebElement getTimeLine() {
	        return timeLine;
	    }

	    public WebElement getDatacontainer() {
	        return datacontainer;
	    }
	}

