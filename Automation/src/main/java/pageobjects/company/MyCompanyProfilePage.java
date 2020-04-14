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
	 * Class representing My Company Profile page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class MyCompanyProfilePage extends AbstractBasePageObject<MyCompanyProfilePage> {

	    private static final Logger logger = LoggerFactory.getLogger(MyCompanyProfilePage.class);

	    private static final String relativeUrl = "/";

	    public MyCompanyProfilePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the my company profile page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@id='vtab']//h4[contains(text(),'My Company Profile')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "vediopopup")
	    private WebElement quickVideoLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chbox normaltext1 ']//a[contains(text(),'My Account')]")
	    private WebElement myAccountLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='chbox normaltext1 ']//a[contains(text(),'Show guided tour')]")
	    private WebElement guidedTourLink;

	    @FindBy(how = How.ID, using = "company_url")
	    private WebElement websiteUrl;

	    @FindBy(how = How.ID, using = "company_url_anchor")
	    private WebElement checkUrlLink;

	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getQuickVideoLink() {
	        return quickVideoLink;
	    }

	    public WebElement getMyAccountLink() {
	        return myAccountLink;
	    }

	    public WebElement getGuidedTourLink() {
	        return guidedTourLink;
	    }

	    public WebElement getWebsiteUrl() {
	        return websiteUrl;
	    }

	    public void inputWebsiteUrl(String text) {
	        set_text(websiteUrl, text);
	    }


	    public WebElement getCheckUrlLink() {
	        return checkUrlLink;
	    }

	    public WebElement getVideoPopup() {
	        return videoPopup;
	    }

	    public WebElement getVideoPopupCloseButton() {
	        return videoPopupCloseButton;
	    }
	}

