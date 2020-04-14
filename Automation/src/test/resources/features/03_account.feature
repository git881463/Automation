Feature: As a user, I want to navigate & analyze my account page of application

  @MyAccountPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view current plan details - CRC_051
    Given Admin is on my account page
    Then verify if the admin is able to view the current plan details

  @MyAccountPage @Regression @P1
  Scenario: As a CRC Admin I should be able to change the current plan details - CRC_053
    Given Admin is on my account page
    Then verify if the admin is able to change the current plan details

  @MyAccountPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view all plan details - CRC_054
    Given Admin is on my account page
    Then verify if the admin is able to view all plan details

  @MyAccountPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the plan payment receipts - CRC_055
    Given Admin is on my account page
    Then verify if the admin is able to view plan payment receipts

  @MyAccountPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to upgrade or downgrade the plans - CRC_057
    Given Admin is on my account page
    Then verify if the admin is able to upgrade or downgrade the plans

  @MyAccountPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view the team member and client usage - CRC_059
    Given Admin is on my account page
    Then verify if the admin is able to view team members and client usage

  @MyAccountPage @Regression @P1
  Scenario: As a CRC Admin I should be able to change the credit card used for the billing - CRC_060
    Given Admin is on my account page
    Then verify if the admin is able to change the credit card used for the billing

  @MyAccountPage @P1
  Scenario: As a CRC Admin I should be able to buy additional team members - CRC_061
    Given Admin is on my account page
    Then verify if the admin is able to buy additional team members

  @MyAccountPage @P1
  Scenario: As a CRC Admin I should be able to buy additional client slots - CRC_062
    Given Admin is on my account page
    Then verify if the admin is able to buy additional client slots

  @MyAccountPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view the text 'You are the account owner' is displayed and user can transfer the account ownership to other member - CRC_063
    Given Admin is on my account page
    Then verify if the admin views the ownership info and transfer link

  @MyAccountPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to cancel my account - CRC_064
    Given Admin is on my account page
    Then verify if the admin is able to cancel his account

  @MyAccountPage @Regression @P1
  Scenario: As a CRC Admin I should be able to save the 'Auto Recharge for Additional Client Slots' by clicking 'Save'- CRC_065
    Given Admin is on my account page
    Then verify if the admin is able to save auto recharge for additional client shots

  @MyAccountPage @Regression @P1
  Scenario: As a CRC Admin I should be able to disable 'Auto Recharge for Additional Client Slots' by clicking 'Disable'- CRC_066
    Given Admin is on my account page
    Then verify if the admin is able to disable auto recharge for additional client shots

  @MyAccountPage @P1
  Scenario: As a CRC Admin I should be able to change my master email for billing and support- CRC_067
    Given Admin is on my account page
    Then verify if the admin is able to change master email for billing and support
