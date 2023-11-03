Feature: To create an application as Sole Trader

  Scenario Outline: Verify if a sole trader application can be created

    Given user is on the sign up page
    And user enters first name as "<firstname>"
    And user enters last name as "<lastname>"
    And enters email address as "<emailadd1>"
    And enters confirm email address as "<emailadd2>"
    And enters contact number as "<phone>"
    And enters password as "<password>"
    And enters confirm password as "<confpassword>"
    When clicks on continue button
    When user selects quantity
    When user selects product
    Then User is on Choose your pricing plan
    And user selects no to amex1
    Then user click on proceed with online application
    And clicks on lets start
    Then CSR is shown
    Then select legal entity
    Then select Country of incorporation
    Then enter date of commence trading
    Then enter business address
    Then select type of property
    Then select company have website
    Then select advertise business and enter details
    Then select Vat
    Then select take card payments
    Then select verbal comms
    Then click continue
    Then capture CSR
    Then capture contact details
    Then add details of principal
    Then add details about your goods and services
    Then add outlet details as "<tradingName>"
    Then add contact details
    Then add settlement bank account
    Then add delivery details
    Then clicks on continue button on step 6
    Then user is on the Service requirements
    Then user is on the Acceptance page
    Then screen shot is captured
    Then user goes to upload image page
    Then user is on image upload page

    Examples:
      | firstname      | lastname       | emailadd1                              | emailadd2                                 | phone       | password  | confpassword | tradingName        |
      | Hollyanne      | Holbarrow     | bosco.dsouza+test091003@fisglobal.com   | bosco.dsouza+test091003@fisglobal.com     | 07478754119 | Asdf@1977 | Asdf@1977    | Holbarrow_Outlet   |