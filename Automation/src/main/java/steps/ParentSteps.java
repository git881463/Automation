package steps;

	import spring.AppConfig;
	import spring.PageObjectsContext;
	import spring.PropertiesContext;
	import spring.SeleniumContext;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;

    import io.cucumber.java.Scenario;

    import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	/**
	 * Class exposing all the available spring beans in the application context.
	 */
	@ContextConfiguration(classes={SeleniumContext.class, PropertiesContext.class, PageObjectsContext.class, AppConfig.class})
	public class ParentSteps {

		private static final Logger logger = LoggerFactory.getLogger(ParentSteps.class);

		protected Scenario scenario;

		@Autowired
		protected WebDriver webdriver;
		
		@Autowired
		protected WebDriverWait wait;

		@Autowired
		protected boolean screenshotOnFailure;
		
		@Autowired
		protected String screenshotDestinationFolder;

		@Autowired
		protected String baseurl;

		@Autowired
		protected String username;

		@Autowired
		protected String password;

		@Autowired
		protected String newPassword;

		@Autowired
		protected String loggedinUser;

		public void beforeScenario(Scenario scenario){
			this.scenario = scenario;
		}

		public void afterScenario(Scenario scenario) throws IOException {
			if (scenario.isFailed()) {
				if (screenshotOnFailure) {
					Date now = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmss");
					String timestamp = sdf.format(now);

					File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
					File destFile = new File(screenshotDestinationFolder
							+ timestamp + "_"
							+ scenario.getName().replaceAll(" ", "_") + ".png");
					FileUtils.moveFile(srcFile, destFile);
					logger.info("Screenshot taken: " + destFile.getAbsolutePath());
				}
			}
		}
	}
