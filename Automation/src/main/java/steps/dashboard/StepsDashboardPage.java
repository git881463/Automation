package steps.dashboard;

	import steps.StepsNavigationHelper;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Steps for Dashboard Page.
	 * Look at the feature file for more detail
	 */
	public class StepsDashboardPage extends StepsNavigationHelper {

	    private static final Logger logger = LoggerFactory.getLogger(StepsDashboardPage.class);

	    @Given("^Admin is on the dashboard page$")
	    public void adminIsOnTheDashboardPage() {
	        dashboardPage.load();
	    }

	    @Then("^verify that on clicking 'Dashboard' tab, Dashboard page is shown$")
	    public void verify_that_on_clicking_dashboard_tab_dashboard_page_is_shown() throws Exception {
	        commonHeaderSection.getCommonHeaderTabNavigationBar().getDashboardTab().click();
	        dashboardPage.isLoaded();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	    }

	    @Then("^verify that admin should be able to view the percentage of 'New leads, 'Leads converted to Client' and 'Suspended/cancelled clients' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_view_the_leads_and_client_details_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientOverviewSection().getNewLeadsCount()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientOverviewSection().getConvertedToPaidCount()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientOverviewSection().getSuspendedCancelledCount()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the percentage of 'New leads, 'Leads converted to Client' and 'Suspended/cancelled clients' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_preiod_and_view_the_leads_and_client_details_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientOverviewSection().getTimePeriod()));
	        dashboardPage.getDashboardPageClientOverviewSection().selectTimePeriod(3);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientOverviewSection().getNewLeadsCount()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientOverviewSection().getConvertedToPaidCount()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientOverviewSection().getSuspendedCancelledCount()));
	    }

	    @Then("^verify that admin should be able to view the Conversion rate, Churn rate and Avg revenue per client in Dashboard$")
	    public void verify_that_admin_should_be_able_to_view_the_conversion_rate_churn_rate_and_avg_revenue_per_client_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageRateOverviewSection().getConversionRate()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageRateOverviewSection().getChurnRate()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageRateOverviewSection().getAvgRevenuePerClient()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the Conversion rate, Churn rate and Avg revenue per client in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_conversion_rate_churn_rate_and_avg_revenue_per_client_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageRateOverviewSection().getTimePeriod()));
	        dashboardPage.getDashboardPageRateOverviewSection().selectTimePeriod(3);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageRateOverviewSection().getConversionRate()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageRateOverviewSection().getChurnRate()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageRateOverviewSection().getAvgRevenuePerClient()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Sales growth - Revenue' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_sales_growth_revenue_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getTimePeriod()));
	        dashboardPage.getDashboardPageSalesGrowthSection().selectTimePeriod(3);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenuText()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenueChart()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getNewLeadsLink()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getActiveClientsLink()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getAffiliatesLink()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Sales growth - New Leads' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_sales_growth_new_leads_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getTimePeriod()));
	        dashboardPage.getDashboardPageSalesGrowthSection().selectTimePeriod(3);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenueChart()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getNewLeadsLink()));
	        dashboardPage.getDashboardPageSalesGrowthSection().getNewLeadsLink().click();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenueChart()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Sales growth - Active Clients' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_sales_growth_active_clients_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getTimePeriod()));
	        dashboardPage.getDashboardPageSalesGrowthSection().selectTimePeriod(3);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenueChart()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getActiveClientsLink()));
	        dashboardPage.getDashboardPageSalesGrowthSection().getActiveClientsLink().click();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenueChart()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Sales growth - Affiliates' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_sales_growth_affiliates_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getTimePeriod()));
	        dashboardPage.getDashboardPageSalesGrowthSection().selectTimePeriod(3);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenueChart()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getAffiliatesLink()));
	        dashboardPage.getDashboardPageSalesGrowthSection().getAffiliatesLink().click();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageSalesGrowthSection().getRevenueChart()));
	    }

	    @Then("^verify that admin should be able to view the 'Client Stages' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_view_the_client_stages_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientStagesSection().getLifeCycleChart()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientStagesSection().getClientLifeCycle()));
	        dashboardPage.getDashboardPageClientStagesSection().selectClientLifeCycle(3);
	        myClientsPage.getSearchClientPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to view the 'Client Status' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_view_the_client_status_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("2000", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientStatusSection().getStatusChart()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageClientStatusSection().getClientStatus()));
	        dashboardPage.getDashboardPageClientStatusSection().selectClientStatus(3);
	        myClientsPage.getSearchClientPage().isLoaded();
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Top Affiliates referrals' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_top_affiliates_referrals_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTimePeriod()));
	        dashboardPage.getDashboardPageTopAffiliateSection().selectTimePeriod(2);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getReferralsText()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Top Affiliates clients' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_top_affiliates_clients_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getClientsLink()));
	        dashboardPage.getDashboardPageTopAffiliateSection().getClientsLink().click();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTimePeriod()));
	        dashboardPage.getDashboardPageTopAffiliateSection().selectTimePeriod(2);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Top Affiliates revenue' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_top_affiliates_revenue_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getRevenuesLink()));
	        dashboardPage.getDashboardPageTopAffiliateSection().getRevenuesLink().click();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTimePeriod()));
	        dashboardPage.getDashboardPageTopAffiliateSection().selectTimePeriod(2);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopAffiliateSection().getTopAffiliatesPlace()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Top Member Sign-ups' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_top_member_signups_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTimePeriod()));
	        dashboardPage.getDashboardPageTopTeamMembersSection().selectTimePeriod(2);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getSignupText()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Top Member Revenues' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_top_member_revenues_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getRevenuesLink()));
	        dashboardPage.getDashboardPageTopTeamMembersSection().getRevenuesLink().click();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTimePeriod()));
	        dashboardPage.getDashboardPageTopAffiliateSection().selectTimePeriod(2);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	    }

	    @Then("^verify that admin should be able to change the time period and view the 'Top Member Repairs' in Dashboard$")
	    public void verify_that_admin_should_be_able_to_change_the_time_period_and_view_the_top_member_repairs_on_dashboard_page() throws Exception {
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getPageTitle()));
	        dashboardPage.scroll("0", "document.body.scrollHeight");
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getRepairedLink()));
	        dashboardPage.getDashboardPageTopTeamMembersSection().getRepairedLink().click();
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTimePeriod()));
	        dashboardPage.getDashboardPageTopAffiliateSection().selectTimePeriod(2);
	        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageTopTeamMembersSection().getTopTeamPlace()));
	    }
	}
