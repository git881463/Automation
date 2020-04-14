Feature: As a user, I want to navigate & analyze creditors/furnishers page of application

  @CreditorsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view the list of Creditors/Furnishers when I navigate to 'Creditors/Furnishers' page - CRC_478
    Given Admin is on Creditors/Furnishers page
    Then verify that list of Creditors/Furnishers is shown on the page

  @CreditorsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search Creditors/Furnishers by their name - CRC_479
    Given Admin is on Creditors/Furnishers page
    Then verify that admin should be able to search Creditors/Furnishers by their name

  @CreditorsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add new Creditors/Furnishers - CRC_480
    Given Admin is on Creditors/Furnishers page
    Then verify that admin is able to add new Creditors/Furnishers

  @CreditorsPage @P2
  Scenario: As a CRC Admin I should be able to view Creditor/Furnisher detail by clicking on the name - CRC_482
    Given Admin is on Creditors/Furnishers page
    Then verify that admin should be able to view Creditor/Furnisher detail by clicking on the name

  @CreditorsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to filter the Creditor/Furnisher list by clicking on the alphabet - CRC_483
    Given Admin is on Creditors/Furnishers page
    Then verify that admin should be able to filter the Creditor/Furnisher list by clicking on the alphabet

  @CreditorsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to import Creditor/Furnisher details CSV file - CRC_484
    Given Admin is on Creditors/Furnishers page
    Then verify that admin should be able to import Creditor/Furnisher details CSV file

  @CreditorsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to export Creditor/Furnisher details CSV file - CRC_485
    Given Admin is on Creditors/Furnishers page
    Then verify that admin should be able to export Creditor/Furnisher details CSV file

  @CreditorsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to print Creditor/Furnisher list - CRC_486
    Given Admin is on Creditors/Furnishers page
    Then verify that admin should be able to print Creditor/Furnisher list
