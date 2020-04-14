package pageobjects.creditors;

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
	 * Class representing Print Creditors/Furnishers Popup in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class PrintCreditorsFurnishersPopup extends AbstractBasePageObject<PrintCreditorsFurnishersPopup> {

	    private static final Logger logger = LoggerFactory.getLogger(PrintCreditorsFurnishersPopup.class);

	    private static final String relativeUrl = "/";

	    public PrintCreditorsFurnishersPopup(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        //navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the print creditors/furnishers popup: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Print creditors/furnishers')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.XPATH, using = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']//span[contains(text(),'Print creditors/furnishers')]//following-sibling::a")
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

