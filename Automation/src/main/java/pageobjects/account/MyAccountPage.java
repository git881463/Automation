package pageobjects.account;

import pageobjects.AbstractBasePageObject;
import pageobjects.popup.FlashMessage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class representing My Account Page in CRC application.
 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
 */
public class MyAccountPage extends AbstractBasePageObject<MyAccountPage> {

    private static final Logger logger = LoggerFactory.getLogger(MyAccountPage.class);

    private static final String relativeUrl = "/myaccount";

    @Autowired
    private MyAccountPageStatusSection myAccountPageStatusSection;

    @Autowired
    private MyAccountPageCurrentPlanDetailsSection myAccountPageCurrentPlanDetailsSection;

    @Autowired
    private MyAccountPageUsageSection myAccountPageUsageSection;

    @Autowired
    private MyAccountPageAutoRechargeSection myAccountPageAutoRechargeSection;

    @Autowired
    private FlashMessage flashMessage;

    public MyAccountPage(WebDriver driver, WebDriverWait wait, String url) {
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
        Assert.assertTrue("Not on the my account page: " + url, url.endsWith(relativeUrl));
        logger.warn(getClass().getSimpleName() + " was loaded successfully");
    }

    @FindBy(how = How.CLASS_NAME, using = "contentbg")
    private WebElement pageContainer;

    @FindBy(how = How.ID, using = "ajax_loader_new")
    private WebElement ajaxLoader;

    @FindBy(how = How.ID, using = "cancel_account_popup")
    private WebElement cancelAccountLink;

    public MyAccountPageStatusSection getMyAccountPageStatusSection() {
        return myAccountPageStatusSection;
    }

    public MyAccountPageCurrentPlanDetailsSection getMyAccountPageCurrentPlanDetailsSection() {
        return myAccountPageCurrentPlanDetailsSection;
    }

    public MyAccountPageUsageSection getMyAccountPageUsageSection() {
        return myAccountPageUsageSection;
    }

    public MyAccountPageAutoRechargeSection getMyAccountPageAutoRechargeSection() {
        return myAccountPageAutoRechargeSection;
    }

    public FlashMessage getFlashMessage() {
        return flashMessage;
    }

    public WebElement getPageContainer() {
        return pageContainer;
    }

    public WebElement getAjaxLoader() {
        return ajaxLoader;
    }

    public WebElement getCancelAccountLink() {
        return cancelAccountLink;
    }
}