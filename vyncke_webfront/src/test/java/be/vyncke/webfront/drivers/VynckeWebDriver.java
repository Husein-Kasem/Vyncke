package be.vyncke.webfront.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VynckeWebDriver {
    static private WebDriver driver = null;

    static public WebDriver getDriver() {
        if ( driver == null){
            // path naar driver moet veranderd worden volgens jouw pc
            System.setProperty("webdriver.gecko.driver", "D:\\workspace\\SE5\\Vyncke\\vyncke_webfront\\geckodriver.exe");
            driver = new FirefoxDriver();
            return driver;
        }
        return driver;
    }
}
