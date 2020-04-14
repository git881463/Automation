package spring;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.test.context.ContextConfiguration;

	/**
	 * Spring Configuration Class representing the propertied declared in application.properties.
	 * Make sure to update this class whenever there is any change in application.yml
	 */
	@Configuration
	@ContextConfiguration(classes={AppConfig.class})
	public class PropertiesContext {

		private static final Logger logger = LoggerFactory.getLogger(PropertiesContext.class);

		@Value("${selenium.screenshotOnFailure}")
		private String screenshotOnFailure;

		@Value("${selenium.screenshotDestinationFolder}")
		private String screenshotDestinationFolder;
		
		@Value("${selenium.webbrowser}")
		private String webbrowser;

		@Value("${browser.platform}")
		private String platform;

		@Value("${environment.baseurl}")
		private String baseurl;

		@Value("${environment.username}")
		private String username;

		@Value("${environment.password}")
		private String password;

		@Value("${environment.newPassword}")
		private String newPassword;

		@Value("${environment.loggedinUser}")
		private String loggedinUser;

		@Bean("screenshotOnFailure")
		public boolean takeScreenshotOnFailure() {
			logger.debug("Creating Bean screenshotOnFailure");
			return Boolean.parseBoolean(screenshotOnFailure);
		}

		@Bean("screenshotDestinationFolder")
		public String getScreenshotDestinationFolder() {
			logger.debug("Creating Bean screenshotDestinationFolder");
			return screenshotDestinationFolder;
		}

		@Bean("webbrowser")
		public String getWebbrowser() {
			logger.debug("Creating Bean webbrowser");
			return webbrowser;
		}

		@Bean("platform")
		public String getPlatform() {
			logger.debug("Creating Bean platform");
			return platform;
		}

		@Bean("baseurl")
		public String getBaseurl() {
			logger.debug("Creating Bean baseurl");
			return baseurl;
		}

		@Bean("username")
		public String getUsername() {
			logger.debug("Creating Bean username");
			return username;
		}

		@Bean("password")
		public String getPassword() {
			logger.debug("Creating Bean password");
			return password;
		}

		@Bean("newPassword")
		public String getNewPassword() {
			logger.debug("Creating Bean newPassword");
			return newPassword;
		}

		@Bean("loggedinUser")
		public String getLoggedinUser() {
			logger.debug("Creating Bean loggedinUser");
			return loggedinUser;
		}
	}

