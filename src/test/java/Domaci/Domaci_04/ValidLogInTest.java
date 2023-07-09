package Domaci.Domaci_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidLogInTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        String username = "admin";
        String password = "admin";

        WebElement basicAuth = driver.findElement(By.linkText("Basic Auth"));
        basicAuth.click();

        String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement title = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String expectedTitle = "Basic Auth";
        Assert.assertEquals(title.getText(), expectedTitle);

        WebElement message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        Assert.assertEquals(message.getText(), expectedMessage);
    }
}
