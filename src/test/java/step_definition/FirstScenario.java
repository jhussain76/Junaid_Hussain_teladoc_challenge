package step_definition;

import POM.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class FirstScenario {
    HomePage obj = new HomePage();

    @Given("Admin is on the HomePage {string}")
    public void admin_is_on_the_home_page(String link) {
        Driver.getDriver().get(link);
    }
    @When("Admin click on add User module")
    public void admin_click_on_add_user_module() {

        obj.addUserButton.click();
    }
    @When("Admin insert required information to create a user {string} {string} {string} {string}{string}{string}")
    public void admin_insert_required_information_to_create_a_user(String first, String last, String user, String pass, String emaiL, String num) {

    Select select = new Select(obj.roleId);
        obj.firstName.sendKeys(first);
        obj.lastName.sendKeys(last);
        obj.userName.sendKeys(user);
        obj.password.sendKeys(pass);
        obj.companyAAA.click();
        select.selectByVisibleText("Admin");
        obj.email.sendKeys(emaiL);
        obj.number.sendKeys(num);
        obj.save.click();
    }
    @Then("Admin validate the user has been added to the table")
    public void admin_validate_the_user_has_been_added_to_the_table(List<String> expectedList) {
        List<WebElement> allUserData = obj.firstRow;

        List<String> actualDataUI = new ArrayList<>();

        actualDataUI.add(allUserData.get(0).getText());
        actualDataUI.add(allUserData.get(1).getText());
        actualDataUI.add(allUserData.get(2).getText());
        actualDataUI.add(allUserData.get(6).getText());
        actualDataUI.add(allUserData.get(7).getText());

        Assert.assertEquals(actualDataUI, expectedList);
    }
}
