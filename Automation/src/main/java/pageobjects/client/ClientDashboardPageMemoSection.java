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
	 * Class representing Client Dashboard Page Memo Section within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientDashboardPageMemoSection extends AbstractBasePageObject<ClientDashboardPageMemoSection> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientDashboardPageMemoSection.class);

	    private static final String relativeUrl = "/";

	    public ClientDashboardPageMemoSection(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client dashboard memo section page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='memo showAreadblClick']")
	    private WebElement pageContainer;

	    @FindBy(how = How.ID, using = "momo_edit_btn")
	    private WebElement editMemoButton;

	    @FindBy(how = How.ID, using = "memo_input_div")
	    private WebElement memoContainer;

	    @FindBy(how = How.ID, using = "memo_txt")
	    private WebElement memoText;

	    @FindBy(how = How.ID, using = "memo_submit")
	    private WebElement saveMemoButton;

	    @FindBy(how = How.ID, using = "memo_cancel")
	    private WebElement cancelMemoButton;


	    public void inputMemoText(String text) {
	        set_text(memoText, text);
	    }

	    public WebElement getPageContainer() {
	        return pageContainer;
	    }

	    public WebElement getEditMemoButton() {
	        return editMemoButton;
	    }

	    public WebElement getMemoContainer() {
	        return memoContainer;
	    }

	    public WebElement getMemoText() {
	        return memoText;
	    }

	    public WebElement getSaveMemoButton() {
	        return saveMemoButton;
	    }

	    public WebElement getCancelMemoButton() {
	        return cancelMemoButton;
	    }
	}

