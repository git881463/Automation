package pageobjects.library;

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
	 * Class representing Add New Letters Page within Library Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EditLetterPage extends AbstractBasePageObject<EditLetterPage> {

	    private static final Logger logger = LoggerFactory.getLogger(EditLetterPage.class);

	    private static final String relativeUrl = "/edit";

	    public EditLetterPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the library page edit letter page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Edit Letters')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "category")
	    private WebElement category;

	    @FindBy(how = How.ID, using = "lname")
	    private WebElement title;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement letterEditor;

	    @FindBy(how = How.XPATH, using = "//form[@id='mylibrary']//input[@id='submit2']")
	    private WebElement saveLetterButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public void selectCategory(String text){
	        select_dropdown_by_value(category, text);
	    }

	    public void inputTitle(String text) {
	        set_text(title, text);
	    }

	    public void inputDetails(String text) {
	        set_text(letterEditor, text);
	    }

	    public WebElement getSaveLetterButton() {
	        return saveLetterButton;
	    }
	}

