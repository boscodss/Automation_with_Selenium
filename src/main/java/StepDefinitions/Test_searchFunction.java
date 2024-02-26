package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_searchFunction {

    WebDriver driver;

    @Given("Open site")
    public void Open_site() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //System.setProperty("webdriver.chrome.driver", "C:/Users/E5618594/IdeaProjects/OLS/src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().driverVersion("119.0.6045.160").setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.google.co.uk/");
        driver.findElement(By.id("L2AGLb")).click();
    }

    @And("Do login")
    public void do_login() {
        System.out.println("User is on Login");
    }

    @Given("Enter search term {string}")
    public void Enter_search_term(String searchterm) throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys(searchterm);
        Thread.sleep(5000);
    }

    @When("Do search")
    public void do_search() throws InterruptedException {
        driver.findElement(By.name("btnK")).submit();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/div/span")).click();
   }

    @Then("Single result is shown for {string}")
    public void single_result_is_shown_for(String searchterm) {
        System.out.println("Result shown for " + searchterm);
        driver.quit();
    }
}