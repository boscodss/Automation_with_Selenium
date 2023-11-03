package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hookTest {

    WebDriver driver = null;

    @Before
    public void setUp(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //System.setProperty("webdriver.chrome.driver", "C:/Users/E5618594/IdeaProjects/OLS/src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().driverVersion("117.0.5938.132").setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    @Given("^user navigates to Facebook$")
    public void goToFacebook() {
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[2]")).click();
    }

    @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void I_enter_Username_as_and_Password_as(String arg1, String arg2) {
        driver.findElement(By.id("email")).sendKeys(arg1);
        driver.findElement(By.id("pass")).sendKeys(arg2);
        driver.findElement(By.name("login")).click();
    }

    @Then("^login should be unsuccessful$")
    public void validateRelogin() {
        if(driver.getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }

    @After
    public void cleanUp(){
        driver.close();
    }

}
