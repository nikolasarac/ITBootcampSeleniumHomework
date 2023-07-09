package Domaci.Domaci_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQA {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");

        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im5pa3NhciIsInBhc3N3b3JkIjoiRDNtMHFhISEhIiwiaWF0IjoxNjg2MTYzNTIwfQ.kWqil7b_-H77qP3oyuvCpuXW9b_fS66U0lFokBzG-gg");
        Cookie expires = new Cookie("expires", "2023-06-14T18%3A45%3A20.026Z");
        Cookie userID = new Cookie("userID", "cf763ad5-7c37-47b7-b87f-17f2572c42ce");
        Cookie userName = new Cookie("userName", "niksar");
        //Cookie gads = new Cookie("__gads", "ID=16230ccb6574af56-2201ad2d40e10009:T=1686089131:RT=1686089554:S=ALNI_MapX8y5g_uhvDpVgNYgIyDLz3savw");
        Cookie gid = new Cookie("_gid", "GA1.2.673198878.1686163506");
        //Cookie ccid = new Cookie("_cc_id", "f258387d064595b9b382b107e46210e9");

        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(userName);
        //driver.manage().addCookie(gads);
        driver.manage().addCookie(gid);
        //driver.manage().addCookie(ccid);

        driver.navigate().refresh(); // Radim refresh jer bez toga i dalje postoji Log in dugme i driver ne konta da je ulogovan
        WebElement book1 = driver.findElement(By.linkText("Speaking JavaScript"));
        wdwait.until(ExpectedConditions.elementToBeClickable(book1));
        book1.click();

        WebElement addBookBtn = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBookBtn.click();

        driver.navigate().refresh(); // nisam drugacije uspeo da zatvorim modal, probao Keys.ESCAPE, alert().disimss(), alert().accept()...

        WebElement backToStoreBtn = driver.findElement(By.cssSelector(".text-left.fullButton"));
        backToStoreBtn.click();

        WebElement book2 = driver.findElement(By.linkText("Programming JavaScript Applications"));
        wdwait.until(ExpectedConditions.elementToBeClickable(book2));
        book2.click();

        WebElement addBookBtn2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBookBtn2.click();

        driver.navigate().refresh(); // nisam drugacije uspeo da zatvorim modal, probao Keys.ESCAPE, alert().disimss(), alert().accept()...

        WebElement backToStoreBtn2 = driver.findElement(By.cssSelector(".text-left.fullButton"));
        backToStoreBtn2.click();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        //WebElement login = driver.findElement(By.id("login"));
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        login.click();

        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("niksar");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("D3m0qa!!!");

        WebElement login2 = driver.findElement(By.id("login"));
        login2.click();

    }
}
