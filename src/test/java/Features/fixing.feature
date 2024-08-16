Feature: 2 To create an application as Seller

  Scenario Outline: 2 Verify if a Seller can create application

    Given seller is on the sign up page 2
    Then seller signs in 2
    Then seller clicks on resume application
    Then seller click on Details Verified
    Then seller expands the bank details for charges
    When seller selects campaign1
    Then seller select noThanks1
    When seller selects product1
    Then seller is on Choose your pricing plan1
#    And seller selects no to amex
    Then seller click on proceed with online application1
    And seller clicks on lets start1
    Then seller CSR is shown1
    Then seller select legal entity1
    Then seller select Country of incorporation1
    Then seller enter date of commence trading1
    Then seller enter business address1
    Then seller select type of property1
    Then seller select company have website1
    Then seller select advertise business and enter details
    Then seller select Vat1
    Then seller select take card payments1
    Then seller select verbal comms1
    Then seller click continue1
    Then seller capture CSR1
    Then seller capture contact details1
    Then seller add details of principal1
    Then seller add details about your goods and services1
    Then seller add outlet details as "<tradingname>"1
    Then seller add contact details1
    Then seller add settlement bank account1
    Then seller add delivery details1
    Then seller clicks on continue button on step 61
    Then seller is on the Service requirements1
    Then seller clicks on hand over to customer1
    Examples:

      | customer_email                         | firstname      | lastname            | phone        | tradingname         |
      | bosco.dsouza+test190608@fisglobal.com  | Jaxel          | Kioni               | 07478754119  | Kioni Outlet        |