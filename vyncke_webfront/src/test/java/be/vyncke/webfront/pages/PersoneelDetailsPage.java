package be.vyncke.webfront.pages;

import be.vyncke.webfront.drivers.VynckeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersoneelDetailsPage {

    public PersoneelDetailsPage(){
        PageFactory.initElements(VynckeWebDriver.getDriver(), this);
    }

    public String getBodyText(){
        return VynckeWebDriver.getDriver().findElement(By.tagName("body")).getText();
    }

    @FindBy(how = How.NAME, using = "delete")
    private WebElement deleteButton;

    @FindBy(how = How.NAME, using = "wijzig")
    private WebElement wijzigButton;

    public void clickDeleteButton(){
        deleteButton.click();
    }

    public void clickWijzigButton(){
        wijzigButton.click();
    }

    public boolean waitUntilLoaded (){
        return new WebDriverWait(VynckeWebDriver.getDriver(), 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.id("Details"), "Details"));
    }
}
