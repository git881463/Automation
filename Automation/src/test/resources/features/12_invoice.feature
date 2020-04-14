Feature: As a user, I want to navigate & analyze Invoices page of application

  @InvoicesPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view list of all invoices on  'My Invoices' page - CRC_436
    Given Admin is on Invoices page
    Then verify that invoices details are shown on the page

  @InvoicesPage @P2
  Scenario: As a CRC Admin I should be able to watch quick videos on 'How to create invoices' - CRC_437
    Given Admin is on Invoices page
    Then verify that admin should be able to watch quick videos on 'How to create invoices'

  @InvoicesPage @P1
  Scenario: As a CRC Admin I should be able to filter the invoice and payment by 'Total Outstanding' status - CRC_438
    Given Admin is on Invoices page
    Then verify that admin should be able to filter the invoice and payment by 'Total Outstanding' status

  @InvoicesPage @P2
  Scenario: As a CRC Admin I should be able to filter the invoice and payment by 'Past due' status - CRC_439
    Given Admin is on Invoices page
    Then verify that admin should be able to filter the invoice and payment by 'Past due' status

  @InvoicesPage @P2
  Scenario: As a CRC Admin I should be able to filter the invoice and payment by 'Paid in last 30 days' status - CRC_440
    Given Admin is on Invoices page
    Then verify that admin should be able to filter the invoice and payment by 'Paid in last 30 days' status

  @InvoicesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search the invoices by entering clients name - CRC_441
    Given Admin is on my clients search page
    Then verify that admin should be able to search the invoices by entering clients name in Invoices page

  @InvoicesPage @Regression @P1
  Scenario: As a CRC Admin I should be able to search the invoices by entering clients email address - CRC_442
    Given Admin is on my clients search page
    Then verify that admin should be able to search the invoices by entering clients email address in Invoices page

  @InvoicesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search the invoices by Invoice date under 'Advanced search' - CRC_443
    Given Admin is on my clients search page
    Then verify that admin should be able to search the invoices by Invoice date under 'Advanced search' in Invoices page

  @InvoicesPage @Regression @P1
  Scenario: As a CRC Admin I should be able to search the invoices by Invoice number under 'Advanced search' - CRC_444
    Given Admin is on my clients search page
    Then verify that admin should be able to search the invoices by Invoice number under 'Advanced search' in Invoices page

  @InvoicesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search the invoices by Invoice reference under 'Advanced search' - CRC_445
    Given Admin is on my clients search page
    Then verify that admin should be able to search the invoices by Invoice reference under 'Advanced search' in Invoices page

  @InvoicesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to search the invoices by Invoice Terms in Days under 'Advanced search' - CRC_446
    Given Admin is on my clients search page
    Then verify that admin should be able to search the invoices by Invoice Terms in Days under 'Advanced search' in Invoices page

  @InvoicesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to view the invoice and payment details upon clicking Clients name' - CRC_447
    Given Admin is on my clients search page
    Then verify that admin should be able to view the invoice and payment details upon clicking 'Clients name' in Invoices page

  @InvoicesPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to create invoice for the clients listed in 'Invoices ' page - CRC_448
    Given Admin is on my clients search page
    Then verify that invoice can be created by selecting saved invoice items in Invoices page

  @InvoicesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to add new item while creating the Invoice - CRC_449
    Given Admin is on my clients search page
    Then verify that invoice can be created by adding new invoice item in Invoices page

  @InvoicesPage @Regression @P2
  Scenario: As a CRC Admin I should be able to set billing reminders for all the clients listed in 'Invoices ' page - CRC_451
    Given Admin is on my clients search page
    Then verify that admin should be able to set billing reminders for all the clients listed in Invoices page
