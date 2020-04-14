Feature: As a user, I want to navigate & analyze landing page of application

  Scenario: I want to evaluate the landing page of this application
    Given I am on the landing page
    Then I should see page container
    And I should see login section
    And I should see advert section

  Scenario: I want to verify the login section on the landing page
    Given I am on the landing page
    Then I should see login section title
    And I should see login form
    And I should see login form title
    And I should see login form username input
    And I should see login form password input
    And I should see login form signin button
    And I should see login form forgot password link

  @LandingPage @Regression @P1
  Scenario: As an existing CRC Admin I should not be able to login with incorrect password - CRC-008
    Given I am on the landing page
    When I enter username
    And I enter incorrect password
    And I press the login button
    Then I should not be logged in and should see error message instead

  @LandingPage @Smoke @Regression @functional @P0 @P1 @P2 @P3 @PX
  Scenario: As an existing CRC Admin I should be able to login with valid credentials - CRC-007 - CRC-010
    Given I am on the landing page
    When I enter username
    And I enter password
    And I press the login button
    Then I should be logged in

