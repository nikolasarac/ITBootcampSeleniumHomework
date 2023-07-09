package Domaci.Domaci_08.PagesDemoQA;

import Domaci.Domaci_08.BaseDemoQA.BaseTestDemoQA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTestDemoQA {

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]")
    public WebElement elementsCard;

    //---------------

    public void clickOnElements() {
        elementsCard.click();
    }

}

