package step_definition;

import POM.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SecondScenario {
    int found;
    HomePage homePage = new HomePage();
    @When("Admin locating {string} from table")
    public void admin_locating_from_table(String userName) {
        for (int i = 0; i < homePage.userNames.size(); i++) {
            if (homePage.userNames.get(i).getText().contains(userName)) {
                found = i;
                break;
            }
        }
    }
    @When("Admin delete")
    public void admin_delete() {
        homePage.deleteColumn.get(found).click();
        homePage.delete.click();
    }
    @Then("Admin validate {string} has deleted")
    public void admin_validate_has_deleted(String userName) {

        for (WebElement each: homePage.userNames) {
            if(each.getText().contains(userName)){
                System.out.println("The userName " + userName + " was not deleted form the table");
            }
        }
    }
}
