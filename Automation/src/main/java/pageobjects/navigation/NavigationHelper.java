package pageobjects.navigation;

	import pageobjects.header.CommonHeaderSection;
    import pageobjects.home.HomePage;
    import pageobjects.schedule.SchedulePage;

    import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	public class NavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(NavigationHelper.class);

	    @Autowired
	    protected WebDriverWait wait;

	    @Autowired
	    private CommonHeaderSection commonHeaderSection;

	    @Autowired
	    private HomePage homePage;

	    @Autowired
	    private SchedulePage schedulePage;

	    public void clickHomeTab(){
	        commonHeaderSection.getCommonHeaderTabNavigationBar().getHomeTab().click();
	        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageContainer()));
	    }


	}

