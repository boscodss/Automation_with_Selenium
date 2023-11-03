Feature: To create an application as Seller

  Scenario Outline: Verify if a Seller can create application

    Given seller is on the sign up page
    Then seller signs in
    Then seller clicks on start new application
    Then seller enters Customers Email Address as "<customer_email>"
    And seller enters first name as "<firstname>"
    And seller enters last name as "<lastname>"
    And seller enters contact number as "<phone>"
    When seller clicks on create account button
    When seller selects campaign
    Then seller select noThanks
    When seller selects product
    Then seller is on Choose your pricing plan
    And seller selects no to amex
    Then seller click on proceed with online application
    And seller clicks on lets start
    Then seller CSR is shown
    Then seller select legal entity
    Then seller select Country of incorporation
    Then seller enter date of commence trading
    Then seller enter business address
    Then seller select type of property
    Then seller select company have website
    Then seller select advertise business and enter details
    Then seller select Vat
    Then seller select take card payments
    Then seller select verbal comms
    Then seller click continue
    Then seller capture CSR
    Then seller capture contact details
    Then seller add details of principal
    Then seller add details about your goods and services
    Then seller add outlet details as "<tradingname>"
    Then seller add contact details
    Then seller add settlement bank account
    Then seller add delivery details
    Then seller clicks on continue button on step 6
    Then seller is on the Service requirements
    Then seller clicks on hand over to customer
    Examples:

        | customer_email                        | firstname      | lastname     | phone        | tradingname         |
        | bosco.dsouza+test261002@fisglobal.com | Bibbie         | Bdawkes      | 07478754119  | Bdawkes_Test        |