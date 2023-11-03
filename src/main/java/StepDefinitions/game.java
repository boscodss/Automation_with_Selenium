package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class game {

    WebDriver driver;

    @Given("website is open")
    public void website_is_open() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //System.setProperty("webdriver.chrome.driver", "C:/Users/E5618594/IdeaProjects/OLS/src/main/resources/driver/chromedriver.exe");
        WebDriverManager.chromedriver().driverVersion("117.0.5938.132").setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://keytodatascience.com/games/");
     }

    @And("User clicks on Start")
    public void User_clicks_on_Start() throws InterruptedException {
        driver.findElement(By.id("btnRestart")).click();
        Thread.sleep(2000);
    }

    @And("User clicks on numbers")
    public void User_clicks_on_numbers() throws InterruptedException {
       // driver.findElement(By.linkText("1")).click();
        //driver.findElement(By.xpath("//*[contains(text(), '11')]")).click();

        driver.findElement(By.xpath("//*[text()='1']")).click();
        driver.findElement(By.xpath("//*[text()='2']")).click();
        driver.findElement(By.xpath("//*[text()='3']")).click();
        driver.findElement(By.xpath("//*[text()='4']")).click();
        driver.findElement(By.xpath("//*[text()='5']")).click();
        driver.findElement(By.xpath("//*[text()='6']")).click();
        driver.findElement(By.xpath("//*[text()='7']")).click();
        driver.findElement(By.xpath("//*[text()='8']")).click();
        driver.findElement(By.xpath("//*[text()='9']")).click();
        driver.findElement(By.xpath("//*[text()='10']")).click();
        driver.findElement(By.xpath("//*[text()='11']")).click();
        driver.findElement(By.xpath("//*[text()='12']")).click();
        driver.findElement(By.xpath("//*[text()='13']")).click();
        driver.findElement(By.xpath("//*[text()='14']")).click();
        driver.findElement(By.xpath("//*[text()='15']")).click();
        driver.findElement(By.xpath("//*[text()='16']")).click();
        driver.findElement(By.xpath("//*[text()='17']")).click();
        driver.findElement(By.xpath("//*[text()='18']")).click();
        driver.findElement(By.xpath("//*[text()='19']")).click();
        driver.findElement(By.xpath("//*[text()='20']")).click();
        driver.findElement(By.xpath("//*[text()='21']")).click();
        driver.findElement(By.xpath("//*[text()='22']")).click();
        driver.findElement(By.xpath("//*[text()='23']")).click();
        driver.findElement(By.xpath("//*[text()='24']")).click();
        driver.findElement(By.xpath("//*[text()='25']")).click();
        driver.findElement(By.xpath("//*[text()='26']")).click();
        driver.findElement(By.xpath("//*[text()='27']")).click();
        driver.findElement(By.xpath("//*[text()='28']")).click();
        driver.findElement(By.xpath("//*[text()='29']")).click();
        driver.findElement(By.xpath("//*[text()='30']")).click();
        driver.findElement(By.xpath("//*[text()='31']")).click();
        driver.findElement(By.xpath("//*[text()='32']")).click();
        driver.findElement(By.xpath("//*[text()='33']")).click();
        driver.findElement(By.xpath("//*[text()='34']")).click();
        driver.findElement(By.xpath("//*[text()='35']")).click();
        driver.findElement(By.xpath("//*[text()='36']")).click();
        driver.findElement(By.xpath("//*[text()='37']")).click();
        driver.findElement(By.xpath("//*[text()='38']")).click();
        driver.findElement(By.xpath("//*[text()='39']")).click();
        driver.findElement(By.xpath("//*[text()='40']")).click();
        driver.findElement(By.xpath("//*[text()='41']")).click();
        driver.findElement(By.xpath("//*[text()='42']")).click();
        driver.findElement(By.xpath("//*[text()='43']")).click();
        driver.findElement(By.xpath("//*[text()='44']")).click();
        driver.findElement(By.xpath("//*[text()='45']")).click();
        driver.findElement(By.xpath("//*[text()='46']")).click();
        driver.findElement(By.xpath("//*[text()='47']")).click();
        driver.findElement(By.xpath("//*[text()='48']")).click();
        driver.findElement(By.xpath("//*[text()='49']")).click();
        driver.findElement(By.xpath("//*[text()='50']")).click();
        Thread.sleep(2000);
    }
  }