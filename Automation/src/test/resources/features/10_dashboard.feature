Feature: As a user, I want to navigate & analyze dashboard page of application

  @DashboardPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to access 'Dashboard' by clicking on 'Dashboard' tab in navigation bar - CRC_504
  Given Admin is on the home page
  Then verify that on clicking 'Dashboard' tab, Dashboard page is shown

  @DashboardPage @P0
  Scenario: As a CRC Admin I should be able to view the percentage of 'New leads, 'Leads converted to Client' and 'Suspended/cancelled clients in Dashboard - CRC_505
    Given Admin is on the dashboard page
    Then verify that admin should be able to view the percentage of 'New leads, 'Leads converted to Client' and 'Suspended/cancelled clients' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the percentage of 'New leads, 'Leads converted to Client' and 'Suspended/cancelled clients - CRC_506
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the percentage of 'New leads, 'Leads converted to Client' and 'Suspended/cancelled clients' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view the Conversion rate, Churn rate and Avg revenue per client in Dashboard - CRC_507
    Given Admin is on the dashboard page
    Then verify that admin should be able to view the Conversion rate, Churn rate and Avg revenue per client in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the Conversion rate, Churn rate and Avg revenue per client in Dashboard - CRC_508
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the Conversion rate, Churn rate and Avg revenue per client in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Sales growth - Revenue' - CRC_509
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Sales growth - Revenue' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Sales growth - New leads' - CRC_510
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Sales growth - New Leads' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Sales growth - Active Clients' - CRC_511
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Sales growth - Active Clients' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Sales growth - Affiliates' - CRC_512
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Sales growth - Affiliates' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view the 'Client Stages' - CRC_513
    Given Admin is on the dashboard page
    Then verify that admin should be able to view the 'Client Stages' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view the 'Client Status' - CRC_514
    Given Admin is on the dashboard page
    Then verify that admin should be able to view the 'Client Status' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Top Affiliates referrals' - CRC_515
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Top Affiliates referrals' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Top Affiliates clients' - CRC_516
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Top Affiliates clients' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Top Affiliates revenue' - CRC_517
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Top Affiliates revenue' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Top Member Sign-ups' - CRC_518
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Top Member Sign-ups' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Top Member Revenue' - CRC_519
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Top Member Revenues' in Dashboard

  @DashboardPage @Regression @P2
  Scenario: As a CRC Admin I should be able to change the time period and view the 'Top Member Repairs' - CRC_520
    Given Admin is on the dashboard page
    Then verify that admin should be able to change the time period and view the 'Top Member Repairs' in Dashboard
