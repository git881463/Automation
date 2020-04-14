package steps.everything;

	import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import steps.StepsNavigationHelper;

    import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

import helper.TestAssert;

	/**
	 * Steps for ChangePassword Page.
	 * Look at the feature file for more detail
	 */
	public class StepsChangePasswordPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsChangePasswordPage.class);

	    @When("^the admin clicks on Account link$")
	    public void the_admin_clicks_on_account_link(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton().click();
	    }

	    @And("^click on 'Change Password' link in the dropdown$")
	    public void click_on_change_password_link_in_the_dropdown(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getAccountDropDown().getDropDownContainer()));
	        commonHeaderSection.getCommonHeaderRightNavigationSection().getAccountDropDown().getChangePasswordLink().click();
	        changePasswordPage.isLoaded();
	    }

	    @Then("^admin is navigated to Change Password Page$")
	    public void admin_is_navigated_to_change_password_page(){
	        changePasswordPage.isLoaded();
	    }

	    @Then("^admin provides valid old and new passwords and submits the form$")
	    public void admin_provides_valid_old_and_new_passwords_and_submits_the_form(){
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getPageTitle()));
	        changePasswordPage.inputOldPassword(password);
	        changePasswordPage.inputNewPassword(newPassword);
	        changePasswordPage.inputConfirmPassword(newPassword);
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getSubmitButton()));
	        changePasswordPage.getSubmitButton().click();
	    }

	    @Then("^admin get confirmation for password change success$")
	    public void admin_get_confirmation_for_password_change_success(){
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(changePasswordPage.getFlashMessage().getMessage(), "Password updated successfully");
	    }

	    @Then("^admin provides invalid old and new passwords and submits the form$")
	    public void admin_provides_invalid_old_and_new_passwords_and_submits_the_form(){
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getPageTitle()));
	        changePasswordPage.inputOldPassword(password);
	        changePasswordPage.inputNewPassword(newPassword);
	        changePasswordPage.inputConfirmPassword(newPassword);
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getSubmitButton()));
	        changePasswordPage.getSubmitButton().click();
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getErrorOldPasswordNotMatching()));
	    }

	    @Then("^admin gets an error for invalid password$")
	    public void admin_gets_an_error_for_invalid_password(){
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getErrorOldPasswordNotMatching()));
	    }

	    @Then("^admin provides valid old and new passwords this time and submits the form$")
	    public void admin_provides_valid_old_and_new_passwords_this_time_and_submits_the_form(){
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getPageTitle()));
	        changePasswordPage.inputOldPassword(newPassword);
	        changePasswordPage.inputNewPassword(password);
	        changePasswordPage.inputConfirmPassword(password);
	        wait.until(ExpectedConditions.visibilityOf(changePasswordPage.getSubmitButton()));
	        changePasswordPage.getSubmitButton().click();
	    }


	}

