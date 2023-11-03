package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Login {

    WebDriver driver;

    @Given("Open the Test Login Page")
    public void Open_the_Test_Login_Page() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //System.setProperty("webdriver.chrome.driver", "C:/Users/E5618594/IdeaProjects/OLS/src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().driverVersion("117.0.5938.132").setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        //driver.findElement(By.id("L2AGLb")).click();
    }

    @Given("User enters Username as {string}")
    public void Enter_search_term(String username) throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);
    }

    @And("User enters Password as {string}")
    public void User_enters_Password_as(String password) throws InterruptedException {
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
    }

    @And("User clicks on Submit button")
    public void User_clicks_on_Submit_button() throws InterruptedException {
        driver.findElement(By.id("submit")).click();
    }

    @Then("message is shown {string}")
    public void message_is_shown() throws InterruptedException {
        String expectedCorrectMessage ="message";
        String actualCorrectMessage = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[1]/h1")).getText();
        Assert.assertEquals(expectedCorrectMessage, actualCorrectMessage);
    }
  }