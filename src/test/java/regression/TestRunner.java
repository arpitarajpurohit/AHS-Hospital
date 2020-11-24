package regression;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}

       ,tags = {"@04"}

)


public class TestRunner {
    static WebDriver driver;

    @BeforeClass
    public static void startBrowser() {
        driver = BrowserFactory.getDriver();

    }

    @AfterClass
    public static void stop() {
        driver.quit();
        driver = null;
    }


}
