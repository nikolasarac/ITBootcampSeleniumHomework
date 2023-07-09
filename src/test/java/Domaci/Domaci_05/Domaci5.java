package Domaci.Domaci_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Domaci5 {
    WebDriver driver;
    WebDriverWait wait;
    String validUsername;
    String validPassword;
    ArrayList<String> naslovi = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        validUsername = "niksar";
        validPassword = "D3m0qa!!!";
        naslovi.add("Git Pocket Guide");
        naslovi.add("Learning JavaScript Design Patterns");
        naslovi.add("Speaking JavaScript");
        naslovi.add("You Don't Know JS");
    }

    @BeforeMethod
    public void beforeEveryTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    public void goToLoginPage() {
        WebElement bookStoreApp = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
        bookStoreApp.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement logInBtn = driver.findElement(By.id("login"));

        Assert.assertTrue(logInBtn.isDisplayed());

        logInBtn.click();

        String expectedURL = "https://demoqa.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    public void logIn() {
        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(validUsername);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);
        WebElement logInBtn = driver.findElement(By.id("login"));
        logInBtn.click();
    }

    public void logOutByDeletingCookies(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    public void addBookToCollection(String naslov) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(naslov)));
        WebElement book = driver.findElement(By.linkText(naslov));
        book.click();

        WebElement addBookBtn = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBookBtn.click();

        driver.navigate().refresh();
    }

    public void goToProfile() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]")));
        WebElement profileBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]"));
        profileBtn.click();
    }

    public void deleteAllBooks(){
        WebElement deleteAllBooks = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button"));
        deleteAllBooks.click();

        WebElement confirmDeleteBtn = driver.findElement(By.id("closeSmallModal-ok"));
        confirmDeleteBtn.click();

        driver.navigate().refresh();
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        goToLoginPage();
        logIn();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        WebElement logOutBtn = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutBtn.isDisplayed());
    }

    @Test(priority = 20)
    public void userCanAddBookToCollection() {
        goToLoginPage();
        logIn();
        addBookToCollection(naslovi.get(0));
        goToProfile();

        logOutByDeletingCookies();

        WebElement logInSideBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        logInSideBtn.click();
        logIn();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(naslovi.get(0))));
        WebElement bookTitle = driver.findElement(By.linkText(naslovi.get(0)));
        String expectedBookTitle = naslovi.get(0);
        Assert.assertEquals(bookTitle.getText(), expectedBookTitle);

        deleteAllBooks();
    }

    @Test(priority = 30)
    public void userCanAddTwoBooks(){
        goToLoginPage();
        logIn();
        for (int i = 0; i < 2; i++) {
            addBookToCollection(naslovi.get(i));
            driver.navigate().back();
        }
        goToProfile();
        logOutByDeletingCookies();

        WebElement logInSideBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        logInSideBtn.click();
        logIn();

        for (int i = 0; i < 2; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(naslovi.get(i))));
            WebElement bookTitle = driver.findElement(By.linkText(naslovi.get(i)));
            String expectedBookTitle = naslovi.get(i);
            Assert.assertEquals(bookTitle.getText(), expectedBookTitle);
        }

        deleteAllBooks();
    }

    @Test(priority = 40)
    public void userCanAddThreeBooks(){
        goToLoginPage();
        logIn();
        for (int i = 0; i < 3; i++) {
            addBookToCollection(naslovi.get(i));
            driver.navigate().back();
        }
        goToProfile();
        logOutByDeletingCookies();

        WebElement logInSideBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        logInSideBtn.click();
        logIn();

        for (int i = 0; i < 3; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(naslovi.get(i))));
            WebElement bookTitle = driver.findElement(By.linkText(naslovi.get(i)));
            String expectedBookTitle = naslovi.get(i);
            Assert.assertEquals(bookTitle.getText(), expectedBookTitle);
        }

        deleteAllBooks();
    }

    @Test(priority = 50)
    public void userCanAddFourBooks(){
        goToLoginPage();
        logIn();
        for (int i = 0; i < 4; i++) {
            addBookToCollection(naslovi.get(i));
            driver.navigate().back();
        }
        goToProfile();
        logOutByDeletingCookies();

        WebElement logInSideBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        logInSideBtn.click();
        logIn();

        for (int i = 0; i < 4; i++) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(naslovi.get(i))));
            WebElement bookTitle = driver.findElement(By.linkText(naslovi.get(i)));
            String expectedBookTitle = naslovi.get(i);
            Assert.assertEquals(bookTitle.getText(), expectedBookTitle);
        }

        // ovde namerno nisam obrisao sve knjige da bi se videlo da su tu 4 komada posle svegih testova

    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
