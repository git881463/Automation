Feature: As a user, I want to navigate & analyze affiliates page of application

  @AffiliatesPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view the list of my affiliates when I navigate to 'My Affiliate' page - CRC_462
    Given Admin is on Affiliates page
    Then verify that list of affiliates is shown on the page

  @AffiliatesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search for an affiliate by 'Affiliate name' - CRC_463
    Given Admin is on Affiliates page
    Then verify that admin should be able to search for an affiliate by 'Affiliate Name'

  @AffiliatesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search for an affiliate by 'Company' - CRC_464
    Given Admin is on Affiliates page
    Then verify that admin should be able to search for an affiliate by 'Company'

  @AffiliatesPage @Regression @P1
  Scenario: As a CRC Admin I should be able to search for an affiliate by 'Affiliate Email' - CRC_465
    Given Admin is on Affiliates page
    Then verify that admin should be able to search for an affiliate by 'Affiliate Email'

  @AffiliatesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search for an affiliate by 'Status' - CRC_466
    Given Admin is on Affiliates page
    Then verify that admin should be able to search for an affiliate by 'Status'

  @AffiliatesPage @P2
  Scenario: As a CRC Admin I should be able to add new affiliate without portal access - CRC_467
    Given Admin is on Affiliates page
    Then verify that new affiliate can be added without portal access

  @AffiliatesPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add new affiliate with portal access and the affiliate should receive an email with login details to his/her email id - CRC_469
    Given Admin is on Affiliates page
    Then verify that new affiliate can be added with portal access

  @AffiliatesPage @Regression @P1
  Scenario: As a CRC Admin I should be able to import affiliate details CSV file - CRC_471
    Given Admin is on Affiliates page
    Then verify that admin should be able to import affiliate details CSV file

  @AffiliatesPage @Regression @P1
  Scenario: As a CRC Admin I should be able to export affiliate details CSV file - CRC_472
    Given Admin is on Affiliates page
    Then verify that admin should be able to export affiliate details CSV file

  @AffiliatesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to print affiliate list - CRC_473
    Given Admin is on Affiliates page
    Then verify that admin should be able to print affiliate list

  @AffiliatesPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'Edit Affiliate Profile' page upon clicking 'Affiliate name' - CRC_474
    Given Admin is on Affiliates page
    Then verify that admin should be able to navigate to 'Edit Affiliate Profile' page upon clicking 'Affiliate name'

  @AffiliatesPage @Regression @P1
  Scenario: As a CRC Admin I should be able to edit affiliate profile - CRC_475
    Given Admin is on Affiliates page
    Then verify that admin should be able to edit affiliate profile

  @AffiliatesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view affiliates client referral stats - CRC_476
    Given Admin is on Affiliates page
    Then verify that admin should be able to view affiliates client referral stats