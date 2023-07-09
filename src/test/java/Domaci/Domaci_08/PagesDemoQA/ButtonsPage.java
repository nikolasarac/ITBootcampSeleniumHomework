package Domaci.Domaci_08.PagesDemoQA;

import Domaci.Domaci_08.BaseDemoQA.BaseTestDemoQA;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ButtonsPage extends BaseTestDemoQA {

    Actions actions = new Actions(driver);
    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")
    public WebElement clickMeButton;

    @FindBy (id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy (id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy (id = "dynamicClickMessage")
    public WebElement clickMeMessage;

    //=========== METODE ============

    public void setMargin(WebElement element) { // Metoda za dodavanje margine elementu (zatrebalo mi da pomerim dugme kako bih izbegao klik na reklamu)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.marginTop ='50px'", element);
    }
    public void doubleClick() {
        actions.doubleClick(doubleClickButton).perform();
    }

    public void rightClick() {
        actions.contextClick(rightClickButton).perform();
    }

    public void clickMe() {
        clickMeButton.click();
    }
}
