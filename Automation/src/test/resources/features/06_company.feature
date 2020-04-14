Feature: As a user, I want to navigate & analyze my company page of application

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to edit my company profile  - CRC_346
  Given Admin is on my company page
  Then verify that company profile can be edited in My Company page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to watch the quick video  - CRC_347
    Given Admin is on my company page
    Then verify that admin should be able to watch the quick video in My Company Profile page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to navigate to 'My Account' page  - CRC_348
    Given Admin is on my company page
    Then verify that admin should be able to navigate to 'My Account' page from My Company Profile page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to check URL functionality  - CRC_349
    Given Admin is on my company page
    Then verify that admin should be able to check URL functionality in My Company Profile page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to view guided tours  - CRC_350
    Given Admin is on my company page
    Then verify that admin should be able to view guided tours in My Company Profile page

  @MyCompanyPage @Smoke @Regression @P0
  Scenario: As a CRC Admin I should be able to add team member   - CRC_352
    Given Admin is on my company page
    Then verify that team member can be added in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to 'Disable team chat'   - CRC_354
    Given Admin is on my company page
    Then verify that admin should be able to 'Disable team chat' in My Company page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to view the permission granted for the 3 default user roles   - CRC_355
    Given Admin is on my company page
    Then verify that admin should be able to view the permission granted for the 3 default user roles in My Company page

  @MyCompanyPage @P1
  Scenario: As a CRC Admin I should be able to create new user role   - CRC_356_357_358
    Given Admin is on my company page
    Then verify that roles can be created edited deleted in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to edit credit monitoring service client's Sign-up link  - CRC_359
    Given Admin is on my company page
    Then verify that admin should be able to edit credit monitoring service clients sign-up link in My Company page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to request affiliate program information  - CRC_360
    Given Admin is on my company page
    Then verify that admin should be able to request affiliate program information in My Company page

  @MyCompanyPage @P1
  Scenario: As a CRC Admin I should be able to set my company logo which will be displayed in 'Client/Affiliate' portal  - CRC_361
    Given Admin is on my company page
    Then verify that admin should be able to set my company logo which will be displayed in 'Client/Affiliate' portal

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to preview my client portal  - CRC_362
    Given Admin is on my company page
    Then verify that client portal can be previewed in My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to preview my affiliate portal  - CRC_363
    Given Admin is on my company page
    Then verify that affiliate portal can be previewed in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to select the useful details to be displayed in Client and Affiliate profile  - CRC_364
    Given Admin is on my company page
    Then verify that admin should be able to select the useful details to be displayed in Client and Affiliate profile in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to show useful resource in client portal  - CRC_365
    Given Admin is on my company page
    Then verify that admin should be able to show useful resource in client portal

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to hide useful resource in client portal  - CRC_366
    Given Admin is on my company page
    Then verify that admin should be able to hide useful resource in client portal

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to modify useful resource in client portal  - CRC_367
    Given Admin is on my company page
    Then verify that admin should be able to modify useful resource in client portal

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to reset the useful resource settings to default setting in client portal  - CRC_368
    Given Admin is on my company page
    Then verify that admin should be able to reset the useful resource settings to default setting in client portal

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to show credit info in client portal  - CRC_369
    Given Admin is on my company page
    Then verify that credit info setting can be set to show in My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to hide credit info in client portal  - CRC_370
    Given Admin is on my company page
    Then verify that credit info setting can be set to hide in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to modify credit info in client portal  - CRC_371
    Given Admin is on my company page
    Then verify that admin should be able to modify credit info in client portal in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to reset the credit info settings to default setting  - CRC_372
    Given Admin is on my company page
    Then verify that admin should be able to reset the credit info settings to default settings in client portal in My Company page

  @MyCompanyPage @P3
  Scenario: As a CRC Admin I should be able to turn ON Clients choice   - CRC_373
    Given Admin is on my company page
    Then verify that admin should be able to turn ON Clients choice in client portal

  @MyCompanyPage @P3
  Scenario: As a CRC Admin I should be able to turn OFF Clients choice   - CRC_374
    Given Admin is on my company page
    Then verify that admin should be able to turn OFF Clients choice in client portal

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to edit the Client/Affiliate portal theme color   - CRC_375
    Given Admin is on my company page
    Then verify that admin should be able to edit the Client/Affiliate portal theme color in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to reset the Client/Affiliate theme color to default   - CRC_376
    Given Admin is on my company page
    Then verify that admin should be able to reset the Client/Affiliate theme color to default in My Company page

  @MyCompanyPage @P3
  Scenario: As a CRC Admin I should be able to Turn ON Client Onboarding   - CRC_377
    Given Admin is on my company page
    Then verify that admin should be able to turn ON Clients Onboarding in client portal

  @MyCompanyPage @P3
  Scenario: As a CRC Admin I should be able to turn OFF Client Onboarding   - CRC_378
    Given Admin is on my company page
    Then verify that admin should be able to turn OFF Clients Onboarding in client portal

  @MyCompanyPage @Regression @P3
  Scenario: As a CRC Admin I should be able to rearrange the 6 default tasks   - CRC_379
    Given Admin is on my company page
    Then verify that admin should be able to rearrange the 6 default tasks in client portal

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to delete the 6 default tasks   - CRC_380
    Given Admin is on my company page
    Then verify that admin should be able to delete the 6 default tasks in client portal

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to reset onboarding tasks to default tasks and order   - CRC_381
    Given Admin is on my company page
    Then verify that admin should be able to reset onboarding tasks to default tasks and order in client portal

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to preview client onboarding tasks   - CRC_382
    Given Admin is on my company page
    Then verify that admin should be able to preview client onboarding tasks in client portal

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to edit client onboarding tasks   - CRC_383
    Given Admin is on my company page
    Then verify that admin should be able to edit client onboarding tasks in client portal

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to edit web lead form   - CRC_384
    Given Admin is on my company page
    Then verify that admin should be able to edit web lead form in website tools

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to preview web lead form   - CRC_385
    Given Admin is on my company page
    Then verify that admin should be able to preview web lead form in website tools

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to copy the web lead form code   - CRC_386
    Given Admin is on my company page
    Then verify that admin should be able to copy the web lead form code in website tools

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add New simple audit template  - CRC_388_392
    Given Admin is on my company page
    Then verify that new simple audit template can be added in My Company page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to change the Company logo just for simple audit report  - CRC_389
    Given Admin is on my company page
    Then verify that admin should be able to change the Company logo just for simple audit report in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to preview the Simple audit template  - CRC_390
    Given Admin is on my company page
    Then verify that admin should be able to preview the Simple audit template in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to edit the simple audit template  - CRC_391
    Given Admin is on my company page
    Then verify that admin should be able to edit the Simple audit template in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to select my preference on online agreement  - CRC_393
    Given Admin is on my company page
    Then verify that admin should be able to select preference on online agreement in My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add new agreement  - CRC_394
    Given Admin is on my company page
    Then verify that new client agreement can be added in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to preview the agreement  - CRC_395
    Given Admin is on my company page
    Then verify that admin should be able to preview the agreement in My Company page

  @MyCompanyPage @P1
  Scenario: As a CRC Admin I should be able to get the added agreement in spanish  - CRC_397
    Given Admin is on my company page
    Then verify that admin should be able to get the added agreement in spanish in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to set the agreement status to default  - CRC_398
    Given Admin is on my company page
    Then verify that admin should be able to set the agreement status to default in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the list of clients who have set the digital signature  - CRC_399
    Given Admin is on my company page
    Then verify that admin should be able to view the list of clients who have set the digital signature

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to view digital signature of my client  - CRC_400
    Given Admin is on my company page
    Then verify that digital signature of the client can be viewed from My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add new dispute reasons  - CRC_401
    Given Admin is on my company page
    Then verify that new dispute reasons can be added in My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add new instructions  - CRC_403
    Given Admin is on my company page
    Then verify that new instructions can be added in My Company page

  @MyCompanyPage @P0
  Scenario: As a CRC Admin I should be able to activate batch print  - CRC_405
    Given Admin is on my company page
    Then verify that batch print can be activated in My Company page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to modify the credit bureaus address  - CRC_406
    Given Admin is on my company page
    Then verify that admin should be able to modify the credit bureaus address in My Company page

  @MyCompanyPage @P2
  Scenario: As a CRC Admin I should be able to reset the credit bureau address  - CRC_407
    Given Admin is on my company page
    Then verify that admin should be able to reset the credit bureaus address in My Company page

  @MyCompanyPage @P1
  Scenario: As a CRC Admin I should be able to set automated notification options  - CRC_408
    Given Admin is on my company page
    Then verify that admin should be able to set automated notification options in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to add new client status type  - CRC_409_410
    Given Admin is on my company page
    Then verify that admin should be able to add new client status type in My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to add new invoice option  - CRC_411_412
    Given Admin is on my company page
    Then verify that new invoice option can be added in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to preview the invoice option  - CRC_413
    Given Admin is on my company page
    Then verify that admin should be able to preview the invoice option in My Company page

  @MyCompanyPage @P1
  Scenario: As a CRC Admin I should be able to update affiliate commission settings  - CRC_414
    Given Admin is on my company page
    Then verify that admin should be able to update affiliate commission settings in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to see the affiliate commission setting in affiliate profile page  - CRC_415
    Given Admin is on my company page
    Then verify that admin should be able to see the affiliate commission setting in affiliate profile page in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view affiliate payment history  - CRC_416
    Given Admin is on my company page
    Then verify that admin should be able to view affiliate payment history in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to set the commission rate for the affiliate  - CRC_419
    Given Admin is on my company page
    Then verify that admin should be able to set the commission rate for the affiliate in My Company page

  @MyCompanyPage @Regression @P2
  Scenario: As a CRC Admin I should be able to set the Custom rate for the affiliate for future - CRC_420
    Given Admin is on my company page
    Then verify that admin should be able to set the Custom rate for the affiliate for future in My Company page

  @MyCompanyPage @Regression @P1
  Scenario: As a CRC Admin I should be able to view the email template  - CRC_426
    Given Admin is on my company page
    Then verify that admin should be able to view the email template in My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to activate ChargeBee Integration  - CRC_429
    Given Admin is on my company page
    Then verify that chargebee integration can be activated in My Company page

  @MyCompanyPage @Smoke @P0
  Scenario: As a CRC Admin I should be able to access API&Automation information - CRC_435
    Given Admin is on my company page
    Then verify that api & automation information can be accessed in My Company page
