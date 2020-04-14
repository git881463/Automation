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
	 * Class representing Educate Page Expenses Section Print Preview Popup within Client Tab in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class EducatePageClientExpensesSectionPrintPreviewPopup extends AbstractBasePageObject<EducatePageClientExpensesSectionPrintPreviewPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(EducatePageClientExpensesSectionPrintPreviewPopup.class);

	    private static final String relativeUrl = "/";

	    public EducatePageClientExpensesSectionPrintPreviewPopup(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the educate page expenses section print preview popup: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Print Preview')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Print Preview')]//following-sibling::a")
	    private WebElement closePopupLink;

	    @FindBy(how = How.ID, using = "btnok")
	    private WebElement okButton;

	    @FindBy(how = How.ID, using = "btnprint")
	    private WebElement printButton;

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getClosePopupLink() {
	        return closePopupLink;
	    }

	    public WebElement getOkButton() {
	        return okButton;
	    }

	    public WebElement getPrintButton() {
	        return printButton;
	    }
	}
