package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class Seller {

    WebDriver driver;

    @Given("seller is on the sign up page")
    public void user_is_on_the_sign_up_page() throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://apply-online-featuretest.worldpay.com/");

        //Click on Cookie Pref
        driver.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div/div[2]/button[3]")).click();
        //driver.navigate().to("https://apply-online-test.worldpay.com/"); AccessWorldpay Test
        driver.findElement(By.xpath("//*[@id='header-right-content']/div/div[1]/a")).click();
        driver.manage().window().maximize();
// This section is for headless
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options=new ChromeOptions();
//        options.setCapability("browserVersion", "119.0.6045.124");
//        options.addArguments("headless");
//        driver=new ChromeDriver(options);
//        driver.get("https://apply-online-featuretest.worldpay.com/");
//        //driver.get("https://apply-online-test.worldpay.com/");
//        Thread.sleep(2000);
    }

    //Seller Signs in
    @Then("seller signs in")
    public void seller_signs_in() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='LoginViewModel_Email']")).sendKeys("bosco.dsouza+SMB@fisglobal.com");
        driver.findElement(By.xpath("//*[@id='LoginViewModel_Password']")).sendKeys("Tango@1977");
        Thread.sleep(5000);
        driver.findElement(By.id("loginbtn")).click();
        Thread.sleep(5000);
        System.out.println("Seller is Successfully Logged in");
    }

    @Then("seller clicks on start new application")
    public void seller_clicks_on_start_new_application() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='main-content']/div[1]/div/a")).click();
        Thread.sleep(5000);
        System.out.println("Seller has clicked on the start new application");
    }

    //Seller enters customer email address and searches
    @Then("seller enters Customers Email Address as {string}")
    public void seller_enters_Customers_Email_Address(String customer_email) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys(customer_email);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='submit-container']/input")).click();
        Thread.sleep(2000);
        System.out.println("Seller has entered email address");
    }

    @Given("seller enters first name as {string}")
    public void seller_enters_first_name_as(String firstname) {
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys(firstname);
        System.out.println("Seller has entered  First Name");

    }

    @Given("seller enters last name as {string}")
    public void seller_enters_last_name_as(String lastname) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys(lastname);
        System.out.println("Seller has entered Last Name");
        Thread.sleep(2000);
    }

    @Given("seller enters contact number as {string}")
    public void seller_enters_contact_number_as(String phone) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='TelephoneNumber']")).sendKeys(phone);
        System.out.println("Seller has entered Phone");
        Thread.sleep(2000);
    }

    @When("seller clicks on create account button")
    public void seller_clicks_on_create_account_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='submit-container']/input")).click();
        System.out.println("Seller has entered Clicked Registration button");
        Thread.sleep(5000);
    }

    //Seller selects Campaign and Starts Application
    @When("seller selects campaign")
    public void seller_selects_campaign() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='SelectedCampaignId']/option[2]")).click();
        Thread.sleep(2000);
        System.out.println("Seller has Selected Campaign AccessWorldpay Test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='submit-container']/input")).click();
        Thread.sleep(2000);
    }

    //NO - Would you like to hear more from our partner Liberis ltd. about this?
    @Then("seller select noThanks")
    public void seller_select_noThanks() throws InterruptedException {
        JavascriptExecutor noThanksbuttonjse = (JavascriptExecutor) driver;
        noThanksbuttonjse.executeScript("scroll(0, 2000)");
        driver.findElement(By.xpath("//*[@id='additionalServices']/div[2]/div/div[4]/div/div[3]/label")).click();
        Thread.sleep(2000);
    }

    @When("seller selects product")
    public void seller_selects_product() throws InterruptedException {
        //Please help us identify your business type. 1
        Select mcc1 = new Select(driver.findElement(By.id("SelectedMCCSelectorTier1Id")));
        mcc1.selectByIndex(2);
        Thread.sleep(2000);

        //Please help us identify your business type. 2
        Select mcc2 = new Select(driver.findElement(By.id("SelectedMCCSelectorTier2Id")));
        mcc2.selectByIndex(2);
        Thread.sleep(2000);

        //In a few words, please describe the products or services that your business offers.
        driver.findElement(By.id("FurtherBusinessInfo")).sendKeys("My business");
        Thread.sleep(2000);

        //What is your annual turnover?
        driver.findElement(By.id("annualTurnover")).sendKeys("50000");
        Thread.sleep(2000);

        //What percentage of your annual turnover is taken by card?
        driver.findElement(By.id("cardPercentage")).sendKeys("5");
        Thread.sleep(2000);

        //What is your average card transaction value?
        driver.findElement(By.id("averageTransactionValue")).sendKeys("500");
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement UKYes = driver.findElement(By.id("HasUKBankAccount_Yes"));
        js.executeScript("arguments[0].click();", UKYes);
        Thread.sleep(2000);
        WebElement prowithApp = driver.findElement(By.id("btnContinue"));
        js.executeScript("arguments[0].click();", prowithApp);
        Thread.sleep(5000);
    }

    @Then("seller is on Choose your pricing plan")
    public void seller_is_on_Choose_your_pricing_plan() throws InterruptedException {
        JavascriptExecutor chooseplan1 = (JavascriptExecutor) driver;
        WebElement chooseplan2 = driver.findElement(By.xpath("//*[@id='select_SMBECOMUK_1']"));
        chooseplan1.executeScript("arguments[0].click();", chooseplan2);
        Thread.sleep(2000);
        System.out.println("Selected Simplicity Price Plan");
        Thread.sleep(20000);
    }

    //SELECT NO OR YES TO AMEX
    @And("seller selects no to amex")
    public void seller_selects_no_to_amex() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //No To Amex
//        WebElement noToAmex = driver.findElement(By.xpath("//*[@id='sales-quote-amex-buttons']/div[2]/label"));
//        js.executeScript("arguments[0].click();", noToAmex);
//        Thread.sleep(2000);
//        System.out.println("Selected No to Amex Card");


        //Yes To Amex
        WebElement yesToAmex = driver.findElement(By.xpath("//*[@id='sales-quote-amex-buttons']/div[1]/label"));
        js.executeScript("arguments[0].click();", yesToAmex);
        Thread.sleep(2000);
        System.out.println("Selected Yes to Amex Card");
    }

    @Then("seller click on proceed with online application")
    public void seller_click_on_proceed_with_online_application() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement apply = driver.findElement(By.name("apply"));
        js.executeScript("arguments[0].click();", apply);
        Thread.sleep(2000);
        System.out.println("Selected Proceed with online application");
    }

    @And("seller clicks on lets start")
    public void seller_clicks_on_lets_start() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement start = driver.findElement(By.name("start"));
        js.executeScript("arguments[0].click();", start);
        System.out.println("Selected Lets get started");
        Thread.sleep(2000);
    }

    //User is on the 1st Step of the Application

    @And("seller CSR is shown")
    public void seller_CSR_is_shown() throws InterruptedException {
        String csrNumber = driver.findElement(By.id("application-reference")).getText();
        System.out.println(csrNumber);
        System.out.println("CSR is shown");
        Thread.sleep(2000);
    }

    //Select Sole Trader
    @Then("seller select legal entity")
    public void seller_select_legal_entity() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement legalEntity = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[1]/div/div[1]/div[1]/label"));
        js.executeScript("arguments[0].click();", legalEntity);
        Thread.sleep(2000);
    }

    //Select Country of incorporation
    @Then("seller select Country of incorporation")
    public void seller_select_Country_of_incorporation() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement counOfInco = driver.findElement(By.id("rb_CountryOfIncorporation_SelectedItemId_1"));
        js.executeScript("arguments[0].click();", counOfInco);
        Thread.sleep(2000);

        //Select which part of the Country - England
        WebElement incorpIN = driver.findElement(By.id("rb_RegionsOfCountry_SelectedItemId_1"));
        js.executeScript("arguments[0].click();", incorpIN);
    }

    //Select Date of Commenced Trading
    @Then("seller enter date of commence trading")
    public void seller_enter_date_of_commence_trading() throws InterruptedException {
        driver.findElement(By.id("CommencedTradingMonth")).sendKeys("5");
        Thread.sleep(2000);
        driver.findElement(By.id("CommencedTradingYear")).sendKeys("2010");
        Thread.sleep(2000);
    }

    //Look up address
    @Then("seller enter business address")
    public void seller_enter_business_address() throws InterruptedException {

        //Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='addressSearchTerm']")).sendKeys("CB24 9ZR");
        Thread.sleep(5000);

        //Click on list of addresses displayed
        JavascriptExecutor listofAddress1 = (JavascriptExecutor) driver;
        //WebElement listofAddress2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/span"));
        WebElement listofAddress2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div"));
        listofAddress1.executeScript("arguments[0].click();", listofAddress2);
        Thread.sleep(5000);

        //Click on list of addresses displayed
        JavascriptExecutor selectAddress1 = (JavascriptExecutor) driver;
        WebElement selectAddress2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[5]"));
        selectAddress1.executeScript("arguments[0].click();", selectAddress2);
        Thread.sleep(5000);

//        driver.findElement(By.id("BusinessAddressLine2")).sendKeys("2 Address");
//        System.out.println("Manually entered Address");
//        Thread.sleep(2000);
    }

    //Is this address a residential or commercial property?
    @Then("seller select type of property")
    public void seller_select_type_of_property() throws InterruptedException {
        //Is this address a residential or commercial property?
        //driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='registeredAddressContainer']/div[2]/div[7]/label[2]")).click();
        Thread.sleep(2000);

        //Would you like to use this address for all application correspondence?
        driver.findElement(By.xpath("//*[@id='registeredIsCorrespondenceContainer']/div/label[1]")).click();
        Thread.sleep(2000);

        //Click on Save address
        driver.findElement(By.xpath("//*[@id='registeredAddressContainer']/div[2]/div[9]/button[2]")).click();
        Thread.sleep(2000);
    }

    //Does your company have a website?
    @Then("seller select company have website")
    public void seller_select_company_have_website() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor companyurlNo1 = (JavascriptExecutor) driver;
        WebElement companyurlNo2 = driver.findElement(By.xpath("//*[@id='CompanyWebsite']"));
        companyurlNo1.executeScript("arguments[0].click();", companyurlNo2);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='CompanyWebsite']")).sendKeys("www.worldpay.com");
    }

    //Do you advertise your business?
    @Then("seller select advertise business and enter details")
    public void seller_select_advertise_business_and_enter_details() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement website = driver.findElement(By.xpath("//*[@id='DoesCustomerAdvertiseLabel_No']"));
        js.executeScript("arguments[0].click();", website);
        Thread.sleep(2000);
        driver.findElement(By.id("HowDoesCustomerGenerateBusiness")).sendKeys("How do you generate business?");
        Thread.sleep(2000);
    }

    //Is your company VAT Registered?
    @Then("seller select Vat")
    public void seller_select_Vat() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement vatNoButton = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[13]/div/label[2]"));
        js.executeScript("arguments[0].click();", vatNoButton);
        Thread.sleep(2000);
    }

    //Are you new to taking card payments?
    @Then("seller select take card payments")
    public void seller_select_take_card_payments() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cardPaymentButtonNo = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[15]/div/label[2]"));
        js.executeScript("arguments[0].click();", cardPaymentButtonNo);
        Thread.sleep(2000);
    }

    //Written and verbal communication options
    @Then("seller select verbal comms")
    public void seller_select_verbal_comms() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement verbalCommButtonNo = driver.findElement(By.xpath("//*[@id='about-your-business-form']/div[18]/div/label[2]"));
        js.executeScript("arguments[0].click();", verbalCommButtonNo);
        Thread.sleep(2000);
    }

    //Click on Continue
    @Then("seller click continue")
    public void seller_click_continue() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement contButton = driver.findElement(By.id("btnBusiness"));
        js.executeScript("arguments[0].click();", contButton);
        Thread.sleep(2000);
    }

    //User is on the 2nd Step of the Application
    @Then(("seller capture CSR"))
    public void seller_capture_CSR() throws InterruptedException {
        String CSR = driver.findElement(By.id("application-reference")).getText();
        System.out.println(CSR);
        System.out.println("On Stage 2 of the Application");
        Thread.sleep(2000);
    }

    @Then(("seller capture contact details"))
    public void seller_capture_contact_details() throws InterruptedException {
        //click on Title
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        WebElement Title = driver.findElement(By.xpath("//*[@id='selectBoxTitleContainer']/div[1]/div[1]/label"));
        jst.executeScript("arguments[0].click();", Title);
        Thread.sleep(2000);

        //click on Position
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement soleTrader = driver.findElement(By.xpath("//*[@id='YourDetailsContainer']/div[3]/div/div[1]/div/label"));
        js.executeScript("arguments[0].click();", soleTrader);
        Thread.sleep(2000);

        //Select Country of residence
        driver.findElement(By.id("CountryOfResidence")).sendKeys("United Kingdom");
        Thread.sleep(2000);

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
    @Then(("seller add details of principal"))
    public void seller_add_details_of_principal() throws InterruptedException {

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
        Thread.sleep(10000);

        //Select Principal Address
        driver.findElement(By.name("loqate-address-lookup-search")).sendKeys("CB24 9ZR");
        Thread.sleep(10000);

        //Click on list of addresses displayed - addressLookupSole1
        JavascriptExecutor listofAddress1 = (JavascriptExecutor) driver;
        WebElement listofAddress2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/span"));
        listofAddress1.executeScript("arguments[0].click();", listofAddress2);
        Thread.sleep(10000);

        //Click on list of addresses displayed - addressLookupSole1
        JavascriptExecutor selectAddress1 = (JavascriptExecutor) driver;
        WebElement selectAddress2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[4]"));
        selectAddress1.executeScript("arguments[0].click();", selectAddress2);
        Thread.sleep(10000);

        //Time at current address:
        driver.findElement(By.id("timeAtCurrentAddressYear")).sendKeys("5");
        driver.findElement(By.id("timeAtCurrentAddressYear")).clear();
        driver.findElement(By.id("timeAtCurrentAddressYear")).sendKeys("5");
        driver.findElement(By.id("timeAtCurrentAddressMonth")).sendKeys("10");
        driver.findElement(By.id("timeAtCurrentAddressMonth")).clear();
        driver.findElement(By.id("timeAtCurrentAddressMonth")).sendKeys("10");
        Thread.sleep(2000);

        //Save Principal
        JavascriptExecutor saveprincipal1 = (JavascriptExecutor) driver;
        WebElement saveprincipal2 = driver.findElement(By.xpath("//*[@id='btnSavePrincpal']"));
        saveprincipal1.executeScript("arguments[0].click();", saveprincipal2);
        Thread.sleep(2000);

        //CLick on Continue
        JavascriptExecutor contiOnPrinci1 = (JavascriptExecutor) driver;
        WebElement contiOnPrinci2 = driver.findElement(By.xpath("//*[@id='PrincipalsDivContainer']/div/input[2]"));
        contiOnPrinci1.executeScript("arguments[0].click();", contiOnPrinci2);
        Thread.sleep(2000);
    }

    @Then(("seller add details about your goods and services"))
    public void seller_add_details_about_your_goods_and_services() throws InterruptedException {
        //Are the goods or services to be sold or supplied, owned or to be provided by a third party?
        driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[1]/label[2]")).click();
        Thread.sleep(1000);

        //Do you hold stock at any address other than your trading address(es)?
        driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[2]/label[2]")).click();
        Thread.sleep(1000);

        //Do you accept deposits prior to the supply of goods or services?
        driver.findElement(By.xpath("//*[@id='good-and-services-form']/div/div[4]/label[2]")).click();
        Thread.sleep(1000);

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
        Thread.sleep(2000);
    }

    @Then(("seller add outlet details as {string}"))
    public void seller_add_outlet_details_as(String tradingname) throws InterruptedException {
        System.out.println("Step - Outlet details");
        JavascriptExecutor outlet = (JavascriptExecutor) driver;
        WebElement addoutlet = driver.findElement(By.xpath("//*[@id='add-outlet-button']"));
        outlet.executeScript("arguments[0].click();", addoutlet);
        Thread.sleep(2000);

        //Enter Trading Name
        driver.findElement(By.xpath("//*[@id='tradingName']")).sendKeys(tradingname);
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
        Thread.sleep(2000);

        //Save the Outlet
        JavascriptExecutor saveoutlet = (JavascriptExecutor) driver;
        WebElement save = driver.findElement(By.xpath("//*[@id='add-outlet-container']/div[4]/div[1]/button"));
        saveoutlet.executeScript("arguments[0].click();", save);
        Thread.sleep(2000);

        //Click on Continue
        JavascriptExecutor contionOutlet = (JavascriptExecutor) driver;
        WebElement continuebuttononOutlet = driver.findElement(By.name("nextBtn"));
        contionOutlet.executeScript("arguments[0].click();", continuebuttononOutlet);
        Thread.sleep(2000);
    }

    @Then(("seller add contact details"))
    public void seller_add_contact_details() throws InterruptedException {
        //Expand the Contact Detail Panel
        JavascriptExecutor contactDetailpanel = (JavascriptExecutor) driver;
        WebElement contactDetailpanelID = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[3]/div/div[1]/button"));
        Thread.sleep(3000);
        contactDetailpanel.executeScript("arguments[0].click();", contactDetailpanelID);

        //Select the Contacts
        Thread.sleep(3000);
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
        Thread.sleep(3000);
        JavascriptExecutor saveContactDetails = (JavascriptExecutor) driver;
        WebElement saveContact = driver.findElement(By.xpath("//*[@id='saveButton']"));
        saveContactDetails.executeScript("arguments[0].click();", saveContact);
        Thread.sleep(3000);
    }

    @Then(("seller add settlement bank account"))
    public void seller_add_settlement_bank_account() throws InterruptedException {
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

    //add delivery details
    @Then(("seller add delivery details"))
    public void seller_add_delivery_details() throws InterruptedException {
        //Click on the Add delivery details panel
        JavascriptExecutor deliverydetailspanel1 = (JavascriptExecutor) driver;
        WebElement deliverydetailspanel2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[6]/div/div[1]/button"));
        deliverydetailspanel1.executeScript("arguments[0].click();", deliverydetailspanel2);
        Thread.sleep(2000);

        //Save Delivery Details
        JavascriptExecutor savedeliverydetail1 = (JavascriptExecutor) driver;
        WebElement savedeliverydetail2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div/div[6]/div/div/div[2]/div[3]/button[1]"));
        savedeliverydetail1.executeScript("arguments[0].click();", savedeliverydetail2);
        Thread.sleep(2000);
    }

    //Click on continue button on step 6
    @Then(("seller clicks on continue button on step 6"))
    public void seller_clicks_on_continue_button_on_step_6() throws InterruptedException {

        JavascriptExecutor continuestep1 = (JavascriptExecutor) driver;
        WebElement continuestep2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[4]/form/div/input[2]"));
        continuestep1.executeScript("arguments[0].click();", continuestep2);
        Thread.sleep(2000);
    }

    //user is on the Service requirements
    @Then(("seller is on the Service requirements"))
    public void user_is_on_the_Service_requirements() throws InterruptedException {

        //Would you like to provide any additional supporting information regarding this application
        JavascriptExecutor addsupportdocs1 = (JavascriptExecutor) driver;
        WebElement addsupportdocs2 = driver.findElement(By.xpath("//*[@id='terminal-config-form']/div[2]/label[2]"));
        addsupportdocs1.executeScript("arguments[0].click();", addsupportdocs2);
        Thread.sleep(2000);

        //Click Continue button - /html/body/div[1]/div[3]/div[3]/form/div[6]/input[2]
        JavascriptExecutor continuebuttonstep7_1 = (JavascriptExecutor) driver;
        WebElement continuebuttonstep7_2 = driver.findElement(By.xpath("//*[@id='btnTerminalConfig']"));
        continuebuttonstep7_1.executeScript("arguments[0].click();", continuebuttonstep7_2);
        Thread.sleep(2000);
    }

    //user is on the Acceptance page
    @Then(("seller clicks on hand over to customer"))
    public void seller_clicks_on_hand_over_to_customer() throws InterruptedException, IOException {

        //Capture CSR of the application and store in a Variable
        WebElement appCSR = driver.findElement(By.id("application-reference"));
        String csr = appCSR.getAttribute("value");
        System.out.println(appCSR.getAttribute("value"));

        //Capture Screen shot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        //Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        //Path to the location to save screenshot
        FileUtils.copyFile(source, new File("C:/Users/E5618594/IdeaProjects/OLS/screenshot/seller-" + csr + ".png"));
        System.out.println("Screenshot is captured");
        Thread.sleep(2000);

        //seller clicks on hand over to customer
        JavascriptExecutor handover_1 = (JavascriptExecutor) driver;
        WebElement handover_2 = driver.findElement(By.xpath("//*[@id='handoverContainer']/div[2]/div[2]/div/div/a"));
        handover_1.executeScript("arguments[0].click();", handover_2);
        Thread.sleep(2000);

        //seller clicks on Confirm button on the popup
        JavascriptExecutor confirm_1 = (JavascriptExecutor) driver;
        WebElement confirm_2 = driver.findElement(By.xpath("//*[@id='handoverConfirmBtn']"));
        confirm_1.executeScript("arguments[0].click();", confirm_2);
        Thread.sleep(4000);
        driver.close();
    }
}