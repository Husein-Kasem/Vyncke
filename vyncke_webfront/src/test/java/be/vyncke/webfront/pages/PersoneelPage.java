package be.vyncke.webfront.pages;

import be.vyncke.webfront.drivers.VynckeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersoneelPage {

    public PersoneelPage(){
        PageFactory.initElements(VynckeWebDriver.getDriver(), this);
    }

    @FindBy(how = How.NAME, using = "nieuw")
    private WebElement niewButton;

    public void clickNieuwButton(){
        niewButton.click();
    }

    public String getBodyText(){
        return VynckeWebDriver.getDriver().findElement(By.tagName("body")).getText();
    }

    public void navigateToDetailsOfPersoneel(String personeelName){
        String[] memberName = personeelName.split(" ");
        String mn = memberName[0]+memberName[1];
        VynckeWebDriver.getDriver().findElement(By.className(mn)).click();
    }

    public Boolean waitUntilLoaded(){
        return new WebDriverWait(VynckeWebDriver.getDriver(), 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.id("personeellijst"), "Personeel"));
    }
}
