package pageobjects.company;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.util.List;

	/**
	 * Class representing Client Status Types page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class ClientStatusTypesPage extends AbstractBasePageObject<ClientStatusTypesPage> {

	    private static final Logger logger = LoggerFactory.getLogger(ClientStatusTypesPage.class);

	    private static final String relativeUrl = "/";

	    public ClientStatusTypesPage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the client status types page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.ID, using = "vstatus_name")
	    private WebElement status;

	    @FindBy(how = How.ID, using = "btnAddStatus")
	    private WebElement addStatusButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='top-div'][2]//tbody/tr[2]")
	    private WebElement statusTable;


	    public void inputStatus(String text) {
	        set_text(status, text);
	    }

	    public WebElement getAddStatusButton() {
	        return addStatusButton;
	    }

	    public WebElement getStatusTable() {
	        return statusTable;
	    }

	    public WebElement findDeleteLinkOfMatchingStatus(String status){
	        List<WebElement> rows =  webdriver.findElements(By.xpath("//div[@class='top-div'][2]//tbody//tr"));//Find all rows first

	        int matchingIndex = 0;

	        for(int i=0;i<rows.size();i++){
	            if(rows.get(i).getText().toLowerCase().contains(status.toLowerCase())){
	                matchingIndex = i;
	                break;
	            }
	        }
	        if(matchingIndex<2)
	            return null;

	        matchingIndex+=1; //Since there is already a row of type client.

	        List<WebElement> links =  webdriver.findElements(By.xpath("//div[@class='top-div'][2]//tbody//tr[" + matchingIndex +"]/td[5]/a[2]"));//Find all rows first

	        if(links.size()>0){
	            return links.get(0);
	        }
	        return null;
	    }

	}


