package spring;

	import drivers.ChromeWebDriver;
	import drivers.FirefoxWebDriver;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.test.context.ContextConfiguration;

	/**
	 * Spring Configuration class representing WebDriver and other common platform beans.
	 */
	@Configuration
	@ContextConfiguration(classes={PropertiesContext.class})
	public class SeleniumContext {

		private static final Logger logger = LoggerFactory.getLogger(SeleniumContext.class);

		@Autowired 
		private String webbrowser;

		@Autowired
		private String platform;

		@Bean(name="webdriver", destroyMethod="close")
		public WebDriver getWebDriver() {
			logger.debug("Creating Bean webdriver");
			WebDriver webdriver = null;
			switch (webbrowser) {
				case "firefox":
					webdriver = new FirefoxWebDriver();
					break;
				
				case "chrome":
					System.setProperty("webdriver.chrome.driver", getChromeBinaryPath(platform));
					webdriver = new ChromeWebDriver();
					break;
			}
			return webdriver;
		}
		
		@Bean("wait")
		public WebDriverWait getWebDriverWait() {
			logger.debug("Creating Bean wait");
			return new WebDriverWait(getWebDriver(), 60);
		}


		private String getChromeBinaryPath(String platform){
			String binaryPath =  "src/main/resources/";
			switch (platform) {
				case "windows":
					binaryPath += "chromedriver.exe";
					break;

				case "mac":
					binaryPath += "chromedriver_mac";
					break;

				case "linux":
					binaryPath += "chromedriver_linux";
					break;

				default:
					binaryPath += "chromedriver_linux";

			}
			return binaryPath;
		}

	}


