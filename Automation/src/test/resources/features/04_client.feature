Feature: As a user, I want to navigate & analyze my clients page of application

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view the list of clients/leads as I navigate to 'My clients' page - CRC_070
    Given Admin is on my clients search page
    Then verify if the admin is able to view the clients list

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to add new client with portal access and the client gets an email with login details - CRC_071
    Given Admin is on my clients search page
    Then verify if the admin is able to add a new client with portal access

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to add new client without portal access and the client does not get an email with login details - CRC_072
    Given Admin is on my clients search page
    Then verify if the admin is able to add a new client without portal access

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to watch the video about adding a new client - CRC_073
    Given Admin is on my clients search page
    Then verify if the admin is able to watch the video about adding a new client

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to search his/her client by name - CRC_076
    Given Admin is on my clients search page
    Then verify if the admin is able to search the client by name

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search his/her client by email - CRC_077
    Given Admin is on my clients search page
    Then verify if the admin is able to search the client by email

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search by client start date under 'Advanced search' - CRC_078
    Given Admin is on my clients search page
    Then verify if the admin is able to search by client start date

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search by client added date range under 'Advanced search' - CRC_079
    Given Admin is on my clients search page
    Then verify if the admin is able to search by client added date

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search by client status under 'Advanced search' - CRC_080
    Given Admin is on my clients search page
    Then verify if the admin is able to search by client status

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search by client phone number under 'Advanced search' - CRC_081
    Given Admin is on my clients search page
    Then verify if the admin is able to search by client phone number

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search by referred by team member name under  'Advanced search' - CRC_082
    Given Admin is on my clients search page
    Then verify if the admin is able to search by client referrer

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search by assigned team member name under  'Advanced search' - CRC_083
    Given Admin is on my clients search page
    Then verify if the admin is able to search by assigned team member

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to use the 'Sample client' to learn the system - CRC_084
    Given Admin is on my clients search page
    Then verify if the admin is able to access Sample Client

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to filter the client list by different status - CRC_085
    Given Admin is on my clients search page
    Then verify if the admin is able to apply quick filter on status

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to watch the video about searching and filtering the clients faster - CRC_086
    Given Admin is on my clients search page
    Then verify if the admin is able to watch quick video about searching and filtering the clients faster

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to import CSV file to add new clients - CRC_087
    Given Admin is on my clients search page
    Then verify if the admin is able to import CSV file to add new clients
    Then remove the newly imported client so that next time import does not fail

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to export CSV file - CRC_088
    Given Admin is on my clients search page
    Then verify if the admin is able to export CSV file

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to print the client list - CRC_089
    Given Admin is on my clients search page
    Then verify if the admin is able to print client list

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to add internal note to each clients/leads - CRC_090
    Given Admin is on my clients search page
    Then verify if the admin is able to add notes to client

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to edit each client/lead by clicking on 'Edit' icon - CRC_092
    Given Admin is on my clients search page
    Then verify if the admin is able to edit client

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to delete a client - CRC_093
    Given Admin is on my clients search page
    Then verify if the admin is able to delete a client

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to sort the client names by alphabetical order - CRC_095
    Given Admin is on my clients search page
    Then verify if the admin is able to sort client names alphabetically

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to sort the client list by 'referred by' name - CRC_096
    Given Admin is on my clients search page
    Then verify if the admin is able to sort by referred by name

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to sort the client list by 'Added date' - CRC_097
    Given Admin is on my clients search page
    Then verify if the admin is able to sort by added date

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to sort the client list by 'Start date' - CRC_098
    Given Admin is on my clients search page
    Then verify if the admin is able to sort by start date

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to sort the client list by 'Status' - CRC_099
    Given Admin is on my clients search page
    Then verify if the admin is able to sort by status

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view the clients with status 'Lead' in green color - CRC_100
    Given Admin is on my clients search page
    Then verify that newly added client with status 'Lead' is shown with green background in the list

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view the clients with status 'Suspended' in pink color - CRC_101
    Given Admin is on my clients search page
    Then verify that newly added client with status 'Suspended' is shown with pink background in the list

  @MyClientsPage @P3
  Scenario: As a CRC Admin I should be able to view the clients with status 'Prospect' in blue color - CRC_102
    Given Admin is on my clients search page
    Then verify that newly added client with status 'Prospect' is shown with blue background in the list

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to navigate to client's Dashboard by clicking on client's name - CRC_104
    Given Admin is on my clients search page
    Then verify that on clicking clients name in list, dashboard is shown

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to Client's profile page to edit Client details by clicking on 'Edit' button in Client list page - CRC_105
    Given Admin is on my clients search page
    Then verify that on clicking 'edit client' link, profile page is shown

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to unassign and assign a team member for the selected client - CRC_106_107
    Given Admin is on my clients search page
    Then verify that on edit profile page, a team member can be unassigned and assigned

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to give portal access to my client - CRC_108
    Given Admin is on my clients search page
    Then verify that on edit profile page, portal access can be given

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to revoke the client portal access - CRC_109
    Given Admin is on my clients search page
    Then verify that on edit profile page, portal access can be revoked

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to resend my clients login details - CRC_111
    Given Admin is on my clients search page
    Then verify that on edit profile page, login details can be resend

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to change the status of selected 'Lead' to Prospect/Client/ Inactive/ suspended or Lead/Inactive - CRC_112
    Given Admin is on my clients search page
    Then verify that on edit profile page, status of selected 'Lead' can be changed

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to client's dashboard by clicking on client's name from 'My clients' page - CRC_113
    Given Admin is on my clients search page
    Then verify that on clicking client name, dashboard page is shown

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to upload the client document from client Dashboard - CRC_114_115
    Given Admin is on my clients search page
    Then verify that client document can be uploaded from client dashboard

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to customize the document list - CRC_116
    Given Admin is on my clients search page
    Then verify that document list can be customized on client dashboard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view the pending team task on client Dashboard - CRC_117
    Given Admin is on my clients search page
    Then verify that pending team tasks are visible on client dashboard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view the pending client task on client Dashboard - CRC_118
    Given Admin is on my clients search page
    Then verify that pending client tasks are visible on client dashboard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view the completed team task on client Dashboard - CRC_119
    Given Admin is on my clients search page
    Then verify that completed team tasks can be viewed on client dashboard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view the completed client task on client Dashboard - CRC_120
    Given Admin is on my clients search page
    Then verify that completed client tasks can be viewed on client dashboard

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to add and remove task to the team on client Dashboard - CRC_121_124
    Given Admin is on my clients search page
    Then verify that new team task can be added and then removed on client dashboard

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to add and remove task to the client on client Dashboard - CRC_122_123
    Given Admin is on my clients search page
    Then verify that new client task can be added and then removed on client dashboard

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to mark the task added to the team as complete on client Dashboard - CRC_125
    Given Admin is on my clients search page
    Then verify that new team task can be marked as complete on client dashboard

#  @MyClientsPage @P2
#  Scenario: As a CRC Admin I should be able to mark the task added to the client as complete on client Dashboard - CRC_126
#    Given Admin is on my clients search page
#    Then verify that new client task can be marked as complete on client dashboard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add memo on client Dashboard - CRC_127
    Given Admin is on my clients search page
    Then verify that a memo can be added on client dashboard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the team member assigned to the client on client dashboard - CRC_128
    Given Admin is on my clients search page
    Then verify that team member assigned to client is specified on client dashboard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view clients credit score from Equifax, Experian, TransUnion - CRC_129
    Given Admin is on my clients search page
    Then verify that scores are visible on client dashboard

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to add clients credit score from Equifax, Experian, TransUnion - CRC_130
    Given Admin is on my clients search page
    Then verify that scores can be added on client dashboard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to edit clients credit score from Equifax, Experian, TransUnion - CRC_131_132
    Given Admin is on my clients search page
    Then verify that scores can be edited on client dashboard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the number of dispute items under each bureaus on Client Dashboard - CRC_133
    Given Admin is on my clients search page
    Then verify that disputed items are visible on client dashboard

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to navigate to to 'All Dispute items' tab from client Dashboard shortcut - CRC_134
    Given Admin is on my clients search page
    Then verify that on clicking 'All dispute items' button on client dashboard, dispute detail page is shown

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to navigate to to 'Import/Audit' tab from client Dashboard shortcut - CRC_135
    Given Admin is on my clients search page
    Then verify that on clicking 'Import Online Credit Reports' button on client dashboard, import audit page is shown

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view the graphical representation of 'Dispute status' of each bureaus - CRC_136
    Given Admin is on my clients search page
    Then verify that graphical representation of dispute status of each bureau can be shown on client dashboard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view clients document by clicking 'Document Storage' from Client dashboard - CRC_137
    Given Admin is on my clients search page
    Then verify that on clicking 'Document Storage' link on client dashboard, document storage popop is shown

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to add client's document by clicking 'Document Storage ' from Client dashboard - CRC_138
    Given Admin is on my clients search page
    Then verify that client documents can be added via document storage popup

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view the list of saved letters from Client's Dashboard shortcut - CRC_139
    Given Admin is on my clients search page
    Then verify that on clicking 'Clients Saved Letters' link on client dashboard, saved letters page is shown

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view Total Invoiced, Received, Outstanding, Past Due invoice details on Clients dashboard - CRC_140
    Given Admin is on my clients search page
    Then verify that invoice details are shown on client dashboard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to create new invoice to the client through client dashboard shortcut - CRC_141
    Given Admin is on my clients search page
    Then verify that new invoice can be created on client dashboard

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view all invoices from client dashboard shortcut - CRC_142
    Given Admin is on my clients search page
    Then verify that all invoices can be viewed on client dashboard

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view client's payment from client dashboard shortcut - CRC_143
    Given Admin is on my clients search page
    Then verify that clients payments can be viewed on client dashboard

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to add billing related tasks to the team from Client Dashboard shortcut - CRC_144
    Given Admin is on my clients search page
    Then verify that billing related tasks can be added on client dashboard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view client's 'Chargebee Transaction History' from client dashboard shortcut - CRC_145
    Given Admin is on my clients search page
    Then verify that 'Chargebee Transaction History' can be viewed on client dashboard


#  @MyClientsPage @Smoke @Regression @P0
#  Scenario: As a CRC Admin I should be able to import credit report with 1-click - CRC_150
#    Given Admin is on my clients search page
#    Then verify that credit report can be imported with 1-click in Import Audit Tab


  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view Step 1 upon clicking 'Step 1' in 'Dispute Wizard' page - CRC_176
    Given Admin is on my clients search page
    Then verify that 'Step1' page can be viewed by clicking on 'Step1' link in Dispute Wizard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view 'Credit Report Overview' upon clicking 'Order credit History Report' - CRC_177
    Given Admin is on my clients search page
    Then verify that 'Credit Report Overview' overlay is shown when clicking on 'Order credit History Report' in Dispute Wizard

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to view the quick video on Method 1 to Order credit history report - CRC_178
    Given Admin is on my clients search page
    Then verify that quick video can be viewed by Method 1 quick video shortcut in Dispute Wizard

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to view the quick video on Method 2 to Order credit history report - CRC_179
    Given Admin is on my clients search page
    Then verify that quick video can be viewed by Method 2 quick video shortcut in Dispute Wizard

  @MyClientsPage @Regression @P3
  Scenario: As a CRC Admin I should be able to view 9 report providers list  - CRC_180
    Given Admin is on my clients search page
    Then verify that report providers list can be viewed in Dispute Wizard

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view the 'Sample report' by clicking the link displayed on 'Credit Report Overview' popup  - CRC_181
    Given Admin is on my clients search page
    Then verify that sample report can be viewed in Dispute Wizard

  @MyClientsPage @Regression @P3
  Scenario: As a CRC Admin I should be able to navigate to 'Import/Audit' tab upon clicking 'import online credit reports' link in 'Dispute wizard' screen  - CRC_184
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'Import/Audit' tab upon clicking 'import online credit reports' link in 'Dispute wizard' screen

  @MyClientsPage @Regression @P3
  Scenario: As a CRC Admin I should be able to 'Order Free annual reports by mail'  - CRC_185
    Given Admin is on my clients search page
    Then verify that admin can order free annual reports by mail in 'Dispute wizard' screen

#  @MyClientsPage @Regression @P1
#  Scenario: As a CRC Admin I should be able to 'Order Free annual reports Online'  - CRC_186
#    Given Admin is on my clients search page
#    Then verify that admin can order free annual reports online in 'Dispute wizard' screen

  @MyClientsPage @Regression @P3
  Scenario: As a CRC Admin I should be able to 'Request Credit Reports by mail'  - CRC_187
    Given Admin is on my clients search page
    Then verify that admin can request credit reports by mail in 'Dispute wizard' screen

#  @MyClientsPage @Regression @P1
#  Scenario: As a CRC Admin I should be able to 'Order Credit report from my favourite provider'  - CRC_188
#    Given Admin is on my clients search page
#    Then verify that admin can order credit report from favourite provider

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to change my 'Favourite credit report provider'  - CRC_189
    Given Admin is on my clients search page
    Then verify that admin can change favourite provider

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'Import/Audit' tap upon clicking the link 'Click here for details'  - CRC_190
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'Import/Audit' tab upon clicking 'Click here for details'

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to navigate to 'Import/Audit' tap upon clicking the link 'import online credit reports' displayed on under 'Tips'  - CRC_191
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'Import/Audit' tab upon clicking 'import online credit reports' displayed on under 'Tips'

#  @MyClientsPage @Regression @PX
#  Scenario:  As a CRC Admin I should be able to navigate to 'https://www.privacyguard.com/' upon clicking the link 'Privacy guard' displayed on under 'Tips'  - CRC_192
#    Given Admin is on my clients search page
#    Then verify that admin can navigate to 'https://www.privacyguard.com/' upon clicking the link 'Privacy guard' displayed on under 'Tips'

  @MyClientsPage @Regression @P2
  Scenario:  As a CRC Admin I should be able to navigate to 'Import/Audit' tap upon clicking the link 'Importing credit reports' displayed on under 'Tips' - CRC_193
    Given Admin is on my clients search page
    Then verify that admin should be able to navigate to 'Import/Audit' tap upon clicking the link 'Importing credit reports' displayed on under 'Tips' in Dispute Wizard

  @MyClientsPage @Regression @P2
  Scenario:   As a CRC Admin I should be able to navigate to 'Dashboard' page upon clicking the link 'Sample client' displayed on under 'Tips' - CRC_194
    Given Admin is on my clients search page
    Then verify that admin should be able to navigate to 'Dashboard' page upon clicking the link 'Sample client' displayed on under 'Tips' in Dispute Wizard

  @MyClientsPage @Regression @P2
  Scenario:   As a CRC Admin I should be able to navigate to 'Sample Report' page upon clicking the link 'Sample report' displayed on under 'Tips' - CRC_195
    Given Admin is on my clients search page
    Then verify that admin should be able to navigate to 'Sample Report' page upon clicking the link 'Sample report' displayed on under 'Tips' in Dispute Wizard

  @MyClientsPage @Smoke @P1
  Scenario: As a CRC Admin I should be able to navigate to 'Step 2' upon tapping 'Step 2' button - CRC_196
    Given Admin is on my clients search page
    Then verify that 'Step2' page can be viewed by clicking on 'Step2' button in Dispute Wizard

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to navigate to previous page by 'Back' button - CRC_197
    Given Admin is on my clients search page
    Then verify that admin should be able to navigate to previous page by 'Back' button in Dispute Wizard

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to navigate to 'Who orders the credit reports?' page upon clicking 'It's important to have you clients order their own credit reports. Click here' button - CRC_199
    Given Admin is on my clients search page
    Then verify that admin should be able to navigate to 'Who orders the credit reports' page upon clicking 'Client Report' button in Dispute Wizard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view Step 3 page clicking 'Step 3' link displayed in 'Step 2' page - CRC_200
    Given Admin is on my clients search page
    Then verify that 'Step3' page can be viewed by clicking on 'Step3' link in 'Step 2' page in Dispute Wizard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to view Step 3 page clicking 'Step 3' button displayed in 'Step 2' page - CRC_201
    Given Admin is on my clients search page
    Then verify that 'Step3' page can be viewed by clicking on 'Step3' button in 'Step 2' page in Dispute Wizard

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to watch a quick video on 'Adding report items manually' - CRC_202
    Given Admin is on my clients search page
    Then verify that admin should be able to watch a quick video on 'Adding report items manually' in Dispute Wizard

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to watch a quick video on 'Working with Saved or Imported Items' - CRC_203
    Given Admin is on my clients search page
    Then verify that admin should be able to watch a quick video on 'Working with Saved or Imported Items' in Dispute Wizard

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to create letter for 'Round 1: Basic Dispute' by adding new item - CRC_204
    Given Admin is on my clients search page
    Then verify that letter for 'Round 1: Basic Dispute' can be created by adding new items in Step3 page in Dispute Wizard

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to add creditor/furnisher while adding a new item for Round 1 letter - CRC_205
    Given Admin is on my clients search page
    Then verify that admin should be able to add creditor/furnisher while adding a new item for Round 1 letter

  @MyClientsPage @P3
  Scenario: As a CRC Admin I should be able to add new reason while adding a new item for Round 1 letter - CRC_206
    Given Admin is on my clients search page
    Then verify that admin should be able to add new reason while adding a new item for Round 1 letter

  @MyClientsPage @P3
  Scenario: As a CRC Admin I should be able to add new instruction while adding a new item for Round 1 letter - CRC_207
    Given Admin is on my clients search page
    Then verify that admin should be able to add new instruction while adding a new item for Round 1 letter

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to create letter for 'Round 1: Basic Dispute' by adding saved items - CRC_208
    Given Admin is on my clients search page
    Then verify that letter for 'Round 1: Basic Dispute' can be created by adding saved items in Step3 page in Dispute Wizard

#  @MyClientsPage @Regression @P1
#  Scenario: As a CRC Admin I should be able to edit the dispute letter - CRC_209
#    Given Admin is on my clients search page
#    Then verify that admin is able to edit the dispute letter

  #This one is having issue in Jenkins somehow, so hiding it for the moment.
  @MyClientsPage @Smoke @P3
  Scenario: As a CRC Admin I should be able to export the dispute letter in 'PDF' format - CRC_210
    Given Admin is on my clients search page
    Then verify that dispute letter can be exported as PDF in Dispute Wizard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to save the dispute letter - CRC_211
    Given Admin is on my clients search page
    Then verify that dispute letter can be saved in Dispute Wizard

  @MyClientsPage @Regression @P3
  Scenario: As a CRC Admin I should be able to preview the dispute letter - CRC_212
    Given Admin is on my clients search page
    Then verify that admin is able to preview the dispute letter

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'My Saved Letters' page from 'LETTER EDITOR' page - CRC_213
    Given Admin is on my clients search page
    Then verify that admin is able to navigate to saved letters page

  @MyClientsPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to create letter for 'Round 2: All other letters' by adding new items  - CRC_214
    Given Admin is on my clients search page
    Then verify that letter for 'Round 2: All other letters' can be created by adding new item in Step3 page in Dispute Wizard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to create letter for 'Round 2: All other letters' by adding saved/pending items  - CRC_215
    Given Admin is on my clients search page
    Then verify that letter for 'Round 2: All other letters' can be created by adding saved item in Step3 page in Dispute Wizard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to create letter for 'Round 2: or higher: All other letters :Creditor/Furnishers or Collections: by adding new item  - CRC_216
    Given Admin is on my clients search page
    Then verify that letter for 'Round 2: All other letters' to creditor-furnisher can be created by adding new item in Step3 page in Dispute Wizard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to create letter for 'Round 2: or higher: All other letters :Creditor/Furnishers or Collections: by adding saved items  - CRC_217
    Given Admin is on my clients search page
    Then verify that letter for 'Round 2: All other letters' to creditor-furnisher can be created by adding saved items in Step3 page in Dispute Wizard

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should not be able to continue without selecting the letter i want while creating 'Round 2: All other letters  - CRC_218
    Given Admin is on my clients search page
    Then verify that letter for 'Round 2: All other letters' can not be created without selecting the letter in Step3 page in Dispute Wizard

  @MyClientsPage @Smoke @P3
  Scenario: As a CRC Admin I should be able to export the dispute letter in 'PDF' format  - CRC_220
    Given Admin is on my clients search page
    Then verify that Round 2 dispute letter can be exported as PDF in Dispute Wizard

  @MyClientsPage @Smoke @P3
  Scenario: As a CRC Admin I should be able to save the dispute letter   - CRC_221
    Given Admin is on my clients search page
    Then verify that Round 2 dispute letter can be saved in Dispute Wizard

  @MyClientsPage @Smoke @P3
  Scenario: As a CRC Admin I should be able to preview the dispute letter   - CRC_222
    Given Admin is on my clients search page
    Then verify that Round 2 dispute letter can be previewed in Dispute Wizard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view all the letters generated for the selected bureaus by clicking on the respective tabs  - CRC_224
    Given Admin is on my clients search page
    Then verify that admin can view all the bureaus letter in their respective tabs

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the client's documents  - CRC_225
    Given Admin is on my clients search page
    Then verify that admin can view the clients documents in Dispute Wizard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'My saved letters' page upon clicking 'Saved letters' link displayed under 'Tips'  - CRC_226
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'My saved letters' page upon clicking 'Saved letters' link under tips in Dispute Wizard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'client's dashboard' page upon clicking 'client's dashboard' link displayed under 'Tips'  - CRC_227
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'Clients Dashboard' page upon clicking 'clients dashboard' link under tips in Dispute Wizard

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the dispute items in 'List view'  - CRC_229
    Given Admin is on my clients search page
    Then verify that admin can view the dispute items in 'List view' in Dispute Items page

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to edit the dispute item details in 'Dispute items' page  - CRC_231
    Given Admin is on my clients search page
    Then verify that admin can edit the dispute item in Dispute Items page

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to update the dispute item status in 'Dispute item' page   - CRC_232
    Given Admin is on my clients search page
    Then verify that update of dispute item status is possible in Dispute item page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'Dispute wizard' tab upon clicking 'run wizard 3' link displayed in 'Dispute items' List view page  - CRC_233
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'Dispute wizard' tab upon clicking 'run wizard 3' link in 'Dispute items' List view page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the dispute items in 'Report view'  - CRC_234
    Given Admin is on my clients search page
    Then verify that admin can view the dispute items in 'Report view' in Dispute Items page

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to delete the dispute item in 'Dispute item' page   - CRC_235
    Given Admin is on my clients search page
    Then verify that delete of dispute item is possible in Dispute item page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'Dispute wizard' tab upon clicking 'run the dispute wizard' link displayed in 'Dispute items' Report view page   - CRC_238
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'Dispute wizard' tab upon clicking 'run the dispute wizard' link in 'Dispute items' Report view page

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to view the demo video upon clicking 'See video demo' link displayed in 'Dispute items' Report view page   - CRC_239
    Given Admin is on my clients search page
    Then verify that admin can view the demo video upon clicking 'See video demo' link displayed in 'Dispute items' Report view page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view 'clients dashboard' page upon clicking 'clients dashboard' link displayed in 'Dispute items' Report view page   - CRC_240
    Given Admin is on my clients search page
    Then verify that admin can navigate to clients dashboard page upon clicking 'clients dashboard' link displayed in 'Dispute items' Report view page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to navigate to 'My saved letters' page upon clicking 'Saved letters' link displayed in 'Dispute items' Report view page   - CRC_241
    Given Admin is on my clients search page
    Then verify that admin can navigate to 'My saved letters' page upon clicking 'Saved letters' link displayed in 'Dispute items' Report view page

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to watch the quick video on 'How to add the dispute items manually'    - CRC_242
    Given Admin is on my clients search page
    Then verify that admin can watch the quick video on 'How to add the dispute items manually' in 'Dispute items' List view page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to add new dispute item   - CRC_243
    Given Admin is on my clients search page
    Then verify that admin should be able to add new dispute item

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to add new dispute item by selecting the mode 'Different for each bureau'   - CRC_245
    Given Admin is on my clients search page
    Then verify that admin should be able to add new dispute item by selecting the mode 'Different for each bureau'

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to add new 'creditor/furnisher' while adding a new dispute item   - CRC_246
    Given Admin is on my clients search page
    Then verify that admin should be able to add new 'creditor/furnisher' while adding a new dispute item

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to add new 'Dispute Reason' while adding a new dispute item  - CRC_248
    Given Admin is on my clients search page
    Then verify that admin should be able to add new 'Dispute Reason' while adding a new dispute item

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to add new 'Instruction' while adding a new dispute item  - CRC_249
    Given Admin is on my clients search page
    Then verify that admin should be able to add new 'Instruction' while adding a new dispute item

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should not be able to add new dispute item without entering mandatory fields   - CRC_250
    Given Admin is on my clients search page
    Then verify that admin should not be able to add new dispute item without entering mandatory fields

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should not be able to add new dispute item without entering mandatory fields   - CRC_250
    Given Admin is on my clients search page
    Then verify that admin should not be able to add new dispute item without entering mandatory fields

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view clients Outstanding Debt   - CRC_251
    Given Admin is on my clients search page
    Then verify that admin should be able to view clients Outstanding Debt in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to add my clients outstanding Debt   - CRC_252_253_254
    Given Admin is on my clients search page
    Then verify that admin should be able to add clients Outstanding Debt in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to update clients outstanding debt details   - CRC_255
    Given Admin is on my clients search page
    Then verify that admin should be able to update clients Outstanding Debt in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to print clients outstanding debt details   - CRC_256
    Given Admin is on my clients search page
    Then verify that admin should be able to print clients Outstanding Debt in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to add daily expenses on my Client   - CRC_257_258
    Given Admin is on my clients search page
    Then verify that admin should be able to add daily expenses on Client in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to update daily expenses on my Client   - CRC_259
    Given Admin is on my clients search page
    Then verify that admin should be able to update daily expenses on Client in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to print daily expenses on my Client   - CRC_260
    Given Admin is on my clients search page
    Then verify that admin should be able to print daily expenses on Client in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to add monthly expenses on my Client   - CRC_261_262
    Given Admin is on my clients search page
    Then verify that admin should be able to add monthly expenses on Client in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to update monthly expenses on my Client   - CRC_263
    Given Admin is on my clients search page
    Then verify that admin should be able to update monthly expenses on Client in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to print monthly expenses on my Client   - CRC_264
    Given Admin is on my clients search page
    Then verify that admin should be able to print monthly expenses on Client in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to access Standard Calculator   - CRC_265
    Given Admin is on my clients search page
    Then verify that admin should be able to access Standard Calculator in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to access Mortgage Calculator   - CRC_266
    Given Admin is on my clients search page
    Then verify that admin should be able to access Mortgage Calculator in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to access Saving Calculator   - CRC_267
    Given Admin is on my clients search page
    Then verify that admin should be able to access Saving Calculator in educate page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to access calculator to find out 'HOW LONG WILL IT TAKE TO PAY OFF MY CREDIT CARD?'   - CRC_268
    Given Admin is on my clients search page
    Then verify that admin should be able to access CreditCard Calculator in educate page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view all the messages/conversations with my clients and team member  - CRC_269
    Given Admin is on my clients search page
    Then verify that admin should be able to view all the messages/conversations with its clients and team members

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view all the conversation with clients under 'Clients message' tab  - CRC_270
    Given Admin is on my clients search page
    Then verify that admin should be able to view all the conversation with clients under 'Clients messages' tab

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to search for a client by entering the name   - CRC_271
    Given Admin is on my clients search page
    Then verify that admin should be able to should be able to search for a client by entering the name

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to send a new message to a client   - CRC_272
    Given Admin is on my clients search page
    Then verify that admin should be able to send a new message to a client

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to reply to the client message   - CRC_273
    Given Admin is on my clients search page
    Then verify that admin should be able to reply to the client message

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to attach files while sending a message reply to client  - CRC_274
    Given Admin is on my clients search page
    Then verify that admin should be able to attach files while sending a message reply to client

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to select the quick note as a reply to the client message  - CRC_275
    Given Admin is on my clients search page
    Then verify that admin should be able to select the quick note as a reply to the client message

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to delete the sent message to client  - CRC_276
    Given Admin is on my clients search page
    Then verify that admin should be able to delete the sent message to client

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to attach files while sending a new message  - CRC_278
    Given Admin is on my clients search page
    Then verify that admin should be able to attach files while sending a new message to client

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to save the message as 'Quick Note' while sending the new message  - CRC_279
    Given Admin is on my clients search page
    Then verify that admin should be able to save the message as 'Quick Note' while sending the new message to client

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to navigate to 'Quick Notes' page by clicking 'Manage Quick Notes'  - CRC_280
    Given Admin is on my clients search page
    Then verify that admin should be able to navigate to 'Quick Notes' page by clicking 'Manage Quick Notes'

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to add new 'Quick Note'  - CRC_281_283_284
    Given Admin is on my clients search page
    Then verify that admin should be able to add new 'Quick Note'

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to edit 'Quick Note'  - CRC_282
    Given Admin is on my clients search page
    Then verify that admin should be able to edit 'Quick Note'

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view all the conversation with affiliates under 'Affiliates message' tab  - CRC_285
    Given Admin is on my clients search page
    Then verify that admin should be able to view all the conversation with affiliates under 'Affiliates messages' tab

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search for an affiliate by entering the name   - CRC_286
    Given Admin is on my clients search page
    Then verify that admin should be able to should be able to search for an affiliate by entering the name

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to send a new message to an affiliate   - CRC_287
    Given Admin is on my clients search page
    Then verify that admin should be able to send a new message to an affiliate

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to reply to the affiliate message   - CRC_288
    Given Admin is on my clients search page
    Then verify that admin should be able to reply to the affiliate message

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to attach files while sending a message reply to affiliate  - CRC_289
    Given Admin is on my clients search page
    Then verify that admin should be able to attach files while sending a message reply to affiliate

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to select the quick note as a reply to the affiliate message  - CRC_290
    Given Admin is on my clients search page
    Then verify that admin should be able to select the quick note as a reply to the affiliate message

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to delete the sent message to affiliate  - CRC_291
    Given Admin is on my clients search page
    Then verify that admin should be able to delete the sent message to affiliate

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view all the conversation with affiliates under 'Team member' tab  - CRC_293
    Given Admin is on my clients search page
    Then verify that admin should be able to view all the conversation with affiliates under 'Team member messages' tab

#  @MyClientsPage @Regression @P1
#  Scenario: As a CRC Admin I should be able to search for a team member by entering the name   - CRC_294
#    Given Admin is on my clients search page
#    Then verify that admin should be able to search for a team member by entering the name


  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to send a new message to a team member   - CRC_295
    Given Admin is on my clients search page
    Then verify that admin should be able to send a new message to a team member

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to reply to the team member's message   - CRC_296
    Given Admin is on my clients search page
    Then verify that admin should be able to reply to the team member message

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to attach files while sending a message reply   - CRC_297
    Given Admin is on my clients search page
    Then verify that admin should be able to attach files while sending a message reply

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to select the quick note as a reply to the team member's message  - CRC_298
    Given Admin is on my clients search page
    Then verify that admin should be able to select the quick note as a reply to the team member message

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to delete the sent message  - CRC_299
    Given Admin is on my clients search page
    Then verify that admin should be able to delete the sent message

#  @MyClientsPage @Regression @P1
#  Scenario: As a CRC Admin I should be able to delete the message sent by the team member  - CRC_300
#    Given Admin is on my clients search page
#    Then verify that admin should be able to delete the message sent by the team member

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to save an internal note for each client   - CRC_301_303
    Given Admin is on my clients search page
    Then verify that admin should be able to save an internal note for each client

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to edit the internal note added for each client   - CRC_302
    Given Admin is on my clients search page
    Then verify that admin should be able to edit the internal note added for each client

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to attach files with the internal note    - CRC_304
    Given Admin is on my clients search page
    Then verify that admin should be able to attach files with the internal note

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to access 'Invoices & Payments' details of the selected Client   - CRC_305
    Given Admin is on my clients search page
    Then verify that invoices and payment details of the selected client can be viewed in Invoices page

  @MyClientsPage @P2
  Scenario: As a CRC Admin I should be able to watch the quick video on how to create new invoice   - CRC_306
    Given Admin is on my clients search page
    Then verify that admin should be able to watch the quick video on how to create new invoice in Invoices page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view clients 'Past/outstanding/Paid payments   - CRC_307
    Given Admin is on my clients search page
    Then verify that admin should be able to view clients Past/Outstanding/Paid payments

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter only invoices from the invoices and payments list   - CRC_308
    Given Admin is on my clients search page
    Then verify that admin should be able to filter only invoices from the invoices and payments list in Invoices page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter only payments from the invoices and payments list   - CRC_309
    Given Admin is on my clients search page
    Then verify that admin should be able to filter only payments from the invoices and payments list in Invoices page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter only pending from the invoices and payments list   - CRC_310
    Given Admin is on my clients search page
    Then verify that admin should be able to filter only pending from the invoices and payments list in Invoices page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to filter only paid from the invoices and payments list   - CRC_311
    Given Admin is on my clients search page
    Then verify that admin should be able to filter only paid from the invoices and payments list in Invoices page

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to see chargebee warning message while creating a new invoice in Invoices page   - CRC_312
    Given Admin is on my clients search page
    Then verify that chargebee warning can be seen while creating a new invoice in Invoices page

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to create invoice by selecting saved invoice items   - CRC_313
    Given Admin is on my clients search page
    Then verify that invoice can be created by selecting saved invoice items in Invoices page

  @MyClientsPage @P1
  Scenario: As a CRC Admin I should be able to create invoice by adding new invoice item   - CRC_314
    Given Admin is on my clients search page
    Then verify that invoice can be created by adding new invoice item in Invoices page

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to change the status of pending invoice to 'Received'  - CRC_315
    Given Admin is on my clients search page
    Then verify that invoice status can be set from pending to received in Invoices page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to edit the invoice by clicking on 'More Actions'  - CRC_316
    Given Admin is on my clients search page
    Then verify that admin should be able to edit the invoice by clicking on 'More Actions' in Invoices page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to preview the invoice by clicking on 'Preview'  - CRC_317
    Given Admin is on my clients search page
    Then verify that admin should be able to preview the invoice by clicking on 'Preview' in Invoices page

  @MyClientsPage @Regression @P2
  Scenario: As a CRC Admin I should be able to print the invoice  - CRC_318
    Given Admin is on my clients search page
    Then verify that admin should be able to print the invoice in Invoices page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to export the invoice in PDF format  - CRC_319
    Given Admin is on my clients search page
    Then verify that admin should be able to export the invoice in PDF format in Invoices page

  @MyClientsPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view my client's 'Credit Repair Activity Report'  - CRC_320
    Given Admin is on my clients search page
    Then verify that Credit Repair Activity Report can be viewed in Activity page

  @MyClientsPage @Regression @P1
  Scenario: As a CRC Admin I should be able to print my client's 'Credit Repair Activity Report'  - CRC_321
    Given Admin is on my clients search page
    Then verify that Credit Repair Activity Report can be printed in Activity page

