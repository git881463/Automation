package steps.library;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Library Page.
	 * Look at the feature file for more detail
	 */
	public class StepsLibraryPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsLibraryPage.class);


	    @Given("^Admin is on Library page$")
	    public void adminIsOnLibraryPage() {
	        libraryPage.load();
	    }

	    @Then("^verify that list of saved letters is shown on the page$")
	    public void verify_that_list_of_affiliates_is_shown_on_the_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getLettersList()));
	    }

	    @Then("^verify that admin should be able to search for a letter by 'Letter title'$")
	    public void verify_that_admin_should_be_able_to_search_for_a_letter_by_letter_title() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getLettersList()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchTitle()));
	        libraryPage.inputSearchTitle("Basic Dispute for Creditor or Furnisher");
	        libraryPage.getSearchButton().click();
	        Thread.sleep(5000);//As there is no ajax indicator, that's the only option
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchResult()));
	    }

	    @Then("^verify that admin should be able to search for a letter by 'Letter category'$")
	    public void verify_that_admin_should_be_able_to_search_for_a_letter_by_letter_category() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getLettersList()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchCategory()));
	        libraryPage.selectSearchCategory("Default");
	        libraryPage.getSearchButton().click();
	        Thread.sleep(5000);//As there is no ajax indicator, that's the only option
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchResult()));
	    }

	    @Then("^verify that admin should be able to search for a letter by 'Letter status'$")
	    public void verify_that_admin_should_be_able_to_search_for_a_letter_by_letter_status() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getLettersList()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getQuickFilter()));
	        libraryPage.selectQuickFilter("Active");
	        libraryPage.getSearchButton().click();
	        Thread.sleep(5000);//As there is no ajax indicator, that's the only option
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchResult()));
	    }

	    @Then("^verify that admin should be able to sort the letters$")
	    public void verify_that_admin_should_be_able_to_sort_the_letters() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getLettersList()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSortLettersButton()));
	        libraryPage.getSortLettersButton().click();
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSortDoneButton()));
	        libraryPage.shuffleLetters();
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSortDoneButton()));
	        libraryPage.getSortDoneButton().click();
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(libraryPage.getFlashMessage().getMessage(), "Your new order has been saved");
	        wait.until(ExpectedConditions.invisibilityOf(libraryPage.getFlashMessage().getMessage()));
	    }

	    @Then("^verify that new letters can be added$")
	    public void verify_that_new_letters_can_be_added() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getAddNewLettersButton()));
	        libraryPage.getAddNewLettersButton().click();
	        libraryPage.getAddNewLettersPage().isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getAddNewLettersPage().getPageTitle()));

	        //Add Letter
	        long currentTimeInMillis = System.currentTimeMillis();
	        libraryPage.getAddNewLettersPage().selectCategory("Default");
	        libraryPage.getAddNewLettersPage().inputTitle("Title" + currentTimeInMillis);
	        webdriver.switchTo().frame("letter_txt_ifr");//switching the frame by ID
	        libraryPage.getAddNewLettersPage().inputDetails("Sample Letter");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        libraryPage.scroll("0", "document.body.scrollHeight");
	        libraryPage.getAddNewLettersPage().getSaveLetterButton().click();
//	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getFlashMessage().getMessage()));
//	        TestAssert.verifyElementContent(libraryPage.getFlashMessage().getMessage(), "Letter added successfully");
//	        wait.until(ExpectedConditions.invisibilityOf(libraryPage.getFlashMessage().getMessage()));

	        wait.until(ExpectedConditions.urlContains("/mediacenter"));
	        libraryPage.isLoaded();

	        //Cleanup letter
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchTitle()));
	        libraryPage.inputSearchTitle("Title" + currentTimeInMillis);
	        libraryPage.selectSearchCategory("Default");
	        libraryPage.getSearchButton().click();
	        Thread.sleep(10000);//As there is no ajax indicator, that's the only option
	        libraryPage.scroll("2000", "0");
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getDeleteItemLink()));
	        libraryPage.getDeleteItemLink().click();

	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getWarningPopup().getWarningMessage()));
	        libraryPage.getWarningPopup().getOkButton().click();

	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(libraryPage.getFlashMessage().getMessage(), "Letter deleted successfully");
	        wait.until(ExpectedConditions.invisibilityOf(libraryPage.getFlashMessage().getMessage()));

	    }

	    @Then("^verify that admin should be able to edit the existing letter$")
	    public void verify_that_admin_should_be_able_to_edit_the_existing_letter() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getLettersList()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchTitle()));
	        libraryPage.inputSearchTitle("Basic Dispute for Creditor or Furnisher");
	        libraryPage.getSearchButton().click();
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getSearchResult()));
	        libraryPage.getSearchResult().click();
	        libraryPage.getEditLetterPage().isLoaded();
	        webdriver.switchTo().frame("letter_txt_ifr");//switching the frame by ID
	        libraryPage.getEditLetterPage().inputDetails("Sample Letter");
	        webdriver.switchTo().defaultContent();//Move out of iframe
	        libraryPage.scroll("0", "document.body.scrollHeight");
	        libraryPage.getEditLetterPage().getSaveLetterButton().click();
	        wait.until(ExpectedConditions.urlContains("/mediacenter"));
	        libraryPage.isLoaded();
	    }

	    @Then("^verify that admin should be able to mark the existing letter as Favourite$")
	    public void verify_that_admin_should_be_able_to_mark_the_existing_letter_as_favourite() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getLettersList()));
	        libraryPage.scroll("2000", "0");
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getFavoriteItemLink()));
	        libraryPage.getFavoriteItemLink().click();
	        wait.until(ExpectedConditions.visibilityOf(libraryPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(libraryPage.getFlashMessage().getMessage(), "as Favorite.");
	        wait.until(ExpectedConditions.invisibilityOf(libraryPage.getFlashMessage().getMessage()));
	    }
	}
