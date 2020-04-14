package steps.account;

	import helper.TestAssert;
	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for My Account Page.
	 * Look at the feature file for more detail
	 */
	public class StepsAccountPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsAccountPage.class);

	    @Given("^Admin is on my account page$")
	    public void adminIsOnTheAccountPage() {
	        myAccountPage.get();
	    }

	    @Then("^verify if the admin is able to view the current plan details$")
	    public void verify_if_the_admin_is_able_to_view_the_current_plan_details(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getPageContainer());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageStatusSection().getStatus());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getHeader());
	    }

	    @Then("^verify if the admin is able to change the current plan details$")
	    public void verify_if_the_admin_is_able_to_change_the_current_plan_details() throws InterruptedException{
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink());
	        myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink().click();
	        subscriptionPage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        subscriptionPage.getDuration().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        subscriptionPage.scroll("0", "document.body.scrollHeight");
	        subscriptionPage.getSaveChangesButton().click();

	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getWarningPopup().getWarningMessage()));
	        //TestAssert.verifyElementVisible(subscriptionPage.getWarningPopup().getWarningMessage());
	        subscriptionPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));

	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(subscriptionPage.getFlashMessage().getMessage(), "Changes saved successfully");
	    }

	    @Then("^verify if the admin is able to view all plan details$")
	    public void verify_if_the_admin_is_able_to_view_all_plan_details(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink());
	        myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink().click();
	        subscriptionPage.isLoaded();
	    }

	    @Then("^verify if the admin is able to view plan payment receipts$")
	    public void verify_if_the_admin_is_able_to_plan_payment_receipts(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getPageContainer());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getHeader());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getViewReceiptLink());
	    }

	    @Then("^verify if the admin is able to upgrade or downgrade the plans$")
	    public void verify_if_the_admin_is_able_to_upgrade_or_downgrade_the_plans() throws InterruptedException{
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink());
	        myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink().click();
	        subscriptionPage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        subscriptionPage.getScalePlan().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        subscriptionPage.scroll("0", "document.body.scrollHeight");
	        subscriptionPage.getSaveChangesButton().click();
	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getWarningPopup().getWarningMessage()));
	        //TestAssert.verifyElementVisible(subscriptionPage.getWarningPopup().getWarningMessage());
	        subscriptionPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));

	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(subscriptionPage.getFlashMessage().getMessage(), "Changes saved successfully");

	    }

	    @Then("^verify if the admin is able to buy additional team members$")
	    public void verify_if_the_admin_is_able_to_buy_additional_team_members() throws InterruptedException{
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        subscriptionPage.scroll("0", "0");
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getHeader());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink());
	        myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink().click();
	        subscriptionPage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        subscriptionPage.scroll("0", "document.body.scrollHeight");
	        String costBefore = subscriptionPage.getSubscriptionCosts().getText();
	        subscriptionPage.getAddOnTeamMembersLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
//	        String costAfter = subscriptionPage.getSubscriptionCosts().getText();
//	        TestAssert.verifyNotEqual(costBefore, costAfter);
	        subscriptionPage.getSaveChangesButton().click();
	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getWarningPopup().getWarningMessage()));
	        //TestAssert.verifyElementVisible(subscriptionPage.getWarningPopup().getWarningMessage());
	        subscriptionPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));

	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(subscriptionPage.getFlashMessage().getMessage(), "Changes saved successfully");
	    }

	    @Then("^verify if the admin is able to buy additional client slots$")
	    public void verify_if_the_admin_is_able_to_buy_additional_client_shots() throws InterruptedException{
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink());
	        myAccountPage.getMyAccountPageCurrentPlanDetailsSection().getChangePlanLink().click();
	        subscriptionPage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        subscriptionPage.scroll("0", "document.body.scrollHeight");
	        String costBefore = subscriptionPage.getSubscriptionCosts().getText();
	        subscriptionPage.getAddOnClinetShotsLink().click();
//	        subscriptionPage.getAddOnClinetShotsLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
//	        String costAfter = subscriptionPage.getSubscriptionCosts().getText();
//	        TestAssert.verifyNotEqual(costBefore, costAfter);
	        subscriptionPage.getSaveChangesButton().click();
	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getWarningPopup().getWarningMessage()));
	        //TestAssert.verifyElementVisible(subscriptionPage.getWarningPopup().getWarningMessage());
	        subscriptionPage.getWarningPopup().getOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));

	        wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getFlashMessage().getMessage()));
	        TestAssert.verifyElementContent(subscriptionPage.getFlashMessage().getMessage(), "Changes saved successfully");
	    }

	    @Then("^verify if the admin is able to view team members and client usage$")
	    public void verify_if_the_admin_is_able_to_view_team_members_and_client_usage(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getPageContainer());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getHeader());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getTeamMember());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getClientSlots());
	    }

	    @Then("^verify if the admin is able to change the credit card used for the billing$")
	    public void verify_if_the_admin_is_able_to_change_the_credit_card_used_for_the_billing(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getPageContainer());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getHeader());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getChangeCardLink());
	        myAccountPage.getMyAccountPageUsageSection().getChangeCardLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().getPageContainer()));
	        myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().inputCardNumber("111111111111112");
	        myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().inputCardName("CRCUser");
	        myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().inputCardExpiry("102024");
	        myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().inputCardCvv("654");
	        myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().inputBillingZip("12345");
	        myAccountPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().getUpdateButton()));

	        myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().getUpdateButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().getErrorContainer());
	        myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().closePopup();
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getMyAccountPageUsageSection().getUpdateCreditCardDetailsPopup().getPageContainer()));
	    }

	    @Then("^verify if the admin views the ownership info and transfer link$")
	    public void verify_if_the_admin_views_the_ownership_info_and_transfer_link(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getPageContainer());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getAccountOwnershipHeader());
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getAccountOwnershipTransferLink());
	        myAccountPage.getMyAccountPageUsageSection().getAccountOwnershipTransferLink().click();
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageUsageSection().getAccountOwnershipForm());
	    }

	    @Then("^verify if the admin is able to cancel his account$")
	    public void verify_if_the_admin_is_able_to_cancel_his_account(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        TestAssert.verifyElementVisible(myAccountPage.getCancelAccountLink());
	        myAccountPage.scroll("0", "document.body.scrollHeight");
	        myAccountPage.getCancelAccountLink().click();
	        cancelAccountPage.isLoaded();
	    }

	    @Then("^verify if the admin is able to save auto recharge for additional client shots$")
	    public void verify_if_the_admin_is_able_to_save_auto_recharge_for_additional_client_shots(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        myAccountPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageAutoRechargeSection().getHeader());
	        myAccountPage.getMyAccountPageAutoRechargeSection().inputClientSlots("20");
	        myAccountPage.getMyAccountPageAutoRechargeSection().getSaveButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        myAccountPage.isLoaded();
	    }

	    @Then("^verify if the admin is able to disable auto recharge for additional client shots$")
	    public void verify_if_the_admin_is_able_to_disable_auto_recharge_for_additional_client_shots(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        myAccountPage.scroll("0", "document.body.scrollHeight");
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageAutoRechargeSection().getHeader());
	        if(!myAccountPage.getMyAccountPageAutoRechargeSection().isDisabled()){
	            myAccountPage.getMyAccountPageAutoRechargeSection().getDisableButton().click();
	        }
	        myAccountPage.isLoaded();
	    }

	    @Then("^verify if the admin is able to change master email for billing and support$")
	    public void verify_if_the_admin_is_able_to_change_master_email_for_billing_and_support(){
	        wait.until(ExpectedConditions.visibilityOf(commonHeaderSection.getCommonHeaderRightNavigationSection().getLogoutButton()));
	        myAccountPage.scroll("0", "0");
	        TestAssert.verifyElementVisible(myAccountPage.getMyAccountPageStatusSection().getStatus());
	        TestAssert.verifyElementContent(myAccountPage.getMyAccountPageStatusSection().getStatus(), username);
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        myAccountPage.getMyAccountPageStatusSection().getChangeEmailLink().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getMyAccountPageStatusSection().getChangeEmailOkButton()));
	        myAccountPage.getMyAccountPageStatusSection().getChangeEmailOkButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getMyAccountPageStatusSection().getChangeEmailPopup()));
	        myAccountPage.getMyAccountPageStatusSection().getUpdateEmailButton().click();
	        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getAjaxLoader()));
	        wait.until(ExpectedConditions.invisibilityOf(myAccountPage.getAjaxLoader()));
	        myAccountPage.isLoaded();
	    }
	}

