package regression.PageObject;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.person.Person;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GroupTestPage extends basePage {

    @FindBy(how = How.ID, using = "sample_editable_1_new")
    WebElement addNew;

    @FindBy(how = How.ID, using = "GrouptestName")
    WebElement groupTestName;

    @FindBy(how = How.ID, using = "Price")
    WebElement price;

    @FindBy(how = How.XPATH, using = "//button[@class='btn green']")
    WebElement submitBtn;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Group test Names')]")
    WebElement groupTestList;

    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    BaseProducer baseProducer = fairy.baseProducer();

    public void addGroupTest() {
        addNew.click();
    }

      public void createNewGroupTest() {

        groupTestName.sendKeys(person.getFullName());
        price.sendKeys(String.valueOf(baseProducer.randomBetween(50,300)));
        submitBtn.click();

    }

    public boolean isGroupTestCreated() {
        return groupTestList.isDisplayed();

    }


}
