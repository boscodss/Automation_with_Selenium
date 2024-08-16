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

public class fixing {

    WebDriver driver;

    @Given("seller is on the sign up page 2")
    public void user_is_on_the_sign_up_page_2() throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.navigate().to("https://apply-online-featuretest.worldpay.com/");

        Thread.sleep(5000);
        //Click on Cookie Pref
        JavascriptExecutor cookie = (JavascriptExecutor) driver;
        WebElement cookieYes = driver.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div/div[2]/button[3]"));
        cookie.executeScript("arguments[0].click();", cookieYes);
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div/div[2]/button[3]")).click();

       //driver.navigate().to("https://apply-online-test.worldpay.com/"); AccessWorldpay Test
        driver.findElement(By.xpath("//*[@id='header-right-content']/div/div[1]/a")).click();
        driver.manage().window().maximize();
    }

    //Seller Signs in
    @Then("seller signs in 2")
    public void seller_signs_in_2() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='LoginViewModel_Email']")).sendKeys("bosco.dsouza+SMB@fisglobal.com");
        driver.findElement(By.xpath("//*[@id='LoginViewModel_Password']")).sendKeys("Tango@1977");
        Thread.sleep(5000);
        driver.findElement(By.id("loginbtn")).click();
        Thread.sleep(5000);
        System.out.println("Seller is Successfully Logged in");
    }

    @Then("seller clicks on resume application")
    public void seller_clicks_on_resume_application() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='resumebtn']")).click();
        Thread.sleep(5000);
    }

    @Then("seller click on Details Verified")
    public void seller_click_on_Details_Verified() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id='detailsVerifiedWrapper']/label")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='verifyFormContainer']/form/div[2]/input")).click();
        Thread.sleep(5000);
    }

    @Then("seller expands the bank details for charges")
    public void seller_expands_the_bank_details_for_charges() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='add-bank-button-5423']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='AddEditForm']/div[2]/div[1]/div/label[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='AddEditForm']/div[2]/div[2]/div[4]/div[5]/div[1]/div/label[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='saveButton']")).click();

    }


}