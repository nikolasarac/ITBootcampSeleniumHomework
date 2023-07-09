package Domaci.Domaci_08.PagesDemoQA;

import Domaci.Domaci_08.BaseDemoQA.BaseTestDemoQA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BaseTestDemoQA {

    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[3]")
    public WebElement radioButtonMenuItem;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[5]")
    public WebElement buttonsMenuItem;

    //======== METODE ===========
    public void clickOnRadioButtonMenuItem() {
        radioButtonMenuItem.click();
    }

    public void clickOnButtonsMenuItem() {
        buttonsMenuItem.click();
    }
}
