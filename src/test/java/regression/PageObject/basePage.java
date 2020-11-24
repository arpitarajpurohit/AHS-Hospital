package regression.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import regression.BrowserFactory;

public class basePage {

    WebDriver driver;

    public basePage() {
        driver = BrowserFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

}



