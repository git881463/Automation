Feature: As a user, I want to navigate & analyze library page of application

  @LibraryPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view list of all saved letters when I navigate to 'My Library' page - CRC_452
    Given Admin is on Library page
    Then verify that list of saved letters is shown on the page

  @LibraryPage @Regression @P1
  Scenario: As a CRC Admin I should be able to search for a letter by 'Letter title' - CRC_453
    Given Admin is on Library page
    Then verify that admin should be able to search for a letter by 'Letter title'

  @LibraryPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search for a letter by 'Letter category' - CRC_454
    Given Admin is on Library page
    Then verify that admin should be able to search for a letter by 'Letter category'

  @LibraryPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search for a letter by 'Letter status' - CRC_455
    Given Admin is on Library page
    Then verify that admin should be able to search for a letter by 'Letter status'

  @LibraryPage @Regression @P2
  Scenario: As a CRC Admin I should be able to sort the letters - CRC_456
    Given Admin is on Library page
    Then verify that admin should be able to sort the letters

  @LibraryPage @Smoke @P0 @P1
  Scenario: As a CRC Admin I should be able to add new letter - CRC_457_458
    Given Admin is on Library page
    Then verify that new letters can be added

  @LibraryPage @Regression @P1
  Scenario: As a CRC Admin I should be able to edit the existing letter - CRC_459
    Given Admin is on Library page
    Then verify that admin should be able to edit the existing letter

  @LibraryPage @Regression @P2
  Scenario: As a CRC Admin I should be able to mark the existing letter as Favourite - CRC_460
    Given Admin is on Library page
    Then verify that admin should be able to mark the existing letter as Favourite
