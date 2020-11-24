package regression.PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends basePage {
    @FindBy(how = How.ID, using = "MobileNumber")
    WebElement userName;
    @FindBy(how = How.ID, using = "Password")
    WebElement Password;
    @FindBy(how = How.CLASS_NAME, using = "chic-button")
    WebElement signInbutton;
    @FindBy(how = How.CSS, using = "div.col-md-6.alert.alert-danger")
    WebElement errorMessage;


    public void login(String username, String password) {

        userName.sendKeys(username);
        Password.sendKeys(password);
        signInbutton.click();

    }

    public boolean isUserInloginPage() {
        return userName.isDisplayed();
    }

    public void isErrorMessageShown() {
        String message = "Oops!Sorry invalid credentials please try again" ;
        String errorMsg = ( errorMessage.getText().replace("\n", "")
                .replace("×", "").trim());

        Assert.assertEquals(message, errorMsg);


    }



}
