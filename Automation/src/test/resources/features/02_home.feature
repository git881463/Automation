Feature: As a user, I want to navigate & analyze home page of application
#  //Note: If tests are required to be run in parallel, across the features. then login has to be included as a prerequisite.
#  Scenario: I provide correct credentials and successfully logged in
#    Given I am on the landing page
#    When I enter username
#    And I enter password
#    And I press the login button
#    Then I should be logged in

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to view the shortcuts to common items - CRC_HP_01
    Given Admin is on the home page
    Then verify if the admin is able to view the shortcuts to common items

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to access My accounts, New features, Help & Support pages from Home page - CRC_HP_02
    Given Admin is on the home page
    Then verify if the admin is able to view the common links on top right navigation

  @HomePage @P2
  Scenario: As a CRC Admin I should be able to view complete login activity by clicking on 'Full History' - CRC_HP_03
    Given Admin is on the home page
    Then verify that on clicking 'Full History' link, admin is able to view the complete history

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to view graphical interpretation of Active Clients, Affiliates, Leads and Client Success under 'Business status' - CRC_HP_04
    Given Admin is on the home page
    Then verify if the admin is able to view the contents of Business Status Section

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to navigate to 'Dashboard' by clicking on 'View Dashboard' under 'Business status' - CRC_HP_05
    Given Admin is on the home page
    Then verify that on clicking 'View Dashboard' shortcut, admin navigates to 'Dashboard' page

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to add 'New tasks' under 'My Tasks' - CRC_HP_06
    Given Admin is on the home page
    Then verify that if admin creates a new task for today’s date then the created task should be visible under Today’s schedule

  @HomePage @Regression @P1
  Scenario: As a CRC Admin I should be able to mark the task as completed by clicking on the checkbox - CRC_HP_08
    Given Admin is on the home page
    Then verify that admin can mark the task as completed

  @HomePage @Regression @P1
  Scenario: As a CRC Admin I should be able to mark the task as incomplete by clicking on the checked checkbox - CRC_HP_09
    Given Admin is on the home page
    Then verify that admin can mark the task as incomplete

  @HomePage @Regression @P1
  Scenario: As a CRC Admin I should be able to 'view all tasks' - CRC_HP_10
    Given Admin is on the home page
    Then admin should be able to view all tasks by clicking on 'View All Tasks' link

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to view all the schedules added for the current date - CRC_HP_11
    Given Admin is on the home page
    Then verify that on clicking 'Manage Schedule' shortcut, admin navigates to 'My Schedule' page

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to 'Add a New Client' from Home page shortcut - CRC_HP_12
    Given Admin is on the home page
    Then verify that on clicking 'Add a New Client' shortcut, admin navigates to 'Add Client' page

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to 'Select an existing Client' page to from Home page shortcut - CRC_HP_13
    Given Admin is on the home page
    Then verify that on clicking 'Select an Existing Client' shortcut, admin navigates to 'Search Client' page

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to navigate to a 'Dispute Wizard' page- CRC_HP_14
    Given Admin is on the home page
    When the admin clicks on 'Run Credit Dispute Wizard'
    Then 'Select a client' widget is shown
    Then clicking on a client, I should navigate to dispute wizard

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to access Leads, Messages, My tasks & Events, & Batch Print from Home page- CRC_HP_15
     Given Admin is on the home page
     Then verify if the admin is able to view the common links on top left navigation and access them

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to view badge count displaying the pending batch prints on Batch print icon- CRC_HP_16
    Given Admin is on the home page
    Then verify if the admin is able to view badge count displaying the pending batch prints on Batch print icon

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to view badge count displaying the new message count on Message icon- CRC_HP_17
    Given Admin is on the home page
    Then verify if the admin is able to view badge count displaying the new message count on Message icon

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to view badge count displaying the new lead count on Leads icon- CRC_HP_18
    Given Admin is on the home page
    Then verify if the admin is able to view badge count displaying the new lead count on Leads icon

  @HomePage @P1
  Scenario: As a CRC Admin I should be able view the badge count displaying the pending and upcoming tasks count on Tasks icon- CRC_HP_19
    Given Admin is on the home page
    Then verify if the admin is able to view badge count displaying the task count on task icon

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to navigating to all the pages displayed in 'Help & Support' drop down list- CRC_HP_22
    Given Admin is on the home page
    Then verify if the admin is able to navigate to all the pages displayed in 'Help & Support' drop down list

  @HomePage @P1
  Scenario: As a CRC Admin I should be able to change my account password- CRC_HP_23
    Given Admin is on the home page
    When the admin clicks on Account link
    And  click on 'Change Password' link in the dropdown
    Then admin is navigated to Change Password Page
    Then admin provides valid old and new passwords and submits the form
    Then admin get confirmation for password change success

  @HomePage @Regression @P1
  Scenario: As a CRC Admin I should not be able to use my old password- CRC_HP_24
    Given Admin is on the home page
    When the admin clicks on Account link
    And  click on 'Change Password' link in the dropdown
    Then admin is navigated to Change Password Page
    Then admin provides invalid old and new passwords and submits the form
    Then admin gets an error for invalid password
    Then admin provides valid old and new passwords this time and submits the form
    Then admin get confirmation for password change success

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to 'My Company Profile' page from Home page shortcuts - CRC_HP_26
    Given Admin is on the home page
    Then verify that on clicking 'My Company Profile' shortcut, admin navigates to 'My Company Profile' page

##  @HomePage @Regression @P2
##  Scenario: As a CRC Admin I should be able to navigate to 'Support' page from Home page shortcuts - CRC_HP_27
##    Given Admin is on the home page
##    When  Admin clicks on 'Get Help by Phone' shortcut
##    Then verify if the admin is able to navigate to support center page in a new tab

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to 'My Clients' page from Home page shortcuts - CRC_HP_28
    Given Admin is on the home page
    Then verify that on clicking 'My Clients' shortcut, admin navigates to 'My Clients' page

  @HomePage @P2
  Scenario: As a CRC Admin I should be able to navigate to 'My Contacts' page to add a contact from Home page shortcuts - CRC_HP_30
    Given Admin is on the home page
    Then verify that on clicking 'My Contacts' shortcut, admin navigates to 'My Contacts' page

  @HomePage @P2
  Scenario: As a CRC Admin I should be able to navigate to 'Free Guides and Resources' page to view the complete Guide on CRC from Home page shortcuts - CRC_HP_31
    Given Admin is on the home page
    Then verify that on clicking 'Free Guides and Resources' shortcut, admin navigates to 'Guide' page

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to 'My Sc' page from Home page shortcuts - CRC_HP_32
    Given Admin is on the home page
    Then verify that on clicking 'Schedule' shortcut, admin navigates to 'Schedule' page

  @HomePage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'Quick videos' page to view the complete guide on CRC from Home page shortcuts - CRC_HP_33
    Given Admin is on the home page
    Then verify that on clicking 'Quick video' shortcut, admin navigates to 'Quick Videos' page in new tab


##  @HomePage @P1
##  Scenario: As a CRC Admin I should be able to navigate to 'Client/Affiliate portal' to login to Client/Affiliate account from Home page shortcuts- CRC_HP_34
##    Given Admin is on the home page
##    When  Admin clicks on 'Client/Affiliate portal' shortcut
##    Then verify if the admin is able to navigate to client portal page in new tab
#
##  @HomePage @P2
##  Scenario: As a CRC Admin I should be able to navigate to 'My Business website' page from Home page shortcuts - CRC_HP_35
##    Given Admin is on the home page
##    When  Admin clicks on 'My Business website' shortcut
##    Then verify if the admin is able to navigate to business website page

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to 'My Library' page from Home page shortcuts - CRC_HP_36
    Given Admin is on the home page
    Then verify that on clicking 'My Library' shortcut, admin navigates to 'My Library' page

  @HomePage @P2
  Scenario: As a CRC Admin I should be able to navigate to 'Bonus Material' page from Home page shortcuts - CRC_HP_37
    Given Admin is on the home page
    Then verify that on clicking 'Bonus Material' shortcut, admin navigates to 'Bonus Material' page

  @HomePage @P2
  Scenario: As a CRC Admin I should be able to send a new message by navigating from 'Messages' notification screen - CRC_HP_38
    Given Admin is on the home page
    When  Admin clicks on messages icon in header left section
    And  clicks on 'send a new message' link in the message popup
    Then verify if the admin is able to navigate to send message page

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to 'All Messages' page from 'Messages' notification screen - CRC_HP_39
    Given Admin is on the home page
    When  Admin clicks on messages icon in header left section
    And  clicks on 'see all messages' link in the message popup
    Then verify if the admin is able to navigate to allmessages page

  @HomePage @P2
  Scenario: As a CRC Admin I should be able to view the new message by clicking on the new message from 'Messages' notification screen - CRC_HP_40
    Given Admin is on the home page
    When  Admin clicks on messages icon in header left section
    Then verify if the admin is able to view the new messages

  @HomePage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to 'Batch Print' page from 'Batch Print' notification screen - CRC_HP_41
    Given Admin is on the home page
    When  Admin clicks on batch print icon in header left section
    Then verify if the admin is able to navigate to batch print page

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to access 'http://support.creditrepaircloud.com/' page by clicking on 'Support center' from 'Help & Support' dropdown button - CRC_HP_42
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'Support Center' menu item
    Then verify if the admin is able to navigate to support center page

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to access quick videos by clicking on 'Quick videos' from 'Help & Support' dropdown button - CRC_HP_43
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'Watch Quick Videos' menu item
    Then verify if the admin is able to navigate to quick videos page

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to read startup guides by clicking on 'Read Startup Guides' from 'Help & Support' dropdown button - CRC_HP_44
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'Read Startup Guides' menu item
    Then verify if the admin is able to navigate to read startup guide page

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to access business check lists by clicking on 'Business Checklist' from 'Help & Support' dropdown button - CRC_HP_45
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'Business Checklist' menu item
    Then verify if the admin is able to navigate to business checklist page

  @HomePage @Regression @P3
  Scenario: As a CRC Admin I should be able to access tips and tricks by clicking on 'Tips and tricks' from 'Help & Support' dropdown button - CRC_HP_46
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'Tips and tricks' menu item
    Then verify if the admin is able to navigate to tips and tricks page

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to send new feature request by clicking on 'New Feature Requests' from 'Help & Support' dropdown button - CRC_HP_47
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'New Feature Requests' menu item
    Then verify if the admin is able to view 'New Feature Requests' popup

  @HomePage @Regression @P2
  Scenario: As a CRC Admin I should be able to access professional resources by clicking on 'Resources' from 'Help & Support' dropdown button - CRC_HP_48
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'Resources' menu item
    Then verify if the admin is able to navigate to resources page

  @HomePage @Regression @P1
  Scenario: As a CRC Admin I should be able to claim T-shirt  by clicking on 'Get Free Shirt' from 'Help & Support' dropdown button - CRC_HP_49
    Given Admin is on the home page
    When  Admin clicks on 'Help & Support' link and clicks on 'Get Free Shirt' menu item
    Then verify if the admin is able to navigate to get free shirt page

