package Domaci.Domaci_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BlankUsernameTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        // Bice prazan username i tacan password

        WebElement practiceMenuItem = driver.findElement(By.id("menu-item-20"));
        practiceMenuItem.click();

        WebElement testLoginLink = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a"));
        testLoginLink.click();

        WebElement username = driver.findElement(By.id("username"));
        Assert.assertEquals("", username.getText());

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());

        String errorMsg = "Your username is invalid!";
        Assert.assertEquals(error.getText(), errorMsg);
    }
}
