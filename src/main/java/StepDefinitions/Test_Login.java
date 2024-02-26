package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_Login {

    WebDriver driver;

    @Given("User is on the login page")
    public void I_navigate_to_the_Website() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //System.setProperty("webdriver.chrome.driver", "C:/Users/E5618594/IdeaProjects/OLS/src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().driverVersion("119.0.6045.160").setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        //WebDriverManager.chromedriver().clearResolutionCache().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
    }

    @Given("User inserts valid username {string}")
    public void user_inserts_valid_username(String username) throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);
    }

    @Given("User inserts valid password {string}")
    public void user_inserts_valid_password(String password) throws InterruptedException {
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
    }

    @When("User clicks on submit button")
    public void user_clicks_on_submit_button() throws InterruptedException {
        driver.findElement(By.className("btn")).click();
        Thread.sleep(2000);
    }

    @Then("User is logged in")
    public void user_is_logged_in() {
       //String title = driver.findElement(By.className("post-title")).getText();
//       System.out.println(title);
//       Assert.assertEquals("Liogged In Successfully", title);
//        if(driver.findElement(By.className("post-title")).getText().equalsIgnoreCase("Logged In Successfully"))
//        {
//            System.out.println("Test Pass");
//        }
//        else {
//            System.out.println("Test Fail");
//        }
        System.out.println("Logged in");
        String ActualTitle = driver.findElement(By.className("post-title")).getText();
        String ExpectedTitle = "Logged In Successfully";
        assertEquals(ActualTitle,ExpectedTitle);
        assertTrue(ActualTitle,true);
        driver.close();

    }
}