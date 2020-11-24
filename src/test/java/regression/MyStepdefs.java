package regression;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import regression.PageObject.CreateEditUserPage;
import regression.PageObject.GroupTestPage;
import regression.PageObject.LoginPage;
import regression.PageObject.MastersPage;

public class MyStepdefs extends TestRunner {


    public LoginPage loginPage;
    public MastersPage mastersPage;
    public CreateEditUserPage createEditUserPage;
    public GroupTestPage grouptestPage;

    @Before
    public void start() {
        loginPage = new LoginPage();
        mastersPage = new MastersPage();
        createEditUserPage = new CreateEditUserPage();
        grouptestPage = new GroupTestPage();
        driver.get("http://ahs.bananaapps.co.uk/");

    }


    @After
    public void stop(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        }

    }

    @Given("^SuperAdmin logIn$")
    public void superadminLogedIn() {
        loginPage.login("07442382353", "Superadmin");
    }

    @And("^He navigate to Masters screen and select Users$")
    public void heNavigateToMastersScreenAndSelectUsers() {
        mastersPage.gotoUsers();
    }

    @And("^He select Edit from action column$")
    public void heSelectEditFromActionColumn() {
        mastersPage.clickEdit();

    }

    @When("^He updates details and select UserType as \"([^\"]*)\" and click submit\\.$")
    public void heUpdatesDetailsAndSelectUserTypeAsAndClickSubmit(String User) {
        createEditUserPage.editUserDetails(User);
    }

    @Then("^All the updated data should be available for the selected user$")
    public void allTheUpdatedDataShouldBeAvailableForTheSelectedUser() {

        createEditUserPage.isUserEdited();
    }

    @And("^He navigate to Masters screen and select Group Test$")
    public void heNavigateToMastersScreenAndSelectGroupTest() {

        mastersPage.gotoGroupTest();
    }

    @And("^In GroupTestName select AddNew$")
    public void inGroupTestNameSelectAddNew() {
        grouptestPage.addGroupTest();
    }

    @When("^Add group test name and price and click submit$")
    public void addGroupTestNameAndPriceAndClickSubmit() {
        grouptestPage.createNewGroupTest();
    }

    @Then("^Group test created successfully$")
    public void groupTestCreatedSuccessfully() {
        grouptestPage.isGroupTestCreated();
    }

    @And("^He navigate to Add New$")
    public void heNavigateToAddNew() {
        mastersPage.addNewUser();

    }

    @Then("^New user created successfully$")
    public void newUserCreatedSuccessfully() {
        createEditUserPage.isUserCreated();
    }

    @When("^He go to action column and select delete$")
    public void heGoToActionColumnAndSelectDelete()  {

        mastersPage.deleteUser();

    }

    @Then("^user should be deleted successfully$")
    public void userShouldBeDeletedSuccessfully() {
        mastersPage.isUserDeleted();

    }
}
