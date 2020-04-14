package pageobjects;

    import org.openqa.selenium.*;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.*;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

    import com.vimalselvam.cucumber.listener.Reporter;

    import helper.WaitConditions;

    import java.util.List;
	import java.util.NoSuchElementException;
	import java.util.concurrent.TimeoutException;


	/**
	 * This Class contains common methods which are required through-out the CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	   public abstract class AbstractBasePageObject<T extends AbstractBasePageObject<T>> extends LoadableComponent<T> {

	    private static final Logger logger = LoggerFactory.getLogger(AbstractBasePageObject.class);
	    protected WebDriver webdriver;
	    protected final WebDriverWait wait;
	    private final String url;
	    private String relativeUrl;

	    public AbstractBasePageObject(WebDriver webdriver, WebDriverWait wait, String url) {
	        this.webdriver = webdriver;
	        this.wait = wait;
	        this.url = url;
	        PageFactory.initElements(webdriver, this);
	    }

	    public void navigate_and_wait() {
	        logger.info("Attempting to navigate to: {}",  url + relativeUrl);
	        webdriver.manage().window().maximize();
	        //webdriver.manage().window().setSize(new Dimension(1440, 900));
	        webdriver.navigate().to(url + relativeUrl);
	        wait.until(ExpectedConditions.urlToBe(url + relativeUrl));
	    }

	    public void set_text(WebElement ele, String value) {
	        ele.clear();
	        ele.sendKeys(value);
	    }

	    public void set_text_for_autocomplete(WebElement ele, String value) {
	        ele.clear();
	        ele.sendKeys(value);
	        ele.sendKeys(Keys.ARROW_DOWN);
	    }

	    public void set_text_for_autocomplete_forced(WebElement ele, String value) {
	        ele.clear();
	        ele.sendKeys(value);
	        ele.sendKeys(Keys.ENTER);
	    }
	    public void submit(WebElement ele) {
	        ele.submit();
	    }

	    public void select_dropdown_by_value(WebElement ele, String valueToChoose) {
	        Select s = new Select(ele);
	        wait_for_dropdown(ele);
	        s.selectByVisibleText(valueToChoose);
	    }

	    public void select_dropdown_by_index(WebElement ele, int index) {
	        Select s = new Select(ele);
	        wait_for_dropdown(ele);
	        s.selectByIndex(index);
	    }

	    public int count_options_in_select_dropdown(WebElement ele) {
	        Select s = new Select(ele);
	        wait_for_dropdown(ele);
	        List<WebElement> l = s.getOptions();
	        return l.size();
	    }

	    public boolean is_text_present(String text) {
	        logger.debug("Attempting to find text on the page: {}", text);
	        try {
	            wait_until_true_or_timeout(WaitConditions.pageContainsText(text));
	        } catch (TimeoutException te) {
	            logger.error(te.getMessage() + "\n\nPageSource:\n\n" + getDriver().getPageSource());
	            return false;
	        }
	        return true;
	    }

	    protected boolean isElementPresent(String xpath){
	        return webdriver.findElements(By.xpath(xpath)).size() > 0;
	    }

	    protected WebElement find(By loc) {
	        try {
	            return getDriver().findElement(loc);
	        } catch (NoSuchElementException ex) {
	            throw new NoSuchElementException(ex.getMessage()
	                    + "\n\nPageSource:\n\n" + getDriver().getPageSource());
	        }
	    }

	    protected <V> V wait_until_true_or_timeout(ExpectedCondition<V> isTrue) throws TimeoutException {
	        Wait<WebDriver> wait = new WebDriverWait(this.webdriver, 5)
	                .ignoring(StaleElementReferenceException.class);
	        return wait.until(isTrue);
	    }

	    protected WebDriver getDriver() {
	        return webdriver;
	    }

	    protected void setRelativeUrl(String relativeUrl) {
	        this.relativeUrl = relativeUrl;
	    }

	    protected String getUrl() {
	        return this.url;
	    }

	    private void wait_for_dropdown(WebElement ele) {
	        wait.until(ExpectedConditions.elementToBeClickable(ele));
	    }

	    public void scroll(String x_axis, String y_axis) {
	        JavascriptExecutor js = (JavascriptExecutor) webdriver;
	        // This  will scroll down the page by pixels
	        js.executeScript("window.scrollBy("+x_axis+","+y_axis+")");
	    }

	    public void printMsg(String msg)
	    {
	        Reporter.addStepLog("Step : "+msg);
	    }

	    public void close() {
	        webdriver.close();
	    }

	    public void waitForLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	    }



	}


