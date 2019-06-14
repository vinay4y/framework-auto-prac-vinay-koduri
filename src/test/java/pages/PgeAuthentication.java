package pages;

import common.BrowserDriver;
import common.DataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PgeAuthentication {


    WebDriver objPgeAuthenticationDriver = BrowserDriver.getCurrentDriver();


    public PgeAuthentication(WebDriver objPgeAuthenticationDriver){
        this.objPgeAuthenticationDriver = objPgeAuthenticationDriver;
        //This initElements method will create all WebElements
        PageFactory.initElements(objPgeAuthenticationDriver, this);
    }

    @FindBy(xpath="//input[@id='email_create']")
    public WebElement txtbox_emailAddress;

    @FindBy(xpath="//form[@id='create-account_form']//span[1]")
     public WebElement button_createAnAccount;

    @FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
    public WebElement txt_invalidEmailAddress;

    @FindBy(xpath="//input[@id='customer_firstname']")
    public WebElement txtbox_firstName;

    @FindBy(xpath="//input[@id='customer_lastname']")
    public WebElement txtbox_lastName;

    @FindBy(xpath="//input[@id='email']")
    public WebElement txtbox_Email;

    @FindBy(xpath="//input[@id='passwd']")
    public WebElement txtbox_Password;

    @FindBy(xpath="//input[@id='firstname']")
    public WebElement txtbox_Address_FirstName;

    @FindBy(xpath="//input[@id='lastname']")
    public WebElement txtbox_Address_Lastname;

    @FindBy(xpath="//input[@id='address1']")
    public WebElement txtbox_Address_Address_L1;

    @FindBy(xpath="//input[@id='city']")
    public WebElement txtbox_Address_City;

    @FindBy(xpath="//select[@id='id_state']")
    public WebElement select_Address_State;

    @FindBy(xpath="//input[@id='postcode']")
    public WebElement txtbox_Address_Postcode;

    @FindBy(xpath="//select[@id='id_country']")
    public WebElement select_Address_Country;

    @FindBy(xpath="//input[@id='phone_mobile']")
    public WebElement txtbox_Address_Mobilephone;

    @FindBy(xpath="//input[@id='alias']")
    public WebElement txtbox_Address_Alias;

    @FindBy(xpath="//span[contains(text(),'Register')]")
    public WebElement button_Register;

// This method will input all the mandatory information to create an account
// Test data will be fetched from testData.yml file based on the email address provided

    public void  provideAlltheMandatoryInfo(String email){
       try {
        DataReader dr = new DataReader("src//test//resources//data//testData.yml",email);
        txtbox_firstName.sendKeys(dr.getvalue_ymlfile("Personal_FirstName"));
        txtbox_lastName.sendKeys(dr.getvalue_ymlfile("Personal_LastName"));
        txtbox_Password.sendKeys(dr.getvalue_ymlfile("Personal_Password"));
        txtbox_Address_Address_L1.sendKeys(dr.getvalue_ymlfile("Address_Address_L1"));
        txtbox_Address_City.sendKeys(dr.getvalue_ymlfile("Address_City"));
        Select stateDropdown = new Select(select_Address_State);
        stateDropdown.selectByVisibleText(dr.getvalue_ymlfile("Address_State"));
        txtbox_Address_Postcode.sendKeys(dr.getvalue_ymlfile("Address_Postcode"));
        txtbox_Address_Mobilephone.sendKeys(dr.getvalue_ymlfile("Address_Mobile"));
        txtbox_Address_Alias.clear();
        txtbox_Address_Alias.sendKeys(dr.getvalue_ymlfile("Address_alais"));
       } catch (Exception e) {
           e.printStackTrace();
           throw new Error(e);

       }
    }
}
