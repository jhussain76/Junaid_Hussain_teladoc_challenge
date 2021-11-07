package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='btn btn-link pull-right']")
    public WebElement addUserButton;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement password;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement companyAAA;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement companyBBB;

    @FindBy(xpath = "//select[@name='RoleId']")
    public WebElement roleId;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    public WebElement number;


    @FindBy(xpath = "//button[@class = 'btn btn-success']")
    public WebElement save;

    @FindBy(xpath = "(//tbody/tr)[1]/td")
    public List<WebElement> firstRow;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> userNames;

    @FindBy(xpath = "//tbody/tr/td[11]/button")
    public List<WebElement> deleteColumn;



    @FindBy(xpath = "//button[@class='btn ng-scope ng-binding btn-primary']")
    public WebElement delete;







}
