package Domaci.Domaci_06.base;

import Domaci.Domaci_06.pages.HomePage;
import Domaci.Domaci_06.pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest2 {
    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage homePage;
    public ProfilePage profilePage;
    public ExcelReader excelReader;

    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
        excelReader = new ExcelReader("src/test/java/Domaci/Domaci_06/TestDataHeroku.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

}
