Feature: As a user, I want to navigate & analyze everything page of application

  @EverythingPage @Smoke @Regression @P3
  Scenario: As a CRC Admin I should be able to view sequence of activities done by me and my team members under 'Progress' - CRC_487
    Given Admin is on Everything page
    Then verify that on clicking 'Progress' tab, sequence of activities done by me and my team members are shown

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter and view the sequence of activity  - CRC_488
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the sequence of activity

  @EverythingPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view only particular date's activity by clicking on the Date  - CRC_489
    Given Admin is on Everything page
    Then verify that admin should be able to view only particular dates activity by clicking on the Date

  @EverythingPage @P1
  Scenario: As a CRC Admin I should be able to view List of all first work pending clients of my organization  - CRC_490
    Given Admin is on Everything page
    Then verify that admin should be able to view List of all first work pending clients of the organization

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter and view the pending work  - CRC_491
    Given Admin is on Everything page
    Then As a CRC Admin I should be able to filter and view the Pending work

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view List of all tasks added for me and my team member and clients  - CRC_493
    Given Admin is on Everything page
    Then verify that admin should be able to view List of all tasks added for him and his team member and clients

  @EverythingPage @Regression @P1
  Scenario: As a CRC Admin I should be able to filter and view the list of all tasks assigned to me  - CRC_494
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the list of all tasks assigned to him

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter and view the list of all tasks assigned to my team members  - CRC_495
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the list of all tasks assigned to his team members

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter and view the list of all tasks assigned to my clients  - CRC_496
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the list of all tasks assigned to his clients

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view list of all messages sent between team members and clients   - CRC_497_499
    Given Admin is on Everything page
    Then verify that admin should be able to view list of all messages sent between team members and clients

  @EverythingPage @Regression @P1
  Scenario: As a CRC Admin I should be able to filter and view the list of messages between me and team members or clients   - CRC_498
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the list of messages between him and team members or clients

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter and view the conversation of selected team member   - CRC_500
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the conversation of selected team member

  @EverythingPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter and view the conversation of selected affiliate  - CRC_501
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the conversation of selected affiliate

  @EverythingPage @P2
  Scenario: As a CRC Admin I should be able to view list of all Files/Documents of my organisation   - CRC_502
    Given Admin is on Everything page
    Then verify that admin should be able to view the list of all Files/Documents of his organisation

  @EverythingPage @Regression @P1
  Scenario: As a CRC Admin I should be able to filter and view the list of all Files/Documents   - CRC_503
    Given Admin is on Everything page
    Then verify that admin should be able to filter and view the list of all Files/Documents
