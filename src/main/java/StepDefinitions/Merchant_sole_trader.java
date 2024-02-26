package StepDefinitions;

import io.cucumber.java.en.*;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class Merchant_sole_trader {

    WebDriver driver;

    @Given("user is on the sign up page")
    public void user_is_on_the_sign_up_page() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //System.setProperty("webdriver.chrome.driver", "C:/Users/E5618594/IdeaProjects/OLS/src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().driverVersion("119.0.6045.160").setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        driver = new ChromeDriver();

// This section is for headless
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("headless");
//        driver=new ChromeDriver(options);
//        driver.get("https://apply-online-featuretest.worldpay.com/");


// This section is for Browser Opens
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://apply-online-featuretest.worldpay.com/");
    }

    @Given("user enters first name as {string}")
    public void user_enters_first_name_as(String firstname) throws InterruptedException {
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div[2]/button[3]")).click();
        driver.findElement(By.name("RegistrationViewModel.FirstName")).sendKeys(firstname);
        System.out.println("First Name entered");
    }

    @Given("user enters last name as {string}")
    public void user_enters_last_name_as(String lastname) throws InterruptedException {
        driver.findElement(By.name("RegistrationViewModel.LastName")).sendKeys(lastname);
        System.out.println("Last Name entered");
        Thread.sleep(2000);
    }

    @Given("enters email address as {string}")
    public void enters_email_address_as(String emailadd1) throws InterruptedException {
        driver.findElement(By.name("RegistrationViewModel.RegisterEmail")).sendKeys(emailadd1);
        System.out.println("Email1 entered");
        Thread.sleep(2000);
    }

    @Given("enters confirm email address as {string}")
    public void enters_confirm_email_address_as(String emailadd2) throws InterruptedException {
        driver.findElement(By.name("RegistrationViewModel.ConfirmEmail")).sendKeys(emailadd2);
        System.out.println("Email2 entered");
        Thread.sleep(2000);
    }

    @Given("enters contact number as {string}")
    public void enters_contact_number_as(String phone) throws InterruptedException {
        driver.findElement(By.name("RegistrationViewModel.PhoneNumber")).sendKeys(phone);
        System.out.println("Phone entered");
        Thread.sleep(2000);
    }

    @Given("enters password as {string}")
    public void enters_password_as(String password) throws InterruptedException {
        driver.findElement(By.name("RegistrationViewModel.RegisterPassword")).sendKeys(password);
        System.out.println("Password entered");
        Thread.sleep(2000);
    }

    @Given("enters confirm password as {string}")
    public void enters_confirm_password_as(String confpassword) throws InterruptedException {
        driver.findElement(By.name("RegistrationViewModel.ConfirmPassword")).sendKeys(confpassword);
        System.out.println("Re enter Password entered");
        Thread.sleep(2000);
    }

    @When("clicks on continue button")
    public void clicks_on_continue_button() throws InterruptedException {
        driver.findElement(By.id("registerbtn")).click();
        System.out.println("Clicked Registration button");
        Thread.sleep(25000);
    }

    @When("user selects quantity")
    public void user_selects_quantity() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='cardmachines']/div[1]/div/div/div[3]/div[1]/label[2]")).click();
        Thread.sleep(5000);
        System.out.println("Quantity Selected as 1");
    }


    @When("user selects product")
    public void user_selects_product() throws InterruptedException {
        //No, Thanks button - Would you like to hear more from our partner Liberis ltd. about this?
        JavascriptExecutor noThanksbuttonjse = (JavascriptExecutor) driver;
        noThanksbuttonjse.executeScript("scroll(0, 2000)");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div/div/div[3]/div[2]/div/div[4]/div/div[3]/label")).click();
        Thread.sleep(5000);

        //Please help us identify your business type. 1
        Select mcc1 = new Select(driver.findElement(By.id("SelectedMCCSelectorTier1Id")));
        mcc1.selectByIndex(2);
        Thread.sleep(5000);

        //Please help us identify your business type. 2
        Select mcc2 = new Select(driver.findElement(By.id("SelectedMCCSelectorTier2Id")));
        mcc2.selectByIndex(2);
        Thread.sleep(5000);

        //In a few words, please describe the products or services that your business offers.
        driver.findElement(By.id("FurtherBusinessInfo")).sendKeys("My business");
        Thread.sleep(5000);

        //What is your annual turnover?
        driver.findElement(By.id("annualTurnover")).sendKeys("50000");
        Thread.sleep(3000);

        //What percentage of your annual turnover is taken by card?
        driver.findElement(By.id("cardPercentage")).sendKeys("5");
        Thread.sleep(3000);

        //What is your average card transaction value?
        driver.findElement(By.id("averageTransactionValue")).sendKeys("500");
        Thread.sleep(3000);

        // WebElement avgtraValue = driver.findElement(By.id("averageTransactionValue"));
        //avgtraValue.sendKeys(Keys.TAB);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement UKYes = driver.findElement(By.id("HasUKBankAccount_Yes"));
        js.executeScript("arguments[0].click();", UKYes);
        Thread.sleep(3000);
        WebElement prowithApp = driver.findElement(By.id("btnContinue"));
        js.executeScript("arguments[0].click();", prowithApp);
        Thread.sleep(10000);
    }

    @Then("User is on Choose your pricing plan")
    public void user_is_on_Choose_your_pricing_plan() throws InterruptedException {
        JavascriptExecutor chooseplan1 = (JavascriptExecutor) driver;
        WebElement chooseplan2 = driver.findElement(By.xpath("//*[@id='select_SIMPLICITY_1']"));
        chooseplan1.executeScript("arguments[0].click();", chooseplan2);
        Thread.sleep(3000);
        System.out.println("Selected Simplicity Price Plan");
    }

    @And("user selects no to amex1")
    public void selects_no_to_amex1() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement noToAmex = driver.findElement(By.id("Amex_NotRequired_2"));
        js.executeScript("arguments[0].click();", noToAmex);
        Thread.sleep(3000);
        System.out.println("Selected No to Amex Card");
    }

    @Then("user click on proceed with online application")
    public void user_click_on_proceed_with_online_application() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement apply = driver.findElement(By.name("apply"));
        js.executeScript("arguments[0].click();", apply);
        Thread.sleep(3000);
        System.out.println("Selected Proceed with online application");
    }

    @And("clicks on lets start")
    public void clicks_on_lets_start() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement start = driver.findElement(By.name("start"));
        js.executeScript("arguments[0].click();", start);
        System.out.println("Selected Lets get started");
        Thread.sleep(10000);
    }

    //User is on the 1st Step of the Application

    @And("CSR is shown")
    public void CSR_is_shown() throws InterruptedException {
        String csrNumber = driver.findElement(By.id("application-reference")).getText();
        System.out.println(csrNumber);
        System.out.println("CSR is shown");
        Thread.sleep(4000);
    }

    //Select Sole Trader
    @Then("select legal entity")
    public void select_legal_entity() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement legalEntity = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[1]/div/div[1]/div[1]/label"));
        js.executeScript("arguments[0].click();", legalEntity);
        Thread.sleep(5000);
    }

    //Select Country of incorporation
    @Then("select Country of incorporation")
    public void select_Country_of_incorporation() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement counOfInco = driver.findElement(By.id("rb_CountryOfIncorporation_SelectedItemId_1"));
        js.executeScript("arguments[0].click();", counOfInco);
        Thread.sleep(3000);

        //Select which part of the Country - England
        WebElement incorpIN = driver.findElement(By.id("rb_RegionsOfCountry_SelectedItemId_1"));
        js.executeScript("arguments[0].click();", incorpIN);
    }

    //Select Date of Commenced Trading
    @Then("enter date of commence trading")
    public void enter_date_of_commence_trading() throws InterruptedException {
        driver.findElement(By.id("CommencedTradingMonth")).sendKeys("5");
        Thread.sleep(4000);
        driver.findElement(By.id("CommencedTradingYear")).sendKeys("2010");
        Thread.sleep(4000);
    }

    //Manually enter address
    @Then("enter business address")
    public void enter_business_address() throws InterruptedException {

        //Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement manuEnterAddress = driver.findElement(By.xpath("//*[@id='btnAddressManual']"));
        js.executeScript("arguments[0].click();", manuEnterAddress);
        driver.findElement(By.id("BusinessAddressLine1")).sendKeys("3010 Loveday Road");
        driver.findElement(By.id("BusinessAddressLine2")).sendKeys("High Street");
        driver.findElement(By.id("Town")).sendKeys("London");
        driver.findElement(By.id("BusinessPostCode")).sendKeys("TW80GB");
        driver.findElement(By.id("Country")).sendKeys("United Kingdom");
        System.out.println("Manually entered Address");
        Thread.sleep(5000);
    }

    //Is this address a residential or commercial property?
    @Then("select type of property")
    public void select_type_of_property() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='registeredAddressContainer']/div[2]/div[7]/label[2]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='registeredIsCorrespondenceContainer']/div/label[1]")).click();
        Thread.sleep(3000);

        //Click on Save address
        driver.findElement(By.xpath("//*[@id='registeredAddressContainer']/div[2]/div[9]/button[2]")).click();
        Thread.sleep(3000);
    }

    //Does your company have a website?
    @Then("select company have website")
    public void select_company_have_website() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor companyurlNo1 = (JavascriptExecutor) driver;
        WebElement companyurlNo2 = driver.findElement(By.xpath("//*[@id='label_CompanyUrlType_2']"));
        companyurlNo1.executeScript("arguments[0].click();", companyurlNo2);

    }

    //Do you advertise your business?
    @Then("select advertise business and enter details")
    public void select_advertise_business_and_enter_details() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement website = driver.findElement(By.xpath("//*[@id='DoesCustomerAdvertiseLabel_No']"));
        js.executeScript("arguments[0].click();", website);
        Thread.sleep(3000);
        driver.findElement(By.id("HowDoesCustomerGenerateBusiness")).sendKeys("How do you generate business?");
        Thread.sleep(5000);
    }

    //Is your company VAT Registered?
    @Then("select Vat")
    public void select_Vat() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement vatNoButton = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[13]/div/label[2]"));
        js.executeScript("arguments[0].click();", vatNoButton);
        Thread.sleep(5000);
    }

    //Are you new to taking card payments?
    @Then("select take card payments")
    public void select_take_card_payments() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cardPaymentButtonNo = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[15]/div/label[2]"));
        js.executeScript("arguments[0].click();", cardPaymentButtonNo);
        Thread.sleep(5000);
    }

    //Written and verbal communication options
    @Then("select verbal comms")
    public void select_verbal_comms() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement verbalCommButtonNo = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[18]/div/label[2]"));
        js.executeScript("arguments[0].click();", verbalCommButtonNo);
        Thread.sleep(5000);
    }

    //Click on Continue
    @Then("click continue")
    public void click_continue() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement contButton = driver.findElement(By.id("btnBusiness"));
        js.executeScript("arguments[0].click();", contButton);
        Thread.sleep(5000);
    }

    //User is on the 2nd Step of the Application
    @Then(("capture CSR"))
    public void capture_CSR() throws InterruptedException {
        String CSR = driver.findElement(By.id("application-reference")).getText();
        System.out.println(CSR);
        System.out.println("On Stage 2 of the Application");
        Thread.sleep(5000);
    }

    @Then(("capture contact details"))
    public void capture_contact_details() throws InterruptedException {
        //click on Title
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        WebElement Title = driver.findElement(By.xpath("//*[@id='selectBoxTitleContainer']/div[1]/div[1]/label"));
        jst.executeScript("arguments[0].click();", Title);
        Thread.sleep(5000);

        //click on Position
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement soleTrader = driver.findElement(By.xpath("//*[@id='YourDetailsContainer']/div[3]/div/div[1]/div/label"));
        js.executeScript("arguments[0].click();", soleTrader);
        Thread.sleep(5000);

        //Select Country of residence
        driver.findElement(By.id("CountryOfResidence")).sendKeys("United Kingdom");
        Thread.sleep(5000);

        //Enter DOB
        driver.findElement(By.id("DateOfBirth")).sendKeys("02/04/1990");

        //click on email checkbox
        JavascriptExecutor f = (JavascriptExecutor) driver;
        WebElement emailcheckbox = driver.findElement(By.xpath("//*[@id='YourDetailsContainer']/div[8]/div/div[2]/label"));
        f.executeScript("arguments[0].click();", emailcheckbox);
        Thread.sleep(2000);

        JavascriptExecutor g = (JavascriptExecutor) driver;
        WebElement continuebutton = driver.findElement(By.xpath("//*[@id='btnYourDetails']"));
        g.executeScript("arguments[0].click();", continuebutton);
        Thread.sleep(2000);
    }

    //Principals and ownership details Screen
    @Then(("add details of principal"))
    public void add_details_of_principal() throws InterruptedException {

        //Click on Edit
        JavascriptExecutor editPrincipal = (JavascriptExecutor) driver;
        WebElement editprin = driver.findElement(By.xpath("//*[@id='principal_-1']"));
        editPrincipal.executeScript("arguments[0].click();", editprin);
        Thread.sleep(2000);

        //Enter DOB
        driver.findElement(By.id("dob")).sendKeys("01/04/1991");
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys("01/04/1991");
        Thread.sleep(2000);

        //Select Nationality
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement nationality = driver.findElement(By.xpath("//*[@id='add-edit-principal']/div[1]/div[9]/div/div[1]/div[1]/label"));
        js.executeScript("arguments[0].click();", nationality);
        Thread.sleep(2000);

        //Select Principal Address
        JavascriptExecutor princiAdd = (JavascriptExecutor) driver;
        WebElement manuenterPricipalAddress = driver.findElement(By.xpath("//*[@id='CurrentAddressContainer']/div[1]/div/a"));
        princiAdd.executeScript("arguments[0].click();", manuenterPricipalAddress);
        Thread.sleep(3000);
        driver.findElement(By.id("currentAddressLine1")).sendKeys("3010 Loveday Road");
        driver.findElement(By.id("currentAddressLine2")).sendKeys("High Street");
        driver.findElement(By.id("currentAddressTown")).sendKeys("London");
        driver.findElement(By.id("currentAddressCounty")).sendKeys("Middlesex");
        driver.findElement(By.id("currentAddressPostcode")).sendKeys("TW80GB");
        driver.findElement(By.id("currentAddressCountry")).sendKeys("United Kingdom");
        Thread.sleep(3000);

        //Time at current address:
        driver.findElement(By.id("timeAtCurrentAddressYear")).sendKeys("5");
        driver.findElement(By.id("timeAtCurrentAddressYear")).clear();
        driver.findElement(By.id("timeAtCurrentAddressYear")).sendKeys("5");
        driver.findElement(By.id("timeAtCurrentAddressMonth")).sendKeys("10");
        driver.findElement(By.id("timeAtCurrentAddressMonth")).clear();
        driver.findElement(By.id("timeAtCurrentAddressMonth")).sendKeys("10");
        Thread.sleep(3000);

        //Save Principal
        JavascriptExecutor saveprincipal1 = (JavascriptExecutor) driver;
        WebElement saveprincipal2 = driver.findElement(By.xpath("//*[@id='btnSavePrincpal']"));
        saveprincipal1.executeScript("arguments[0].click();", saveprincipal2);
        Thread.sleep(2000);
//      driver.findElement(By.xpath("//*[@id='btnSavePrincpal']")).click();
//      Thread.sleep(10000);

        //CLick on Continue
        JavascriptExecutor contiOnPrinci1 = (JavascriptExecutor) driver;
        WebElement contiOnPrinci2 = driver.findElement(By.xpath("//*[@id='PrincipalsDivContainer']/div/input[2]"));
        contiOnPrinci1.executeScript("arguments[0].click();", contiOnPrinci2);
        Thread.sleep(2000);
    }

    @Then(("add details about your goods and services"))
    public void add_details_about_your_goods_and_services() throws InterruptedException {
        //Are the goods or services to be sold or supplied, owned or to be provided by a third party?
        driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[1]/label[2]")).click();
        Thread.sleep(1000);

        //Do you hold stock at any address other than your trading address(es)?
        driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[2]/label[2]")).click();
        Thread.sleep(1000);

        //Do you accept deposits prior to the supply of goods or services?
        driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[4]/label[2]")).click();
        Thread.sleep(1000);

        //Do you accept full payment prior to the supply of goods or services?
        //driver.findElement(By.xpath("")).click();

        JavascriptExecutor supplyofgood1 = (JavascriptExecutor) driver;
        WebElement supplyofgood2 = driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[6]/label[2]"));
        supplyofgood1.executeScript("arguments[0].click();", supplyofgood2);
        Thread.sleep(1000);

        //Do you levy a charge for any guarantees or extended warranties?
        JavascriptExecutor guarantee = (JavascriptExecutor) driver;
        WebElement guarantees = driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[8]/label[2]"));
        guarantee.executeScript("arguments[0].click();", guarantees);
        Thread.sleep(2000);

        //Do you levy a charge for memberships, subscriptions or insurance premiums?
        JavascriptExecutor premiums = (JavascriptExecutor) driver;
        WebElement premium = driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[10]/label[2]"));
        premiums.executeScript("arguments[0].click();", premium);
        Thread.sleep(2000);

        //Click on Continue
        JavascriptExecutor conti = (JavascriptExecutor) driver;
        WebElement continuebutton = driver.findElement(By.xpath("//*[@id='btnGoodAnServices']"));
        conti.executeScript("arguments[0].click();", continuebutton);
        Thread.sleep(5000);
    }

    @Then(("add outlet details as {string}"))
    public void add_outlet_details_as(String tradingName) throws InterruptedException {
        System.out.println("Step - Outlet details");
        JavascriptExecutor outlet = (JavascriptExecutor) driver;
        WebElement addoutlet = driver.findElement(By.xpath("//*[@id='add-outlet-button']"));
        outlet.executeScript("arguments[0].click();", addoutlet);
        Thread.sleep(5000);

        //Enter Trading Name
        //driver.findElement(By.xpath("//*[@id='tradingName']")).sendKeys("E2E Zee");
        driver.findElement(By.xpath("//*[@id='tradingName']")).sendKeys(tradingName);


        WebElement tradingNamefield = driver.findElement(By.xpath("//*[@id='tradingName']"));
        tradingNamefield.sendKeys(Keys.TAB);

        //Select Trading address
        WebElement selectTradeAddress = driver.findElement(By.xpath("//*[@id='vs1__combobox']/div[1]/input"));
        selectTradeAddress.sendKeys(Keys.ARROW_DOWN);
        selectTradeAddress.sendKeys(Keys.ARROW_DOWN);
        selectTradeAddress.sendKeys(Keys.ARROW_DOWN);
        selectTradeAddress.sendKeys(Keys.ENTER);

        //Which card machines would you like at this outlet?
        JavascriptExecutor addtooutlet = (JavascriptExecutor) driver;
        WebElement addoutlets = driver.findElement(By.xpath("//*[@id='add-outlet-container']/div[3]/div/div/div[2]/div/label[2]"));
        addtooutlet.executeScript("arguments[0].click();", addoutlets);
        Thread.sleep(5000);

        //Save the Outlet
        JavascriptExecutor saveoutlet = (JavascriptExecutor) driver;
        WebElement save = driver.findElement(By.xpath("//*[@id='add-outlet-container']/div[4]/div[1]/button"));
        saveoutlet.executeScript("arguments[0].click();", save);
        Thread.sleep(5000);

        //Click on Continue
        JavascriptExecutor contionOutlet = (JavascriptExecutor) driver;
        WebElement continuebuttononOutlet = driver.findElement(By.name("nextBtn"));
        contionOutlet.executeScript("arguments[0].click();", continuebuttononOutlet);

        // driver.findElement(By.name("nextBtn")).click();
        Thread.sleep(5000);
    }

    @Then(("add contact details"))
    public void add_contact_details() throws InterruptedException {
        //Expand the Contact Detail Panel
        JavascriptExecutor contactDetailpanel = (JavascriptExecutor) driver;
        WebElement contactDetailpanelID = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[3]/div/div[1]/button"));
        contactDetailpanel.executeScript("arguments[0].click();", contactDetailpanelID);

        //Select the Contacts
        WebElement selectContact = driver.findElement(By.xpath("//*[@id='vs1__combobox']/div[1]/input"));
        selectContact.sendKeys(Keys.ARROW_DOWN);
        selectContact.sendKeys(Keys.ARROW_DOWN);
        selectContact.sendKeys(Keys.ENTER);

        //Public facing contact details
        JavascriptExecutor pubfacing1 = (JavascriptExecutor) driver;
        WebElement pubfacing2 = driver.findElement(By.xpath("//*[@id='AddEditForm']/div[2]/div[2]/div[8]/div[2]/label[2]"));
        pubfacing1.executeScript("arguments[0].click();", pubfacing2);
        Thread.sleep(5000);


        //Select Save Details
        JavascriptExecutor saveContactDetails = (JavascriptExecutor) driver;
        WebElement saveContact = driver.findElement(By.xpath("//*[@id='saveButton']"));
        saveContactDetails.executeScript("arguments[0].click();", saveContact);
        Thread.sleep(5000);
    }

    @Then(("add settlement bank account"))
    public void add_settlement_bank_account() throws InterruptedException {
        //Select Bank Details for Settlement
        JavascriptExecutor bankdetailpanel = (JavascriptExecutor) driver;
        WebElement bankdetailpanel2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[4]/div/div/div[1]/button"));
        bankdetailpanel.executeScript("arguments[0].click();", bankdetailpanel2);

        //Enter Sort Code and Account Number
        driver.findElement(By.id("SortCodeFirst")).sendKeys("08");
        driver.findElement(By.id("SortCodeSecond")).sendKeys("32");
        driver.findElement(By.id("SortCodeThird")).sendKeys("10");
        driver.findElement(By.id("AccountNumber")).sendKeys("12001038");

        //Lookup Account
        JavascriptExecutor lookupAcc1 = (JavascriptExecutor) driver;
        WebElement lookupAcc2 = driver.findElement(By.xpath("//*[@id='lookUpButton']"));
        lookupAcc1.executeScript("arguments[0].click();", lookupAcc2);
        Thread.sleep(5000);

        //Confirm the Bank Account
        JavascriptExecutor confirmAcc1 = (JavascriptExecutor) driver;
        WebElement confirmAcc2 = driver.findElement(By.xpath("//*[@id='main-content']/div[3]/div/div[4]/div/div[4]/div/div/div[2]/div[2]/button"));
        confirmAcc1.executeScript("arguments[0].click();", confirmAcc2);
        Thread.sleep(5000);
        //Enter Bank Name
        //driver.findElement(By.id("BankName")).sendKeys("Bank Name");

        //Select the Name on the Bank Account
        driver.findElement(By.xpath("//*[@id='outer-circle']")).click();
        Thread.sleep(2000);

        //authorise Direct Debit payments - NO TO Direct Debit
        JavascriptExecutor notoDD1 = (JavascriptExecutor) driver;
        WebElement notoDD2 = driver.findElement(By.xpath("//*[@id='AddEditForm']/div[2]/div[1]/div[3]/div[4]/div[1]/div/label[2]"));
        notoDD1.executeScript("arguments[0].click();", notoDD2);
        Thread.sleep(3000);

        //Save the Details
        JavascriptExecutor saveBankAcc1 = (JavascriptExecutor) driver;
        WebElement saveBankAcc2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[4]/div/div[1]/div[2]/div[2]/button[1]"));
        saveBankAcc1.executeScript("arguments[0].click();", saveBankAcc2);
        Thread.sleep(3000);

    }

    //Add bank details for charges


    //add delivery details
    @Then(("add delivery details"))
    public void add_delivery_details() throws InterruptedException {
        //Click on the Add delivery details panel
        JavascriptExecutor deliverydetailspanel1 = (JavascriptExecutor) driver;
        WebElement deliverydetailspanel2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[6]/div/div[1]/button"));
        deliverydetailspanel1.executeScript("arguments[0].click();", deliverydetailspanel2);
        Thread.sleep(3000);

        //Save Delivery Details
        JavascriptExecutor savedeliverydetail1 = (JavascriptExecutor) driver;
        WebElement savedeliverydetail2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[6]/div/div/div[2]/div[3]/button[1]"));
        savedeliverydetail1.executeScript("arguments[0].click();", savedeliverydetail2);
        Thread.sleep(3000);
    }

    //Click on continue button on step 6
    @Then(("clicks on continue button on step 6"))
    public void clicks_on_continue_button_on_step_6() throws InterruptedException {

        JavascriptExecutor continuestep1 = (JavascriptExecutor) driver;
        WebElement continuestep2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[4]/form/div/input[2]"));
        continuestep1.executeScript("arguments[0].click();", continuestep2);
        Thread.sleep(3000);
    }

    //user is on the Service requirements
    @Then(("user is on the Service requirements"))
    public void user_is_on_the_Service_requirements() throws InterruptedException {

        //Would you like to process card payments over the telephone using your Card Machine (Card Not Present transactions)?
        driver.findElement(By.xpath("//*[@id='terminal-config-form']/div[1]/div/label[2]")).click();
        Thread.sleep(3000);

        //Would you like to process cashback on purchases made with debit cards on your Card Machine (Purchase With Cashback transactions)?
        driver.findElement(By.xpath("//*[@id='terminal-config-form']/div[3]/div/label[2]")).click();
        Thread.sleep(3000);

        //Please tick to confirm you have read and agree to the Internet connection requirements.
        JavascriptExecutor readagreement1 = (JavascriptExecutor) driver;
        WebElement readagreement2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/form/div[5]/div/div/label"));
        readagreement1.executeScript("arguments[0].click();", readagreement2);
        Thread.sleep(3000);

        //Click Continue button - /html/body/div[1]/div[3]/div[3]/form/div[6]/input[2]
        JavascriptExecutor continuebuttonstep7_1 = (JavascriptExecutor) driver;
        WebElement continuebuttonstep7_2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/form/div[6]/input[2]"));
        continuebuttonstep7_1.executeScript("arguments[0].click();", continuebuttonstep7_2);
        Thread.sleep(3000);
    }

    //user is on the Acceptance page
    @Then(("user is on the Acceptance page"))
    public void user_is_on_the_Acceptance_page() throws InterruptedException {

        //Worldpay Application Form
        JavascriptExecutor checkbox1_1 = (JavascriptExecutor) driver;
        WebElement checkbox1_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/ul/li[1]/label"));
        checkbox1_1.executeScript("arguments[0].click();", checkbox1_2);
        Thread.sleep(3000);

        //Worldpay Outlet Form
        JavascriptExecutor checkbox2_1 = (JavascriptExecutor) driver;
        WebElement checkbox2_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/ul/li[2]/label"));
        checkbox2_1.executeScript("arguments[0].click();", checkbox2_2);
        Thread.sleep(3000);

        //Hire Agreement
        JavascriptExecutor checkbox3_1 = (JavascriptExecutor) driver;
        WebElement checkbox3_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/ul/li[3]/label"));
        checkbox3_1.executeScript("arguments[0].click();", checkbox3_2);
        Thread.sleep(3000);

        //Principal Document
        JavascriptExecutor checkbox4_1 = (JavascriptExecutor) driver;
        WebElement checkbox4_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/ul/li[4]/label"));
        checkbox4_1.executeScript("arguments[0].click();", checkbox4_2);
        Thread.sleep(3000);

        //Worldpay T&C
        JavascriptExecutor checkbox5_1 = (JavascriptExecutor) driver;
        WebElement checkbox5_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/ul/li[5]/label"));
        checkbox5_1.executeScript("arguments[0].click();", checkbox5_2);
        Thread.sleep(3000);

        //Tick to confirm - 1
        JavascriptExecutor checkbox6_1 = (JavascriptExecutor) driver;
        WebElement checkbox6_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/div[3]/div[2]/label"));
        checkbox6_1.executeScript("arguments[0].click();", checkbox6_2);
        Thread.sleep(3000);

        //Tick to confirm - 2
        JavascriptExecutor checkbox7_1 = (JavascriptExecutor) driver;
        WebElement checkbox7_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/div[4]/div[2]/label"));
        checkbox7_1.executeScript("arguments[0].click();", checkbox7_2);
        Thread.sleep(3000);

        //I understand from j4 to nap(radu) to
        JavascriptExecutor checkbox8_1 = (JavascriptExecutor) driver;
        WebElement checkbox8_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/div[5]/div[2]/label"));
        checkbox8_1.executeScript("arguments[0].click();", checkbox8_2);
        Thread.sleep(3000);

        //Keeping you informed
        JavascriptExecutor checkbox9_1 = (JavascriptExecutor) driver;
        WebElement checkbox9_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/div[6]/label"));
        checkbox9_1.executeScript("arguments[0].click();", checkbox9_2);
        Thread.sleep(3000);

        //Confirm Acceptance
        JavascriptExecutor checkbox10_1 = (JavascriptExecutor) driver;
        WebElement checkbox10_2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[3]/div[2]/form/div[7]/input"));
        checkbox10_1.executeScript("arguments[0].click();", checkbox10_2);
        Thread.sleep(3000);
    }
    @Then(("screen shot is captured"))
    public void screen_shot_is_captured() throws InterruptedException, IOException {
        //Capture CSR of the application and store in a Variable
        WebElement appCSR = driver.findElement(By.id("application-reference"));
        String csr = appCSR.getAttribute("value");
        System.out.println(appCSR.getAttribute("value"));

        //Capture Screen shot
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        //Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        //Path to the location to save screenshot
        FileUtils.copyFile(source, new File("C:/Users/E5618594/IdeaProjects/OLS/screenshot/sole-trader-"+csr+".png"));
        System.out.println("Screenshot is captured");
        Thread.sleep(5000);
    }

    //User clicks on I'm ready to upload
    @Then(("user goes to upload image page"))
    public void user_goes_to_upload_image_page() throws InterruptedException {
        JavascriptExecutor ready1 = (JavascriptExecutor) driver;
        WebElement ready2 = driver.findElement(By.xpath("//*[@id='btnContinue']"));
        ready1.executeScript("arguments[0].click();", ready2);
        Thread.sleep(10000);
    }

    //User is on the Upload image page
    @Then(("user is on image upload page"))
    public void user_is_on_image_upload_page() throws InterruptedException, IOException {

        //Click on + Button
        JavascriptExecutor plusbutton1 = (JavascriptExecutor) driver;
        WebElement plusbutton2 = driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/form/div[1]/div[3]/div[2]/div/div[2]/label"));
        plusbutton1.executeScript("arguments[0].click();", plusbutton2);
        Thread.sleep(5000);

        Thread.sleep(5000);

        //Click submit after upload image
        JavascriptExecutor submitImage1 = (JavascriptExecutor) driver;
        WebElement submitImage2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[1]/div[1]/div[3]/input"));
        submitImage1.executeScript("arguments[0].click();", submitImage2);
        Thread.sleep(5000);

        //Click Continue after upload image
        JavascriptExecutor con1 = (JavascriptExecutor) driver;
        WebElement con2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[2]/input"));
        con1.executeScript("arguments[0].click();", con2);
        Thread.sleep(10000);
        driver.close();
    }
}