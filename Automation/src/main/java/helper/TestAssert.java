package helper;

	import org.junit.Assert;
	import org.openqa.selenium.WebElement;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;


	/**
	 * This class contains all the custom assert being used througout the tests.
	 */
	public class TestAssert {

	    private static final Logger logger = LoggerFactory.getLogger(TestAssert.class);

	    public static void verifyElementVisible(WebElement element){
	        Assert.assertTrue(element!= null && element.isDisplayed());
	    }

	    public static void verifyElementContent(WebElement element, String text){
	        //logger.debug("Element Content : {}", element.getText().toLowerCase());
	        //logger.debug("search element  : {}", text.toLowerCase());
	        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
	    }

	    public static void verifyElementContent(WebElement element, String text, Boolean presence){
	        if(presence){
	            verifyElementContent(element, text);
	        }else{
	            Assert.assertFalse(element.getText().toLowerCase().contains(text.toLowerCase()));
	        }
	    }

	    public static void verifyEqual(String value1, String value2){
	        Assert.assertEquals(value1, value2);
	    }

	    public static void verifyNotEqual(String value1, String value2){
	        Assert.assertNotSame(value1, value2);
	    }

	    public static void verifyEqual(Boolean value1, Boolean value2){
	        Assert.assertEquals(value1, value2);
	    }

	    public static void verifyGreater(int value1, int value2){
	        Assert.assertTrue(value1 >value2);
	    }
	}

