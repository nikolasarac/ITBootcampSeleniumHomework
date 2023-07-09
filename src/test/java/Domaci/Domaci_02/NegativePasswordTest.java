package Domaci.Domaci_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NegativePasswordTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        // Bice unet tacan username i netacan password

        WebElement practiceMenuItem = driver.findElement(By.id("menu-item-20"));
        practiceMenuItem.click();

        WebElement testLoginLink = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a"));
        testLoginLink.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword ");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        WebElement error = driver.findElement(By.id("error"));
        Thread.sleep(2000);
        Assert.assertTrue(error.isDisplayed());

        String errorMsg = "Your password is invalid!";
        Assert.assertEquals(error.getText(), errorMsg);
    }
}
