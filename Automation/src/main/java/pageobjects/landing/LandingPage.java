package pageobjects.landing;

	import pageobjects.AbstractBasePageObject;
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
	 * Class representing Landing Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 *
	 * Please note that Landing page should not use the common components (header,footer) from AbstractBasePageObject becuase
	 * landing page does not have those components
	 */
	public class LandingPage extends AbstractBasePageObject<LandingPage> {

		private static final Logger logger = LoggerFactory.getLogger(LandingPage.class);

		private static final String relativeUrl = "/";

		@Autowired
		private LandingPageLoginSection loginPanelSection;

		public LandingPage(WebDriver driver, WebDriverWait wait, String url) {
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
		protected void isLoaded() throws Error {
			String url = getDriver().getCurrentUrl();
			Assert.assertTrue("Not on the landing page: " + url, url.endsWith("creditrepaircloud.com/"));
			logger.warn(getClass().getSimpleName() + " was loaded successfully");
		}

		@FindBy(how = How.CLASS_NAME, using="new-login")
		private WebElement pageContainer;

		@FindBy(how = How.CLASS_NAME, using="new-login-left-box")
		private WebElement loginSection;

		@FindBy(how = How.CLASS_NAME, using="frame-src")
		private WebElement advertSection;

		@FindBy(how = How.XPATH, using="//div[@class='top-logo-box']//span[text()='Team Member Login']")
		private WebElement loginHeaderTitle;

		public WebElement getPageContainer() {
			return pageContainer;
		}

		public WebElement getLoginSection() {
			return loginSection;
		}

		public WebElement getAdvertSection() {
			return advertSection;
		}

		public WebElement getLoginHeaderTitle() {
			return loginHeaderTitle;
		}

		public LandingPageLoginSection getLoginPanelSection() {
			return loginPanelSection;
		}
	}

