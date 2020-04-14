package pageobjects.header;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pageobjects.AbstractBasePageObject;
	/**
	 * Class representing Common Header shared across the CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class CommonHeaderSection extends AbstractBasePageObject<CommonHeaderSection> {

	    private static final Logger logger = LoggerFactory.getLogger(CommonHeaderSection.class);

	    private static final String relativeUrl = "/";

	    @Autowired
	    private CommonHeaderTabNavigationBar commonHeaderTabNavigationBar;

	    @Autowired
	    private CommonHeaderLeftNavigationSection commonHeaderLeftNavigationSection;

	    @Autowired
	    private CommonHeaderRightNavigationSection commonHeaderRightNavigationSection;

	    public CommonHeaderSection(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
//	        navigate_and_wait();
	    }

	    @Override
	    protected void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the common header page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    public CommonHeaderTabNavigationBar getCommonHeaderTabNavigationBar() {
	        return commonHeaderTabNavigationBar;
	    }

	    public CommonHeaderLeftNavigationSection getCommonHeaderLeftNavigationSection() {
	        return commonHeaderLeftNavigationSection;
	    }

	    public CommonHeaderRightNavigationSection getCommonHeaderRightNavigationSection() {
	        return commonHeaderRightNavigationSection;
	    }

	}


