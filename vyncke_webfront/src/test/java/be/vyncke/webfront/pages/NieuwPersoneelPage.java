package be.vyncke.webfront.pages;

import be.vyncke.webfront.drivers.VynckeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NieuwPersoneelPage {

    public NieuwPersoneelPage(){
        PageFactory.initElements(VynckeWebDriver.getDriver(), this);
    }

    @FindBy(how = How.NAME, using = "verkoper")
    private WebElement verkoperButton;

    @FindBy(how = How.NAME, using = "ketelmaker")
    private WebElement ketelmakerButton;

    public void clickVerkoperButton(){
        verkoperButton.click();
    }

    public void clickKetelmakerButton(){
        ketelmakerButton.click();
    }

    public void fillFormFieldByFieldNameAndText(String fieldName, String textToBeFilled){
        VynckeWebDriver.getDriver().findElement(By.id(fieldName)).sendKeys(textToBeFilled);
    }

    public boolean waitUntilLoaded (){
        return new WebDriverWait(VynckeWebDriver.getDriver(), 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("h1"), "Personeel toevoegen"));
    }
}
